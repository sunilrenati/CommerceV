package com.commerce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	By lnkCustomers_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By btnAddnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a"); //Add new
		
	By txtEmail=By.xpath("//*[@id=\"Email\"]");
	By txtPassword=By.xpath("//*[@id=\"Password\"]");
	
	By txtFirstName=By.xpath("//*[@id=\"FirstName\"]");
	By txtLastName=By.xpath("//*[@id=\"LastName\"]");
	
	
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtDob=By.xpath("//*[@id=\"DateOfBirth\"]");	
	
	By txtCompanyName=By.xpath("//*[@id=\"Company\"]");
	
	
	By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	By lstitemAdministrators=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	By lstitemRegistered=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li[2]/span[1]");
	By lstitemGuests=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	By lstitemVendors=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li[2]/span[1]");
	
	By drpmgrOfVendor=By.xpath("//*[@id=\"VendorId\"]");
	
	

	

	
	
	
	
		
	By txtAdminContent=By.xpath("//*[@id=\"AdminComment\"]");
	
	By btnSave=By.xpath("//*[@id=\"AdminComment\"]");
	
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	
	public void setCustomerRoles(String role) 
		{
			ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")).click();
		
			ldriver.findElement(txtcustomerRoles).click();
						
			WebElement listitem;
			
			switch(role)
			{
			case "Administrators":
					listitem=ldriver.findElement(lstitemAdministrators); break;
			case "Guests":
					listitem=ldriver.findElement(lstitemGuests); break;
			case "Registered":
				listitem=ldriver.findElement(lstitemRegistered); break;
			case "Vendors":
				listitem=ldriver.findElement(lstitemVendors); break;
			default:
				listitem=ldriver.findElement(lstitemGuests);
			}
						
			JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
			
	}

	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFeMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();//Default
		}
		
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}

}
