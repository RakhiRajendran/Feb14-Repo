package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityPack.GeneralUtilities;

public class YourLogoHomePageRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	

	public YourLogoHomePageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement loggedUserName;
	
	
	public String getLoggedUserNameText() {
		return gu.getElementText(loggedUserName);
	}
	public String getPageTitle() {
		return gu.pageTitleFunction(driver);
	}
}
