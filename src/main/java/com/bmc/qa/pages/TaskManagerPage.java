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

	public TaskManagerPage() {
		PageFactory.initElements(driver, this);
	}
}
