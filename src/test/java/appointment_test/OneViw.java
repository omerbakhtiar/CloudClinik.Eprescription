package appointment_test;

import static org.testng.Assert.fail;

import java.io.IOException;

import framework.Config;
import framework.Login;
import helper.Helper;
import oneview.OneView;
import oneview.PaymentOne;
import oneview.Receipt;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import appointment.Appoints;
import appointment.SearchPatient;

public class OneViw extends Config {

	private boolean acceptNextAlert = true;
	Helper help = new Helper(driver);
	Appoints app = new Appoints(driver);
	OneView one = new OneView(driver);
	SearchPatient search=new SearchPatient(driver);
	PaymentOne pay=new PaymentOne(driver);
	Receipt re=new Receipt(driver);


	@Test(priority = 2)
	public void Oneview() throws InterruptedException, IOException {
		Thread.sleep(10000);
		one.clickOneView();
		Thread.sleep(10000);
		one.clickOnEmptySlot(1);
		Thread.sleep(10000);
		search.searchByMr("974100301863");
		Thread.sleep(6000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		search.clickSelectPatient();
		Thread.sleep(10000);
		search.selectPatient("974100301863");	
	}
	

	@Test(priority = 3)
	public void OneviewPayment() throws InterruptedException, IOException {
		Thread.sleep(10000);
		one.clickOneView();
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		one.clickOnAppointment("9:00");	
		Thread.sleep(10000);
		one.clickOnPayment();
		Thread.sleep(1000);
		pay.clickOKAlreadyBilled();
		Thread.sleep(10000);
		pay.clickPaymentMode();
		Thread.sleep(1000);
		pay.selectPaymentType("Cash and Credit Card");
		Thread.sleep(1000);
		pay.inserDiscount("100");
		Thread.sleep(1000);
		pay.insertCardRefNumber("23455");
		Thread.sleep(1000);
		pay.insertCreditCardPayment("200");
		Thread.sleep(1000);
		pay.insertCash("200");
		Thread.sleep(10000);
		pay.clickCardType();
		Thread.sleep(10000);
		pay.selectCardType("Visa");
		Thread.sleep(20000);
		pay.clickSave();
		Thread.sleep(10000);
		Assert.assertEquals(re.compareMrNumber("974100301864"),"974100301864");
		
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
