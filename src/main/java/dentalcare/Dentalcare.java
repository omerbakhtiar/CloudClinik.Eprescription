package dentalcare;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dentalcare {

	WebDriver driver;

	String data;
	boolean s;
	ArrayList<WebElement> tr = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> span = new ArrayList<WebElement>();
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> subdivs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();

	public Dentalcare(WebDriver driver2) {
		driver = driver2;
	}

	public void clickOnDentalCare() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:getd"))
				.submit();

	}

	public void setComplaints(String complaint) throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:complaints_input"))
				.sendKeys(complaint);
		Thread.sleep(1000);
		selectLComplaints();
	}

	public void selectLComplaints() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:complaints_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickNotesHistory() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:patientNotesHitoryBtn"))
				.click();
	}

	public void closeNotesHistory() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:notes_history_popup_id"))
				.findElement(By.tagName("div")).findElement(By.tagName("a"))
				.click();
	}

	public void applyTemplates() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:applyDoctorNotesBtn"))
				.click();
	}

	public void clickOnSpecialityTemplate(String name)
			throws InterruptedException {
		WebElement ele = driver.findElement(By
				.id("_CCDENTAL_WAR_CCDENTALportlet_:nt_form:j_idt540_data"));
		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			td = (ArrayList<WebElement>) tr.get(i).findElements(
					By.tagName("td"));

			if (td.get(i).getText().contains(name)) {
				System.out.println(td.get(i).getText());
				Thread.sleep(2000);
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:nt_form:j_idt540:"
								+ i + ":applySpecilaityTemplateLink")).click();
				break;
			}

		}

	}

	public void setDoctor(String notes) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:doc_notes_area"))
				.sendKeys(notes);

	}

	public void setNoteTemplate(String name) throws InterruptedException {
		WebElement ele = driver.findElement(By
				.id("_CCDENTAL_WAR_CCDENTALportlet_:nt_form:dt_nt_data"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {
			td = (ArrayList<WebElement>) tr.get(i).findElements(
					By.tagName("td"));

			if (td.get(i).getText().contains(name)) {
				System.out.println(td.get(i).getText());
				Thread.sleep(10000);

				WebElement element = driver.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:nt_form:dt_nt:" + i
								+ ":applyNotesTemplateLink"));

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", element);

				break;
			}

		}

	}

	public boolean getCompalintsData(String date, String data) {

		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:notes_history_popup:dt_patnotes_data"));

		tr = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tr.size(); i++) {

			td = (ArrayList<WebElement>) tr.get(i).findElements(
					By.tagName("td"));

			if (td.get(i).getText().contains(date)) {

				if (td.get(i + 1).getText().contains(data)) {
					s = true;
				} else {
					s = false;
				}
			}

		}

		return s;
	}

	public void clickAdd() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:getd').click()");
	}

	public void setPrimaryDisease(String primary, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":diagnostics_input")).sendKeys(primary);
		Thread.sleep(10000);
		selectDisease(index);
	}

	public void selectDisease(int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":diagnostics_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void setProcedure(String procedure, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":procedures_input")).sendKeys(procedure);
		Thread.sleep(1000);
		selectProcedureList(index);
	}

	public void selectProcedureList(int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":procedures_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void setAdditional(String diagnosis, int index)
			throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":additionalDiagnosis_input")).sendKeys(
				diagnosis);

		Thread.sleep(1000);
		selectAddionlList(index);

	}

	public void selectAddionlList(int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":additionalDiagnosis_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void setTeeth(String teeth, int index) throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":teeth_input")).sendKeys(teeth);
		Thread.sleep(1000);
		selectTeeth(index);
	}

	public void selectTeeth(int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":teeth_panel"))
				.findElement(By.tagName("ul")).findElement(By.tagName("li"))
				.click();
	}

	public void clickToothNumber(int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":selectTeeth")).click();
	}

	public void clickTeeth(int index) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:"
						+ index + ":teeth_panel")).click();
	}

	public void setTeeth(int teeth) throws InterruptedException {

		Thread.sleep(1000);

		if (teeth >= 25) {
			teethGreaterEqual25(teeth);

		} else if (teeth <= 24 && teeth >= 17) {
			teethLessThan25(teeth);

		} else if (teeth <= 16) {

			teethlessThan17(teeth);
		}

	}

	public void teethGreaterEqual25(int teeth) {

		for (int i = 0; i < 6; i++) {

			String tex = driver
					.findElement(
							By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt622:"
									+ i + ":j_idt631"))
					.findElement(By.tagName("div"))
					.findElement(By.className("num")).getText();

			if (String.valueOf(teeth).contains(tex)) {

				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt622:"
								+ i + ":j_idt631"))
						.findElement(By.tagName("div"))
						.findElement(By.tagName("input")).click();
				break;

			}

		}
		if (teeth == 25) {

			driver.findElement(
					By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt622:7:j_idt623"))
					.findElement(By.tagName("div"))
					.findElement(By.tagName("input")).click();
		}

	}

	public void teethLessThan25(int teeth) {
		if (teeth == 22) {
			String text = driver
					.findElement(
							By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt603:2:j_idt614"))
					.findElement(By.tagName("div"))
					.findElement(By.className("num")).getText();

			System.out.println(text + "i am here");

		} else {
			for (int i = 0; i <= 7; i++) {

				if (i == 2) {
					i = i + 1;
				}

				String tex = driver
						.findElement(
								By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt603:"
										+ i + ":j_idt604"))
						.findElement(By.tagName("div"))
						.findElement(By.className("num")).getText();

				if (String.valueOf(teeth).contains(tex)) {

					driver.findElement(
							By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt603:"
									+ i + ":j_idt604"))
							.findElement(By.tagName("div"))
							.findElement(By.tagName("input")).click();
					break;

				}

			}
		}
	}

	public void teethlessThan17(int teeth) throws InterruptedException {

		for (int i = 0; i < 8; i++) {

			WebElement ele = driver.findElement(By
					.cssSelector("span[id^='_CCDENTAL_WAR_CCDENTALportlet_"
							+ ":toothSelectionForm:j_idt575:" + i + ":j_']"));

			String s = ele.findElement(By.tagName("div"))
					.findElement(By.tagName("span")).getText();

			if (Integer.valueOf(s).equals(teeth)) {

				WebElement button = driver
						.findElement(By
								.cssSelector("input[id^='_CCDENTAL_WAR_CCDENTALportlet_"
										+ ":toothSelectionForm:j_idt575:"
										+ i
										+ ":permanentUpperLeftCheckBox']"));

				Thread.sleep(10000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", button);
				break;
			}

			if (teeth == 1) {
				Thread.sleep(10000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				WebElement button = driver
						.findElement(By
								.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:"
										+ "0:permanentUpperRightCheckBox"));
				jse.executeScript("arguments[0].click();", button);

			} else if (teeth == 2) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:"
								+ "1:permanentUpperRightCheckBox")).click();

			} else if (teeth == 3) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:"
								+ "j_idt594:2:permanentUpperRightCheckBox"))
						.click();

			} else if (teeth == 4) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document."
						+ "getElementById('_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:3:"
						+ "permanentUpperRightCheckBox" + "')" + ".click();");

			} else if (teeth == 5) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:"
						+ "j_idt594:4:permanentUpperRightCheckBox').click();");

			} else if (teeth == 6) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:"
						+ "j_idt594:5:permanentUpperRightCheckBox').click();");

			} else if (teeth == 7) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:6:"
								+ "permanentUpperRightCheckBox")).click();

			} else if (teeth == 8) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:7:"
								+ "permanentUpperRightCheckBox")).click();
			}
		}

	}

	public void setSingleTeeth(int teeth) throws InterruptedException {
		Thread.sleep(1000);

		if (teeth >= 25) {
			teethSingleGreaterEqual25(teeth);

		} else if (teeth <= 24 && teeth >= 17) {
			teethSingleLessThan25(teeth);

		} else if (teeth <= 16) {

			teethSingleLessThan17(teeth);
		}

	}

	public void teethSingleGreaterEqual25(int teeth) {

		for (int i = 0; i < 6; i++) {

			String tex = driver
					.findElement(
							By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt622:"
									+ i + ":j_idt631"))
					.findElement(By.tagName("div"))
					.findElement(By.className("num")).getText();

			if (String.valueOf(teeth).contains(tex)) {

				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt622:"
								+ i + ":j_idt631"))
						.findElement(By.tagName("div"))
						.findElement(By.tagName("a")).click();
				break;

			}

		}
		if (teeth == 25) {

			driver.findElement(
					By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt622:7:j_idt623"))
					.findElement(By.tagName("div"))
					.findElement(By.tagName("a")).click();
		}

	}

	public void teethSingleLessThan25(int teeth) {
		if (teeth == 22) {
			String text = driver
					.findElement(
							By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt603:2:j_idt614"))
					.findElement(By.tagName("div"))
					.findElement(By.className("num")).getText();

			System.out.println(text + "i am here");

		} else {
			for (int i = 0; i <= 7; i++) {

				if (i == 2) {
					i = i + 1;
				}

				String tex = driver
						.findElement(
								By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt603:"
										+ i + ":j_idt604"))
						.findElement(By.tagName("div"))
						.findElement(By.className("num")).getText();

				if (String.valueOf(teeth).contains(tex)) {

					driver.findElement(
							By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt603:"
									+ i + ":j_idt604"))
							.findElement(By.tagName("div"))
							.findElement(By.tagName("a")).click();
					break;

				}

			}
		}
	}

	public void teethSingleLessThan17(int teeth) throws InterruptedException {

		for (int i = 0; i < 8; i++) {

			WebElement ele = driver.findElement(By
					.cssSelector("span[id^='_CCDENTAL_WAR_CCDENTALportlet_"
							+ ":toothSelectionForm:j_idt575:" + i + ":j_']"));

			String s = ele.findElement(By.tagName("div"))
					.findElement(By.tagName("span")).getText();

			if (Integer.valueOf(s).equals(teeth)) {

				WebElement button = driver
						.findElement(By
								.cssSelector("a[id^='_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt575:"
										+ i + ":permanentUpperLeftLink']"));

				Thread.sleep(10000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", button);
				break;
			}

			if (teeth == 1) {
				Thread.sleep(10000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				WebElement button = driver
						.findElement(By
								.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:0:permanentUpperRightLink"));
				jse.executeScript("arguments[0].click();", button);
			} else if (teeth == 2) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:1:permanentUpperRightLink"))
						.click();
			} else if (teeth == 3) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:2:permanentUpperRightLink"))
						.click();
			} else if (teeth == 4) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:3:permanentUpperRightLink"
						+ "')" + ".click();");
			} else if (teeth == 5) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:4:permanentUpperRightLink').click();");
			
			} else if (teeth == 6) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:5:permanentUpperRightLink').click();");
		
			} else if (teeth == 7) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:6:permanentUpperRightLink"))
						.click();
			} else if (teeth == 8) {
				driver.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt594:7:permanentUpperRightLink"))
						.click();
			}
		}

	}

	public void clickMed() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:addMedication').click()");
	}

	public void setsMedsName(String name,int index) throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"+index+":md_medicine_input"))
				.sendKeys(name);
		Thread.sleep(10000);
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"+index+":md_medicine_input"))
				.sendKeys(Keys.ENTER);

	}

	public void setDose(String amount, int index) throws InterruptedException {

		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
						+ index + ":md_dozeId_input")).clear();
		Thread.sleep(1000);
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
						+ index + ":md_dozeId_input")).sendKeys(amount);

	}

	public void setFrequency(String frequency, int index)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
								+ index + ":selectFreq"));
		Thread.sleep(1000);

		divs = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		divs.get(2).click();

		Thread.sleep(10000);
		WebElement el = driver.findElement(By.id(""
				+ "_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
				+ index + ":selectFreq_panel"));

		li = (ArrayList<WebElement>) el.findElement(By.tagName("div"))
				.findElement(By.tagName("ul")).findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(frequency)) {
				li.get(i).click();
			}

		}
	}

	public void duration(String dur, int index) throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
						+ index + ":md_duration_input")).clear();
		Thread.sleep(1000);
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
						+ index + ":md_duration_input")).sendKeys(dur);

	}

	public void setRefills(String amount, int index)
			throws InterruptedException {

		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
						+ index + ":medicineRefills_input")).clear();
		Thread.sleep(1000);
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
						+ index + ":medicineRefills_input")).sendKeys(amount);
	}

	public void setRoute(String value, int index) throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
								+ index + ":selectRoute"));
		Thread.sleep(1000);

		divs = (ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		divs.get(2).click();

		Thread.sleep(10000);
		WebElement el = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:"
								+ index + ":selectRoute_panel"));

		li = (ArrayList<WebElement>) el.findElement(By.tagName("div"))
				.findElement(By.tagName("ul")).findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getText().contains(value)) {
				li.get(i).click();
				break;
			}

		}
	}

	public void setDiet(String diet) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:suggestions_input"))
				.sendKeys(diet);
	}

	public void setBilling(String billing) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:Discount"))
				.sendKeys(billing);
	}

	public void setFollowUp() {
		driver.findElement(
				By.className("ui-chkbox-box ui-widget ui-corner-all ui-state-default"))
				.click();

	}

	public void submit() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:btn_presc_save_only"))
				.submit();

	}

	public void clickOrderSet() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:btn_os")).click();
	}

	public void clickPrimaryTeeth() {
		WebElement ele = driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:GrapOptions"))
				.findElement(By.tagName("tr"));

		td = (ArrayList<WebElement>) ele.findElements(By.tagName("td"));

		td.get(2).findElement(By.className("ui-corner-all")).click();
	}

	public void kidsJaw(String s) {
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:GraphPrimary"));

		divs = (ArrayList<WebElement>) ele
				.findElements(By
						.cssSelector("span[id^='_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt652']"));

		System.out.println(divs.size());

		if (s.matches((".*[F-K].*"))) {

			for (int i = 0; i < 5; i++) {

				String f = divs.get(i).findElement(By.tagName("div"))
						.findElement(By.tagName("span")).getText();

				System.out.println(f);

				if (s.matches(f)) {

					divs.get(i).findElement(By.tagName("div"))
							.findElement(By.tagName("input")).click();
				}

			}

		} else if (s.matches(".*[A-E].*")) {

			for (int i = 1; i < 6; i++) {

				WebElement element = driver.findElement(By.className("toot5"
						+ i + ""));
				String ag = element.findElement(By.className("num")).getText();

				System.out.println(ag);

				if (s.matches(ag)) {
					element.findElement(By.tagName("input")).click();
				}

			}

		} else if (s.matches(".*[K-L].*")) {
			for (int i = 1; i < 6; i++) {

				WebElement element = driver.findElement(By.className("toot7"
						+ i + ""));
				String ag = element.findElement(By.className("num")).getText();

				System.out.println(ag);

				if (s.matches(ag)) {
					element.findElement(By.tagName("input")).click();
				}

			}
		} else if (s.matches(".*[P-T].*")) {
			divs = (ArrayList<WebElement>) ele
					.findElements(By
							.cssSelector("span[id^='_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt690']"));

			for (int i = 0; i < 5; i++) {

				String f = divs.get(i).findElement(By.tagName("div"))
						.findElement(By.tagName("span")).getText();

				System.out.println(f);

				if (s.matches(f)) {

					divs.get(i).findElement(By.tagName("div"))
							.findElement(By.tagName("input")).click();
				}

			}

		}
	}

	public void singleKidJaw(String s) {
		WebElement ele = driver
				.findElement(By
						.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:GraphPrimary"));

		divs = (ArrayList<WebElement>) ele
				.findElements(By
						.cssSelector("span[id^='_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt652']"));

		System.out.println(divs.size());

		if (s.matches((".*[F-K].*"))) {

			for (int i = 0; i < 5; i++) {

				String f = divs.get(i).findElement(By.tagName("div"))
						.findElement(By.tagName("span")).getText();

				System.out.println(f);

				if (s.matches(f)) {

					divs.get(i).findElement(By.tagName("div"))
							.findElement(By.tagName("a")).click();
					break;
				}

			}

		} else if (s.matches(".*[A-E].*")) {

			for (int i = 1; i < 6; i++) {

				WebElement element = driver.findElement(By.className("toot5"
						+ i + ""));
				String ag = element.findElement(By.className("num")).getText();

				System.out.println(ag);

				if (s.matches(ag)) {
					element.findElement(By.tagName("a")).click();
					break;
				}

			}

		} else if (s.matches(".*[K-L].*")) {
			for (int i = 1; i < 6; i++) {

				WebElement element = driver.findElement(By.className("toot7"
						+ i + ""));
				String ag = element.findElement(By.className("num")).getText();

				System.out.println(ag);

				if (s.matches(ag)) {
					element.findElement(By.tagName("a")).click();
					break;
				}

			}
		} else if (s.matches(".*[P-T].*")) {
			divs = (ArrayList<WebElement>) ele
					.findElements(By
							.cssSelector("span[id^='_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:j_idt690']"));

			for (int i = 0; i < 5; i++) {

				String f = divs.get(i).findElement(By.tagName("div"))
						.findElement(By.tagName("span")).getText();

				System.out.println(f);

				if (s.matches(f)) {

					divs.get(i).findElement(By.tagName("div"))
							.findElement(By.tagName("a")).click();
					break;
				}

			}

		}
	}

	public void clickFavroiteDiease() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT"
						+ ":applyFavoritePrimaryIcd")).click();
	}

	public void insertFavoriteDieaseData(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form"
						+ "_primary:searchIcd")).sendKeys(data);
	}

	public void searchFavoriteDiease() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_"
						+ "primary:searchFavPrimaryIcdBtn")).click();
	}

	public void clickSearchFavoriteDiease() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_primary"
						+ ":dt_ficd_primary:0:applyFavPrimaryIcdLink")).click();
	}

	public void closeFavoriteDieasePopup() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_"
						+ "primary:closePrimaryIcdFavoritePopup")).click();
	}

	public void clickFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:"
						+ "diagnosticDT:applyFavoriteProcedure")).click();
	}

	public void insertFavoriteProcedureData(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_"
						+ "popup_form:searchCpt")).sendKeys(data);
	}

	public void searchFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup"
						+ "_form:searchFavProcedureBtn")).click();
	}

	public void selectFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup"
						+ "_form:dt_dg:0:applyFavProcedureLink")).click();
	}

	public void closeFavoriteProcedure() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup"
						+ "_form:closeCptFavoritePopup")).click();
	}

	public void clickFavoriteAdditionalDiagnosis() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:applyFavoriteAdditionalIcd"))
				.click();
	}

	public void insertFavoriteAdditonalDiagnosis(String data)
			throws InterruptedException {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:searchIcd"))
				.clear();

		Thread.sleep(1000);

		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:searchIcd"))
				.sendKeys(data);
	}

	public void searchFavortieAddDiagnosis() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:searchFavIcdBtn"))
				.click();
	}

	public void clickFavoriteDiagnosisList() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:dt_ficd:0:applyFavIcdLink"))
				.click();
	}

	public void closeFavoriteDiagnois() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:closeIcdFavoritePopup"))
				.click();
	}

	public void clickOnFullMouth() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:fmToothBtn"))
				.click();
	}

	public void clickOnMaxillary() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:mxToothBtn"))
				.click();
	}

	public void clickOnManibular() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:toothSelectionForm:mnToothBtn"))
				.click();
	}

	public void save() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:btn_presc_save_only"))
				.click();
	}

	public boolean FMMMessage(String message) {
		WebElement ele = driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:j_idt192"))
				.findElement(By.tagName("div")).findElement(By.tagName("ul"))
				.findElement(By.tagName("li"));

		String s = ele.findElement(By.tagName("span")).getText();

		if (s.contains(message)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickFavoriteMedicine() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:applyFavoriteMedicine"))
				.click();
	}

	public void inserFavoriteMedRecord(String data) {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_medicine_popup_form:searchMed"))
				.sendKeys(data);
	}

	public void searchFavoriteRecord() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_medicine_popup_form:searchFavMedicineBtn"))
				.click();
	}

	public void clickONFavoriteRecord() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_medicine_popup_form:dt_nt:0:applyFavMedicineLink"))
				.click();
	}

	public void close() {
		driver.findElement(
				By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_medicine_popup_form:closeMedicineFavoritePopup"))
				.click();
	}

	public boolean FavoriteICDDDieaseisplayed() {
		return driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form_primary:j_idt500"))
				.isDisplayed();

	}

	public boolean FavoriteProcedurePopup() {
		return driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_cpt_popup_form:j_idt481"))
				.isDisplayed();
	}

	public boolean FavoriteAdditional() {
		return driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:icd_popup_form:j_idt490"))
				.isDisplayed();
	}

	public boolean FavoriteMedcine() {
		return driver
				.findElement(
						By.id("_CCDENTAL_WAR_CCDENTALportlet_:fav_medicine_popup_form:j_idt511"))
				.isDisplayed();
	}

	public void closeFavoriteMedicine() {

	}

}
