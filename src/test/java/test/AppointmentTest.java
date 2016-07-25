package test;

import helper.Helper;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;
import patient.Pateintvital;
import bookApointment.Appointment;
import framework.Login;

public class AppointmentTest {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.get("http://10.10.1.129:8080/web/cloudclinik/cc-login");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
 
  
	@Test(priority = 1)
	public void patientName() throws IOException, InterruptedException {
		Helper help = new Helper(driver);
		Appointment app = new Appointment(driver);
		Login log = new Login(driver);
		Thread.sleep(1000);;
		log.Logincredentials("974100232884", "infogistic@1");
		Thread.sleep(10000);
		Pateintvital vi = new Pateintvital(driver);
		vi.searchPatient();
		help.WindowHandles();
		Thread.sleep(1000);
		app.searchPatientName("test");
	    Thread.sleep(10000);
		app.clickSearchButton();
		Thread.sleep(20000);
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
		boolean res=app.noRecordFound();
		Assert.assertFalse(res);
		Thread.sleep(10000);
		vi.closeSearchPatient();
		Thread.sleep(1000);
	}
	
/*	@Test(priority = 2)
	public void searchNumber() throws IOException, InterruptedException {

		appointment app = new appointment(driver);
		Pateintvital vi = new Pateintvital(driver);
		vi.searchPatient();
		Helper help = new Helper(driver);
		help.WindowHandles();
		Thread.sleep(1000);;
		app.searchContactNumber("4310000");
		Thread.sleep(1000);;
		app.clickSearchButton();
		Thread.sleep(1000);;
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
		
		Assert.assertFalse(driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:allMessages")).isDisplayed());
		Thread.sleep(1000);;
		vi.closeSearchPatient();
		Thread.sleep(1000);;
	}
	
	@Test(priority = 3)
	public void searchMRNumber() throws IOException, InterruptedException {

		appointment app = new appointment(driver);
		Login log = new Login(driver);
		Pateintvital vi = new Pateintvital(driver);
		Helper help = new Helper(driver);
		help.WindowHandles();
		vi.searchPatient();
		Thread.sleep(1000);;
		app.searchMr("974100301865");
		Thread.sleep(1000);;
		app.clickSearchButton();
		Thread.sleep(1000);;
		Assert.assertFalse(driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:allMessages")).isDisplayed());
		
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
				
			 boolean res=app.noRecordFound();
		     Assert.assertFalse(res);
		 Thread.sleep(1000);
	     vi.closeSearchPatient();
	     Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void searchFileNumber() throws IOException, InterruptedException {

		appointment app = new appointment(driver);
		Pateintvital vi = new Pateintvital(driver);
		Helper help = new Helper(driver);
		help.WindowHandles();
		vi.searchPatient();
		Thread.sleep(1000);;
		app.searchFileNumber("12763");
		Thread.sleep(1000);;
		app.clickSearchButton();
		Thread.sleep(1000);;
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
		Assert.assertFalse(driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:allMessages"))
				.isDisplayed());
				
	    boolean res=app.noRecordFound();
		Assert.assertFalse(res);
		
		
		Thread.sleep(1000);;
		vi.closeSearchPatient();
		
	}
	
	@Test(priority = 5)
	public void searchID() throws IOException, InterruptedException {

		appointment app = new appointment(driver);
		Pateintvital vi = new Pateintvital(driver);
		Helper help = new Helper(driver);
		help.WindowHandles();
		vi.searchPatient();
		Thread.sleep(1000);;
		app.searchidy("456786");
		Thread.sleep(1000);;
		app.clickSearchButton();
		Thread.sleep(1000);
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
		Assert.assertFalse(driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:allMessages"))
				.isDisplayed());
	
	    boolean res=app.noRecordFound();
		Assert.assertFalse(res);
		
		Thread.sleep(10000);
		vi.closeSearchPatient();
		
	}
	
	
	@Test(priority = 6)
	public void searchAdvance() throws IOException, InterruptedException {

		appointment app = new appointment(driver);
		Pateintvital vi = new Pateintvital(driver);
		Helper help = new Helper(driver);
		help.WindowHandles();
		vi.searchPatient();
        Thread.sleep(1000);;
		app.selectGender(1);
		Thread.sleep(1000);;
		app.selectAgeFrom(0);
		app.selectAgeTo(5);
		app.selectAgeUnit("Month");
		Thread.sleep(1000);;
		app.clickSearchButton();
		Thread.sleep(1000);;
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
		Assert.assertFalse(driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:allMessages"))
				.isDisplayed());
		boolean res=app.noRecordFound();
		Assert.assertFalse(res);
		
		Thread.sleep(30000);
		vi.closeSearchPatient();
		
	}
	

	@Test(priority = 7)
	public void invalidMr() throws IOException, InterruptedException {

		appointment app = new appointment(driver);
		Pateintvital vi = new Pateintvital(driver);
		Helper help = new Helper(driver);
		help.WindowHandles();
		vi.searchPatient();
        Thread.sleep(1000);;
		app.searchMr("fud");
		Thread.sleep(1000);;
		app.clickSearchButton();
		Thread.sleep(1000);
		Assert.assertTrue(driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
				.isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:allMessages"))
				.isDisplayed());
		boolean res=app.noRecordFound();
		Assert.assertTrue(res);
		
		Thread.sleep(1000);
		vi.closeSearchPatient();
		
	}
      */
	
	   @Test(priority = 8)
	  	public void selectDates() throws IOException, InterruptedException {
	  		Helper help = new Helper(driver);
	  		Appointment app = new Appointment(driver);
	  		Pateintvital vi = new Pateintvital(driver);
	  		vi.searchPatient();
	  		help.WindowHandles();
	  		Thread.sleep(10000);
	  		app.selectYear(2017);
	  		Thread.sleep(10000);
	  		app.selectmonts("May");
	  		Thread.sleep(20000);
	  		app.selectDate("15");
	  	    Thread.sleep(10000);
	  		app.clickSearchButton();
	  		Thread.sleep(10000);
	  		Assert.assertTrue(driver
	  				.findElement(
	  						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_head"))
	  				.isDisplayed());
	  		boolean res=app.noRecordFound();
	  		Assert.assertFalse(res);
	  		Thread.sleep(10000);
	  		vi.closeSearchPatient();
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
