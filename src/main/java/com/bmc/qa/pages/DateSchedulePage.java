package com.bmc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class DateSchedulePage extends BmcRemedyBase{

	@FindBy(xpath="//input[@id='arid_WIN_3_1000000350']")
	WebElement startDateInput;
	
	@FindBy(xpath="//input[@id='arid_WIN_3_1000000362']")
	WebElement endDateInput;
	
	
	public DateSchedulePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void insertStartDate(String startDate) {
		writeOn(startDateInput, startDate);
	}
	
	public void insertEndDate(String endDate) {
		writeOn(endDateInput, endDate);
	}
}
