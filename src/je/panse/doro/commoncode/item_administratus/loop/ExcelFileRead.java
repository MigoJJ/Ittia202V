package je.panse.doro.commoncode.item_administratus.loop;

import java.io.File;		
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelFileRead {
    public static void main(String[] args) throws IOException {
    	String fileName = "/home/woon/git/ITTIAVersion2/src/datatext/xlsxfile/Labgenomics.xlsx";
    	FileInputStream inputStream = new FileInputStream(new File(fileName));
    	XSSFWorkbook workbook = null;

    	try {
    	    // Create a workbook object from the Excel file
    	    workbook = new XSSFWorkbook(inputStream);

    	    // Get the first sheet of the workbook
    	    XSSFSheet sheet = workbook.getSheetAt(0);

    	    // Get the index of the "수진자명" column
    	    int 수진자명ColumnIndex = -1;
    	    Row headerRow = sheet.getRow(0);
    	    for (int cellIndex = 0; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
    	        Cell cell = headerRow.getCell(cellIndex);
    	        if (cell.getCellType() == CellType.STRING && "수진자명".equals(cell.getStringCellValue())) {
    	            수진자명ColumnIndex = cellIndex;
    	            break;
    	        }
    	    }

    	    if (수진자명ColumnIndex == -1) {
    	        System.out.println("Error: Could not find '수진자명' column.");
    	        return;
    	    }

    	    // Iterate over each row of the sheet, starting from the second row (i.e., index 1)
    	    for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
    	        Row row = sheet.getRow(rowIndex);
    	        Cell 수진자명Cell = row.getCell(수진자명ColumnIndex);
    	        if (수진자명Cell != null && 수진자명Cell.getCellType() == CellType.STRING && "김정현".equals(수진자명Cell.getStringCellValue())) {
    	            // Iterate over each cell of the row and print its value
    	            for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
    	                Cell cell = row.getCell(cellIndex);
    	                if (cell.getCellType() == CellType.STRING) {
    	                    System.out.print(headerRow.getCell(cellIndex).getStringCellValue() + ": " + cell.getStringCellValue() + "\t");
    	                } else if (cell.getCellType() == CellType.NUMERIC) {
    	                    System.out.print(headerRow.getCell(cellIndex).getStringCellValue() + ": " + cell.getNumericCellValue() + "\t");
    	                } else if (cell.getCellType() == CellType.BOOLEAN) {
    	                    System.out.print(headerRow.getCell(cellIndex).getStringCellValue() + ": " + cell.getBooleanCellValue() + "\t");
    	                } else {
    	                    System.out.print(" " + "\t");
    	                }
    	            }
    	            System.out.println();
    	        }
    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    // Close the workbook and input stream
    	    if (workbook != null) {
    	        workbook.close();
    	    }
    	    inputStream.close();
    	}

        
        // Close the workbook and input stream
        workbook.close();
        inputStream.close();
    }
}
