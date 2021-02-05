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
	
	/**
	 * Fill up the Start Date in Date Page
	 * 
	 * @param startDate
	 */
	public void insertStartDate(String startDate) {
		writeOn(startDateInput, startDate);
	}
	
	/**
	 * Fill up the End date in the Date Page
	 * 
	 * @param endDate
	 */
	public void insertEndDate(String endDate) {
		writeOn(endDateInput, endDate);
	}
}
