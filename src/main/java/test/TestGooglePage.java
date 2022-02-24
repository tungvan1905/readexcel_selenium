package test;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseSetup;
import page.GooglePage;
import utiliti.ExcelUtils;

public class TestGooglePage extends BaseSetup {
	@Test(dataProvider = "testData")
	public void testMethod(String xpath, String content) throws InterruptedException {
		GooglePage googlePage=new GooglePage(driver);
		WebElement btnInput=googlePage.btnInput(xpath);
		googlePage.inputValue(btnInput, content);//input value to box sraech
		googlePage.pressEnter(btnInput);// enter to search
		String actualResult=googlePage.checkResult();
		assertTrue(actualResult.contains(content));// check title page searchs

	}

	@DataProvider(name = "testData")
	public Object[][] getDataFromExcel() throws Exception {
		Object[][] testObjArray = ExcelUtils
				.getTableArray("C:\\Users\\mvtung\\OneDrive - CMC Global\\Desktop\\tool\\Data_Test.xlsx", "Sheet1");
		return (testObjArray);
	}
}
