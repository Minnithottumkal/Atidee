package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class VisitSearch extends BaseData {

	//@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void visitSearch(String NAME) throws InterruptedException, IOException {
		test=extent.createTest("visitSearch");

		if (!(TestUtil.isTestRunnable("VisitSearch", excel))) {

			throw new SkipException("Skipping the test " + "VisitSearch".toUpperCase() + "as the Run mode is NO");
		}
		Thread.sleep(3000);
		click("VisitSearchclick_XPATH");
		Thread.sleep(2000);
		type("VisitSearchtype_CSS", (NAME));
		click("VisitSearchselection_CSS");
		click("Visitsearchclose_CSS");
		Thread.sleep(2000);
		click("Visitsearchboxclick_CSS");
		// clear();
		clearthetextboxfield("Visitsearchdelete_CSS");
		
	}
		
	
}