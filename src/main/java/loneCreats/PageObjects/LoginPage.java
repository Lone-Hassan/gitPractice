package loneCreats.PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loneCreats.AbstractComponents.AbstractComponent;

//page Object Model for Tarsil Login page

public class LoginPage extends AbstractComponent{
	/**
	 * @author Hassan
	 * page Elements for Tarsil Login page
	 * 
	 * */
	WebDriver driver;
		
	@FindBy(id="txtUserName_Login")
	WebElement userName;
	
	@FindBy(id="txtPassword_Login")
	WebElement passWord;
	
	@FindBy(id="btnLogin_Login")
	WebElement loginButton;

	
	public LoginPage(WebDriver driver) {
		/**
		 * Constructor for initializing driver
		 * */
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public DashBoard LoginApplication(String UserName,String PassWord) 
	{
		/**
		 * Performs Login action
		 * @apiNote LoginApplication to perform login action
		 * */
		
		userName.sendKeys(UserName);
		passWord.sendKeys(PassWord);
		loginButton.click();
		DashBoard db = new DashBoard(driver);
		return db;
		//waitforElement(By.id("pageTitle"));
		
	}
	
	public void visit(String url) {
		/**
		 * Visits page given as
		 * 
		 * */
		driver.get(url);
	}
	
	
}
