package com.bmc.qa.pages;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmc.qa.base.BmcRemedyBase;
import com.bmc.qa.utils.UserUtility;

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
	
	// Summary Text Box
	@FindBy(xpath="//*[@id='arid_WIN_3_1000000000']")
	WebElement summaryTextBox;
	
	
	// Notes Text Box
	@FindBy(xpath="//*[@id='arid_WIN_3_1000000151']")
	WebElement notesTextBox;
	
	// Work Info Text Box
	@FindBy(xpath="//div[@id='WIN_3_304247080']//*[@id='arid_WIN_3_304247080']")
	WebElement workInfoTextBox;
	
	// Add Work Info Note Button
	@FindBy(xpath="//a[@id='WIN_3_304247110']//div[@class='f1'][contains(text(),'Add')]")
	WebElement workInfoAddBtn;
	
	// Change Manager Menu Button
	@FindBy(xpath="//*[@id='WIN_3_1000000403']/a")
	WebElement changeManagerMenuBtn;
	
	
	
	// Constructor
	public NewChangePage() {
		PageFactory.initElements(driver, this);
		newChangeNumber = null;
	}
	
	
	/**
	 * Make the Change manager XPATH with user Shared Manager Name.
	 * 
	 * @param managerName
	 * @return WebElement
	 * 
	 */
	private static WebElement makeChangeManagerXpath(String managerName) {
		try {
			return driver.findElement(By.xpath(String.format(
					"//div[@class='MenuOuter']//*[text()='%s']", 
					managerName)));
		}catch (NoSuchElementException exception) {
			// TODO: here for now using default person but in future will give a Xpath where it automatically picks the first available one in shown list.
			return driver.findElement(By.xpath("//div[@class='MenuOuter']//*[text()='Muhammad Shahed']"));
		}
	}
	
	
	/**
	 * Check if the user shared Change Manager is ANR or TNR Group.
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @return True if contains Manager in Array else False
	 */
	private static boolean getChangeManagerType(String[] arrayOfManagers, String changeManager) {
		
		return Arrays.asList(arrayOfManagers).contains(changeManager);
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
	public void insertSummaryText(String summaryText) {
		summaryTextBox.sendKeys(summaryText);
	}
	
	/**
	 * Writes the Notes section area text with user provided information.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertNotesText(String details) {
		notesTextBox.sendKeys(details);;
	}
	
	/**
	 * Writes the impact-list shared by the user site list in Notes.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertImpactListText(String impactList) {
		notesTextBox.sendKeys(impactList);
	}
	
	/**
	 * Creates the Work info area with user provided information.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void insertWorkInfoText(String details) {
		workInfoTextBox.sendKeys(details);;
	}
	
	/**
	 * Click the add button on Work Info Section.
	 * 
	 * @author Jibon
	 * @version 0.1
	 * @returns void
	 */
	public void clickWorkInfoAddBtn() {
		clickOn(workInfoAddBtn);
	}
	
	/**
	 * Selects the Change Manager Group(ANR / TNR) of user choice.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void selectChangeManagerGroup(String changeManager) {
		clickOn(managerGroupBtn);
		hoverOver(implementationMenuBtn);
		
		if (getChangeManagerType(UserUtility.TNR_GROUP, changeManager)) {
			hoverOver(tnrGroupMenuBtn);
			hoverOver(txOptimizationBtn);
			clickOn(txOptimizationBtn);
		}
		else if (getChangeManagerType(UserUtility.ANR_GROUP, changeManager)) {
			hoverOver(anrGroupMenuBtn);
			hoverOver(radioRolloutBtn);
			clickOn(radioRolloutBtn);
		}
		else {
			System.out.println("Change Manager is unknown. Using default Group.");
			hoverOver(tnrGroupMenuBtn);
			hoverOver(txOptimizationBtn);
			clickOn(txOptimizationBtn);
		}
	}
	
	/**
	 * Selects the Change Manager relative to {@code selectChangeManagerGroup()} function.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void selectChangeManager(String changeManager) {
		clickOn(changeManagerMenuBtn);
		
		WebElement manager = makeChangeManagerXpath(changeManager);
		
		if (manager.isDisplayed()) {
			hoverOver(manager);
			clickOn(manager);
		}else {
			throw new NoSuchElementException("Change Manager not defined.");
		}
	}

	/**
	 * Selects the Zonal Information of user Working area.
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @return void
	 */
	public void ChangeLocation(String zonalGroupVendor) {
		;
	}
}
