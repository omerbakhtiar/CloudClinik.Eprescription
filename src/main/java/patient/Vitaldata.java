package patient;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Vitaldata {
	
	WebDriver driver;
	
	public Vitaldata(WebDriver driv){
		
		driver=driv;
	}
	
	public void setTemp(String temp) throws InterruptedException{
		driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:temp")).sendKeys(temp);
		Thread.sleep(1000);
		driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:temp")).click();
	}
	
	public void setRep(String resp){
		driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:respRate")).sendKeys(resp);
	}
	
	public void setPulse(String pulse){
		driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:pulse")).sendKeys(pulse);
	
	}
	
	public void setHeight(String height){
		driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:height")).sendKeys(height);
		
	}

    public void setWeight(String weight){
    	driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:weight")).sendKeys(weight);
    	
    }
    
    public void setBp(String bp){
    	driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:systolic")).sendKeys(bp);
    	
    }
    
    public void setMM(String mm){
    	driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:dias")).sendKeys(mm);
    	
    }
   
    public void setTempPoint(String option) throws InterruptedException{
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	Thread.sleep(10000);
		js.executeScript("document.getElementById('_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:temp_point_label').innerHTML='Axillary'");
    	
    	
    }

    public void selectBloodSugar(String option){
      
      driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:bsl_type:"+option)).click();
    	
    }
    
    public void setSugar(String sugar){
    	driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:bsl")).sendKeys(sugar);
      
    }
   
    public void setNotes(String notes){
    	driver.findElement(By.id("_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:vital_notes")).sendKeys(notes);

    }

    public void submitSave(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_PatientVitals_WAR_CloudClinikportlet_:vitalsForm:save_button').click()");
    }
    
    
    
}

