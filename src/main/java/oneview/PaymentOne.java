package oneview;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentOne {

	WebDriver driver;
	ArrayList<WebElement> div = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();

	public PaymentOne(WebDriver driv) {
		driver = driv;
	}

	public void clickPaymentMode() throws InterruptedException {
		div = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:PaymentMode"))
				.findElements(By.tagName("div"));
		Thread.sleep(1000);
		div.get(2).findElement(By.tagName("span")).click();

	}

	public void selectPaymentType(String data) {
		WebElement ele = driver
				.findElement(
						By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:PaymentMode_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(data)) {
				li.get(i).click();
				break;

			} else {
				System.out.println("record not found");
			}
		}
	}

	public void inserDiscount(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:Discount"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(value);
	}

	public void insertNetAmount(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:TotalBill"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(value);
	}

	public void insertReceievedAmount(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:amountRecieved"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(value);

	}

	public boolean verifyNetAmount(String value) {
		WebElement ele = driver
				.findElement(By
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:balanceAmount"));

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
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:amountRecieved"));

		if (ele.getAttribute("value").contains(String.valueOf(value))) {
			return true;

		} else {
			return false;

		}
	}

	public void clickSave() {
		driver.findElement(
				By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:paymentSaveButton"))
				.click();
	}

	public void cancel() {
		driver.findElement(
				By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:paymentCancelButton"))
				.click();
	}

	public void clickOnBalanceAmount() {
		driver.findElement(
				By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:balanceAmount"))
				.click();
	}

	public void clickOKAlreadyBilled() {
		driver.findElement(
				By.cssSelector("button[id^='_oneViewApptCalendar_WAR_CloudClinikportlet_:duplicateBillingConfirmationForm:j_idt451']"))
				.click();
	}

	public void insertCardRefNumber(String data) {
		driver.findElement(
				By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:CardRefNo"))
				.sendKeys(data);
	}

	public void clickCardType() {
		div = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:CardType"))
				.findElements(By.tagName("div"));

		div.get(2).findElement(By.tagName("span")).click();
	}

	public void selectCardType(String data) {
		WebElement ele = driver
				.findElement(
						By.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:CardType_panel"))
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
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:CreditPayment"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='';", ele);

		Thread.sleep(1000);
		String s = new StringBuilder().append("arguments[0].value=")
				.append("'").append(data).append("'").toString();

		jse.executeScript(s, ele);

	}

	public void insertCash(String data) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_oneViewApptCalendar_WAR_CloudClinikportlet_:evenDetailForm:AmountCollected"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='';", ele);

		Thread.sleep(1000);
		String s = new StringBuilder().append("arguments[0].value=")
				.append("'").append(data).append("'").toString();

		jse.executeScript(s, ele);

	}

}
