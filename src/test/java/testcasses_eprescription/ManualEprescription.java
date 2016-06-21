package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ePrescriptionM.CloudClinik.Eprescription.Epres;

public class ManualEprescription {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void call() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	public void insertCompDNotes() throws InterruptedException, IOException {
		Thread.sleep(1000);
		sr.insertComplaints("Joint Pain");
		Thread.sleep(1000);
		sr.insertDoctorNotes("Pain in muscles");
	}

	@Test(priority = 2)
	public void insertManualDiease() throws InterruptedException, IOException {
		Thread.sleep(20000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		sr.clickAddDiease();
		Thread.sleep(1000);
		sr.adddieaseData("E56.1", 0);
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void insertManualProcedure() throws InterruptedException,
			IOException {
		Thread.sleep(20000);
		driver.manage().window().maximize();
		sr.addProcedureTreatmentButton();
		Thread.sleep(1000);
		sr.addManualProcedureData("GEN07", 0);
		Thread.sleep(10000);
		sr.addProcedureNotes("testing notes", 0);
		Thread.sleep(10000);
		sr.addProcedureQuantity(10, 0);
		Thread.sleep(10000);

	}

	@Test(priority = 4)
	public void insertLabManual() throws InterruptedException {
		sr.addLabSetButton();
		Thread.sleep(1000);
		Assert.assertTrue(sr.addLabSetData(0, "48378-4 "));
		Thread.sleep(1000);
		sr.insertLabInstruction("lab instruction", 0);
		Thread.sleep(10000);
	}

	@Test(priority = 5)
	public void insertLabRComments() throws InterruptedException {
		sr.clickLabRC(0);
		Thread.sleep(1000);
		sr.insertCommentsLab(0, "lab comments");
		Thread.sleep(100);
		sr.insertResultLab(0, "test lab");
		Thread.sleep(1000);
		sr.clickLabRC(0);
		Thread.sleep(10000);
	}

	@Test(priority = 6)
	public void insertLabSetManual() throws InterruptedException {
		sr.addLabSetButton();
		Thread.sleep(1000);
		Assert.assertTrue(sr.addLabSetData(1, "500 : lab Set 500"));
		Thread.sleep(1000);
		sr.insertLabInstruction("lab instruction set", 1);
		Thread.sleep(1000);
		sr.clickLabRC(1);

	}

	@Test(priority = 7)
	public void insertLabSetInsComm() throws InterruptedException {
		Thread.sleep(1000);
		sr.insertLabInstruction("lab instruction set", 0);
		Thread.sleep(1000);
		sr.insertLabSetComments(0, "result of lab");
		Thread.sleep(1000);
		sr.insertLabSetResult(0,"test");

	}

	@Test(priority = 8)
	public void insertMedicineManual() throws InterruptedException {
		sr.clickAddMedicine();
		Thread.sleep(1000);
		sr.insertMedcineData("AUGME4 : AUGMENTIN EfTb 375mg  20eftb", 0);
		Thread.sleep(1000);
		Assert.assertTrue(sr.outOfStockMessage(0));
		sr.insertDoseUnit("1", 0);
		Thread.sleep(1000);
		sr.insertMedicineFrequency("before meals");
		Thread.sleep(1000);
		sr.insertMedicineRoute(0, " intracoelomic");
		Thread.sleep(1000);
		sr.insertMedicineRfills(10, 0);
		Thread.sleep(1000);
		sr.insertDuration(10, 0);
		Thread.sleep(1000);
	}
	
	@Test(priority=9)
	public void calculateDosage(){
		
	}
	
	@Test(priority=10)
	public void insertDiet() throws InterruptedException{
		sr.insertDietInstruction("diet test");
		Thread.sleep(1000);
		sr.insertBillingNote("test data");
		
	}

}
