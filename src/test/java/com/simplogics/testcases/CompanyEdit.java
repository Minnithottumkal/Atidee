package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class CompanyEdit extends BaseData{
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp",priority=7)

	public void companyedit(String Name,String Domain) throws InterruptedException {
		test=extent.createTest("companyedit");
	if(!(TestUtil.isTestRunnable("companyedit", excel))){
		
		throw new SkipException("Skipping the test "+"companyedit".toUpperCase()+ "as the Run mode is NO");		
	}
	Thread.sleep(2000);
	click("editbotton_CSS");
	type("Name_CSS",(Name));
	type("Domain_CSS",(Domain));
	click("save_CSS");
	Thread.sleep(2000);
	Asserttoast(OR.getProperty("Expected_toast_companyedit"),"Actual_toast_companyedit_CSS");
	
}
}
