package dentalcare;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoryEdit {

	WebDriver driver;
	ArrayList<WebElement> tr = new ArrayList<WebElement>();

	public HistoryEdit(WebDriver driv) {
		driver = driv;
	}

	public void clickHistoryEdit() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:btn_history_edit"))
				.click();
	}

	public void insertMrNumber(String data) {
		WebElement myDynamicElement = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:mrn"));
		myDynamicElement.sendKeys(data);
	}

	public void insertName(String name) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:pname"))
				.sendKeys(name);
	}

	public void insertDate(String Date) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:vdate_input"))
				.sendKeys(Date);
	}

	public void search() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:searchBtn"));
		jse.executeScript("arguments[0].click();", element);
	}

	public void clickCurrentPatient() {
		driver.findElement(By.linkText("Current Patient")).click();
	}

	public boolean tableDisplayed(String s) {

		WebElement table = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:dtdt_data"));

		tr = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));

		String message = tr.get(0).findElement(By.tagName("td"))
				.findElement(By.tagName("span")).getText();

		if (message.contains(s)) {
			return true;
		} else {

			return false;

		}
	}

	public void clickEpres() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:dtdt:0:j_idt18"))
				.click();
	}

	public void clickCurrentErpes() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:hstry_current_dt:0:j_idt39"))
				.click();
	}

}
