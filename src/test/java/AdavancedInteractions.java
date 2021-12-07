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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class AdavancedInteractions
{  
	WebDriver driver;
	
	@Test
     public void click() throws InterruptedException, IOException
     {
       //  if(browser.equalsIgnoreCase("chrome")) 
		//  { 
          DesiredCapabilities cap1;
		  cap1=DesiredCapabilities.chrome(); 
		  cap1.setBrowserName("chrome"); 
		  driver=new RemoteWebDriver(new URL("http://13.127.62.27:4444/wd/hub"),cap1);
		  System.out.println("launched chrome browser"); 
		 // } 
	//	  else if(browser.equalsIgnoreCase("firefox")) 
		//  { 
		  //DesiredCapabilities cap2;
		  //cap2=DesiredCapabilities.firefox(); 
		  //cap2.setBrowserName("firefox");
		  //driver=new RemoteWebDriver(new URL("http://13.127.62.27:4444/wd/hub"),cap2);
		  //System.out.println("launched firefox browser"); 
		  //}
		 
   	   driver.get("https://www.google.com");
   	   driver.manage().window().maximize();
   	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	   Thread.sleep(2000);
   	   
   	   Actions action= new Actions(driver);
   	   
   	   WebElement link=driver.findElement(By.linkText("Gmail"));
   	   
   	   action.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
   	   sendKeys(Keys.ENTER).build().perform();
   	   System.out.println("clicked on the Gmail link");
   	   
    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	   FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"/Screenshots/test2.jpg"));
   	   System.out.println("screenshot is taken");
   	    
   	    driver.close();
   	    
   	    System.out.println("closed the browser");
     }
}
