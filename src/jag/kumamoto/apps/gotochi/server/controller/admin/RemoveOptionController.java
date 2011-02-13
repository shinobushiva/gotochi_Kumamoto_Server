package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class RemoveOptionController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Option.class, id);
            Option option = Datastore.get(Option.class, key);

            Quiz quiz = Datastore.get(Quiz.class, option.getQuizKey());
            quiz.getOptionKeys().remove(option.getKey());

            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.delete(key);
            tx.commit();
            tx = Datastore.beginGlobalTransaction();
            Datastore.delete(option.getKey());
            tx.commit();

            requestScope("quizId", option.getQuizKey().getId());
        } else {
            return redirect("pins");
        }
        return forward("options");

    }
}
