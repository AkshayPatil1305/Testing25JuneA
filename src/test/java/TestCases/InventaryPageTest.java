package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.InventaryPage;
import Pages.LoginPage;

public class InventaryPageTest extends InventaryPage{
	
	LoginPage login;
	InventaryPage invent;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		intialization();
		invent =new InventaryPage();
		login =new LoginPage();	
	}
	
	@Test (enabled = true)
	public void verifySmallLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifySmallLogo();
		Assert.assertEquals(result, true,"Fail Zali ka??????");
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		System.out.println("This is verifysmallLogoTest");
	}
	
	@Test (enabled = false)
	public void verifyBigLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyBigLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test(enabled=false,invocationCount=1,timeOut=3000)
	public void add6ProductTest() throws Exception
	{
		login.loginToApp1();
		String result = invent.add6Product();
		Assert.assertEquals(result, "6");
	}
	
	@Test (enabled = false)
	public void verifytwitterLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
	}
	
	
	@Test (enabled = false)
	public void verifyfaceBookLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyFaceBookLogo();
		Assert.assertEquals(result, true);
	}
	
	
	@Test (enabled = false)
	public void verifylinkdeinLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyLinkdeinLogo();
		Assert.assertEquals(result, true);
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
