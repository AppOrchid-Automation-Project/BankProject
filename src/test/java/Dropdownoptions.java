import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dropdownoptions 
{
	@Test
    public void dropdown() throws Exception
    {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
 	   WebDriver driver=new ChromeDriver();
 	   driver.get("https://www.amazon.in/");
 	   driver.manage().window().maximize();
 	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	   
 	   WebElement dd=driver.findElement(By.id("searchDropdownBox"));
 	   List<WebElement> options=driver.findElements(By.tagName("option"));
 	   
 	   System.out.println(options.size());
 	   int count=0;
 	   for(int i=0;i<options.size();i++)
 	   {
 		   System.out.println(options.get(i).getText());
 		   count++;
 	   }
 	   System.out.println("Total options in dropdown are"+" "+count);
    }
}
