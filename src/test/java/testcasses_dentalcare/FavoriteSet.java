package testcasses_dentalcare;

import helper.Helper;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import dentalcare.Dentalcare;
import dentalcare.OrderSet;

public class FavoriteSet {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Dentalcare dental = new Dentalcare(driver);
	OrderSet set = new OrderSet(driver);

	@Test(priority = 1)
	public void orderSet() throws IOException, InterruptedException {
		sr.Searching("974100232886", "infogistic@1", " 974100301865");
		Helper.implicitWait(driver);
		Helper.maximize(driver);
		dental.clickOrderSet();
		set.clickNew();
		set.setOrderSetName("dental");
	}

	@Test(priority = 2)
	public void setComplaint() throws InterruptedException {
		Helper.implicitWait(driver);
		set.setComlaintsSet("pain fom acute gigivitits over tooth");
		Thread.sleep(1000);
		set.selectComplaint();
		Thread.sleep(1000);

	}

	@Test(priority = 3)
	public void setFavoriteDiease() throws InterruptedException {
		Helper.implicitWait(driver);
		set.clickFavoriteDiease();
		Thread.sleep(10000);
		set.searchFavoriteDiease("K04.4");
		Thread.sleep(10000);
		set.searchDieaseButton();
		Thread.sleep(1000);
		set.clicksearchValueDiease();
		Thread.sleep(1000);
		Assert.assertTrue(set.displayFavoriteDieseaPop());
	}
	
	@Test(priority=4)
	public void setFavoriteProcedure() throws InterruptedException{
		set.clickFavoriteProcedure();
		Thread.sleep(1000);
		set.searcFavoriteProcedure("97014-00");
		Thread.sleep(10000);
		set.srFavoriteButton();
		Thread.sleep(1000);
		set.clickFavoriteProcedureData();
		Thread.sleep(10000);
		set.closeFavoriteProcedure();
		Thread.sleep(10000);
	}

	@Test(priority=5)
	public void setFavoriteDiagnosis() throws InterruptedException{
		Helper.implicitWait(driver);
		set.clickFavoriteAddDiagnosis();
		
	}

}
