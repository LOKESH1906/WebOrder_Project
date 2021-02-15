package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Page_Objects {


	@FindBy (id = "dashboard")
	public static WebElement dashboard_MainMenu;
	
	@FindBy (xpath = "//*[@class = \'col col-9 f-20-rem text-secondary text-center\']")
	public static WebElement dashboard_title;
	
}
