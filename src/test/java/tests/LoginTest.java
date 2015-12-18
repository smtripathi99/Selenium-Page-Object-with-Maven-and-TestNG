package test.java.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import test.java.pages.LoginPage;
import test.java.util.Log;

public class LoginTest extends LoginPage {

	@BeforeClass
	public void setUp() throws Exception {
		launchUrl();
	}

	@Test(priority = 1)
	public void siteUp() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		Log.startTestCase("Is Charlie Portal Up Test Started");
		boolean isSiteUp = LoginPageUp();
		Assert.assertTrue(isSiteUp, "Charlie Portal is up");

	}

	@Test(priority = 2)
	public void LoginSuccess() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		Log.startTestCase("Login Success Test Started");
		boolean isLoginPass = doLogin();
		Assert.assertTrue(isLoginPass, "Login is successful");
	}

	@AfterClass
	public void teardown() throws InterruptedException {

		driver.close();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}
}
