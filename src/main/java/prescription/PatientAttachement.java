package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientAttachement {
	
	WebDriver driver;
	ArrayList<WebElement> div = new ArrayList<WebElement>();
	
	public PatientAttachement(WebDriver driv){
		driver=driv;
	}
	
	public void clickPatientAttachement(){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:btn_pat_attc")).click();
	}
	
	public void clickAllClincik(){
		WebElement ele=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:viewAttachment:allClinicsCheck"));
		div=(ArrayList<WebElement>) ele.findElements(By.tagName("div"));
		div.get(2).click();
		
		
		
	}
	
	public void insertSubject(String subject){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:viewAttachment:documentsDataTable:j_idt209:filter")).
		sendKeys(subject);
	}
	
	public void closeViewPatient(){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:j_idt196")).click();
	}

}
