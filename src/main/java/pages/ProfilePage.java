package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	private WebDriver driver;
	private By addContactButton = By.xpath("//button[contains(text(),'Add New Contact')]");
	private By firstName = By.xpath("//input[@name='firstName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By phoneNumber = By.xpath("//input[@name='primaryPhoneNumber']");
	private By eMail = By.id("email-input");
	private By relationship = By.id("relationship-input");
	private By otherOption = By.xpath("//option[contains(text(),'Other')]");
	private By saveButton = By.xpath("//button[contains(text(),'Save Changes')]");
	private By succesfulContactMessage = By.xpath("//div[contains(text(),'Contact created successfully')]");
	private By addNewContactButton = By.xpath("//button[contains(text(),'New Contact')]");
	WebDriverWait wait;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddContactButton() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(addContactButton));
		driver.findElement(addContactButton).click();
	}
	
	public void setFirstName(String firstname) {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
		driver.findElement(firstName).sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		driver.findElement(lastName).sendKeys(lastname);
	}
	
	public void setPhoneNumber(String phonenumber) {
		driver.findElement(phoneNumber).sendKeys(phonenumber);
	}
	
	public void setEmail(String email) {
		driver.findElement(eMail).sendKeys(email);
	}
	
	public void clickRelationship() {
		driver.findElement(relationship).click();
	}
	
	public void clickOtherOption() {
		driver.findElement(otherOption).click();
	}
	
	public void clickSaveButton() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		driver.findElement(saveButton).click();
	}
	
	public String getSuccesfulContactMessage() {
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(succesfulContactMessage));
		return driver.findElement(succesfulContactMessage).getText();
	}
	
	public void clickAddNewContactButton() {
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNewContactButton));
		driver.findElement(addNewContactButton).click();
	}
	
	
	

}
