package jag.kumamoto.apps.gotochi.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * ご当地アプリに関連するユーザ情報を保持します。
 * 
 * @author shiva
 * 
 */
@Model(schemaVersion = 1)
public class GotochiUserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * 獲得ポイント
     */
    private Integer point = 0;

    /**
     * ユーザキー
     */
    private Key userKey;

    /**
     * 取得アイテムのキーリスト
     */
    private List<Key> itemKeys = new ArrayList<Key>();

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GotochiUserData other = (GotochiUserData) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }

    public void setUserKey(Key userKey) {
        this.userKey = userKey;
    }

    public Key getUserKey() {
        return userKey;
    }

    public void setItemKeys(List<Key> itemKeys) {
        this.itemKeys = itemKeys;
    }

    public List<Key> getItemKeys() {
        return itemKeys;
    }
}
