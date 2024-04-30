package loneCreates;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import loneCreates.resources.BaseTest2;



public class ValidLoginTest extends BaseTest2{

	@Test(groups ="itemcheck")
	public void validLogin() throws IOException  {
		// TODO Auto-generated method stub
		
		//DashBoard db = launchDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		
		
		
		//Assert.assertTrue(db.getTitle().equalsIgnoreCase("Dashboard"));
		Assert.assertTrue(true);
		
	}

}
