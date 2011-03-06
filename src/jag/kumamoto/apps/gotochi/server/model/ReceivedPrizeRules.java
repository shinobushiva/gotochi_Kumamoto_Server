package jag.kumamoto.apps.gotochi.server.model;

import jag.kumamoto.apps.gotochi.server.service.ExcelSheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * ユーザが既に受け取った賞の受賞ルールを保持します。
 * 
 * @author shiva
 * 
 */
@ExcelSheet(useColumn = false)
@Model(schemaVersion = 1)
public class ReceivedPrizeRules implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * ユーザキー
     */
    private Key userKey;

    /**
     * 受賞ルールのキーリスト
     */
    private List<Key> prizeRuleKeys = new ArrayList<Key>();

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
        ReceivedPrizeRules other = (ReceivedPrizeRules) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setUserKey(Key userKey) {
        this.userKey = userKey;
    }

    public Key getUserKey() {
        return userKey;
    }

    public void setPrizeRuleKeys(List<Key> prizeRuleKeys) {
        this.prizeRuleKeys = prizeRuleKeys;
    }

    public List<Key> getPrizeRuleKeys() {
        return prizeRuleKeys;
    }
}
