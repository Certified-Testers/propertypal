package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landingpage_Page {
	
	WebDriver driver;
	
	public Landingpage_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	By cookieButton = By.xpath("//span[contains(text(), 'AGREE')]/..");
	By searchField = By.xpath("//input[@data-testid='searchInput']");
	By homeButton = By.xpath("//button[@data-testid='log-in']/../a");
	By viewMoreProperties = By.xpath("//div[@id='main']/section[1]/a");
	
	
	// Functions
	public void handleCookiePopup() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
		driver.findElement(cookieButton).click();
	}
	
	public void searchForAreaCode(String areaCode) {
		driver.findElement(searchField).click();
		driver.findElement(searchField).sendKeys(areaCode);
		driver.findElement(searchField).sendKeys(Keys.ENTER);
	}
	
	public void navigateToLandingPage() throws Exception{
		Thread.sleep(3000);
		driver.findElement(homeButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewMoreProperties));
		
	}
	
	public void verifySearchFieldData(String areacode) {
		WebElement searchBox = driver.findElement(searchField);
		String searchBoxValue = searchBox.getAttribute("value");
		boolean status = searchBoxValue.equals(areacode);
		assertTrue(status);
	}
	
	
	
	
	
	
	

}
