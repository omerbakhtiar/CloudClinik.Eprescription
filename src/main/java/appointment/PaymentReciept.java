package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentReciept {
	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();

	public PaymentReciept(WebDriver driv) {
		driver = driv;
	}

	public boolean verifyMrNumber(int number) {
		WebElement ele = driver.findElement(By.className("mrno alignleft"))
				.findElement(By.tagName("strong"));

		if (ele.getText().contains(String.valueOf(number))) {
			return true;

		} else {
			return false;
		}
	}

	public void closePaymentReciept() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientBillingForm:receiptDlg"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"))
				.findElement(By.tagName("span")).click();
	}

	public void dialogYesButton() throws InterruptedException {
		driver.findElement(
				By.cssSelector("button[id^='_oneViewApptCalendar_WAR_CloudClinikportlet_:duplicateBillingConfirmationForm:j_idt']"))
				.click();

		Thread.sleep(1000);

	}
}
