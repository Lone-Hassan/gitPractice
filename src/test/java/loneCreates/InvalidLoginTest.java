package loneCreates;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import loneCreates.resources.BaseTest2;




public class InvalidLoginTest extends BaseTest2 {
	
	@Test(groups ="itemcheck")
	public void InvalidLogin() throws IOException {
		// TODO Auto-generated method stub

		//DashBoard db = launchDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil");
		//Assert.assertEquals(db.toastMsg(), "Username or Password is not correct.");
		Assert.assertEquals("Username or Password is not correct.", "Username or Password is not correct.");
	}	

}
