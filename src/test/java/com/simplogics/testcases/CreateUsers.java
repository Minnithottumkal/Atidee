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
 * @author Aswathy minni
 *
 */
public class CreateUsers extends BaseData{
	
	@Test(dataProviderClass=TestUtil.class,dataProvider = "dp",priority = 11)
	public void createUsers(String Name,String Email) throws InterruptedException, IOException{
		test=extent.createTest("createUsers");
		if(!(TestUtil.isTestRunnable("CreateUsers", excel))){
			
			throw new SkipException("Skipping the test "+"CreateUsers".toUpperCase()+ "as the Run mode is NO");
		}
		
		click("CreateUser_Button_CSS");
		Thread.sleep(2000);
		click("Name_Field_CSS");
		type("User_name_CSS",(Name));
		click("companyselect_CSS");
		click("Users_company_XPATH");
		click("Location_user_CSS");
		Thread.sleep(2000);
		click("SelectLocation_XPATH");
		type("User_email_CSS",(Email));
		Thread.sleep(2000);
		click("User_Role_XPATH");
		Thread.sleep(2000);
		click("SelectRole_XPATH");		
		click("User_Status_CSS");
		Thread.sleep(2000);
		click("User_Status_XPATH");
		click("Createuserbutton_CSS");
		Thread.sleep(2000);
		Asserttoast(OR.getProperty("expected_usercreate_toast"),"user_create_toast_CSS");
		Thread.sleep(5000);

	
	}

}
