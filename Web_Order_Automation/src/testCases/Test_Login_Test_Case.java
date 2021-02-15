package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObjects.Loginpage_Page_Objects;

public class Test_Login_Test_Case extends CommonFunctions{
	public static String [][] data = null;
	Logger logger = Logger.getLogger(Test_Login_Test_Case.class);


	@DataProvider(name ="TestCASE")
	public String [][] loginDataProvider () throws BiffException, IOException {
		data = getExcelData();
		return data;


	}

	public String [][] getExcelData () throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("D:\\SOFTWARE\\Selenium\\ExcelData\\WebOrder_Datas.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
		logger.info("Read Data from Workbook");
		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();
		
		String webOrderData [][] = new String [rowcount-1][columncount];

		for (int i=1; i<rowcount; i++) {
			for (int j=0; j<columncount; j++) {
				webOrderData [i-1][j] = sheet.getCell(j, i).getContents();
			}
		}
		logger.info("Return to Excel Data");
			return webOrderData;

	}

	@Test(dataProvider = "TestCASE")
	public void logintestCase (String uname, String pword) throws InterruptedException {
		
		PageFactory.initElements(driver, Loginpage_Page_Objects.class);
		Loginpage_Page_Objects.username.clear();
		Loginpage_Page_Objects.password.clear();
		logger.info("Username Entry");
		Loginpage_Page_Objects.username.sendKeys(uname);
		logger.info("Password Entry");
		Loginpage_Page_Objects.password.sendKeys(pword);
		logger.info("Click on Submit button");
		Loginpage_Page_Objects.submit.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
