package jag.kumamoto.apps.gotochi.server.controller.admin;

import java.util.UUID;

import jag.kumamoto.apps.gotochi.server.model.ClientAuth;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

public class NewAuthorizedClientController extends Controller {

    @Override
    public Navigation run() throws Exception {

        ClientAuth ca = new ClientAuth();
        ca.setAuthToken(UUID.randomUUID().toString());
        ca.setName("Your Client Name");

        GlobalTransaction tx = Datastore.beginGlobalTransaction();
        Datastore.put(ca);
        tx.commit();

        return null;
    }
}
