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
public class Visits extends BaseData{
	
		
		@Test(priority=16)
		public void visits() throws InterruptedException, IOException{
			test=extent.createTest("visits");

		if(!(TestUtil.isTestRunnable("Visits", excel))){
			
			throw new SkipException("Skipping the test "+"Visits".toUpperCase()+ "as the Run mode is NO");
		}
	
	
		click("Visits_linkText");
		 verifypageurl(config.getProperty("expectedvisiturl"));
	
		
	}

}
