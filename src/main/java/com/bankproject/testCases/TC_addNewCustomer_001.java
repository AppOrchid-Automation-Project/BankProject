package com.bankproject.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankproject.pageObjects.Addnewcustomer;
import com.bankproject.pageObjects.Loginpage;

public class TC_addNewCustomer_001 extends Baseclass
{
	@Test
    public void addNewCust() throws InterruptedException, IOException
    {
		Loginpage lp=new Loginpage(driver);
		lp.userName(userId);
		lp.password(password);
		lp.loginButton();
		
		Thread.sleep(2000);
		
    	Addnewcustomer newcust=new Addnewcustomer(driver);
    	newcust.newCustomerText();
  		newcust.customerName("mallikarjun");
  		newcust.gender("Male");
  		newcust.dob("26", "12", "1989");
  		
  		Thread.sleep(2000);
  		
  		newcust.address("hyderabadkukatpally");
  		newcust.city("hyderabad");
  		newcust.state("telangana");
  		newcust.pin(500072);
  		newcust.mobileNumber("1234567890");
  		String email=randomString()+"@gmail.com";
  		newcust.email(email);
  		newcust.password("mallikarjun");	
  		newcust.submit();
  		
  		
  		//driver.switchTo().alert().accept();
  		
  		Thread.sleep(5000);
  		
  		if(newcust.successmsg().equals("Customer Registered Successfully!!!"))
  		{
  			logger.info("Customer Registered Successfully!!!");
  			Assert.assertTrue(true);
  		}
  		else
  		{
  			takeScreenshot(driver, "addNewCustomer");
  			logger.info("Customer is not Registered !!!");
  			Assert.assertTrue(false);
  		}
    	}
	
	public String randomString()
	{
		String alpha=RandomStringUtils.randomAlphabetic(5);
		return alpha;
	}
    }

