package jag.kumamoto.apps.gotochi.server.vo;

import java.util.Arrays;

import jag.kumamoto.apps.gotochi.server.service.ExcelColumun;
import jag.kumamoto.apps.gotochi.server.service.ExcelSheet;

@ExcelSheet
public class QuizExcelSheet {

    @ExcelColumun(description = "コマンド(n-Pin作成,d-Pin削除)")
    public String command;
    @ExcelColumun(description = "ピンID")
    public String pinId;
    @ExcelColumun(description = "緯度")
    public String latitude;
    @ExcelColumun(description = "軽度")
    public String longitude;
    @ExcelColumun(description = "高度")
    public String altitude;
    @ExcelColumun(description = "ピン種類")
    public String pinType;
    @ExcelColumun(description = "ピンの名前")
    public String pinName;
    @ExcelColumun(description = "県コード")
    public String prefCode;
    @ExcelColumun(description = "エリアコード")
    public String areaCode;
    @ExcelColumun(description = "ピンの到達得点")
    public String pinPoint;
    @ExcelColumun(description = "ピンのURL")
    public String pinUrl;
    @ExcelColumun(description = "ピンの説明(HTML)")
    public String pinDescription;

    @ExcelColumun(description = "クイズID")
    public String quizId;
    @ExcelColumun(description = "クイズのタイトル")
    public String quizTitle;
    @ExcelColumun(description = "クイズの内容(HTML)")
    public String quizContent;
    @ExcelColumun(description = "クイズの得点")
    public String quizPoint;
    @ExcelColumun(description = "クイズのプライオリティ")
    public String quizOrder;

    @ExcelColumun(description = "選択肢ID", group = "option")
    public String[] optionIds;
    @ExcelColumun(description = "(1-正解,0-不正解)", group = "option")
    public String[] optionCorrectness;
    @ExcelColumun(description = "選択肢の種類", group = "option")
    public String[] optionTypes;
    @ExcelColumun(description = "選択肢の内容(HTML)", group = "option")
    public String[] optionContent;

    @Override
    public String toString() {
        return "QuizExcelSheet [altitude="
            + altitude
            + ", areaCode="
            + areaCode
            + ", latitude="
            + latitude
            + ", longitude="
            + longitude
            + ", optionContent="
            + Arrays.toString(optionContent)
            + ", optionCorrectnes="
            + Arrays.toString(optionCorrectness)
            + ", optionIds="
            + Arrays.toString(optionIds)
            + ", optionTypes="
            + Arrays.toString(optionTypes)
            + ", pinId="
            + pinId
            + ", pinName="
            + pinName
            + ", pinPoint="
            + pinPoint
            + ", pinType="
            + pinType
            + ", pinUrl="
            + pinUrl
            + ", prefCode="
            + prefCode
            + ", quizContent="
            + quizContent
            + ", quizId="
            + quizId
            + ", quizPoint="
            + quizPoint
            + ", quizPriority="
            + quizOrder
            + ", quizTitle="
            + quizTitle
            + "]";
    }

}
