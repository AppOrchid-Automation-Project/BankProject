package com.bankproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
	public static WebDriver ldriver;
       public Loginpage(WebDriver rdriver)
       {
    	   ldriver=rdriver;
    	   PageFactory.initElements(ldriver, this);
       }
       
 @FindBy(name="uid")
 public WebElement username;
 
 @FindBy(name="password")
 public WebElement password;
 
 @FindBy(xpath="//input[@value='LOGIN']")
 public WebElement loginButton;
 
 @FindBy(xpath="//a[contains(text(),'Log out')]")
public WebElement logoutbutton; 
 public void userName(String uname)
 {
	 username.sendKeys(uname);
 }
 
 public void password(String pwd)
 {
	 password.sendKeys(pwd);
 }
 
 public void loginButton()
 {
	 loginButton.click();
 }
 
 public void logout()
 {
	 logoutbutton.click();
 }
 
}

