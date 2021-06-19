/**
 * 
 */
package com.simplogics.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

/**
 * @author Aswathy
 *
 */
public class CompanySearch extends BaseData {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp", priority = 6)
	public void companySearch(String COMPANYNAME) throws InterruptedException, IOException {
		test = extent.createTest("companySearch");

		if (!(TestUtil.isTestRunnable("companySearch", excel))) {

			throw new SkipException("Skipping the test " + "Createvisits".toUpperCase() + "as the Run mode is NO");
		}
		Thread.sleep(2000);
		type("Search_XPATH", (COMPANYNAME));
		searchcompany();
		if (cell.getText().equalsIgnoreCase(COMPANYNAME)) {
			cell.click();
		}
		//System.out.println(COMPANYNAME);
		//System.out.println(cell.getText());
		//String value=cell.getText();
		//System.out.println(value);
		//assertEquals(cell.getText(),COMPANYNAME);

		Thread.sleep(5000);

	}
}
