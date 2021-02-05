package com.bmc.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.utils.UserUtility;

public class LogoutPage extends BmcRemedyBase {
	
	String logoutSuccessMsg = "You have successfully logged out";
	
	@FindBy(xpath="//td[@class='Logout'][contains(text(),'You have successfully logged out')]")
	WebElement logoutSuccessText;
	
	
	// initialize the PageFactory
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoutSuccessfullVerification() {
		try {
			wait = new WebDriverWait(driver, UserUtility.EXPLICIT_WAIT);
			String parseText = wait.until(ExpectedConditions.visibilityOf(logoutSuccessText)).getText();
			return parseText.equals(logoutSuccessMsg);
		}catch (NoSuchElementException exception) {
			throw new NoSuchElementException(exception.getMessage());
		}catch (TimeoutException exception) {
			throw new TimeoutException(exception.getMessage());
		}
	}

}

