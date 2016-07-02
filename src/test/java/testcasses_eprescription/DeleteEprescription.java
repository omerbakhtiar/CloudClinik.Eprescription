package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class DeleteEprescription {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	boolean result;

	@Test(priority = 1)
	public void deleteComplaints() throws InterruptedException, IOException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(10000);
		sr.selectCancel();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		sr.selectSeenPatient("Newone");
		Thread.sleep(10000);
		sr.deleteComplaints();
	}
	
	@Test(priority=2)
	public void deleteDiease() throws InterruptedException{
		Thread.sleep(1000);
		sr.deleteDiseases();
	}
	
	@Test(priority=3)
	public void deleProcedure() throws InterruptedException{
		Thread.sleep(1000);
		sr.deleteProcedure();
	}
	
	@Test(priority=4)
	public void deleteLab() throws InterruptedException{
		Thread.sleep(10000);
		sr.deleteLabSet();
		
	}
	
	@Test(priority=5)
	public void deleteMedicine() throws InterruptedException{
		Thread.sleep(1000);
		sr.deleteMedicine();
	}
	
	@Test(priority=6)
	public void deleteDiet() throws InterruptedException{
		Thread.sleep(1000);
		sr.deleteDiet();
	}
	
	@Test(priority=7)
	public void deleteDoctorNotes() throws InterruptedException{
		Thread.sleep(1000);
		sr.deleteDoctorNotes();
	}
	
	@Test(priority=8)
	public void deleteBillingNote() throws InterruptedException{
		Thread.sleep(1000);
		sr.deleteBillingNote();
		Thread.sleep(1000);
		sr.clickUpdate();
	}
	
}


