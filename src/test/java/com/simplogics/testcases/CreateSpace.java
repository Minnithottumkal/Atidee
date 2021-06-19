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
public class CreateSpace extends BaseData{

	@Test(priority = 3)
	public void createSpace() throws InterruptedException, IOException{
		test=extent.createTest("createSpace");

		if(!(TestUtil.isTestRunnable("CreateSpace", excel))){
			
			throw new SkipException("Skipping the test "+"Spacemenu".toUpperCase()+ "as the Run mode is NO");
		}
	
	//click("Spacecreate_CSS");	
	

}
	
}
