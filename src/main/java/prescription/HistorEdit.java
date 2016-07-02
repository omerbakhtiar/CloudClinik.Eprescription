package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HistorEdit {

	WebDriver driver;
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> a = new ArrayList<WebElement>();

	public HistorEdit(WebDriver driv) {
		driver = driv;
	}

	public void selectHistory() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:btn_history_edit"))
				.click();

	}

	public void searchMr(String mr) throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:mrn"))
				.sendKeys(mr);

	}

	public void searchName(String name) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:pname"))
				.sendKeys(name);
	}

	public void searchButton() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:searchBtn"))
				.click();
	}

	public void selectCalender() {
		// driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:vdate_input")).sendKeys("");
		String s = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:j_idt50"))
				.toString();
		System.out.println(s);

		// driver.findElement(By.xpath("//*[@id='_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:vdate_input']")).click();

	}

	public void selectCurrent() {
		driver.findElement(By.linkText("Current Patient")).click();

	}

	public void close() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:closePrescriptionHistoryLink"))
				.click();
	}

	public boolean displayPopUp() {
		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:print_popup_id"))
				.isDisplayed();
	}

	public boolean verifyTable() throws InterruptedException {

		if (driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:dtdt:0:j_idt514"))
				.isDisplayed()) {
			return true;

		} else {
			return false;
		}
	}

	
	public boolean verifyInavlidTable(){
		WebElement ele=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:dtdt_data")).
				findElement(By.tagName("tr")).findElement(By.tagName("td"));
		
		if(ele.getText().contains("No records found.")){
			return true;
		}else {
			return false;
		}
				
	}
	
	public void editPrescrition(String date) throws InterruptedException{
		WebElement ele=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:dtdt_data"));
		
		row=(ArrayList<WebElement>) ele.findElements(By.tagName("tr"));
		
		td=(ArrayList<WebElement>) row.get(0).findElements(By.tagName("td"));
		WebElement element = driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:dtdt:0:j_idt514"));
		
			
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		
		System.out.println(td.get(0).findElement(By.tagName("span")).getText());
		
	}
	
}
