package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.RandomDataUtility;

public class AdminUsersTest extends Base{
	HomePage hp;
	AdminUsersPage ap;
	@Test(description="user is trying to add new user")
	public void verifyWhetherUserisAbleToAddNewUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnSignInButton();
		
		ap=hp.clickOnMoreInfoButton();
		
		
		RandomDataUtility rdu=new RandomDataUtility();//object creation for random data utility class
		String username=rdu.randomUserName();//calling random username method
		String password=rdu.randomPassword();

		ap.clickOnNewButton().enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectUserTypeFromDropDown().clickOnSaveButton();
		Boolean newuserisdisplayed=ap.userAddedAlertIsDisplayed();//for assert true
		Assert.assertTrue(newuserisdisplayed,Constant.NEWUSERERROR);
	}
	@Test(description="user is trying to search the newly added user")
	public void verifyWhetherTheUserIsAbleToSearchTheNewlyAddedUser() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnSignInButton();
		
		ap=hp.clickOnMoreInfoButton();
		
		
		String newusername=ExcelUtility.getStringData(0, 0, "AdminPage");
		
		ap.clickOnSearchButton().enterNewUserNameOnUserNameField(newusername).selectNewUserTypeFromDropDown().clickOnFinalSearchButton();
		Boolean newuserisdisplayed=ap.addedUserIsDisplayed();
		Assert.assertTrue(newuserisdisplayed,Constant.SEARCHUSERERROR);
	}
	@Test(description="user is trying to reset the users list")
	public void verifyWhetherUserIsAbleToResetTheUsersList() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnSignInButton();
		
		ap=hp.clickOnMoreInfoButton();
		
		ap.clickOnResetButton();
		Boolean newuserisdisplayed=ap.usersListIsDisplayed();
		Assert.assertTrue(newuserisdisplayed,Constant.RESETERROR);
	}

}
