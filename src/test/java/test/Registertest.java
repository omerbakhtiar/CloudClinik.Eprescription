package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import framework.ReadExcel;
import framework.Register;

public class Registertest {
	
	 private WebDriver driver;
	 private static String  url = "http://10.10.1.129:8080/web/cloudclinik/register";

	@BeforeClass
	  public void beforeClass() {
	      driver = new FirefoxDriver();
		 
	  }	
	
 @Test(priority=1)
  public void Registring() throws Exception {
	
		  driver.get(url); 
		  ReadExcel excel=new ReadExcel(driver);
	       excel.ReadData(2);
	       Thread.sleep(5000);
		   excel.Call(0);
		   
  }
  
/*   @Test(priority=2)
   public void MandatoryCheck() throws Exception {
	   driver.get("https://10.10.1.214/web/cloudclinik/register"); 
		   Register reg=new Register(driver);
	       Thread.sleep(10000);     
	       Assert.assertEquals(reg.ClickProceed(),"Please enter first name in alphabets");
	       Assert.assertEquals(reg.CheckmessageMobile(),"Please enter numerics 0-9 only");	
	       Assert.assertEquals(reg.CheckmessagePassword(),"Please enter alpha-numeric password");
	       Assert.assertEquals(reg.CheckmessageCaptcha(),"Enter Captcha Value");
  }*/
	
   @AfterTest
	  public void afterTest() {
		 driver.close();
	  }	
   
}
