package loneCreats.PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loneCreats.AbstractComponents.AbstractComponent;


public class ItemsPage extends AbstractComponent{
	/**
	 * @author Hassan
	 * page Elements for Tarsil Login page
	 * 
	 * */
	WebDriver driver;
	
	@FindBy(id="txtItemNameAddItem")
	WebElement itemName;
	
	@FindBy(id="select2-slctItemTypeAddItem-container")
	WebElement itemType;
	
	@FindBy(id="txtPriceAddItem")
	WebElement salePrice;
	
	@FindBy(id="txtPurchasePriceAddItem")
	WebElement purchasePrice;
	
	@FindBy(id="txtGSTPercentAddItem")
	WebElement GST;
	
	@FindBy(css=".custom-control")
	WebElement includeGST;
	
	@FindBy(id="txtOpeningStockAddItem")
	WebElement openingStockQuantity;
	
	@FindBy(id="txtOpeningPurchasePriceAddItem")
	WebElement PurchasePricePerUnit;
	
	@FindBy(id="txtBarcodeNoAddItem")
	WebElement BarcodeNum;
	
	@FindBy(id="btnSaveAddItem")
	WebElement SaveItem;
	
	@FindBy(id="txtBarcodeNoAddItem")
	WebElement cancelItem;

	@FindBy(css="#select2-slctItemTypeAddItem-results>li")
	List<WebElement> itemTypeList;
	
	@FindBy(css=".toast")
	WebElement toastMsg;
	
	@FindBy(id="btnFindAddItem")
	WebElement findItem;
	
	@FindBy(css=".dataTables_scroll tbody")
	WebElement findItemtable;
	
	public ItemsPage(WebDriver driver) {
		/**
		 * Constructor for initializing driver
		 * */
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void setItemName(String name) {
		
		itemName.sendKeys(name);
	}
	public void selectItemType(String type) {
		
		itemType.click();
		//System.out.println(itemTypeeList.getText());
		itemTypeList.stream().filter(item->item.getText().equalsIgnoreCase(type)).toList().get(0).click();
	}
	 public void setSalePrice(double price) {
		 salePrice.sendKeys(String.valueOf(price));
	 }
	 public void setPurchasePrice(double price) {
		 purchasePrice.sendKeys(String.valueOf(price));
	 }
	 public void setGST(double price) {
		 GST.sendKeys(String.valueOf(price));
	 }
	 public void includeGST() {
		 includeGST.click();
	 }
	 public void setOpeningStockQuantity(double quantity) {
		 openingStockQuantity.sendKeys(String.valueOf(quantity));
	 }

	 public void setPurchasePricePerUnit(double price) {
		 PurchasePricePerUnit.sendKeys(String.valueOf(price));
	 }
	 public void setBarcodeNum(double barCodeNum) {
		 BarcodeNum.sendKeys(String.valueOf(barCodeNum));
	 }
	 public void saveItem() {
		 
		 SaveItem.click();
		 waitforWebElement(toastMsg,1);
	 }
	 public void pressCancelBtn() {
		 cancelItem.click();
	 }
	 
	 public String toastMsg()
	 {
		 
		 return toastMsg.getText();
	 }
	 public boolean findItemByName(String itemname)
	 {
		 findItem.click();
		 waitforWebElement(findItemtable,1);
		 List<WebElement> el=findItemtable.findElements(By.cssSelector("tr td:nth-child(2)"))
				 .stream().filter(entry->entry.getText().equalsIgnoreCase(itemname)).toList();
		 
		 return el.size()>0;
	 }


}
