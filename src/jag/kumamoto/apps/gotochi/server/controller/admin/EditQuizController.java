package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class EditQuizController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Quiz q = new Quiz();

        Integer id = asInteger("id");
        Integer pinId = asInteger("pinId");
        if (pinId != null) {
            Key key = Datastore.createKey(Pin.class, pinId);
            q.setPinKey(key);
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            q.setKey(Datastore.put(q));
            tx.commit();

        } else if (id != null) {
            Key key = Datastore.createKey(Quiz.class, id);
            q = Datastore.get(Quiz.class, key);
        } else {
            return redirect("pins");
        }

        requestScope("quiz", q);

        return forward("editQuiz.jsp");
    }
}
