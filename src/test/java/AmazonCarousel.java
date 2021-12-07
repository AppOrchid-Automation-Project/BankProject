import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonCarousel 
{
	WebDriver driver;
	WebDriverWait wait;
	   @Test
       public void slideTest()
       {
    	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
    	   driver=new ChromeDriver();
    	   driver.get("https://www.amazon.in/");
    	   driver.manage().window().maximize();
    	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	   
    	   List<WebElement> list=driver.findElements(By.xpath("//div[@id='anonCarousel1']//ol/li"));
    	   
    	   System.out.println(list.size());
    	   
    	   for(int i=1;i<=list.size();i++)
    	   {
    		   String text=driver.findElement(By.xpath("//img[@alt='Amazon Specials']")).getText();
    		   System.out.println(text);
    		   driver.findElement(By.xpath("//span[contains(text(),'Next slide')]")).click();
    	   }
       }
	   
	  
}
