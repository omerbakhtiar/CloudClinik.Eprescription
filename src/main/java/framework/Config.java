package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Config{

public  static WebDriver driver=new FirefoxDriver();

@BeforeSuite
public void setup(){

}

public Config(){
}

}