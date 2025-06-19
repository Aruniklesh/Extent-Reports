package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.BaseTest;

public class SampleTest extends BaseTest{
	@Test(priority = 1)
	public void enteremail() throws Exception {
	    String username = prop.getProperty("username");
	    test = reporter.createTest("Clicking the email and giving the input button");

	    wait = new WebDriverWait(driver, 10);
	    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	    email.sendKeys(username);

	    test.log(Status.INFO, "Entered email: " + username);
	    String emailScreenshot = takeScreenshot("enteremail");
	    test.addScreenCaptureFromPath(emailScreenshot);
	}

	@Test(priority = 2)
	public void enterpassword() throws Exception {
	    test = reporter.createTest("Clicking the Password button");
	    String password = prop.getProperty("password");

	    driver.findElement(By.name("password")).sendKeys(password);
	    test.log(Status.INFO, "Entered password: " + password);
	    test.log(Status.WARNING, "Password is visible: " + password);
	    String passwordScreenshot = takeScreenshot("enterpassword");
	    test.addScreenCaptureFromPath(passwordScreenshot);

	    // Clicking Login
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	    test = reporter.createTest("Clicking the login button");
	    test.log(Status.INFO, "Login success");
	    String loginScreenshot = takeScreenshot("loginbutton");
	    test.addScreenCaptureFromPath(loginScreenshot);
	}}
