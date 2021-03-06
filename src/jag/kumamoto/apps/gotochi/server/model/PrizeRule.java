package jag.kumamoto.apps.gotochi.server.model;

import jag.kumamoto.apps.gotochi.server.service.ExcelSheet;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 獲得商品情報を保持します。
 * 
 * @author shiva
 * 
 */
@ExcelSheet(useColumn = false)
@Model(schemaVersion = 1)
public class PrizeRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * タイトル
     */
    private String title;

    /**
     * ルール検証スクリプト Javascript
     */
    @Attribute(lob = true)
    private String script;

    /**
     * メッセージ
     */
    private String message;

    /**
     * 受賞アイテムキー
     */
    private Key itemKey;

    /**
     * 発行時刻
     */
    private Date issuedTime;

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
        PrizeRule other = (PrizeRule) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getScript() {
        return script;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setItemKey(Key itemKey) {
        this.itemKey = itemKey;
    }

    public Key getItemKey() {
        return itemKey;
    }
}
