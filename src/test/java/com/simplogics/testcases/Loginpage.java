/**
 * 
 */
package com.simplogics.testcases;


import java.io.IOException;
import java.net.MalformedURLException;


import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;


public class Loginpage extends BaseData {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider = "dp")
	public void loginpage(String email,String password,String Y) throws InterruptedException, MalformedURLException, IOException{
		test=extent.createTest("Loginpage");
		if(!(TestUtil.isTestRunnable("Loginpage", excel))){
			
			throw new SkipException("Skipping the test "+"Loginpage".toUpperCase()+ "as the Run mode is NO");
		}
		
		type("email_XPATH",(email));
		type("password_CSS",(password));
		click("loginbtn_XPATH");

		Thread.sleep(2000);
		Asserttoast(OR.getProperty("expected_login_toast"),"Company_login_CSS");
		log.debug("Login Successfully");
		
	}
}

  