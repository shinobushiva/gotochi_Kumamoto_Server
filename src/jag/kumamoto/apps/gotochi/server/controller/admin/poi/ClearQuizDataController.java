package jag.kumamoto.apps.gotochi.server.controller.admin.poi;

import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class ClearQuizDataController extends Controller {

    @Override
    public Navigation run() throws Exception {

        List<Key> pins = Datastore.query(Pin.class).asKeyList();
        for (Key key : pins) {
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.delete(key);
            tx.commit();
        }
        List<Key> quizes = Datastore.query(Quiz.class).asKeyList();
        for (Key key : quizes) {
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.delete(key);
            tx.commit();

        }
        List<Key> options = Datastore.query(Option.class).asKeyList();
        for (Key key : options) {
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.delete(key);
            tx.commit();
        }

        return redirect("index");
    }

}
