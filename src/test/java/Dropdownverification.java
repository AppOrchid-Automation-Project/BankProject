import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dropdownverification 
{
	@Test
    public void dropdown() throws Exception
    {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
 	   WebDriver driver=new ChromeDriver();
 	   driver.get("https://www.goair.in");
 	   driver.manage().window().maximize();
 	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	   Thread.sleep(2000);
 	   WebElement fromdd=driver.findElement(By.id(""));
 	   
    }
}
