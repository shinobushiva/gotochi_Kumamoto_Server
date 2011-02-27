package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.meta.GotochiUserDataMeta;
import jag.kumamoto.apps.gotochi.server.meta.UserAuthMeta;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.model.UserAuth;

import java.util.HashMap;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;

//http://localhost:8888/registration?token=test&gender=0&nickname=shiva
public class UserController extends JsonController {

    @Override
    protected Map<String, Object> handle() throws Exception {

        Map<String, Object> hm = new HashMap<String, Object>();

        String token = asString("token");
        if (token == null) {
            hm.put("success", "false");
            return hm;
        }

        UserAuth ua =
            Datastore.query(UserAuth.class).filter(
                UserAuthMeta.get().token.equal(token)).asSingle();
        User u = null;
        GotochiUserData gud = null;

        if (ua != null) {
            u = Datastore.get(User.class, ua.getUserKey());

            gud =
                Datastore
                    .query(GotochiUserData.class)
                    .filter(
                        GotochiUserDataMeta.get().userKey
                            .equal(ua.getUserKey()))
                    .asSingle();

            hm.put("user", u);
            hm.put("gotochiData", gud);
            hm.put("success", "true");
        } else {
            hm.put("success", "false");
            return hm;
        }

        return hm;

    }
}
