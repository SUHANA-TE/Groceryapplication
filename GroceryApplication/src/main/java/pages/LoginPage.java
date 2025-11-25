package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	WaitUtility wait=new WaitUtility();
	@FindBy(xpath ="//input[@name='username']") WebElement username;
	@FindBy(xpath ="//input[@name='password']") WebElement password;
	@FindBy(xpath ="//button[@class='btn btn-dark btn-block']") WebElement signin; 
	@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashboard;//find element for assertion
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement title;//to find 7rmrt supermarket
	public LoginPage enterUserNameOnUserNameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
		}
		public LoginPage enterPasswordOnPasswordField(String passwordvalue)
		{
			password.sendKeys(passwordvalue);
			return this;
		}
		public HomePage clickOnSignInButton()
		{
			wait.waitUntilElementToBeClickable(driver, signin);
			signin.click();
			return new HomePage(driver);
		}
		public boolean dashboardTilePresent()//have to return true or false ie,boolean instead of void
		{
			return dashboard.isDisplayed();
		}
		public String GetTitleOfLoginPage()//method for element 7rmart supermarket
		{
			return title.getText();
		}

}
