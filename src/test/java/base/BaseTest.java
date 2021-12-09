package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;


import pages.DashBoardPage;
import pages.LogInPage;


public class BaseTest {

	protected WebDriver driver;
	protected LogInPage loginPage;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "driverPath", "browser", "url","email","password" })
	public void goHome(ITestResult result, String driverPath, String browser, String url,String email,String password) throws Exception {

		// Check if parameter passed from TestNG is 'Chrome'
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			// create Chrome instance
			driver = new ChromeDriver(getChromeHeadlessOptions());
		}

		// Check if parameter passed as 'Firefox'
		else if (browser.equalsIgnoreCase("Firefox")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.gecko.driver", driverPath);
			// create Firefox instance
			driver = new FirefoxDriver(getFirefoxHeadlessOptions());
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", driverPath);
			// create Edge instance
			driver = new EdgeDriver(getEdgeHeadlessOptions());
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not supported");
		}

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(url);
		driver.manage().window().maximize();

		loginPage = new LogInPage(driver);

		Reporter.setCurrentTestResult(result);
		Reporter.log("BeforeMethod");
	}

	@AfterMethod(alwaysRun = true)
	
	public void tearDown(ITestResult result) {

		driver.quit();

		Reporter.setCurrentTestResult(result);
		Reporter.log("AfterMethod");
	}

	private ChromeOptions getChromeHeadlessOptions() {
		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		return options;
	}

	private FirefoxOptions getFirefoxHeadlessOptions() {
		FirefoxOptions options = new FirefoxOptions();
		// options.setHeadless(true);
		return options;
	}

	private EdgeOptions getEdgeHeadlessOptions() {
		EdgeOptions options = new EdgeOptions();
		// options.setHeadless(true);
		// options.addArguments("headless");
		return options;
	}
}
