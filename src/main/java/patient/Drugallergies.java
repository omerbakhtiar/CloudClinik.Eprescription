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

public class Drugallergies {
	WebDriver driver;
	ArrayList<WebElement>divs=new ArrayList<WebElement>();
	
	public Drugallergies(WebDriver driv){
		driver=driv;
	}
	
	public void selectDrug() throws InterruptedException{
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("left-col")).findElement(By.tagName("ul")).findElement(By.className("child-menu"));
		ArrayList<WebElement> divs = (ArrayList<WebElement>) ele.findElements(By.tagName("li"));
		
		Thread.sleep(1000);
		divs.get(6).click();	
		
	}

	public void selectAdd() throws InterruptedException{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('_drugReactions_WAR_CloudClinikportlet_:form:addDrugAllergieBtn').click()");
		
	}
	
	public void setMedBrand(String brand) throws InterruptedException{
		Thread.sleep(10000);
		driver.findElement(By.id("_drugReactions_WAR_CloudClinikportlet_:dlgForm:MedicineBrand_input")).sendKeys(brand);
		Thread.sleep(10000);
		driver.findElement(By.id("_drugReactions_WAR_CloudClinikportlet_:dlgForm:MedicineBrand_input")).sendKeys(Keys.ENTER);
	}
	
	public void setReactionDetail(String detail) throws InterruptedException{
		driver.findElement(By.id("_drugReactions_WAR_CloudClinikportlet_:dlgForm:ReactionDetial")) .sendKeys(detail);
		Thread.sleep(1000);
	}
	
	public void setGeneric(String generic) throws InterruptedException{
		driver.findElement(By.id("_drugReactions_WAR_CloudClinikportlet_:dlgForm:Generic_input")).sendKeys(generic);
		Thread.sleep(1000);
		driver.findElement(By.id("_drugReactions_WAR_CloudClinikportlet_:dlgForm:Generic_input")).sendKeys(Keys.ENTER);
	}
	
	public void setSeverity(String amount) throws InterruptedException{
		 driver.findElement(By.className("ui-selectonemenu-trigger")).click();
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//*[@id='_drugReactions_WAR_CloudClinikportlet_:dlgForm:Severity_panel']/div/ul/li[6]")).click();
	}
	
	 public void saveAllergies() throws InterruptedException{
		 Thread.sleep(10000);
		 driver.findElement(By.id("_drugReactions_WAR_CloudClinikportlet_:dlgForm:saveDrugAllergyBtn")).click();
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
		Drugallergies drug=new Drugallergies(driver);
		drug.selectDrug();
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
		 drug.selectAdd();
		 Thread.sleep(10000);
		 drug.setSeverity("1");
		 Thread.sleep(1000);
		 drug.setMedBrand("T-5740 : C MAX SACHETS(Calcium Supplement Preps)");
		 Thread.sleep(10000);
		 drug.setReactionDetail("nozia");
		 Thread.sleep(10000);
		 drug.setGeneric("Cefixime");
		 Thread.sleep(10000);
		 drug.saveAllergies();
		/* Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='_drugReactions_WAR_CloudClinikportlet_:dlgForm:Severity_input']")));
		 dropdown.selectByIndex(2);
		 Thread.sleep(1000);
		// drug.saveAllergies();*/
	 }
}



