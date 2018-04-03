package com.example.adrian.homeautomationaccessmobile;

import com.example.adrian.homeautomationaccessmobile.interactor.InteractorModule;
import com.example.adrian.homeautomationaccessmobile.interactor.control.ControlInteractor;
import com.example.adrian.homeautomationaccessmobile.network.NetworkModule;
import com.example.adrian.homeautomationaccessmobile.ui.UIModule;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlFragment;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlPresenter;
import com.example.adrian.homeautomationaccessmobile.ui.home.HomeFragment;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginActivity;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class})
public interface HomeAutomationAccessMobileComponent {

    void inject(LoginActivity loginActivity);

    void inject(LoginPresenter loginPresenter);

    void inject(HomeFragment homeFragment);

    void inject(ControlInteractor controlInteractor);

    void inject(ControlFragment controlFragment);

    void inject(ControlPresenter controlPresenter);

}
