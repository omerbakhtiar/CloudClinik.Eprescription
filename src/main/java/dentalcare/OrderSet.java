package dentalcare;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSet {

	WebDriver driver;
	ArrayList<WebElement> div = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();

	public OrderSet(WebDriver driv) {
		driver = driv;
	}

	public void clickNew() {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:orserSets:j_idt812")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:orserSets:j_idt812').click()");
	}

	public void setOrderSetName(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:OrderSetName")));

		element.sendKeys(name);
	}

	public void setComlaintsSet(String complaint) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:complaints_input"))
				.sendKeys(complaint);
	}

	public void selectComplaint() {
		WebElement el = driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:complaints_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"));
		el.click();

	}

	public void setDoctorNotes(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:doc_notes_area"))
				.sendKeys(data);
	}

	public void clickTemplates() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:dosNotesTemplateBtn"))
				.click();
	}

	public void insertDieases(String diease) {
		WebElement element = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:diagnostics_input"));
		element.sendKeys(diease);
	}

	public void selectDiease() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:diagnostics_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickFavoriteDiease() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:diagnosticsFavorite"))
				.click();
	}

	public void searchFavoriteDiease(String data) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_primary:searchIcd")));

		element.sendKeys(data);
	}

	public void clicksearchValueDiease() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_primary:dt_ficd_primary:0:applyFavPrimaryIcdLink"))
				.click();
	}

	public void searchDieaseButton() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_primary:searchFavPrimaryIcdBtn"))
				.click();
	}

	public boolean displayFavoriteDieseaPop() {
		return driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_icds_popup_primary"))
				.isDisplayed();
	}

	public void insertProcedure(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:procedures_input"))
				.sendKeys(data);
	}

	public void selectProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:procedures_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:proceduresFavorite"))
				.click();
	}

	public void searcFavoriteProcedure(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup_form:searchCpt"))
				.sendKeys(data);
	}

	public void srFavoriteButton() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup_form:searchFavProcedureBtn"))
				.click();
	}

	public void clickFavoriteProcedureData() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup_form:dt_dg:0:applyFavProcedureLink"))
				.click();
	}

	public void closeFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup_form:closeCptFavoritePopup"))
				.click();
	}

	public void insertAdditionalDiagnosis(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:additionalDiagnosis_input"))
				.sendKeys(data);
	}

	public void selectAdditionalDiagnosis() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:additionalDiagnosis_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickFavoriteAddDiagnosis() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:additionalDiagnosisFavorite"))
				.click();
	}

	public void searchFavoriteDiagnosisData(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:searchIcd"))
				.sendKeys(data);
	}

	public void searchFavoriteDiagnosis() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:searchFavIcdBtn"))
				.click();
	}

	public void clickFavoriteDiagnosis() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:dt_ficd:0:applyFavIcdLink"))
				.click();
	}

	public void selectFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:proceduresFavorite"))
				.click();
	}

	public void searchFavoriteDataPro() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup_form:searchFavProcedureBtn"))
				.click();
	}

	public void selectProcedureList() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:procedures_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void selectAdditionalDiagnosisList() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:additionalDiagnosis_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();

	}

	public void clickAddMedcine() {
		WebElement element = driver.findElement(By
				.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:addMedication"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		// actions.click();
		actions.perform();

		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:addMedication"))
				.click();
	}

	public void insertMedicine(String data, int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
						+ index + ":md_medicine_input")).sendKeys(data);
	}

	public void selectMedcine(int index) throws InterruptedException {
		WebElement ele = driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
						+ index + ":md_medicine_panel")).findElement(
				By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		Thread.sleep(1000);
		li.get(1).click();

	}

	public void insertDose(double data, int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
						+ index + ":dozeId_input")).sendKeys(
				String.valueOf(data));
	}

	public void insertFrequency(String name, int index) {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
								+ index + ":selectFreq")));

		div = (ArrayList<WebElement>) element.findElements(By.tagName("div"));
		div.get(2).click();
		callFrequency(index, name);
	}

	public void callFrequency(int index, String name) {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
								+ index + ":selectFreq_panel"))).findElement(
						By.tagName("div"));

		li = (ArrayList<WebElement>) element.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(name)) {
				li.get(i).click();
			} else {

			}
		}

	}

	public void insertDuration(double data) {
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:0:dura_input"));
		ele.clear();
		ele.sendKeys(String.valueOf(data));
	}

	public void insertRoute(int index, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
								+ index + ":selectRoute")));

		div = (ArrayList<WebElement>) element.findElements(By.tagName("div"));
		div.get(2).click();
		selectRoute(index, value);

	}

	public void selectRoute(int index, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:medicationDT:"
								+ index + ":selectRoute_panel")));

		li = (ArrayList<WebElement>) element.findElement(By.tagName("div"))
				.findElement(By.tagName("ul")).findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(value)) {
				li.get(i).click();
			}

		}
	}

	public void save() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:os_btn_presc_sign"));
		jse.executeScript("arguments[0].click();", element);

	}

	public void applyTemplate(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("_CCDENTAL_WAR_CCDENTALportlet_:nt_form:dt_nt_data")));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			td = (ArrayList<WebElement>) tr.get(i).findElements(
					By.tagName("td"));

			if (td.get(0).getText().contains(name)) {
				System.out.println(td.get(0).getText());

				td.get(1).findElement(By.tagName("a")).click();
			}

		}

	}

	public void clickTemplate() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:dosNotesTemplateBtn"))
				.click();
	}

	public void cancel() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:os_form:cancelDosBtn"))
				.click();
	}

	public void apply(String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:orserSets:dt_orderset_data"));
		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			td = (ArrayList<WebElement>) tr.get(i).findElements(
					By.tagName("td"));

			if (td.get(1).getText().contains(name)) {
				WebElement element = td.get(2).findElement(By.tagName("a"));
				js.executeScript("arguments[0].click();", element);

			} else {
				System.out.println("template not found");
			}
		}
	}

	public void closeOrderSet() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:orserSets:j_idt823"))
				.click();
	}

}
