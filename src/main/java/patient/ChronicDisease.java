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

public class ChronicDisease {

	 WebDriver driver;
	
	public ChronicDisease(WebDriver driv){
		driver=driv;
		
	}
	
	public void selectChronic() throws InterruptedException{
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(7).click();	
	}
	
	public void addClick(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_patientChornicDiseases_WAR_CloudClinikportlet_:form:addChoronicDiseaseBtn').click()");
		
	}
	
	public void setDiseasee(String dieases) throws InterruptedException{
	 driver.findElement(By.id("_patientChornicDiseases_WAR_CloudClinikportlet_:dlgForm:Disease_input")).sendKeys(dieases);
	 Thread.sleep(10000);
	 driver.findElement(By.id("_patientChornicDiseases_WAR_CloudClinikportlet_:dlgForm:Disease_input")).sendKeys(Keys.ENTER);
	 Thread.sleep(10000);
	 
	}
	
	public void setDocumentRemark(String remark){
		driver.findElement(By.id("_patientChornicDiseases_WAR_CloudClinikportlet_:dlgForm:DoctorRemark")).sendKeys(remark);
	}
	
	public void save() throws InterruptedException{
		Thread.sleep(10000);
		driver.findElement(By.id("_patientChornicDiseases_WAR_CloudClinikportlet_:dlgForm:saveChoronicDiseaseBtn")).click();
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
		ChronicDisease dise=new ChronicDisease(driver);
		dise.selectChronic();
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
		
		dise.addClick();
		Thread.sleep(10000);
	    dise.setDiseasee("C173 : Meckel's diverticulum, malignant");
	    Thread.sleep(20000);
	    dise.setDocumentRemark("for testing purpose");
	    Thread.sleep(10000);
	    dise.save();
		
	}
	
	
	
}
