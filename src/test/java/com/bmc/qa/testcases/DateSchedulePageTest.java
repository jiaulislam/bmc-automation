package com.bmc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.DateSchedulePage;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.pages.LogoutPage;
import com.bmc.qa.pages.NewChangePage;
import com.bmc.qa.utils.UserUtility;

public class DateSchedulePageTest extends BmcRemedyBase {

	LoginPage loginPage;
	HomePage homePage;
	LogoutPage logoutPage;
	NewChangePage newChange;
	DateSchedulePage datePage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
		homePage.clickApplicationBtn();
		homePage.clickChangeManagementBtn();
		newChange = homePage.createNewChange();
		newChange.insertSummaryText("Test lorem ipsum input");
		newChange.insertNotesText("Test lorem ipsum input");
		
	}
	
	@Test(priority=1)
	public void insertStartDateTest() {
		datePage = newChange.createDate();
		datePage.insertStartDate("02/07/2021 06:00:00 AM");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=2)
	public void insertEndDate() {
		datePage = newChange.createDate();
		datePage.insertEndDate("02/07/2021 06:00:00 PM");
		logoutPage = homePage.clickLogoutBtn();
		newChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
