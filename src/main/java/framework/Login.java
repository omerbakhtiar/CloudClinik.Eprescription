package framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public WebDriver driver;

	@FindBy(id = "_58_login")
	private WebElement idn;

	@FindBy(id = "_58_password")
	private WebElement password;
	
	

	public Login(WebDriver driver1) throws IOException {

		this.driver = driver1;
		PageFactory.initElements(driver, this);
	}

	public void Logincredentials(String id, String pass)
			throws InterruptedException {
		
		driver.get("http://10.10.1.129:8080/web/cloudclinik/cc-login");
		Thread.sleep(10000);
		
		idn.sendKeys(id);
		password.sendKeys(pass);
		
        Thread.sleep(1000);
        driver.findElement(By.className("button-holder")).findElement(By.tagName("button")).submit();
	}

	public void RegisterLink() {

		driver.findElement(By.className("last_nav")).click();
	}
	
	
	public void clickPatient(){
		
		driver.findElement(By.id("_appointmentWidget_WAR_CloudClinikportlet_:form:btn_select_patient")).submit();
	}


	
}
