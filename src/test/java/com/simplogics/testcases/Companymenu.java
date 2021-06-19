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
public class Companymenu extends BaseData{
	@Test(priority=4)
	public void companymenu() throws InterruptedException, IOException{		
		test=extent.createTest("companymenu");
		if(!(TestUtil.isTestRunnable("companymenu", excel))){
			
			throw new SkipException("Skipping the test "+"Createvisits".toUpperCase()+ "as the Run mode is NO");
		}		
        click("Company_linkText");
        verifyEquals(OR.getProperty("expected"),OR.getProperty("actual"));
        verifypageurl(config.getProperty("expectedurl"));
       
        
}
}

