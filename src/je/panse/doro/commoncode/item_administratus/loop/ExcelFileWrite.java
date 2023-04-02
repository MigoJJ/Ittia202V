package commoncode.item_administratus.loop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelFileWrite {
    public static void main(String[] args) throws IOException {
        String inputFileName = "/home/woon/git/ITTIAVersion2/src/datatext/xlsxfile/Labgenomics.xlsx";
        String outputFileName = "/home/woon/git/ITTIAVersion2/src/datatext/xlsxfile/kimlab.xlsx";
        String filterName = "김정현";
        String[] columns = {"결과완료일", "수진자명", "주민번호01", "검사명", "검사결과", "단위", "참고치", "서술형결과"};

        // Read the input Excel file
        FileInputStream inputStream = new FileInputStream(new File(inputFileName));
        XSSFWorkbook inputWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet inputSheet = inputWorkbook.getSheetAt(0);

        // Create the output Excel file and sheet
        XSSFWorkbook outputWorkbook = new XSSFWorkbook();
        XSSFSheet outputSheet = outputWorkbook.createSheet("Sheet1");

        // Create the header row
        XSSFRow headerRow = outputSheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            XSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Loop through each row in the input sheet
        int outputRowIndex = 1; // start at row 1 because row 0 is the header
        for (int i = 1; i <= inputSheet.getLastRowNum(); i++) {
            XSSFRow inputRow = inputSheet.getRow(i);

            // Check if the 수진자명 column contains the filter name
            XSSFCell 수진자명Cell = inputRow.getCell(2);
            
            if (수진자명Cell.getCellType() != CellType.STRING || !수진자명Cell.getStringCellValue().equals(filterName)) {
                continue;
            }
            // Create the output row and copy the selected columns from the input row
            XSSFRow outputRow = outputSheet.createRow(outputRowIndex++);
            for (int j = 0; j < columns.length; j++) {
                XSSFCell inputCell = inputRow.getCell(j);
                XSSFCell outputCell = outputRow.createCell(j);

                // Copy the cell value and formatting from the input cell to the output cell
                outputCell.setCellStyle(inputCell.getCellStyle());
                switch (inputCell.getCellType()) {
                    case BOOLEAN:
                        outputCell.setCellValue(inputCell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        outputCell.setCellValue(inputCell.getNumericCellValue());
                        break;
                    case STRING:
                        outputCell.setCellValue(inputCell.getStringCellValue());
                        break;
                    case FORMULA:
                        outputCell.setCellFormula(inputCell.getCellFormula());
                        break;
                    case BLANK:
                        outputCell.setBlank();
                        break;
                    default:
                        break;
                }
            }
        }

        // Write the output workbook to the file
        FileOutputStream outputStream = new FileOutputStream(outputFileName);
        outputWorkbook.write(outputStream);

        // Close the input and output streams and workbooks
        inputStream.close();
        inputWorkbook.close();
        outputStream.close();
        outputWorkbook.close();
    }
}
