package com.bmc.qa.run;

import java.io.FileNotFoundException;

import com.bmc.qa.utils.ExcelReader;

public class Run {

	public static void main(String[] args) {
//		CreateChangeAction change = new CreateChangeAction();
		ExcelReader excel = null;
		try {
			excel = new ExcelReader();
		}catch (FileNotFoundException error) {
			System.err.print(error.getMessage());
		}	
		
		String summary = excel.parseSummary(2);
		String activityDetails = excel.parseActivityDetails(2);
		String serviceType = excel.parseServiceType(2);
		String impactList = excel.parseImpactList(2);
		String coordinator = excel.parseCoordinator(2);
		String downTime = excel.parseDownTime(2);
		String commercialZone = excel.parseCommercialZone(2);
		String changeManager = excel.parseChangeManager(2);
		
		String makeSummary = summary + " // " + serviceType;
		
		System.out.println(makeSummary);
		System.out.println(activityDetails);
		System.out.println(impactList);
		System.out.println(coordinator);
		System.out.println(downTime);
		System.out.println(commercialZone);
		System.out.println(changeManager);
//		Object[][] exceldata = excel.getExcelData();
//		change.lunchBrowser();
//		change.login();
		
//		for (int i=0; i < exceldata.length -1; i++) {
//			for (int k=1; k < (exceldata[0].length); k++) {
//				System.out.print(exceldata[i+1][k] + " || ");
//			}
//			System.out.println();
//		}

//		change.logout();
//		change.quitBrower();
		System.out.println("Program executed successfully.");
	}
	
}
