package com.training.tests;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest{

static WebDriver driver;
String url;
LoginPage login;
static HomePage home;
static CommonUtilities common = new CommonUtilities();

@BeforeTest
public void beforeMethod() throws IOException {
	url = common.getproperty("url");
	driver= getDriver("chrome");
	driver.get(url);
	login = new LoginPage(driver);
	 home = new HomePage(driver);
	 String Username = common.getproperty("login.valid.userid");
		BaseTest.enterText(login.Username(), Username,"usenameEle");
		String Password = common.getproperty("login.valid.password");
		BaseTest.enterText(login.enterIntoPassword(), Password,"passwordEle");
		BaseTest.selectCheckBox(login.checkRememberme(), "RememberMe");
		BaseTest.clickonme(login.LoginButton(), "Login");
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		System.out.println(expectedTitle);
		
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");

	}

/****************************************************************************/
	@Test(description = "TC_5_Selectusermenudropdown")
	public void TC_5_Selectusermenudropdown() throws Exception {
		
		BaseTest.clickonme(home.Username(), "Usermenu");
		String dropdownverify=driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
		System.out.println(dropdownverify);
		
	}

/************************************************************************/
	@Test(description = "TC_6_SelectMyProfile")
	public void TC_6_SelectMyProfile() throws Exception {
		
		BaseTest.clickonme(home.Username(), "Usermenu");
		WebElement profileTab = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		waitforVisibilty(100, profileTab);
		Thread.sleep(5000);
		BaseTest.clickonme(profileTab," My Profile");
		
	   }
 /************************************************************************/    
	
	@Test(description = "TC_6_editmyProfilebutton")
	 public static void  TC_6_editmyProfilebutton() throws InterruptedException {
		  WebElement editprofilebutton = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")); 
		  BaseTest.clickonme(editprofilebutton, "editprofilebutton"); 
		  Thread.sleep(8000);
		        	       	  
		 }
	
	
	/***************************************************************************/
	
@Test(description = "TC_6_editprofilewindow")
public static void TC_6_editprofileWindow() throws InterruptedException, IOException {
 
WebElement usermenu = home.Username();
 BaseTest.clickonme(home.Username(), "Usermenu");
 
 
WebElement profileTab = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
waitforVisibilty(100, profileTab);
Thread.sleep(5000);
BaseTest.clickonme(profileTab,"My Profile"); 
		
WebElement editprofilebutton = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")); 
 BaseTest.clickonme(editprofilebutton, "editprofilebutton"); 
Thread.sleep(8000);
		        	       	  
WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
System.out.println("I am inside frame");
driver.switchTo().frame(frame1);
 
Thread.sleep(5000); 
WebElement aboutTab = driver.findElement(By.cssSelector("#aboutTab"));
waitforVisibilty(100, aboutTab);
BaseTest.clickonme(aboutTab, "abouttab");

WebElement newLastname = driver.findElement(By.xpath("//input[@id='lastName']"));
waitforVisibilty(100, newLastname);
newLastname.clear();

String lastName = common.getproperty("lastname");
BaseTest.enterText(newLastname,lastName, "lastnameEle");

System.out.println("LastName is Entered");

    	
WebElement savebutton = driver.findElement(By.xpath("//input[@value='Save All']"));
Thread.sleep(4000);
//BaseTest.clickonme(savebutton,"savebuttonEle");

}


	@AfterMethod
	public void teardown() throws IOException {
				driver.close();
	}
}

  
	
