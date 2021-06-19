/**
 * 
 */
package com.simplogics.testcases;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;


/**
 * @author Aswathy
 *
 */
public class CreateCompany extends BaseData{
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp",priority=5)
	public void createCompany(String COMPANYNAME,String COMPANYCODE, String COMPANYDOMAIN) throws InterruptedException, IOException{
		test=extent.createTest("createCompany");
        if(!(TestUtil.isTestRunnable("createCompany", excel))){
			
			throw new SkipException("Skipping the test "+"Createvisits".toUpperCase()+ "as the Run mode is NO");
		}		
				
		click("Create_Button_CSS");
		click("Click_name_CSS");
		type("Company_Name_CSS",(COMPANYNAME));
		type("Company_Code_CSS",(COMPANYCODE));
		type("Company_Domain_CSS",(COMPANYDOMAIN));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");  
		click("Create_CSS");
		
		Thread.sleep(2000);
		Asserttoast(OR.getProperty("expected_companycreate_toast"),"Company_create_toast_CSS");
		
		
		
			 
}
}
