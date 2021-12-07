package com.bankproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankproject.pageObjects.Addnewcustomer;
import com.bankproject.pageObjects.Loginpage;

public class Tc_loginPage_001 extends Baseclass
{
	//If guru99 site cred are expired use link "http://demo.guru99.com/" we can recreate cred
	Loginpage lp;
	Addnewcustomer newcustomer;
	@Test(priority = 1)
    public void login()
    {
    	
		lp=new Loginpage(driver);
		
		
		lp.userName(userId);
	    logger.info("Username is entered");
	    
        lp.password(password);
        logger.info("Password is entered");
        
        lp.loginButton();
        logger.info("clicked on login button");
        
        String text="Manger Id : ";
        String expUname=text+userId;
        //"//td[contains(text(),'Manger Id : "expUname"')]"
        String actUname=driver.findElement(By.xpath("//td[contains(text(),'"+expUname+"')]")).getText();
        if(expUname.equals(actUname))
        {
        	Assert.assertTrue(true);
        	logger.info("User names are asserted and they are matching");
        }else
        {
        	Assert.assertTrue(false);
        	logger.info("User names are asserted and they are not matching");
        }
        
    }
	
}
