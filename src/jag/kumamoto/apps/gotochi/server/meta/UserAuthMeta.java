package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-13 13:44:38")
/** */
public final class UserAuthMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth> token = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth>(this, "token", "token");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth, com.google.appengine.api.datastore.Key> userKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth, com.google.appengine.api.datastore.Key>(this, "userKey", "userKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.UserAuth, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final UserAuthMeta slim3_singleton = new UserAuthMeta();

    /**
     * @return the singleton
     */
    public static UserAuthMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserAuthMeta() {
        super("UserAuth", jag.kumamoto.apps.gotochi.server.model.UserAuth.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.UserAuth entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.UserAuth model = new jag.kumamoto.apps.gotochi.server.model.UserAuth();
        model.setKey(entity.getKey());
        model.setToken((java.lang.String) entity.getProperty("token"));
        model.setUserKey((com.google.appengine.api.datastore.Key) entity.getProperty("userKey"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = (jag.kumamoto.apps.gotochi.server.model.UserAuth) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("token", m.getToken());
        entity.setProperty("userKey", m.getUserKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = (jag.kumamoto.apps.gotochi.server.model.UserAuth) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = (jag.kumamoto.apps.gotochi.server.model.UserAuth) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = (jag.kumamoto.apps.gotochi.server.model.UserAuth) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = (jag.kumamoto.apps.gotochi.server.model.UserAuth) model;
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
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = (jag.kumamoto.apps.gotochi.server.model.UserAuth) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getToken() != null){
            writer.setNextPropertyName("token");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getToken());
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
    public jag.kumamoto.apps.gotochi.server.model.UserAuth jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.UserAuth m = new jag.kumamoto.apps.gotochi.server.model.UserAuth();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("token");
        decoder = new org.slim3.datastore.json.Default();
        m.setToken(decoder.decode(reader, m.getToken()));
        reader = rootReader.newObjectReader("userKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setUserKey(decoder.decode(reader, m.getUserKey()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}