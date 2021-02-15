package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.NewOrder_Page_Objects;

public class Test_Raise_Order_with_10_Product extends CommonFunctions{

	Logger logger = Logger.getLogger(Test_Login_Test_Case.class);

	@Test
	public void raiseOrderWithTenProduct () throws InterruptedException {

		PageFactory.initElements(driver, NewOrder_Page_Objects.class);
		logger.info("New Order main menu clicked");
		NewOrder_Page_Objects.newOrder_MainMenu.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		NewOrder_Page_Objects.newOrder_MainMenu.click();
		
	}




}
