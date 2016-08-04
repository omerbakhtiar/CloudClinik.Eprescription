package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsuranceEnrol {
	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> select = new ArrayList<WebElement>();
	ArrayList<WebElement> option = new ArrayList<WebElement>();
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> columns = new ArrayList<WebElement>();

	public InsuranceEnrol(WebDriver driv) {
		driver = driv;
	}

	public void clickAdd() {
		driver.findElement(
				By.cssSelector("button[id^='_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:j_idt']"))
				.click();
	}

	public void clickInsuranceCompany() throws InterruptedException {

		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:InsuranceCompany"))
				.findElements(By.tagName("div"));

		Thread.sleep(1000);
		divs.get(2).findElement(By.tagName("span")).click();

	}

	public void selectCompany(String data) {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:InsuranceCompany_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(data)) {
				li.get(i).click();
				break;

			} else {
				System.out.println("not found company");

			}
		}

	}

	public void insertPolicyNumber(String data) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:InsurancePolicyNo"));

		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(data);
	}

	public void insertInsuranceNumber(String data) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:InsuranceCardNo"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(data);
	}

	public void clickCardValidFrom() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:ECardValidFrom_input"))
				.click();
	}

	public void selectMonth(String month) throws InterruptedException {
		WebElement ele = driver.findElement(By.id("ui-datepicker-div"))
				.findElement(By.className("ui-datepicker-title"));

		Thread.sleep(1000);

		select = (ArrayList<WebElement>) ele.findElements(By.tagName("select"));

		option = (ArrayList<WebElement>) select.get(0).findElements(
				By.tagName("option"));

		for (int i = 0; i < option.size(); i++) {

			if (option.get(i).getText().contains(month)) {
				option.get(i).click();
				break;

			} else {

				System.out.println("not month found");
			}

		}

	}

	public void selectYear(String year) throws InterruptedException {
		WebElement ele = driver.findElement(By.id("ui-datepicker-div"))
				.findElement(By.className("ui-datepicker-title"));

		Thread.sleep(1000);

		select = (ArrayList<WebElement>) ele.findElements(By.tagName("select"));

		option = (ArrayList<WebElement>) select.get(1).findElements(
				By.tagName("option"));

		for (int i = 0; i < option.size(); i++) {

			if (option.get(i).getText().contains(year)) {
				option.get(i).click();
				break;

			} else {

				System.out.println("not month found");
			}

		}
	}

	public void selectDate(String date) throws InterruptedException {
		driver.findElement(By.linkText(String.valueOf(date))).click();

	}

	public void clickValidTo() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:ECardValidTo_input"))
				.click();
	}

	public void clickDefault() {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:defaultCheckBox"));

		divs = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));

		divs.get(1).click();

	}

	public void clickInsuranceRef() {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:InsurancePreference"))
				.findElements(By.tagName("div"));

		divs.get(2).findElement(By.tagName("span")).click();
	}

	public void selectInsuranceRefOption(String data) {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:InsurancePreference_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(data)) {
				li.get(i).click();
				break;

			} else {
				System.out.println("not option avlalable");
			}
		}
	}

	public void chooseInsuranceCard() {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:UploadScan_input"));

		ele.sendKeys("D:\\images.jpg");
	}

	public void saveUpload() throws InterruptedException {
		td = (ArrayList<WebElement>) driver.findElement(
				By.className("template-upload")).findElements(By.tagName("td"));
		Thread.sleep(1000);
		td.get(4).findElement(By.tagName("button")).click();
	}

	public void save() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:insuranceEnrollmentDButton"))
				.click();
	}

	public void close() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:PatientInsurance"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"))
				.findElement(By.tagName("span")).click();
	}

	public boolean errorMessage(String message) {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:insuranceMessages"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"))
				.findElement(By.tagName("li")).findElement(By.tagName("span"));

		if (ele.getText().contains(message)) {
			return true;

		} else {

			return false;
		}
	}

	public void editInsurance(String name) {
		
		System.out.println("i am here");
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:patientInsuranceForm:patientInsCompanies_data"));

		row = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < row.size(); i++) {

			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			if (td.get(1).getText().contains(name)) {
				WebElement elem = td.get(4).findElement(By.tagName("a"));

				System.out.println("i came heere");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", elem);
				break;

			} else {
				System.out.println("not found");
			}
		}
	}
}
