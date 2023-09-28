package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import library.Constants;
import pageObjects.Landingpage_Page;
import pageObjects.Results_Page;

public class Result_Test {

	
	WebDriver driver;
	Landingpage_Page landing;
	Results_Page result;
	
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
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterMethod
	public void reset() throws Exception{
		landing = new Landingpage_Page(driver);
		landing.navigateToLandingPage();
	}
	
	@Test
	public void PP_003() {
		//verify user gets an error message when searching with an invalid area code
		landing = new Landingpage_Page(driver);
		result = new Results_Page(driver);
		landing.searchForAreaCode(Constants.INVALID_AREACODE);
		result.verifyErrorMessage(Constants.INVALID_AREACODE);
	}
	
	@Test
	public void PP_004() throws Exception{
		//verify user gets search results with a valid area code
		landing = new Landingpage_Page(driver);
		result = new Results_Page(driver);
		landing.searchForAreaCode(Constants.VALID_AREACODE);
		result.verifyAreaCodeResults(Constants.VALID_AREACODE);
		result.selectPage("2");
		result.verifyAreaCodeResults(Constants.VALID_AREACODE);
		result.selectPage("3");
		result.verifyAreaCodeResults(Constants.VALID_AREACODE);
	}
	
	
	
}
