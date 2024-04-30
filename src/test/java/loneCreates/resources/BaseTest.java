package loneCreates.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import loneCreats.PageObjects.DashBoard;
import loneCreats.PageObjects.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	DashBoard db;
	LoginPage lp;
	@BeforeMethod(alwaysRun=true)
	public WebDriver driverInitialization() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public LoginPage launchApplication(String url) {
		 lp = new LoginPage(driver);
		 lp.visit(url);
		 return lp;
	}
	
	public DashBoard launchDashBoard(String url,String Username,String PassWord) {
		/**
		 * Visits page given as
		 * 
		 * */
		LoginPage lp = new LoginPage(driver);
		lp.visit(url);
		db = lp.LoginApplication(Username,PassWord);

		try {
		lp.waitforElement(By.cssSelector(".toast-message"),1);
		
		}catch (Exception e) {
		lp.waitforPageTitle("Dashboard",10);
		}
		
		return db;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
	}
}
