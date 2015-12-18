package test.java.pages;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import test.java.base.Base;
import test.java.util.ReadUIProperties;

public class AddUserPage extends Base {

	By fullname = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_FULL_NAME"));
	By email = By.xpath(ReadUIProperties.getInstance().getValue("USER_EMAIL"));
	By countrycode = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_COUNTRY_CODE"));
	By phoneno = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_PHONE_NUMBER"));
	By profileImage = By.xpath(ReadUIProperties.getInstance().getValue(
			"PROFILE_IMAGE_BUTTON"));
	By profileImageDone = By.cssSelector(ReadUIProperties.getInstance()
			.getValue("SELECT_PROFILE_DONE"));
	By providerAdminType = By.xpath(ReadUIProperties.getInstance().getValue(
			"PROVIDER_ADMIN"));
	By providerdropdown = By.xpath(ReadUIProperties.getInstance().getValue(
			"PROVIDER_DROP_DOWN"));
	By userName = By
			.xpath(ReadUIProperties.getInstance().getValue("USER_NAME"));
	By userpwd = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_PASSWORD"));
	By confirmuserpwd = By.xpath(ReadUIProperties.getInstance().getValue(
			"CONFIRM_USER_PASSWORD"));
	By basicRole = By.xpath(ReadUIProperties.getInstance().getValue(
			"BASIC_ROLE"));
	By userCreatorRole = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_CREATOR_ROLE"));
	By providerCreatorRole = By.xpath(ReadUIProperties.getInstance().getValue(
			"PROVIDER_CREATOR_ROLE"));
	By notificationCreatorRole = By.xpath(ReadUIProperties.getInstance()
			.getValue("NOTIFICATION_CREATOR_ROLE"));
	By notificationApproverRole = By.xpath(ReadUIProperties.getInstance()
			.getValue("NOTIFICATION_APPROVER_ROLE"));
	By userManagerRole = By.xpath(ReadUIProperties.getInstance().getValue(
			"USER_MANAGER_ROLE"));
	By providerManagerRole = By.xpath(ReadUIProperties.getInstance().getValue(
			"PROVIDER_MANAGER_ROLE"));
	By notificationPublisherRole = By.xpath(ReadUIProperties.getInstance()
			.getValue("NOTIFICATION_PUBLISHER_ROLE"));
	By providerAdminCreatorRole = By.xpath(ReadUIProperties.getInstance()
			.getValue("PROVIDER_ADMIN_CREATOR_ROLE"));
	By addUserButton = By.xpath(ReadUIProperties.getInstance().getValue(
			"ADD_USER_BUTTON"));
	By userAddedMsg = By.id(ReadUIProperties.getInstance().getValue(
			"USER_ADDED_MESSAGE"));

	public boolean addCharlieUser(String userRoleType) {

		try {
			driver.findElement(fullname)
					.sendKeys(
							"charlieuserbasicrole"
									+ RandomStringUtils.randomNumeric(3));
			;
			driver.findElement(email).sendKeys(
					"charlieuserbasicrole" + RandomStringUtils.randomNumeric(3)
							+ "@charlie.com");
			driver.findElement(countrycode).sendKeys("91");
			driver.findElement(phoneno).sendKeys(
					"9" + RandomStringUtils.randomNumeric(9));
			driver.findElement(profileImage).click();
			File file = new File("src/test/resources/charlie.jpg");
			driver.findElement(By.id("fileInput_profile_picture")).sendKeys(
					file.getAbsolutePath());
			driver.findElement(profileImageDone).click();
			driver.findElement(userName)
					.sendKeys(
							"charlieuserbasicrole"
									+ RandomStringUtils.randomNumeric(3));
			driver.findElement(userpwd).sendKeys("password");
			driver.findElement(confirmuserpwd).sendKeys("password");
			if (userRoleType.equals("Basic Role")) {
				driver.findElement(basicRole).click();
			} else if (userRoleType.equals("User Creator")) {
				driver.findElement(userCreatorRole).click();
			}
			waitForElementToAppear(driver, addUserButton).isEnabled();
			driver.findElement(addUserButton).click();
			return waitForElementToAppear(driver, userAddedMsg).isDisplayed();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}

	public boolean addProviderAdmin() {

		try {
			// return driver.findElement(signin).isDisplayed();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}

}
