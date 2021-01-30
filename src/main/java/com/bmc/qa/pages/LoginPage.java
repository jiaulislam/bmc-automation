package com.bmc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class LoginPage extends BmcRemedyBase {
	
	//Page Factory
	@FindBy(xpath="//*[@id='username-id']") // Locator XPATH: User-Name Field
	WebElement username;
	
	@FindBy(xpath="//*[@id='pwd-id']") // Locator XPATH: Password Field
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']") // Locator XPATH: Login Button
	WebElement loginBtn;
	
	@FindBy(xpath="//em[contains(text(), 'BMC Remedy Action Request System')]")
	WebElement itHomeText;
	
	// initialize the page-factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateText() {
		return itHomeText.isDisplayed();
	}
	
	
	/**
	 * <h1>Login to BMC Remedy</h1>
	 * <p>The login() function implements
	 * and login to Web-Site given browser and 
	 * return a HomePage object as this functions landing
	 * page is HomePage.<br><br>
	 * <b> Usage</b>: {@code LoginPage.login();}
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @param username An User-Name is required to login to Web-Site
	 * @param password A password is required to login to Web-Site relative to UserName 
	 * @returns HomePage
	 */
	public HomePage login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.loginBtn.click();
		
		return new HomePage();
	}

}
