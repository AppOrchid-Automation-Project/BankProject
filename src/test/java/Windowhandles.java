import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Windowhandles 
{
	@Test
    public void dropdown() throws Exception
    {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
 	   WebDriver driver=new ChromeDriver();
 	   driver.get("https://opensource-demo.orangehrmlive.com/");
 	   driver.manage().window().maximize();
 	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	   Thread.sleep(2000);
 	   
 	   String parentwindow=driver.getWindowHandle();
 	   
 	   JavascriptExecutor js=((JavascriptExecutor)driver);
 	   
    	WebElement link=driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]"));
 	   
 	   js.executeScript("arguments[0].scrollIntoView();",link);
 	   
 	   String title1=driver.getTitle();
 	   
 	   link.click();
 	   
 	   Thread.sleep(2000);
 	   
 	   Set<String> winIds=driver.getWindowHandles();
 	   
 	   
 	   Iterator<String> it=winIds.iterator();
 	   
 	   while(it.hasNext())
 	   {
 		   driver.switchTo().window(it.next());
 		   
 		   String title2=driver.getTitle();
 		   String expheading="Peace of mind is just a few clicks away!";
 		   if(!title1.equals(title2))
 		   {
 			   String actheading=driver.findElement(By.xpath("//h3[contains(text(),'Peace of mind is just a few clicks away!')]")).getText();
 			   if(expheading.equals(actheading))
 			   {
 				   System.out.println("switched to second window");
 				   Thread.sleep(3000);
 			   }
 		   }
 		   
 		 
 	  }
 	      driver.switchTo().window(parentwindow);
	   
		  String title3=driver.getTitle();
		  
		  Assert.assertEquals(title1, title3);
		  
		  System.out.println("Switched to parent window");
 	   
 	   
    }
}
