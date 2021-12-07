import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Explicitwait 
{
	@Test
	   public void implicitwait() throws InterruptedException
	   {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		   	   
		  WebDriverWait ww=new WebDriverWait(driver, 100);
		  
		//  driver.findElement(By.xpath("//img[@alt='winterwear store']")).click();
		  
		  ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='under 599']"))).click();
		  
		  System.out.println("waiting");
		   	   
		  Thread.sleep(10000);
		   	   
	   }
}
