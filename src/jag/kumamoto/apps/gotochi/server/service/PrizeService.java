package jag.kumamoto.apps.gotochi.server.service;

import jag.kumamoto.apps.gotochi.server.meta.PrizeMeta;
import jag.kumamoto.apps.gotochi.server.meta.ReceivedPrizeRulesMeta;
import jag.kumamoto.apps.gotochi.server.model.EventLog;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.Item;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Prize;
import jag.kumamoto.apps.gotochi.server.model.PrizeRule;
import jag.kumamoto.apps.gotochi.server.model.Quiz;
import jag.kumamoto.apps.gotochi.server.model.ReceivedPrizeRules;
import jag.kumamoto.apps.gotochi.server.model.User;

import java.util.Date;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class PrizeService {

    private EventLogService els = new EventLogService();

    public void checkPrize(GotochiUserData gud, Pin pin, Quiz quiz, User user) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        engine.put("userdata", gud);
        engine.put("pin", pin);
        engine.put("quiz", quiz);
        engine.put("user", user);
        List<EventLog> logs = els.getEventLog(user);
        engine.put("logs", logs);

        ReceivedPrizeRules rpr =
            Datastore
                .query(ReceivedPrizeRules.class)
                .filter(
                    ReceivedPrizeRulesMeta.get().userKey.equal(user.getKey()))
                .asSingle();
        if (rpr == null) {
            rpr = new ReceivedPrizeRules();
            Key rprKey =
                Datastore.allocateId(user.getKey(), ReceivedPrizeRules.class);
            rpr.setKey(rprKey);
            rpr.setUserKey(user.getKey());
        }

        List<PrizeRule> rules = Datastore.query(PrizeRule.class).asList();
        for (PrizeRule prizeRule : rules) {
            if (rpr.getPrizeRuleKeys().contains(prizeRule.getKey())) {
                continue;
            }

            try {
                Object eval = engine.eval("(" + prizeRule.getScript() + ")();");
                if (Boolean.TRUE.equals(eval)) {
                    Prize p = new Prize();
                    p.setIssuedTime(new Date());
                    p
                        .setItem(Datastore.get(Item.class, prizeRule
                            .getItemKey()));
                    p.setMessage(prizeRule.getMessage());
                    p.setTitle(prizeRule.getTitle());
                    p.setUserKey(user.getKey());

                    GlobalTransaction tx = Datastore.beginGlobalTransaction();
                    Datastore.put(p);
                    tx.commit();

                    rpr.getPrizeRuleKeys().add(prizeRule.getKey());
                }

            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Datastore.put(rpr);
        gtx.commit();

    }

    public List<Prize> listPrizes(User u) {
        return Datastore.query(Prize.class).filter(
            PrizeMeta.get().userKey.equal(u.getKey())).sort(
            PrizeMeta.get().issuedTime.asc).asList();
    }
}
