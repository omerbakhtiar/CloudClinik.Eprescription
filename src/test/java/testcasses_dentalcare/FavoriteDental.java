package testcasses_dentalcare;

import helper.Helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prescription.Epres;
import dentalcare.Dentalcare;

public class FavoriteDental {
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
	public void setFavoriteDiease() throws InterruptedException {
		Thread.sleep(1000);
		dental.clickFavroiteDiease();
		Thread.sleep(2000);
		Assert.assertTrue(dental.FavoriteICDDDieaseisplayed());
		dental.insertFavoriteDieaseData("K04.4");
		Thread.sleep(1000);
		dental.searchFavoriteDiease();
		Thread.sleep(10000);
		dental.clickSearchFavoriteDiease();
	}

     @Test(priority = 3)
	public void selectFavoriteProcedure() throws InterruptedException {
		Thread.sleep(2000);
		dental.clickFavoriteProcedure();
		Thread.sleep(1000);
		Assert.assertTrue(dental.FavoriteProcedurePopup());
		Thread.sleep(1000);
		dental.insertFavoriteProcedureData("97014-00");
		dental.searchFavoriteProcedure();
		Thread.sleep(10000);
		dental.selectFavoriteProcedure();
		Thread.sleep(10000);
	}

	@Test(priority = 4)
	public void setFavoriteAdditionalDiagnosis() throws InterruptedException {
		dental.clickFavoriteAdditionalDiagnosis();
		Thread.sleep(1000);
		Assert.assertTrue(dental.FavoriteAdditional());
		dental.insertFavoriteAdditonalDiagnosis("K05.0");
		Thread.sleep(2000);
		dental.searchFavortieAddDiagnosis();
		Thread.sleep(2000);
		dental.clickFavoriteDiagnosisList();
	}
	
	@Test(priority=5)
	public void setMedicineFavorite() throws InterruptedException{
		Thread.sleep(2000);
		dental.clickFavoriteMedicine();
		Thread.sleep(1000);
		Assert.assertTrue(dental.FavoriteMedcine());
		Thread.sleep(10000);
		dental. inserFavoriteMedRecord("T-2029");
		Thread.sleep(1000);
		dental.searchFavoriteRecord();
		Thread.sleep(10000);
		dental.clickONFavoriteRecord();
		Thread.sleep(2000);
		dental.closeFavoriteMedicine();
	}
	 
	@Test(priority=7)
    public void insertUnit() throws InterruptedException{
		Thread.sleep(1000);
		dental.setDose("5",0);
		Thread.sleep(1000);
		dental.setFrequency("bid: twice a day",0);
		Thread.sleep(1000);
		dental.duration("5",0);
		Thread.sleep(1000);
		dental.setRoute("npo: Nothing by mouth",0);
		Thread.sleep(1000);
		dental.setRefills("2",0);
	
	
	}   
	
	

}
