package jag.kumamoto.apps.gotochi.server.controller.admin.poi;

import jag.kumamoto.apps.gotochi.server.service.ExcelIOService;
import jag.kumamoto.apps.gotochi.server.vo.QuizExcelSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class GetQuizTemplateController extends Controller {

    private ExcelIOService eIO = new ExcelIOService();

    @Override
    public Navigation run() throws Exception {

        HSSFWorkbook book = eIO.createBook(QuizExcelSheet.class);

        // EXCELのコンテントタイプを設定
        response.setContentType("application/msexcel");

        String fname = "Template.xls";

        // ファイル名を設定
        response.setHeader("Content-Disposition", "attachment; filename="
            + fname);

        book.write(response.getOutputStream());
        response.flushBuffer();

        return null;
    }
}
