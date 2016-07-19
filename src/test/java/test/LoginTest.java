package test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import framework.Login;

public class LoginTest {

	WebDriver driver;
	private ArrayList<WebElement> divs = new ArrayList<WebElement>();
	private ArrayList<WebElement> subdivs = new ArrayList<WebElement>();

	@BeforeClass
	public void beforeTest() {
	driver = new FirefoxDriver();
	}

	@Test(priority=1)
	public void Login() throws IOException, InterruptedException {
		
		driver.get("http://10.10.1.85:8080/web/cloudclinik/cc-login");
		Thread.sleep(10000);
		Login log = new Login(driver);
		log.RegisterLink();
		Thread.sleep(5000);
		log.Logincredentials("9213053774", "infogistic1");
         Thread.sleep(50000);
		WebElement condition = driver
				.findElement(By.id("_PatientHeader_WAR_CloudClinikportlet_:header_form:patient_header"));
		Assert.assertTrue(condition.isDisplayed());
		Thread.sleep(5000);
		
	}
	
	
/*	@Test(priority=2)
	public void NotLogin() throws IOException, InterruptedException{
		
		Thread.sleep(5000);
		//driver = new FirefoxDriver();
		driver.get("http://10.10.1.85:8080/web/cloudclinik");	
		Login log = new Login(driver);
		log.RegisterLink();
		Thread.sleep(5000);
		log.Logincredentials("testuser", "infogist");
		Thread.sleep(10000);
		divs=(ArrayList<WebElement>) driver.findElement(By.className("dockbar-split")).findElement(By.className("cloudclinik_mainDiv")).
				findElements(By.tagName("div"));
		
		String condition =(divs.get(12).getText().toString());
		Assert.assertFalse(condition.contentEquals(" Invalid Credentials."));
		Thread.sleep(5000);	
	}

	@Test(priority=3)
	 public void forGetPassword() throws IOException, InterruptedException{
		 
		 
		driver.get("http://10.10.1.85:8080/web/cloudclinik");	
		Login log = new Login(driver);
		log.RegisterLink();
		Thread.sleep(10000);
		boolean value= driver.findElement(By.linkText("Forgot Password")).isDisplayed();
		Assert.assertTrue(value);	 
	 }
	 */
	
	 

		
}
	



