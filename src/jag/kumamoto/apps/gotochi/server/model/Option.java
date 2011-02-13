package jag.kumamoto.apps.gotochi.server.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 
 * クイズの選択肢を表すクラスです。
 * 
 * @author shiva
 * 
 */
@Model(schemaVersion = 1)
public class Option implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * 解答種類
     */
    private Integer type;

    /**
     * 選択肢内容
     */
    private String text;

    /**
     * 正解・不正解 (正解は1, 不正解は0)
     */
    private Integer correctness;

    /**
     * クイズ参照キー
     */
    private Key quizKey;

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
        Option other = (Option) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setCorrectness(Integer correctness) {
        this.correctness = correctness;
    }

    public Integer getCorrectness() {
        return correctness;
    }

    public void setQuizKey(Key quizKey) {
        this.quizKey = quizKey;
    }

    public Key getQuizKey() {
        return quizKey;
    }
}
