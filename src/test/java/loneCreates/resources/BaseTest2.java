package loneCreates.resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import loneCreats.PageObjects.DashBoard;
import loneCreats.PageObjects.LoginPage;

public class BaseTest2 {

	public WebDriver driver;
	public DashBoard db;
	String url;
	String Username;
	String PassWord;

	@BeforeClass(alwaysRun = true)
	public DashBoard driverInitialization() throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.properties");
		prop.load(fis);
		//System.out.println("cmd Browser: " + System.getProperty("browser"));

		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		//System.out.println("browser is : " + browser);
		url = prop.getProperty("Url");
		Username = prop.getProperty("Username");
		PassWord = prop.getProperty("Password");

		if (browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		/**
		 * Visits page given as
		 * 
		 */
		LoginPage lp = new LoginPage(driver);
		lp.visit(url);
		/*
		db = lp.LoginApplication(Username, PassWord);

		try {
			lp.waitforElement(By.cssSelector(".toast-message"), 1);

		} catch (Exception e) {
			lp.waitforPageTitle("Dashboard", 10);
		}
*/
		return db;
	}

	public String getScreenShot(String TestName, WebDriver driver) throws IOException

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//reports//" + TestName + ".png");
		FileUtils.copyFile(src, destination);

		return System.getProperty("user.dir") + "//reports//" + TestName + ".png";
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
