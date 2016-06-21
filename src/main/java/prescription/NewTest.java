package prescription;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.Login;

public class NewTest {
    
  @Test
  public void f() throws IOException, InterruptedException {
	  WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cloudclinik.pk/web/cloudclinik");
		Login log = new Login(driver);
		log.RegisterLink();
		Thread.sleep(5000);
		log.Logincredentials("9213053774", "infogistic1");
       Thread.sleep(50000);
		WebElement condition = driver
				.findElement(By.id("_PatientHeader_WAR_CloudClinikportlet_:header_form:patient_header"));
		Assert.assertTrue(condition.isDisplayed());
		Thread.sleep(5000);
  }
}
