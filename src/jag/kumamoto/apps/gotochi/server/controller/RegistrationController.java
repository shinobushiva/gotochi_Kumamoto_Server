package jag.kumamoto.apps.gotochi.server.controller;

import jag.kumamoto.apps.gotochi.server.meta.UserAuthMeta;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.model.UserAuth;

import java.util.HashMap;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

//http://localhost:8888/registration?token=test&gender=0&nickname=shiva
public class RegistrationController extends JsonController {

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

        // XXX:仮にE-mail
        UserAuth ua =
            Datastore.query(UserAuth.class).filter(
                UserAuthMeta.get().token.equal(token)).asSingle();
        if (ua == null) {
            User u = new User();
            u.setGender(gender);
            u.setNickName(nickname);
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Key userKey = Datastore.put(u);

            ua = new UserAuth();
            ua.setToken(token);
            ua.setUserKey(userKey);

            Key uaKey = Datastore.allocateId(userKey, UserAuth.class);
            ua.setKey(uaKey);
            Datastore.put(ua);

            GotochiUserData gud = new GotochiUserData();
            gud.setUserKey(userKey);
            Key gudKey = Datastore.allocateId(userKey, GotochiUserData.class);
            gud.setKey(gudKey);
            gud.setPoint(0);
            Datastore.put(gud);

            tx.commit();
            hm.put("success", "true");
            return hm;
        }

        hm.put("success", "false");
        return hm;
    }

}
