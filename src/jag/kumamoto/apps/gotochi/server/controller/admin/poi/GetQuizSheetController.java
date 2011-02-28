package jag.kumamoto.apps.gotochi.server.controller.admin.poi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jag.kumamoto.apps.gotochi.server.meta.OptionMeta;
import jag.kumamoto.apps.gotochi.server.meta.QuizMeta;
import jag.kumamoto.apps.gotochi.server.model.Option;
import jag.kumamoto.apps.gotochi.server.model.Pin;
import jag.kumamoto.apps.gotochi.server.model.Quiz;
import jag.kumamoto.apps.gotochi.server.service.ExcelIOService;
import jag.kumamoto.apps.gotochi.server.vo.QuizExcelSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class GetQuizSheetController extends Controller {

    private ExcelIOService eIO = new ExcelIOService();

    @Override
    public Navigation run() throws Exception {

        List<QuizExcelSheet> list = new ArrayList<QuizExcelSheet>();

        List<Pin> pins = Datastore.query(Pin.class).asList();
        for (Pin pin : pins) {
            {
                QuizExcelSheet s = new QuizExcelSheet();
                s.command = "u";
                list.add(s);
                s.pinId = value(pin.getKey().getId());
                s.pinName = value(pin.getName());
                s.pinPoint = value(pin.getPoint());
                s.pinType = value(pin.getType());
                s.pinUrl = value(pin.getUrl());
                s.pinDescription = value(pin.getDescription());
                s.altitude = value(pin.getAltitude());
                s.areaCode = value(pin.getAreaCode());
                s.latitude = value(pin.getLatitude());
                s.longitude = value(pin.getLongitude());
                s.prefCode = value(pin.getPrefCode());
            }

            List<Quiz> quizes =
                Datastore.query(Quiz.class).filter(
                    QuizMeta.get().pinKey.equal(pin.getKey())).asList();
            for (Quiz quiz : quizes) {

                QuizExcelSheet s = new QuizExcelSheet();
                list.add(s);

                // s.pinId = "" + pin.getKey().getId();
                // s.pinName = pin.getName();
                // s.pinPoint = "" + pin.getPoint();
                // s.pinType = "" + pin.getType();
                // s.pinUrl = pin.getUrl();

                s.quizId = value(quiz.getKey().getId());
                s.quizContent = value(quiz.getHtml());
                s.quizPoint = value(quiz.getPoint());
                s.quizOrder = value(quiz.getOrder());
                s.quizTitle = value(quiz.getTitle());

                List<Option> options =
                    Datastore.query(Option.class).filter(
                        OptionMeta.get().quizKey.equal(quiz.getKey())).asList();
                s.optionIds = new String[options.size()];
                s.optionContent = new String[options.size()];
                s.optionCorrectness = new String[options.size()];
                s.optionTypes = new String[options.size()];
                for (int i = 0; i < options.size(); i++) {
                    Option o = options.get(i);
                    s.optionIds[i] = value(o.getKey().getId());
                    s.optionContent[i] = value(o.getText());
                    s.optionCorrectness[i] = value(o.getCorrectness());
                    s.optionTypes[i] = value(o.getType());
                }
            }
        }

        HSSFWorkbook book = eIO.write(list, QuizExcelSheet.class);

        // EXCELのコンテントタイプを設定
        response.setContentType("application/msexcel");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fname = "DataSheet_" + sdf.format(new Date()) + ".xls";

        // ファイル名を設定
        response.setHeader("Content-Disposition", "attachment; filename="
            + fname);

        book.write(response.getOutputStream());
        response.flushBuffer();

        return null;
    }

    private String value(Object o) {
        if (o == null) {
            return "";
        }
        return "" + o;
    }
}
