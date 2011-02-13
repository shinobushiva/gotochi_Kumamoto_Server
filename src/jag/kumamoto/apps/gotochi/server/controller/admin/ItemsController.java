package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Item;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ItemsController extends Controller {

    @Override
    public Navigation run() throws Exception {

        List<Item> items = Datastore.query(Item.class).asList();

        requestScope("items", items);

        return forward("items.jsp");
    }
}
