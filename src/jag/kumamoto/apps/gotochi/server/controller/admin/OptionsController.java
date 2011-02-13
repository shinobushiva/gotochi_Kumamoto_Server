package jag.kumamoto.apps.gotochi.server.controller.admin;

import jag.kumamoto.apps.gotochi.server.meta.OptionMeta;
import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class OptionsController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Integer quizId = asInteger("quizId");
        if (quizId != null) {
            Key key = Datastore.createKey(Quiz.class, quizId);

            List<Option> quizes =
                Datastore.query(Option.class).filter(
                    OptionMeta.get().quizKey.equal(key)).asList();
            requestScope("quizId", quizId);
            requestScope("options", quizes);

        } else {
            return redirect("pins");
        }

        return forward("options.jsp");
    }
}
