package jag.kumamoto.apps.gotochi.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-27 19:12:02")
/** */
public final class ItemMeta extends org.slim3.datastore.ModelMeta<jag.kumamoto.apps.gotochi.server.model.Item> {

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item> description = new org.slim3.datastore.StringUnindexedAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item>(this, "description", "description");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item> imageUrl = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item>(this, "imageUrl", "imageUrl");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item> name = new org.slim3.datastore.StringAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<jag.kumamoto.apps.gotochi.server.model.Item, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ItemMeta slim3_singleton = new ItemMeta();

    /**
     * @return the singleton
     */
    public static ItemMeta get() {
       return slim3_singleton;
    }

    /** */
    public ItemMeta() {
        super("Item", jag.kumamoto.apps.gotochi.server.model.Item.class);
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Item entityToModel(com.google.appengine.api.datastore.Entity entity) {
        jag.kumamoto.apps.gotochi.server.model.Item model = new jag.kumamoto.apps.gotochi.server.model.Item();
        model.setDescription(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("description")));
        model.setImageUrl((java.lang.String) entity.getProperty("imageUrl"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        jag.kumamoto.apps.gotochi.server.model.Item m = (jag.kumamoto.apps.gotochi.server.model.Item) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("description", stringToText(m.getDescription()));
        entity.setProperty("imageUrl", m.getImageUrl());
        entity.setProperty("name", m.getName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Item m = (jag.kumamoto.apps.gotochi.server.model.Item) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        jag.kumamoto.apps.gotochi.server.model.Item m = (jag.kumamoto.apps.gotochi.server.model.Item) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Item m = (jag.kumamoto.apps.gotochi.server.model.Item) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        jag.kumamoto.apps.gotochi.server.model.Item m = (jag.kumamoto.apps.gotochi.server.model.Item) model;
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
        jag.kumamoto.apps.gotochi.server.model.Item m = (jag.kumamoto.apps.gotochi.server.model.Item) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getDescription());
        }
        if(m.getImageUrl() != null){
            writer.setNextPropertyName("imageUrl");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getImageUrl());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    public jag.kumamoto.apps.gotochi.server.model.Item jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        jag.kumamoto.apps.gotochi.server.model.Item m = new jag.kumamoto.apps.gotochi.server.model.Item();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("description");
        decoder = new org.slim3.datastore.json.Default();
        m.setDescription(decoder.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("imageUrl");
        decoder = new org.slim3.datastore.json.Default();
        m.setImageUrl(decoder.decode(reader, m.getImageUrl()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
    return m;
}
}