package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewOrder_Page_Objects {


	@FindBy (xpath = "//a[@href=\'#/nav/titlecard/prodadd\']")
	public static WebElement newOrder_MainMenu;


}
