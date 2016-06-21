package testcasses_eprescription;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import ePrescriptionM.CloudClinik.Eprescription.Epres;





public class Eprescription {

	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	 
	 
	@BeforeClass
	public void beforeClass() {
		

	}

	/*@Test(priority = 1)
	public void verifyMrNumber() throws IOException, InterruptedException {
		Thread.sleep(20000);
		String s = sr.Searching();
		Thread.sleep(20000);
		driver.manage().window().maximize();

		QuickHistory his = new QuickHistory(driver);
		his.clickQuickHistory();
		Thread.sleep(20000);

		his.clickVisitFomDate("10-May-2016");
		Thread.sleep(10000);
		
		his.clickVisitToDate("19-July-2017");
		Thread.sleep(10000);
		
		his.clickSearch();
		Thread.sleep(10000);
		
		his.clickSoap();
		
	}
*/
	/*
	 * @Test(priority=1) public void verifyMrNumber() throws IOException,
	 * InterruptedException { Thread.sleep(20000); String s = sr.Searching();
	 * Assert.assertTrue(s.contains("9213061292")); Thread.sleep(20000);
	 * HistorEdit his=new HistorEdit(driver); his.selectHistory();
	 * Thread.sleep(20000); his.searchMr("9213061292"); Thread.sleep(10000);
	 * his.searchButton(); Thread.sleep(20000);
	 * driver.manage().window().maximize(); Thread.sleep(10000);
	 * his.selectCalender();
	 * 
	 * }
	 * 
	 * 
	 * /* @Test(priority=1) public void verifyMrNumber() throws IOException,
	 * InterruptedException { Thread.sleep(20000); String s = sr.Searching();
	 * Assert.assertTrue(s.contains("9213061292")); Thread.sleep(20000); }
	 * 
	 * @Test(priority=2) public void changeInsurance() throws IOException,
	 * InterruptedException { sr.selectInsurance(); Thread.sleep(10000);
	 * sr.selectInsuranceOption(); Thread.sleep(20000); }
	 */

/*	  @Test(priority=1)
	  public void insertFavoriteSearchDiease() throws InterruptedException, IOException{
			String s = sr.Searching();
			Thread.sleep(20000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			sr.clickAddDiease();
			Thread.sleep(1000);
			sr.adddieaseData("E56.1",0);
			Thread.sleep(1000);
			sr.adddieaseData("F54",1);
		    Thread.sleep(10000);
	  }
	
	  @Test(priority=2)
	  public void insertManualDiease() throws InterruptedException, IOException{
		  Epres ep=new Epres(driver);
			ep.clickFavoriteDiease();
			Thread.sleep(1000);
			ep.searchDiseaseFovrite("K02.1");
			Thread.sleep(1000);
			ep.clickFavoriteDieaseSearch();
			Thread.sleep(1000);
			ep.selectFavoriteDiease("K02.1");
			Thread.sleep(1000);
			ep.closeFavoriteDieasePopUp();
			Thread.sleep(1000);
		  
	  }*/
	
	  @Test(priority=3)
	  public void insertManualProcedure() throws InterruptedException, IOException{
/*		String s = sr.Searching();
		Thread.sleep(20000);
		driver.manage().window().maximize();*/
		/*sr.addProcedureTreatmentButton();
		Thread.sleep(1000);
		sr.addManualProcedureData("GEN07", 0);
		Thread.sleep(1000);
		sr.addProcedureNotes("testing notes", 0);
		Thread.sleep(1000);
		sr.addProcedureQuantity(10,0);*/
		  
	  }
	
	  
	  
	/*  @Test(priority=4)
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
		sr.addProcedureNotes("testing notes", 1);
		Thread.sleep(1000);
		sr.addProcedureQuantity(10,1);
		  
	  }
	*/
	/*  @Test(priority=5)
	  public void insertLabManual() throws InterruptedException, IOException{
		 // 48378-4 
		  sr.Searching();
		  implicitWait(driver);
		  sr.addLabSetButton();
		  Assert.assertTrue(sr.addLabSetData(0,"48378-4 "));
		  Thread.sleep(10000);
		  sr.insertLabInstruction("test",0);
		  sr.clickLabRC(0);
		  sr.insertCommentsLab(0, "testing comments");
		  Assert.assertTrue(sr.insertResultLab(0,"labs result"));
	  }
	  
	  @Test(priority=6)
	  public void insertLabFavorite() throws InterruptedException, IOException{
		  Thread.sleep(1000);
		  sr.clickFavoriteLab();
		  Thread.sleep(10000);
		  Assert.assertTrue(sr.FavoriteLabPopupDisplayed());
		  Thread.sleep(1000);
		  sr.searchFavoriteLabData("1002");
		  Thread.sleep(1000);
		  sr.clickSearchFavoriteLab();
		  Thread.sleep(1000);
		  sr.selectFavoirteLabSearch("1002");
		  Thread.sleep(1000);
		  sr.closeFavoriteLabPopUp();
		  Thread.sleep(7000);
		  sr.insertLabInstruction("test",1);
	  }*/
	  
	  @Test(priority=7)
	  public void insertLabMedicine() throws InterruptedException, IOException{
		  sr.Searching();
		  Thread.sleep(1000);
		  sr.clickAddMedicine();
		  Thread.sleep(1000);
		  sr.insertMedcineData("AUGME4 : AUGMENTIN EfTb 375mg  20eftb",0);
		  Thread.sleep(1000);
		  Assert.assertTrue(sr.outOfStockMessage(0));
		  sr.insertDoseUnit("1",0);
		  Thread.sleep(1000);
		  sr.insertMedicineFrequency("before meals");
		  Thread.sleep(1000);
		  sr.insertMedicineRoute(0," intracoelomic");
		  Thread.sleep(1000);
		  sr.insertMedicineRfills(10,0);
		  Thread.sleep(1000);
		  sr.insertDuration(10,0);
		  Thread.sleep(1000);
		  
	  }
	
	  
	  public static void implicitWait(WebDriver driver){
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
