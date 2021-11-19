package com.bankproject.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.bankproject.Utilities.Readconfig;
import com.bankproject.Utilities.XLSXUtils;

public class Baseclass 
{
	Readconfig readconfig=new Readconfig();
	
	 public static Logger logger;
     public static WebDriver driver;
     public String userId=readconfig.getUsername();
     public String password=readconfig.getPassword();
     public String url=readconfig.getbaseURL();
    
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser)
    {
    	logger=Logger.getLogger("Bank project logs");
    	PropertyConfigurator.configure("Log4j.properties");
    	//DOMConfigurator.configure("Log4j.xml");//This is for running with log4j.xml file
    	if(browser.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
        	driver=new ChromeDriver();
        	logger.info("Testcase is executing on chrome browser");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if (browser.equals("firefox")) 
    	{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
			logger.info("Testcase is executing on firefox browser");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	else if (browser.equals("edge")) 
    	{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
			driver=new EdgeDriver();
			logger.info("Testcase is executing on edge browser");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	
    	driver.get(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Url is entered");
    }
    
    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }
    
    public void takeScreenshot(WebDriver driver,String tname) throws IOException
    {
       TakesScreenshot ts =(TakesScreenshot) driver;	
       File source=ts.getScreenshotAs(OutputType.FILE);
       File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
       FileUtils.copyFile(source, target);
       logger.info("Screenshot is taken");
       
    }
    @DataProvider(name="Logindata")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/bankproject/testData/Bankproject data.xlsx";
		int rowcount=XLSXUtils.getRowCount(path, "Login");
		int colcount=XLSXUtils.getCellCount(path, "Login", 1);
		String logindata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLSXUtils.getCellData(path, "Login", i, j);//this is because in excel we have header from in oth row and in array it starts from 0 so i-1
			}
		}
		return logindata;
	}
	
}






























