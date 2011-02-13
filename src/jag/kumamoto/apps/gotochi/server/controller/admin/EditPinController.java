package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Pin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class EditPinController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Pin p = new Pin();

        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Pin.class, id);
            p = Datastore.get(Pin.class, key);
        }

        requestScope("pin", p);

        return forward("editPin.jsp");
    }
}
