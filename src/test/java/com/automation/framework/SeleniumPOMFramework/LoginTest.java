package com.automation.framework.SeleniumPOMFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

	LoginPage login;

	CreateBatch testing;

	@Test(description = "Verify valid login")
	public void verifyLogin() {
		test.info("Navigating to Login Page");
		login = new LoginPage(driver);
		login.LoginToApplication("nikhil.rayate@aressindia.net", "Nikhil@12");
		
		System.out.println("Test the changes");

		test.info("Verifying successful login");
		test.pass("✅ Login successful");
	}

	@Test(dependsOnMethods = "verifyLogin")
	public void CreatingBatch() {

		testing = new CreateBatch(driver);

		testing.batchAction();
	}

	@AfterMethod
	public void tearDownTest() {
		test.info("Test completed");
	}

}
