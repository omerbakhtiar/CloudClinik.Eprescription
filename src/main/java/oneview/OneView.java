package oneview;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

import static org.testng.Assert.*;

public class OneView {

	WebDriver driver;
	ArrayList<WebElement> divs = new ArrayList<WebElement>();
	ArrayList<WebElement> li = new ArrayList<WebElement>();
	ArrayList<WebElement> row = new ArrayList<WebElement>();
	ArrayList<WebElement> td = new ArrayList<WebElement>();
	ArrayList<WebElement> span = new ArrayList<WebElement>();
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public OneView(WebDriver driv) {
		driver = driv;
	}

	public void clickOneView() throws InterruptedException {
		driver.findElement(By.linkText(".")).click();
	}

	public void clickOnEmptySlot(int index) {
		WebElement ele = driver.findElement(By.className("fc-agenda-slots"));
		row = (ArrayList<WebElement>) ele.findElements(By.tagName("tr"));

		td = (ArrayList<WebElement>) row.get(index).findElements(
				By.tagName("td"));

		td.get(0).findElement(By.tagName("div")).click();
	}

	public void clickOnAppointment(String data) throws InterruptedException {
		
		divs=(ArrayList<WebElement>) driver.findElements(By.cssSelector("div[class='fc-event-time']"));
		
		System.out.println(divs.get(0).getText());
		System.out.println(divs.get(1).getText());
	 
	    for(int i=0;i<divs.size();i++){
	    	
	    	if(divs.get(i).getText().contains(data)){
	    		divs.get(i).click();
	    		break;
	    	}
	    }
		
	}

	public void clickOnPayment(){
		driver.findElement(By.linkText("Payment")).click();
	}
	
	
}
