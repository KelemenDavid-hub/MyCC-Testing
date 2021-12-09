package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	private WebDriver driver;
	WebDriverWait wait;
	private By emailText = By.xpath("//input[@name='email']");
	private By passwordText = By.xpath("//input[@name='password']");
	private By signInButton = By.xpath("//button[contains(text(),' Sign In ')]");
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public DashBoardPage clickSignInButton(String email,String password) {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(signInButton));
		driver.findElement(emailText).sendKeys(email);
		driver.findElement(passwordText).sendKeys(password);
		driver.findElement(signInButton).click();
		return new DashBoardPage(driver);
	}

}
