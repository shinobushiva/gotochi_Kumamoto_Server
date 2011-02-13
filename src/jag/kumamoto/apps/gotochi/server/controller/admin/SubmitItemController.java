package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Item;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public class SubmitItemController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Item p = new Item();
        BeanUtil.copy(request, p);

        Item p2 = null;
        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Item.class, id);
            p2 = Datastore.get(Item.class, key);

            p.setKey(p2.getKey());
        }

        GlobalTransaction tx = Datastore.beginGlobalTransaction();
        Datastore.put(p);
        tx.commit();

        return redirect("items");
    }
}
