package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MedicalCertificate {
	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	
	public MedicalCertificate(WebDriver driv){
		driver=driv;
	}
	
	public void selectCertificate(){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:btn_med_cert")).click();
		
	}

	public void insertNotes(String notes){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:addCertificateForm:doctorNote2")).sendKeys(notes);
	}
	
	public void insertLeaveDays(String days) throws InterruptedException{
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:addCertificateForm:leaveDays")).clear();
		Thread.sleep(10000);
		
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:addCertificateForm:leaveDays")).sendKeys(days);
	}
    
	public void submit(){
		WebElement ele=driver.findElement(By.cssSelector("button[id^='_Eprescription_WAR_CloudClinikportlet_:addCertificateForm:j_idt']"));
		ele.submit();
	}

}
