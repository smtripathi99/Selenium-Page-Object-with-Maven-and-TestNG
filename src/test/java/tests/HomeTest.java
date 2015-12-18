package test.java.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.java.pages.HomePage;
import test.java.pages.LoginPage;
import test.java.util.Log;

public class HomeTest extends HomePage {

	@BeforeClass
	public void setUp() throws Exception {
		launchUrl();
	}

	LoginPage loginpage = new LoginPage();

	@Test
	public void HomePageSuccess() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		Log.startTestCase("Home Page Test Started");
		boolean isLoginPass = loginpage.doLogin();
		Assert.assertTrue(isLoginPass, "Home page is displayed");
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
