package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class UserChangePassword extends BaseData {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp",priority=15)
	
	public void userChnagepassword(String USERSEARCHNAME,String Password,String confirmpassword) throws InterruptedException, IOException{
		  
		test=extent.createTest("userChnagepassword");

		  if(!(TestUtil.isTestRunnable("userChnagepassword", excel))){
				
				throw new SkipException("Skipping the test "+"UserChangePassword".toUpperCase()+ "as the Run mode is NO");
			}
		  Thread.sleep(2000);
		  click("User_Edit_button_XPATH");
		  Thread.sleep(2000);
		  click("User_Changepassword_CSS");
		  Thread.sleep(2000);
		  click("User_Change_Newpassword_XPATH");
		  type("User_Change_Newpassword_XPATH", (Password));
		  click("User_Change_Confirmpassword_XPATH");
		  type("User_Change_Confirmpassword_XPATH", (confirmpassword));
		  click("User_Chnagepassword_ok_CSS");
		  Thread.sleep(2000);
		 // click("User_Edit_Save_button_XPATH");
			Asserttoast(OR.getProperty("expected_userpassword_toast"),"userpassword_actual_toast_CSS");
		  Thread.sleep(2000);
		  click("User_Edit_Close_button_XPATH");
		  
		  
	}
}
