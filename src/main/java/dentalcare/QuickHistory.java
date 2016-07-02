package dentalcare;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickHistory {

	WebDriver driver;
	ArrayList<WebElement> select = new ArrayList<WebElement>();
	ArrayList<WebElement> options = new ArrayList<WebElement>();
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> divs = new ArrayList<WebElement>();

	public QuickHistory(WebDriver driv) {
		driver = driv;
	}

	public void clickQuickHistory() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:quickPatientHistoryBtn"))
				.click();
	}

	public void clickVisitDate() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:quickPatienthistory:dateFrom_input"))
				.click();
	}

	public void selectMonth(String month) throws InterruptedException {
		WebElement ele = driver.findElement(By
				.className(("ui-datepicker-title")));
		select = (ArrayList<WebElement>) ele.findElements(By.tagName("select"));
		select.get(0).click();
		Thread.sleep(1000);

		options = (ArrayList<WebElement>) select.get(0).findElements(
				By.tagName("option"));

		for (int i = 0; i < options.size(); i++) {

			if (options.get(i).getText().contains(month)) {
				options.get(i).click();
				break;
			} else {
				System.out.println("not found");
			}
		}

	}

	public void selectYear(String year) throws InterruptedException {
		WebElement ele = driver.findElement(By
				.className(("ui-datepicker-title")));
		select = (ArrayList<WebElement>) ele.findElements(By.tagName("select"));
		select.get(1).click();
		Thread.sleep(1000);

		options = (ArrayList<WebElement>) select.get(1).findElements(
				By.tagName("option"));

		for (int i = 0; i < options.size(); i++) {

			if (options.get(i).getText().contains(year)) {
				options.get(i).click();
				break;
			} else {
				System.out.println("not found");
			}
		}
	}

	public void selectDate(int date) throws InterruptedException {
		driver.findElement(By.linkText(String.valueOf(date))).click();
	}

	public void clickVistiToDate() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:quickPatienthistory:dateTo_input"))
				.click();
	}

	public void clickSearch() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:quickPatienthistory:j_idt840"))
				.click();
	}

	public void clickAllclinic() {
		// $('.ui-chkbox-box span').click();

		driver.findElement(By.className("ui-chkbox-box span'"))
				.findElement(By.tagName("span")).click();
	}

	public boolean verifyTable() {
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:quickPatienthistory:documentsDataTable_data"));

		String s = ele.findElement(By.tagName("tr"))
				.findElement(By.tagName("td")).getText();

		if (s.contains("No record found")) {
			return true;
		} else {
			return false;
		}
	}

	public void close() {
		driver.findElement(By.xpath(".//*[@id='_CCDENTAL_WAR_CCDENTALportlet_:j_idt832']/div[1]/a/span")).click();
	}

}
