package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LabHistory {

	WebDriver driver;
	ArrayList<WebElement> rows = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> subdivs = new ArrayList<WebElement>();

	public LabHistory(WebDriver driv) {
		driver = driv;
	}

	public void selectLabHis() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:loincHistory"))
				.click();
	}

	public void setLab(String set) {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:labAndlabSet"))
				.sendKeys(set);
	}

	public void selectFromDate(String date) {
		driver.findElement(
				By.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:dateFrom_input']"))
				.sendKeys(date);
	}

	public void selectVisitDate(String date) {
		driver.findElement(
				By.xpath("//*[@id='_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:dateTo_input']"))
				.sendKeys(date);

	}
	
	public void searchLab(String value){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:labAndlabSet")).sendKeys(value);
	}

	public void clickAllClinicks() {
		driver.findElement(
				By.className("ui-chkbox-box ui-widget ui-corner-all ui-state-default"))
				.click();

	}

	public void Search() {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:j_idt332"))
				.click();

	}

	public void AddResult() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable:0:j_idt354').click();");
	}

	public void insertResult(String result) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:result"))
				.clear();
		
		Thread.sleep(1000);
		
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:result"))
				.sendKeys(result);
	}

	public void insertComments(String comments) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		
		js.executeScript("document.querySelector('[id^=\"_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:comments"+"\"]').value='';");
	
		
		Thread.sleep(1000);
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:comments")).sendKeys(comments);
		
		
	}

	public void submitResult() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("document.getElementById('_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt386').click();");
	}


	public void close() throws InterruptedException {
		
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:loincHistoryDialog")).
		findElement(By.tagName("div")).findElement(By.tagName("a")).click();
	}
	

	public void clickOnLabSet(int sr) throws InterruptedException {
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable"))
						.findElement(By.tagName("table"))
						.findElement(By.tagName("tbody"));
		rows = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		Thread.sleep(20000);

		td = (ArrayList<WebElement>) rows.get(sr)
				.findElements(By.tagName("td"));

		System.out.println(td.size());

		td.get(0).findElement(By.tagName("div")).click();

	}

	public void AddResutlLabSet(int sr) throws InterruptedException {
		// 7
		WebElement ele = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable"))
						.findElement(By.tagName("table"))
						.findElement(By.tagName("tbody"));
		rows = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		Thread.sleep(20000);

		td = (ArrayList<WebElement>) rows.get(sr)
				.findElements(By.tagName("td"));

		System.out.println(td.size());

		td.get(7).findElement(By.tagName("a")).click();

	}

	public void AddRecordLabSet(String record) throws InterruptedException {
		
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:result"))
				.clear();
		Thread.sleep(1000);
		
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:result"))
				.sendKeys(record);
		

	}

	public void AddComments(String comments) throws InterruptedException {
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:comments"))
				.clear();
		Thread.sleep(1000);
		
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt375:0:comments"))
				.sendKeys(comments);
	}

    public void AddResultLabSet(){
		driver.findElement(
				By.id("_Eprescription_WAR_CloudClinikportlet_:LabSetAddResultForm:j_idt386"))
				.click();
    }

	public boolean getAddedResultSet(String result, String comments)
			throws InterruptedException {
		WebElement ele = driver
				.findElement(By
						.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable_data']/tr[5]/td/div[2]/div[2]"));

		System.out.println(ele.getText().toString());

		WebElement comment = driver
				.findElement(By
						.xpath(".//*[@id='_Eprescription_WAR_CloudClinikportlet_:loincHistroyForm:loincHistroyDataTable_data']/tr[5]/td/div[2]/div[3]"));

		System.out.println(comment.getText().toString());

		if (comment.getText().contains(comments)
				&& ele.getText().contains(result)) {

			return true;
		} else {

			return false;
		}

	}
	
	public void selectSeenPatient(String patientName){
		String s=driver.findElement(By.id("_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients:0:theLink"))
		.getText();
		rows=(ArrayList<WebElement>) driver.findElement(By.id("_seenPatientsWidget_WAR_CloudClinikportlet_:seen_widget_form:seenPatients_data")).
				findElements(By.tagName("tr"));
				
		for(int i=0;i<rows.size();i++){
			String n=rows.get(i).findElement(By.tagName("td")).findElement(By.tagName("a")).getText().toString();
			
			if(n.contains(patientName)){
				rows.get(i).findElement(By.tagName("td")).findElement(By.tagName("a")).click();
			}
		}
		
	
	}



}
