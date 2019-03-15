package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Open Tasks')]")
	@CacheLookup
	WebElement tasklebel;
	
	@FindBy(xpath="//a[contains(text(),'Projects & Customers')]")
	WebElement projectAndCustomersBtn;
	
	@FindBy(xpath="//span[contains(text(),'Create Customer')]")
	WebElement createCustomer;
	
	@FindBy(xpath="//input[@id='customerLightBox_nameField']")
	WebElement customerName;	
	
	@FindBy(xpath="//span[@class='buttonTitle'][contains(text(),'Create Customer')]")
	WebElement createCustomerBtn;
	
	//Initializing the Page Object
		public TasksPage(){
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyTasklebel(){
			return tasklebel.isDisplayed();
		}
		
		public void selectCustomerByName(String name){
			driver.findElement(By.xpath("//tr[td[table[tbody[tr[td[a[contains(text(),'"+name+"')]]]]]]]/td[7]/input")).click();; 
			
		}
		
		public void activeCustomersAndProjectsPage(){
			tasklebel.click();
			projectAndCustomersBtn.click();
		}
		
		public void createNewCustomer(String custName){
			
			projectAndCustomersBtn.click();
			createCustomer.click();
			customerName.sendKeys(custName);
			createCustomerBtn.click(); 
		}
		
		
}
