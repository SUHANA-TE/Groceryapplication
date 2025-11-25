package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base{
	HomePage home;
	@Test(priority=1,description="user is trying to login with valid credentils",groups= {"smoke"})
	public void validateUserLoginWithValidCredentials() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=lp.clickOnSignInButton();
		Boolean dashboarddisplayed=lp.dashboardTilePresent();// to insert assert true
		Assert.assertTrue(dashboarddisplayed,Constant.VALIDCREDENTIALERROR);
		
	}
	@Test(priority=2,description="user is trying to login with invalid username and valid password",retryAnalyzer=retry.Retry.class)
	public void validateUserLoginWithInvalidUserNameValidPassword() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expected="7rmart supermarket";
		String actual=lp.GetTitleOfLoginPage();
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERERROR);
		
	}
	@Test(priority=3,description="user is trying to login with valid username and invalid password")
	public void validateUserLoginWithValidUserNameInvalidPassword() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnSignInButton();
		String expected="7rmart supermarket";
		String actual=lp.GetTitleOfLoginPage();
		Assert.assertEquals(actual, expected,Constant.INVALIDPASSWORDERROR);
		
	}
	@Test(priority=4,description="user is trying to login with invalid credentials",groups= {"smoke"},dataProvider="loginProvider")
	public void validateUserLoginWithInvalidCredentials(String usernamevalue,String passwordvalue) throws IOException 
	{
		//String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		//String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		
		String actual=lp.GetTitleOfLoginPage();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);
		lp.clickOnSignInButton();
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

}
