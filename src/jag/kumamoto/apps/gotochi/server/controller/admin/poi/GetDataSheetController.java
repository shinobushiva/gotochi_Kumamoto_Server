package jag.kumamoto.apps.gotochi.server.controller.admin.poi;

import jag.kumamoto.apps.gotochi.server.service.ExcelIOService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class GetDataSheetController extends Controller {

    private ExcelIOService eIO = new ExcelIOService();

    @SuppressWarnings("unchecked")
    @Override
    public Navigation run() throws Exception {

        String clazz = asString("class");
        Class cls = Class.forName(clazz);
        List list = Datastore.query(cls).asList();
        HSSFWorkbook book = eIO.write(list, cls);

        // EXCELのコンテントタイプを設定
        response.setContentType("application/msexcel");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fname =
            cls.getSimpleName()
                + "_DataSheet_"
                + sdf.format(new Date())
                + ".xls";

        // ファイル名を設定
        response.setHeader("Content-Disposition", "attachment; filename="
            + fname);

        book.write(response.getOutputStream());
        response.flushBuffer();

        return null;
    }

}
