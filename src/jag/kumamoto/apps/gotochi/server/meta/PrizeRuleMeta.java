package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-27 19:12:02")
/** */
public final class PrizeRuleMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, java.util.Date> issuedTime = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, java.util.Date>(this, "issuedTime", "issuedTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, com.google.appengine.api.datastore.Key> itemKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, com.google.appengine.api.datastore.Key>(this, "itemKey", "itemKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule> message = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule>(this, "message", "message");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule> script = new org.slim3.datastore.StringUnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule>(this, "script", "script");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule> title = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.PrizeRule, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PrizeRuleMeta slim3_singleton = new PrizeRuleMeta();

    /**
     * @return the singleton
     */
    public static PrizeRuleMeta get() {
       return slim3_singleton;
    }

    /** */
    public PrizeRuleMeta() {
        super("PrizeRule", jag.kumamoto.apps.gotochi.server.model.PrizeRule.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.PrizeRule entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.PrizeRule model = new jag.kumamoto.apps.gotochi.server.model.PrizeRule();
        model.setIssuedTime((java.util.Date) entity.getProperty("issuedTime"));
        model.setItemKey((com.google.appengine.api.datastore.Key) entity.getProperty("itemKey"));
        model.setKey(entity.getKey());
        model.setMessage((java.lang.String) entity.getProperty("message"));
        model.setScript(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("script")));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = (jag.kumamoto.apps.gotochi.server.model.PrizeRule) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("issuedTime", m.getIssuedTime());
        entity.setProperty("itemKey", m.getItemKey());
        entity.setProperty("message", m.getMessage());
        entity.setUnindexedProperty("script", stringToText(m.getScript()));
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = (jag.kumamoto.apps.gotochi.server.model.PrizeRule) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = (jag.kumamoto.apps.gotochi.server.model.PrizeRule) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = (jag.kumamoto.apps.gotochi.server.model.PrizeRule) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = (jag.kumamoto.apps.gotochi.server.model.PrizeRule) model;
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
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = (jag.kumamoto.apps.gotochi.server.model.PrizeRule) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getIssuedTime() != null){
            writer.setNextPropertyName("issuedTime");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getIssuedTime());
        }
        if(m.getItemKey() != null){
            writer.setNextPropertyName("itemKey");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getItemKey());
        }
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
        if(m.getScript() != null){
            writer.setNextPropertyName("script");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getScript());
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
    public jag.kumamoto.apps.gotochi.server.model.PrizeRule jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.PrizeRule m = new jag.kumamoto.apps.gotochi.server.model.PrizeRule();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("issuedTime");
        decoder = new org.slim3.datastore.json.Default();
        m.setIssuedTime(decoder.decode(reader, m.getIssuedTime()));
        reader = rootReader.newObjectReader("itemKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setItemKey(decoder.decode(reader, m.getItemKey()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("message");
        decoder = new org.slim3.datastore.json.Default();
        m.setMessage(decoder.decode(reader, m.getMessage()));
        reader = rootReader.newObjectReader("script");
        decoder = new org.slim3.datastore.json.Default();
        m.setScript(decoder.decode(reader, m.getScript()));
        reader = rootReader.newObjectReader("title");
        decoder = new org.slim3.datastore.json.Default();
        m.setTitle(decoder.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}