package ePrescriptionM.CloudClinik.Eprescription;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HistorEdit {
	
	WebDriver driver;
	
	public HistorEdit(WebDriver driv){
		driver=driv;
	}

	public void selectHistory(){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:btn_history_edit")).click();
		
	}
	
	public void searchMr(String mr) throws InterruptedException{
		Thread.sleep(20000);
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:mrn")).sendKeys(mr);
		
	}
	
	public void searchName(String name){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:pname")).sendKeys(name);
	}
	
	public void searchButton(){
		driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:searchBtn")).click();
	}

	public void selectCalender(){
		//driver.findElement(By.id("_CCDENTAL_WAR_CCDENTALportlet_:tool_form:pres_print_panel:vdate_input")).sendKeys("");
		String s=driver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:j_idt50")).toString();
		System.out.println(s);
		
		//driver.findElement(By.xpath("//*[@id='_Eprescription_WAR_CloudClinikportlet_:tool_form:pres_print_panel:vdate_input']")).click();
		
	}

    public void selectCurrent(){
     driver.findElement(By.linkText("Current Patient")).click();
     
    }


}
