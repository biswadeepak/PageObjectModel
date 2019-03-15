package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TasksPage taskpage;
	
	public HomePageTest() {
		super();	
	}
	
	//Test cases should be independent
	//Before Each Testcase - Launch the Testcase
	//@test -- Execute the testcase
	//After each Tet case -- Close the browser
	@BeforeMethod
	public void setup() throws InterruptedException{
		Initialization();
		loginpage = new LoginPage();
		taskpage = new TasksPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String hommePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(hommePageTitle, "actiTIME - Enter Time-Track","HomePage Title not Matched");
	}
	
	@Test(priority=2)
	public void verifyTsksLinkTest(){
		 taskpage = homepage.clickOnTaskLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
