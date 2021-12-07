import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot 
{
	@Test
    public void dropdown() throws Exception
    {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
 	   WebDriver driver=new ChromeDriver();
 	   driver.get("https://www.bbc.com");
 	   driver.manage().window().maximize();
 	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	   Thread.sleep(2000);
 	   
 	   File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	   FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"/Screenshots/test1.jpg"));
 	   Thread.sleep(1000);
 	   System.out.println("Screenshot taken successfully");
 	   driver.close();
 	   
    }
}
