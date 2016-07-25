package appointment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appoints {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> span = new ArrayList<WebElement>();
	ArrayList<WebElement> span2 = new ArrayList<WebElement>();
	ArrayList<WebElement> span3 = new ArrayList<WebElement>();
	ArrayList<WebElement> span4 = new ArrayList<WebElement>();
	ArrayList<WebElement> span5 = new ArrayList<WebElement>();
	ArrayList<WebElement> span6 = new ArrayList<WebElement>();
	ArrayList<WebElement> span7 = new ArrayList<WebElement>();
	ArrayList<WebElement> span8 = new ArrayList<WebElement>();
	boolean value;

	public Appoints(WebDriver driv) {
		driver = driv;
	}

	public void clickPreviousAppoint() {
		WebElement element = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:previousAppointmentsLink"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);

	}

	public void clickClinicDropDown() {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:Clinic"));

		divs = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));

		divs.get(2).findElement(By.tagName("span")).click();
	}

	public void selectClinick(String name) {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:Clinic_panel"));

		li = (ArrayList<WebElement>) ele.findElement(By.tagName("div"))
				.findElement(By.tagName("ul")).findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(name)) {
				li.get(i).click();

				break;
			}

		}

	}

	public void clickForward() throws InterruptedException {
		span = (ArrayList<WebElement>) driver.findElement(
				By.cssSelector("div[id$='_paginator_bottom']")).findElements(
				By.tagName("span"));

		Thread.sleep(1000);

		span.get(4).findElement(By.tagName("span")).click();

	}

	public void getPreviousTable(String date, Data[] dat)
			throws InterruptedException {
		WebElement tbody = driver
				.findElement(
						By.cssSelector("div[id^='_AppointmentCalender_WAR_CloudClinikportlet_:PreviousAppointForm:j_idt']"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));
		Thread.sleep(1000);

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		for (int i = 0; i < row.size(); i++) {
			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			System.out.println(td.get(0).getText());

			if (td.get(0).getText().contains(date)) {
				dat[1] = new Data(Integer.valueOf(td.get(1).getText()),
						Integer.valueOf(td.get(2).getText()),
						Integer.valueOf(td.get(3).getText()),
						Integer.valueOf(td.get(4).getText()));
				Thread.sleep(5000);
				td.get(0).click();

				System.out.println("this is the value in seen"
						+ td.get(2).getText());
				break;

			} else {
				System.out.println("date not found");

			}

		}

	}

	public boolean getTotalSizePrevious(int total) throws InterruptedException {
		WebElement tbody = driver
				.findElement(
						By.cssSelector("div[id^='_AppointmentCalender_WAR_CloudClinikportlet_:PreviousAppointForm:j_idt']"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));
		Thread.sleep(1000);

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		if (row.size() == total) {
			return true;

		} else {
			return false;

		}
	}

	public void getappointmentStatus(CalenderData[] dat) {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:statusCount_content"))
				.findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		span = (ArrayList<WebElement>) li.get(0).findElements(
				By.tagName("span"));
		span2 = (ArrayList<WebElement>) li.get(1).findElements(
				By.tagName("span"));
		span3 = (ArrayList<WebElement>) li.get(2).findElements(
				By.tagName("span"));
		span4 = (ArrayList<WebElement>) li.get(3).findElements(
				By.tagName("span"));
		span5 = (ArrayList<WebElement>) li.get(4).findElements(
				By.tagName("span"));
		span6 = (ArrayList<WebElement>) li.get(5).findElements(
				By.tagName("span"));
		span7 = (ArrayList<WebElement>) li.get(6).findElements(
				By.tagName("span"));
		span8 = (ArrayList<WebElement>) li.get(7).findElements(
				By.tagName("span"));
		dat[1] = new CalenderData(Integer.valueOf(span.get(1).getText()),
				Integer.valueOf(span2.get(1).getText()), Integer.valueOf(span3
						.get(1).getText()), Integer.valueOf(span4.get(1)
						.getText()), Integer.valueOf(span5.get(1).getText()),
				Integer.valueOf(span6.get(1).getText()), Integer.valueOf(span7
						.get(1).getText()), Integer.valueOf(span8.get(1)
						.getText()));
	}

	public void clickFutureAppointment() throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:futureAppointmentsLink"));
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);

	}

	public void getFutureTable(String date, Data[] dat)
			throws InterruptedException {
		WebElement tbody = driver
				.findElement(
						By.cssSelector("div[id^='_AppointmentCalender_WAR_CloudClinikportlet_:FuturAppointForm:j_idt']"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));
		Thread.sleep(1000);

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		for (int i = 0; i < row.size(); i++) {
			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			System.out.println(td.get(0).getText());

			if (td.get(0).getText().contains(date)) {
				dat[2] = new Data(Integer.valueOf(td.get(1).getText()),
						Integer.valueOf(td.get(2).getText()),
						Integer.valueOf(td.get(3).getText()),
						Integer.valueOf(td.get(4).getText()));
				Thread.sleep(5000);
				td.get(0).click();

				System.out.println("this is the previous value"
						+ td.get(2).getText());
				break;

			} else {
				System.out.println("date not found");

			}

		}
	}

	public void clickOnTodayAppointment() throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:todayAppointmentsLink"));
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
	}

	public void doAppointment(String date, int option)
			throws InterruptedException {
		WebElement tbody = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));

		Thread.sleep(1000);

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		for (int i = 0; i < row.size(); i++) {
			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));
			Thread.sleep(1000);

			if (td.get(1).getText().contains(date)) {
				td.get(10).click();
				Thread.sleep(10000);
				bookAppointmentMenu(i, option);
				break;

			} else {
				System.out.println("date not found");
			}

		}

	}

	public void bookAppointmentMenu(int index, int option)
			throws InterruptedException {
		WebElement div = driver.findElement(By
				.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app:"
						+ index + ":appCalenderManu"));
		Thread.sleep(1000);

		li = (ArrayList<WebElement>) div.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));
		Thread.sleep(5000);
		WebElement element = li.get(option).findElement(By.tagName("a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public ArrayList<WebElement> BookedMen(int index)
			throws InterruptedException {

		Thread.sleep(6000);

		WebElement div = driver.findElement(By
				.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app:"
						+ index + ":appCalenderManu"));
		Thread.sleep(1000);
		li = (ArrayList<WebElement>) div.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));

		Thread.sleep(10000);

		return li;
	}

	public void clickDisabledBookApp(int index) throws InterruptedException {
		WebElement tbody = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		td = (ArrayList<WebElement>) row.get(index).findElements(
				By.tagName("td"));
		td.get(10).click();
	}

	public boolean checkElementState(ArrayList<WebElement> li, int index) {
		String s = li.get(index).findElement(By.tagName("a"))
				.getAttribute("class");

		System.out.println("innerHtml" + s);

		if (s.contains("ui-state-disabled")) {

			return true;

		} else {
			return false;
		}
	}

	public void clickOnUrgent(int index) throws InterruptedException {
		bookAppointmentMenu(index, 1);
	}

	public void clickOnConfirmed(int index) throws InterruptedException {
		bookAppointmentMenu(index, 2);
	}

	public void clickonArrived(int index) throws InterruptedException {
		bookAppointmentMenu(index, 3);
	}

	public void clickONInclinic(int index) throws InterruptedException {
		bookAppointmentMenu(index, 4);
	}

	public void clickOnPayment(int index) throws InterruptedException {
		bookAppointmentMenu(index, 6);
	}

	public void clickOnInsuranceEnrolement(int index)
			throws InterruptedException {
		bookAppointmentMenu(index, 6);
	}

	public void clickOnAppointmentHistory(int index)
			throws InterruptedException {
		bookAppointmentMenu(index, 7);
	}

	public void clickOnReschedule(int index) throws InterruptedException {
		bookAppointmentMenu(index, 8);
	}

	public void clickOnSendReminder(int index) throws InterruptedException {
		bookAppointmentMenu(index, 9);
	}

	public void clickOnCancelAppoinment(int index) throws InterruptedException {
		bookAppointmentMenu(index, 11);
	}

	public void clickOnFutureAppointment(int index) throws InterruptedException {
		bookAppointmentMenu(index, 12);
	}

	public void clickOnPatientLogs(int index) throws InterruptedException {
		bookAppointmentMenu(index, 13);
	}

	public void clickOnPatientLeft(int index) throws InterruptedException {
		bookAppointmentMenu(index, 14);
	}

	public void clickOnCardStickert(int index) throws InterruptedException {
		bookAppointmentMenu(index, 15);
	}

	public void clickOnEditAppointment(int index) throws InterruptedException {
		bookAppointmentMenu(index, 16);
	}

	public void clickOnInitialHistory(int index) throws InterruptedException {
		bookAppointmentMenu(index, 17);
	}

	public void cancelAppointmentReason(String reason)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:cancelAppointmentForm:reason_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		Thread.sleep(1000);

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(reason)) {

				li.get(i).click();

				System.out.println("i came here");

				Thread.sleep(2000);
				break;

			} else {
				System.out.println("record not found");

			}
		}

	}

	public void clickOnReasonCancel() throws InterruptedException {
		divs = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:cancelAppointmentForm:reason"))
				.findElements(By.tagName("div"));
		Thread.sleep(1000);

		divs.get(2).click();

	}

	public void clickOkCancelAppointment() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:cancelAppointmentForm:cancelAppointmentOKButton"))
				.click();
	}

	public void clickCancelOnAppointment() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:cancelAppointmentForm:cancelAppointmentCancelButton"))
				.click();
	}

	public void clickOnOkAppointmentConfirmation() {
		driver.findElement(
				By.id("_AppointmentCalender_WAR_CloudClinikportlet_:AppointmentForm:ConfirmStatusOkButton"))
				.click();

	}

	public boolean verifyErrorMessage(String message) {
		WebElement div = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:allMessages"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"))
				.findElement(By.tagName("li"));

		if (div.findElement(By.tagName("span")).getText().contains(message)) {
			return true;

		} else {
			return false;

		}

	}

	public boolean getTime(String time, int index) {
		WebElement tbody = driver
				.findElement(
						By.id("_AppointmentCalender_WAR_CloudClinikportlet_:form:app"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody"));

		row = (ArrayList<WebElement>) tbody.findElements(By.tagName("tr"));

		td = (ArrayList<WebElement>) row.get(index).findElements(
				By.tagName("td"));

		if (td.get(1).getText().contains(time)) {
			return true;

		} else {
			return false;
		}
	}

}
