package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Item;
import jag.kumamoto.apps.gotochi.server.model.PrizeRule;

import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public class SubmitPrizeRuleController extends Controller {

    @Override
    public Navigation run() throws Exception {

        PrizeRule p = new PrizeRule();
        BeanUtil.copy(request, p);

        PrizeRule p2 = null;
        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(PrizeRule.class, id);
            p2 = Datastore.get(PrizeRule.class, key);

            p.setKey(p2.getKey());
        }
        p.setIssuedTime(new Date());

        Integer itemId = asInteger("itemId");
        p.setItemKey(Datastore.createKey(Item.class, itemId));

        GlobalTransaction tx = Datastore.beginGlobalTransaction();
        Datastore.put(p);
        tx.commit();

        return redirect("prizeRules");
    }
}
