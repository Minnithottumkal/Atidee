/**
 * 
 */
package com.simplogics.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

/**
 * @author Aswathy
 *
 */
public class Spacemenu extends BaseData{
	
	//@Test(priority = 2)
	public void spacemenu() throws InterruptedException, IOException{
		
		if(!(TestUtil.isTestRunnable("Spacemenu", excel))){
			
			throw new SkipException("Skipping the test "+"Spacemenu".toUpperCase()+ "as the Run mode is NO");
		}
	
	click("Spacemenu_XPATH");
	Thread.sleep(2000);
	isElementPresent(By.cssSelector("Spacecreate_CSS"));

}
}
