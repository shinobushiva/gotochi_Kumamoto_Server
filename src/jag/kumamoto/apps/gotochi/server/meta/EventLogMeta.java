package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-03-06 21:36:16")
/** */
public final class EventLogMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.EventLog> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Long> answeringTime = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Long>(this, "answeringTime", "answeringTime", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Integer> correctness = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Integer>(this, "correctness", "correctness", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Integer> executed = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Integer>(this, "executed", "executed", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Integer> overridden = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Integer>(this, "overridden", "overridden", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, jag.kumamoto.apps.gotochi.server.model.Pin> pin = new org.slim3.datastore.UnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, jag.kumamoto.apps.gotochi.server.model.Pin>(this, "pin", "pin", jag.kumamoto.apps.gotochi.server.model.Pin.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, com.google.appengine.api.datastore.Key> pinKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, com.google.appengine.api.datastore.Key>(this, "pinKey", "pinKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, jag.kumamoto.apps.gotochi.server.model.Quiz> quiz = new org.slim3.datastore.UnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, jag.kumamoto.apps.gotochi.server.model.Quiz>(this, "quiz", "quiz", jag.kumamoto.apps.gotochi.server.model.Quiz.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, com.google.appengine.api.datastore.Key> quizKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, com.google.appengine.api.datastore.Key>(this, "quizKey", "quizKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.util.Date> time = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.util.Date>(this, "time", "time", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, org.slim3.datastore.ModelRef<jag.kumamoto.apps.gotochi.server.model.User>, jag.kumamoto.apps.gotochi.server.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, org.slim3.datastore.ModelRef<jag.kumamoto.apps.gotochi.server.model.User>, jag.kumamoto.apps.gotochi.server.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, jag.kumamoto.apps.gotochi.server.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.EventLog, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final EventLogMeta slim3_singleton = new EventLogMeta();

    /**
     * @return the singleton
     */
    public static EventLogMeta get() {
       return slim3_singleton;
    }

    /** */
    public EventLogMeta() {
        super("EventLog", jag.kumamoto.apps.gotochi.server.model.EventLog.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.EventLog entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.EventLog model = new jag.kumamoto.apps.gotochi.server.model.EventLog();
        model.setAnsweringTime((java.lang.Long) entity.getProperty("answeringTime"));
        model.setCorrectness(longToInteger((java.lang.Long) entity.getProperty("correctness")));
        model.setExecuted(longToInteger((java.lang.Long) entity.getProperty("executed")));
        model.setKey(entity.getKey());
        java.util.List<jag.kumamoto.apps.gotochi.server.model.Option> _options = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("options"));
        model.setOptions(_options);
        model.setOverridden(longToInteger((java.lang.Long) entity.getProperty("overridden")));
        jag.kumamoto.apps.gotochi.server.model.Pin _pin = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("pin"));
        model.setPin(_pin);
        model.setPinKey((com.google.appengine.api.datastore.Key) entity.getProperty("pinKey"));
        jag.kumamoto.apps.gotochi.server.model.Quiz _quiz = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("quiz"));
        model.setQuiz(_quiz);
        model.setQuizKey((com.google.appengine.api.datastore.Key) entity.getProperty("quizKey"));
        model.setTime((java.util.Date) entity.getProperty("time"));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("answeringTime", m.getAnsweringTime());
        entity.setProperty("correctness", m.getCorrectness());
        entity.setProperty("executed", m.getExecuted());
        entity.setUnindexedProperty("options", serializableToBlob(m.getOptions()));
        entity.setProperty("overridden", m.getOverridden());
        entity.setUnindexedProperty("pin", serializableToBlob(m.getPin()));
        entity.setProperty("pinKey", m.getPinKey());
        entity.setUnindexedProperty("quiz", serializableToBlob(m.getQuiz()));
        entity.setProperty("quizKey", m.getQuizKey());
        entity.setProperty("time", m.getTime());
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = (jag.kumamoto.apps.gotochi.server.model.EventLog) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getAnsweringTime() != null){
            writer.setNextPropertyName("answeringTime");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getAnsweringTime());
        }
        if(m.getCorrectness() != null){
            writer.setNextPropertyName("correctness");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getCorrectness());
        }
        if(m.getExecuted() != null){
            writer.setNextPropertyName("executed");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getExecuted());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getOptions() != null){
            writer.setNextPropertyName("options");
            encoder = new org.slim3.datastore.json.Default();
            // jag.kumamoto.apps.gotochi.server.model.Option is not supported.
        }
        if(m.getOverridden() != null){
            writer.setNextPropertyName("overridden");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getOverridden());
        }
        // jag.kumamoto.apps.gotochi.server.model.Pin is not supported.
        if(m.getPinKey() != null){
            writer.setNextPropertyName("pinKey");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPinKey());
        }
        // jag.kumamoto.apps.gotochi.server.model.Quiz is not supported.
        if(m.getQuizKey() != null){
            writer.setNextPropertyName("quizKey");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getQuizKey());
        }
        if(m.getTime() != null){
            writer.setNextPropertyName("time");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getTime());
        }
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getUserRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.EventLog jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.EventLog m = new jag.kumamoto.apps.gotochi.server.model.EventLog();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("answeringTime");
        decoder = new org.slim3.datastore.json.Default();
        m.setAnsweringTime(decoder.decode(reader, m.getAnsweringTime()));
        reader = rootReader.newObjectReader("correctness");
        decoder = new org.slim3.datastore.json.Default();
        m.setCorrectness(decoder.decode(reader, m.getCorrectness()));
        reader = rootReader.newObjectReader("executed");
        decoder = new org.slim3.datastore.json.Default();
        m.setExecuted(decoder.decode(reader, m.getExecuted()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("options");
        decoder = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("overridden");
        decoder = new org.slim3.datastore.json.Default();
        m.setOverridden(decoder.decode(reader, m.getOverridden()));
        // jag.kumamoto.apps.gotochi.server.model.Pin is not supported.
        reader = rootReader.newObjectReader("pinKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setPinKey(decoder.decode(reader, m.getPinKey()));
        // jag.kumamoto.apps.gotochi.server.model.Quiz is not supported.
        reader = rootReader.newObjectReader("quizKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setQuizKey(decoder.decode(reader, m.getQuizKey()));
        reader = rootReader.newObjectReader("time");
        decoder = new org.slim3.datastore.json.Default();
        m.setTime(decoder.decode(reader, m.getTime()));
        reader = rootReader.newObjectReader("userRef");
        decoder = new org.slim3.datastore.json.Default();
        decoder.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}