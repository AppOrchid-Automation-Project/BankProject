package com.bankproject.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jenkins 
{
	 @Test
	    public void OpenBrowser()  {
	        WebDriver driver;
	        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("headless");
	        options.addArguments("disable-gpu");
	        driver = new ChromeDriver(options);
	        driver.get("https://www.google.com");
	        System.out.println("Title of the page is: " + driver.getTitle());
	        Assert.assertTrue(driver.getTitle().equals("Google"));
	        
	    }
}
