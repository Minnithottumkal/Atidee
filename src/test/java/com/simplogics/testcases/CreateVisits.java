package com.simplogics.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class CreateVisits extends BaseData {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp",priority=17)
	public void createVisits(String VISITSNAME, String VISITSPURPOSE, String VISITCHECK) throws InterruptedException, IOException {
		test=extent.createTest("createVisits");

		if (!(TestUtil.isTestRunnable("CreateVisits", excel))) {

			throw new SkipException("Skipping the test " + "CreateVisits".toUpperCase() + "as the Run mode is NO");
		}

		
		click("visitcreatebutton_CSS");
		click("visitclick_CSS");
		type("Visitsname_CSS", (VISITSNAME));
		type("Visistspurpose_CSS", (VISITSPURPOSE));

		// Thread.sleep(100);
		// driver.findElement(By.xpath("//li[contains(.,'PERSONAL')]")).click();
		click("Visittypeclick_XPATH");
		click("Visittype_XPATH");
		Thread.sleep(1000);
		click("Visitcompanyclick_CSS");
		click("Visitcompany_XPATH");
		click("Visitlocationclick_CSS");
		click("Visitlocation_XPATH");
		click("Visitspocclick_CSS");
		click("Visitspoc_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    click("Visitcheckclick_CSS");
	    type ("Visitcheck_CSS",(VISITCHECK));
	    click ("Visitcheckclick_XPATH");
	    Thread.sleep(3000);
	    click("Visitcreate_CSS");
	    Thread.sleep(2000);
	    
	   
	   Asserttoast(OR.getProperty("expected_visitcreate_toast"),"Visit_create_toast_CSS");
	  // Thread.sleep(1000);
	
	}
}