package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Results_Page {

	WebDriver driver;
	
	public Results_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By errorMessage = By.xpath("//h1[@data-testid='noPropertiesHeading']/../p");
	By resultsAddress = By.xpath("//div[@id='main']//h2[@font-size='20']");
	By propertyForSaleHeader = By.xpath("//h1[@id='search-title']");
	By pagination = By.cssSelector("a[data-testid*='page-link-']");
	By paginationSection = By.xpath("//a[@data-testid='page-arrow-left']/..");
	
	
	public void verifyErrorMessage(String areaCode) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
		
		WebElement errorMessageText = driver.findElement(errorMessage);
		
		String text = errorMessageText.getText();
		
		boolean status = errorMessageText.isDisplayed();
		assertTrue(status);
		
		boolean status2 = text.contains(areaCode);
		assertTrue(status2);
	}
	
	public void verifyAreaCodeResults(String areaCode) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(propertyForSaleHeader));
		
		List<WebElement> resultsHeader = driver.findElements(resultsAddress);
		
		int count = resultsHeader.size();
		
		for(int i = 0; i < count; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", resultsHeader.get(i));
			String text = resultsHeader.get(i).getText();
			
			boolean status = text.contains(areaCode);
			System.out.println(status);
			System.out.println(text);
			assertTrue(status);
			
			
		}
	}
	
	public void selectPage(String pageNumber) throws Exception{
		
		List<WebElement> pages = driver.findElements(pagination);
		
		if (pageNumber.equals("1")) {
			pages.get(0).click();
		} else if(pageNumber.equals("2")) {
			pages.get(1).click();
		} else if(pageNumber.equals("3")) {
			pages.get(2).click();
		} else if (pageNumber.equals("4")) {
			pages.get(3).click();
		}
		Thread.sleep(2000);
	}
	
	
	
}
