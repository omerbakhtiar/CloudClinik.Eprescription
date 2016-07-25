package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAppointment {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();

	public EditAppointment(WebDriver driv) {
		driver = driv;
	}

	public void insertPurposeOfVisit(String value) throws InterruptedException {
		WebElement ele=driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:editPatientAppointment:ApptSubject"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(value);
	}

	public void clickProvider() throws InterruptedException {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:editPatientAppointment:ProviderName"))
				.findElements(By.tagName("div"));

		divs.get(2).findElement(By.tagName("span")).click();
		Thread.sleep(1000);

	}

	public void selectProvider(String provider) {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:editPatientAppointment:ProviderName_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(provider)) {
				li.get(i).click();

			} else {
				System.out.println("not found");

			}
		}
	}

	public void insertDuration(String value) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:editPatientAppointment:timeTo_input"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(value);
	}

	public void save() {
		driver.findElement(
				By.cssSelector("button[id^='_AppointmentCalender_WAR_CloudClinikportlet_:editPatientAppointment:j_idt']"))
				.click();

	}

	public void close() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:editPatientAppt"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"))
				.findElement(By.tagName("span")).click();
	}

}
