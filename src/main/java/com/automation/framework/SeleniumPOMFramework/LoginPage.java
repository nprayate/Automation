package com.automation.framework.SeleniumPOMFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(id = "email")
	WebElement txtUsername;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "loginform")
	WebElement btnLogin;

//	    @FindBy(id = "logout")
//	    WebElement btnLogout;

	// Actions
	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	
	public void LoginToApplication(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}
