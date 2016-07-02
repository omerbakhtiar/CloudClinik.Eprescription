package testcasses_eprescription;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import prescription.Epres;

public class VerifyData {
	
	WebDriver driver=new FirefoxDriver();
	boolean result;
	Epres sr= new Epres(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	ArrayList<String> list = new ArrayList<String>() {{
	    add("PRE07 : Tx of Sensitive/Tooth");
	    add("GEN03 : Emergency Call");
	}};
	
	ArrayList<String> notes = new ArrayList<String>() {{
	    add("test");
	    add("testing 123");
	}};
	
	ArrayList<String> lab = new ArrayList<String>() {{
	    add("test");
	    add("testing 123");
	}};
	
	
	ArrayList<String> diag = new ArrayList<String>() {{
	    add("T40.7 : Cannabis (derivatives)");
	}};
	
	ArrayList<String> doz = new ArrayList<String>() {{
	    add("1.0");
	}};
	
	
	@Test(priority=1)
	public void verifyComplaint() throws IOException, InterruptedException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		sr.selectCancel();
		Thread.sleep(20000);
		sr.selectSeenPatient("1. Mr. Demo Pathologist ");
		
		Thread.sleep(10000);
	
	}
		/*sr.getComplaintData(list);
		Thread.sleep(20000);
		sr.getDoctorNotes("test congested tympanic membrane");
		Thread.sleep(10000);
	   }
	
	 @Test(priority=2)
	 public void verifyDieasesData() throws InterruptedException{
		  boolean result=sr.getDieasesData(list);
		  Assert.isTrue(result);
	 }
	 
	 @Test(priority=3)
	 public void verifyProcedureData(){
		 boolean pro=sr.getProcedureData(list,notes);
		 Assert.isLegal(pro);
	 }
	 */
	 
	/* @Test(priority=4)
	 public void verifyProcedureData() throws InterruptedException{
		 
		 //sr.clickOptionLabSet(2);
		 Thread.sleep(10000);
		 sr.verifyMedicineData(0);
		 sr.printData();
		 //boolean pro=sr.getLabData(list, notes);
		 //Assert.isLegal(pro);
	 }*/
	
	 @Test(priority=5)
	 public void verifyMedicine() throws InterruptedException{
		 Thread.sleep(1000);
		 sr.verifyMedicineData(0);
		 result=sr.verifyMedicine(diag,doz);
		 Thread.sleep(1000);
		 sr.printData();
		 System.out.println(result);
		 
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

