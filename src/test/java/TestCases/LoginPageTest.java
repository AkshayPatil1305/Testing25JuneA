package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utility.CaptureScreenShot;
import Utility.ReadData;

public class LoginPageTest extends LoginPage{
	
	LoginPage login;
	
	//It is prerequisite to	run	the	test case open the browser + enter URL
	//This will execute multiple times depend on number of test cases
	@BeforeMethod
	public void setup() throws Exception
	{
		intialization();
		login =new LoginPage();
	}
	//Test case to login to application	and verify label
	@Test (enabled=true/*,dependsOnMethods="verifyUrlTest"*/,priority=0)
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		Assert.assertEquals(label, "PRODUCTS");
//		Assert.assertEquals(label, ReadData.readExcelFile(1, 0) );//"PRODUCTS"
	}
	//Test case to login to application	and	verify	URL
	@Test (enabled = false)
	public void loginToApp2Test() throws Exception
	{
		Assert.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
	}
	//Test case to verify title
	@Test (enabled = true/*,dependsOnMethods="verifyUrlTest"*/,priority=1)
	public void verifyTitleTest()
	{
		String expTitle="Swag Labs";
		String actTitle=verifythetilte();
		Assert.assertEquals(expTitle, actTitle);
	}
	//Test case to verify current URL
	@Test (enabled = true,priority=1)
	public void verifyUrlTest()
	{
		String expUrl="https://www.saucedemo.com/";
		String actUrl=verifyurl();
		Assert.assertEquals(expUrl, actUrl);
	}
	//This is post action after running	the	test case and will close the browser	
	//This will	execute	multiple times depend on number of test cases
	@AfterMethod
	public void closeBrower(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenshot(it.getName());
		}
		
		driver.close();
	}

}
