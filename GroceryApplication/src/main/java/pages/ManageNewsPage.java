package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger'and@onclick='click_button(1)']") WebElement newnewsbutton;
	@FindBy(id="news") WebElement news;
	@FindBy(xpath="//button[@type='submit'and@name='create']") WebElement savenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary'and@onclick='click_button(2)']") WebElement searchnews;
	@FindBy(xpath="//input[@type='text'and@placeholder='Title']") WebElement newstitle;
	@FindBy(xpath = "//button[@type='submit'and@name='Search']") WebElement finalsearch;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement addedalert;
	@FindBy(xpath="//td[text()='Deals of the Day']") WebElement dealsofday;
	
	
	
	
	
	public ManageNewsPage clickOnNewNewsbutton()
	{
		newnewsbutton.click();
		return this;
	}
	public ManageNewsPage enterNewsOnNewsField(String newstext)
	{
		news.sendKeys(newstext);
		return this;
	}
	public ManageNewsPage clickOnSaveNewsButton()
	{
		savenews.click();
		return this;
	}
	public ManageNewsPage clickOnSearchNewsButton()
	{
		searchnews.click();
		return this;
	}
	public ManageNewsPage enterNewNewsOnSearchField(String newstext) 
	{
		newstitle.sendKeys(newstext);
		return this;
	}
	public ManageNewsPage clickOnFinalSearchButton()
	{
		finalsearch.click();
		return this;
	}
	public boolean addedNewsIsDisplayed()
	{
		return addedalert.isDisplayed();
	}
	public boolean searchedNewsIsDisplayed()
	{
		return dealsofday.isDisplayed();
	}
}
