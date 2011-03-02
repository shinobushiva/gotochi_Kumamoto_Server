package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-03-01 17:56:54")
/** */
public final class OptionMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.Option> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, java.lang.Integer> correctness = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, java.lang.Integer>(this, "correctness", "correctness", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, com.google.appengine.api.datastore.Key> quizKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, com.google.appengine.api.datastore.Key>(this, "quizKey", "quizKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option> text = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option>(this, "text", "text");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, java.lang.Integer> type = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, java.lang.Integer>(this, "type", "type", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Option, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final OptionMeta slim3_singleton = new OptionMeta();

    /**
     * @return the singleton
     */
    public static OptionMeta get() {
       return slim3_singleton;
    }

    /** */
    public OptionMeta() {
        super("Option", jag.kumamoto.apps.gotochi.server.model.Option.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Option entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.Option model = new jag.kumamoto.apps.gotochi.server.model.Option();
        model.setCorrectness(longToInteger((java.lang.Long) entity.getProperty("correctness")));
        model.setKey(entity.getKey());
        model.setQuizKey((com.google.appengine.api.datastore.Key) entity.getProperty("quizKey"));
        model.setText((java.lang.String) entity.getProperty("text"));
        model.setType(longToInteger((java.lang.Long) entity.getProperty("type")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.Option m = (jag.kumamoto.apps.gotochi.server.model.Option) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("correctness", m.getCorrectness());
        entity.setProperty("quizKey", m.getQuizKey());
        entity.setProperty("text", m.getText());
        entity.setProperty("type", m.getType());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Option m = (jag.kumamoto.apps.gotochi.server.model.Option) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.Option m = (jag.kumamoto.apps.gotochi.server.model.Option) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Option m = (jag.kumamoto.apps.gotochi.server.model.Option) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Option m = (jag.kumamoto.apps.gotochi.server.model.Option) model;
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
        jag.kumamoto.apps.gotochi.server.model.Option m = (jag.kumamoto.apps.gotochi.server.model.Option) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getCorrectness() != null){
            writer.setNextPropertyName("correctness");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getCorrectness());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getQuizKey() != null){
            writer.setNextPropertyName("quizKey");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getQuizKey());
        }
        if(m.getText() != null){
            writer.setNextPropertyName("text");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getText());
        }
        if(m.getType() != null){
            writer.setNextPropertyName("type");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getType());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Option jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.Option m = new jag.kumamoto.apps.gotochi.server.model.Option();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("correctness");
        decoder = new org.slim3.datastore.json.Default();
        m.setCorrectness(decoder.decode(reader, m.getCorrectness()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("quizKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setQuizKey(decoder.decode(reader, m.getQuizKey()));
        reader = rootReader.newObjectReader("text");
        decoder = new org.slim3.datastore.json.Default();
        m.setText(decoder.decode(reader, m.getText()));
        reader = rootReader.newObjectReader("type");
        decoder = new org.slim3.datastore.json.Default();
        m.setType(decoder.decode(reader, m.getType()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}