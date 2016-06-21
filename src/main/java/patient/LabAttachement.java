package patient;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import bookApointment.Appointment;
import framework.Login;

public class LabAttachement {
	
	
	WebDriver driver;
	
	ArrayList<WebElement>divs=new ArrayList<WebElement>();
	ArrayList<WebElement>seconddivs=new ArrayList<WebElement>();
	ArrayList<WebElement>thirddivs=new ArrayList<WebElement>();
	
	
	
	
	public LabAttachement(WebDriver driv){
		driver=driv;
	}
	
	public void clickLabTab() throws InterruptedException{
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(11).click();	
		
	}

	public void clickAdd() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_labPatientAttachments_WAR_CloudClinikportlet_:myform:addLabPatientAttachmentBtn').click()");
		Thread.sleep(10000);
	}
	
	public void setSubject(String subject){
		driver.findElement(By.id("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:subject")).sendKeys(subject);
	
	}
	
	public void setProcedure(String proceudre) throws InterruptedException{
		WebElement ele=driver.findElement(By.id("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:adddlg")).findElement
				(By.className("ui-widget-content")).findElement(By.className("dlg-content")).findElement(By.className("form-block"));
		
		 divs=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		 divs.get(0).findElement(By.className("alignright")).findElement(By.id
				 ("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:procedure_input")).
				 sendKeys(proceudre);
		 
		   Thread.sleep(10000);
		   divs.get(0).findElement(By.className("alignright")).findElement(By.id
					 ("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:procedure_input")).
					 sendKeys(Keys.ENTER);
		   
		
	}
	
	public void setBriefNote(String note){
		driver.findElement(By.id("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:briefnote")).sendKeys(note);
	}
	
	public void uploadDocument(){
		
    	WebElement file_input = driver.findElement(By.id("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:document_input"));
    	file_input.sendKeys("D:\\Notices.docx");
		
	}
	
	public void save(){
		driver.findElement(By.id("_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:saveLabPatientAttachmentBtn")).click();
	}
	
	public void close(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_labPatientAttachments_WAR_CloudClinikportlet_:labPatientAttachmentfrm:closeLabPatientAttachmentBtn').click()");
		
	}
	
	public static void main(String []args) throws IOException, InterruptedException{
		
		ArrayList<WebElement> arr = new ArrayList<WebElement>();
		
	     WebDriver driver=new FirefoxDriver();	 
	    driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
	  	Login log=new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("9213053774","infogistic1");
		
		
		LabAttachement lab=new LabAttachement(driver);
		Pateintvital vi=new Pateintvital(driver);
		Thread.sleep(20000);	
		 lab.clickLabTab();
		 Thread.sleep(10000);
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
		
		
	    lab.clickAdd();
		Thread.sleep(20000);
		lab.setProcedure("13152 : CMPLX RPR E/N/E/L 2.6-7.5 CM");
		Thread.sleep(10000);
	   ///13152 : CMPLX RPR E/N/E/L 2.6-7.5 CM
			
		
	}
	
}
