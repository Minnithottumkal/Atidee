package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class Useredit extends BaseData
{
	@Test(priority = 13)
    public void userEdit() throws InterruptedException, IOException {
		test=extent.createTest("userEdit");

        if (!TestUtil.isTestRunnable("userEdit", Useredit.excel)) {
            throw new SkipException("Skipping the test " + "UserEdit".toUpperCase() + "as the Run mode is NO");
        }
        Thread.sleep(2000);
        click("User_Edit_button_XPATH");
       /* click("User_Edit_status_XPATH");
        Thread.sleep(2000);
        click("User_Edit_Status_active_XPATH");*/
        Thread.sleep(2000);
        click("User_Edit_role_XPATH");
        Thread.sleep(2000);
        click("User_Edit_Role_Admin_XPATH");
        Thread.sleep(2000);
        click("User_Edit_Save_button_XPATH");
        Thread.sleep(2000);
        //click("User_Edit_Close_button_XPATH");
		  Asserttoast(OR.getProperty("expected_useredit_toast"),"useredit_actual_toast_CSS");
    }
}
