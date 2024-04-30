package loneCreats.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//page Object Model for Tarsil Login page

public class CommunicationPage extends DashBoard{
	/**
	 * @author Hassan
	 * page Elements for Tarsil Login page
	 * 
	 * */
	

	
	public CommunicationPage(WebDriver driver) {
		/**
		 * Constructor for initializing driver
		 * */
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	}
	
	

