package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreenShot;

public class GroupTest extends TestBase{
	LoginPage login;
	@BeforeMethod (alwaysRun =true)
	public void setup() throws Exception
	{
		intialization();
		login =new LoginPage();
	}
	//Test case to login to application	and verify label
	@Test (groups = {"Sanity","Smoke","Regression"})
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		Assert.assertEquals(label, "1PRODUCTS");
//		Assert.assertEquals(label, ReadData.readExcelFile(1, 0) );//"PRODUCTS"
	}
	//Test case to login to application	and	verify	URL
	@Test (groups ="Sanity")
	public void loginToApp2Test() throws Exception
	{
		Assert.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
	}
	//Test case to verify title
	@Test (groups ="Smoke")
	public void verifyTitleTest()
	{
		String expTitle="Swag Labs1";
		String actTitle=login.verifythetilte();
		Assert.assertEquals(expTitle, actTitle);
	}
	//Test case to verify current URL
	@Test (groups ="Sanity")
	public void verifyUrlTest()
	{
		String expUrl="https://www.saucedemo.com/";
		String actUrl=login.verifyurl();
		Assert.assertEquals(expUrl, actUrl);
	}
	//This is post action after running	the	test case and will close the browser	
	//This will	execute	multiple times depend on number of test cases
	@AfterMethod (alwaysRun =true)
	public void closeBrower(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenshot(it.getName());
		}
		
		driver.close();
	}

}

