package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class Companylocationoption extends BaseData {
	@Test(priority=8)
	public  void companylocationoption() throws InterruptedException {
		test=extent.createTest("companylocationoption");
		if(!(TestUtil.isTestRunnable("manageCompanyLocation", excel))){
			
			throw new SkipException("Skipping the test "+"ManageCompanyLocation".toUpperCase()+ "as the Run mode is NO");
		}
		Thread.sleep(2000);
		click("managecompanylocation_CSS");
		Thread.sleep(2000);

	}

}
