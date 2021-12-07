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
	   cap.setPlatform(Platform.WINDOWS);
	   
	   RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),cap);
			   
	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
   	 //WebDriver driver=new ChromeDriver();
   	   driver.get("https://www.google.com");
   	   driver.manage().window().maximize();
   	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	   Thread.sleep(2000);
   	   
   	   Actions action= new Actions(driver);
   	   
   	   WebElement link=driver.findElement(By.linkText("Gmail"));
   	   
   	   action.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
   	   sendKeys(Keys.ENTER).build().perform();
   	   
   	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	   String dest=(("user.dir")+"/Driver/Screenshots/test2.png");
   	   
   	   FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"/Screenshots/test1.jpg"));
   	    System.out.println("done");
     }
}
