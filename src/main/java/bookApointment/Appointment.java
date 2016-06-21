package bookApointment;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.Wait;

import framework.ReadExcel;

public class Appointment {

	private WebDriver driver;

	private ArrayList<WebElement> divs = new ArrayList<WebElement>();
	private ArrayList<WebElement> a = new ArrayList<WebElement>();
	private ArrayList<WebElement> td = new ArrayList<WebElement>();
	private ArrayList<WebElement> tr = new ArrayList<WebElement>();
	private ArrayList<WebElement> ul = new ArrayList<WebElement>();
	private ArrayList<WebElement> td2 = new ArrayList<WebElement>();
	private ArrayList<WebElement> arr = new ArrayList<WebElement>();
	private ArrayList<WebElement> li = new ArrayList<WebElement>();
	private ArrayList<WebElement> select = new ArrayList<WebElement>();
	private ArrayList<WebElement> months = new ArrayList<WebElement>();
	private ArrayList<WebElement> rows = new ArrayList<WebElement>();

	public Appointment(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ArrayList<ReadExcel> lst = new ArrayList<ReadExcel>();

	}

	public void selectAppointmentCal() throws InterruptedException {

		Thread.sleep(10000);
		WebElement element = driver.findElement(By.id("myId"));
		divs = (ArrayList<WebElement>) element.findElements(By.tagName("li"));
		divs.get(0).findElement(By.tagName("a")).click();

	}

	public void selectVisit() throws InterruptedException {

		Thread.sleep(10000);

		// _AppointmentCalender_WAR_CloudClinikportlet_:form:app:0:dynaButton
		tr = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr"));
		td = (ArrayList<WebElement>) tr.get(0).findElements(By.tagName("td"));
		td.get(9).findElement(By.tagName("div")).click();

	}

	public void bookAppointments() {
		WebElement element = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app:0:appCalenderManu"))
				.findElement(By.tagName("ul"));

		ul = (ArrayList<WebElement>) element.findElements(By.tagName("li"));
		ul.get(0).findElement(By.tagName("a")).click();
	}

	public void searchidy(String id) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:CnicNo"))
				.sendKeys(id);
	}

	public void searchMr(String mr) {

		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:CloudClinikNo"))
				.sendKeys(mr);
		;
	}

	public void searchPatientName(String patient) throws InterruptedException {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:PatientName"))
				.sendKeys(patient);

	}

	public void searchContactNumber(String contact) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:ContactNo"))
				.sendKeys(contact);

	}

	public void searchFileNumber(String number) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:SearchFileNo"))
				.sendKeys(number);
	}

	public void selectGender(int index) throws InterruptedException {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:Gender_label"))
				.click();
		Thread.sleep(1000);
		selectGenderType(index);

	}

	public void selectGenderType(int index) {
		WebElement ele = driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:Gender_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		li.get(index).click();

	}

	public void selectAgeFrom(int year) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:AgeBetween"))
				.sendKeys(String.valueOf(year));
	}

	public void selectAgeTo(int year) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:AgeBetween2nd"))
				.sendKeys(String.valueOf(year));
	}

	public void selectAgeUnit(String unit) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:j_idt44_label"))
				.click();
		selectAgeUnitType(unit);
	}

	public void selectAgeUnitType(String unit) {
		WebElement ele = driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:j_idt44_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		if (unit == "Year") {
			li.get(0).click();

		} else if (unit == "Month") {
			li.get(1).click();

		} else if (unit == "Week") {
			li.get(2).click();

		} else {
			System.out.println("type not found");
		}

	}

	public boolean noRecordFound() {
		String message = driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientGrid_data"))
				.findElement(By.tagName("tr")).getText();

		if (message.contains("No record found")) {
			return true;

		} else {
			return false;
		}

	}

	public void selectmonts(String mon) throws InterruptedException {
		
		  new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
		
		WebElement month = driver.findElement(By.id("ui-datepicker-div"))
				.findElement(By.tagName("div")).findElement(By.tagName("div"));

	     	select = (ArrayList<WebElement>) month.findElements(By
				.tagName("select"));
		    select.get(0).click();
		  
		Thread.sleep(20000);
		months = (ArrayList<WebElement>) select.get(0).findElements(
				By.tagName("option"));
		
		
		for(int i=0;i<months.size();i++){
			if(months.get(i).getText().contains(mon)){
				months.get(i).click();
				break;
			}
		}

	}

	public void selectYear(int year) throws InterruptedException {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:DOB_input"))
				.click();
		Thread.sleep(1000);
		WebElement month = driver.findElement(By.id("ui-datepicker-div"))
				.findElement(By.tagName("div")).findElement(By.tagName("div"));

		select = (ArrayList<WebElement>) month.findElements(By
				.tagName("select"));
		select.get(1).click();

		months = (ArrayList<WebElement>) select.get(1).findElements(
				By.tagName("option"));

		for(int i=0;i<months.size();i++){
			if(months.get(i).getText().contains(String.valueOf(year))){
				months.get(i).click();
				break;
			}
			
		}
		
	}

	public void clickAnElementByLinkText(String linkText) {
		  new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
		  driver.findElement(By.linkText(linkText)).click();
		}

	
	
	public void selectDate(String date) throws InterruptedException {
	
		
		
		   new WebDriverWait(driver, 25).
		  until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
		
		WebElement month =driver.findElement(By.id("ui-datepicker-div"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));

		Thread.sleep(1000);

		rows = (ArrayList<WebElement>) month.findElements(By.tagName("tr"));
		/*
		 * td=(ArrayList<WebElement>)
		 * rows.get(0).findElements(By.tagName("td"));
		 * td.get(6).findElement(By.tagName("a")).click();
		 */

		for (int i = 0; i < rows.size(); i++) {
			td = (ArrayList<WebElement>) rows.get(i).findElements(
					By.tagName("td"));

			for (int j = 0; j < td.size(); j++) {

				if (td.get(j).getText().contains(date)) {

					td.get(j).click();
				}

			}
		}

	}

	public void clickSearchButton() throws InterruptedException {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn"))
				.click();
		Thread.sleep(5000);
	}

	public void selectAppointment() throws InterruptedException {
		driver.findElement(
				By.xpath("//*[@id='_AppointmentCalender_WAR_CloudClinikportlet_:searchtbl_data']/tr/td[1]"))
				.click();
		Thread.sleep(10000);
	}
}