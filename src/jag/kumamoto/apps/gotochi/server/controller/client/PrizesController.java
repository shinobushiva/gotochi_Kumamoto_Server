package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.model.Prize;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.service.PrizeService;
import jag.kumamoto.apps.gotochi.server.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

//http://localhost:8888/arrive?token=test&pinId=4
public class PrizesController extends JsonController {

    private UserService us = new UserService();
    private PrizeService ps = new PrizeService();

    @Override
    protected Map<String, Object> handle() throws Exception {

        String token = asString("token");

        User user = us.getUser(token);
        List<Prize> prs = ps.listPrizes(user);

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("prizes", prs);
        hm.put("success", "true");

        return hm;
    }

}
