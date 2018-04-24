package com.example.adrian.homeautomationaccessmobile.test;

import com.example.adrian.homeautomationaccessmobile.interactor.login.LoginInteractor;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginInteractorUnitTest {

    LoginInteractor login;
    LoginResponse loginResponseMock;

    @Before
    public void setup(){
        loginResponseMock = mock(LoginResponse.class);
        login = new LoginInteractor();
    }

    @Test
    public void loginFailsOnWrongEmail(){
        login.setCredentials("email", "a", loginResponseMock);
        login.execute();
        verify(loginResponseMock).loginError();
    }

    @Test
    public void loginFailsOnWrongPassword(){
        login.setCredentials("a", "pw", loginResponseMock);
        login.execute();
        verify(loginResponseMock).loginError();
    }

    @Test
    public void loginSucceedsOnGoodEmailAndPassword(){
        login.setCredentials("a", "a", loginResponseMock);
        login.execute();
        verify(loginResponseMock).loginSuccess();
    }
}
