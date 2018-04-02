package com.example.adrian.homeautomationaccessmobile;

import android.app.Application;

import com.example.adrian.homeautomationaccessmobile.ui.UIModule;

public class HomeAutomationAccessMobile extends Application {

    public static HomeAutomationAccessMobileComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerHomeAutomationAccessMobileComponent.builder().uIModule(new UIModule(this)).build();
    }
}
