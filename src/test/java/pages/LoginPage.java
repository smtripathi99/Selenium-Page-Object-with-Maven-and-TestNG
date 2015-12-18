package test.java.pages;

import org.openqa.selenium.By;
import test.java.base.Base;
import test.java.util.ReadUIProperties;

public class LoginPage extends Base {

	// private WebDriver driver;
	By username = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_NAME_LOGIN"));
	By password = By.xpath(ReadUIProperties.getInstance().getValue(
			"PASSWORD_LOGIN"));
	By signin = By.className(ReadUIProperties.getInstance().getValue(
			"SIGNIN_BUTTON"));
	By homePageImage = By.xpath(ReadUIProperties.getInstance().getValue(
			"CHARLIE_HOME_IMAGE"));

	public boolean LoginPageUp() {

		try {
			return waitForElementToAppear(driver, signin).isDisplayed();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}

	public boolean doLogin() {

		try {
			waitForElementToAppear(driver, signin);
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys("charlieadmin");
			driver.findElement(password).clear();
			driver.findElement(password).sendKeys("P@ssw0rd");
			driver.findElement(signin).click();
			boolean loginSuccess = waitForElementToAppear(driver, homePageImage)
					.isDisplayed();
			return loginSuccess;
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}

}
