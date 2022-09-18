package TestNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void Launchbrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;
		}
	}

//	@AfterTest
//	public void Teardown() {
//		driver.quit();
//	}

	
	@Test
	@Parameters("url")
	public void OpeningUrl(String url) throws Exception {
		Thread.sleep(2000);
		driver.get(url);
		
	}
	@Parameters({"id", "password"})
	@Test(priority=2)
	public void EnterloginDetails(String id,String password) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@placeholder=\"Username\"]")).sendKeys("id");
		driver.findElement(By.xpath("//*[@placeholder=\"Password\"]")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		
	}

	@Test(priority=3)
	public void NaviagateToMyInfo() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'My Info')]")).click();
	}

	

	@Test(priority=4)
	public void VerifyEmplyeeDetails() throws Exception {
		Thread.sleep(2000);
		boolean emplyee = driver.findElement(By.xpath("//*[@class=\"orangehrm-background-container\"]")).isDisplayed();
		System.out.println(emplyee);
	}
}
