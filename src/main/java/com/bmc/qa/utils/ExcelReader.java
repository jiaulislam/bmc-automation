package com.bmc.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String pathOfReaderFile;
	private DataFormatter formatter;
	private FileInputStream bufferStream;
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	
	public ExcelReader() throws FileNotFoundException {
		this.pathOfReaderFile = System.getProperty("user.dir").concat("/datasets/Request_CR.xlsx");
		this.formatter = new DataFormatter();
		try {
			this.bufferStream = new FileInputStream(this.pathOfReaderFile);
		}catch (IOException error) {
			throw new FileNotFoundException("File Not found !" + error.getMessage());
		}
		try {
			this.workbook = new XSSFWorkbook(bufferStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String excelParser(String letterIndex, int intIndex) {
		CellReference dateCellRef = new CellReference(letterIndex.concat(String.valueOf(intIndex)));
		Row r = this.worksheet.getRow(dateCellRef.getRow());
		Cell c = r.getCell(dateCellRef.getCol());
		return formatter.formatCellValue(c);
	}
	
	
	public void changeSheet() {
		this.worksheet = this.workbook.getSheet("Main");
	}
	
	public String parseDate(int index) {
		return excelParser("B", index);
	}
	
	public String parseCoordonator(int index) {
		return excelParser("C", index);
	}
	
	public String parseShortDescription(int index) {
		return excelParser("D", index);
	}
	
	public String parseChangeActivity(int index) {
		return excelParser("E", index);
	}
	
	public String parseImpactList(int index) {
		return excelParser("F", index);
	}
	
	public String parseServiceType(int index) {
		return excelParser("G", index);
	}
	
	public String parseDownTimeHour(int index) {
		return excelParser("H", index);
	}
	
	public String parseCommercialZone(int index) {
		return excelParser("I", index);
	}
	
	public String parseChangeManager(int index) {
		return excelParser("J", index);
	}
	
	public void closeWorkBook() throws IOException {
		workbook.close();
	}
}
