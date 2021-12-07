import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tagname 
{
	@Test
     public void tagName() throws InterruptedException
     {
    	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
    	 WebDriver driver= new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
    	 driver.get("http://www.bing.com");
    	 
    	 WebElement ele=driver.findElement(By.linkText("Videos"));
    	 String actAtt=ele.getAttribute("href");
    	 
    	 ele.click();
    	 
    	 Thread.sleep(1000);
    	 
    	 System.out.println(driver.getCurrentUrl()+" "+"Is the url");
    	 System.out.println(driver.getTitle()+" "+"Is the title");
    	 
    	// Assert.assertEquals(actAtt, driver.getCurrentUrl());
     }
     
}
