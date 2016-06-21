package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class VitalHistory {
	WebDriver driver;
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<VitalData> vi = new ArrayList<VitalData>();
	boolean result;

	public VitalHistory(WebDriver driv) {
		driver = driv;
	}

	public void clickVitalHistory() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:vitalPatientHistory"))
				.click();
	}

	public void insertFromDate(String date) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryForm:dateFrom_input"))
				.sendKeys(date);
	}

	public void visitToDate(String date) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryForm:dateTo_input"))
				.sendKeys(date);
	}

	public void search() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryForm:j_idt408"))
				.click();
	}

	public void clickAllClinic() {
		driver.findElement(
				By.cssSelector("div[id='_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryForm:allClinicsCheck']"))
				.findElement(By.cssSelector("div[class='ui-chkbox-box ']"))
				.click();

	}

	public void clickAddPatient() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryForm:save_button"))
				.click();
	}

	public void insertTemp(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:temp"))
				.sendKeys(data);
	}

	public void insertRespRate(String rate) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:respRate"))
				.sendKeys(rate);
	}

	public void insertBpFirst(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:systolic"))
				.sendKeys(data);
	}

	public void insertBpSecond(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:dias"))
				.sendKeys(data);
	}

	public void insertHeight(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:height"))
				.sendKeys(data);
	}

	public void insertPulse(String pulse) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:pulse"))
				.sendKeys(pulse);
	}

	public void clickRandom() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:bsl_type:0"))
				.click();
	}

	public void clickFasting() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:bsl_type"))
				.click();
	}

	public void insertBloodSugarData(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:bsl"))
				.sendKeys(data);
	}

	public void insertNotes(String notes) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:vital_notes"))
				.sendKeys(notes);
	}

	public void saveData() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:vitalsForm:save_buttn').click();");
	}

	public void selectTempPoint(String data) throws InterruptedException {
		td = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:temp_point"))
				.findElements(By.tagName("div"));
		td.get(2).click();
		Thread.sleep(1000);
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:temp_point_panel"))
				.findElement(By.tagName("ul"));

		Thread.sleep(10000);

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getText().contains(data)) {
				li.get(i).click();
			}
		}

	}

	public void insertWeight(String data) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalsForm:weight"))
				.sendKeys(data);
	}

	public void closeAddPatientVital() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:addPatientVital"))
				.findElement(By.tagName("a")).click();
	}

	public void closeVitalHistory() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryDialog"))
				.click();
	}

	public void getTableData(String date) {

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:vitalPatientHistoryForm:j_idt410_data"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			td = (ArrayList<WebElement>) tr.get(i).findElements(
					By.tagName("td"));

			if (td.get(0).getText().contains(date)) {

				VitalData data = new VitalData(td.get(0).getText(), td.get(1)
						.getText(), td.get(2).getText(), td.get(3).getText(),
						td.get(4).getText(), td.get(5).getText(), td.get(6)
								.getText(), td.get(7).getText(), td.get(8)
								.getText(),td.get(9).getText());

				vi.add(data);
			}
		}

	}

	public boolean verifyTableData(String date, String temp, String bp,
			String pulse, String RR, String Height, String weight, String BMI,
			String Notes, String BSL) {

		for (int i = 0; i < vi.size(); i++) {

			if (vi.get(i).getDate().contains(date)
					&& vi.get(i).getTemprature().contains(temp)
					&& vi.get(i).getbpt().contains(bp)
					&& vi.get(i).getPulse().contains(pulse)
					&& vi.get(i).getRR().contains(RR)
					&& vi.get(i).getHeight().contains(Height)
					&& vi.get(i).getWeight().contains(weight)
					&& vi.get(i).getNotes().contains(Notes)
					&& vi.get(i).getBMI().contains(BMI)
					&& vi.get(i).getBSL().contains(BSL)) {
				result = true;
				
			} else {
				result = false;
				
			}
		}

		return result;
		
	}

}
