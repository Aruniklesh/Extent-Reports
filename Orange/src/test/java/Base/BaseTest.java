package Base;

import java.io.File;
import java.io.ObjectInputFilter.Status;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends ConfigReader {
	protected WebDriverWait wait ;

	@BeforeSuite
	public void loadBrowser() {
		String browser =  prop.getProperty("browser");
		String url = prop.getProperty("url");
	    new File("screenshots").mkdirs();

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chrome = new ChromeOptions();
			chrome.addArguments("--start-maximized");
			driver = new ChromeDriver();
			test = 	reporter.createTest("Navigating to the site");
			driver.get(url);
			test.pass(url + "IS oppened");

		}
	}

}
