package com.bankproject.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.CustomAttribute;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankproject.testCases.Baseclass;

public class Reporting extends Baseclass implements ITestListener
{
	ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	Logger logger;
    public void onStart(ITestContext testcontext)
    {
    	String timestamp=new SimpleDateFormat("mm.dd.yyyy.hh.mm.ss").format(new Date());
    	String reportName="Extent-Report-"+timestamp+".html";
    	
    	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
    	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
    	
    	extentReport=new ExtentReports();
    	
    	extentReport.attachReporter(htmlReporter);
    	
    	extentReport.setSystemInfo("hostname", testcontext.getHost());
    	
    	extentReport.setSystemInfo("Environment", "QA");
    	
    	extentReport.setSystemInfo("User", "Malli");
    	
    	htmlReporter.config().setDocumentTitle("Sample Bank Project");
    	
    	htmlReporter.config().setReportName("Functional Automation");
    	
    	htmlReporter.config().setTheme(Theme.DARK);
    	
    }
    
    public void onTestSuccess(ITestResult tr)
    {
    	test=extentReport.createTest(tr.getName());
    	test.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+"testcase Passed", ExtentColor.GREEN));
    }
    
    public void onTestFailure(ITestResult tr)
	{
		test=extentReport.createTest(tr.getName()); // create new entry in th report
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		test=extentReport.createTest(tr.getName()); // create new entry in th report
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extentReport.flush();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
