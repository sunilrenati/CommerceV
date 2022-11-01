package com.commerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commerce.pageObject.LoginPage;
import com.commerce.pageObject.AddCustomerPage;
public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(baseURL);
	
	LoginPage lp=new LoginPage(driver);
	


	lp.setUserName(username);
	logger.info("User name is provided");
	
	lp.setPassword(password);
	logger.info("password is provided");
	
	lp.clickLogin();
	
	logger.info("providing customer details....");
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	
	addcust.clickOnCustomersMenu();
	addcust.clickOnCustomersMenuItem();
	
	addcust.clickOnAddnew();
	
	String email = randomestring() + "@gmail.com";
	addcust.setEmail(email);
			
	addcust.setPassword("test123");
	Thread.sleep(2000);
	//Registered - default
	//The customer cannot be in both 'Guests' and 'Registered' customer roles
	//Add the customer to 'Guests' or 'Registered' customer role
	addcust.setCustomerRoles("Guest");
	Thread.sleep(2000);
	addcust.setManagerOfVendor("Vendor 2");
	Thread.sleep(2000);
	addcust.setGender("Male");
	Thread.sleep(2000);
	addcust.setFirstName("Pavan");
	addcust.setLastName("Kumar");
	Thread.sleep(2000);
	addcust.setDob("7/05/1985"); // Format: D/MM/YYY
	Thread.sleep(2000);
	addcust.setCompanyName("busyQA");
	addcust.setAdminContent("This is for testing.........");
	Thread.sleep(2000);
	addcust.clickOnSave();
	
	logger.info("validation started....");
			
	//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	
	String msg = driver.findElement(By.tagName("body")).getText();
		
	
	if(msg.contains("The new customer has been added successfully."))
	{
		Assert.assertTrue(true);
		logger.info("test case passed....");
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
			
}
}
