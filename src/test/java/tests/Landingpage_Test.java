package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Constants;
import pageObjects.Landingpage_Page;

public class Landingpage_Test {

	WebDriver driver;
	Landingpage_Page landing;
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			driver = library.Browsers.launchBrowser("Chrome");
		} else if(Browser.equalsIgnoreCase("Firefox")) {
			driver = library.Browsers.launchBrowser("Firefox");
		} else if(Browser.equalsIgnoreCase("Safari")) {
			driver = library.Browsers.launchBrowser("Safari");
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get(Constants.PROPERTYPAL_URL);
		landing = new Landingpage_Page(driver);
		landing.handleCookiePopup();
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@AfterMethod
	public void reset() throws Exception{
		landing = new Landingpage_Page(driver);
		landing.navigateToLandingPage();
	}
	
	@Test
	public void PP_001() {
		//verify search field contains entered data
		landing = new Landingpage_Page(driver);
		landing.searchForAreaCode(Constants.INVALID_AREACODE);
		landing.verifySearchFieldData(Constants.INVALID_AREACODE);
	}
	
	@Test
	public void PP_002() {
		//verify user gets search results with a valid area code
		landing = new Landingpage_Page(driver);
		landing.searchForAreaCode("BT6");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
