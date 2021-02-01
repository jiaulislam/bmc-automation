package com.bmc.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;

public class NewChangePage extends BmcRemedyBase {
	
	private String newChangeNumber;
	
	@FindBy(xpath="//div[@id='WIN_3_1000000015']//a[@class='btn btn3d menu']")
	WebElement managerGroupBtn;
	
	@FindBy(xpath="//div[@class='MenuOuter']//div[@class='MenuTableContainer']//table[@class='MenuTable']"
			+ "//tbody[@class='MenuTableBody']//tr[@class='MenuTableRow']"
			+ "//td[@class='MenuEntryName'][contains(text(),'Implementation')]")
	WebElement implementationMenuBtn;
	
	@FindBy(xpath="//td[contains(text(),'Transport Network Rollout')]")
	WebElement tnrGroupMenuBtn;
	
	@FindBy(xpath="//td[contains(text(),'Access Network Rollout')]")
	WebElement anrGroupMenuBtn;
	
	@FindBy(xpath="//td[contains(text(),'Tx Optimization and Modernization')]")
	WebElement txOptimizationBtn;
	
	@FindBy(xpath="//td[contains(text(),'Radio Rollout')]")
	WebElement radioRolloutBtn;
	
	
	// Constructor
	public NewChangePage() {
		PageFactory.initElements(driver, this);
		newChangeNumber = null;
	}
	
	
	private static WebElement makeChangeManagerXpath(String managerName) {
		String s1 = "//div[@class='MenuOuter']//*[text()='";
		String s2 = managerName + "']";
		WebElement changeManager = driver.findElement(By.xpath(s1+s2));
		return changeManager;
	}
	
	
	//Setter
	public void setChangeNumber(String newChangeNumber) {
		this.newChangeNumber = newChangeNumber;
	}
	
	// Reset Old Change Number
	public void resetChangeNumber() {
		this.newChangeNumber = null;
	}
	
	//Getter
	public String getChangeNumber() {
		return this.newChangeNumber;
	}
	
	/**
	 * Writes the Summary section of the new Change with user provided information.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertSummaryText() {
		;
	}
	
	/**
	 * Writes the Notes section area text with user provided information.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertNotesText() {
		;
	}
	
	/**
	 * Writes the impact-list shared by the user site list in Notes.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertImpactListText() {
		;
	}
	
	/**
	 * Creates the Work info area with user provided information.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertWorkInfoText() {
		;
	}
	
	/**
	 * Selects the Change Manager Group(ANR / TNR) of user choice.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void selectChangeManagerGroup() {
		clickOn(managerGroupBtn);
	}
	
	/**
	 * Selects the Change Manager relative to {@code selectChangeManagerGroup()} function.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void selectChangeManager() {
		;
	}
	
	/**
	 * Selects the Zonal Information of user Working area.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void ChangeLocation() {
		;
	}
}
