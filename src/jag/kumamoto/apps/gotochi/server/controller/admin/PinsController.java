package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Pin;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class PinsController extends Controller {

    @Override
    public Navigation run() throws Exception {

        List<Pin> pins = Datastore.query(Pin.class).asList();

        requestScope("pins", pins);

        return forward("pins.jsp");
    }
}
