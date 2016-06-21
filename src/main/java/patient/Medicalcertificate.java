package patient;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import bookApointment.Appointment;
import framework.Login;

public class Medicalcertificate {
	WebDriver driver;
	
	public Medicalcertificate(WebDriver driv){
		driver=driv;
	}
	
	public void selectCertificate() throws InterruptedException{
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(9).click();	
	
	}	
	public void Add(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_MedicalCertificates_WAR_CloudClinikportlet_:medicalCertificatesFrom:addMedicalCertificatesbutton').click()");
	}
	
	public void setDoctorNotes(String notes) throws InterruptedException{
		
		driver.findElement(By.id("_MedicalCertificates_WAR_CloudClinikportlet_:addCertificateForm:doctorNote2")).sendKeys(notes);
	}
	
	public void setLeaveDays(String days) throws InterruptedException{
		driver.findElement(By.id("_MedicalCertificates_WAR_CloudClinikportlet_:addCertificateForm:leaveDays")).sendKeys(days);
	}
	
	public void saveData(){
		driver.findElement(By.id("_MedicalCertificates_WAR_CloudClinikportlet_:addCertificateForm:saveMedicalCertificatesBtn")).click();
	}
	
	public void close(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_MedicalCertificates_WAR_CloudClinikportlet_:addCertificateForm:addDialogueCloseMedicalCertificatesBtn').click()");
	}
	
	public void DeleteNote() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('MedicalCertificates_WAR_CloudClinikportlet_:medicalCertificatesFrom:tblMedCert:0:editMedicalCertificatesLink').click()");
		Thread.sleep(10000);
		js.executeScript("document.getElementById('_MedicalCertificates_WAR_CloudClinikportlet_:j_idt44:confirm').click()");
		
	}	
	
	public void updateRecord(String note,String period) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_MedicalCertificates_WAR_CloudClinikportlet_:medicalCertificatesFrom:tblMedCert:0:editMedicalCertificatesLink').click()");
		Thread.sleep(10000);
		
		WebElement element =driver.findElement(By.id("_MedicalCertificates_WAR_CloudClinikportlet_:editCertificateForm:doctorNote2"));
		WebElement ele=driver.findElement(By.id("_MedicalCertificates_WAR_CloudClinikportlet_:editCertificateForm:leaveDays"));
		Thread.sleep(10000);
		element.clear();
		Thread.sleep(1000);
		element.sendKeys(note);
		Thread.sleep(10000);
		ele.clear();
		Thread.sleep(10000);
		ele.sendKeys(period);
	}
	
	public void saveUpdate(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_MedicalCertificates_WAR_CloudClinikportlet_:editCertificateForm:updateMedicalCertificatesBtn').click()");	
	}
 	
	public void closeUpdate(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_MedicalCertificates_WAR_CloudClinikportlet_:editCertificateForm:editDialogueCloseMedicalCertificatesBtn').click()");	
	}
	
	
	public static void main(String []args) throws IOException, InterruptedException{
		ArrayList<WebElement> arr = new ArrayList<WebElement>();
		
	     WebDriver driver=new FirefoxDriver();	 
	    driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
	  	Login log=new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("9213053774","infogistic1");
		
		Pateintvital vi=new Pateintvital(driver);
		Thread.sleep(20000);	
		Medicalcertificate medical=new Medicalcertificate(driver);
		medical.selectCertificate();
	    Thread.sleep(20000);
		vi.searchPatient();
		
		
		Appointment app=new Appointment(driver);
		Thread.sleep(20000);
		arr=(ArrayList<WebElement>) driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:MyPatients_content")).
		findElements(By.tagName("div"));
		Thread.sleep(20000);
		arr.get(4).findElement(By.tagName("input")).sendKeys("3454391379");
		Thread.sleep(10000);
       driver.findElement(By.xpath(".//*[@id='_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn']")).click();
		Thread.sleep(10000);
		 vi.clicktable();
		Thread.sleep(10000);
		/* medical.Add();
		 Thread.sleep(10000);
		 medical.setDoctorNotes("tesingd new notes for the doctors");
		 Thread.sleep(10000);
		 medical.setLeaveDays("2");
		 Thread.sleep(10000);
		 medical.saveData();
		 Thread.sleep(30000);
		 medical.close();*/
		 medical.updateRecord("new record","2");
		 Thread.sleep(10000); 
		 medical.saveUpdate();
		 Thread.sleep(30000);
		 medical.closeUpdate();
	}

}