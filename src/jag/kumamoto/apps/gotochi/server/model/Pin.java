package jag.kumamoto.apps.gotochi.server.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * クイズや立ち寄りイベントの位置情報を保持します。
 * 
 * @author shiva
 * 
 */
@Model(schemaVersion = 1)
public class Pin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * 緯度
     */
    private Integer latitude;

    /**
     * 軽度
     */
    private Integer longitude;

    /**
     * 高度
     */
    private Integer altitude;

    /**
     * ピンの種類
     */
    private Integer type;

    /**
     * ピンの名前
     */
    private String name;

    /**
     * ピンの説明
     */
    private String description;

    /**
     * 地域コード
     */
    private Integer areaCode;

    /**
     * 県コード
     * 
     * @see jag.kumamoto.apps.gotochi.PrefecturesCode
     */
    private Integer prefCode;

    /**
     * URL ?
     */
    private String url;

    /**
     * 獲得ポイント
     */
    private Integer point;

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
        Pin other = (Pin) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getPrefCode() {
        return prefCode;
    }

    public void setPrefCode(Integer prefCode) {
        this.prefCode = prefCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
