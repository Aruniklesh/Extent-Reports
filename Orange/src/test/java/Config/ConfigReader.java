package Config;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigReader {

	protected WebDriver driver;
	protected Properties prop;
	protected ExtentReports reporter;
	ExtentSparkReporter spark;

	protected ExtentTest test;
	@BeforeSuite
	public void configload() throws IOException {

		FileInputStream file = new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(file);

		String reportFile = "reports/ExtentReport.html";
		spark = new ExtentSparkReporter(reportFile);

		reporter = new ExtentReports();
		reporter.attachReporter(spark);


	}
	public String takeScreenshot(String fileName) {
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String path = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
	    try {
	        FileUtils.copyFile(src, new File(path));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return path;
	}
	
	@AfterSuite
	public void tearDown() {

		driver.quit();
		reporter.setSystemInfo("Browser", "Chrome");
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("Tester", "Arun");
		reporter.setSystemInfo("Environment", "QA");
		reporter.flush();
	}


}
