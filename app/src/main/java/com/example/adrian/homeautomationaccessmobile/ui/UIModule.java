package com.example.adrian.homeautomationaccessmobile.ui;

import android.content.Context;

import com.example.adrian.homeautomationaccessmobile.ui.login.LoginPresenter;

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
}
