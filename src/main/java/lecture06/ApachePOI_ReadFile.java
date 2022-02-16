package lecture06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI_ReadFile {

	public static void main(String[] args) throws IOException {
		File myFile = new File("Writesheet.xlsx"); 
		FileInputStream fis = new FileInputStream(myFile); // Finds the workbook instance for XLSX file XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); // Return first sheet from the XLSX workbook XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); 
		// Return first sheet from the XLSX workbook 
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		
		Iterator<Row> iter = mySheet.iterator();
		
		while (iter.hasNext()) {
			Row row = iter.next();
			Iterator<Cell> cellIter = row.cellIterator();
			
			while (cellIter.hasNext()) {
				Cell cell = cellIter.next();
				DataFormatter formatter = new DataFormatter();
				String s = formatter.formatCellValue(cell);
				System.out.print(s + " --- ");
//				if (cell.getCellType().equals(CellType.STRING)) {
//					System.out.print(cell.getStringCellValue() + " --- ");
//				} else if (cell.getCellType().equals(CellType.NUMERIC)) {
//					System.out.print(cell.getNumericCellValue() + " --- ");
//				} else {
//					//
//				}
				
			}
			System.out.println();
		}

	}

}
