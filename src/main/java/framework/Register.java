package framework;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


	public class Register {

		private WebDriver driver;
		ArrayList<WebElement> span= new ArrayList<WebElement>();
		

		public Register(WebDriver driver) throws IOException {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			ArrayList<ReadExcel> lst = new ArrayList<ReadExcel>();

		}

		public void SelectTitle(String title) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:Title_label').innerHTML="+ "'" + title+ "'" + "");
		}

		public void SelectGender() throws InterruptedException {

			Thread.sleep(5000);
			WebElement table = driver.findElement(By.tagName("table"));

			ArrayList<WebElement> Columns_row = new ArrayList<WebElement>();
			ArrayList<WebElement> divs = new ArrayList<WebElement>();

			ArrayList<WebElement> arr = new ArrayList<WebElement>();
			arr = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));

			ArrayList<WebElement> td = new ArrayList<WebElement>();

			for (int j = 0; j < arr.size(); j++) {
				Columns_row = (ArrayList<WebElement>) arr.get(j).findElements(
						By.tagName("td"));

			}

			divs = (ArrayList<WebElement>) Columns_row.get(2).findElements(
					By.tagName("div"));
			divs.get(2).click();

			Thread.sleep(5000);
			System.out.println(Columns_row.size());
		}

		public void SetFirstName(String name) throws InterruptedException {
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:Name"))
			.sendKeys(name);
		}

		public void SetLastName(String lastName) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:LastName"))
					.sendKeys(lastName);
		}

		public void SetAge(int Age) throws InterruptedException {
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:Age"))
			.clear();

			Thread.sleep(5000);
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:Age"))
			.sendKeys(Integer.toString(Age));

		}

		public void SetUnit(String unit) {
			// document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:Units_label').innerHTML="Month"
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:Units_label').innerHTML="+ "'" + unit + "'" + "");
		}

		public void setMobileNumber(int number) {
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:Mobile"))
			.sendKeys(Integer.toString(number));

		}

		public void setPassword(String password) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:Password"))
					.sendKeys("password@80");

		}

		public void setConfirmPassword(String password) {

			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:ConfirmedPassword"))
					.sendKeys("password@80");

		}

		public void setNationality(String nationality) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:Nationality_label').innerHTML="+ "'" + nationality+ "'" + "");

		}

		public void setId(String ID) {
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:CNIC"))
			.sendKeys(ID);
		}

		public void setCountry(String Country) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:Country_label').innerHTML="
					+ "'" + Country + "'" + "");

		}

		public void selectState(String state) {
			// _SignUp_WAR_CloudClinikportlet_:form:State_label
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:State_label').innerHTML="
					+ "'" + state + "'" + "");
		}

		public void selectCity(String city) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('_SignUp_WAR_CloudClinikportlet_:form:City_label').innerHTML="
					+ "'" + city + "'" + "");

		}

		public void setBuildingNumber(String number) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:BuildingNumber"))
					.sendKeys(number);
		}

		public void setStreetAdress(String street) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:StreetAddress"))
					.sendKeys(street);
		}

		public void setZoneNumber(String number) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:ZoneNumber"))
					.sendKeys(number);
		}

		public void setSecondaryMoblie(int mobile) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:Mobile1"))
					.sendKeys(Integer.toString(mobile));

		}

		public void setOtherMobile(int otherMobile) {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:Mobile2"))
					.sendKeys(Integer.toString(otherMobile));

		}

		public void setEmail(String email) {
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:Email"))
			.sendKeys(email);
		}

		public void clickProceed() {
			driver.findElement(
					By.id("_SignUp_WAR_CloudClinikportlet_:form:regSignUpBtn"))
					.click();
		}
		
		public String ClickProceed() throws InterruptedException{
           clickProceed();
           Thread.sleep(10000);
           span= (ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:firstName")).
              		  findElements(By.tagName("span"));  
    
           
         return (span.get(1).getText().toString());		
		}
		
		public String CheckmessageMobile() throws InterruptedException{
			    Thread.sleep(10000);
		
		span=(ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:primaryMobile")).
							findElements(By.tagName("span"));
		return (span.get(1).getText().toString());
		}
		
		public String CheckmessagePassword() throws InterruptedException{
				span=(ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:pswd")).
						findElements(By.tagName("span"));
				 Thread.sleep(1000);
			 
			return (span.get(1).getText().toString());	
		}	
		
		public String CheckmessageconfirmPassword() throws InterruptedException{
			
			span=(ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:cpswd")).
					findElements(By.tagName("span"));
			
			return (span.get(1).getText().toString());		
		}	
         
		public String CheckmessageCaptcha() throws InterruptedException{
			
			span=(ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:cpswd")).
					findElements(By.tagName("span")); 
			 Thread.sleep(10000);
			 
			return (span.get(1).getText().toString());		
		}
	    
		public String lengthFirst(String name) throws InterruptedException{
			driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:Name"))
			.sendKeys(name);
			Thread.sleep(100);
			
			clickProceed();
			Thread.sleep(1000);
			span=(ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:firstName")).
					findElements(By.tagName("span")); 
			
			return (span.get(1).getText().toString());		
			
		}
		
	    public String checkLengthpassword(String password) throws InterruptedException{
	    	
	    	 driver.findElement(
						By.id("_SignUp_WAR_CloudClinikportlet_:form:Password"))
						.sendKeys("pass1");
	    	 Thread.sleep(10000);
	    	 clickProceed();
	    	 span=(ArrayList<WebElement>) driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:form:pswd")).findElements(By.tagName("span"));
	    	 return span.get(1).getText().toString();
	    	 
	    }
	
	}
	
