package patient;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bookApointment.Appointment;

public class SrPatient {

	WebDriver driver;
	ArrayList<WebElement> arr = new ArrayList<WebElement>();
	
	public SrPatient(WebDriver driv){
		 driver = driv;
	}
	
	public void selectType(String data, String type)
			throws InterruptedException {
		arr = (ArrayList<WebElement>) driver
				.findElement(
						By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:MyPatients_content"))
				.findElements(By.tagName("div"));
		Thread.sleep(2000);

		if (type == "ID") {
			arr.get(1).findElement(By.tagName("input")).sendKeys(data);

		} else if (type == "Mr") {
			arr.get(2).findElement(By.tagName("input")).sendKeys(data);

		} else if (type == "PateintName") {
			arr.get(3).findElement(By.tagName("input")).sendKeys(data);

		} else if (type == "ContactNo") {
			arr.get(4).findElement(By.tagName("input")).sendKeys(data);

		} else if (type == "PatientFileNO") {
			arr.get(5).findElement(By.tagName("input")).sendKeys(data);

		} else if (type == "VisitDate") {
			arr.get(6).findElement(By.tagName("input")).sendKeys(data);
		}

	}
	
	
	public void selectGenderType(String type) {
		if (type == "Male") {
			((JavascriptExecutor) driver)
					.executeScript("$('#_appointmentWidget_WAR_CloudClinikportlet_\\:j_idt22\\:Gender_panel div ul li:eq(1)').click();");

		} else if (type == "Female") {
			((JavascriptExecutor) driver)
					.executeScript("$('#_appointmentWidget_WAR_CloudClinikportlet_\\:j_idt22\\:Gender_panel div ul li:eq(2)').click();");

		} else if (type == "Others") {
			((JavascriptExecutor) driver)
					.executeScript("$('#_appointmentWidget_WAR_CloudClinikportlet_\\:j_idt22\\:Gender_panel div ul li:eq(3)').click();");
		}
	}

	public void selectFromAge(String Age) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:AgeBetween"))
				.sendKeys(Age);
	}

	public void selectToAge(String toAge) {
		driver.findElement(
				By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:AgeBetween2nd"))
				.sendKeys(toAge);
	}

	public void selectYMW(String data){

		if (data == "Year") {
			((JavascriptExecutor) driver)
					.executeScript("$('#_appointmentWidget_WAR_CloudClinikportlet_\\:j_idt22\\:j_idt44_panel div ul li:eq(0)').click();");
		} else if (data == "Month") {
			((JavascriptExecutor) driver)
					.executeScript("$('#_appointmentWidget_WAR_CloudClinikportlet_\\:j_idt22\\:j_idt44_panel div ul li:eq(1)').click();");

		} else if (data == "Week") {
			((JavascriptExecutor) driver)
					.executeScript("$('#_appointmentWidget_WAR_CloudClinikportlet_\\:j_idt22\\:j_idt44_panel div ul li:eq(2)').click();");
		}
	}
	
    public void AdanceTypeSearching(String gender,String age, String toAge,String type) throws InterruptedException, IOException{
    	Pateintvital vi = new Pateintvital(driver);
		Thread.sleep(20000);
		
		vi.searchPatient();
		Appointment app = new Appointment(driver);
		Thread.sleep(20000);

		selectGenderType(gender);
		selectYMW(type);
		selectFromAge(age);
		selectToAge(toAge);
		Thread.sleep(1000);
		
		Thread.sleep(30000);

		driver.findElement(
				By.xpath(".//*[@id='_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn']"))
				.click();
		Thread.sleep(10000);
		vi.clicktable();
		Thread.sleep(3000);
		
		String s = driver
				.findElement(
						By.xpath("//*[@id='_PatientHeader_WAR_CloudClinikportlet_:header_form:j_idt5_content']/div[1]/span[2]"))
				.getText().toString();
		System.out.println(s);
		Thread.sleep(1000);
    	
    }
	
	
	
	
	
	public String Searching(String data,String Type) throws IOException, InterruptedException {

		Pateintvital vi = new Pateintvital(driver);
		Thread.sleep(20000);
		vi.searchPatient();

		Appointment app = new Appointment(driver);
		Thread.sleep(20000);
		selectType(data, Type);
		Thread.sleep(30000);

		driver.findElement(
				By.xpath(".//*[@id='_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn']"))
				.click();
		Thread.sleep(10000);
		vi.clicktable();
		Thread.sleep(3000);
		
		String s = driver
				.findElement(
						By.xpath("//*[@id='_PatientHeader_WAR_CloudClinikportlet_:header_form:j_idt5_content']/div[1]/span[2]"))
				.getText().toString();
		System.out.println(s);
		Thread.sleep(1000);
		return s;
		
	}
	
	
	public String SearchingAdvance(String gender,String ageTo,String ageFrom,String type) throws IOException, InterruptedException {

		Pateintvital vi = new Pateintvital(driver);
		Thread.sleep(20000);
		vi.searchPatient();

		Appointment app = new Appointment(driver);
		Thread.sleep(20000);
		//selectType(data, Type);
		Thread.sleep(30000);

		driver.findElement(
				By.xpath(".//*[@id='_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn']"))
				.click();
		Thread.sleep(10000);
		vi.clicktable();
		Thread.sleep(3000);
		
		String s = driver
				.findElement(
						By.xpath("//*[@id='_PatientHeader_WAR_CloudClinikportlet_:header_form:j_idt5_content']/div[1]/span[2]"))
				.getText().toString();
		System.out.println(s);
		Thread.sleep(1000);
		return s;
		
	}
	
	
}
