package com.bankproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.bankproject.testCases.Baseclass;

public class Addnewcustomer extends Baseclass
{
	public static WebDriver ldriver;
    public Addnewcustomer(WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(ldriver, this);
    }
    
    //Objects for Add new customer page
    @FindBy(xpath="//a[contains(text(),'New Customer')]")
    WebElement newCustomerText;
    
    @FindBy(xpath="//p[contains(text(),'Add New Customer')]")
    WebElement addNewCustomerHeading;
    
  //@FindBy(xpath="//td[text()='Customer Name']/following::input[1]")
    //WebElement customerName;
    
    //@cachelookup annotation is used to locate an element and keepit and not to search every time 
    @FindBy(how = How.XPATH, using="//td[text()='Customer Name']/following::input[1]")
    @CacheLookup
    WebElement customerName;
    
    //male
    @FindBy(xpath="//input[@name='rad1'][1]")
    WebElement genderm;
    
    //female
    @FindBy(xpath="//input[@name='rad1'][2]")
    WebElement genderf;
    
    @FindBy(xpath="//input[@name='dob']")
    WebElement dateOfBirth;
    
    @FindBy(xpath="//textarea[@name='addr']")
    WebElement address;
    
    @FindBy(xpath="//input[@name='city']")
    WebElement city;
    
    @FindBy(xpath="//input[@name='state']")
    WebElement state;
    
    @FindBy(xpath="//input[@name='pinno']")
    WebElement pin;
    
    @FindBy(xpath="//input[@name='telephoneno']")
    WebElement mobileNumber;
    
    @FindBy(xpath="//input[@name='emailid']")
    WebElement email;
    
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@name='sub']")
    WebElement submit;
    
    @FindBy(xpath="//p[text()='Customer Registered Successfully!!!']")
    WebElement successmsg;
//======================================================================================================
    //Action methods
    public void newCustomerText()
    {
    	newCustomerText.click();
    	logger.info("clicked on New Customer");
    }
    
    public String addNewCustomerHeading()
    {
    	String text=addNewCustomerHeading.getText();
		return text;
    }
    
    public void customerName(String name)
    {
    	customerName.sendKeys(name);
    	logger.info("Entered customer name");
    }
    
    public void gender(String gendr)
    {
    	if(gendr.equals("Male"))
    	genderm.click();
    	else
    	genderf.click();
    	logger.info("Selected gender");
    }
    
    public void dob(String dd,String mm,String yyyy)
    {
    	dateOfBirth.sendKeys(dd);
    	dateOfBirth.sendKeys(mm);
    	dateOfBirth.sendKeys(yyyy);
    	logger.info("Entered dob");
    }
    
    public void address(String addr)
    {
       address.sendKeys(addr);
       logger.info("Entered address");
    }
    
    public void city(String city1)
    {
       city.sendKeys(city1);
       logger.info("Entered city");
    }
    
    public void state(String state1)
    {
       state.sendKeys(state1);
       logger.info("Entered state");
    }
    
    public void pin(int pincode)
    {
       pin.sendKeys(String.valueOf(pincode));
       logger.info("Entered pin");
    }
    
    public void mobileNumber(String mobile)
    {
    	mobileNumber.sendKeys(mobile);
    	logger.info("Entered mobile number");
    }
    
    public void email(String emailaddr)
    {
       email.sendKeys(emailaddr);
       logger.info("Entered gmail");
    }
    
    public void password(String password1)
    {
       password.sendKeys(password1);
       logger.info("Entered password");
    }
    
    public void submit()
    {
       submit.click();
       logger.info("Clicked on submit");
    }
    
    public String successmsg()
    {
    	String msg=successmsg.getText();
    	return msg;
    }
    
}
