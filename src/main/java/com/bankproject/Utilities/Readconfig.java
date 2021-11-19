package com.bankproject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig 
{
	Properties properties;
    public Readconfig() {
		File inputfile=new File("./Configuration/config.properties");
		
		try {
			FileInputStream inputstream=new FileInputStream(inputfile);
			properties=new Properties();
			properties.load(inputstream);
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
			System.out.println("Not able to locate the file"+e.getMessage());
		}
		
    }
    public String getbaseURL()
    {
    	String urlPath=properties.getProperty("baseURL");
    	return urlPath;
    }
    
    public String getUsername()
    {
    	String username=properties.getProperty("userId");
    	return username;
    }
    
    public String getPassword()
    {
    	String password=properties.getProperty("password");
		return password;
    	
    }
    public String getChromepath()
    {
    	String chromepath=properties.getProperty("chromepath");
		return chromepath;
    	
    }
    
    public String getFirefoxpath()
    {
    	String firefoxpath=properties.getProperty("firefoxpath");
		return firefoxpath;
    	
    }
    
    public String getEdgepath()
    {
    	String edgepath=properties.getProperty("msedgepath");
		return edgepath;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
