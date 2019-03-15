package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//img[@src='/img/custom/logo.0.767324014879954.jpg?hash=970234804']")
	private WebElement imagelebel;
	
	@FindBy(xpath="//a[@class='content tasks']/img")
	WebElement taskLink;
	
	@FindBy(xpath="//a[@class='content reports']/img")
	private WebElement reportLink;
	
	@FindBy(xpath="//a[@class='content users']/img")
	private WebElement usersLink;
	
	
	//Initializing the Page Object
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public TasksPage clickOnTaskLink(){
		taskLink.click();
		return new TasksPage();
	}
	
	public ReportsPage clickOnReportsPage(){
		reportLink.click();
		return new ReportsPage();
	}
	
	public UsersPage clickOnUsersPage(){
		reportLink.click();
		return new UsersPage();
	}
	
	

}
