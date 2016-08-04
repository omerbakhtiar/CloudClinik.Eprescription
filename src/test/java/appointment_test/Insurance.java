package appointment_test;

import java.io.IOException;

import junit.framework.Assert;
import framework.Login;
import helper.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import appointment.Appoints;
import appointment.CalenderData;
import appointment.Data;
import appointment.InsuranceEnrol;
import appointment.SearchPatient;

public class Insurance {

	WebDriver driver = new FirefoxDriver();
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Appoints app = new Appoints(driver);
	Data[] data = new Data[7];
	CalenderData[] dt = new CalenderData[5];
	SearchPatient st = new SearchPatient(driver);
	InsuranceEnrol enrol=new InsuranceEnrol(driver);

	@Test
	public void insuranceAdd() throws IOException, InterruptedException {
		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232895", "infogistic@1");
		Thread.sleep(10000);
		help.maximize(driver);
		Thread.sleep(1000);
		/*app.clickDisabledBookApp(2,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(0, 7);
		Thread.sleep(7000);
		enrol.clickAdd();
		Thread.sleep(1000);
		enrol.clickInsuranceCompany();
		Thread.sleep(1000);
		enrol.selectCompany("NEXT CARE");
		Thread.sleep(10000);
		enrol.clickCardValidFrom();
		Thread.sleep(2000);
		enrol.selectMonth("May");
		Thread.sleep(20000);
		enrol.selectDate("5");
		Thread.sleep(10000);
		enrol.clickInsuranceRef();
		Thread.sleep(1000);
		enrol.selectInsuranceRefOption("Quaternary");
		Thread.sleep(5000);
		enrol.chooseInsuranceCard();
		Thread.sleep(1000);
		enrol.saveUpload();
		Thread.sleep(6000);
		enrol.save();
		Thread.sleep(6000);
		enrol.close();*/
		
	}
	
	@Test(enabled=false)
	public void checkAppointment() throws InterruptedException{
		app.clickDisabledBookApp(2,7);
		Thread.sleep(10000);
		app.selectInsurance("NEXT CARE");
	}
	
/*	@Test(priority=3)
	public void checkAppointmentMessage() throws InterruptedException{
		app.clickDisabledBookApp(0,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(0, 7);
		Thread.sleep(7000);
		enrol.clickAdd();
		Thread.sleep(1000);
		enrol.clickInsuranceCompany();
		Thread.sleep(1000);
		enrol.selectCompany("NEXT CARE");
		Thread.sleep(1000);
		enrol.save();
		Thread.sleep(7000);
		Assert.assertTrue(enrol.errorMessage("Patient is already enrolled with selected insurance company"));
		Thread.sleep(1000);
		enrol.close();
		
	}
	
	@Test(priority=4)
	public void checkAppointmentSecondary() throws InterruptedException{
		Thread.sleep(1000);
		app.clickDisabledBookApp(1,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(1, 7);
		Thread.sleep(7000);
		enrol.clickAdd();
		Thread.sleep(1000);
		enrol.clickInsuranceCompany();
		Thread.sleep(1000);
		enrol.selectCompany("Seha");
		Thread.sleep(1000);
		enrol.save();
		Thread.sleep(7000);
		Assert.assertTrue(enrol.errorMessage("Patient is already enrolled with selected insurance company"));
		Thread.sleep(1000);
		enrol.close();
		
	}
	
	@Test(priority=5)
	public void checkAppointmentTertiary() throws InterruptedException{
		Thread.sleep(1000);
		app.clickDisabledBookApp(0,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(0,7);
		Thread.sleep(7000);
		enrol.clickAdd();
		Thread.sleep(1000);
		enrol.clickInsuranceCompany();
		Thread.sleep(1000);
		enrol.selectCompany("AXA INSURANCE");
		Thread.sleep(1000);
		enrol.save();
		Thread.sleep(7000);
		Assert.assertTrue(enrol.errorMessage("Patient is already enrolled with selected insurance company"));
		Thread.sleep(1000);
		enrol.close();
		
	}
	*/
	
/*	@Test(priority=6)
	public void editInsurance() throws InterruptedException{
		Thread.sleep(1000);
		app.clickDisabledBookApp(0,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(0,7);
		Thread.sleep(10000);
		enrol.editInsurance("Seha");
		Thread.sleep(1000);
		enrol.insertInsuranceNumber("123number");
		Thread.sleep(1000);
		enrol.save();
		Thread.sleep(1000);
		enrol.close();
		
	}*/
	
/*	@Test(priority=6)
	public void editInsurance() throws InterruptedException{
		Thread.sleep(1000);
		app.clickDisabledBookApp(0,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(0,7);
		Thread.sleep(10000);
		enrol.editInsurance("Seha");
		Thread.sleep(1000);
		enrol.clickDefault();
		Thread.sleep(1000);
		enrol.save();
		Thread.sleep(1000);
		enrol.close();
		
	}*/
	
	@Test(priority=7)
	public void cancelAppointment() throws InterruptedException{
		Thread.sleep(10000);
	/*	app.clickDisabledBookApp(0,10);
		Thread.sleep(10000);
		app.bookAppointmentMenu(0,11);
		Thread.sleep(1000);
		app.clickOnReasonCancel();
		Thread.sleep(10000);
		app.cancelAppointmentReason("Out of city");
		Thread.sleep(1000);
		app.clickOkCancelAppointment();*/
		String s=app.getInsuranceName(0);
		Assert.assertEquals(s,"Allianz");
		
	}
	
}
