package com.commerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
		 public LoginPage(WebDriver rdriver)
		
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
		 	
			
		@FindBy(name="Email")
		@CacheLookup					// this will store above email element in buffer not mandatory code
		WebElement txtEmail;
		
		@FindBy(name="Password")
		@CacheLookup		
		WebElement txtPassword;
		
		@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
		@CacheLookup		
		WebElement btnlogin;
		
		@FindBy(linkText="Logout")
		@CacheLookup		
		WebElement btnlogout;
		
		public void setUserName(String uname)
		{
			txtEmail.clear();
			txtEmail.sendKeys("admin@yourstore.com");
		}
		
		public void setPassword(String pwd)
		{	
			txtPassword.clear();
			txtPassword.sendKeys("admin");
		}
		
		
		public void clickLogin()
		{
				btnlogin.click();
		}
		
		public void clickLogout()
		{
				btnlogout.click();
		}
		
		
		
	
	
	
}
