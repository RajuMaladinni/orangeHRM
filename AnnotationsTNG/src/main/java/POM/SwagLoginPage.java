package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@placeholder=\"Username\"]")private WebElement userName;
	@FindBy(xpath="//*[@placeholder=\"Password\"]")private WebElement lastName;
	@FindBy(xpath="//*[@name=\"login-button\"]")private WebElement clickOnButton;
	
	public SwagLoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String Uname) {
		userName.sendKeys(Uname);
	}
	
	public void lastName(String Lname) {
		lastName.sendKeys(Lname);
	}
	
	public void ClickOnLoginButton() {
		clickOnButton.click();
	}
	

}
