/**
 * 
 */
package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

/**
 * @author Aswathy
 *
 */
public class ManageCompanyLocation extends BaseData{
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp",priority=9)
	public void manageCompanyLocation(String LOCATION,String COMPANYLOCATIONCODE,String DOMAIN) throws InterruptedException, IOException{
		test=extent.createTest("manageCompanyLocation");

		if(!(TestUtil.isTestRunnable("manageCompanyLocation", excel))){
			
			throw new SkipException("Skipping the test "+"ManageCompanyLocation".toUpperCase()+ "as the Run mode is NO");
		}
		/*Thread.sleep(2000);
		click("managecompanylocation_CSS");*/
		Thread.sleep(2000);
		click("companylocationcreate_CSS");
		Thread.sleep(2000);
		click("Selectcountry_CSS");
		Thread.sleep(2000);
		click("Selectcountry_XPATH");
		type("Location_XPATH",(LOCATION));
		type("Locationcode_XPATH",(COMPANYLOCATIONCODE));
		type("Domain_XPATH",(DOMAIN));
		click("checkbox_XPATH");
		Thread.sleep(2000);
		click("Createbutton_XPATH");
		Thread.sleep(2000);
		  Asserttoast(OR.getProperty("expected_locationcompany_toast"),"locationcompany_actual_toast_CSS");
		
	}
}
