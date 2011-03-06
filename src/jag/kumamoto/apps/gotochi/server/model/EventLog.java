package jag.kumamoto.apps.gotochi.server.model;

import jag.kumamoto.apps.gotochi.server.service.ExcelSheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

/**
 * ユーザの解答や訪問履歴を保持します。
 * 
 * @author shiva
 * 
 */
@ExcelSheet(useColumn = false)
@Model(schemaVersion = 1)
public class EventLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * ピン
     */
    @Attribute(lob = true)
    private Pin pin;

    /**
     * ユーザ参照キー
     */
    private ModelRef<User> userRef = new ModelRef<User>(User.class);

    // /**
    // * ピン参照キー XXX:LOBとどちらかだけ残す
    // */
    // private ModelRef<Pin> pinRef = new ModelRef<Pin>(Pin.class);
    //
    // /**
    // * クイズ参照キー XXX:LOBとどちらかだけ残す
    // */
    // private ModelRef<Quiz> quizRef = new ModelRef<Quiz>(Quiz.class);

    /**
     * ピンキー 検索用
     */
    private Key pinKey;

    /**
     * クイズキー 検索用
     */
    private Key quizKey;

    /**
     * クイズ
     */
    @Attribute(lob = true)
    private Quiz quiz;

    /**
     * 解答参照キーリスト
     */
    @Attribute(lob = true)
    private List<Option> options = new ArrayList<Option>();

    /**
     * 解答時刻
     */
    private Date time;

    /**
     * 解答に要した時間
     */
    private Long answeringTime;

    /**
     * 正解・不正解 (正解は1, 不正解は0)
     */
    private Integer correctness;

    /**
     * 既に上書きされている場合は1
     */
    private Integer overridden = 0;

    /**
     * 既にポイントが付加されている場合は1
     */
    private Integer executed = 0;

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
        EventLog other = (EventLog) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setOptions(List<Option> optionKeys) {
        this.options = optionKeys;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setAnsweringTime(Long answeringTime) {
        this.answeringTime = answeringTime;
    }

    public Long getAnsweringTime() {
        return answeringTime;
    }

    public void setCorrectness(Integer correctness) {
        this.correctness = correctness;
    }

    public Integer getCorrectness() {
        return correctness;
    }

    public void setOverridden(Integer overridden) {
        this.overridden = overridden;
    }

    public Integer getOverridden() {
        return overridden;
    }

    public void setExecuted(Integer executed) {
        this.executed = executed;
    }

    public Integer getExecuted() {
        return executed;
    }

    // public ModelRef<Pin> getPinRef() {
    // return pinRef;
    // }

    public ModelRef<User> getUserRef() {
        return userRef;
    }

    // public ModelRef<Quiz> getQuizRef() {
    // return quizRef;
    // }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public Pin getPin() {
        return pin;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setPinKey(Key pinKey) {
        this.pinKey = pinKey;
    }

    public Key getPinKey() {
        return pinKey;
    }

    public void setQuizKey(Key quizKey) {
        this.quizKey = quizKey;
    }

    public Key getQuizKey() {
        return quizKey;
    }
}
