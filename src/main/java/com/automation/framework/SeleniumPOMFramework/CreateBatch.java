package com.automation.framework.SeleniumPOMFramework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBatch {

	WebDriver driver;

	public CreateBatch(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Enable Later']")
	WebElement mfa;

	@FindBy(xpath = "//a[@href='admin/barcode-batches']")
	WebElement batches;

	public void batchAction() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(mfa)).click();

		wait.until(ExpectedConditions.elementToBeClickable(batches)).click();
	}

}
