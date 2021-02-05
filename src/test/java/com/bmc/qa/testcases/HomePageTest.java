package com.bmc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.utils.UserUtility;

public class HomePageTest extends BmcRemedyBase{
	
	LoginPage loginPage;
	HomePage homePage;
	String validUser = "K M Jiaul Islam Jibon";
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
	}
	
	@Test(priority=1)
	public void validateCurrnetUserTest() {
		String currentUser = homePage.validateCurrentUser();
		homePage.clickLogoutBtn();
		Assert.assertEquals(currentUser, validUser, "User Name is not Valid !");
	}
	
	@Test(priority=2)
	public void clickLogoutBtnTest() {
		homePage.clickLogoutBtn();
	}
	
	@Test(priority=3)
	public void alreadyLoggedInTest() {
		boolean flag = homePage.alreadyLoggedIn();
		homePage.clickLogoutBtn();
		Assert.assertFalse(flag);
	}
	
	@Test(priority=4)
	public void clickApplicationBtnTest() {
		homePage.clickApplicationBtn();
		homePage.clickLogoutBtn();
	}
	
	@Test(priority=5)
	public void clickChangeManagementBtnTest() {
		homePage.clickApplicationBtn();
		homePage.clickChangeManagementBtn();
		homePage.clickLogoutBtn();
	}
	
	@Test(priority=6)
	public void createNewChangeTest() {
		homePage.clickApplicationBtn();
		homePage.clickChangeManagementBtn();
		homePage.createNewChange();
		homePage.clickLogoutBtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
