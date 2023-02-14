package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class YourLogoBaseClass {
	WebDriver driver;

	public static Properties prop;

	public static void testBasics() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\Config.properties");
		prop.load(fis);
	}

	@BeforeMethod

	@Parameters("Browser")
	public void beforeMethod(String Browser) throws IOException {
		testBasics();
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty(prop.getProperty("ChromeDriver"), System.getProperty("user.dir")
					+ "\\src\\main\\resources\\Driver\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Edge")) {
			System.setProperty(prop.getProperty("EdgeDriver"), System.getProperty("user.dir")
					+ "\\src\\main\\resources\\Driver\\edgedriver_win64 (2)\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod()

	public void afterMethod() {

		driver.close();
	}
}
