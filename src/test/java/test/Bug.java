package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.Login;

public class Bug {
	 private WebDriver driver;
	 
	@BeforeClass
	  public void beforeClass() {
	      driver = new FirefoxDriver();
		 
	  }	
	
	@Test(priority=1)
	public void Login() throws IOException, InterruptedException {
		
		driver.get("http://192.168.8.103:8080/");
		Login log = new Login(driver);
		Thread.sleep(1000);
		
		log.RegisterLink();
		Thread.sleep(10000);
		log.Logincredentials("974100301867", "test@1989");
		
         Thread.sleep(10000);
         driver.findElement(By.cssSelector("img[alt=\"CloudClinik\"]")).click();
         
         Thread.sleep(10000);
         String message=driver.findElement(By.xpath(".//*[@id='header']/h2")).getText();
        
         //Assert.assertTrue(!message.contains("Appointment / Find Doctor"));
  
         Assert.assertTrue(driver.findElement(By.className("cc_DesktopNavigation_contactUs")).isDisplayed());
  
		
	}
	
}
