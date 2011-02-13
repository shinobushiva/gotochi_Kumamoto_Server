package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.model.Quiz;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public class SubmitQuizController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Quiz p = new Quiz();
        BeanUtil.copy(request, p);

        Quiz p2 = null;
        Integer id = asInteger("id");
        if (id != null) {
            Key key = Datastore.createKey(Quiz.class, id);
            p2 = Datastore.get(Quiz.class, key);
        } else {
            return redirect("pins");
        }

        p.setKey(p2.getKey());
        p.setOptionKeys(p2.getOptionKeys());
        p.setPinKey(p2.getPinKey());
        requestScope("pinId", p2.getPinKey().getId());

        GlobalTransaction tx = Datastore.beginGlobalTransaction();
        Datastore.put(p);
        tx.commit();

        return forward("quizes");
    }
}
