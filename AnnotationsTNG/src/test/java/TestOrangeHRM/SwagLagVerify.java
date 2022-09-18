package TestOrangeHRM;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM.SwagLoginPage;
import utility_package.EReader;
import utility_package.Openchrome;
import utility_package.ScreenShot;

public class SwagLagVerify extends ScreenShot {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeClass
	public void Setup() {
		WebDriver driver=Openchrome.swagLab();
		this.driver=driver;
		
		
		report = new ExtentReports();
		File file = new File("./screenshot/swag.html");
		ExtentSparkReporter	sp=new ExtentSparkReporter(file);
		report.attachReporter(sp);
		logger = report.createTest("Login","login details");
	
	}
	
	@Test
	public void Login() throws EncryptedDocumentException, IOException, InterruptedException {
		
		SwagLoginPage sg=new SwagLoginPage(driver);
		
		sg.enterUsername(EReader.LoginCred(1, 0));
		
		sg.lastName(EReader.LoginCred(1, 1));
		
		sg.ClickOnLoginButton();	
		Assert.fail("loging fail");
	}
	
	@AfterMethod
	public void generatereort(ITestResult result) throws IOException {
	
		if (result.getStatus()==ITestResult.FAILURE ){
			String temp = ScreenShot.screenshots(driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//			logger.pass(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		report.flush();
	}
	
	@AfterClass
	public void Close() {
		driver.close();
	}

}
