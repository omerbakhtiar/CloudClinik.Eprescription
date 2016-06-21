package test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import patient.Pateintvital;
import bookApointment.Appointment;
import framework.Login;


public class Testing {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.get("http://192.168.1.16:8080/web/cloudclinik/cc-login");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	   @Test(priority=1)
	   public void test() throws IOException, InterruptedException{
	   Appointment app=new Appointment(driver); 
	  	Login log=new Login(driver);
		Thread.sleep(5000);
		log.Logincredentials("974100232884","infogistic@1");
		Thread.sleep(10000);
		Pateintvital vi = new Pateintvital(driver);
		vi.searchPatient();
		Thread.sleep(20000);
}

	  @Test(priority=2)
	  public void SearchByName() throws Exception {
	    driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:PatientName")).clear();
	    driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:PatientName")).sendKeys("test");
	    driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn")).click();
	    Thread.sleep(1000);
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

