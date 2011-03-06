package jag.kumamoto.apps.gotochi.server.service;

import jag.kumamoto.apps.gotochi.server.meta.GotochiUserDataMeta;
import jag.kumamoto.apps.gotochi.server.meta.UserAuthMeta;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.model.UserAuth;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

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

    /**
     * ユーザを登録します
     * 
     * @param token
     * @param nickname
     * @param gender
     * @return 更新時はtrue, 新規登録はfalse
     */
    public boolean registrate(String token, String nickname, Integer gender) {
        UserAuth ua =
            Datastore.query(UserAuth.class).filter(
                UserAuthMeta.get().token.equal(token)).asSingle();
        User u = null;
        GotochiUserData gud = null;

        boolean isUpdated = false;

        if (ua == null) {
            isUpdated = false;
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
            isUpdated = true;
            Key userKey = ua.getUserKey();

            u = Datastore.get(User.class, userKey);
            u.setGender(gender);
            u.setNickName(nickname);
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.put(u);

            tx.commit();
        }
        return isUpdated;
    }

}
