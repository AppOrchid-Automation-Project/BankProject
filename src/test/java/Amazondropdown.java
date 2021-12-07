import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Amazondropdown 
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
 	   dd.click();
 	   Select select=new Select(dd);
 	   select.selectByVisibleText("Books");
 	   
 	   Thread.sleep(1000);
 	   
 	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
 	   
 	   Actions action=new Actions(driver);
 	   action.sendKeys(Keys.ENTER).build().perform();
 	   
 	   Thread.sleep(2000);
 	   
 	   JavascriptExecutor js=(JavascriptExecutor)driver;
 	   WebElement link=driver.findElement(By.partialLinkText("Harry Potter and the Chamber of Secrets"));
 	   js.executeScript("arguments[0].scrollIntoView();", link);
 	   
 	  String title= link.getText();
 	  if(title.contains("Harry Potter"))
 	  {
 		  System.out.println("Searched for the right book and records are displaying on UI");
 	  }
 	   
    }
}
