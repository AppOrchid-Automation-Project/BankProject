import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class Fluentwait 
{
	@Test
	   public void fluentwait() throws InterruptedException
	   {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		.withTimeout(50, TimeUnit.SECONDS)
		.pollingEvery(2, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
		
		fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='under 599']"))).click();
	   }
}
