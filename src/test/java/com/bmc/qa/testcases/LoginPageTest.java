package com.bmc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.utils.CustomUtility;

public class LoginPageTest extends BmcRemedyBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertTrue(title.contains("Login")); // Login sub-string available in page title ?
	}
	
	@Test(priority=2)
	public void isItHomeTextAvailableTest() {
		boolean flag = loginPage.validateText();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(CustomUtility.USER_NAME, CustomUtility.USER_PASS);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
