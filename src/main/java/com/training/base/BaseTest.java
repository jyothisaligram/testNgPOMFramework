package com.training.base;

import java.io.File;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 static WebDriver driver=null;
	// private static Logger logger = LogManager.getLogger(LoginTest.class.getName());	
	
	public WebDriver getDriver(String browser) {
		
		switch(browser) {
		case "firefox":		WebDriverManager.firefoxdriver().setup();
							driver=new FirefoxDriver();
							driver.manage().window().maximize();
							break;
							
		case "chrome":  
			
			//ChromeOptions option=new ChromeOptions();
			//option.addArguments("--headless");
			//option.addArguments("--incognito");
			//option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					
			            WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver();
						driver.manage().window().maximize();
						break;
						
		default: System.out.println("not entered proper browsername");
		}
			
		return driver;
	}

	public static void takescreenshot(WebDriver driver) {
		
		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
		  File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		  
		  	Date currentDate = new Date();
		  	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		  	String fileSeperator = System.getProperty("file.separator");
		    String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "Screenshots";
		    String reportFileName = "ScreenShot"+timestamp+".png";
		    String filePath =  reportFilepath +fileSeperator+ reportFileName;
		    File DestFile = new File(filePath);
		    try {
		    FileUtils.copyFile(srcFile, DestFile);
		    }catch(IOException e) {
		    	e.printStackTrace();
		    }
		
	}
	/* name of the method:   entertext
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  obj-->object
	 *                      textval--->to be entered 
	 *                      objName--->object name
	  */

	
	/* name of the method:   entertext
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  element -->object
	 *                      text--->to be entered 
	 *                      name--->object name
	 */
	
	public static void enterText(WebElement element,String text,String name){
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println( name+ "web element is not displayed");
		}
		try {
			driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* name of the method:   clickonme--->Button
	 * BriefDescription  :   clicking a button
	 * Arguments         :  element-->object, name --->object name
	 */
	
	public static void clickonme(WebElement element, String name) {
		if(element.isDisplayed()) {
			element.click();
		}
		else
		{
			System.out.println("Unable to click because web element is not displayed"+name);
		}
	}

	
		public static void validateErrormsg(String actualmsg, String errormsg) {
			
			if(actualmsg.equals(errormsg))
			{
				System.out.println("TestCase is passed");
			//	logger.log(LogStatus.PASS,  "TestCase is passed" );
			}else
		    {
			System.out.println("TestCase is failed");
			//logger.log(LogStatus.FAIL,  "TestCase is failed" );
		    }
		}
		
		
		/*
		 * Name of the method: selectCheckBox
		 * Brief Description: Select the checkbox
		 * Arguments: obj --> web object, objName--> name of the object*/
		
		public static void selectCheckBox(WebElement obj, String objName) {
			
			if(obj.isDisplayed()) {
				
				if(obj.isSelected()) {
					System.out.println("Pass: "+objName+" is already selected");
//					logger.log(LogStatus.INFO, objName + "is already selected");
				}else{
				obj.click();
				System.out.println("Pass: "+objName+" is selected");
//				logger.log(LogStatus.PASS, objName + "is selected");
			    }}
				else {
				System.out.println("Fail:"+objName+" is not present.Please chk application");	
//				logger.log(LogStatus.FAIL, objName+ " is not displayed ,please check the application");
			}	
		}
		
		public static void waitforVisibilty(int time, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,time);
		    wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		
		
		public static void selectDropdown(WebElement obj, String objName) {
			
			if(obj.isDisplayed()) {
				System.out.println("Pass: "+objName+" is  selected");
				obj.click();
			}else
			{
			
				System.out.println("Fail:"+objName+" is not present.Please chk application");	
		
		    }
		}
		
		
	
	}
	
	
	
	
	
	
	

