package com.bmc.qa.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;


/**
 * LoginPage class is inheriting from BmcRemedyBase Class.<br>
 * LoginPage class should only have the login pagelocators &<br>
 * LoginPage related methods.
 * @author Jibon
 *
 */
public class LoginPage extends BmcRemedyBase {
	
	final String INVLAID_USER_CRED = "ARERR [9388] Authentication failed";
	
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
	
	public boolean validateLoginPageText() {
		return itHomeText.isDisplayed();
	}
	
	/**
	 *  Handle invalid user credentials with logics
	 * <br>
	 * @author Jibon
	 * @version 0.1
	 * @return boolean
	 */
	public boolean isValidUserCredentials() {
		try {
			String alertText = driver.switchTo().alert().getText();
			if (alertText.equals(INVLAID_USER_CRED)) {
				driver.switchTo().alert().accept();
				System.err.println("Invalid username or password. Please try again.");
				driver.quit();
				return false;
			}
			else {
				throw new NoAlertPresentException();
			}
		} catch (NoAlertPresentException exception) {
			return true;
		}
	}
	
	/**
	 * Login to BMC Remedy
	 * The login() function implements
	 * and login to Web-Site given browser and 
	 * return a HomePage object as this functions landing
	 * page is HomePage.<br>
	 * @author Jibon
	 * @version 0.1
	 * @param username An User-Name is required to login to Web-Site
	 * @param password A password is required to login to Web-Site relative to UserName 
	 * @return HomePage
	 */
	public HomePage login(final String username, final String password) {
		writeOn(this.username, username);
		writeOn(this.password, password);
		clickOn(this.loginBtn);
		return new HomePage();
	}

}
