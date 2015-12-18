package test.java.pages;

import org.openqa.selenium.By;
import test.java.base.Base;
import test.java.util.ReadUIProperties;

public class HomePage extends Base {

	By userLink = By
			.xpath(ReadUIProperties.getInstance().getValue("USER_LINK"));
	By providerLink = By.xpath(ReadUIProperties.getInstance().getValue(
			"PROVIDER_LINK"));
	By addUserLink = By.xpath(ReadUIProperties.getInstance().getValue(
			"ADD_USER_LINK"));
	By addProviderLink = By.xpath(ReadUIProperties.getInstance().getValue(
			"ADD_PROVIDER_LINK"));
	By addUserTitle = By.xpath(ReadUIProperties.getInstance().getValue(
			"ADD_USER_TITLE"));
	By addProviderTitle = By.xpath(ReadUIProperties.getInstance().getValue(
			"ADD_PROVIDER_TITLE"));

	public boolean openAddUserPage() {

		try {
			driver.findElement(userLink).click();
			driver.findElement(addUserLink).click();
			waitForElementToAppear(driver, addUserTitle);
			return driver.findElement(addUserTitle).isDisplayed();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}

	public boolean openAddProviderPage() {

		try {
			driver.findElement(providerLink).click();
			driver.findElement(addProviderLink).click();
			waitForElementToAppear(driver, addProviderTitle);
			return driver.findElement(addProviderTitle).isDisplayed();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}

}
