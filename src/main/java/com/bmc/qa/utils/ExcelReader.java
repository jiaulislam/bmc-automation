package com.bmc.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String pathOfReaderFile;
	private FileInputStream bufferStream;
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	private DataFormatter formatter;
	private CellReference cellReference;
	
	public ExcelReader() throws FileNotFoundException {
		pathOfReaderFile = System.getProperty("user.dir").concat("/datasets/Request_CR.xlsx");
		try {
			bufferStream = new FileInputStream(pathOfReaderFile);
		}catch (IOException error) {
			throw new FileNotFoundException("File Not found !" + error.getMessage());
		}
		try {
			workbook = new XSSFWorkbook(bufferStream);
			worksheet = workbook.getSheet("Main");
			formatter = new DataFormatter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Cell getMyCell(String reference, int cell) {
		cellReference = new CellReference(reference.concat(String.valueOf(cell)));
		Row row = worksheet.getRow(cellReference.getRow());
		Cell cellIndex = row.getCell(cellReference.getCol());
		return cellIndex;
	}
	
	public String parseSummary(int cell) {
		return formatter.formatCellValue(getMyCell("D", cell));
	}
	
	public String parseActivityDetails(int cell) {
		return formatter.formatCellValue(getMyCell("E", cell));
	}
	
	public String parseServiceType(int cell) {
		return formatter.formatCellValue(getMyCell("G", cell));
	}
	
	public String parseDate(int cell) {
		return formatter.formatCellValue(getMyCell("B", cell));
	}
	
	public String parseCoordinator(int cell) {
		return formatter.formatCellValue(getMyCell("C", cell));
	}
	
	public String parseImpactList(int cell) {
		return formatter.formatCellValue(getMyCell("F", cell));
	}
	
	public String parseDownTime(int cell) {
		return formatter.formatCellValue(getMyCell("H", cell));
	}
	
	public String parseCommercialZone(int cell) {
		return formatter.formatCellValue(getMyCell("I", cell));
	}
	
	public String parseChangeManager(int cell) {
		return formatter.formatCellValue(getMyCell("K", cell));
	}
	
	/* Obsolete Code 
	-----------------------------
	public List<String>[] getUserData() {
		int cnt = 0;
		for (Row row : worksheet) {
			if (row.getCell(1).toString().equals("")) {
				break;
			}else {
				List<String> cols = new ArrayList<String>();
				for (Cell col : row) {
					if(formatter.formatCellValue(col) != "") {
						cols.add(formatter.formatCellValue(col));
					}else {
						break;
					}
				}
				listOfData[cnt++] = cols;
			}
		}
		return listOfData;
	}
	-------------------------------
	*/
	public Object[][] getExcelData() {
		Object[][] data = new Object[worksheet.getLastRowNum()][worksheet.getRow(0).getLastCellNum()]; 
		
		for (int i = 0; i < worksheet.getLastRowNum(); i++) {
			for (int k = 0; k < worksheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = worksheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}


	public void closeWorkbook() throws IOException {
		workbook.close();
	}
}
