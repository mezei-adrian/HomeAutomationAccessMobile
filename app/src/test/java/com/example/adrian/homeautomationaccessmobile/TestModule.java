package com.example.adrian.homeautomationaccessmobile;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.example.adrian.homeautomationaccessmobile.di.Network;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlPresenter;
import com.example.adrian.homeautomationaccessmobile.ui.home.HomePresenter;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginPresenter;
import com.example.adrian.homeautomationaccessmobile.utils.UiExecutor;

@Module
public class TestModule {

    private Context context;

    public TestModule(Context context) {
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
    public HomePresenter provideHomePresenter() {
        return new HomePresenter();
    }

    @Provides
    public ControlPresenter provideControlPresenter() {
        return new ControlPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}
