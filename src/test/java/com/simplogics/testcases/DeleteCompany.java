package com.simplogics.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class DeleteCompany extends  BaseData{
	//@Test(priority = 20)
	public void deleteCompany() throws InterruptedException, IOException{
		
		if(!(TestUtil.isTestRunnable("deleteCompany", excel))){
			
			throw new SkipException("Skipping the test "+"deleteCompany".toUpperCase()+ "as the Run mode is NO");
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(OR.getProperty("deleteButton_CSS"))).click();
		click("Okbutton_XPATH");
	}

}

