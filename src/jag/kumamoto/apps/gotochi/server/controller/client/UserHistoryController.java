package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.meta.UserAuthMeta;
import jag.kumamoto.apps.gotochi.server.model.EventLog;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.model.UserAuth;
import jag.kumamoto.apps.gotochi.server.service.EventLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;

public class UserHistoryController extends JsonController {

    EventLogService els = new EventLogService();

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

        if (ua != null) {
            u = Datastore.get(User.class, ua.getUserKey());

            System.out.println(u);

            String pinsOnly = asString("pinsOnly");

            List<EventLog> arrivedLog = null;
            if ("true".equals(pinsOnly)) {
                arrivedLog = els.getArrivedLog(u);
            } else {
                arrivedLog = els.getEventLog(u);
            }

            hm.put("history", arrivedLog);
            hm.put("success", "true");
        } else {
            hm.put("success", "false");
            return hm;
        }

        return hm;

    }
}
