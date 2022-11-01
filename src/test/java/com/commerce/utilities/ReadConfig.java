package com.commerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() 
	{
	
		String url=pro.getProperty("baseURL");		// baseurl from config properties
		return url;
	}
	
	public String getUseremail() 
	{
	
		String url=pro.getProperty("useremail");
		return url;
	}
	
	public String getPassword() 
	{
	
		String url=pro.getProperty("password");	
		return url;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");		// chromepath is from config properties 
	return chromepath;
	}
	
	public String getEdgePath()
	{
	String iepath=pro.getProperty("edgepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	
}
