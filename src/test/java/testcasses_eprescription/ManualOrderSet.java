package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class ManualOrderSet {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	 OrderSet order=new OrderSet(driver);
  @Test (priority=1)
  public void complaints()  throws IOException, InterruptedException {
		  String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		  Thread.sleep(2000);
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
		
		  order.selectOrderSet();
		  Thread.sleep(10000);
		  order.clickAddNew();
	      Thread.sleep(20000);
	      order.clickTemplates();
	      Thread.sleep(10000);
	      order.addTemplate();
	      Thread.sleep(1000);
	      order.closeNotesTemplate();
	      Thread.sleep(10000);
	      order.setComplaints("nauzia");
	      Thread.sleep(10000);
	      order.setDoctorNotes("test notes");
	      Thread.sleep(1000);
	      order.setOrderSetName("dengue");
	      Thread.sleep(10000);
	 
  }
  @Test(priority=2)
  public void setDisease() throws InterruptedException{
	  order.addDisease();
	  Thread.sleep(1000);
	  order.addDieaseData("Cough");
  }
  
  @Test(priority=3)
  public void setProcedureData() throws InterruptedException{
	   order.addProcedureClick();
	   Thread.sleep(10000);
	   order.addProcedureData("GEN03 : Emergency Call");
	   Thread.sleep(1000);
	   order.addProcedureNote("testing note for the procedure");
	   Thread.sleep(1000); 
  }
  
  @Test(priority=4)
	 public void setLab() throws InterruptedException{
		 order.addLabButton();
		 Thread.sleep(10000);
		 order.labSetData("MLABSET01",0);
		 Thread.sleep(1000);
		 order.setLabsetInstructions("testing instructiong lab test manual",0);
		 Thread.sleep(2000);
		 order.addLabButton();
		 Thread.sleep(10000);
		 order.labSetData("Long Name of Manual Lab",1);
		 Thread.sleep(1000);
		 order.setLabsetInstructions("testing instructions lab test manual", 1);
		 Thread.sleep(1000);
	 }
  
  @Test(priority=4)
	 public void setMedicine() throws InterruptedException{
		 order.addMedicieneButton();
		 Thread.sleep(10000);
		 order.setMedicineData("panadol ADVANCE", 0);
		 Thread.sleep(1000);
		 order.insertDosageUnit("10", 0);
		 Thread.sleep(1000);
		 order.setMedicineFrequency(0, 0);
		 Thread.sleep(1000);
		 order.setMedicineDuration("10", 0);
		 Thread.sleep(1000);
		 order.setMedicineRoute(2);
		 Thread.sleep(1000);
		 
  }
}
