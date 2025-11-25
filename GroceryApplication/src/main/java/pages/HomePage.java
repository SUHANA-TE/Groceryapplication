package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath= "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logout;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreinfo;//admin users more info
	@FindBy(xpath="//a[@class='small-box-footer'and @href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement managenewsmoreinfo;
	@FindBy(xpath = "//button[@type='submit']") WebElement signinbutton;
	public HomePage clickOnAdmin()
	{
		admin.click();
		return this;
	}
	public LoginPage clickOnLogout()
	{
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUsersPage clickOnMoreInfoButton()
	{
		moreinfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageNewsPage clickOnManageNewsMoreInfo()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	public boolean signinButtonPresent()
	{
		return signinbutton.isDisplayed();
	}
}
