package jag.kumamoto.apps.gotochi.server.service;

import jag.kumamoto.apps.gotochi.server.meta.EventLogMeta;
import jag.kumamoto.apps.gotochi.server.model.EventLog;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;
import jag.kumamoto.apps.gotochi.server.model.User;

import java.util.List;

import org.slim3.datastore.Datastore;

public class EventLogService {

    public EventLog getEventLog(User user, Pin pin, Quiz quiz) {

        EventLogMeta m = EventLogMeta.get();
        EventLog el =
            Datastore
                .query(EventLog.class)
                .filter(m.userRef.equal(user.getKey()))
                .filter(m.pinRef.equal(pin.getKey()))
                .filter(m.quizRef.equal(quiz.getKey()))
                .filter(m.overridden.equal(0))
                .sort(m.time.asc)
                .asSingle();
        return el;

    }

    public EventLog getEventLog(User user, Pin pin) {

        EventLogMeta m = EventLogMeta.get();
        EventLog el =
            Datastore
                .query(EventLog.class)
                .filter(m.userRef.equal(user.getKey()))
                .filter(m.pinRef.equal(pin.getKey()))
                .filter(m.quizRef.equal(null))
                .filter(m.overridden.equal(0))
                .sort(m.time.asc)
                .asSingle();
        return el;

    }

    public List<EventLog> getEventLog(User user) {

        EventLogMeta m = EventLogMeta.get();
        return Datastore
            .query(EventLog.class)
            .filter(m.userRef.equal(user.getKey()))
            .filter(m.overridden.equal(0))
            .filter(m.executed.equal(1))
            .sort(m.time.asc)
            .asList();

    }

    public List<EventLog> getArrivedLog(User user) {

        EventLogMeta m = EventLogMeta.get();
        return Datastore
            .query(EventLog.class)
            .filter(m.userRef.equal(user.getKey()))
            .filter(m.overridden.equal(0))
            .filter(m.executed.equal(1))
            .filter(m.quizRef.equal(null))
            .sort(m.time.asc)
            .asList();

    }
}
