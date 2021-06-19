package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class UserDelete extends BaseData {
	
	//@Test(priority = 19)

	public void userDelete() throws InterruptedException, IOException{
		  
		 
		  if(!(TestUtil.isTestRunnable("userDelete", excel))){
				
				throw new SkipException("Skipping the test "+"UserDelete".toUpperCase()+ "as the Run mode is NO");
			}
	
		  Thread.sleep(2000);
		  click("User_Delete_button_XPATH");
		  Thread.sleep(2000);
		  click("User_Delete_ok_CSS");
		  
		  
	}		  
}
 
