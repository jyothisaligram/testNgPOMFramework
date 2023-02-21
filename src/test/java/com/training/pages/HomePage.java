package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//*[@id='userNavButton']")
	WebElement UserMenu;
	
	
	public WebElement Username() {
		return UserMenu;
	}

}
