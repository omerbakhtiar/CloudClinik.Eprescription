package patient;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Dentalcare {

	WebDriver driver;
	
	public Dentalcare(WebDriver driver2){
		driver=driver2;	
	}
	
	
	public void clickOnDentalCare(){
		driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:getd")).submit();
		
	}
	public void setComplaints(String complaint){
		driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:complaints_input")).sendKeys(complaint);
		
	}
	
	public void setDoctor(String notes){
		driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:doc_notes_area")).sendKeys(notes);
	
	}
	
	public void clickAdd() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	Thread.sleep(1000);
		js.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:getd').click()");
    	
    	
		
	}
	
    public void setPrimaryDisease(String primary) throws InterruptedException{
       driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:diagnostics_input")).
       sendKeys(primary);   	
       Thread.sleep(1000);
       driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:diagnostics_input")).sendKeys(Keys.ENTER);
    }

    public void setProcedure(String procedure) throws InterruptedException{
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:procedures_input")).sendKeys(procedure);
    	Thread.sleep(5000);
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:procedures_input")).sendKeys(Keys.ENTER);
    	
    }
 
    public void setAdditional(String diagnosis) throws InterruptedException{
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:additionalDiagnosis_input")).
    	sendKeys(diagnosis);
    	 Thread.sleep(10000);
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:additionalDiagnosis_input")).sendKeys(Keys.ENTER);
    	
    }
    
    public void setTeeth(String teeth) throws InterruptedException{
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:teeth_input")).
    	sendKeys(teeth);
    	//10d	
    	Thread.sleep(1000);
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:diagnosticDT:0:teeth_input")).
    	sendKeys(Keys.ENTER);
    }
    
    public void clickMed() throws InterruptedException{
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:addMedication').click()");
    }
    
    public void setsMedsName(String name) throws InterruptedException{
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:md_medicine_input")).sendKeys(name);
    	Thread.sleep(10000);
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:md_medicine_input")).sendKeys(Keys.ENTER);
    	
    }
    
    public void setDose(String amount) throws InterruptedException{
    	
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:md_dozeId_input")).clear();
    	Thread.sleep(1000);
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:md_dozeId_input")).
    	sendKeys(amount);
    	
    }
    
    public void setFrequency(String frequency) throws InterruptedException{
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:selectFreq_label').innerHtml='od:'");
		Thread.sleep(10000);
    }
    
    public void duration(String dur) throws InterruptedException{
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:md_duration_input")).clear();
    	Thread.sleep(1000);
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:medicationDT:0:md_duration_input")).sendKeys(dur);
    	 	
    }
    
    public void setDiet(String diet){
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:suggestions_input")).sendKeys(diet);
    }
    
    public void setBilling(String billing){
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:Discount")).sendKeys(billing);
    }
    
    public void setFollowUp(){
    	driver.findElement(By.className("ui-chkbox-box ui-widget ui-corner-all ui-state-default")).click();
    	
    }
    
    public void submit(){
    	driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:myform:tabView:btn_presc_save_only")).submit();
    	
    }
    
}
	
	

