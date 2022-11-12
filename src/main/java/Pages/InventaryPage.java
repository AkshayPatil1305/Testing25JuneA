package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.ReadData;
import Utility.UtilityMethod;

public class InventaryPage extends TestBase{
	//TC1 verify the visiblity small logo
	//TC1 verify the visibilty large logo
	//TC1 Add 6 product in cart
	//TC1 Remove 2 product from the cart[Assignment]
	//TC1 verify the visibilty of twitter logo[Assignment]
	//TC1 verify the linkdin logo[Assignment]
	
	//object Reporesatry
	@FindBy(xpath="//div[@class='peek']") private WebElement smalllogo;
	@FindBy(xpath="//img[@class='footer_robot']") private WebElement biglogo;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement sorterDropdownropDown;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement tshirtBlackProduct16;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct50;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement tshirtProduct8;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement tshirtRedProduct16;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement productCountIcon;
	
	//Twitter logo
	@FindBy(xpath="//li[@class='social_twitter']") private WebElement twitterLogo;
	
	//FB logo
	@FindBy(xpath="//li[@class='social_facebook']") private WebElement faceBookLogo;
	
	//Linkdein logo
	@FindBy(xpath="//li[@class='social_linkedin']") private WebElement linkdeinLogo;
	
	//constructor
	public InventaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public boolean verifySmallLogo()
	{
		return smalllogo.isDisplayed();
	}
	
	public boolean verifyBigLogo()
	{
		return biglogo.isDisplayed();
	}
	
	public String add6Product() throws Exception
	{
		Select s=new Select(sorterDropdownropDown);
//		s.selectByVisibleText("Price (low to high)")
		UtilityMethod.selectClass(sorterDropdownropDown, "Price (low to high)");
		
//		s.selectByVisibleText(ReadData.readExcelFile(0, 0));//Price (low to high)
		backPackProduct.click();
		bikeLightProduct.click();
		tshirtBlackProduct16.click();
		jacketProduct50.click();
		tshirtProduct8.click();
		tshirtRedProduct16.click();
		String count = productCountIcon.getText();
		return count;
	}
	
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyFaceBookLogo()
	{
		return faceBookLogo.isDisplayed();
	}
	
	public boolean verifyLinkdeinLogo()
	{
		return linkdeinLogo.isDisplayed();
	}



}
