package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
    private WebDriver driver;
    private By myLeavesPage = By.xpath("//span[contains(text(),'My Leaves')]");
    private By myProfilePage = By.xpath("//span[contains(text(),'My Profile')]");
    WebDriverWait wait;

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }
    
    public MyLeavesPage goToRequestLeavePage() {
    	wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.presenceOfElementLocated(myLeavesPage));
    	driver.findElement(myLeavesPage).click();
    	return new MyLeavesPage(driver);
    }
    
    public ProfilePage goToProfilePage() {
    	wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.presenceOfElementLocated(myProfilePage));
    	driver.findElement(myProfilePage).click();
    	return new ProfilePage(driver);
    }
    
   

    
}
