package loneCreats.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loneCreats.AbstractComponents.AbstractComponent;

public class DashBoard extends AbstractComponent{

	WebDriver driver;
	@FindBy(id="aDashboardIndex")
	WebElement DashBoard;
	
	@FindBy(id="aTrackboardIndex")
	WebElement TrackBoard;
	
	@FindBy(id="aCommunicationIndex")
	WebElement Communication;
	
	@FindBy(css="#navSidebarIndex>ul>li:nth-child(4)")
	WebElement Administration;
	
	@FindBy(css="#navSidebarIndex>ul>li:nth-child(4)")
	WebElement Reports;
	
	public DashBoard(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectDashboard() {
		DashBoard.click();
	}
	
	public void selectTrackboard() {
		TrackBoard.click();
	}
	public void openAdministration() {
		Administration.click();
	}
	
	public ItemsPage selectItems() {
		WebElement items = Administration.findElement(By.cssSelector("ul>li:nth-child(3)"));
		if(!items.isDisplayed())
		{
			openAdministration();
		}
		items.click();
		waitforPageTitle("Items",3);
		ItemsPage item = new ItemsPage(driver);
		return item;
	}
	
	public CommunicationPage selectCommunication()  {
		Communication.click();
		
		waitforPageTitle("Message Settings",3);
		CommunicationPage cp = new CommunicationPage(driver);
		return cp;
	}


	
}
