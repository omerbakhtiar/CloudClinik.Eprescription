package appointment_test;

import framework.Login;
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
import appointment.PaymentReciept;
import appointment.RegularInvocing;
import appointment.SearchPatient;

public class FutureAppointment {

	WebDriver driver = new FirefoxDriver();
	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Appoints app = new Appoints(driver);
	Data[] data = new Data[7];
	CalenderData[] dt = new CalenderData[5];
	SearchPatient st = new SearchPatient(driver);
	ArrayList<WebElement> ele = new ArrayList<WebElement>();
	RegularInvocing regular =new RegularInvocing(driver);
	PaymentReciept pay=new PaymentReciept(driver);
	
	@Test(priority = 1)
	public void future() throws IOException, InterruptedException {
		Logger logger = Logger.getLogger(appointment_test.Urgent.class);
		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232895", "infogistic@1");
		Thread.sleep(10000);
		help.maximize(driver);
		Thread.sleep(10000);
	}

	@Test(enabled= false)
	public void futureAppoint() throws IOException, InterruptedException {
		Thread.sleep(10000);
		app.clickFutureAppointment();
		Thread.sleep(1000);
		app.getFutureTable("23-Jul-2016", data);
		Thread.sleep(1000);
		app.pressAppointment(0);
		Thread.sleep(1000);
		app.bookAppointmentMenu(0, 0);
		Thread.sleep(10000);
		st.searchByName("test");
		Thread.sleep(1000);
		st.clickSearch();
		Thread.sleep(7000);
		st.insertPurposeOfVisit("nausia");
		Thread.sleep(10000);
		st.selectPatient("974100301864");
	}
	
	@Test(enabled=false)
	public void payment() throws InterruptedException{
		app.clickFutureAppointment();
		Thread.sleep(10000);
		app.getFutureTable("23-Jul-2016", data);
		Thread.sleep(10000);
		app.pressAppointment(0);
		Thread.sleep(1000);
		app.bookAppointmentMenu(0, 6);
		Thread.sleep(10000);
		regular.clickPaymentMode();
		Thread.sleep(1000);
		regular.selectPaymentValue("Cheque");
		Thread.sleep(1000);
		regular.insertDiscount("20");
		Thread.sleep(10000);
		regular.clickOnBalanceAmount();
		Thread.sleep(10000);
		Assert.assertTrue(regular.verifyNetAmount("500.0"));
		Thread.sleep(1000);
		Assert.assertTrue(regular.verifyMrNumber("974100301864"));
		Assert.assertTrue(regular.verifyRecievedAmount(480.0));
		Assert.assertTrue(regular.verifyName("Mr. testing  newpatient"));
		regular.clickSave();
		Thread.sleep(1000);
		pay.closePaymentReciept();
	}
	
	@Test(enabled=false)
	public void paymentCard() throws InterruptedException{
		app.clickFutureAppointment();
		Thread.sleep(10000);
		app.getFutureTable("23-Jul-2016", data);
		Thread.sleep(10000);
		app.pressAppointment(0);
		Thread.sleep(1000);
		app.bookAppointmentMenu(0, 6);
		Thread.sleep(10000);
		regular.clickOKAlreadyBilled();
		Thread.sleep(10000);
		regular.clickPaymentMode();
		Thread.sleep(1000);
		regular.selectPaymentValue("Debit/Credit Card");
		Thread.sleep(1000);
		regular.insertDiscount("20");
		Thread.sleep(10000);
		regular.clickOnBalanceAmount();
		Thread.sleep(10000);
		regular.clickCardType();
		Thread.sleep(1000);
		regular.selectCardType("Visa");
		Thread.sleep(1000);
		regular.insertCardRefNumber("3456800");
		Thread.sleep(1000);
		Assert.assertTrue(regular.verifyNetAmount("500.0"));
		Thread.sleep(1000);
		Assert.assertTrue(regular.verifyMrNumber("974100301864"));
		Assert.assertTrue(regular.verifyRecievedAmount(480.0));
		Assert.assertTrue(regular.verifyName("Mr. testing  newpatient"));
		regular.clickSave();
		Thread.sleep(1000);
		pay.closePaymentReciept();
	}
	
	@Test(enabled=false)
	public void paymentCardCredit() throws InterruptedException{
		app.clickFutureAppointment();
		Thread.sleep(10000);
		app.getFutureTable("23-Jul-2016", data);
		Thread.sleep(10000);
		app.pressAppointment(0);
		Thread.sleep(1000);
		app.bookAppointmentMenu(0, 6);
		Thread.sleep(10000);
		regular.clickOKAlreadyBilled();
		Thread.sleep(10000);
		regular.clickPaymentMode();
		Thread.sleep(1000);
		regular.selectPaymentValue("Cash and Credit Card");
		Thread.sleep(1000);
		regular.insertDiscount("20");
		Thread.sleep(10000);
		regular.clickOnBalanceAmount();
		Thread.sleep(10000);
		regular.clickCardType();
		Thread.sleep(1000);
		regular.selectCardType("Visa");
		Thread.sleep(1000);
		regular.insertCardRefNumber("3456800");
		Thread.sleep(10000);
		regular.insertCreditCardPayment("480");
		Thread.sleep(1000);
		Assert.assertTrue(regular.verifyNetAmount("500.0"));
		Thread.sleep(1000);
		Assert.assertTrue(regular.verifyMrNumber("974100301864"));
		Assert.assertTrue(regular.verifyRecievedAmount(480.0));
		Assert.assertTrue(regular.verifyName("Mr. testing  newpatient"));
		regular.clickSave();
		Thread.sleep(1000);
		pay.closePaymentReciept();
	
	}
	
	
	@Test(priority=6)
	public void paymentCardCreditCash() throws InterruptedException{
		app.clickFutureAppointment();
		Thread.sleep(10000);
		app.getFutureTable("23-Jul-2016", data);
		Thread.sleep(10000);
		app.pressAppointment(0);
		Thread.sleep(1000);
		app.bookAppointmentMenu(0, 6);
		Thread.sleep(10000);
		regular.clickOKAlreadyBilled();
		Thread.sleep(10000);
		regular.clickPaymentMode();
		Thread.sleep(1000);
		regular.selectPaymentValue("Cash and Credit Card");
		Thread.sleep(1000);
		regular.insertDiscount("20");
		Thread.sleep(10000);
		regular.clickOnBalanceAmount();
		Thread.sleep(10000);
		regular.clickCardType();
		Thread.sleep(1000);
		regular.selectCardType("Visa");
		Thread.sleep(1000);
		regular.insertCardRefNumber("3456800");
		Thread.sleep(10000);
		regular.insertCreditCardPayment("480");
		Thread.sleep(1000);
		regular.insertCash("200");
		Assert.assertTrue(regular.verifyNetAmount("500.0"));
		Thread.sleep(1000);
		Assert.assertTrue(regular.verifyMrNumber("974100301864"));
		Assert.assertTrue(regular.verifyRecievedAmount(480.0));
		Assert.assertTrue(regular.verifyName("Mr. testing  newpatient"));
		regular.clickSave();
		Thread.sleep(10000);
		pay.closePaymentReciept();
	
	}
}
