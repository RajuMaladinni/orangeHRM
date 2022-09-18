package crossbrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {

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

	@Test
	@Parameters("url")
	public void VerifyTitle(String url) throws Exception {
		Thread.sleep(2000);
		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority = 1)
	@Parameters({ "username", "password" })

	public void Loginpage(String username, String password) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void ClickOnEmployee() {
		driver.findElement(By.xpath("//*[contains(text(),'Employee List')]")).click();
	}

	@Test(priority=3)
	public void VerifyMyInfo() {
		WebElement element = driver.findElement(By.xpath("//span[text()='My Info']"));
		element.click();
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		System.out.println(element.getTagName());
		System.out.println(element.getTagName().isBlank());

	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
