package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	// Page Factory  
	@FindBy(name="username")
	private WebElement username; 
	 		
	
	@FindBy(name="pwd")
	 private WebElement password;
	
	@FindBy(xpath="//a[@class='initial']//div[contains(text(),'Login')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='/img/custom/logo.0.767324014879954.jpg?hash=970234804']")
	private WebElement actiTimeLogo;
	
	//How to initialize the elements using PageFactory
	//Use Constructor
	//driver is object of Webdriver
	//this refers to all the variables of current class object (username,password.loginBtn,actiTimeLogo)
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Actions
	
	public String valiadteLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean validateactiTimeImg(){
		return actiTimeLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(5000);
		
		return new HomePage();
	}
	
	
	
	

}
