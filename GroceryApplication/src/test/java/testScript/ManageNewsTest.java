package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage hp;
	ManageNewsPage mn;
@Test(description="user is trying to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnSignInButton();
		
		mn=hp.clickOnManageNewsMoreInfo();
		
		
		String newstext=ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		
		mn.clickOnNewNewsbutton().enterNewsOnNewsField(newstext).clickOnSaveNewsButton();
		boolean newnewsisdisplayed=mn.addedNewsIsDisplayed();
		Assert.assertTrue(newnewsisdisplayed,Constant.ADDNEWSERROR);
	
		
	}
@Test(description="user is trying to search newly added news")
public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException
{
	String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
	LoginPage lp=new LoginPage(driver);
	lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
	hp=lp.clickOnSignInButton();
	
	mn=hp.clickOnManageNewsMoreInfo();
	ManageNewsPage mn=new ManageNewsPage(driver);
	
	String newstext=ExcelUtility.getStringData(0, 0, "ManageNewsPage");
	
	mn.clickOnSearchNewsButton().enterNewNewsOnSearchField(newstext).clickOnFinalSearchButton();
	boolean searchednews=mn.searchedNewsIsDisplayed();
	Assert.assertTrue(searchednews,Constant.SEARCHNEWSERROR);

	
}

}
