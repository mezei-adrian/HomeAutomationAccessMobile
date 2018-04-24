package com.example.adrian.homeautomationaccessmobile;

import javax.inject.Singleton;

import dagger.Component;
import com.example.adrian.homeautomationaccessmobile.interactor.InteractorModule;
import com.example.adrian.homeautomationaccessmobile.mock.MockNetworkModule;
import com.example.adrian.homeautomationaccessmobile.network.NetworkModule;
import com.example.adrian.homeautomationaccessmobile.ui.UIModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends HomeAutomationAccessMobileComponent {
}