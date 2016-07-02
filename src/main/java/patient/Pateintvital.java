package patient;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dentalcare.Dentalcare;
import bookApointment.Appointment;
import framework.Login;

public class Pateintvital {
	
	 WebDriver driver;
	 ArrayList<WebElement> divs = new ArrayList<WebElement>();
	 
	 
	public Pateintvital(WebDriver drivers){
		driver=drivers;
	}
      
	public void clickVital() throws InterruptedException{
		
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		divs=(ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(0).click();
		
		
	}
	
	public void searchPatient() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_appointmentWidget_WAR_CloudClinikportlet_:form:btn_select_patient').click();");
		Thread.sleep(1000);
	}
	
	public void closeSearchPatient(){
		driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:searchpatient")).
		findElement(By.tagName("div")).findElement(By.tagName("a")).click();
	}
	
	
	public void clicktable(){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_appointmentWidget_WAR_CloudClinikportlet_:patientSearchForm:patientGrid:0:patientMrNoLink').click()");

	}
	
	
	public void Call() throws InterruptedException{
		 Vitaldata data=new Vitaldata(driver);
		 data.selectBloodSugar("1");
		 Thread.sleep(1000);
		 data.setBp("100");
		 Thread.sleep(1000);
		 data.setHeight("10");
		 Thread.sleep(1000);
		 data.setMM("10");
		 Thread.sleep(1000);
		 data.setTemp("100");
		 Thread.sleep(1000);
		 data.setPulse("10");
		 Thread.sleep(1000);
		 data.setRep("10");
         Thread.sleep(1000);
         data.setTempPoint("Axillary");
         Thread.sleep(1000);
         data.setWeight("30");
         data.setNotes("testing this page");
         Thread.sleep(1000);
         data.submitSave();
	    
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
			//vi.clickVital();
			Thread.sleep(10000);
			vi.searchPatient();
			Thread.sleep(10000);
			
			Appointment app=new Appointment(driver);
			Thread.sleep(20000);
			arr=(ArrayList<WebElement>) driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:MyPatients_content")).
			findElements(By.tagName("div"));
			Thread.sleep(20000);
			arr.get(4).findElement(By.tagName("input")).sendKeys("3454391379");
			Thread.sleep(20000);
            driver.findElement(By.xpath(".//*[@id='_appointmentWidget_WAR_CloudClinikportlet_:j_idt22:patientSearchBtn']")).click();
			Thread.sleep(20000);
             vi.clicktable();
             Thread.sleep(10000); 
             Dentalcare care=new Dentalcare(driver);
             Thread.sleep(10000);
             care.clickMed();
             Thread.sleep(10000);
             care.setFrequency("od: once a day");
             Thread.sleep(10000);
             care.submit();

}
}