import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alllinksofpage 
{
	@Test
    public void links()
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.get("http://www.bing.com");
    	
    	List<WebElement> list=driver.findElements(By.tagName("a"));
    	System.out.println(list.size()+" "+ "links are present on the webpage");
    	
    	for (WebElement x : list) 
    	{
		     //System.out.println(x.getText());	
    		try {
    			if(x.getText().equals("Videos"))
   		     {
   		    	 x.click();
   		    	System.out.println(driver.getCurrentUrl()+" "+"This is the current url on the page");
   		    	 break;
   		     }
			} catch (NoSuchElementException e) 
    		{
			    System.out.println(e);	
			}
		     
		}
    	System.out.print("");
    	driver.close();
    }
}
