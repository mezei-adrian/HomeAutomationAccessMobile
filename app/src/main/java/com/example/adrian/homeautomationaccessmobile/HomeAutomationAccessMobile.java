package com.example.adrian.homeautomationaccessmobile;

import android.app.Application;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.example.adrian.homeautomationaccessmobile.ui.UIModule;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import io.fabric.sdk.android.Fabric;

public class HomeAutomationAccessMobile extends Application {

    public static HomeAutomationAccessMobileComponent injector;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        injector = DaggerHomeAutomationAccessMobileComponent.builder().uIModule(new UIModule(this)).build();

        sAnalytics = GoogleAnalytics.getInstance(this);
        sAnalytics.setLocalDispatchPeriod(15);
    }


    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
}
