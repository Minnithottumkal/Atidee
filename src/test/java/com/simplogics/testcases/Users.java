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
public class Users extends BaseData{
	@Test(priority = 10)
	public void users() throws InterruptedException, IOException{
		test=extent.createTest("users");

		
		if(!(TestUtil.isTestRunnable("Users", excel))){
			
			throw new SkipException("Skipping the test "+"Users".toUpperCase()+ "as the Run mode is NO");
		}
		
		
		Thread.sleep(2000);
	  	click("Users_linkText");
	  	//verifyEquals(OR.getProperty("expected"),OR.getProperty("actual"));
	  	verifypageurl(config.getProperty("expectedUserspage_url"));
		

}
}
