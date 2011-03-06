package jag.kumamoto.apps.gotochi.server.model;

import jag.kumamoto.apps.gotochi.server.service.ExcelSheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 
 * ご当地クイズを表すクラスです。
 * 
 * @author shiva
 * 
 */
@ExcelSheet(useColumn = false)
@Model(schemaVersion = 1)
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * クイズタイトル
     */
    private String title;

    /**
     * クイズコンテンツ
     */
    @Attribute(lob = true)
    private String html;

    /**
     * クイズ選択肢
     */
    private List<Key> optionKeys = new ArrayList<Key>();

    /**
     * 位置情報
     */
    private Key pinKey;

    /**
     * 獲得ポイント
     */
    private Integer point;

    /**
     * プライオリティ
     */
    private Integer order;

    /**
     * クイズの解説
     */
    @Attribute(lob = true)
    private String description;

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
        Quiz other = (Quiz) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<Key> getOptionKeys() {
        return optionKeys;
    }

    public void setOptionKeys(List<Key> optionKeys) {
        this.optionKeys = optionKeys;
    }

    public void setPinKey(Key pinKey) {
        this.pinKey = pinKey;
    }

    public Key getPinKey() {
        return pinKey;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
