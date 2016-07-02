package helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.thoughtworks.selenium.Wait;

public class Helper {

	WebDriver driver;

	public Helper(WebDriver driver2) {
		driver = driver2;
		PageFactory.initElements(driver2, this);

	}

	public void WindowHandles() {
		String parentWindowHandler = driver.getWindowHandle(); // Store your
																// parent window
		String subWindowHandler = null;

		HashSet<String> handles = (HashSet<String>) driver.getWindowHandles(); // get
																				// all
																				// handles
		Iterator<String> iterator = handles.iterator();

		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}

		driver.switchTo().window(subWindowHandler);

	}

	public static void waits(WebDriver driver) {

		FluentWait wait = new FluentWait(driver)
				.withTimeout(2, TimeUnit.MINUTES)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
	}

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	public static void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
}
