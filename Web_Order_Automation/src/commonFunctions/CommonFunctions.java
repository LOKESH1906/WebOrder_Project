package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	public static Properties properties = null;
	public static WebDriver driver = null;
	Logger logger = Logger.getLogger(CommonFunctions.class);
	

	public Properties loadPropertieFiles() throws IOException {
		FileInputStream fileinputstream = new FileInputStream ("config.properties");
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	@BeforeSuite
	public void launchBrowser () throws IOException {
		PropertyConfigurator.configure("Log4j.properties");
		loadPropertieFiles();
		logger.info("Launching Browser");
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverlocation = properties.getProperty("driverlocation");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverlocation);
			logger.info("Launching Chrome Browser");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", driverlocation);
			logger.info("Launching Firefox Browser");
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}



	@AfterSuite
	public void tearDown () {
		logger.info("Closing Browser");
		driver.quit();

	}

}
