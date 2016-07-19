package testcasses_eprescription;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.LabSet;
import prescription.VitalHistory;

public class Vital {

	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	LabSet set = new LabSet(driver);
	VitalHistory vital = new VitalHistory(driver);

	@BeforeTest
	public void fun() throws IOException, InterruptedException{
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(20000);

		driver.manage().window().maximize();
		Thread.sleep(20000);
	}
	
	
	
	@Test(enabled=false)
	public void testDates() throws IOException, InterruptedException {
		vital.clickVitalHistory();
		Thread.sleep(10000);
		vital.clickAddPatient();
		Thread.sleep(1000);
		vital.insertTemp("100");
		Thread.sleep(1000);
		vital.selectTempPoint("Ear");
		Thread.sleep(1000);
		vital.insertPulse("10");
		vital.insertBloodSugarData("20");
		vital.insertBpFirst("140");
		vital.insertBpSecond("110");
		vital.insertHeight("10");
		vital.clickFasting();
		vital.insertRespRate("30");
		vital.insertNotes("temp notes");
		vital.insertWeight("40");
		Thread.sleep(10000);
		vital.saveData();
		Thread.sleep(10000);
		vital.closeAddPatientVital();
		
	}

	@Test(enabled=false)
	public void search() throws InterruptedException {
		vital.clickVitalHistory();
		Thread.sleep(10000);
		vital.insertFromDate("06-May-2016");
		Thread.sleep(1000);
		vital.visitToDate("08-Jun-2016");
		Thread.sleep(1000);
		vital.search();
		Thread.sleep(10000);
		vital.closeVitalHistory();
	}
	
	
	@Test(enabled=true)
	public void testTable() throws IOException, InterruptedException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(20000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		vital.clickVitalHistory();
		Thread.sleep(10000);
		vital.getTableData("05-Jun-2016 09:16 AM"); 
		Thread.sleep(1000);
		boolean result =vital.verifyTableData("05-Jun-2016 09:16 AM", 
				"100.0 F, Ear","140/110 mmHg","10 bpm", "30 /min","10.0 cm","40.0 kg","4000.0","temp notes", 
				"20 Random");
	//	Assert.isTrue(result);
		//vital.viewTableData();
		
	}
	
	
/*	 @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
		String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }*/

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
