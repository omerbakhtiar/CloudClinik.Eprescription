package testcasses_eprescription;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.LabHistory;
import prescription.MedicalCertificate;

@Test
public class medicalCertificate {
	
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
   public void enterData() throws InterruptedException, IOException {


		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		MedicalCertificate med=new MedicalCertificate(driver);
		med.selectCertificate();
		Thread.sleep(10000);
		
		med.insertNotes("testing notes");
		Thread.sleep(10000);
		
		med.insertLeaveDays("12");
		org.testng.Assert.assertTrue(driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:j_idt186")).isDisplayed());
		Thread.sleep(10000);
		med.submit();
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
