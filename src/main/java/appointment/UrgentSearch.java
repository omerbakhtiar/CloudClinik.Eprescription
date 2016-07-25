package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UrgentSearch {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();

	public UrgentSearch(WebDriver driv) {
		driver = driv;
	}

	public void searchId(int id) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentSearchCNIC"))
				.sendKeys(String.valueOf(id));
	}

	public void searchMR(int mr) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentSearchCloudClinicNO"))
				.sendKeys(String.valueOf(mr));
	}

	public void searchPatientName(String name) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentSearchPatientName"))
				.sendKeys(name);
	}

	public void searchContactNumber(int number) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentSearchContactNumber"))
				.sendKeys(String.valueOf(number));
	}

	public void searchFileNo(int number) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentSearchFileNo"))
				.sendKeys(String.valueOf(number));
	}

	public void searchOther(String value) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentSearchOtherIdentification"))
				.sendKeys(value);
	}

	public void clickSearch() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:urgentAppointmentSearchPatient"))
				.click();
	}

	public void purposeOfVisit(String data) {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:ApptSubject"))
				.sendKeys(data);
	}

	public void selectProvider(String name) throws InterruptedException {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentProviderName"))
				.findElements(By.tagName("div"));

		Thread.sleep(10000);

		divs.get(2).click();

		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:UrgentProviderName_panel"))
				.findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.contains(name)) {
				li.get(i).click();
				break;
			} else {
				System.out.println("not provider found");
			}
		}

	}

	public void selectPatient(int mrnumber) throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.cssSelector("div[id^='_AppointmentCalender_WAR_CloudClinikportlet_:urgentSearchForm:urgentsearchtb']"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));

		Thread.sleep(10000);

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			td = (ArrayList<WebElement>) ele.findElements(By.tagName("td"));

			if(td.get(2).getText().contains(String.valueOf(mrnumber))){
				td.get(2).click();
			}
		}

	}

}
