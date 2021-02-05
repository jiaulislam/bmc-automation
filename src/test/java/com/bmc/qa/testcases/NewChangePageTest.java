package com.bmc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.pages.LogoutPage;
import com.bmc.qa.pages.NewChangePage;
import com.bmc.qa.utils.UserUtility;

public class NewChangePageTest extends BmcRemedyBase {
	
	LoginPage loginPage;
	HomePage homePage;
	NewChangePage newChange;
	LogoutPage logoutPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
		homePage.clickApplicationBtn();
		homePage.clickChangeManagementBtn();
		newChange = homePage.createNewChange();
	}
	
	
	@Test(priority=1)
	public void insertSummaryTextTest() {
		newChange.insertSummaryText("Hello World");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=2)
	public void insertNotesTextTest() {
		newChange.insertNotesText("Hello World");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=3)
	public void insertImpactListTextTest() {
		newChange.insertImpactListText("Hello World");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=4)
	public void insertWorkInfoTextTest() {
		newChange.insertWorkInfoText("Hello World");
		newChange.clickWorkInfoAddBtn();
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=5)
	public void selectChangeManagerGroupTest() {
		newChange.selectChangeManagerGroup("Md. Musfiqur  Rahman");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=6)
	public void selectChangeManagerTest() {
		newChange.selectChangeManagerGroup("Md. Musfiqur  Rahman");
		newChange.selectChangeManager("Md. Musfiqur  Rahman");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
