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

public class Attachement {
	
	WebDriver driver;
	
	public Attachement(WebDriver driv){
		driver=driv;
	}
	
	public void clickAttachement() throws InterruptedException{
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(8).click();	
	}
	
	public void selectAdd() throws InterruptedException{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_PatientAttachment_WAR_CloudClinikportlet_:patientAttachmentForm:addPatientAttachmentBtn').click()");
	    
	}	
	
    public void addSubject(String subject) throws InterruptedException{
    	Thread.sleep(1000);
    	driver.findElement(By.id("_PatientAttachment_WAR_CloudClinikportlet_:addAttachmentForm:AddAttachSubject")).sendKeys(subject);	
    }
	
    public void addBriefNotes(String notes) throws InterruptedException
    {
    	Thread.sleep(1000);
    	driver.findElement(By.id("_PatientAttachment_WAR_CloudClinikportlet_:addAttachmentForm:AddAttachNotes")).sendKeys(notes);
    }
   
    public void uploadFile(){
    	
    	WebElement file_input = driver.findElement(By.id("_PatientAttachment_WAR_CloudClinikportlet_:addAttachmentForm:addPatientAttachment_input"));
    	file_input.sendKeys("D:\\Notices.docx");
    	
    }
    
    public void selectAttachementType(String attachement) throws InterruptedException{
    	
    	driver.findElement(By.xpath("//*[@id='_PatientAttachment_WAR_CloudClinikportlet_:addAttachmentForm:docTypeAdd']/div[3]")).click();
		 Thread.sleep(10000);
	     driver.findElement(By.xpath(".//*[@id='_PatientAttachment_WAR_CloudClinikportlet_:addAttachmentForm:docTypeAdd_panel']/div/ul/li[2]")).click();
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
		Attachement att=new Attachement(driver);
		att.clickAttachement();
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
	     att.selectAdd();
	     Thread.sleep(10000);
	     //att.uploadFile();
	     att.selectAttachementType("type");
	     
    	
    }
   

}
	

