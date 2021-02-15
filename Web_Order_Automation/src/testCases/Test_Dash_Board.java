package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.Dashboard_Page_Objects;

public class Test_Dash_Board extends CommonFunctions{

	Logger logger = Logger.getLogger(Test_Login_Test_Case.class);

	@Test
	public void dashBoardPageTesting () throws InterruptedException {
		PageFactory.initElements(driver, Dashboard_Page_Objects.class);
		logger.info("Dash board main menu clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String dashBoartTitle = Dashboard_Page_Objects.dashboard_title.getText();
		logger.info("Dashboard Title - " + dashBoartTitle);



	}





}
