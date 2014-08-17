package com.sunset.tests;


import com.sunset.framework.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestNavigation extends BaseTest {

    @BeforeClass(alwaysRun = true)
    private void createSession() {
        super.setupBaseTest();

    }

    @BeforeMethod(alwaysRun = true)
    public void loginToEnv() {

    }


    @Test
    public void amendDOBInvalidDateT3() {

        String a = "aa";
        String b = "a";

        assertThat("Error summary: '", a, containsString(b));


    }

    @AfterClass(alwaysRun = true)
    private void quit() {
        endSession();
    }
}
