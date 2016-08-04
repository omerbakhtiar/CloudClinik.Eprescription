package appointment_test;

import java.io.IOException;

import helper.Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import appointment.Appoints;
import framework.Login;
import framework.ReadExcel;

public class NewTest {

	@Test
	public void f() throws IOException, InterruptedException {
		String exePath = "D:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		Logger logger = Logger.getLogger(appointment_test.Urgent.class);
		WebDriver driver = new ChromeDriver();
		Login log = new Login(driver);
		Helper help = new Helper(driver);
		Appoints app = new Appoints(driver);
		help.implicitWait(driver);
		log.Logincredentials("974100232895", "infogistic@1");
		Thread.sleep(10000);
		app.pressAppointment(0);
		Thread.sleep(1000);
		app.bookAppointmentMenu(0, 0);
		Thread.sleep(10000);
		app.registerPatient();
		Thread.sleep(10000);
		ReadExcel excel = new ReadExcel(driver);
		excel.ReadData(2);
		Thread.sleep(10000);
		excel.callForRegister(0);
		Thread.sleep(7000);
		app.clickOnOk();
	}
}
