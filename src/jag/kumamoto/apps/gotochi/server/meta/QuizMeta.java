package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-27 19:12:02")
/** */
public final class QuizMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.Quiz> {

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz> html = new org.slim3.datastore.StringUnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz>(this, "html", "html");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.util.List<com.google.appengine.api.datastore.Key>, com.google.appengine.api.datastore.Key> optionKeys = new org.slim3.datastore.CollectionAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.util.List<com.google.appengine.api.datastore.Key>, com.google.appengine.api.datastore.Key>(this, "optionKeys", "optionKeys", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.lang.Integer> order = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.lang.Integer>(this, "order", "order", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, com.google.appengine.api.datastore.Key> pinKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, com.google.appengine.api.datastore.Key>(this, "pinKey", "pinKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.lang.Integer> point = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.lang.Integer>(this, "point", "point", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz> title = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Quiz, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final QuizMeta slim3_singleton = new QuizMeta();

    /**
     * @return the singleton
     */
    public static QuizMeta get() {
       return slim3_singleton;
    }

    /** */
    public QuizMeta() {
        super("Quiz", jag.kumamoto.apps.gotochi.server.model.Quiz.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Quiz entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.Quiz model = new jag.kumamoto.apps.gotochi.server.model.Quiz();
        model.setHtml(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("html")));
        model.setKey(entity.getKey());
        model.setOptionKeys(toList(com.google.appengine.api.datastore.Key.class, entity.getProperty("optionKeys")));
        model.setOrder(longToInteger((java.lang.Long) entity.getProperty("order")));
        model.setPinKey((com.google.appengine.api.datastore.Key) entity.getProperty("pinKey"));
        model.setPoint(longToInteger((java.lang.Long) entity.getProperty("point")));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.Quiz m = (jag.kumamoto.apps.gotochi.server.model.Quiz) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("html", stringToText(m.getHtml()));
        entity.setProperty("optionKeys", m.getOptionKeys());
        entity.setProperty("order", m.getOrder());
        entity.setProperty("pinKey", m.getPinKey());
        entity.setProperty("point", m.getPoint());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Quiz m = (jag.kumamoto.apps.gotochi.server.model.Quiz) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.Quiz m = (jag.kumamoto.apps.gotochi.server.model.Quiz) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Quiz m = (jag.kumamoto.apps.gotochi.server.model.Quiz) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Quiz m = (jag.kumamoto.apps.gotochi.server.model.Quiz) model;
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
        jag.kumamoto.apps.gotochi.server.model.Quiz m = (jag.kumamoto.apps.gotochi.server.model.Quiz) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getHtml() != null){
            writer.setNextPropertyName("html");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getHtml());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getOptionKeys() != null){
            writer.setNextPropertyName("optionKeys");
            encoder = new org.slim3.datastore.json.Default();
            writer.beginArray();
            for(com.google.appengine.api.datastore.Key v : m.getOptionKeys()){
                encoder.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getOrder() != null){
            writer.setNextPropertyName("order");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getOrder());
        }
        if(m.getPinKey() != null){
            writer.setNextPropertyName("pinKey");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPinKey());
        }
        if(m.getPoint() != null){
            writer.setNextPropertyName("point");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPoint());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Quiz jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.Quiz m = new jag.kumamoto.apps.gotochi.server.model.Quiz();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("html");
        decoder = new org.slim3.datastore.json.Default();
        m.setHtml(decoder.decode(reader, m.getHtml()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("optionKeys");
        decoder = new org.slim3.datastore.json.Default();
        {
            java.util.ArrayList<com.google.appengine.api.datastore.Key> elements = new java.util.ArrayList<com.google.appengine.api.datastore.Key>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("optionKeys");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    com.google.appengine.api.datastore.Key v = decoder.decode(reader, (com.google.appengine.api.datastore.Key)null);
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setOptionKeys(elements);
            }
        }
        reader = rootReader.newObjectReader("order");
        decoder = new org.slim3.datastore.json.Default();
        m.setOrder(decoder.decode(reader, m.getOrder()));
        reader = rootReader.newObjectReader("pinKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setPinKey(decoder.decode(reader, m.getPinKey()));
        reader = rootReader.newObjectReader("point");
        decoder = new org.slim3.datastore.json.Default();
        m.setPoint(decoder.decode(reader, m.getPoint()));
        reader = rootReader.newObjectReader("title");
        decoder = new org.slim3.datastore.json.Default();
        m.setTitle(decoder.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}