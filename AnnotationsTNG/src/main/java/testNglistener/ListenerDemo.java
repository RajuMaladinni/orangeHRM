package testNglistener;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ListenerDemo {
	
	@Test
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
	assertEquals(driver.getTitle(),"OrangeHRM");		
	}
	
	@Test(priority = 1)
	public void TestFail() {
		System.out.println("Fail test case");
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public void TEstSkipped() {
		System.out.println("skipped test case");
		throw new SkipException("skop expection");
	}
}
