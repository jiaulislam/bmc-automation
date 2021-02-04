package com.bmc.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class TaskManagerPage extends BmcRemedyBase {
	
	@FindBy(xpath="//input[@type='text' and @id='arid_WIN_3_10003042']")
	WebElement selectTaskCatagoryBtn;
	
	@FindBy(xpath="//td[contains(text(), 'Task Group Template')]")
	WebElement taskGroupBtn;
	
	@FindBy(xpath="//div[contains(text(),'Relate')]")
	WebElement relateBtn;
	
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
	 * Set the start & end date time for opened task page.
	 * @param parentWindow
	 * @param startTime
	 * @param endTime
	 * @return void
	 */
	private void setDateTimeOfTask(String parentWindow, String startTime, String endTime) {
		Set<String> allWins = driver.getWindowHandles();
		
		Iterator<String> iterate = allWins.iterator();
		if (iterate.hasNext()) {
			String childWin = iterate.next();
			
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
