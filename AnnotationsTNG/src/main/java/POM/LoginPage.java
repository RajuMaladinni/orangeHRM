package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

		
	}
	
	
	@FindBy(name="username")
	private WebElement uName;
	
	@FindBy(name="password")
	private WebElement pWord;
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	private WebElement clickOnLogin;
	
	

	public void enterUsername() throws InterruptedException {
		Thread.sleep(2000);
		uName.sendKeys("Admin");
			
	}

	public void enterpassword() throws InterruptedException {
		Thread.sleep(2000);
		pWord.sendKeys("admin123");
		
	}
	

	public void clickOnLoginButton() {
		clickOnLogin.click();	
	}

}
