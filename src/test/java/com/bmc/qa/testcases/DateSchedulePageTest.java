package com.bmc.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.pages.LogoutPage;
import com.bmc.qa.pages.NewChangePage;
import com.bmc.qa.utils.UserUtility;

public class DateSchedulePageTest extends BmcRemedyBase {

	LoginPage loginPage;
	HomePage homePage;
	LogoutPage logoutpage;
	NewChangePage newChange;
	
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
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
