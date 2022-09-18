package TestOrangeHRM;
import java.io.File;
import java.io.IOException;

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

import POM.HomePage;
import POM.LoginPage;
import utility_package.Openchrome;
import utility_package.ScreenShot;



public class VrifyTest  {
	ExtentTest logger;
	ExtentReports	report;
	 WebDriver driver;
	
	@BeforeClass
	public void setup() throws IOException {
		WebDriver driver=Openchrome.orangeHRM();
		this.driver=driver;

		report =new ExtentReports();
		File file= new File("./screenshot/report.html");
//		ExtentHtmlReporter hreport= new ExtentHtmlReporter(file);
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(file);
		report.attachReporter(sparkreport);
		logger = report.createTest("log");
		logger = report.createTest("homepg");
	}

	@Test
	public void log() throws InterruptedException, IOException {

		LoginPage logPg = new LoginPage(driver);
		Thread.sleep(2000);
		logPg.enterUsername();
		logPg.enterpassword();
		logPg.clickOnLoginButton();
	}

	@Test(priority = 1)
	public void homepg() throws InterruptedException, IOException {

		HomePage homePg=new HomePage(driver);
		Thread.sleep(2000);
		homePg.MyInfo();
//		Assert.assertTrue(false);
		Assert.fail();
	}

	@AfterMethod
	public void generatereort(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			String temp = ScreenShot.screenshots(driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		report.flush();
	}
	
	

	

	@AfterClass
	public void autogenerate() throws Exception {
		driver.quit();
//		Desktop.getDesktop().browse(new File("./screenshot/report.html").toURI());
	}
	
}


