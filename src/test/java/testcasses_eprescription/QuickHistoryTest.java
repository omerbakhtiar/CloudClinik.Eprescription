package testcasses_eprescription;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.QuickHistory;

public class QuickHistoryTest {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	@Test(priority = 1)
	public void verifyMrNumber() throws IOException, InterruptedException {
		Thread.sleep(10000);
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(20000);
		driver.manage().window().maximize();

		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		boolean result = his.clickVisitFomDate("10-May-2016");
		Thread.sleep(10000);
		org.testng.Assert.assertTrue(result);

		his.clickVisitToDate("19-July-2017");
		Thread.sleep(10000);

		his.clickSearch();
		Thread.sleep(10000);

		boolean res = his.clickSoap();
		Thread.sleep(10000);
		org.testng.Assert.assertTrue(res);

		Thread.sleep(10000);
		his.closePdf();

		Thread.sleep(20000);
		his.close();

	}

	@Test(priority = 2)
	public void invalidDates() throws InterruptedException {
		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		boolean result = his.clickVisitFomDate("10-May-2018");
		Thread.sleep(10000);
		org.testng.Assert.assertTrue(result);

		his.clickVisitToDate("19-July-2020");
		Thread.sleep(10000);

		his.clickSearch();
		Thread.sleep(10000);

		String s = his.errorMessage();

		org.testng.Assert.assertTrue(s.contains("No record"));

		Thread.sleep(10000);
		his.close();

	}

	@Test(priority = 3)
	public void AllClinic() throws InterruptedException, IOException {

		Thread.sleep(10000);
		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		his.clickVisitFomDate("10-May-2016");
		Thread.sleep(10000);

		his.clickVisitToDate("19-July-2016");
		Thread.sleep(10000);

		his.clickSearch();
		Thread.sleep(10000);

		int n1 = his.getTableSize();

		Thread.sleep(1000);
		his.clickClinics();
		Thread.sleep(10000);
		his.clickSearch();

		Thread.sleep(20000);
		int n2 = his.getTableSize();

		org.testng.Assert.assertTrue(n1 < n2);
		Thread.sleep(20000);
		his.close();

	}

/*	  @AfterClass(alwaysRun = true)
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
