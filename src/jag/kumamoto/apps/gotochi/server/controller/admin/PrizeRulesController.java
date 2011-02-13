package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.PrizeRule;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class PrizeRulesController extends Controller {

    @Override
    public Navigation run() throws Exception {

        List<PrizeRule> rules = Datastore.query(PrizeRule.class).asList();

        requestScope("prizeRules", rules);

        return forward("prizeRules.jsp");
    }
}
