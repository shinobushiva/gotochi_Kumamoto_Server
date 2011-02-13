package jag.kumamoto.apps.gotochi.server.service;

import jag.kumamoto.apps.gotochi.server.meta.GotochiUserDataMeta;
import jag.kumamoto.apps.gotochi.server.meta.UserAuthMeta;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.model.UserAuth;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class UserService {

    public User getUser(String token) {
        UserAuth ua =
            Datastore.query(UserAuth.class).filter(
                UserAuthMeta.get().token.equal(token)).asSingle();
        if (ua == null) {
            return null;
        }
        return Datastore.get(User.class, ua.getUserKey());
    }

    public GotochiUserData getGotochiData(User u) {
        return getGotochiData(u.getKey());
    }

    public GotochiUserData getGotochiData(Key u) {
        GotochiUserData gud =
            Datastore.query(GotochiUserData.class).filter(
                GotochiUserDataMeta.get().userKey.equal(u)).asSingle();
        return gud;
    }

}
