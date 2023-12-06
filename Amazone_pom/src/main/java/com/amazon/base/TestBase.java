package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.utill.TestUtil;
import com.amazon.utill.WebEventListener;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
public  TestBase()  {
			
try {
	
	prop = new Properties();
	FileInputStream ip = new FileInputStream("C:\\QA\\selenium_workspace\\Amazone_pom\\src\\main\\java\\com\\amazon\\config\\config.properties\\");
	prop.load(ip);
} catch (FileNotFoundException e) {
	//e.printStackTrace();
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
 }
}

@SuppressWarnings("deprecation")
public static void initilization() throws InterruptedException {
String browserName=prop.getProperty("browser");
//System.out.println("jhndfjdbdfhjdjfjjfjfj---------------------------------"+browserName);
if (browserName.equals("chrome")) {
System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
	driver = new ChromeDriver();
	// driver.get("https://classic.freecrm.com/index.html");

} else if (browserName.equals("ff")) {

 System.setProperty("webdriver.gecko.driver", "C:\\QA\\seleniumjars\\geckodriver.exe");

//	System.setProperty("webdriver.gecko.driver", "D:\\Selenuimjars_1\\geckodriver.exe");
	driver = new FirefoxDriver();

	
	
	
	// 
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	
	
	
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	// above is @deprecated method, due to some security reasons this method 
 	//is no longer is appreciated to use
 	//Thread.sleep(5000);
    driver.manage().timeouts().implicitlyWait(/*Duration.ofSeconds(TestUtil.IMPLICIT_WAIT)*/
    		Duration.ofSeconds(TestUtil.IMPLICT_WAIT));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.get(prop.getProperty("url"));
	Thread.sleep(4000);
	
	
}
}	

}
