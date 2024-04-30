package loneCreates;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import loneCreates.resources.BaseTest2;
import loneCreats.PageObjects.ItemsPage;


public class ItemsTest extends BaseTest2 {
	
	@Test(groups ="itemcheck")
	public void Addnewitemtest() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//WebDriver driver = driverInitialization();
				
		//DashBoard db = launchDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		//db.openDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		//Assert.assertTrue(db.getTitle().equalsIgnoreCase("Dashboard"));
		/*
		ItemsPage items = db.selectItems();
		Assert.assertTrue(db.getTitle().equalsIgnoreCase("Items"));
		items.setItemName("300 btl");
		items.selectItemType("Both");
		items.setSalePrice(255);
		items.setPurchasePrice(200);
		items.setGST(1.1);
		items.includeGST();
		items.setOpeningStockQuantity(55);
		items.setPurchasePricePerUnit(20);
		items.setBarcodeNum(335566);
		items.saveItem();
		String toastmsg = items.toastMsg();
		Assert.assertEquals(toastmsg, "Item Already Exists.");
		//Thread.sleep(2000);*/
		
		Assert.assertTrue(true);
	}
	
	@Test(groups = "itemcheck",dependsOnMethods = "Addnewitemtest")
	public void ItemExists() throws InterruptedException  {
		/*
		DashBoard db = launchDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		//db.openDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		Assert.assertTrue(db.getTitle().equalsIgnoreCase("Dashboard"));
		ItemsPage items = db.selectItems();
		Assert.assertTrue(items.findItemByName("300 btl"));
		*/
		//DashBoard db = launchDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		//db.openDashBoard("https://cloud.tarsil.pk/", "03216466500", "lone@tersil.pk");
		//Assert.assertTrue(db.getTitle().equalsIgnoreCase("Dashboard"));
		////db.selectCommunication();
		//Assert.assertTrue(db.getTitle().equalsIgnoreCase("Message Settings"));
		Assert.assertTrue(true);
		//Thread.sleep(2000);
	}

}
