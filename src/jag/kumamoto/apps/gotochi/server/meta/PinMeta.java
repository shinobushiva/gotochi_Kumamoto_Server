package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-13 13:44:38")
/** */
public final class PinMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.Pin> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> altitude = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "altitude", "altitude", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> areaCode = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "areaCode", "areaCode", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> latitude = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "latitude", "latitude", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> longitude = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "longitude", "longitude", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin> name = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> point = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "point", "point", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> prefCode = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "prefCode", "prefCode", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer> type = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Integer>(this, "type", "type", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin> url = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin>(this, "url", "url");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Pin, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PinMeta slim3_singleton = new PinMeta();

    /**
     * @return the singleton
     */
    public static PinMeta get() {
       return slim3_singleton;
    }

    /** */
    public PinMeta() {
        super("Pin", jag.kumamoto.apps.gotochi.server.model.Pin.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Pin entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.Pin model = new jag.kumamoto.apps.gotochi.server.model.Pin();
        model.setAltitude(longToInteger((java.lang.Long) entity.getProperty("altitude")));
        model.setAreaCode(longToInteger((java.lang.Long) entity.getProperty("areaCode")));
        model.setKey(entity.getKey());
        model.setLatitude(longToInteger((java.lang.Long) entity.getProperty("latitude")));
        model.setLongitude(longToInteger((java.lang.Long) entity.getProperty("longitude")));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPoint(longToInteger((java.lang.Long) entity.getProperty("point")));
        model.setPrefCode(longToInteger((java.lang.Long) entity.getProperty("prefCode")));
        model.setType(longToInteger((java.lang.Long) entity.getProperty("type")));
        model.setUrl((java.lang.String) entity.getProperty("url"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.Pin m = (jag.kumamoto.apps.gotochi.server.model.Pin) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("altitude", m.getAltitude());
        entity.setProperty("areaCode", m.getAreaCode());
        entity.setProperty("latitude", m.getLatitude());
        entity.setProperty("longitude", m.getLongitude());
        entity.setProperty("name", m.getName());
        entity.setProperty("point", m.getPoint());
        entity.setProperty("prefCode", m.getPrefCode());
        entity.setProperty("type", m.getType());
        entity.setProperty("url", m.getUrl());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Pin m = (jag.kumamoto.apps.gotochi.server.model.Pin) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.Pin m = (jag.kumamoto.apps.gotochi.server.model.Pin) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Pin m = (jag.kumamoto.apps.gotochi.server.model.Pin) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Pin m = (jag.kumamoto.apps.gotochi.server.model.Pin) model;
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
        jag.kumamoto.apps.gotochi.server.model.Pin m = (jag.kumamoto.apps.gotochi.server.model.Pin) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getAltitude() != null){
            writer.setNextPropertyName("altitude");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getAltitude());
        }
        if(m.getAreaCode() != null){
            writer.setNextPropertyName("areaCode");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getAreaCode());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getLatitude() != null){
            writer.setNextPropertyName("latitude");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getLatitude());
        }
        if(m.getLongitude() != null){
            writer.setNextPropertyName("longitude");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getLongitude());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        if(m.getPoint() != null){
            writer.setNextPropertyName("point");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPoint());
        }
        if(m.getPrefCode() != null){
            writer.setNextPropertyName("prefCode");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getPrefCode());
        }
        if(m.getType() != null){
            writer.setNextPropertyName("type");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getType());
        }
        if(m.getUrl() != null){
            writer.setNextPropertyName("url");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getUrl());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Pin jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.Pin m = new jag.kumamoto.apps.gotochi.server.model.Pin();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("altitude");
        decoder = new org.slim3.datastore.json.Default();
        m.setAltitude(decoder.decode(reader, m.getAltitude()));
        reader = rootReader.newObjectReader("areaCode");
        decoder = new org.slim3.datastore.json.Default();
        m.setAreaCode(decoder.decode(reader, m.getAreaCode()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("latitude");
        decoder = new org.slim3.datastore.json.Default();
        m.setLatitude(decoder.decode(reader, m.getLatitude()));
        reader = rootReader.newObjectReader("longitude");
        decoder = new org.slim3.datastore.json.Default();
        m.setLongitude(decoder.decode(reader, m.getLongitude()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("point");
        decoder = new org.slim3.datastore.json.Default();
        m.setPoint(decoder.decode(reader, m.getPoint()));
        reader = rootReader.newObjectReader("prefCode");
        decoder = new org.slim3.datastore.json.Default();
        m.setPrefCode(decoder.decode(reader, m.getPrefCode()));
        reader = rootReader.newObjectReader("type");
        decoder = new org.slim3.datastore.json.Default();
        m.setType(decoder.decode(reader, m.getType()));
        reader = rootReader.newObjectReader("url");
        decoder = new org.slim3.datastore.json.Default();
        m.setUrl(decoder.decode(reader, m.getUrl()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}