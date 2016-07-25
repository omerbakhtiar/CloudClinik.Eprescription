package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPatient {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();

	public SearchPatient(WebDriver driv) {
		driver = driv;
	}

	public void searchById(String data) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:SearchCNIC"))
				.sendKeys(data);
	}

	public void searchByMr(String Mr) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:SearchCloudClinicNO"))
				.sendKeys(Mr);
	}

	public void searchByName(String name) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:SearchPatientName"))
				.sendKeys(name);
	}

	public void searchByNumber(int number) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:SearchContactNumber"))
				.sendKeys(String.valueOf(number));
	}

	public void searchByPatientFileNo(int number) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:SearchFileNo"))
				.sendKeys(String.valueOf(number));
	}

	public void insertPurposeOfVisit(String data) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:ApptSubject"))
				.sendKeys(data);
	}

	public void selectProvider(String name) {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:ProviderName"));

		divs = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		divs.get(2).findElement(By.tagName("span")).click();

	}

	public void changeDurationHour(int size) throws InterruptedException {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:timeTo_input"))
				.sendKeys("");
		Thread.sleep(1000);

		WebElement ele = driver.findElement(By.className("ui_tpicker_hour"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"));

		Actions action = new Actions(this.driver);

		action.click(ele).build().perform();
		Thread.sleep(1000);

		for (int i = 0; i < size; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);

		}

	}

	public void changeDurationMinute(double Minute, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:timeTo_input"))
				.sendKeys("");
		Thread.sleep(1000);

		WebElement ele = driver.findElement(By.className("ui_tpicker_hour"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"));

		Actions action = new Actions(this.driver);

		action.click(ele).build().perform();
		Thread.sleep(1000);

		if (Minute >= 30)
			for (int i = 0; i < index; i++) {
				action.sendKeys(Keys.ARROW_RIGHT).build().perform();
				Thread.sleep(200);

			}
		else if (Minute < 30) {
			for (int i = 0; i < index; i++) {
				action.sendKeys(Keys.ARROW_LEFT).build().perform();
				Thread.sleep(200);

			}

		}

	}

	public void insertDuration(String time) throws InterruptedException {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:timeTo_input"))
				.clear();

		Thread.sleep(1000);

		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:timeTo_input"))
				.sendKeys((time));
	}

	public void clickSearch() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:searchPatientButton"))
				.click();
	}

	public void selectPatient(String mrNumber) throws InterruptedException {
		WebElement tbody = driver
				.findElement(
						By.cssSelector("div[id^='_AppointmentCalender_WAR_CloudClinikportlet_:searchtb']"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));

		Thread.sleep(1000);

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		for (int i = 0; i < row.size(); i++) {
			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			if (td.get(2).getText().contains(mrNumber)) {
				td.get(2).click();
				break;

			} else {
				System.out.println("not found");

			}

		}
	}

}
