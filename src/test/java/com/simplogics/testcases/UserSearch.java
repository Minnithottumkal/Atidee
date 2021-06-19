package com.simplogics.testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.BaseData;
import com.simplogics.utilities.TestUtil;

public class UserSearch extends BaseData
{
    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp", priority = 12)
    public void userSearch (String USERSEARCHNAME) throws InterruptedException, IOException {
		test=extent.createTest("userSearch");

        if (!TestUtil.isTestRunnable("userSearch", UserSearch.excel)) {
            throw new SkipException("Skipping the test " + "UserSearch".toUpperCase() + "as the Run mode is NO");
        }

        Thread.sleep(2000);
        click("UserSearch_XPATH");
        Thread.sleep(2000);
        type("UserSearch_XPATH", USERSEARCHNAME);
        searchuser();
        if (cell.getText().equalsIgnoreCase(USERSEARCHNAME)) {
            cell.click();
        }
    }
}

