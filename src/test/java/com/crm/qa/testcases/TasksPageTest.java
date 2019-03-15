package com.crm.qa.testcases;

import org.apache.poi.ss.formula.SheetNameFormatter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TasksPage taskpage;
	
	String sheetName = "Projects&Cust";
	
	
	public TasksPageTest() {
		super();	
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		Initialization();
		loginpage = new LoginPage();
		taskpage = new TasksPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		taskpage = homepage.clickOnTaskLink();
	}
	
	
	@Test(priority=1)
	public void verifyTasksPageLabel(){
		Assert.assertTrue(taskpage.verifyTasklebel(),"Contacts Lebel is missing on the page");
	}
	
	@Test(priority=2)
	public void selectTaskPage(){
		
		taskpage.selectCustomerByName("Building design");
		taskpage.selectCustomerByName("Building regulations");
		//taskpage.selectCustomerByName("W-0");
	}
	
	@DataProvider
	public Object[][] getActiTimeData(){
		Object data[][] = TestUtil.getTestData(sheetName); 
		return data;
	}
	
	@Test(priority=3, dataProvider="getActiTimeData")
	public void validateCreateNewCustomer(String CustomerName){
		//taskpage.createNewCustomer("Biswadeepak Swain");
		taskpage.createNewCustomer(CustomerName);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
