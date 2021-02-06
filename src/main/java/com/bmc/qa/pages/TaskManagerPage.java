package com.bmc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class TaskManagerPage extends BmcRemedyBase {
	
	@FindBy(xpath="//input[@type='text' and @id='arid_WIN_3_10003042']")
	WebElement selectTaskCatagoryBtn;
	
	@FindBy(xpath="//td[contains(text(), 'Task Group Template')]")
	WebElement taskGroupBtn;
	
	// Template Relate Button
	@FindBy(xpath="//div[contains(text(),'Relate')]")
	WebElement relateBtn;
	
	// Task Relate Button
	@FindBy(xpath="//a[@id='WIN_0_10006772']")
	WebElement taskRelateBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Task Group')]")
	WebElement createdTaskGroupBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Initiation Phase Task (SOC)')]")
	WebElement initiationTaskBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Service Downtime Duration Task')]")
	WebElement serviceDowntimeDuration;
	
	@FindBy(xpath="//span[contains(text(), 'System Downtime Task')]")
	WebElement systemDowntimeTask;
	
	@FindBy(xpath="//span[contains(text(), 'Service Downtime Window Task')]")
	WebElement downtimeWindowBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Review and Closure Task (SOC)')]")
	WebElement reviewAndClosureBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Dates')]")
	WebElement taskDateSectionBtn;
	
	@FindBy(xpath="//input[@id= 'arid_WIN_0_1000000350']")
	WebElement taskStartTimeText;
	
	@FindBy(xpath="//input[@id= 'arid_WIN_0_1000000362']")
	WebElement taskEndTimeText;
	
	@FindBy(xpath="//div[@class='f7'][contains(text(), 'Save')]")
	WebElement taskSaveBtn;

	public TaskManagerPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Create the Standard template for all new Change
	 * 
	 * @return void
	 */
	public void createTaskTemplate() {
		String parentWindow = driver.getWindowHandle();
		
		clickOn(selectTaskCatagoryBtn);
		hoverOver(taskGroupBtn);
		clickOn(taskGroupBtn);
		clickOn(relateBtn);
				
		for (String winHanle : driver.getWindowHandles()) {
			if (!parentWindow.equals(winHanle)) {
				driver.switchTo().window(winHanle);
				clickOn(taskRelateBtn);	
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	
	/**
	 * Click on the created task template
	 * 
	 * @return void
	 */
	public void clickTaskRowSpan() {
		clickOn(createdTaskGroupBtn);
	}
	
	
	/**
	 * Set the start & end date time for opened task page.
	 * @param parentWindow
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	private void setDateTimeOfTask(String parentWindow, String startTime, String endTime) {
		for (String childWin : driver.getWindowHandles()) {
			if (!parentWindow.equals(childWin)) {
				driver.switchTo().window(childWin);
				clickOn(taskDateSectionBtn);
				writeOn(taskStartTimeText, startTime);
				writeOn(taskEndTimeText, endTime);
				clickOn(taskSaveBtn);
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	/**
	 * Fill-Up the Initiation Task.
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	public void initiationTaskFillUp(String startTime, String endTime) {
		String parentWin = driver.getWindowHandle();
		doubleClick(initiationTaskBtn);
		
		setDateTimeOfTask(parentWin, startTime, endTime);
	}
	
	/**
	 * Fill-Up the Service Down time Duration Task.
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	public void serviceDowntimeDurationTask(String startTime, String endTime) {
		String parentWin = driver.getWindowHandle();
		doubleClick(serviceDowntimeDuration);
		
		setDateTimeOfTask(parentWin, startTime, endTime);
	}

	/**
	 * Fill-Up the System Down time Window Task.
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	public void systemDowntimeWindowTask(String startTime, String endTime) {
		String parentWin = driver.getWindowHandle();
		doubleClick(downtimeWindowBtn);
		
		setDateTimeOfTask(parentWin, startTime, endTime);
	}
	
	/**
	 * Fill-Up the System Down time Window Task.
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	public void systemDowntimeDurationTask(String startTime, String endTime) {
		String parentWin = driver.getWindowHandle();
		doubleClick(systemDowntimeTask);
		
		setDateTimeOfTask(parentWin, startTime, endTime);
	}
	
	/**
	 * Fill-Up the Review And Closure Task.
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	public void reviewAndClosureTask(String startTime, String endTime) {
		String parentWin = driver.getWindowHandle();
		doubleClick(reviewAndClosureBtn);
		
		setDateTimeOfTask(parentWin, startTime, endTime);
	}

}
