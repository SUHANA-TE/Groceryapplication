package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	PageUtility page=new PageUtility();
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']") WebElement newbutton;
@FindBy(id="username") WebElement username;
@FindBy(id="password") WebElement password;
@FindBy(id="user_type") WebElement usertype;//dropdown
@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement save;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary' and @onclick='click_button(2)']") WebElement search;
@FindBy(id="un") WebElement newusername;
@FindBy(id="ut") WebElement newusertype;
@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Search']") WebElement finalsearch;
@FindBy(xpath="//a[@class='btn btn-rounded btn-warning' and@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement reset;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newuseralert;
@FindBy(xpath="//td[text()='Suhana']") WebElement suhana;//for assertion true
@FindBy(xpath="//section[@class='content']") WebElement userslist;

public AdminUsersPage clickOnNewButton()
{
	newbutton.click();
	return this;
}
public AdminUsersPage enterUserNameOnUserNameField(String usernamevalue) {
	username.sendKeys(usernamevalue);
	return this;
	}
	public AdminUsersPage enterPasswordOnPasswordField(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
}
	public AdminUsersPage selectUserTypeFromDropDown()
	{
		page.selectDragDropWithVisibleText(usertype, "Staff");
		return this;
	}
	public AdminUsersPage clickOnSaveButton()
	{
		save.click();
		return this;
	}
	public AdminUsersPage clickOnSearchButton()
	{
		search.click();
		return this;
	}
	public AdminUsersPage enterNewUserNameOnUserNameField(String newusernamevalue) {
		newusername.sendKeys(newusernamevalue);
		return this;
		}
		
		public AdminUsersPage selectNewUserTypeFromDropDown()
		{
			page.selectDragDropWithVisibleText(newusertype, "Staff");
			return this;
		}
		public AdminUsersPage clickOnFinalSearchButton()
		{
			finalsearch.click();
			return this;
		}
		public AdminUsersPage clickOnResetButton()
		{
			reset.click();
			return this;
		}
		public boolean userAddedAlertIsDisplayed()
		{
			return newuseralert.isDisplayed();
		}
		public boolean addedUserIsDisplayed()//assertion
		{
			return suhana.isDisplayed();
		}
		public boolean usersListIsDisplayed()
		{
			return userslist.isDisplayed();
		}
}