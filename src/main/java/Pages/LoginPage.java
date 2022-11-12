package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {
	
	//Object Reperosatry
	@FindBy(xpath="//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath="//div[@class='bot_column']") private WebElement botLogo;
	@FindBy(xpath="//input[@id='user-name']") private WebElement usernameTextBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	
	@FindBy(xpath="//span[@class='title']") private WebElement productLabel;
	
	

	//Constructor to intialize elements of page
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Metods
	//Method to login to application and to verify the label
	public String loginToApp1() throws Exception
	{
		
		usernameTextBox.sendKeys(ReadData.readPropertyFile("username"));//standard_user
		passwordTextBox.sendKeys(ReadData.readPropertyFile("password"));//secret_sauce
		loginBtn.click();
		return productLabel.getText();
		
	}
	
	//Method to verify current Url
	public String loginToApp2() throws Exception
	{
		loginToApp1();
		return driver.getCurrentUrl();
		}
	
	//Method To verify the logo 1 after login
	
	
	public String verifythetilte()
	{
		return driver.getTitle();
	}
	
	//method to verify Url
	public String verifyurl()
	{
		return driver.getCurrentUrl();
	}
	
	

}
