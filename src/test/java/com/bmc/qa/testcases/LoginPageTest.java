package com.bmc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.utils.UserUtility;

public class LoginPageTest extends BmcRemedyBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	final String USERNAME = "K M Jiaul Islam Jibon";
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertTrue(title.contains("Login")); // Login sub-string available in page title ?
	}
	
	@Test(priority=2)
	public void isItHomeTextAvailableTest() {
		boolean flag = loginPage.validateLoginPageText();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest() {
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
		if (USERNAME.equals(homePage.validateCurrentUser())) {
			homePage.clickLogoutBtn();
		}
	}
	
	@Test(priority=3)
	public void handleInvalidCredentialsTest() {
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
		if (loginPage.isValidUserCredentials()) {
			homePage.clickLogoutBtn();
		}
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
