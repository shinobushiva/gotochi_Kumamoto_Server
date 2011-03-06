package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.service.UserService;

import java.util.HashMap;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

//http://localhost:8888/registration?token=test&gender=0&nickname=shiva
public class RegistrationController extends JsonController {

    private UserService us = new UserService();

    @Override
    protected Map<String, Object> handle() throws Exception {

        Map<String, Object> hm = new HashMap<String, Object>();

        String token = asString("token");
        if (token == null) {
            hm.put("success", "false");
            return hm;
        }
        String nickname = asString("nickname");
        Integer gender = asInteger("gender");

        boolean registrate = us.registrate(token, nickname, gender);

        hm.put("success", "true");
        hm.put("updated", registrate);
        return hm;

    }

}
