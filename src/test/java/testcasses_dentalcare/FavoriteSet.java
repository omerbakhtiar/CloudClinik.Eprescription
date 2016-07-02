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
	public void setComplaint() {
		Helper.implicitWait(driver);
		set.setComlaintsSet("pain fom acute gigivitits over tooth");
		set.selectComplaint();

	}

	/*@Test(priority = 3)
	public void setFavoriteDiease() throws InterruptedException {
		Helper.implicitWait(driver);
		set.clickFavoriteDiease();
		set.searchFavoriteDiease("K04.4");
		set.searchDieaseButton();
		set.clicksearchValueDiease();
		Assert.assertTrue(set.displayFavoriteDieseaPop());
	}*/
	
	@Test(priority=4)
	public void setFavoriteProcedure() throws InterruptedException{
		Helper.implicitWait(driver);
		set.clickFavoriteProcedure();
		Thread.sleep(1000);
		set.searcFavoriteProcedure("97014-00");
		Thread.sleep(1000);
		set.srFavoriteButton();
		set.clickFavoriteProcedureData();
		set.closeFavoriteProcedure();
	}

	@Test(priority=5)
	public void setFavoriteDiagnosis() throws InterruptedException{
		Helper.implicitWait(driver);
		set.clickFavoriteAddDiagnosis();
		
	}

}
