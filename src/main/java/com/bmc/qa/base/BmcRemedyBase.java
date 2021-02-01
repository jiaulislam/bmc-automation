package com.bmc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bmc.qa.utils.UserUtility;


public class BmcRemedyBase {
	public static WebDriver driver;
	public static Properties staticData;
	
	public BmcRemedyBase() {
		
		try {
			staticData = new Properties();
			FileInputStream fp = new FileInputStream("C:\\Users\\Jibon\\eclispe-workspace\\AutomationTest\\"
					+ "src\\main\\java\\com\\bmcremedy\\qa\\config\\config.properties");
			staticData.load(fp);
		}catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	

	/**
	 * Initiate the Driver
	 * <p>The Initialization() function implements the WebDriver 
	 * and runs the Driver of browser property in 
	 * <b>config.properties</b> (ChromeDriver, Firefox, IE)</p>
	 * <b> Usage</b>: {@code BmcRemedyBase.Initialization();}
	 * <br><br>
	 * @author Jibon
	 * @version 0.1
	 * @returns void
	 */
	public static void initialization() {
		String browserName = staticData.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jibon\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			// not yet working for it
			;
		}else if (browserName.equals("Edge")) {
			// not yet working for it
			;
		}else {
			System.out.println("Sorry ! Browser model not supported at the moment. You can mail at jiaulislam.ict.bd@gmail.com for "
					+ "any recommendation.");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UserUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(UserUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(UserUtility.URL);
	}
	
}
