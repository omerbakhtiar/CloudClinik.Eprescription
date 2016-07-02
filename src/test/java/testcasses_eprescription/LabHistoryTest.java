package testcasses_eprescription;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.LabHistory;
import prescription.LabSet;

public class LabHistoryTest {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
    LabSet set=new LabSet(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	@Test(enabled=false)
	public void insertLabHistory() throws IOException, InterruptedException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(20000);

		driver.manage().window().maximize();
		Thread.sleep(20000);

		LabHistory lab = new LabHistory(driver);
		lab.selectLabHis();
		Thread.sleep(20000);

		lab.selectFromDate("15-May-2016");
		Thread.sleep(10000);

		lab.selectVisitDate("16-May-2017");
		Thread.sleep(10000);

		lab.Search();
		Thread.sleep(10000);

		lab.AddResult();
		Thread.sleep(20000);
        lab.insertResult("12");
        Thread.sleep(10000);
		lab.insertComments("newcomments");
		Thread.sleep(2000);

		lab.submitResult();
		
		Thread.sleep(10000);
		lab.close();
		driver.close();
		Thread.sleep(1000);

	}

	@Test(enabled=false)
	public void testTable() throws IOException, InterruptedException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(20000);

		driver.manage().window().maximize();
		Thread.sleep(20000);

		LabHistory lab = new LabHistory(driver);
		lab.selectLabHis();
		Thread.sleep(2000);

		lab.clickOnLabSet(3);
		Thread.sleep(2000);
		
        boolean result= lab.getAddedResultSet("1","tesing comments for labset");
	    
	   // System.out.println(result);
		
	}

	@Test(enabled=false)
	public void testSeenPatient() throws IOException, InterruptedException{
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
	
		Thread.sleep(20000);

		driver.manage().window().maximize();
		Thread.sleep(20000);
        sr.selectCancel();
        Thread.sleep(10000);
		LabHistory lab = new LabHistory(driver);
		lab.selectSeenPatient("Newone");
		Thread.sleep(20000);
	    set.select();
	    Thread.sleep(20000);
	    boolean result=set.getData("1","testing comments");
	    org.testng.Assert.assertTrue(result);
	}
	
	@Test(priority=2)
	public void insertLabSet() throws IOException, InterruptedException{
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		
		Thread.sleep(20000);

		driver.manage().window().maximize();
		Thread.sleep(20000);

		LabHistory lab = new LabHistory(driver);
		lab.selectLabHis();
		Thread.sleep(2000);

		lab.clickOnLabSet(0);
		Thread.sleep(2000);
		
		lab.AddResutlLabSet(0);
		Thread.sleep(10000);
		lab.AddRecordLabSet("1");
		lab.AddComments("testing comments");
		Thread.sleep(1000);
		lab.AddResultLabSet();	
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
