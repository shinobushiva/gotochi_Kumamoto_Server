package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.model.EventLog;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.service.EventLogService;
import jag.kumamoto.apps.gotochi.server.service.PrizeService;
import jag.kumamoto.apps.gotochi.server.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

//http://localhost:8888/arrive?token=test&pinId=4
public class ArriveController extends JsonController {

    private UserService us = new UserService();
    private EventLogService els = new EventLogService();
    private PrizeService ps = new PrizeService();

    @Override
    protected Map<String, Object> handle() throws Exception {

        Value v = new Value();
        BeanUtil.copy(request, v);

        Pin pin =
            Datastore.get(Pin.class, Datastore.createKey(Pin.class, v.pinId));
        User user = us.getUser(v.token);

        if (pin != null && user != null) {
            EventLog el = new EventLog();

            EventLog old = els.getEventLog(user, pin);

            el.setPin(pin);
            el.getPinRef().setModel(pin);
            el.getUserRef().setKey(user.getKey());
            el.setTime(new Date());
            el.setOverridden(0);

            if (old != null) {
                old.setOverridden(1);
                GlobalTransaction tx = Datastore.beginGlobalTransaction();
                Datastore.put(old);
                tx.commit();

                el.setExecuted(old.getExecuted());
            }

            // System.out.println("el? : " + el);
            // System.out.println("el? : " + el.getCorrectness());
            // System.out.println("el? : " + el.getExecuted());
            if (el.getExecuted() != null && 1 != el.getExecuted()) {
                GotochiUserData gud = us.getGotochiData(user);

                if (gud.getPoint() == null) {
                    gud.setPoint(0);
                }

                gud.setPoint(gud.getPoint() + pin.getPoint());
                el.setExecuted(1); // 執行済みにマーク

                GlobalTransaction tx = Datastore.beginGlobalTransaction();
                Datastore.put(gud);
                tx.commit();

                ps.checkPrize(gud, pin, null, user); // 受賞チェック
            }

            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.put(el);
            tx.commit();
        }

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("success", "true");

        return hm;
    }

    public class Value {
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Long getPinId() {
            return pinId;
        }

        public void setPinId(Long pinId) {
            this.pinId = pinId;
        }

        public String token;

        public Long pinId;

    }

}
