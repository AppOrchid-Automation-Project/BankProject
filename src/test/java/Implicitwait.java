import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Implicitwait 
{
	@Test
   public void implicitwait() throws InterruptedException
   {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
	   	   WebDriver driver=new ChromeDriver();
	   	   driver.get("https://www.amazon.in/");
	   	   driver.manage().window().maximize();
	   	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   	   Thread.sleep(2000);
	   	   
	   	   driver.findElement(By.xpath("//img[@alt='Nestle']")).click();
	   	   
	   	   Thread.sleep(10000);
	   	   
   }
}
