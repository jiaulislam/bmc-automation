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
import com.bmc.qa.pages.TaskManagerPage;
import com.bmc.qa.utils.UserUtility;


public class TaskManagerPageTest extends BmcRemedyBase {
	
	LoginPage loginPage;
	HomePage homePage;
	NewChangePage createChange;
	LogoutPage logoutPage;
	DateSchedulePage setDateTime;
	TaskManagerPage task;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
		homePage.clickApplicationBtn();
		homePage.clickChangeManagementBtn();
		createChange = homePage.createNewChange();
		createChange.insertSummaryText("HellO Wrold Tewst ");
		createChange.insertNotesText("Insert Ntoe section");
		setDateTime = createChange.createDate();
		setDateTime.insertStartDate("02/07/2021 06:00:00 AM");
		setDateTime.insertEndDate("02/07/2021 06:00:00 PM");
		task = createChange.createTask();
	}
	
	@Test(priority=1)
	public void createTaskTemplateTest() {
		task.createTaskTemplate();
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=2, dependsOnMethods="createTaskTemplateTest")
	public void clickTaskRowSpan() {
		task.createTaskTemplate();
		task.clickTaskRowSpan();
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=3, dependsOnMethods="createTaskTemplateTest")
	public void initiationTaskFillUpTest() {
		task.createTaskTemplate();
		task.clickTaskRowSpan();
		task.initiationTaskFillUp("02/07/2021 09:00:00 AM", "02/07/2021 11:00:00 AM");
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=4, dependsOnMethods="createTaskTemplateTest")
	public void serviceDowntimeDurationTaskTest() {
		task.createTaskTemplate();
		task.clickTaskRowSpan();
		task.serviceDowntimeDurationTask("02/07/2021 09:00:00 AM", "02/07/2021 11:00:00 AM");
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=5, dependsOnMethods="createTaskTemplateTest")
	public void systemDowntimeWindowTaskTest() {
		task.createTaskTemplate();
		task.clickTaskRowSpan();
		task.systemDowntimeWindowTask("02/07/2021 09:00:00 AM", "02/07/2021 11:00:00 AM");
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=6, dependsOnMethods="createTaskTemplateTest")
	public void systemDowntimeDurationTaskTest() {
		task.createTaskTemplate();
		task.clickTaskRowSpan();
		task.systemDowntimeDurationTask("02/07/2021 09:00:00 AM", "02/07/2021 11:00:00 AM");
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@Test(priority=7, dependsOnMethods="createTaskTemplateTest")
	public void reviewAndClosureTaskTest() {
		task.createTaskTemplate();
		task.clickTaskRowSpan();
		task.reviewAndClosureTask("02/07/2021 09:00:00 AM", "02/07/2021 11:00:00 AM");
		logoutPage = homePage.clickLogoutBtn();
		createChange.handleNotSavedLogout();
		Assert.assertTrue(logoutPage.logoutSuccessfullVerification());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


