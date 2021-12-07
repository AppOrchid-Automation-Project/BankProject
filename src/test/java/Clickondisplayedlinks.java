import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Clickondisplayedlinks 
{
	@Test
    public void displayedLinks() throws InterruptedException
    {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.get("https://www.google.com");
    	
        WebElement ele=driver.findElement(By.linkText("About"));
        String act=ele.getAttribute("href");
        System.out.println(act);
        ele.click();
        String exp=driver.getCurrentUrl();
        driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(act, exp);
        driver.close();
    
    }
}
