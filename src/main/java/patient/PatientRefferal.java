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

public class PatientRefferal {
	
	WebDriver driver;
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	
	public PatientRefferal(WebDriver driv){
		driver=driv;
		
	}
	
	public void clickRefferal() throws InterruptedException{
		
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(10).click();	
	}

	public void clickAdd() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_PatientReferral_WAR_CloudClinikportlet_:myform:j_idt34').click()");
		Thread.sleep(10000);
	}
		
	public void releaseNotes(String notes){
		driver.findElement(By.id("_PatientReferral_WAR_CloudClinikportlet_:myform:ReferralNotes")).sendKeys(notes);
		
	}
	
	public void referralReason(String reason) throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='_PatientReferral_WAR_CloudClinikportlet_:myform:ReferralReason']/div[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='_PatientReferral_WAR_CloudClinikportlet_:myform:ReferralReason_panel']/div/ul/li[2]")).click();
		
		
	}
	
	public void selectDoctor(String reason) throws InterruptedException{
		WebElement tr=driver.findElement(By.id("_PatientReferral_WAR_CloudClinikportlet_:myform:options")).findElement(By.tagName("tr"));
		Thread.sleep(10000);
		td=(ArrayList<WebElement>) tr.findElements(By.tagName("td"));
		
		divs=(ArrayList<WebElement>) td.get(4).findElements(By.tagName("div"));
		divs.get(2).click();
	}
	
	public void setManualName(String name){
		driver.findElement(By.id("_PatientReferral_WAR_CloudClinikportlet_:myform:manualDoctorName")).sendKeys(name);
		
	}
	
	public void saveData(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_PatientReferral_WAR_CloudClinikportlet_:myform:j_idt33').click()");	
		
	}
	
	public static void main(String []args) throws IOException, InterruptedException
	{
		ArrayList<WebElement> arr = new ArrayList<WebElement>();
		
	     WebDriver driver=new FirefoxDriver();	 
	    driver.get("https://www.cloudclinik.pk/web/cloudclinik/cc-login");
	  	Login log=new Login(driver);
		Thread.sleep(1000);
		log.Logincredentials("9213053774","infogistic1");
		
		Pateintvital vi=new Pateintvital(driver);
		Thread.sleep(20000);	
		
		PatientRefferal ref=new PatientRefferal(driver);
		ref.clickRefferal();
		
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
		ref.clickAdd();
		Thread.sleep(20000);
	    ref.selectDoctor("reason");
			
	}
	
	
}
