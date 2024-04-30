package loneCreats.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AbstractComponent {

	public WebDriver driver;
	WebDriverWait wait; 
	
	@FindBy(css=".toast-message")
	WebElement toast;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement waitforElement(By locator,int time) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public WebElement waitforWebElement(WebElement element,int time) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public Boolean waitforPageTitle(String pageTitle,int time) {
		
		wait =new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleIs(pageTitle));
	}
	
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
		//return null;
	}
	
	public String toastMsg() {
	
		waitforWebElement(toast,1);
		return toast.getText();
	}
}
