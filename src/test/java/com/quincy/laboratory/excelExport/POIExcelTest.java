package com.quincy.laboratory.excelExport;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
public class POIExcelTest {
    @Test
    public static void main(String[] argv) {

    }

    @Test
    public void Excel2007AboveOperateOld() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(Files.newInputStream(Paths.get("bak/doc/Excel2007workbook.xlsx")));
        // 获取第一个表单
        Sheet first = workbook.getSheetAt(0);
        for (int i = 0; i < 100000; i++) {
            Row row = first.createRow(i);
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    // 首行
                    row.createCell(j).setCellValue("column" + j);
                } else {
                    // 数据
                    if (j == 0) {
                        CellUtil.createCell(row, j, String.valueOf(i));
                    } else
                        CellUtil.createCell(row, j, String.valueOf(Math.random()));
                }
            }
        }
        // 写入文件
        FileOutputStream out = new FileOutputStream("bak/doc/Excel2007workbook.xlsx");
        workbook.write(out);
        out.close();
    }

    //
    @Test
    public void Excel2007AboveOperate( ) throws IOException {
        XSSFWorkbook workbook1 = new XSSFWorkbook(Files.newInputStream(Paths.get("bak/doc/Excel2007workbook.xlsx")));
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook1, 100);
        //            Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
        Sheet first = sxssfWorkbook.getSheetAt(0);
        for (int i = 0; i < 100000; i++) {
            Row row = first.createRow(i);
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    // 首行
                    row.createCell(j).setCellValue("column" + j);
                } else {
                    // 数据
                    if (j == 0) {
                        CellUtil.createCell(row, j, String.valueOf(i));
                    } else
                        CellUtil.createCell(row, j, String.valueOf(Math.random()));
                }
            }
        }
        FileOutputStream out = new FileOutputStream("bak/doc/Excel2007workbook.xlsx");
        sxssfWorkbook.write(out);
        out.close();
    }
}
