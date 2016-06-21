package testcasses_eprescription;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import prescription.Epres;
import prescription.OrderSet;

public class FavoriteOrderSet {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	 OrderSet order=new OrderSet(driver);
	 
}
