package prescription;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LabSet {

	WebDriver driver;
	ArrayList<WebElement> td = new ArrayList<WebElement>();

	public LabSet(WebDriver driv) {
		driver = driv;
	}

	public void select() {
		// .//*[@id='_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT']/div/table/tbody/tr/td[1]/div

		WebElement ele = driver
				.findElement(By
						.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT"));
		WebElement ela = ele.findElement(By.tagName("div"))
				.findElement(By.tagName("table"))
				.findElement(By.tagName("tbody")).findElement(By.tagName("tr"));
		td = (ArrayList<WebElement>) ela.findElements(By.tagName("td"));
		td.get(0).findElement(By.tagName("div")).click();
	}

	public boolean getData(String data, String data2) {
		String s = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:0:j_idt666:0:loincSetResult"))
				.getAttribute("value");

		String s2 = driver
				.findElement(
						By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:loincDT:0:j_idt666:0:loincSetResultComments"))
				.getAttribute("value");

		if (s.contains(data) && s2.contains(data2)) {
			return true;
		} else {
			return false;
		}

	}

}
