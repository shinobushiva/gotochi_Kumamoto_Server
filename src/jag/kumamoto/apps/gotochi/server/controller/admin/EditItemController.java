package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Item;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class EditItemController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Item p = new Item();

        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Item.class, id);
            p = Datastore.get(Item.class, key);
        }

        requestScope("item", p);

        return forward("editItem.jsp");
    }
}
