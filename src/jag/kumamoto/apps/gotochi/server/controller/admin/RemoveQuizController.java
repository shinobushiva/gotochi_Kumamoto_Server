package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Quiz;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class RemoveQuizController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Quiz.class, id);
            Quiz q = Datastore.get(Quiz.class, key);

            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.delete(key);
            tx.commit();

            requestScope("pinId", q.getPinKey().getId());
        } else {
            return redirect("pins");
        }
        return forward("quizes");

    }
}
