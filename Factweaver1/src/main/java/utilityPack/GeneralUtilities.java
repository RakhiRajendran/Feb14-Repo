package utilityPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}
	public String pageTitleFunction(WebDriver driver) {
		return driver.getTitle();
	}
	public String alertFunction(WebDriver driver, WebElement element) {
		element.click();
		return driver.switchTo().alert().getText();
	}

}
