package jag.kumamoto.apps.gotochi.server.vo;

import java.util.Arrays;

import jag.kumamoto.apps.gotochi.server.service.ExcelColumn;
import jag.kumamoto.apps.gotochi.server.service.ExcelSheet;

@ExcelSheet
public class QuizExcelSheet {

    @ExcelColumn(description = "コマンド(u-更新,d-削除)")
    public String command;
    @ExcelColumn(description = "ピンID")
    public String pinId;
    @ExcelColumn(description = "緯度")
    public String latitude;
    @ExcelColumn(description = "軽度")
    public String longitude;
    @ExcelColumn(description = "高度")
    public String altitude;
    @ExcelColumn(description = "ピン種類")
    public String pinType;
    @ExcelColumn(description = "ピンの名前")
    public String pinName;
    @ExcelColumn(description = "県コード")
    public String prefCode;
    @ExcelColumn(description = "エリアコード")
    public String areaCode;
    @ExcelColumn(description = "ピンの到達得点")
    public String pinPoint;
    @ExcelColumn(description = "ピンのURL")
    public String pinUrl;
    @ExcelColumn(description = "ピンの説明(HTML)")
    public String pinDescription;

    @ExcelColumn(description = "クイズID")
    public String quizId;
    @ExcelColumn(description = "クイズのタイトル")
    public String quizTitle;
    @ExcelColumn(description = "クイズの内容")
    public String quizContent;
    @ExcelColumn(description = "クイズの得点")
    public String quizPoint;
    @ExcelColumn(description = "クイズのプライオリティ(昇順)")
    public String quizOrder;
    @ExcelColumn(description = "クイズの解説")
    public String quizDescription;

    @ExcelColumn(description = "選択肢ID", group = "option")
    public String[] optionIds;
    @ExcelColumn(description = "(1-正解,0-不正解)", group = "option")
    public String[] optionCorrectness;
    @ExcelColumn(description = "選択肢の種類", group = "option")
    public String[] optionTypes;
    @ExcelColumn(description = "選択肢の内容(HTML)", group = "option")
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
