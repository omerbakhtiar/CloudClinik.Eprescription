package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class FavoriteOrder {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	OrderSet order = new OrderSet(driver);
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	@Test(priority = 1)
	public void complaints() throws IOException, InterruptedException {
		String s = sr.Searching();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		order.selectOrderSet();
		Thread.sleep(10000);
		order.clickAddNew();
		Thread.sleep(10000);
		order.setComplaints("nauzia");
		Thread.sleep(10000);
		order.setDoctorNotes("favorite notes");
		Thread.sleep(1000);
		order.setOrderSetName("favorite");
		Thread.sleep(20000);
		order.clickTemplates();
		Thread.sleep(10000);
		order.addTemplate();
		Thread.sleep(1000);
		order.closeNotesTemplate();
		Thread.sleep(10000);

	}

	@Test(priority = 2)
	public void setDisease() throws InterruptedException {
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

	}
   
	@Test(priority = 3)
	public void setProcedureDataFavorite() throws InterruptedException {
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
		order.addProcedureNote("testing note for favorite procedure");
		Thread.sleep(10000);
	}
	

	@Test(priority = 4)
	public void setLab() throws InterruptedException {
		order.clickFavoriteLab();
		Thread.sleep(10000);
		order.searchFavoriteLab("FLABSET01");
		Thread.sleep(10000);
		order.searchFavoriteLab();
		Thread.sleep(1000);
		order.selectFavoriteSearchValueLabandSet("FLABSET01");
		Thread.sleep(10000);
		order.closeLabFavorite();
		Thread.sleep(10000);
		order.setLabsetInstructions("test by favorite lab set instruction", 0);
		Thread.sleep(1000);
		order.clickFavoriteButtonLab();
		Thread.sleep(10000);
		order.searchFavoriteLab("FLAB01");
		Thread.sleep(1000);
		order.searchFavoriteLab();
		Thread.sleep(1000);
		order.selectFavoriteSearchValueLabandSet("FLAB01");
		Thread.sleep(20000);
		order.closeLabFavorite();
		Thread.sleep(10000);
		order.setLabsetInstructions("test by favorite lab instructions", 1);
		Thread.sleep(10000);
	}

	@Test(priority = 5)
	public void setFavoriteMedicine() throws InterruptedException {
		order.clickFavoriteMedicine();
		Thread.sleep(10000);
		order.setSearchFavoriteValueMedicine("Advance");
		Thread.sleep(1000);
		order.searchMedButton();
		Thread.sleep(10000);
		order.selectFavoriteMedSearchData(": panadol");
		Thread.sleep(1000);
		order.closefavoriteMedPopUp();
		Thread.sleep(10000);
		order.insertDosageUnit("10", 0);
		Thread.sleep(10000);
		order.setMedicineFrequency(0, 1);
		Thread.sleep(1000);
		order.setMedicineDuration("10", 0);
		Thread.sleep(1000);
		order.setMedicineRoute(2);
		Thread.sleep(1000);
		order.save();
		Thread.sleep(10000);
		order.closeOrderSetDiaglog();
	}
	
	  @Test(priority=6)
 	  public void applyFavoriteOrderSet() throws InterruptedException{
 		  order.selectOrderSet();
 		  Thread.sleep(10000);
 		  order.applyOrderSet("favorite");
 		  Thread.sleep(10000);
 		  order.closeOrderSetMainWindow();
 		  Thread.sleep(1000);
 		  driver.close();
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
