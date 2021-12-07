import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pvrslider 
{
	@Test
    public void links()
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.get("https://www.amazon.in/");
    	
    	List<WebElement> block=driver.findElements(By.xpath("//div[@id='anonCarousel1']/ol[@class='a-carousel']/li"));
    
    	System.out.println(block.size()+" "+ "links are present on the webpage");
    	
    	for (WebElement x : block) 
    	{
    		try 
    		{
    		System.out.println(x.findElement(By.tagName("link")));
    		
			}
    		catch (Exception e) 
    		{
				System.out.println(e);
			}
    		
		   	
		}
    	System.out.print("");
    }
}
