package com.bmc.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class LogoutPage extends BmcRemedyBase {
	
	
	// initialize the PageFactory
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

}
