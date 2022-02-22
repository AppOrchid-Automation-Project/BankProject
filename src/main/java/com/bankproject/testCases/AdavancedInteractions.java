package com.bankproject.testCases;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AdavancedInteractions
{  
	@Test
     public void click() throws InterruptedException, IOException
     {
	   DesiredCapabilities cap=null;
	   cap=DesiredCapabilities.chrome();
	   cap.setBrowserName("chrome");
	   cap.setPlatform(Platform.LINUX);
	   
	  // RemoteWebDriver driver=new RemoteWebDriver(new URL("http://172.31.10.239:4444/wd/hub"),cap);
	   RemoteWebDriver driver=new RemoteWebDriver(new URL("http://65.0.127.104:4444/wd/hub"),cap);
	   System.out.println("Remote webdriver is started for chrome");
			   
	  // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
	   //To run on jenkins and windows server mechine
	  // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
   	 //WebDriver driver=new ChromeDriver();
	   
   	   driver.get("https://www.google.com");
   	   
   	   System.out.println("website is hitted on chrome");
   	   
   	   driver.manage().window().maximize();
   	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	   Thread.sleep(2000);
   	   
   	   Actions action= new Actions(driver);
   	   
   	   WebElement link=driver.findElement(By.linkText("Gmail"));
   	 System.out.println("clicked on gmail link");
   	   
   	   action.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
   	   sendKeys(Keys.ENTER).build().perform();
   	   
   	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	  // String dest=(("user.dir")+"/Driver/Screenshots/test3chrome.png");
   	   
   	   FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"/Screenshots/chrometest.jpg"));
   	    System.out.println("Screenshot is taken and store on the location");
     }
}
