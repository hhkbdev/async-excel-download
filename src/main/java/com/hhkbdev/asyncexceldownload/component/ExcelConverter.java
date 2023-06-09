package com.hhkbdev.asyncexceldownload.component;

import com.hhkbdev.asyncexceldownload.domain.Field;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelConverter {
  List<Field> fields;

  public ExcelConverter(List<Field> fields) {
    this.fields = fields;
  }

  public Workbook convertToWorkbook(List<Map<String, String>> dataList) {
    Workbook workbook = new SXSSFWorkbook();

    Sheet sheet = workbook.createSheet("Data");
    int rowIndex = 0;

    // 헤더 행 생성
    Row headerRow = sheet.createRow(rowIndex++);
    int cellIndex = 0;
    for (Field field : fields) {
      Cell headerCell = headerRow.createCell(cellIndex++);
      headerCell.setCellValue(field.getSchema().getComment());
    }

    // 데이터 행 생성
    for (Map<String, String> dataMap : dataList) {
      Row dataRow = sheet.createRow(rowIndex++);
      cellIndex = 0;
      for (Field field : fields) {
        Cell dataCell = dataRow.createCell(cellIndex++);
        if (dataMap.get(field.getSchema().getName()) == null) {
          dataCell.setCellValue("");
          continue;
        }
        dataCell.setCellValue(dataMap.get(field.getSchema().getName()));

        CellStyle cellStyle = workbook.createCellStyle();
        dataCell.setCellStyle(cellStyle);
        cellStyle.setAlignment(field.getStyle().getHorizontalAlignment());
      }
    }

    return workbook;
  }
}
