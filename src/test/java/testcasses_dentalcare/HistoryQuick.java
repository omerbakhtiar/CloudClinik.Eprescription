package testcasses_dentalcare;

import helper.Helper;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import prescription.Epres;
import dentalcare.QuickHistory;

public class HistoryQuick {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	QuickHistory his = new QuickHistory(driver);

	@Test(priority = 1)
	public void QuickHistory() throws IOException, InterruptedException {
		sr.Searching("974100232886", "infogistic@1", " 974100301865");
		Thread.sleep(10000);
		his.clickQuickHistory();
	/*	Thread.sleep(10000);
		his.clickVisitDate();
		Thread.sleep(10000);
		his.selectMonth("Jun");
		Thread.sleep(1000);
		his.selectYear("2016");
		Thread.sleep(10000);
		his.selectDate(20);*/
        Thread.sleep(10000);
    	his.close();
	}

	@Test(priority = 2)
	public void toDate() throws InterruptedException {
/*		Thread.sleep(10000);
		his.clickVistiToDate();
		Thread.sleep(10000);
		his.selectMonth("Sep");
		Thread.sleep(1000);
		his.selectYear("2019");
		Thread.sleep(10000);
		his.selectDate(21);
		Thread.sleep(10000);
		his.clickSearch();
		Thread.sleep(1000);
		Assert.assertFalse(his.verifyTable());
		Thread.sleep(1000);*/
	}
	
	@Test(priority = 3)
	public void allClinick() throws InterruptedException {
	/*	Thread.sleep(10000);
		his.clickQuickHistory();
		Thread.sleep(10000);
		his.clickAllclinic();
		Thread.sleep(1000);*/
		//his.close();
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
