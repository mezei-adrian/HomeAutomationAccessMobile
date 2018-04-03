package com.example.adrian.homeautomationaccessmobile.interactor;

import com.example.adrian.homeautomationaccessmobile.interactor.control.ControlInteractor;
import com.example.adrian.homeautomationaccessmobile.interactor.login.LoginInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public LoginInteractor provideLoginInteractor(){
        return new LoginInteractor();
    }

    @Provides
    public ControlInteractor provideControlInteractor(){
        return new ControlInteractor();
    }
}
