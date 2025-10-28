package com.automation.framework.SeleniumPOMFramework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		String reportPath = System.getProperty("user.dir") + "\\src\\Reports\\ExtentReport.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		System.out.println("Extent Report initialized");
	}

	@Parameters("browser")
	@BeforeClass
	public void setupBrowser(@Optional("chrome") String browser) {

		System.out.println("Launching browser: " + browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		driver.get("https://tims-staging.myhealthchecked.com/admin/");

		test = extent.createTest("Login Test");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

//	@BeforeMethod
//	public void setUpTest() {
//
//	}

//	@AfterClass
//	public void tearDownBrowser() {
//		if (driver != null) {
//			driver.quit();
//			System.out.println("🧹 Browser closed");
//		}
//	}

	@AfterSuite
	public void flushReport() {
		if (extent != null) {
			extent.flush();
			System.out.println("📄 Extent Report generated");
		}
	}
}
