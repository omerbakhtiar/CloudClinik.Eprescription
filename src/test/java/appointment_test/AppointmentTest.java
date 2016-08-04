package appointment_test;

import framework.Login;
import helper.Helper;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.*;

import appointment.Appoints;
import appointment.CalenderData;
import appointment.Data;
import appointment.SearchPatient;
import prescription.Epres;
import dentalcare.Dentalcare;
import dentalcare.HistoryEdit;
import dentalcare.OrderSet;

public class AppointmentTest {
	WebDriver driver = new FirefoxDriver();
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Appoints app = new Appoints(driver);
	Data[] data = new Data[7];
	CalenderData[] dt = new CalenderData[5];
	SearchPatient st=new SearchPatient(driver);

	ArrayList<WebElement> ele= new ArrayList<WebElement>();
	@Test(priority = 1)
	public void totalAppointment() throws IOException, InterruptedException {
		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232895", "infogistic@1");
		Thread.sleep(10000);
		help.maximize(driver);
	/*	help.maximize(driver);
		Thread.sleep(4000);
		app.clickClinicDropDown();
		Thread.sleep(7000);
		app.selectClinick("Noha Abdul Monem Clinic");
		Thread.sleep(1000);*/
		//app.clickPreviousAppoint();
		/*Thread.sleep(10000);
		boolean res = app.getTotalSizePrevious(10);
		Assert.assertTrue(res);*/
	}

	/*@Test(priority = 2)
	public void checkPreviousTable() throws InterruptedException {
		app.getPreviousTable("15-Jul-2016", data);
		Thread.sleep(10000);
		app.getappointmentStatus(dt);
		System.out.println("this is the value of the seen from the main"
				+ dt[1].getSeen());
		Thread.sleep(10000);
		Assert.assertEquals(dt[1].getSeen(), data[1].getSeen());
	}*/
	
/*	@Test(priority=3)
	public void checkFutureTable() throws InterruptedException{
		Thread.sleep(2000);
		app.clickFutureAppointment();
		Thread.sleep(10000);
		app.getFutureTable("25-Jul-2016", data);
		Thread.sleep(10000);
		app.getappointmentStatus(dt);
		Thread.sleep(10000);
		Assert.assertEquals(dt[1].getAvailable(), data[2].getTotal());	
	}*/
	
	@Test(priority=4)
	public void doAppointment() throws InterruptedException{
		app.doAppointment("09:00 AM - 09:30 AM",0);
		Thread.sleep(10000);
		st.searchByName("test");
		Thread.sleep(1000);
		st.clickSearch();
		Thread.sleep(10000);
		st.selectPatient("974100301864");
		Thread.sleep(10000);
		Assert.assertFalse(app.verifyErrorMessage("Sorry! This patient already has an appointment with this clinic."));
	
	}
	
	
/*	@Test(priority=5)
	public void checkDisabledAppointment() throws InterruptedException{
		Thread.sleep(10000);
		app.clickDisabledBookApp(3,10);
		Thread.sleep(9000);
		ele=app.BookedMen(3);
		Thread.sleep(1000);
	}*/
}
