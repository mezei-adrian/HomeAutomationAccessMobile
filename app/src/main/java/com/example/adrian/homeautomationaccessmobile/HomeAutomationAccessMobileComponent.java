package com.example.adrian.homeautomationaccessmobile;

import com.example.adrian.homeautomationaccessmobile.interactor.InteractorModule;
import com.example.adrian.homeautomationaccessmobile.ui.UIModule;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginActivity;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})
public interface HomeAutomationAccessMobileComponent {
    void inject(LoginActivity loginActivity);

    void inject(LoginPresenter loginPresenter);
}
