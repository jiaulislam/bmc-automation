package com.bmc.qa.pages;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class HomePage extends BmcRemedyBase{
	
	
	@FindBy(xpath="//div[@class='f9'][contains(text(),'Logout')]")
	WebElement logoutBtn;
	
	@FindBy(xpath="//label[@id='label80137'][contains(text(), 'IT Home')]")
	WebElement itHomeText;
	
	@FindBy(xpath="//*[@id='reg_img_304316340']")
	WebElement applicationBtn;
	
	@FindBy(xpath="//*[text()='Change Management']")
	WebElement changeManagementBtn;
	
	@FindBy(xpath="//*[text()='New Change']")
	WebElement newChangeBtn;
	
	@FindBy(xpath="//label[contains(text(), 'K M Jiaul Islam Jibon')]")
	WebElement userNameText;
	
	
	// initialize the Page Factory objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	
	/**
	 * <h1>Get the current logged in user name.</h1> 
	 * <br>
	 * <b>Usage:<b> {@code HomePage.validateCurrnetUser}
	 * <br>
	 * <br>
	 * @author Jibon
	 * @version 0.1
	 * @return String
	 */
	public String validateCurrentUser() {
		/*
		 * return the current logged in user name
		 */
		return userNameText.getText();
	}
	
	/**
	 * <h1>Check if user already logged in from another machine.</h1>
	 * <br>
	 * @author Jibon
	 * @version 0.1
	 * @return True If user already logged in else False.
	 *
	 */
	public boolean alreadyLoggedIn() {
		try {
			validateCurrentUser();
			return false;
		}catch (UnhandledAlertException exception) {
			return true;
		}
	}
	
	/**
	 * <h1>Handle situation where user have 
	 * already logged in from other computer</h1>
	 * <br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void handleAlreadyLoggedInUser() {
		;
	}
	
	/**
	 *<h1> Click the logout button of the HomePage.</h1>
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
}
