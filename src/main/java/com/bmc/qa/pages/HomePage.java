package com.bmc.qa.pages;

import java.util.Scanner;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class HomePage extends BmcRemedyBase{
	
	final String ALREADY_LOGGED_IN_MSG = "User is currently connected "
			+ "from another machine";
	
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
	 * Get the current logged in user name.
	 * <br><br>
	 * <b>Usage:<b> {@code HomePage.validateCurrnetUser}
	 * <br>
	 * <br>
	 * @author Jibon
	 * @version 0.1
	 * @return String
	 */
	public String validateCurrentUser() {
		return userNameText.getText();
	}
	
	/**
	 * Check if user already logged in from another machine.
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
	 * Handle situation where user  
	 * already logged in from other computer/browser</h1>
	 * <br>
	 * @author Jibon
	 * @version 0.1
	 * @return false if user is not connected & choose to overwrite else false
	 */
	public boolean handleAlreadyLoggedInUser() {
		try {
			String alertText = driver.switchTo().alert().getText();
			
			if (alertText.contains(ALREADY_LOGGED_IN_MSG)) {
				System.out.println("Already connected from other machine! "
						+ "Do you wish to overwrite (Y/N) ?");
				Scanner userInput = new Scanner(System.in);
				
					// just take the first character 
					char userChoice = userInput.nextLine().charAt(0);
					
					if (Character.toLowerCase(userChoice) == 'y') {
						// go-on with the program execution
						driver.switchTo().alert().accept();
						return false;
					}
					else if (Character.toLowerCase(userChoice) == 'n') {
						// break the program as user don't want to proceed with overwrite
						driver.switchTo().alert().dismiss();
						return true;
					}
					else {
						System.out.println("Invalid choice ! Try again.");
						return true;
					}
			}
			else {
				throw new NoAlertPresentException();
			}
		} catch (NoAlertPresentException exception) {
			return false;
		}
	}
	
	/**
	 * Click the floating application button on home page.
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void clickApplicationBtn() {
		applicationBtn.click();
	}
	
	/**
	 * Click the Change Management button from application list.
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void clickChangeManagementBtn() {
		changeManagementBtn.click();
	}
	
	
	/**
	 * Click the New Change button from Change Management list.
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void cilckNewChange() {
		newChangeBtn.click();
	}
	
	
	/**
	 *Click the logout button of the HomePage.
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
}
