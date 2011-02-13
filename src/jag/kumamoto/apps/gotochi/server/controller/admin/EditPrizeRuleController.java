package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.PrizeRule;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class EditPrizeRuleController extends Controller {

    @Override
    public Navigation run() throws Exception {

        PrizeRule p = new PrizeRule();

        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(PrizeRule.class, id);
            p = Datastore.get(PrizeRule.class, key);
        }

        requestScope("prizeRule", p);

        return forward("editPrizeRule.jsp");
    }
}
