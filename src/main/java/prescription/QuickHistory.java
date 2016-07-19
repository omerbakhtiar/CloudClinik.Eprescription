package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class QuickHistory {
	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> tab = new ArrayList<WebElement>();

	public QuickHistory(WebDriver driv) {
		driver = driv;
	}

	public void clickQuickHistory() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:quickPatientHistoryBtn"))
				.click();
	}

	public boolean clickVisitFomDate(String date) throws InterruptedException {
		boolean result = driver
				.findElement(
						By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:dateFrom_input']"))
				.isDisplayed();

		driver.findElement(
				By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:dateFrom_input']"))
				.sendKeys(date);

		return result;
	}

	public void clickVisitToDate(String date) {
		driver.findElement(
				By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:dateTo_input']"))
				.sendKeys(date);
	}

	public void clickClinics() {
		driver.findElement(
				By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:allClinicsCheck']/div[2]"))
				.click();
	}

	public void clickSearch() {
		WebElement ele = driver
				.findElement(By
						.cssSelector("button[id^='_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:j_idt']"));
		ele.click();
	}

	public boolean clickSoap() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:documentsDataTable:0:quickPatientSoapNotes').click()");

		Thread.sleep(10000);

		// i think is being changed by the developer
		boolean result = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:printpatientfile:printDialogue"))
				.isDisplayed();

		return result;
	}

	public void close() {

		WebElement ele = driver.findElement(By.className("ui-overlay-visible"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"))
				.findElement(By.tagName("span"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);

	}

	public void closePdf() throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.cssSelector("a[id^='_Eprescription_WAR_CloudClinikportlet_:printpatientfile:j_idt']"));

		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);

	}

	public String errorMessage() {
		String s = driver
				.findElement(
						By.xpath("//*[@id='_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:documentsDataTable_data']/tr/td"))
				.getText();

		return s;
	}

	public int getTableSize() throws InterruptedException {
		WebElement table = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:quickPatienthistory:documentsDataTable"))
				.findElement(By.tagName("table"));
		Thread.sleep(10000);
		tab = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
		int size = tab.size();

		return size;
	}

}
