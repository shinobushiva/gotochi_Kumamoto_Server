package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-27 19:12:02")
/** */
public final class GotochiUserDataMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData> {

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, java.util.List<com.google.appengine.api.datastore.Key>, com.google.appengine.api.datastore.Key> itemKeys = new org.slim3.datastore.CollectionAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, java.util.List<com.google.appengine.api.datastore.Key>, com.google.appengine.api.datastore.Key>(this, "itemKeys", "itemKeys", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, java.lang.Integer> point = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, java.lang.Integer>(this, "point", "point", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, com.google.appengine.api.datastore.Key> userKey = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, com.google.appengine.api.datastore.Key>(this, "userKey", "userKey", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.GotochiUserData, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final GotochiUserDataMeta slim3_singleton = new GotochiUserDataMeta();

    /**
     * @return the singleton
     */
    public static GotochiUserDataMeta get() {
       return slim3_singleton;
    }

    /** */
    public GotochiUserDataMeta() {
        super("GotochiUserData", jag.kumamoto.apps.gotochi.server.model.GotochiUserData.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.GotochiUserData entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData model = new jag.kumamoto.apps.gotochi.server.model.GotochiUserData();
        model.setItemKeys(toList(com.google.appengine.api.datastore.Key.class, entity.getProperty("itemKeys")));
        model.setKey(entity.getKey());
        model.setPoint(longToInteger((java.lang.Long) entity.getProperty("point")));
        model.setUserKey((com.google.appengine.api.datastore.Key) entity.getProperty("userKey"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = (jag.kumamoto.apps.gotochi.server.model.GotochiUserData) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("itemKeys", m.getItemKeys());
        entity.setProperty("point", m.getPoint());
        entity.setProperty("userKey", m.getUserKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = (jag.kumamoto.apps.gotochi.server.model.GotochiUserData) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = (jag.kumamoto.apps.gotochi.server.model.GotochiUserData) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = (jag.kumamoto.apps.gotochi.server.model.GotochiUserData) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = (jag.kumamoto.apps.gotochi.server.model.GotochiUserData) model;
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
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = (jag.kumamoto.apps.gotochi.server.model.GotochiUserData) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getItemKeys() != null){
            writer.setNextPropertyName("itemKeys");
            encoder = new org.slim3.datastore.json.Default();
            writer.beginArray();
            for(com.google.appengine.api.datastore.Key v : m.getItemKeys()){
                encoder.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getPoint() != null){
            writer.setNextPropertyName("point");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPoint());
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
    public jag.kumamoto.apps.gotochi.server.model.GotochiUserData jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.GotochiUserData m = new jag.kumamoto.apps.gotochi.server.model.GotochiUserData();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("itemKeys");
        decoder = new org.slim3.datastore.json.Default();
        {
            java.util.ArrayList<com.google.appengine.api.datastore.Key> elements = new java.util.ArrayList<com.google.appengine.api.datastore.Key>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("itemKeys");
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
                m.setItemKeys(elements);
            }
        }
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("point");
        decoder = new org.slim3.datastore.json.Default();
        m.setPoint(decoder.decode(reader, m.getPoint()));
        reader = rootReader.newObjectReader("userKey");
        decoder = new org.slim3.datastore.json.Default();
        m.setUserKey(decoder.decode(reader, m.getUserKey()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}