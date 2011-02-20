package jag.kumamoto.apps.gotochi.server.controller.client;

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

        UserAuth ua =
            Datastore.query(UserAuth.class).filter(
                UserAuthMeta.get().token.equal(token)).asSingle();
        User u = null;
        GotochiUserData gud = null;

        if (ua == null) {
            u = new User();
            Key userKey = Datastore.allocateId(User.class);
            u.setKey(userKey);
            u.setGender(gender);
            u.setNickName(nickname);

            ua = new UserAuth();
            Key uaKey = Datastore.allocateId(userKey, UserAuth.class);
            ua.setKey(uaKey);
            ua.setUserKey(u.getKey());

            gud = new GotochiUserData();
            Key gudKey =
                Datastore.allocateId(u.getKey(), GotochiUserData.class);
            gud.setKey(gudKey);
            gud.setPoint(0);

            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.put(u);

            ua.setToken(token);
            Datastore.put(ua);

            gud.setUserKey(u.getKey());
            Datastore.put(gud);

            tx.commit();

        } else {
            Key userKey = ua.getUserKey();

            u = Datastore.get(User.class, userKey);
            u.setGender(gender);
            u.setNickName(nickname);
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.put(u);

            tx.commit();
        }

        hm.put("success", "true");
        return hm;

    }
}
