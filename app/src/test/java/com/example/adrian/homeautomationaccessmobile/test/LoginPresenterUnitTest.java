package com.example.adrian.homeautomationaccessmobile.test;

import com.example.adrian.homeautomationaccessmobile.BuildConfig;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlPresenter;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlScreen;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginPresenter;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginScreen;
import com.example.adrian.homeautomationaccessmobile.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.adrian.homeautomationaccessmobile.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginPresenterUnitTest {

    LoginPresenter loginPresenter;
    LoginScreen loginScreen;

    @Before
    public void setup() throws Exception{
        setTestInjector();
        loginScreen = mock(LoginScreen.class);
        loginPresenter = new LoginPresenter();
        loginPresenter.attachScreen(loginScreen);
    }

    @Test
    public void testLoginError(){
        loginPresenter.loginError();
        verify(loginScreen).loginError();
    }

    @Test
    public void testLoginSuccess(){
        loginPresenter.loginSuccess();
        verify(loginScreen).loginSuccess();
    }

    @Test
    public void testLoginCancelled(){
        loginPresenter.loginCancelled();
        verify(loginScreen).loginCancelled();
    }

    @After
    public void tearDown() {
        loginPresenter.detachScreen();
    }
}
