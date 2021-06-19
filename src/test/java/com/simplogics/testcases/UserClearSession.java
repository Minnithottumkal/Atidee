package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class UserClearSession extends BaseData {
	
	@Test(priority = 14)

	public void userClearSession() throws InterruptedException, IOException{
		test=extent.createTest("userClearSession");

		 
		  if(!(TestUtil.isTestRunnable("userClearSession", excel))){
				
				throw new SkipException("Skipping the test "+"UserClearSession".toUpperCase()+ "as the Run mode is NO");
			}
		  Thread.sleep(2000);
		  click("User_ClearSession_XPATH");
		  Thread.sleep(2000);
		  click("User_Clearsession_ok_CSS");
		  Thread.sleep(2000);
		  //click("Userdeails_Close_XPATH");
		  Asserttoast(OR.getProperty("expected_userclear_toast"),"userclear_actual_toast_CSS");
		 
		  
	}	  
}

