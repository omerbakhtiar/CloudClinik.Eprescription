package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import prescription.Epres;


public class FavoriteEprescription {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	double weight;
	double dosage;

	@BeforeTest
	public void call() throws IOException, InterruptedException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void insertCompDNotes() throws InterruptedException, IOException {
		Thread.sleep(1000);
		sr.insertComplaints("Joint Pain");
		Thread.sleep(1000);
		sr.insertDoctorNotes("Pain in muscles");
		Thread.sleep(1000);
	}
	
	@Test(priority=2)
	public void insertFavoriteDieases() throws InterruptedException{
		sr.clickFavoriteDiease();
		Thread.sleep(1000);
		sr.searchDiseaseFovrite("K02.1");
		Thread.sleep(1000);
		sr.clickFavoriteDieaseSearch();
		Thread.sleep(1000);
		sr.selectFavoriteDiease("K02.1");
		Thread.sleep(1000);
		sr.closeFavoriteDieasePopUp();
		Thread.sleep(1000);
	  
	}
	
	  @Test(priority=3)
	  public void insertFavoriteProcedure() throws InterruptedException, IOException{
		sr.addFavoriteProcedureButton();
		Thread.sleep(1000);
		sr.addFvoriteProcedureData("INS65");
		Thread.sleep(1000);
		sr.searchFavorieProceudreClick();
		Thread.sleep(1000);
		sr.selectSearchProcedure("INS65");
		Thread.sleep(1000);
		sr. closeFavoriteProcedurePopUp();
		Thread.sleep(10000);
		sr.addProcedureNotes("testing notes", 0);
		Thread.sleep(1000);
		sr.addProcedureQuantity(10,0);
		Thread.sleep(10000);
		  
	  }
	  
	  @Test(priority=4)
	  public void insertLabSetFavorite() throws InterruptedException, IOException{
		  Thread.sleep(1000);
		  sr.clickFavoriteLab();
		  Thread.sleep(1000);
		  sr.searchFavoriteLabData("1002");
		  Thread.sleep(1000);
		  sr.clickSearchFavoriteLab();
		  Thread.sleep(10000);
		  sr.selectFavoirteLabSearch("1002");
		  Thread.sleep(1000);
		  sr.closeFavoriteLabPopUp();
		  Thread.sleep(7000);
		  sr.insertLabInstruction("test",0);
		  Thread.sleep(10000);
	  }
	  
		@Test(priority = 5)
		public void insertLabSetInsComm() throws InterruptedException {
			Thread.sleep(1000);
			sr.clickLabRC(0);
			Thread.sleep(1000);
			sr.insertLabSetComments(0, "result of lab");
			Thread.sleep(1000);
			sr.insertLabSetResult(0,"test");
			Thread.sleep(1000);
		    sr.clickLabRC(0);
		}
	  
	  
	  @Test(priority=6)
	  public void insertLabFavorite() throws InterruptedException{
		  Thread.sleep(10000);
		  sr.clickFavoriteLab();
		  Thread.sleep(10000);
		  Assert.assertTrue(sr.FavoriteLabPopupDisplayed());
		  Thread.sleep(1000);
		  sr.searchFavoriteLabData("FLAB01");
		  Thread.sleep(1000);
		  sr.clickSearchFavoriteLab();
		  Thread.sleep(1000);
		  sr.selectFavoirteLabSearch("FLAB01");
		  Thread.sleep(1000);
		  sr.closeFavoriteLabPopUp();
		  Thread.sleep(7000);
		  sr.insertLabInstruction("testing lab",1);
		  
	  }
	  
		@Test(priority = 7)
		public void insertLabRComments() throws InterruptedException {
			sr.clickLabRC(1);
			Thread.sleep(1000);
			sr.insertCommentsLab(1, "lab comments");
			Thread.sleep(100);
			sr.insertResultLab(1, "test lab");
			Thread.sleep(1000);
			sr.clickLabRC(1);
			Thread.sleep(10000);
		}
	  
	  
		@Test(priority = 8)
		public void insertMedicineFavorite() throws InterruptedException {
			Thread.sleep(10000);
			sr.clickFavoriteMedicine();
			Thread.sleep(1000);
			sr.insertFavoriteMedicineData("panadol ADVANCE");
			Thread.sleep(1000);
			sr.clickSearchFavoriteMedicine();
			Thread.sleep(10000);
			sr.clickFavoriteMedicineSRecord("panadol");
			Thread.sleep(10000);
			sr.closeFavoriteMedicine();
			Thread.sleep(10000);
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
		public void insertDiet() throws InterruptedException{
			double str;
			double result;
			sr.insertDietInstruction("diet test");
			Thread.sleep(1000);
			sr.insertBillingNote("test data");
			Thread.sleep(10000);
			sr.clickDosageCalculator();
			Thread.sleep(1000);
			result=sr.selectDosageCalType("Clark'sRule",40,10);
			System.out.println(result);
		    sr.insertAdultDosage(10);
			Thread.sleep(10000);
			str=sr.getCalDoseValue();
			Thread.sleep(10000);
			Assert.assertEquals(str,result);
			Thread.sleep(1000);
			sr.closeDrugDosageCalculator();
				
		}
		
		@Test(priority=10)
		public void calculateDosageWeight() throws InterruptedException{
			Thread.sleep(1000);
			sr.clickDosageCalculator();
			Thread.sleep(1000);
			double result=sr.selectDosageCalType("DosageBasedonWeight",40,20);
			Thread.sleep(10000);
			sr.insertDosePerUnit(20);
			Thread.sleep(1000);
			double str=sr.getCalDoseValue();
			Thread.sleep(10000);
			Assert.assertEquals(str,result);
			Thread.sleep(10000);
			sr.closeDrugDosageCalculator();
		}
		
		@Test(priority=11)
		public void caclulateYoungsRule() throws InterruptedException{
			double str;
			Thread.sleep(1000);
			sr.clickDosageCalculator();
			double result;
			result=sr.selectDosageCalType("Young'sRule",40,10);
			Thread.sleep(20000);
			sr.insertAdultDosage(10);
			Thread.sleep(10000);
			str=sr.getCalDoseValue();
			Thread.sleep(10000);
			Assert.assertEquals(str,result);
			Thread.sleep(1000);
			sr.closeDrugDosageCalculator();
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
