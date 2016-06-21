package testcasses_eprescription;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class TestOrder {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	 OrderSet order=new OrderSet(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
    @Test(priority=1)
  public void testSet() throws IOException, InterruptedException {
	  String s = sr.Searching();
	  Thread.sleep(20000);
	  driver.manage().window().maximize();
	  Thread.sleep(1000);
	
	  order.selectOrderSet();
	  Thread.sleep(10000);
	  order.clickAddNew();
	  Thread.sleep(30000);
	  order.setComplaints("nauzia");
	   Thread.sleep(20000);
      Thread.sleep(20000);
      order.clickTemplates();
      Thread.sleep(10000);
      order.addTemplate();
      Thread.sleep(1000);
      order.closeNotesTemplate();
      Thread.sleep(20000);
      Thread.sleep(10000);
      order.setDoctorNotes("test notes");
      Thread.sleep(1000);
      order.setOrderSetName("dengue");
      Thread.sleep(10000);
 
  }
  /*
  @Test(priority=2)
  public void setDisease() throws InterruptedException{
	  order.addDisease();
	  Thread.sleep(1000);
	  order.addDieaseData("Cough");
	  Thread.sleep(1000);
	  order.clickFavoriteDisease();
	  Thread.sleep(1000);
	  order.favouriteDieaseData("K02.1");
	  Thread.sleep(10000);
	  order.favouriteSearch();
	  Thread.sleep(1000);
	  order.selectFavouriteSearch();
	  Thread.sleep(10000);
	  order.closeDialogButtonFavorite();
	  Thread.sleep(1000);
	  order.save();
	  Thread.sleep(100000);
	  order.closeOrderSetDiaglog();
  }*/
  
/*   @Test(priority=3)
   public void setProcedureData() throws InterruptedException{
	   order.addProcedureClick();
	   Thread.sleep(10000);
	   order.addProcedureData("GEN03 : Emergency Call");
	   Thread.sleep(1000);
	   order.addProcedureNote("testing note for the procedure");
	   Thread.sleep(1000);
	   order.clickFavoriteProcedure();
	   Thread.sleep(1000);
	   order.sendFavoriteProcedure("INS65");
	   Thread.sleep(2000);
	   order.searchFavoriteSearchProcedure();
	   Thread.sleep(1000);
	   order.selectFarovriteSearchDataProcedure();
	   Thread.sleep(1000);
	   order.selectFavoriteSearchClose();
	   Thread.sleep(10000);
	   order.setFavoriteProcedureNote("testing note for favorite procedure");
   }*/
	 
/*	 @Test(priority=4)
	 public void setLab() throws InterruptedException{
		 order.addLabButton();
		 Thread.sleep(10000);
		 order.labSetData("MLABSET01",0);
		 Thread.sleep(1000);
		 order.setLabsetInstructions("testing instructiong lab test manual",0);
		 Thread.sleep(2000);
		 order.addLabButton();
		 Thread.sleep(10000);
		 order.labSetData("Long Name of Manual Lab",1);
		 Thread.sleep(1000);
		 order.setLabsetInstructions("testing instructions lab test manual", 1);
		 Thread.sleep(1000);
		 order.clickFavoriteButtonLab();
		 Thread.sleep(10000);
		 order.searchFavoriteLab("FLABSET01");
		 Thread.sleep(10000);
		 order.searchFavoriteLab();
		 Thread.sleep(1000);
		 order.selectFavoriteSearchValueLabandSet("FLABSET01");
		 Thread.sleep(10000);
		 order.closeLabFavorite();
		 order.setLabsetInstructions("test by favorite lab set instruction", 2);
		 Thread.sleep(1000);
		 order.clickFavoriteButtonLab();
		 Thread.sleep(1000);
		 order.searchFavoriteLab("FLAB01");
		 Thread.sleep(1000);
		 order.searchFavoriteLab();
		 Thread.sleep(1000);
		 order.selectFavoriteSearchValueLabandSet("FLAB01");
		 Thread.sleep(20000);
		 order.closeLabFavorite();
		 order.setLabsetInstructions("test by favorite lab instructions", 3);
	 }
	 
	*/
	 
	 
	/*  @Test(priority=3)
  public void applyOrderSet() throws InterruptedException, IOException{
	  String s = sr.Searching();
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  Thread.sleep(1000);  
	  sr.selectCancel();
	  Thread.sleep(10000); 
	  LabHistory lab=new LabHistory(driver);
	  lab.selectSeenPatient("Buthina Yossif Al Tammimy");
	  
	
	 /* order.selectOrderSet();
	  Thread.sleep(10000);
	  order.applyOrderSet("newone");
	  Thread.sleep(10000);
	  order.closeOrderSetMainWindow();
	  */
	 
	 
	//*[@id="_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:0:selectFreq"]/div[3]/span
	 
    @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
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
