package com.example.adrian.homeautomationaccessmobile.ui;

import android.content.Context;

import com.example.adrian.homeautomationaccessmobile.di.Network;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlPresenter;
import com.example.adrian.homeautomationaccessmobile.ui.home.HomePresenter;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public LoginPresenter provideLoginPresenter(){
        return new LoginPresenter();
    }

    @Provides
    public HomePresenter provideHomePresenter(){
        return new HomePresenter();
    }

    @Provides
    public ControlPresenter provideControlPresenter() { return new ControlPresenter(); }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
