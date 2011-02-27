package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class EditOptionController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Option q = new Option();

        Integer id = asInteger("id");
        Integer quizId = asInteger("quizId");
        if (quizId != null) {
            Key key = Datastore.createKey(Quiz.class, quizId);
            q.setQuizKey(key);
            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            q.setKey(Datastore.put(q));
            tx.commit();

        } else if (id != null) {
            Key key = Datastore.createKey(Option.class, id);
            q = Datastore.get(Option.class, key);
        } else {
            return redirect("pins");
        }

        requestScope("option", q);

        return forward("editOption.jsp");
    }
}
