package com.training.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.utilities.CommonUtilities;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//input[@id='username']")
    WebElement Uname;
	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;
	@FindBy(xpath = "//div[@id='error']")
	WebElement errormessage;
	@FindBy(xpath = "//*[@id='Login']")
	WebElement login;
	@FindBy(xpath = "//*[@id='rememberUn']")
	WebElement remember;
	@FindBy(xpath = "//*[@id='forgot_password_link']")
	WebElement Fpwd;
	@FindBy(xpath = ".//*[@id='un']")
	WebElement Fname;
	@FindBy(xpath = "//*[@id='continue']")
	WebElement Conti;
	@FindBy(xpath="//div[@id='error']")
	WebElement actualText;
	
	@FindBy(xpath="//*[@id='userNavButton']")
	WebElement userMenu;
	
	@FindBy(xpath="//a[text() = 'Logout']")
	WebElement logout;
	
	@FindBy(xpath="//span[@id='idcard-identity']")
	WebElement idLoc;
	
	@FindBy(xpath="//h1[@id='header']")
	WebElement header;
	
	 //WebElement headerLine = driver.findElement(By.xpath("//h1[@id='header']"));
	//WebElement idLoc = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
	//WebElement logoutButton =  driver.findElement(By.xpath("//a[text() = 'Logout']"));
	//selectDropdown(UserMenu, "UserMenu");
	//WebElement UserMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
	
	public WebElement Headerelement() {
		return header;
	}
	
	public WebElement Logout() {
		return logout;
	}
	public WebElement userMenuTab() {
		return userMenu;
	}
	public WebElement idLocElement() {
		return idLoc;
	}

	public WebElement errormessage() {
		return actualText;
	}
	public WebElement Username() {
		return Uname;
	}

	public WebElement enterIntoPassword() {
		return pwd;
	}

	public WebElement checkRememberme() {
		return remember;
	}

	public WebElement LoginButton() {
		return login;
	}
	public WebElement forgotPassword() {
		return Fpwd;
	}
	public WebElement fullName() {
		return Fname;
	}
	public WebElement Continue() {
		return Conti;
	}

	
	
	
	
	public void logintapplication(String strusername, String strpassword) {
		Uname.sendKeys(strusername);
		pwd.sendKeys(strpassword);
		login.click();
	}
	
	    
	
/*	public void enterUsername() {
	  waitForElement(20,Uname);
	  Uname.sendKeys("jan23.jyothi@ta.com");
	  System.out.println(" I am in enter user name method");
	}
*/
		
 }
	
	
	
	
	

