package TestNgScreenshot;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(testName ="testgoogle")
public class testClass extends BaseTest {
	public void testgoogle() {
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("HYR turotial",Keys.ENTER);
		String expectedTitle="HYR turotial - Google Searchss";
		String actualTitle=driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"title is matching");
	}
	@Test(priority = 1,testName="testOrangerHRM")
	public void testOrangerHRM() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Andmin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).submit();
	
		
	}

	
}
