package appointment_test;

import helper.Helper;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import appointment.Appoints;
import appointment.CalenderData;
import appointment.Data;
import appointment.SearchPatient;
import framework.Login;

public class Confirmed {
	WebDriver driver = new FirefoxDriver();
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Appoints app = new Appoints(driver);
	Data[] data = new Data[7];
	CalenderData[] dt = new CalenderData[5];
	SearchPatient st = new SearchPatient(driver);
	ArrayList<WebElement> ele = new ArrayList<WebElement>();

	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		Logger logger = Logger.getLogger(appointment_test.Urgent.class);
		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232895", "infogistic@1");
		Thread.sleep(10000);
		help.maximize(driver);
		Thread.sleep(10000);

	}
	
	@Test(priority=2)
	public void checkConfirmed() throws InterruptedException{
		app.clickDisabledBookApp(0,10);
		Thread.sleep(7000);
		ele=app.BookedMen(0);
		Thread.sleep(10000);
		//app.clickOnConfirmed(0);
		Thread.sleep(1000);
		Assert.assertTrue(app.checkElementState(ele,0));
	//	Assert.assertTrue(app.checkDetailedInvoicing(ele));
	}
	
	@Test(priority=3)
	public void checkInClinick() throws InterruptedException{
		app.clickDisabledBookApp(1,10);
		Thread.sleep(7000);
		ele=app.BookedMen(1);
		Thread.sleep(4000);
		Assert.assertTrue(app.checkElementState(ele,0));
		Assert.assertTrue(app.checkElementState(ele,2));
		Assert.assertTrue(app.checkElementState(ele,3));
		Assert.assertTrue(app.checkElementState(ele,4));
		Assert.assertTrue(app.checkElementState(ele,5));
		Assert.assertTrue(app.checkElementState(ele,9));
		Assert.assertTrue(app.checkElementState(ele,10));
		Assert.assertTrue(app.checkElementState(ele,11));
		Assert.assertTrue(app.checkElementState(ele,14));
		Assert.assertTrue(app.checkElementState(ele,16));
	}
	
	@Test(priority=4)
	public void checkInArrived() throws InterruptedException{
		app.clickDisabledBookApp(0,10);
		Thread.sleep(7000);
		ele=app.BookedMen(0);
		Thread.sleep(4000);
		Assert.assertTrue(app.checkElementState(ele,0));
		Assert.assertTrue(app.checkElementState(ele,2));
		Assert.assertTrue(app.checkElementState(ele,3));
		Assert.assertTrue(app.checkElementState(ele,5));
		Assert.assertTrue(app.checkElementState(ele,9));
		Assert.assertTrue(app.checkElementState(ele,10));
	}
	
	
	@Test(priority=5)
	public void checkPatientAlreadyAppointment() throws InterruptedException{
		Thread.sleep(7000);
		//ele=app.BookedMen(2);
		Thread.sleep(10000);
		app.doAppointment("10:00 AM - 10:30 AM",0);
		Thread.sleep(10000);
		st.searchByName("test");
		Thread.sleep(1000);
		st.clickSearch();
		Thread.sleep(1000);
		st.insertPurposeOfVisit("nausia");
		Thread.sleep(2000);
		st.insertDuration("01:00");
		st.selectPatient("974100301818");
		Thread.sleep(10000);
		app.verifyErrorMessage("Sorry! There is already an appointment in your given time duration.");

	}
	
}
