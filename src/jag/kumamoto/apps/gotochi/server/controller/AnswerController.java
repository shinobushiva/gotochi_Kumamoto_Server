package jag.kumamoto.apps.gotochi.server.controller;

import jag.kumamoto.apps.gotochi.server.model.EventLog;
import jag.kumamoto.apps.gotochi.server.model.GotochiUserData;
import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;
import jag.kumamoto.apps.gotochi.server.model.User;
import jag.kumamoto.apps.gotochi.server.service.EventLogService;
import jag.kumamoto.apps.gotochi.server.service.PrizeService;
import jag.kumamoto.apps.gotochi.server.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

//http://localhost:8888/answer?token=test&pinId=4&quizId=105&optionIdArray=160&optionIdArray=161&correctness=1&answeringTime=3000
public class AnswerController extends JsonController {

    private UserService us = new UserService();
    private EventLogService els = new EventLogService();
    private PrizeService ps = new PrizeService();

    @Override
    protected Map<String, Object> handle() throws Exception {

        Value v = new Value();
        BeanUtil.copy(request, v);

        Pin pin =
            Datastore.get(Pin.class, Datastore.createKey(Pin.class, v.pinId));
        Quiz quiz =
            Datastore
                .get(Quiz.class, Datastore.createKey(Quiz.class, v.quizId));
        User user = us.getUser(v.token);

        if (pin != null && quiz != null && user != null) {
            EventLog el = new EventLog();

            EventLog old = els.getEventLog(user, pin, quiz);

            el.setAnsweringTime(v.answeringTime);
            el.setCorrectness(v.correctness);
            el.setPin(pin);
            el.getPinRef().setModel(pin);
            el.setQuiz(quiz);
            el.getQuizRef().setModel(quiz);
            el.setTime(new Date());
            el.getUserRef().setKey(user.getKey());
            el.setOverridden(0);

            List<Key> list = new ArrayList<Key>();
            if (v.optionIdArray != null) {
                for (String id : v.optionIdArray) {
                    list.add(Datastore.createKey(Option.class, Long
                        .parseLong(id)));
                }
            }
            el.setOptions(Datastore.get(Option.class, list));

            if (old != null) {
                old.setOverridden(1);
                GlobalTransaction tx = Datastore.beginGlobalTransaction();
                Datastore.put(old);
                tx.commit();

                el.setExecuted(old.getExecuted());
            }

            GlobalTransaction tx = Datastore.beginGlobalTransaction();
            Datastore.put(el);
            tx.commit();

            if (1 == el.getCorrectness() && 1 != el.getExecuted()) {
                GotochiUserData gud = us.getGotochiData(user);
                if (gud.getPoint() == null) {
                    gud.setPoint(0);
                }
                gud.setPoint(gud.getPoint() + quiz.getPoint());
                el.setExecuted(1); // 執行済みにマーク

                tx = Datastore.beginGlobalTransaction();
                Datastore.put(gud);
                tx.commit();
                // ps.checkPrize(gud, pin, quiz, user); // 受賞チェック
            }

            // XXX:テスト
            ps.checkPrize(us.getGotochiData(user), pin, quiz, user); // 受賞チェック
        }

        Map<String, Object> hm = new HashMap<String, Object>();

        return hm;
    }

    public class Value {
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String[] getOptionIdArray() {
            return optionIdArray;
        }

        public void setOptionIdArray(String[] optionIdArray) {
            this.optionIdArray = optionIdArray;
        }

        public Long getPinId() {
            return pinId;
        }

        public void setPinId(Long pinId) {
            this.pinId = pinId;
        }

        public Long getQuizId() {
            return quizId;
        }

        public void setQuizId(Long quizId) {
            this.quizId = quizId;
        }

        public Long getAnsweringTime() {
            return answeringTime;
        }

        public void setAnsweringTime(Long answeringTime) {
            this.answeringTime = answeringTime;
        }

        public Integer getCorrectness() {
            return correctness;
        }

        public void setCorrectness(Integer correctness) {
            this.correctness = correctness;
        }

        public String token;

        public String[] optionIdArray;

        public Long pinId;

        public Long quizId;

        public Long answeringTime;

        public Integer correctness;

    }

}
