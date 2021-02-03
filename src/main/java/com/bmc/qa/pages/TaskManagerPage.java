package com.bmc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class TaskManager extends BmcRemedyBase {
	
	@FindBy(xpath="")
	WebElement element;

	public TaskManager() {
		PageFactory.initElements(driver, this);
	}
}
