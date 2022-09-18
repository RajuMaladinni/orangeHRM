package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
		
	}
	
	@FindBy(xpath="//*[(text()='My Info')]")private WebElement Myinfo;
	
	@FindBy(xpath="//*[contains (@class,'orangehrm-horizontal-padding')]/h6")WebElement PersonalDetails ;
	
	@FindBy(xpath="//*[contains (text(),'Employee Full Name')]")WebElement EmployeeFullName;
//	
//	@FindBy(xpath="//*[@name=\"firstName\"]")
//	WebElement firstName;
//	
//	@FindBy(xpath="//*[@name='middleName']")
//	WebElement middletName;
//	
//	@FindBy(xpath="//*[@name='lastName']")
//	WebElement lastName;
//	
//	@FindBy(xpath="//*[contains(text(),'Nickname')]")
//	WebElement nickName;
//	
//	@FindBy(xpath="//*[contains(text(), 'Employee Id')]")
//	WebElement EmployeeID;
//	
//	@FindBy(xpath="//*[contains(text(), 'Employee Id')]/parent::div/following-sibling::div")
//	WebElement EmployeeIdBox;
//	
//	@FindBy(xpath="//*[contains(text(), 'Other Id')]")
//	WebElement OtherID;
//	
//	@FindBy(xpath="//*[contains(text(), 'Other Id')]/parent::div/following-sibling::div")
//	WebElement OtherIdBox;
//	
//	@FindBy(xpath="//*[contains(text(), 'Driver')]")
//	WebElement DriversLiscence;
//	
//	@FindBy(xpath="//*[contains(text(), 'Driver')]/parent::div/following-sibling::div/input")
//	WebElement DriversLiscenceBox;
//	
//	@FindBy(xpath="//*[contains(text(), 'License Expiry Date')]")
//	WebElement LicenseExpiryDate;
//	
//	@FindBy(xpath="//*[contains(text(), 'License Expiry Date')]/parent::div/following-sibling::div")
//	WebElement LicenseExpiryDateBox;
//	
//	@FindBy(xpath="//*[contains(text(), 'SSN Number')]")
//	WebElement SSNnumber;
	
	
	
	public void MyInfo() {
		
		Myinfo.click();
	}
	
	public void PDetails() {
		
		PersonalDetails.isDisplayed();
		System.out.println(PersonalDetails.getText());
	}
	
	public void EmployeeFName() {
		
		EmployeeFullName.isDisplayed();
		System.out.println(EmployeeFullName.getText());
	}
	
}
