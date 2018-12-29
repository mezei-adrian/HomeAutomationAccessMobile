package com.example.adrian.homeautomationaccessmobile.ui.login;

import com.example.adrian.homeautomationaccessmobile.HomeAutomationAccessMobile;
import com.example.adrian.homeautomationaccessmobile.interactor.login.LoginInteractor;
import com.example.adrian.homeautomationaccessmobile.ui.Presenter;

import javax.inject.Inject;
import javax.inject.Provider;

public class LoginPresenter extends Presenter<LoginScreen> implements LoginResponse{

    @Inject
    Provider<LoginInteractor> loginInteractor;

    public LoginPresenter(){
        HomeAutomationAccessMobile.injector.inject(this);
    }

    public boolean isEmailValid(String email) {
        //TODO: Replace this with validation logic
        return true;
    }

    
    public boolean isPasswordValid(String password) {
        //TODO: Replace this with validation logic
        if(password.equals("b")){
            throw new RuntimeException("This is a crash");
        }
        return true;
    }

    public void login(String email, String password){
        LoginInteractor loginInteractorInstance = loginInteractor.get();
        if (loginInteractorInstance != null) {
            loginInteractorInstance.setCredentials(email, password, this);
            loginInteractorInstance.execute();
        }
    }

    @Override
    public void loginSuccess() {
        screen.loginSuccess();
    }

    @Override
    public void loginError() {
        screen.loginError();
    }

    @Override
    public void loginCancelled() {
        screen.loginCancelled();
    }
}
