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

public class Progressnotes {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	
	public Progressnotes(WebDriver element){
		driver=element;
	}
	
	public void selectNotes() throws InterruptedException{
			
			Thread.sleep(1000);
			WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
			divs=(ArrayList<WebElement>) ele.findElements(By.tagName("li"));
			
			Thread.sleep(1000);
			divs.get(3).click();		
		}
	
	public void addNotesSubmit() throws InterruptedException{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_patientNotesHistory_WAR_CloudClinikportlet_:notesHistoryform:j_idt7').click()");
			
	}
  
	public void addDoctorNotes(String notes){
		driver.findElement(By.id("_patientNotesHistory_WAR_CloudClinikportlet_:addUpdateDoctorNotes:doc_notes_area"))
		.sendKeys(notes);
		
	}

	public void saveDoctorNotes(){
		driver.findElement(By.id("_patientNotesHistory_WAR_CloudClinikportlet_:addUpdateDoctorNotes:j_idt61")).click();
	
	}
		
	public static void main(String[] args) throws InterruptedException, IOException {
		
        ArrayList<WebElement> arr = new ArrayList<WebElement>();
	
 	     WebDriver driver=new FirefoxDriver();	 
	    driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
	  	Login log=new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("9213053774","infogistic1");
		Pateintvital vi=new Pateintvital(driver);
		Thread.sleep(20000);	
		Progressnotes note=new Progressnotes(driver);
		note.selectNotes();
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
	     note.addNotesSubmit();
		 Thread.sleep(10000);
		 note.addDoctorNotes("testing the notes");
	     Thread.sleep(10000);
	     note.saveDoctorNotes();
	     Thread.sleep(10000);
		 
	}

}
	

