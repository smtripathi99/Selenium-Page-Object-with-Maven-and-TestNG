package test.java.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.java.pages.AddUserPage;
import test.java.pages.HomePage;
import test.java.pages.LoginPage;
import test.java.util.Log;

public class AddUserTest extends AddUserPage {

	@BeforeClass
	public void setUp() throws Exception {
		launchUrl();
	}

	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();

	@Test
	public void basicRoleCharlieUserSuccess() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		Log.startTestCase("Create Basic Role Charlie User Test Started");
		loginpage.doLogin();
		homepage.openAddUserPage();
		boolean isbasicCharlieUsercreated = addCharlieUser("Basic Role");
		Assert.assertTrue(isbasicCharlieUsercreated,
				"Basic Role Charlie User Created");
	}

	@Test
	public void userCreatorRoleCharlieUserSuccess() throws Exception {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
		Log.startTestCase("User Creator Role Charlie User Test Started");
		loginpage.doLogin();
		homepage.openAddUserPage();
		boolean isUserCreatorCharlieUsercreated = addCharlieUser("User Creator");
		Assert.assertTrue(isUserCreatorCharlieUsercreated,
				"User Creator Role Charlie User Created");
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
