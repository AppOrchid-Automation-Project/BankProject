package com.bankproject.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankproject.pageObjects.Loginpage;

public class TC_loginpage_002 extends Baseclass
{
   @Test(dataProvider = "Logindata")
	public void login(String username,String password) throws InterruptedException, IOException
	{
		Loginpage lp=new Loginpage(driver);
		lp.userName(userId);
		logger.info("Username is entered");
		lp.password(password);
		logger.info("Password is entered");
		lp.loginButton();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Thread.sleep(2000);
			takeScreenshot(driver, "loginpage2");
		}
		else
		{
			Assert.assertTrue(true);
			lp.logout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
			
	}
   
   public boolean isAlertPresent()
   {
	   try 
	   {
		driver.switchTo().alert();
		return true;
	   } 
	   catch (NoAlertPresentException e)  
	   {
		return false;
	   }
   }
}
