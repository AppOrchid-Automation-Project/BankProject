import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames 
{
	@Test
    public void frames() throws InterruptedException
    {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
  	   WebDriver driver=new ChromeDriver();
  	   driver.get("https://www.angelfire.com/super/badwebs/");
  	   driver.manage().window().maximize();
  	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	   Thread.sleep(2000);
  	   
  	   List<WebElement> frames= driver.findElements(By.tagName("frames"));
  	   System.out.println(frames.size());
  	   
  	   
  	  
  	  
    }
}
