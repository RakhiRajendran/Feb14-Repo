package elementRepo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityPack.GeneralUtilities;
import utilityPack.XLReadUtility;

public class YourLogoLoginPageRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	XLReadUtility xlu = new XLReadUtility();

	public YourLogoLoginPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailAddress;
	@FindBy(id = "passwd")
	WebElement password;
	@FindBy(id = "SubmitLogin")
	WebElement loginButton;
	@FindBy(xpath = "//a[@title='Recover your forgotten password']")
	WebElement forgotPassword;
	@FindBy(xpath = "//div[@id='center_column']//li[text()='Authentication failed.']")
	WebElement invalidMsg;

	public void enterUsername(String user) {
		emailAddress.sendKeys(user);
	}

	public void enterPassword(String passwords) {
		password.sendKeys(passwords);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void clickForgotPassword() {
		forgotPassword.click();
	}

	public String getSignInButtonText() {
		return gu.getElementText(loginButton);
	}

	public String getLoginPageTitlt() {
		return gu.pageTitleFunction(driver);
	}

	public String xlStringReadCredentials(int row, int col) throws IOException {
		return XLReadUtility.stringDataRead(row, col);
	}

	public String getInvalidMsg() {
		String msg=gu.getElementText(invalidMsg);
		return msg;
	}

}
