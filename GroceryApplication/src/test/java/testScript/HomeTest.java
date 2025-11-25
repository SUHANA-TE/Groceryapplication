package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base{
	HomePage hp;
	@Test(description="user is trying to loggout")
	public void verifyWhetherUserIsAbleToSuccessfullyLoggedOut() throws IOException
	{
	String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
	LoginPage lp=new LoginPage(driver);
	lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
	hp=lp.clickOnSignInButton();
	
	//hp.clickOnManageNewsMoreInfo();
	hp.clickOnAdmin();
	lp=hp.clickOnLogout();
	Boolean signinbuttondisplayed=hp.signinButtonPresent();
	Assert.assertTrue(signinbuttondisplayed,Constant.LOGGOUTERROR);
	//hp.clickOnMoreInfoButton();
	

}
}
