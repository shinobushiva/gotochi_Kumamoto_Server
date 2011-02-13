package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public class SubmitOptionController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Option p = new Option();
        BeanUtil.copy(request, p);

        Option p2 = null;
        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Option.class, id);
            p2 = Datastore.get(Option.class, key);

        } else {
            return redirect("pins");
        }

        p.setKey(p2.getKey());
        p.setQuizKey(p2.getQuizKey());
        requestScope("quizId", p2.getQuizKey().getId());

        Quiz quiz = Datastore.get(Quiz.class, p.getQuizKey());
        quiz.getOptionKeys().add(p.getKey());

        GlobalTransaction tx = Datastore.beginGlobalTransaction();
        Datastore.put(p);
        tx.commit();

        tx = Datastore.beginGlobalTransaction();
        Datastore.put(quiz);
        tx.commit();

        return forward("options");
    }
}
