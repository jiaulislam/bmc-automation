package com.bmc.qa.run;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.pages.DateSchedulePage;
import com.bmc.qa.pages.HomePage;
import com.bmc.qa.pages.LoginPage;
import com.bmc.qa.pages.LogoutPage;
import com.bmc.qa.pages.NewChangePage;
import com.bmc.qa.pages.TaskManagerPage;
import com.bmc.qa.utils.UserUtility;

public class CreateChangeAction extends BmcRemedyBase {

	LoginPage loginPage;
	LogoutPage logoutPage;
	HomePage homePage;
	NewChangePage newChange;
	DateSchedulePage datePage;
	TaskManagerPage taskPage;
	
	public CreateChangeAction() {
		super();
	}
	
	public void lunchBrowser() {
		initialization();
		loginPage = new LoginPage();
	}
	
	public void login() {
		homePage = loginPage.login(UserUtility.USER_NAME, UserUtility.USER_PASS);
	}
	
	public void logout() {
		logoutPage = homePage.clickLogoutBtn();
	}
	
	public void gotoNewChange() {
		homePage.clickApplicationBtn();
		homePage.clickChangeManagementBtn();
		newChange = homePage.createNewChange();
	}
	
	public void initialCreateChangePageFillup(String summary, String notes) {
		newChange.insertSummaryText(summary);
		newChange.insertNotesText(notes);
		newChange.insertWorkInfoText(notes);
		newChange.clickWorkInfoAddBtn();
	}
	
	public void selectChangeManager(String changeManager) {
		newChange.selectChangeManagerGroup(changeManager);
		newChange.selectChangeManager(changeManager);
	}
	
	public void selectLocation(String changeLocation) {
		newChange.changeLocation(changeLocation);
	}
	
	public void setupDate(String startDate, String endDate) {
		datePage = newChange.createDate();
		datePage.insertEndDate(startDate);
		datePage.insertEndDate(endDate);
	}
	
	public void setupTask(String[] dates) {
		taskPage = newChange.createTask();
		taskPage.createTaskTemplate();
		taskPage.clickTaskRowSpan();
		taskPage.initiationTaskFillUp(dates[0], dates[1]);
		taskPage.serviceDowntimeDurationTask(dates[1], dates[1]);
		taskPage.systemDowntimeWindowTask(dates[1], dates[2]);
		taskPage.systemDowntimeDurationTask(dates[1], dates[1]);
		taskPage.reviewAndClosureTask(dates[2], dates[3]);
	}
	
	public void saveChangeRequest() {
		newChange.saveChange();
	}
	
	public void quitBrower() {
		driver.quit();
	}
}
