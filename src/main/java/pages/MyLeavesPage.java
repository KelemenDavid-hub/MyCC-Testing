package pages;


import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyLeavesPage {
	private WebDriver driver;
	private By requestRestDaysButton = By.xpath("//span[contains(text(),'+ Request')]");
	private By skipButton = By.xpath("//button[contains(text(),'Skip')]");
	private By dateRangeText = By.xpath("//input[@placeholder=\"Date Range\"]");
	private By halfDayCheckBox = By.xpath("(//label[@class='custom-control-label'])[1]");
	private By colleaguesCheckBox = By.xpath("(//label[@class='custom-control-label'])[2]");
	private By todayButton = By.xpath("//span[@class='lm-fs-12 flex-1' and contains(text(),'Today')]");
	private By saveButton = By.xpath("//button[contains(text(),'Save')]");
	private By succesMessage = By.xpath("//div[contains(text(),'Request created successfully')]");
	
	WebDriverWait wait;
	
	public MyLeavesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRequestRestDaysButton() {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(requestRestDaysButton));
		driver.findElement(requestRestDaysButton).click();
	}
	
	public void clickSkipButton() {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(skipButton));
		driver.findElement(skipButton).click();
		
	}
	
	public void clickDateRangeText() {
		driver.findElement(dateRangeText).click();
	}
	
	public void clickHalfDayCheckBox() {
		driver.findElement(halfDayCheckBox).click();
	}
	
	public void clickColleaguesCheckBox() {
		driver.findElement(colleaguesCheckBox).click();
	}
	public void clickTodayButton() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(dateRangeText));
		driver.findElement(todayButton).click();
	
	}
	public void clickSaveButton() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		driver.findElement(saveButton).click();
	}
	
	public String getSuccesMessage() {
		wait = new WebDriverWait(driver,8);
		wait.until(ExpectedConditions.presenceOfElementLocated(succesMessage));
		return driver.findElement(succesMessage).getText();
	}
	public void clickSelectedDay(String day) {
	
		By selectedDay = By.xpath(String.format("//span[@class='datepicker-day-text flex-1' and contains(text(),'%s')]",day));
		driver.findElement(selectedDay).click();  
		
	}
	
}
