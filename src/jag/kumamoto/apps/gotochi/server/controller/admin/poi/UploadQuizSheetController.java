package jag.kumamoto.apps.gotochi.server.controller.admin.poi;

import jag.kumamoto.apps.gotochi.server.meta.OptionMeta;
import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;
import jag.kumamoto.apps.gotochi.server.service.ExcelIOService;
import jag.kumamoto.apps.gotochi.server.vo.QuizExcelSheet;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class UploadQuizSheetController extends Controller {

    private ExcelIOService eIO = new ExcelIOService();

    @Override
    public Navigation run() throws Exception {
        FileItem formFile = requestScope("formFile");
        Workbook wb =
            WorkbookFactory
                .create(new ByteArrayInputStream(formFile.getData()));
        List<QuizExcelSheet> read =
            eIO.read((HSSFWorkbook) wb, QuizExcelSheet.class);

        Pin pin = null;

        for (QuizExcelSheet s : read) {

            System.out.println("--");
            System.out.println(pin);
            System.out.println(s.pinName);
            System.out.println(s.quizTitle);
            System.out.println(s.command);
            System.out.println(isNullOrEmpty(s.pinName));
            if (isNullOrEmpty(s.pinName)) {
                // Quiz定義

                if (pin == null) {
                    continue;// 関連するピンが定義されていない
                }

                Quiz quiz = null;
                Key quizKey = null;

                if (s.command.startsWith("d")) {// 削除
                    if (!isNullOrEmpty(s.quizId)) {
                        long quizId = Long.parseLong(v(s.quizId));
                        quizKey = Datastore.createKey(Quiz.class, quizId);
                        quiz = Datastore.get(Quiz.class, quizKey);

                        List<Key> asKeyList =
                            Datastore
                                .query(Option.class)
                                .filter(OptionMeta.get().quizKey.equal(quizKey))
                                .asKeyList();
                        for (Key key : asKeyList) {
                            GlobalTransaction gtx =
                                Datastore.beginGlobalTransaction();
                            Datastore.delete(key);
                            gtx.commit();
                        }

                        GlobalTransaction gtx =
                            Datastore.beginGlobalTransaction();
                        Datastore.delete(quizKey);
                        gtx.commit();
                        continue;
                    }
                }
                if (s.command.startsWith("u") && !isNullOrEmpty(s.quizId)) {
                    long quizId = Long.parseLong(v(s.quizId));
                    quizKey = Datastore.createKey(Quiz.class, quizId);

                    quiz = Datastore.getOrNull(Quiz.class, quizKey);
                }
                if (quiz == null) {
                    quiz = new Quiz();
                    quizKey = Datastore.allocateId(Quiz.class);
                    quiz.setKey(quizKey);
                }
                quiz.getOptionKeys().clear();

                for (int i = 0; i < s.optionIds.length; i++) {

                    Option option = null;
                    Key opKey = null;
                    if (!isNullOrEmpty(v(s.optionContent, i))
                        && !isNullOrEmpty(v(s.optionIds, i))) {
                        // 更新時
                        try {
                            long opId = Long.parseLong(v(s.optionIds, i));
                            opKey = Datastore.createKey(Option.class, opId);
                            option = Datastore.getOrNull(Option.class, opKey);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                    if (option == null) {
                        option = new Option();
                        opKey = Datastore.allocateId(Option.class);
                        option.setKey(opKey);
                    }
                    option.setQuizKey(quizKey);

                    option.setText(v(s.optionContent, i));
                    if (!isNullOrEmpty(v(s.optionCorrectness, i)))
                        option.setCorrectness(Integer.parseInt(v(v(
                            s.optionCorrectness,
                            i))));
                    if (!isNullOrEmpty(v(s.optionTypes, i)))
                        option
                            .setType(Integer.parseInt(v(v(s.optionTypes, i))));

                    GlobalTransaction gtx = Datastore.beginGlobalTransaction();
                    Datastore.put(option);
                    gtx.commit();

                    if (quiz.getOptionKeys() == null) {
                        quiz.setOptionKeys(new ArrayList<Key>());
                    }
                    quiz.getOptionKeys().add(opKey);
                }

                quiz.setHtml(s.quizContent);
                quiz.setTitle(s.quizTitle);
                quiz.setDescription(s.quizDescription);
                if (!isNullOrEmpty(s.quizPoint))
                    quiz.setPoint(Integer.parseInt(v(s.quizPoint)));
                else
                    quiz.setPoint(null);

                if (!isNullOrEmpty(s.quizOrder))
                    quiz.setOrder(Integer.parseInt(v(s.quizOrder)));
                else
                    quiz.setOrder(null);
                quiz.setPinKey(pin.getKey());

                GlobalTransaction gtx = Datastore.beginGlobalTransaction();
                Datastore.put(quiz);
                gtx.commit();

            } else {
                // Pin定義
                if (s.command.startsWith("u")) {// 更新
                    if (isNullOrEmpty(s.pinId))
                        continue;
                    long pinId = Long.parseLong(v(s.pinId));
                    Key pinKey = Datastore.createKey(Pin.class, pinId);
                    pin = Datastore.getOrNull(Pin.class, pinKey);
                } else if (s.command.startsWith("d")) {// 削除
                    if (isNullOrEmpty(s.pinId))
                        continue;
                    long pinId = Long.parseLong(v(s.pinId));
                    Key pinKey = Datastore.createKey(Pin.class, pinId);
                    GlobalTransaction gtx = Datastore.beginGlobalTransaction();
                    Datastore.delete(pinKey);
                    gtx.commit();
                    continue;
                } else {
                    pin = new Pin();
                }

                if (!isNullOrEmpty(s.altitude))
                    pin.setAltitude(Integer.parseInt(v(s.altitude)));
                else
                    pin.setAltitude(null);

                if (!isNullOrEmpty(s.areaCode))
                    pin.setAreaCode(Integer.parseInt(v(s.areaCode)));
                else
                    pin.setAreaCode(null);

                if (!isNullOrEmpty(s.latitude))
                    pin.setLatitude(Integer.parseInt(v(s.latitude)));
                else
                    pin.setLatitude(null);

                if (!isNullOrEmpty(s.longitude))
                    pin.setLongitude(Integer.parseInt(v(s.longitude)));
                else
                    pin.setLongitude(null);

                if (!isNullOrEmpty(s.pinPoint))
                    pin.setPoint(Integer.parseInt(v(s.pinPoint)));
                else
                    pin.setPoint(null);

                if (!isNullOrEmpty(s.pinDescription))
                    pin.setDescription(v(s.areaCode));

                if (!isNullOrEmpty(s.pinName))
                    pin.setName(v(s.pinName));

                if (!isNullOrEmpty(s.pinUrl))
                    pin.setUrl(v(s.pinUrl));

                GlobalTransaction gtx = Datastore.beginGlobalTransaction();
                Datastore.put(pin);
                gtx.commit();
            }
        }
        requestScope("comment", "アップロードしました");
        return forward("index");
    }

    private String v(String[] sr, int i) {
        if (sr == null) {
            return "";
        }
        if (sr.length <= i) {
            return "";
        }
        return sr[i];
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null) {
            return true;
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;

    }

    // private Long l(String s) {
    // try {
    // return Long.parseLong(s);
    // } catch (Exception e) {
    // return 0l;
    // }
    // }
    //
    // private Integer i(String s) {
    // try {
    // return Integer.parseInt(s);
    // } catch (Exception e) {
    // return 0;
    // }
    // }

    private String v(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return null;
        }
        return s;
    }

}
