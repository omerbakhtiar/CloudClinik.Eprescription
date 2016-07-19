package testcasses_dentalcare;

import helper.Helper;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import dentalcare.Dentalcare;
import dentalcare.OrderSet;
import prescription.Epres;

public class Set {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Dentalcare dental = new Dentalcare(driver);
	OrderSet set = new OrderSet(driver);

	@Test(priority = 1)
	public void orderSet() throws IOException, InterruptedException {
		sr.Searching("974100232886", "infogistic@1", " 974100301865");
		help.maximize(driver);
		dental.clickOrderSet();
		Thread.sleep(1000);
	    set.clickNew();
	    Thread.sleep(1000);
		set.setOrderSetName("dental");
	}

	@Test(priority = 2)
	public void setComplaint() throws InterruptedException {
		set.setComlaintsSet("pain fom acute gigivitits over tooth");
		Thread.sleep(10000);
		set.selectComplaint();
		Thread.sleep(10000);

	}

	@Test(priority = 3)
	public void setDoctorNotes() throws InterruptedException {
		set.setDoctorNotes("testing notes");
		set.clickTemplate();
		set.applyTemplate("test");

	}

	@Test(priority = 4)
	public void setPrimaryDiease() throws InterruptedException {
		Thread.sleep(10000);
		set.insertDieases("E67.3 : Hypervitaminosis D");
		Thread.sleep(1000);
		set.selectDiease();
		Thread.sleep(10000);
	}

	@Test(priority = 5)
	public void setProcedure() throws InterruptedException {
		Thread.sleep(1000);
		set.insertProcedure("GEN07");
		Thread.sleep(10000);
		set.selectProcedure();
		Thread.sleep(10000);
		set.insertAdditionalDiagnosis("E67.3");
		Thread.sleep(10000);
		set.selectAdditionalDiagnosis();
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void insertMedcine() throws InterruptedException {
		set.clickAddMedcine();
		Thread.sleep(1000);
		set.insertMedicine("CAVED2", 0);
		Thread.sleep(1000);
		set.selectMedcine(0);
		Thread.sleep(1000);
		// CAVED2 : CAVED - S Tabs 60 tabs
		set.insertDuration(10);
		set.insertFrequency("qid: four times a day", 0);
		set.insertDuration(2);
		set.insertDose(3, 0);
		set.insertRoute(0, "npo: Nothing by mouth");
		Thread.sleep(9000);
		set.save();
		Thread.sleep(9000);
		set.cancel();
		Thread.sleep(1000);
		set.apply("dental");

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
