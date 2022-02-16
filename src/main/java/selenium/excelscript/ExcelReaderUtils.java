package selenium.excelscript;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lecture06.Utils;

public class ExcelReaderUtils {
	
	public static final String EXCEL_FILE = Utils.DOC_DIRECTORY + "/sample_form_data.xlsx";
	
	public static final DataFormatter DATE_FORMATTER = new DataFormatter();
	
	public static List<FormDataItem> readData() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new File(EXCEL_FILE));
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIter = sheet.iterator();
			List<FormDataItem> dataItems = new LinkedList<FormDataItem>();
			if (rowIter.hasNext()) {
				rowIter.next();
			} else {
				throw new IllegalArgumentException("sheet has no rows");
			}
			while (rowIter.hasNext()) {
				Row row = rowIter.next();
				dataItems.add(readData(row));
			}
			return dataItems;
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static FormDataItem readData(Row row) {
		FormDataItem item = new FormDataItem();
		item.setFirstName(getStringValue(row.getCell(0)));
		item.setLastName(getStringValue(row.getCell(1)));
		item.setEmail(getStringValue(row.getCell(2)));
		item.setGender(getStringValue(row.getCell(3)));
		item.setMobileNumber(getStringValue(row.getCell(4)));
		item.setDay(getStringValue(row.getCell(5)));
		item.setMonth(getStringValue(row.getCell(6)));
		item.setYear(getStringValue(row.getCell(7)));
		item.setSubjects(getCommaSeparatedList(row.getCell(8)));
		item.setHobbies(getCommaSeparatedList(row.getCell(9)));
		item.setAddress(getStringValue(row.getCell(10)));
		item.setState(getStringValue(row.getCell(11)));
		item.setCity(getStringValue(row.getCell(12)));
		return item;
	}
	
	private static String getStringValue(Cell cell) {
		String s = DATE_FORMATTER.formatCellValue(cell);
		return s;
	}
	
	private static List<String> getCommaSeparatedList(Cell cell) {
		String s = getStringValue(cell);
		return Arrays.asList(s.split(","));
	}

}
