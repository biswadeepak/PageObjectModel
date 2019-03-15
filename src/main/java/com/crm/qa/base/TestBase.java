package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_Driver;
	public static WebEventListener eventListener;

	public TestBase(){
		
		try{
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("\\Users\\CHINKU\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void Initialization(){
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Naveen Automation Labs\\Selenium Software\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Naveen Automation Labs\\Selenium Software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_Driver = new EventFiringWebDriver(driver);
		//Now Create object of EventListenHandler to register with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_Driver.register(eventListener);
		driver = e_Driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
	
