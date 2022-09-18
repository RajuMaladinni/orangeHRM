package TestNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertequal {

	

	@Test
	public void TestGoogle() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("HYR Tutorial" + Keys.ENTER);
		Thread.sleep(2000);

		SoftAssert as = new SoftAssert();
		// title assertion
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String expectedtitle = "Log in to Facebook";
		as.assertEquals(actualtitle, expectedtitle, "title is matching");

		// url assertion
		String actualurl = driver.getCurrentUrl();
		System.out.println(actualurl);
		String expectedurl = "https://www.facebook.com/login/";
		as.assertEquals(actualurl, expectedurl, "title is missmatching");
	
		//text assertion
		String actualtext = driver.findElement(By.name("email")).getAttribute("valve");
		
	}

}
