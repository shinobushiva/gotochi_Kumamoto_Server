package jag.kumamoto.apps.gotochi.server.service;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelIOService {

    private final String[] STR_ARRAY = new String[0];

    public <T> List<T> read(HSSFWorkbook book, Class<T> clazz)
            throws InstantiationException, IllegalAccessException {
        // System.out.println("read");

        List<T> result = new ArrayList<T>();

        Map<String, Field> map = new HashMap<String, Field>();

        HSSFSheet sheet = book.getSheetAt(0);
        HSSFRow nameRow = sheet.getRow(1);

        int rowNum = 2;
        int lastRowNum = sheet.getLastRowNum();
        // System.out.println(lastRowNum);
        while (rowNum <= lastRowNum) {
            T obj = clazz.newInstance();
            Map<String, List<String>> arrayValues =
                new HashMap<String, List<String>>();

            result.add(obj);

            HSSFRow row = sheet.getRow(rowNum);

            int lastCellNum = row.getLastCellNum();
            // System.out.println(lastCellNum);
            int cellNum = 0;
            while (cellNum <= lastCellNum) {
                try {
                    HSSFCell nameCell = nameRow.getCell(cellNum);
                    if (nameCell == null) {
                        cellNum++;
                        continue;
                    }
                    String fName = nameCell.getStringCellValue();
                    if (fName.endsWith("[]")) {
                        fName = fName.replace("[]", "");
                        List<String> list = arrayValues.get(fName);
                        if (list == null) {
                            list = new ArrayList<String>();
                            arrayValues.put(fName, list);
                        }
                        list.add(getValue(row.getCell(cellNum)));
                    } else {
                        Field f = getField(fName, map, clazz);
                        f.set(obj, getValue(row.getCell(cellNum)));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                cellNum++;
            }
            for (String key : arrayValues.keySet()) {
                try {
                    Field field = getField(key, map, clazz);
                    field.set(obj, arrayValues.get(key).toArray(STR_ARRAY));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

            }

            // System.out.println(obj);

            rowNum++;
        }

        return result;
    }

    public Field getField(String fName, Map<String, Field> map, Class<?> clazz)
            throws SecurityException, NoSuchFieldException {
        Field f = map.get(fName);
        if (f == null) {
            f = clazz.getDeclaredField(fName);
            f.setAccessible(true);
            map.put(fName, f);
        }
        return f;
    }

    public String getValue(Cell c) {
        if (c == null) {
            return "";
        }
        return c.getStringCellValue();
    }

    public <T> HSSFWorkbook write(List<T> inList, Class<T> clazz) {
        if (clazz.getAnnotation(ExcelSheet.class) == null) {
            return null;
        }

        Map<String, Integer> groupLength = new HashMap<String, Integer>();
        Map<String, List<String>> grouped = new HashMap<String, List<String>>();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, Field> map = new HashMap<String, Field>();

        for (Field field : fields) {
            if (field.getType().isArray()) {
                ExcelColumun ec = field.getAnnotation(ExcelColumun.class);
                if (ec == null)
                    continue;

                String group = ec.group();
                if (group.isEmpty()) {
                    group = "" + field.hashCode(); // groupが指定されていない配列に仮グループ指定
                }

                List<String> groupMembers = grouped.get(group);
                if (groupMembers == null) {
                    groupMembers = new ArrayList<String>();
                    grouped.put(group, groupMembers);
                }

                String fName = field.getName();
                groupMembers.add(fName);

                Integer max = groupLength.get(group);
                if (max == null) {
                    max = 0;
                }

                for (T obj : inList) {
                    try {
                        Field f = getField(fName, map, clazz);
                        String[] ar = (String[]) f.get(obj);
                        if (ar != null) {
                            max = Math.max(max, ar.length);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
                groupLength.put(group, max);
                // System.out.println(group + "[" + max + "]" + ":" +
                // groupMembers);
            }
        }

        HSSFWorkbook wb = null;
        try {
            wb =
                (HSSFWorkbook) WorkbookFactory.create(new FileInputStream(
                    "resources/dummy.xls"));
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
        int sheetNum = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            wb.removeSheetAt(i);
        }
        HSSFSheet sheet = wb.createSheet();

        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);

        int counter = 0;

        List<String> doneGroups = new ArrayList<String>();

        for (Field field : fields) {
            ExcelColumun ec = field.getAnnotation(ExcelColumun.class);
            if (ec == null)
                continue;
            String name = field.getName();
            String description = ec.description();

            if (field.getType().isArray()) {
                String group = ec.group();
                if (group.isEmpty()) {
                    group = "" + field.hashCode();
                }
                if (doneGroups.contains(group))
                    continue;
                doneGroups.add(group);
                Integer length = groupLength.get(group);
                List<String> groupMemebers = grouped.get(group);

                for (int i = 0; i < length; i++) {
                    for (String string : groupMemebers) {
                        try {
                            Field f = getField(string, map, clazz);
                            ExcelColumun ec2 =
                                f.getAnnotation(ExcelColumun.class);
                            {
                                Cell cell = row0.createCell(counter);
                                cell.setCellValue(ec2.description());
                            }
                            {
                                Cell cell = row1.createCell(counter);
                                cell.setCellValue(string + "[]");
                            }
                            counter++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }
                    }
                }
            } else {
                {
                    Cell cell = row0.createCell(counter);
                    cell.setCellValue(description);
                }
                {
                    Cell cell = row1.createCell(counter);
                    cell.setCellValue(name);
                }
                counter++;
            }
        }

        int rownum = 2;

        for (T obj : inList) {
            Row row = sheet.createRow(rownum);
            doneGroups.clear();

            int cellnum = 0;
            for (Field field : fields) {
                ExcelColumun ec = field.getAnnotation(ExcelColumun.class);
                if (ec == null) {
                    continue;
                }
                String fName = field.getName();

                if (field.getType().isArray()) {
                    String group = ec.group();
                    if (group.isEmpty()) {
                        group = "" + field.hashCode();
                    }
                    if (doneGroups.contains(group)) {
                        continue;
                    }
                    doneGroups.add(group);
                    Integer length = groupLength.get(group);
                    List<String> groupMemebers = grouped.get(group);

                    for (int i = 0; i < length; i++) {
                        for (String string : groupMemebers) {
                            try {
                                Cell cell = row.createCell(cellnum++);
                                String[] vals =
                                    (String[]) getField(string, map, clazz)
                                        .get(obj);
                                if (vals != null && vals.length > i) {
                                    cell.setCellValue(trim(vals[i]));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                continue;
                            }
                        }
                    }
                } else {
                    {
                        Cell cell = row.createCell(cellnum++);
                        try {
                            cell.setCellValue(trim(getField(fName, map, clazz)
                                .get(obj)));
                        } catch (Exception e) {
                        }
                    }
                }

            }
            rownum++;
        }

        return wb;

    }

    public String trim(Object str) {
        if (str == null) {
            return "";
        }
        return "" + str;
    }

    public HSSFWorkbook createBook(Class<?> c) {
        if (c.getAnnotation(ExcelSheet.class) == null) {
            return null;
        }

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);

        Map<String, List<String>> groupMap =
            new HashMap<String, List<String>>();

        int counter = 0;

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            ExcelColumun ec = field.getAnnotation(ExcelColumun.class);
            if (ec == null)
                continue;
            String name = field.getName();
            String description = ec.description();

            String group = ec.group();
            if (group.length() > 0) {
                List<String> list = groupMap.get(group);
                if (list == null) {
                    list = new ArrayList<String>();
                    groupMap.put(group, list);
                }
                list.add(name);
            }

            if (field.getType().isArray()) {
                name = name + "[]";
            }

            {
                Cell cell = row0.createCell(counter);
                cell.setCellValue(description);
            }
            {
                Cell cell = row1.createCell(counter);
                cell.setCellValue(name);
            }

            counter++;
        }

        return wb;
    }

}
