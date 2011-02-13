package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.meta.QuizMeta;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class QuizesController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Integer pinId = asInteger("pinId");
        if (pinId != null) {
            Key key = Datastore.createKey(Pin.class, pinId);

            List<Quiz> quizes =
                Datastore.query(Quiz.class).filter(
                    QuizMeta.get().pinKey.equal(key)).asList();
            requestScope("pinId", pinId);
            requestScope("quizes", quizes);

        } else {
            return redirect("pins");
        }

        return forward("quizes.jsp");
    }
}
