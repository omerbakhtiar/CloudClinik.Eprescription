package ePrescriptionM.CloudClinik.Eprescription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import patient.ChronicDisease;
import patient.Pateintvital;
import prescription.LabHistory;
import bookApointment.Appointment;
import framework.Login;
import ePrescriptionM.CloudClinik.Eprescription.*;

public class Epres {

	public class MedicineRecord {

		public MedicineRecord(String val, String diease, String dose,
				String frequency, String duration, String route, String refills) {
			// TODO Auto-generated constructor stub
		}

		public char[] getDiagnosis() {
			// TODO Auto-generated method stub
			return null;
		}

		public char[] getDoze() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private WebDriver driver;
	boolean result;
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<WebElement> input = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> div = new ArrayList<WebElement>();
	List<String> myList = new ArrayList<String>();
	List<String> notes = new ArrayList<String>();
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	String s;

	ArrayList<MedicineRecord> med = new ArrayList<MedicineRecord>();

	public Epres(WebDriver driv) {
		driver = driv;

	}

	public void clickEpres() throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.id("left-col"))
				.findElement(By.tagName("ul"))
				.findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele
				.findElements(By.tagName("li"));

		Thread.sleep(1000);
		divs.get(1).click();
	}

	public String Searching() throws IOException, InterruptedException {

		ArrayList<WebElement> arr = new ArrayList<WebElement>();

		Login log = new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("974100232884", "infogistic@1");

		Pateintvital vi = new Pateintvital(driver);
		Thread.sleep(20000);
		vi.searchPatient();

		Appointment app = new Appointment(driver);
		Thread.sleep(10000);

		arr = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:patientSearchForm:MyPatients_content"))
				.findElements(By.tagName("div"));
		Thread.sleep(20000);

		arr.get(2).findElement(By.tagName("input")).sendKeys("974100301865");

		Thread.sleep(10000);

		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:patientSearchForm:patientSearchBtn"))
				.click();
		Thread.sleep(10000);

		vi.clicktable();

		Thread.sleep(1000);

		return s;

	}

	public void selectInsurance() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("document.querySelector('[id^='"
				+ "_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable:0:j_"
				+ "]').click()");

	}

	public void selectInsuranceOption() {
		ArrayList<WebElement> divs = (ArrayList<WebElement>) driver
				.findElements(By.className("ui-radiobutton "));

		ArrayList<WebElement> subdivs = (ArrayList<WebElement>) divs.get(1)
				.findElements(By.tagName("div"));
		subdivs.get(1).click();

	}

	public void clickCurrentPatient() {
		driver.findElement(By.linkText("Current Patient")).click();
	}

	public void selectCancel() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:cancel_pres_btn').click()");

	}

	public String selectSeenPatient(String name) throws InterruptedException {

		WebElement ele = driver
				.findElement(By
						.id("_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients"));
		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//*[@id='_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients:0:theLink']"))
				.click();

		// System.out.println(tr.size());

		/*
		 * for(int i=0;i<tr.size();i++){
		 * 
		 * if(driver.findElement(By.xpath(
		 * "//*[@id='_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients:"
		 * +i+":theLink']")).getText().contains(name)){
		 * tr.get(i).findElement(By.
		 * tagName("td")).findElement(By.tagName("a")).click();
		 * s="contains result"; }else{ s="does not contain result";
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * Thread.sleep(1000); js.executeScript(
		 * "document.getElementById(\'_Eprescription_WAR_CloudClinikportlet_:presc_form:cancel_pres_btn\').click()"
		 * );
		 * 
		 * }8/ }
		 */

		return s;
	}

	public Boolean getComplaintData(ArrayList<String> array) {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:complaints"))
				.findElement(By.tagName("ul"));

		li = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		String s = li.get(0).getText().toString();

		System.out.println(s);

		for (int i = 0; i < array.size(); i++) {

			if (li.get(i).getText().contains(array.get(i))) {
				result = true;

			} else {
				result = false;

			}
		}

		return result;
	}

	public Boolean getDoctorNotes(String value) {
		String s = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:doc_notes_area"))
				.getText();

		if (s.contains(value)) {
			System.out.println(s);
			result = true;

		} else {
			result = false;
		}

		return result;
	}

	public Boolean getDieasesData(ArrayList<String> data)
			throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diseaseDT"))
				.findElement(By.tagName("tbody"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		System.out.println(tr.size());

		for (int i = 0; i < tr.size(); i++) {
			String val = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:diseaseDT:"
							+ i + ":disease_hinput').value");

			System.out.println(val.toString());
			if (val.contains(data.get(i))) {
				result = true;
			} else {
				result = false;
			}

		}

		return result;

	}

	public Boolean getProcedureData(ArrayList<String> data,
			ArrayList<String> notes) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT"))
				.findElement(By.tagName("tbody"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			String val = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
							+ i + ":diagnostics_hinput').value");

			System.out.println(val.toString());

			if (val.contains(data.get(i))) {
				result = true;
			} else {
				result = false;
			}
		}

		for (int i = 0; i < tr.size(); i++) {

			String note = (String) js
					.executeScript("return  document.getElementById('_Eprescription_WAR_CloudClinikportlet_:presc"
							+ "_form:diagnosticDT:"
							+ i
							+ ":procedureNote').value");

			if (note.contains(notes.get(i))) {
				result = true;
				System.out.println(note);

			} else {
				result = false;
			}
		}

		return result;
	}

	public void clickOptionLabSet(int index) {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT_data"));
		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));
		td = (ArrayList<WebElement>) tr.get(index).findElements(
				By.tagName("td"));

		td.get(0).findElement(By.tagName("div")).click();
	}

	public Boolean getLabData(ArrayList<String> lab, ArrayList<String> notes) {
		boolean labs = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:1:j_idt666:0:j_idt668"))
				.isDisplayed();
		WebElement reslt = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:0:loincResult"));
		String res = reslt.getText();

		System.out.println(res);

		return result;

	}

	public void getLabSet() {
		WebElement ele = driver
				.findElement(By
						.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT_data']/tr[4]/td/div/div[1]/div[1]"));

		System.out.println(ele.getText());

	}

	public void verifyMedicineData(int index) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement table = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT"))
				.findElement(By.tagName("tbody"));

		Actions actions = new Actions(driver);
		actions.moveToElement(table);

		tr = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			String val = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
							+ ":presc_form:medicationDT:"
							+ i
							+ ":md_medicine_hinput').value");

			String diease = (String) js
					.executeScript("return document.getElementById('"
							+ "_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
							+ i + ":j_idt684_label')" + ".textContent");

			String dose = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
							+ ":presc_form:medicationDT:"
							+ i
							+ ":md_dozeId_input')" + ".value;");

			String frequency = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
							+ ":presc_form:medicationDT:"
							+ i
							+ ":selectFreq_label')" + ".textContent");

			String duration = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
							+ ":presc_form:medicationDT:"
							+ i
							+ ":md_duration_input')" + ".value");

			String route = (String) js
					.executeScript("return document.getElementById('"
							+ "_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
							+ i + ":" + "selectRoute_label')" + ".textContent");

			String refills = (String) js
					.executeScript("return document.getElementById('_Eprescription_WAR_CloudClinikportlet_"
							+ ":presc_form:medicationDT:0:medicineRefills_input"
							+ "')" + ".value");

			MedicineRecord record = new MedicineRecord(val, diease, dose,
					frequency, duration, route, refills);

			med.add(record);

		}
	}

	/*
	 * public boolean verifyMedicine(ArrayList<String> dig, ArrayList<String>
	 * doz) {
	 * 
	 * for (int i = 0; i < med.size(); i++) {
	 * 
	 * if (med.get(i).getDiagnosis().contains(dig.get(i)) &&
	 * med.get(i).getDoze().contains(doz.get(i))) { result = true;
	 * 
	 * } else { result = false;
	 * 
	 * } }
	 * 
	 * return result; }
	 */

	public void printData() {
		for (int i = 0; i < med.size(); i++) {
			System.out.println(med.get(i).getDiagnosis());
			System.out.println((med.get(i)).getDoze());
		}
	}

	public void insertComplaints(String complaint) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:complaints_input"))
				.sendKeys(complaint);
		Thread.sleep(1000);
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:complaints_panel"));
		ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();

	}

	public void insertDoctorNotes(String notes) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:doc_notes_area"))
				.sendKeys(notes);
	}

	public void clickAddDiease() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:addDiagnosisBtn"))
				.click();
	}

	public void clickFavoriteDiease() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyFavoriteDiagnosis"))
				.click();
	}

	public void searchDiseaseFovrite(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:searchIcd"))
				.sendKeys(data);
	}

	public void clickFavoriteDieaseSearch() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:searchFavoriteDisseaseBtn"))
				.click();
	}

	public void selectFavoriteDiease(String data) {
		driver.findElement(By.partialLinkText(data)).click();
	}

	public void closeFavoriteDieasePopUp() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:icd_popup_form:closeDiseaseFavoritePopup"))
				.click();
	}

	public void adddieaseData(String data, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diseaseDT:"
						+ index + ":disease_input")).sendKeys(data);

		Thread.sleep(10000);

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diseaseDT:"
								+ index + ":disease_panel"));
		ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();
	}

	public void addProcedureTreatmentButton() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:getd"))
				.click();

	}

	public void addManualProcedureData(String data, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
						+ index + ":diagnostics_input")).sendKeys(data);

		Thread.sleep(10000);

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
								+ index + ":diagnostics_panel"));

		ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();
	}

	public void addProcedureQuantity(int data, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
						+ index + ":procedureQuantity_input")).clear();
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
						+ 0 + ":procedureQuantity_input")).sendKeys(
				String.valueOf(data));
	}

	public void addFavoriteProcedureButton() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyFavoriteProcedure"))
				.click();
	}

	public void addFvoriteProcedureData(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:searchCpt"))
				.sendKeys(data);
	}

	public void searchFavorieProceudreClick() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:searchCpt"))
				.click();
	}

	public void selectSearchProcedure(String data) {
		driver.findElement(By.partialLinkText(data)).click();
	}

	public void closeFavoriteProcedurePopUp() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_diagnostic_popup_form:closeDiagnosticFavoritePopup"))
				.click();
	}

	public String checkProcedurePrice() {
		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:checkPricesBtn"))
				.getText();
	}

	public void addProcedureNotes(String data, int index) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:diagnosticDT:"
						+ index + ":procedureNote")).sendKeys(data);
	}

	public void addLabSetButton() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:addLoinc"))
				.click();
	}

	public boolean addLabSetData(int index, String data)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
						+ index + ":loincCode_input")).sendKeys(data);

		Thread.sleep(10000);

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
								+ index + ":loincCode_panel"));

		ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();

		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
								+ index + ":loincCode_input")).isDisplayed();
	}

	public void insertLabInstruction(String data, int index) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
						+ index + ":loincInstructions")).sendKeys(data);
	}

	public void clickLabRC(int index) {
		// $('#_Eprescription_WAR_CloudClinikportlet_\\:presc_form\\:loincDT_data
		// tr td:first div').click();

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT_data"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		td = (ArrayList<WebElement>) tr.get(index).findElements(
				By.tagName("td"));

		td.get(0).findElement(By.tagName("div")).click();
	}

	public boolean insertResultLab(int index, String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
						+ index + ":loincResult")).sendKeys(data);

		return driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
								+ index + ":loincResult")).isDisplayed();
	}

	public void insertCommentsLab(int index, String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
						+ index + ":loincResultComments")).sendKeys(data);
	}

	public void insertLabSetResult(int index, String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
						+ index + ":j_idt666:" + index + ":loincSetResult"))
				.sendKeys(data);
	}

	public void insertLabSetComments(int index, String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:"
						+ index
						+ ":j_idt666:"
						+ index
						+ ":loincSetResultComments")).sendKeys(data);
	}

	public void clickFavoriteLab() throws InterruptedException {
		WebElement element = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyFavoriteLoinc"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyFavoriteLoinc"))
				.click();
	}

	public boolean FavoriteLabPopupDisplayed() {
		return driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:j_idt14"))
				.isDisplayed();
	}

	public void searchFavoriteLabData(String data) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchLoinc"))
				.clear();
		Thread.sleep(10000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchLoinc"))
				.sendKeys(data);
	}

	public void clickSearchFavoriteLab() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:searchFavPrLabBtn"))
				.click();
	}

	public void selectFavoirteLabSearch(String st) {
		driver.findElement(By.partialLinkText(st)).click();
	}

	public void closeFavoriteLabPopUp() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_loinc_popup_form:closeLoincFavoritePopup"))
				.click();
	}

	public void clickAddMedicine() throws InterruptedException {

		WebElement element = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:addMedication"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:addMedication"))
				.click();

	}

	public void insertMedcineData(String data, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":md_medicine_input")).sendKeys(data);

		Thread.sleep(10000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":md_medicine_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickFavoriteMedicine() throws InterruptedException {
		WebElement element = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyFavoriteMedication"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyFavoriteMedication"))
				.click();
	}

	public void insertFavoriteMedicineData(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:searchMed"))
				.sendKeys(data);
	}

	public void clickSearchFavoriteMedicine() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:searchFavMedicinBtn"))
				.click();
	}

	public void insertDoseUnit(String data, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":md_dozeId_input")).clear();
		Thread.sleep(1000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":md_dozeId_input")).sendKeys(data);
	}

	public void insertMedicineFrequency(String name)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:0:selectFreq"));
		div = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		Thread.sleep(1000);
		div.get(2).click();

		Thread.sleep(1000);

		WebElement el = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:0:selectFreq_panel"))
				.findElement(By.tagName("div"));

		li = (ArrayList<WebElement>) el.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(name)) {
				li.get(i).click();
			} else {

			}
		}

	}

	public void insertMedcineDuration(double duration, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ "" + index + ":md_duration_input")).clear();

		Thread.sleep(1000);

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ "" + index + ":md_duration_input")).sendKeys(
				String.valueOf(duration));
	}

	public void insertMedicineRoute(int index, String value)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
								+ index + ":selectRoute"));
		Thread.sleep(1000);

		div = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		div.get(2).click();

		Thread.sleep(10000);
		WebElement el = driver
				.findElement(By
						.id(""
								+ "_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
								+ index + ":selectRoute_panel"));

		li = (ArrayList<WebElement>) el.findElement(By.tagName("div"))
				.findElement(By.tagName("ul")).findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(value)) {
				li.get(i).click();
			}

		}

	}

	public void insertMedicineRfills(int amount, int index)
			throws InterruptedException {

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":medicineRefills_input")).clear();
		Thread.sleep(1000);

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":medicineRefills_input")).sendKeys(
				String.valueOf(amount));

	}

	public void insertDietInstruction(String data) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:suggestions_input"))
				.sendKeys(data);
		Thread.sleep(1000);
	   WebElement ele=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:suggestions_panel"));
	   ele.findElement(By.tagName("ul")).findElement(By.tagName("li")).click();
	}

	public void clickFavoriteMedicineSRecord(String path) {
		driver.findElement(By.partialLinkText(path)).click();
	}

	public void clickDosageCalculator() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:dosageCalculator"))
				.click();
	}

	public void selectDosageCalType(String name) {

		if (name == "Clark'sRule") {
			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:options:0"))
					.click();

		} else if (name == "Young'sRule") {
			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:options:1"))
					.click();

		} else if (name == "DosageBasedonWeight") {
			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:options:2"))
					.click();

		}
	}

	public double insertDosageWeight(double weight) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:patientWeight"));
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(String.valueOf(weight));
		
		return weight;
	}

	public void insertAdultDosage(double dosage) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:mg"))
					.sendKeys(String.valueOf(dosage));
		} catch (StaleElementReferenceException e) {
			System.out
					.println("Attempting to recover from StaleElementReferenceException ...");
			driver.findElement(
					By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:mg"))
					.click();

		}

		Thread.sleep(10000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:mg"))
				.clear();
		Thread.sleep(2000);
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:mg"))
				.sendKeys(String.valueOf(dosage));
		
       Thread.sleep(10000);
       driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:childDoseCalcForm:mg")).sendKeys(Keys.ENTER);
	}

	public double calculateClarkRule(double weight, double adultDose) {
		double res = weight * 2.2046;
		double value = (res / 150) * adultDose;
		double rounded = (double) Math.round(value * 100) / 100;
		
		return rounded;
	}

	public double calculateYoungRule(double dosage, double Age) {
		// Adult Dose X (Age � (Age+12)) = Child's Dose
		double res = Age / (Age + 12);
		return dosage * res;
	}

	public double calculateOnWegiht(double weight, double dosage) {
		double res = weight * 2.2046;
		return res * dosage;

	}

	public void insertBillingNote(String data) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:Discount"))
				.sendKeys(data);
	}

	public void selectFollowUp() {
		div = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:followup"))
				.findElements(By.tagName("div"));
	}

	public void clickNotesHistory() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:patientNotesHitoryBtn"))
				.click();
	}

	public void getLabHistoryDataTable(String date) {
		WebElement el = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:notes_history_form:dt_patnotes_data"));

		tr = (ArrayList<WebElement>) el.findElements(By.tagName("tr"));

		td = (ArrayList<WebElement>) tr.get(0).findElements(By.tagName("td"));

		System.out.println();

	}

	public void insertDuration(int data, int index) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":md_duration_input")).clear();

		Thread.sleep(1000);

		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
						+ index + ":md_duration_input")).sendKeys(
				String.valueOf(data));

	}

	public boolean outOfStockMessage(int index) {

		if (driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
								+ index + ":j_idt694")).isDisplayed()) {

			WebElement ele = driver
					.findElement(By
							.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:medicationDT:"
									+ index + ":j_idt694"));

			System.out.println(ele.getText());
			if (ele.getText().contains("OUT OF STOCK")) {
				result = true;
			} else {
				result = false;
			}

		} else {

		}
		return result;
	}

	public void applyTemplate() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:applyDoctorNotesBtn"))
				.click();

	}

	public void closeFavoriteMedicine() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:fav_medicine_popup_form:closeMedicineFavoritePopup"))
				.click();
	}
	
	public double getCalDoseValue() {

		WebElement ele = driver.findElement(By.className("text-result"))
				.findElement(By.tagName("strong"));
		String s = ele.getText();
		
		System.out.println(s);
		return Double.valueOf(s);
	}
	
	public void selectSeenPatient() throws InterruptedException{
		Thread.sleep(20000);
		driver.manage().window().maximize();
		Thread.sleep(20000);
        selectCancel();
        Thread.sleep(10000);
		LabHistory lab = new LabHistory(driver);
		lab.selectSeenPatient("test");
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
}
