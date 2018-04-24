package com.example.adrian.homeautomationaccessmobile;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        HomeAutomationAccessMobile application = (HomeAutomationAccessMobile) RuntimeEnvironment.application;
        HomeAutomationAccessMobileComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
    }
}
