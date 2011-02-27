package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-27 19:12:02")
/** */
public final class PrizeMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.Prize> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, java.util.Date> issuedTime = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, java.util.Date>(this, "issuedTime", "issuedTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, jag.kumamoto.apps.gotochi.server.model.Item> item = new org.slim3.datastore.UnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, jag.kumamoto.apps.gotochi.server.model.Item>(this, "item", "item", jag.kumamoto.apps.gotochi.server.model.Item.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize> message = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize>(this, "message", "message");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize> title = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, com.google.appengine.api.datastore.Key> userKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, com.google.appengine.api.datastore.Key>(this, "userKey", "userKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Prize, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PrizeMeta slim3_singleton = new PrizeMeta();

    /**
     * @return the singleton
     */
    public static PrizeMeta get() {
       return slim3_singleton;
    }

    /** */
    public PrizeMeta() {
        super("Prize", jag.kumamoto.apps.gotochi.server.model.Prize.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Prize entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.Prize model = new jag.kumamoto.apps.gotochi.server.model.Prize();
        model.setIssuedTime((java.util.Date) entity.getProperty("issuedTime"));
        jag.kumamoto.apps.gotochi.server.model.Item _item = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("item"));
        model.setItem(_item);
        model.setKey(entity.getKey());
        model.setMessage((java.lang.String) entity.getProperty("message"));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setUserKey((com.google.appengine.api.datastore.Key) entity.getProperty("userKey"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.Prize m = (jag.kumamoto.apps.gotochi.server.model.Prize) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("issuedTime", m.getIssuedTime());
        entity.setUnindexedProperty("item", serializableToBlob(m.getItem()));
        entity.setProperty("message", m.getMessage());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("userKey", m.getUserKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Prize m = (jag.kumamoto.apps.gotochi.server.model.Prize) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.Prize m = (jag.kumamoto.apps.gotochi.server.model.Prize) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Prize m = (jag.kumamoto.apps.gotochi.server.model.Prize) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Prize m = (jag.kumamoto.apps.gotochi.server.model.Prize) model;
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
        jag.kumamoto.apps.gotochi.server.model.Prize m = (jag.kumamoto.apps.gotochi.server.model.Prize) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getIssuedTime() != null){
            writer.setNextPropertyName("issuedTime");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getIssuedTime());
        }
        // jag.kumamoto.apps.gotochi.server.model.Item is not supported.
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getMessage() != null){
            writer.setNextPropertyName("message");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getMessage());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getTitle());
        }
        if(m.getUserKey() != null){
            writer.setNextPropertyName("userKey");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getUserKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Prize jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.Prize m = new jag.kumamoto.apps.gotochi.server.model.Prize();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("issuedTime");
        decoder = new org.slim3.datastore.json.Default();
        m.setIssuedTime(decoder.decode(reader, m.getIssuedTime()));
        // jag.kumamoto.apps.gotochi.server.model.Item is not supported.
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("message");
        decoder = new org.slim3.datastore.json.Default();
        m.setMessage(decoder.decode(reader, m.getMessage()));
        reader = rootReader.newObjectReader("title");
        decoder = new org.slim3.datastore.json.Default();
        m.setTitle(decoder.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("userKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setUserKey(decoder.decode(reader, m.getUserKey()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}