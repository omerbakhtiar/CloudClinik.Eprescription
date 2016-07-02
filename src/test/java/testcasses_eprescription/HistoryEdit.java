package testcasses_eprescription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prescription.HistorEdit;
import prescription.Epres;

public class HistoryEdit {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	/*
	 * @Test(priority = 1) public void verifyMrNumber() throws IOException,
	 * InterruptedException { String s = sr.Searching("974100232885", "infogistic@1"," 974100301865"); Thread.sleep(10000);
	 * HistorEdit his = new HistorEdit(driver); his.selectHistory();
	 * driver.manage().window().maximize(); Thread.sleep(1000);
	 * Assert.assertTrue(his.displayPopUp()); his.searchMr("974100301865");
	 * Thread.sleep(1000); his.searchButton(); Thread.sleep(10000);
	 * Assert.assertTrue(his.verifyTable());
	 * 
	 * }
	 * 
	 * @Test(priority = 2) public void verifyInvalidMrNumber() throws
	 * IOException, InterruptedException { String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
	 * Thread.sleep(10000); HistorEdit his = new HistorEdit(driver);
	 * his.selectHistory(); driver.manage().window().maximize();
	 * Thread.sleep(1000); Assert.assertTrue(his.displayPopUp());
	 * his.searchMr("86"); Thread.sleep(1000); his.searchButton();
	 * Thread.sleep(10000); Assert.assertTrue(his.verifyInavlidTable());
	 * Thread.sleep(1000);
	 * 
	 * }
	 */

	@Test(priority = 2)
	public void searchName() throws InterruptedException, IOException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(10000);
		HistorEdit his = new HistorEdit(driver);
		his.selectHistory();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Assert.assertTrue(his.displayPopUp());
		his.searchName("testuser");
		Thread.sleep(1000);
		his.searchButton();
		Thread.sleep(1000);
		Assert.assertTrue(his.verifyTable());
		Thread.sleep(1000);
		his.selectCurrent();
		Thread.sleep(1000);
		his.editPrescrition("18-Jun-2016");
		// his.close();

	}

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
