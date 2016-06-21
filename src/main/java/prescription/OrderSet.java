package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSet {

	WebDriver driver;
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> div = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> span = new ArrayList<WebElement>();
	boolean result;

	public OrderSet(WebDriver driv) {
		driver = driv;
	}

	public void selectOrderSet() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:btn_os"))
				.click();

	}

	public void clickAddNew() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:orderSetForm:j_idt75').click()");

	}

	public void setOrderSetName(String name) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:OrderSetName"))
				.sendKeys(name);

	}

	public void setComplaints(String complaint) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:complaints_input"))
				.sendKeys(complaint);
		Thread.sleep(10000);
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:complaints_panel"));
		ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();

	}

	public void setDoctorNotes(String notes) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:doc_notes_area"))
				.sendKeys(notes);
	}

	public void clickTemplates() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:osApplyTemplateBtn"))
				.click();
	}

	public void addTemplate() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_nt_form:dt_nt:0:osNotesTemplateLink"))
				.click();

	}

	public void addDisease() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:addDisease').click()");

	}

	public void clickFavoriteDisease() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(200000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseFavoriteBtn').click()");

	}

	public void addDieaseData(String diease) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT:0:disease_input"))
				.sendKeys(diease);

		Thread.sleep(10000);

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT:0:disease_panel"));
		ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();

	}

	public void favouriteDieaseData(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:searchIcd"))
				.sendKeys(data);
	}

	public void favouriteSearch() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:searchFavoriteDisseaseBtn"))
				.click();
	}

	public void selectFavouriteSearch() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.linkText("K02.1:Caries of dentine")).click();
	}

	public void addProcedureTreatment() throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addDiagnositic"))
				.click();

	}

	public void closeNotesTemplate() {
		driver.findElement(
				By.xpath("//div[@id='_Eprescription_WAR_CloudClinikportlet_:j_idt64']/div/a/span"))
				.click();

	}

	public void save() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:os_btn_presc_sign').click()");

	}

	public void closeFavoriteDiaglog() {
		driver.findElement(
				By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:j_idt24']/div[1]/a"))
				.click();
	}

	public void closeDialogButtonFavorite() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:closeDiseaseFavoritePopup"))
				.click();
	}

	public void addProcedureClick() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addDiagnositic"))
				.click();
	}

	public void addProcedureData(String data) throws InterruptedException {
		// GEN03 : Emergency Call
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:0:diagnostics_input"));
		ele.sendKeys(data);

		Thread.sleep(10000);

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:0:diagnostics_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void addProcedureNote(String note) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:0:osProcedureNote"))
				.sendKeys(note);

	}

	public void clickFavoriteProcedure() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:os_form:favoriteDiagnostic').click()");
	}

	public void sendFavoriteProcedure(String data) {
		// INS65 : Tmj Appliance For Tounge Habit
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:searchCpt"))
				.sendKeys(data);
	}

	public void searchFavoriteSearchProcedure() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:searchFavProcedureBtn"))
				.click();
	}

	public void selectFarovriteSearchDataProcedure() {
		driver.findElement(
				By.linkText("INS65 : Tmj Appliance For Tounge Habit")).click();
	}

	public void selectFavoriteSearchClose() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:closeDiagnosticFavoritePopup"))
				.click();
	}

	public void closeOrderSetDiaglog() {
		((JavascriptExecutor) driver)
				.executeScript("$('.ui-dialog-titlebar-icon').click();");
	}

	public void setFavoriteProcedureNote(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:1:osProcedureNote"))
				.sendKeys(data);
	}

	public void addLabButton() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addLoinc"))
				.click();
	}

	public void clickFavoriteLab() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:applyFavoriteLoinc"))
				.click();
	}

	public void labSetData(String data, int index) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
						+ index + ":loincCode_input")).sendKeys(data);
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
						+ index + ":loincCode_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickFavoriteButtonLab() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:applyFavoriteLoinc"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(10000);
		ele.click();
	}

	public void searchFavoriteLab(String data) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchLoinc"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(data);
	}

	public void clickSearchFavoriteLab() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchFavPrLabBtn"))
				.click();
	}

	public void selectFavoriteSearchValueLabandSet(String data) {
		// 1002 lab set
		// 5866-9 lab
		driver.findElement(By.partialLinkText(data)).click();
	}

	public void searchFavoriteLab() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchFavPrLabBtn"))
				.click();
	}

	public void closeLabFavorite() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:closeLoincFavoritePopup"))
				.click();
	}

	public void setLabsetInstructions(String labset, int index) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
						+ index + ":loincInstructions")).sendKeys(labset);

	}

	public void addMedicieneButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:addMedicationBtn"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		ele.click();
	}

	public void setMedicineData(String data, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:"
						+ index + ":md_medicine_input")).sendKeys(data);

		Thread.sleep(10000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:md_medicine_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void insertDosageUnit(String data, int index)
			throws InterruptedException {

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:"
						+ index + ":dozeId_input")).clear();

		Thread.sleep(10000);

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:"
						+ index + ":dozeId_input")).sendKeys(data);
	}

	public void setMedicineFrequency(int val, int index) {
		driver.findElement(
				By.xpath("//*[@id='_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:selectFreq']/div[3]"))
				.click();

		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:selectFreq_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		li.get(1).click();

	}

	public void setMedicineDuration(String duration, int index)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:"
								+ index + ":dura_input"));
		ele.clear();

		Thread.sleep(10000);
		ele.sendKeys(duration);
	}

	public void setMedicineRoute(int index) throws InterruptedException {

		driver.findElement(
				By.xpath("//*[@id='_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:selectRoute']/div[3]"))
				.click();
		Thread.sleep(1000);

		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:0:selectRoute_panel"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));

		li.get(1).click();

		/*
		 * ((JavascriptExecutor) driver) .executeScript(
		 * "$('#_Eprescription_WAR_CloudClinikportlet_\\:os_form\\:medicationDT\\:"
		 * + index+"\\:selectRoute_panel li\\:nth-child(3)').click();");
		 */
	}

	public void setDietInstruction(String diet) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:suggestions_input"))
				.sendKeys(diet);
	}

	public void clickFavoriteMedicine() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:favoriteMedicationBtn"))
				.click();
	}

	public void setSearchFavoriteValueMedicine(String medicine)
			throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:searchMed').value='"
				+ medicine + "';");
	}

	// document.getElementById('_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:searchMed').value="Advance";

	public void searchMedButton() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:searchFavMedicinBtn"))
				.click();

	}

	public void selectFavoriteMedSearchData(String name)
			throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText(name)).click();
	}

	public void closefavoriteMedPopUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:closeMedicineFavoritePopup').click()");
	}

	public void applyOrderSet(String templateName) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		row = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset_data"))
				.findElements(By.tagName("tr"));
		for (int i = 0; i < row.size(); i++) {

			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			String id = "_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset"
					+ ":" + i + ":j_idt84";
			WebElement ele = driver.findElement(By.id(id));

			if (td.get(1).getText().contains(templateName)) {
				jse.executeScript("arguments[0].click()", ele);
			}
		}
	}

	public void deleteOrderSet(String templateName) throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		row = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset_data"))
				.findElements(By.tagName("tr"));
		for (int i = 0; i < row.size(); i++) {

			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			String id = "_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset"
					+ ":" + i + ":j_idt84";

			// _Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset:0:j_idt87

			String deleteid = "_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset:"
					+ i + ":j_idt87";

			WebElement ele = driver.findElement(By.id(deleteid));

			if (td.get(1).getText().contains(templateName)) {
				jse.executeScript("arguments[0].click();", ele);
				Thread.sleep(1000);
				driver.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:deleteOrderSetConfirmationForm:j_idt95"))
						.click();
				break;

			}
		}
	}

	public void editOrderSet(String templateName) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		row = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset_data"))
				.findElements(By.tagName("tr"));
		for (int i = 0; i < row.size(); i++) {

			td = (ArrayList<WebElement>) row.get(i).findElements(
					By.tagName("td"));

			String id = "_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset"
					+ ":" + i + ":j_idt84";

			// _Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset:0:j_idt87

			String editid = "_Eprescription_WAR_CloudClinikportlet_:orderSetForm:dt_orderset:"
					+ i + ":j_idt78";

			WebElement ele = driver.findElement(By.id(editid));

			if (td.get(1).getText().contains(templateName)) {
				jse.executeScript("arguments[0].click();", ele);
				Thread.sleep(1000);
				break;

			}
		}
	}

	public void closeOrderSetMainWindow() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:orderSetForm:j_idt90').click()");

	}

	public void deleteDiseases() throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT"))
				.findElement(By.tagName("tbody"));

		row = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int j = row.size(); j > 0; j--) {

			int i = 0;
			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT:"
							+ i + ":deleteOsDisease")).click();

			if (i == 1) {
				i = 0;
			}

		}
	}

	public void deleteProcedure() {
		// _Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT

		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT"))
				.findElement(By.tagName("tbody"));

		row = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int j = row.size(); j > 0; j--) {

			int i = 0;

			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT:"
							+ i + ":deleteOsProcedure")).click();

			if (i == 1) {
				i = 0;
			}

		}
	}

	public String verfiydeleteProcedure() {
		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diagnosticDT"))
				.findElement(By.tagName("tbody")).findElement(By.tagName("tr"))
				.findElement(By.tagName("td")).getText();
	}

	public void deleteLabSet() throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT"))
				.findElement(By.tagName("tbody"));

		row = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int j = row.size(); j > 0; j--) {

			int i = 0;

			boolean result = driver
					.findElement(
							By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
									+ i + ":j_idt145")).isDisplayed();
			if (result == true) {
				driver.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT:"
								+ i + ":j_idt145")).click();
				Thread.sleep(1000);
			} else {
				break;
			}

			if (i == 1) {
				i = 0;
			}
		}
	}

	public String verifyDeleteLab() {
		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:loincDT_data"))
				.findElement(By.tagName("tbody")).findElement(By.tagName("tr"))
				.findElement(By.tagName("td")).getText();
	}

	public void deleteMedicine() throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT"))
				.findElement(By.tagName("tbody"));
		row = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));
		int i = 0;
		for (int j = row.size(); j > 0; j--) {

			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT:"
							+ i + ":deleteOsMedication")).click();
			i++;
			Thread.sleep(10000);
			if (i == 1) {
				i = 0;
			}
		}

	}

	public String verifyDeleteMedicine() {
		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:medicationDT"))
				.findElement(By.tagName("tbody")).findElement(By.tagName("tr"))
				.findElement(By.tagName("td")).getText();
	}

	public void deleteComplaints() throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:complaints"));

		li = (ArrayList<WebElement>) ele.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < li.size() - 1; i++) {
			
			
			span = (ArrayList<WebElement>) li.get(i).findElements(
					By.tagName("span"));
			Thread.sleep(1000);
			span.get(1).click();
			
		}
	}

	public String complaintMessage() {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:complaints_input"));
		return ele.getText();
	}

	public void deleteInstruction() {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:os_form:suggestions"));

		li = (ArrayList<WebElement>) ele.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < li.size() - 1; i++) {
			span = (ArrayList<WebElement>) li.get(i).findElements(
					By.tagName("span"));
			span.get(1).click();

		}
	}

	public void clickUpdate() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:os_btn_presc_update"))
				.click();
	}

	public String verifyDeletedDieases() {

		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:diseaseDT"))
				.findElement(By.tagName("tbody")).findElement(By.tagName("tr"))
				.findElement(By.tagName("td")).getText();
	}

	public void closeMainWindow() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("$('.ui-icon.ui-icon-closethick').click();");

	}

	public void deleteDoctorNotes() throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:doc_notes_area"))
				.clear();
	}

	public String viewdeleteNotes() throws InterruptedException {
		String s;
		Thread.sleep(10000);
		s = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:doc_notes_area"))
				.getText();
		return s;
	}

	public boolean sucessfulUpdateMessage() {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:os_form:j_idt101"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"))
				.findElement(By.tagName("li")).findElement(By.tagName("span"));

		if (ele.getText().contains("Order Set updated successfully")) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

}
