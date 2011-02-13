package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Item;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class RemoveItemController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Item.class, id);

            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.delete(key);
            tx.commit();

        } else {
            return redirect("items");
        }
        return redirect("items");

    }
}
