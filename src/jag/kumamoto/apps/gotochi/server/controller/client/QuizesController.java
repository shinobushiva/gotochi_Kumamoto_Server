package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.meta.QuizMeta;
import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public class QuizesController extends JsonController {

    @Override
    protected Map<String, Object> handle() throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();

        Integer pinId = asInteger("pinId");
        Key key = Datastore.createKey(Pin.class, pinId);

        List<Quiz> quizes =
            Datastore
                .query(Quiz.class)
                .filter(QuizMeta.get().pinKey.equal(key))
                .asList();

        List<jag.kumamoto.apps.gotochi.server.vo.Quiz> nl =
            new ArrayList<jag.kumamoto.apps.gotochi.server.vo.Quiz>();

        for (Quiz quiz : quizes) {
            jag.kumamoto.apps.gotochi.server.vo.Quiz qvo =
                new jag.kumamoto.apps.gotochi.server.vo.Quiz();

            BeanUtil.copy(quiz, qvo);

            List<Option> list =
                Datastore.get(Option.class, quiz.getOptionKeys());
            qvo.setOptions(list);

            nl.add(qvo);
        }

        map.put("quizes", nl);
        map.put("success", "true");

        return map;
    }
}
