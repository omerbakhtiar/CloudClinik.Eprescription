package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegularInvocing {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();

	public RegularInvocing(WebDriver driv) {
		driver = driv;
	}

	public boolean verifyMrNumber(String number) {
		if (driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:MRNO"))
				.getAttribute("value").contains(number)) {
			return true;

		} else {

			return false;
		}
	}

	public boolean verifyName(String name) {

		if (driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:Name"))
				.getAttribute("value").contains(name)) {
			return true;

		} else {

			return false;
		}
	}

	public void changeFeeType() {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:FeeType"))
				.findElements(By.tagName("div"));

		divs.get(2).click();

	}

	public void selectFeeValue(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:FeeType_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));
		Thread.sleep(1000);
		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(value)) {
				li.get(i).click();
				break;
			} else {

			}
		}

	}

	public void clickPaymentMode() {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:PaymentMode"))
				.findElements(By.tagName("div"));

		divs.get(2).click();
	}

	public void selectPaymentValue(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:PaymentMode_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		Thread.sleep(1000);
		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(value)) {
				li.get(i).click();
				break;
			} else {

			}
		}

	}

	public void insertDiscount(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:Discount"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(value);
	}

	public boolean verifyNetAmount(String value) {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:TotalBill"));

		String s = ele.getAttribute("value");

		if (s.contains(value)) {
			return true;

		} else {
			return false;

		}

	}

	public boolean verifyRecievedAmount(double value) {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:amountRecieved"));

		if (ele.getAttribute("value").contains(String.valueOf(value))) {
			return true;

		} else {
			return false;

		}
	}

	public void clickSave() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:paymentSaveButton"))
				.click();
	}

	public void cancel() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:paymentCancelButton"))
				.click();
	}

	public void clickOnBalanceAmount() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:balanceAmount"))
				.click();
	}

	public void clickOKAlreadyBilled() {
		driver.findElement(
				By.cssSelector("button[id^='_AppointmentCalender_WAR_CloudClinikportlet_:duplicateBillingConfirmationForm:j_idt']"))
				.click();
	}

	public void insertCardRefNumber(String data) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:CardRefNo"))
				.sendKeys(data);
	}

	public void clickCardType() {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:CardType"))
				.findElements(By.tagName("div"));

		divs.get(2).findElement(By.tagName("span")).click();
	}

	public void selectCardType(String data) {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:CardType_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(data)) {
				li.get(i).click();
				break;

			} else {
				System.out.println("not found");

			}

		}

	}

	public void insertCreditCardPayment(String data)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:CreditPayment"));
		  
		   JavascriptExecutor jse = (JavascriptExecutor) driver;
		    jse.executeScript("arguments[0].value='';", ele);
		    
		    Thread.sleep(1000);
		    
		    jse.executeScript("arguments[0].value='280'",ele);

	}

	public void insertCash(String data) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:AmountCollected"));
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		    jse.executeScript("arguments[0].value='';", ele);
		    
		    Thread.sleep(1000);
		    
		    jse.executeScript("arguments[0].value='200'",ele);
		
	}

}
