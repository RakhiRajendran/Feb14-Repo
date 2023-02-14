package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepo.YourLogoHomePageRepo;
import elementRepo.YourLogoLoginPageRepo;

public class YourLogoLoginPageTestCase extends YourLogoBaseClass {
	YourLogoLoginPageRepo lpr;
	YourLogoHomePageRepo hpr;

	@Test(priority = 1,enabled=true)
	public void verifySignInButtonTextTC01() {
		lpr = new YourLogoLoginPageRepo(driver);
		String actualSigninButtonText = lpr.getSignInButtonText();
		String expectedSignButtonText = "Sign in";
		Assert.assertEquals(actualSigninButtonText, expectedSignButtonText, "Signin button text is different");
	}

	@Test(priority = 2,enabled=true)
	public void verifyValidUserTC02() throws IOException {
		lpr = new YourLogoLoginPageRepo(driver);
		hpr = new YourLogoHomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlStringReadCredentials(1, 1));
		lpr.clickLogin();
		String actualLoggedUserName = hpr.getLoggedUserNameText();
		String expectedLoggedUserName = "Rohit Rajendran";
		Assert.assertEquals(actualLoggedUserName, expectedLoggedUserName, "Invalid username and password");
	}

	@Test(priority = 3,enabled=true)
	public void verifyInValidUserTC03() throws IOException {
		lpr = new YourLogoLoginPageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlStringReadCredentials(2, 1));
		lpr.clickLogin();
		String actualAlertMsg = lpr.getInvalidMsg();
		String expectedLoginTitle = "Authentication failed.";
		Assert.assertEquals(actualAlertMsg, expectedLoginTitle, "Logged in with Invalid username and password");
	}

	@Test( priority = 4,enabled=true)
	public void verifyForgotPasswordTC04() throws IOException, InterruptedException {
		lpr = new YourLogoLoginPageRepo(driver);
		hpr = new YourLogoHomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		String loginTitle = hpr.getPageTitle();
		lpr.clickForgotPassword();
		String forgotPasswordTitle = hpr.getPageTitle();
		Assert.assertNotSame(loginTitle, forgotPasswordTitle, "Logged are same");
	}
}
