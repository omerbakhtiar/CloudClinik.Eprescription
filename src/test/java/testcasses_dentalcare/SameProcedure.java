package testcasses_dentalcare;

import helper.Helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prescription.Epres;
import dentalcare.Dentalcare;

public class SameProcedure {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Dentalcare dental = new Dentalcare(driver);

	@Test(priority = 1)
	public void orderSet() throws IOException, InterruptedException {
		sr.Searching("974100232886", "infogistic@1", " 974100301865");
		Helper.maximize(driver);
		Thread.sleep(1000);
		dental.setComplaints("nauzia");
		Thread.sleep(10000);
		dental.clickAdd();

	}

	@Test(priority = 2)
	public void setDoctorNotes() throws InterruptedException {
		dental.applyTemplates();
		Thread.sleep(1000);
		dental.setNoteTemplate("test");
		Thread.sleep(10000);
		dental.setDoctor("testing notes");
	}

	@Test(priority = 3)
	public void setPrimaryDiease() throws InterruptedException {
		Thread.sleep(10000);
		dental.clickAdd();
		Thread.sleep(1000);
		dental.setPrimaryDisease("E67.3", 0);

	}

	@Test(priority = 4)
	public void setProcedure() throws InterruptedException {
		Thread.sleep(1000);
		dental.setProcedure("GEN02", 0);
		Thread.sleep(10000);
		dental.setProcedure("678", 0);
	}

	@Test(priority = 5)
	public void save() throws InterruptedException {
		Thread.sleep(20000);
		dental.save();
		Thread.sleep(2000);
		Assert.assertTrue(dental
				.FMMMessage("Please enter only one procedure per row for group procedures. Please review your Prescription."));
	}

}
