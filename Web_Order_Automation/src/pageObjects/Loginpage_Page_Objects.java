package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage_Page_Objects {
	
	@FindBy (id = "username")
	public static WebElement username;

	@FindBy (id = "password")
	public static WebElement password;
	
	@FindBy (xpath = "//*[@class = \'btn btn-md text-white bg-4343aa text-center f-08 btn-block\']")
	public static WebElement submit;

}
