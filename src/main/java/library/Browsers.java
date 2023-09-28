package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	
	
	
	public static WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
			
		} else if(browser.equalsIgnoreCase("Safari")) {
			
			return new SafariDriver();
			
		} else if(browser.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
			
		} else {
			
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
			
		}
		
	}

}
