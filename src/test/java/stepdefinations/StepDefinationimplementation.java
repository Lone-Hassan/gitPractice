package stepdefinations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loneCreates.resources.BaseTest;
import loneCreats.PageObjects.DashBoard;
import loneCreats.PageObjects.LoginPage;

public class StepDefinationimplementation extends BaseTest{
	LoginPage lp;
	DashBoard db;
	
	@Given("I land on {string} page")
	public void i_land_on_login_page(String url) throws IOException {
	    
		driverInitialization();
		lp=launchApplication(url);
		
	}

	@When("^I provid username (.+) and password (.+)$")
	public void i_provid_username_and_password(String username, String password) {
	    
		db=lp.LoginApplication(username, password);
		
	}

	@When("Try to login")
	public void try_to_login() {
	    // Write code here that turns the phrase above into concrete actions
		
		//System.out.println("try to login function");

	}

	@Then("Verify {string} pagetitle")
	public void verify_pageTitle(String pagetitle) {
	    // Write code here that turns the phrase above into concrete actions
		db.waitforPageTitle(pagetitle, 10);
		Assert.assertEquals(db.getTitle(), "Dashboard");
		tearDown();
	   
	}
	//Then Verify Error "Username or Password is not correct."
	@Then("Verify Error {string}")
	public void verify_Error(String msg) {
	    // Write code here that turns the phrase above into concrete actions
		//db.waitforPageTitle(pagetitle, 7);
	
		Assert.assertEquals(lp.toastMsg(), msg);
		tearDown();  
	}
}
