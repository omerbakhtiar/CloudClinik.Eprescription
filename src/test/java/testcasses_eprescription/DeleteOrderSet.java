package testcasses_eprescription;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prescription.Epres;
import prescription.OrderSet;

public class DeleteOrderSet {
	WebDriver driver = new FirefoxDriver();
	Epres sr = new Epres(driver);
	OrderSet order = new OrderSet(driver);
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	boolean result;

	@Test(enabled = false)
	public void deleteOrderSet() throws IOException, InterruptedException {
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		order.selectOrderSet();
		Thread.sleep(10000);
		order.deleteOrderSet("dengue");
	}
		

	@Test(priority = 1)
	public void deleteComplaints() throws InterruptedException, IOException {
		driver.manage().deleteAllCookies();
		Thread.sleep(10000);
		String s = sr.Searching("974100232885", "infogistic@1"," 974100301865");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		order.selectOrderSet();
		Thread.sleep(1000);
		order.editOrderSet("dengue");
		Thread.sleep(10000);
		order.deleteComplaints();
		Thread.sleep(1000);
	}
	
		

	@Test(priority = 2)
	public void deleteDoctorNotes() throws InterruptedException {
		Thread.sleep(1000);
	    order.deleteDoctorNotes();
	    Thread.sleep(1000);
		order.clickUpdate();
		Thread.sleep(10000);
		String s=order.viewdeleteNotes();
		Assert.assertEquals(s,"");
		  
	}

	@Test(priority = 3)
	public void deleteDiease() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteDiseases();
		Thread.sleep(10000);
		String s=order.verifyDeletedDieases();
		Assert.assertEquals(s,"");
	}

	@Test(priority = 4)
	public void deleteProcedure() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteProcedure();
		String s=order.verfiydeleteProcedure();
		Assert.assertEquals(s,"");
	}

	@Test(priority = 5)
	public void deleteLabSet() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteLabSet();
		String s=order.verifyDeleteLab();
		Assert.assertEquals(s,"");
	}

	@Test(priority = 6)
	public void deleteMedicine() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteMedicine();
		String s=order.verifyDeleteMedicine();
		Assert.assertEquals(s,"");
	}

	@Test(priority = 7)
	public void deleteDiet() throws IOException, InterruptedException {
		Thread.sleep(10000);
		order.deleteInstruction();
		Thread.sleep(1000);
		order.clickUpdate();
		result=order.sucessfulUpdateMessage();
		Thread.sleep(10000);
		Assert.assertTrue(result);
		Thread.sleep(1000);
		order.closeMainWindow();
	}

	

private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }


}

