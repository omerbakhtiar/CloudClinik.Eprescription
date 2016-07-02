package testcasses_dentalcare;

import helper.Helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import dentalcare.Dentalcare;
import dentalcare.OrderSet;
import dentalcare.HistoryEdit;

public class HistoryEdt {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Dentalcare dental = new Dentalcare(driver);
	OrderSet set = new OrderSet(driver);
	HistoryEdit his = new HistoryEdit(driver);

	@Test(priority = 1)
	public void orderSet() throws IOException, InterruptedException {
		 Helper.implicitWait(driver);
		sr.Searching("974100232886", "infogistic@1", " 974100301865");
	    Thread.sleep(10000);
	    his.clickHistoryEdit();
	    Thread.sleep(1000);
		his.insertMrNumber("974100301865");
		Thread.sleep(1000);
		his.search();
		Thread.sleep(1000);
		Assert.assertFalse(his.tableDisplayed("No record Found"));
	}
	
	@Test(priority=2)
	public void currentPatient() throws InterruptedException{
		Thread.sleep(1000);
		his.clickCurrentPatient();
		Thread.sleep(1000);
		his.clickCurrentErpes();
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
