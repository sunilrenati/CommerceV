package com.commerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.*;

import com.commerce.pageObject.LoginPage;

	public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);

		
		lp.setUserName(username);
	
		lp.setPassword(password);
		
		lp.clickLogin();
		
		logger.info("clicked on login");
		
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login passed ");
		}
		
		else
		{
			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}
		
		
	}
	


}
