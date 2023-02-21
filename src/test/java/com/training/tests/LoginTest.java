package com.training.tests;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pages.*;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;



public class LoginTest extends BaseTest {

	 WebDriver driver;
	 String url,browser;
	 CommonUtilities common = new CommonUtilities();
	 LoginPage login;
	 HomePage home;
	
	@BeforeTest
	public void beforeMethod() throws IOException {
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		driver= getDriver(browser);
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println("The page title is: "+title);
		Assert.assertEquals(title, "Login | Salesforce");
		
	    login = new LoginPage(driver);
	  
		
	}
	
	/*********************************************************************/
	
	@Test(description = "Login Error Message - 1")
	public void LoginErrorMessage1() throws Exception {

		String Username = common.getproperty("login.valid.userid");
		
		
		 WebElement username =login.Username();
		 BaseTest.enterText(username, Username,"usernameEle");
		
		 BaseTest.clickonme(login.LoginButton(), "Login");
		 Thread.sleep(5000);
		String errormessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		
		if (errormessage.equals("Please enter your password.")) {
			System.out.println("Error message is been displayed");
			
		} else {
			System.out.println("Error message is not been be displayed");
			
		}

	}
	
/**********************************************************************/	
	
	@Test(description = "Login To SalesForce -2")
	public void LoginToSalesForce2() throws Exception {

		String Username = common.getproperty("login.valid.userid");
		BaseTest.enterText(login.Username(), Username,"UsernameEle");
		String Password = common.getproperty("login.valid.password");
		BaseTest.enterText(login.enterIntoPassword(), Password,"passwordEle");
		BaseTest.selectCheckBox(login.checkRememberme(), "RememberMe");
		BaseTest.clickonme(login.LoginButton(), "Login");
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");
	}
	
/****************************************************************************/	
	
	@Test(description = "Check RemeberMe - 3")
	public void Check_RemeberMe_3() throws Exception {
		String Username = common.getproperty("login.valid.userid");
		BaseTest.enterText(login.Username(), Username,"Usernamele");
		String Password = common.getproperty("login.valid.password");
		BaseTest.enterText(login.enterIntoPassword(), Password,"passwordEle");
		
		BaseTest.selectCheckBox(login.checkRememberme(), "RememberMe");
		
		BaseTest.clickonme(login.LoginButton(), "Login");
		
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");
		Thread.sleep(5000);
		
		waitforVisibilty(60, login.userMenuTab());
		BaseTest.selectDropdown(login.userMenuTab(), "userMenu");
		Thread.sleep(3000);
		BaseTest.clickonme(login.Logout(), "logout");
		
		//landing on salesforce login page
		Thread.sleep(5000);
		String actual = login.idLocElement().getText();
		String expected = common.getproperty("login.valid.userid");
		Thread.sleep(5000);
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Username is displayed");
			System.out.println("The script test for rememberme passed");
		}
		else {
			System.out.println("Username is not displayed");
			System.out.println("The script test for rememberme failed");
			
		}
	}
	
/**********************************************************************/
	
	@Test(description = "Forgot Password- 4A")
	public void Forgot_Password_4_A() throws Exception {
		String Username = common.getproperty("login.valid.userid");
		BaseTest.enterText(login.Username(), Username,"UsernameEle");
		
		BaseTest.clickonme(login.forgotPassword(), "ForgotPassword");
		
		String Fname = common.getproperty("login.valid.userid");
		BaseTest.enterText(login.fullName(), Fname,"FullnameEle");
		BaseTest.clickonme(login.Continue(), "Continue");
			
		String expectedHeader = "Check Your Email";
		
		String actualHeader = login.Headerelement().getText();
		Thread.sleep(5000);
		
		if(actualHeader.equalsIgnoreCase(expectedHeader)) {
			System.out.println("Test script for forgot your password PASSED");	
			}
			else {
				System.out.println("Test script for forgot your password Failed");
			}
			
			System.out.println("TC_4A switchToForgotPassword completed");  	   
	}
	
/**********************************************************************/	
	
	@Test(description = "Forgot Password- 4B")
	public void Forgot_Password_4_B() throws Exception {
		String Username = common.getproperty("login.valid.userid");
		BaseTest.enterText(login.Username(), Username,"UsenameEle");
		
		String Password = common.getproperty("login.invalid.password");
		
		BaseTest.enterText(login.enterIntoPassword(), Password,"PasswordEle");
		
		BaseTest.clickonme(login.LoginButton(), "Login");
		String ErrorText = common.getproperty("errormessage");
		Thread.sleep(5000);
		System.out.println(ErrorText);
		
		System.out.println(login.errormessage().getText());
		
		BaseTest.validateErrormsg(login.errormessage().getText(), ErrorText);
	}
	
/*******************************************************************************/
	
	@AfterMethod
	public void teardown() throws IOException {
	takescreenshot(driver);
	driver.close();

	}

	
	
	
}
