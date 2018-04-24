package com.example.adrian.homeautomationaccessmobile.test;

import android.support.v4.media.VolumeProviderCompat;

import com.example.adrian.homeautomationaccessmobile.BuildConfig;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlPresenter;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlScreen;
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
public class ControlPresenterUnitTest {

    ControlPresenter controlPresenter;
    ControlScreen controlsScreen;

    @Before
    public void setup() throws Exception{
        setTestInjector();
        controlsScreen = mock(ControlScreen.class);
        controlPresenter = new ControlPresenter();
        controlPresenter.attachScreen(controlsScreen);
    }

    @Test
    public void testControlsGates(){
        controlPresenter.showControls("GATES");

        ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
        verify(controlsScreen).showControls(captor.capture());
        assertTrue(captor.getValue().size() > 0);
    }

    @Test
    public void testControlsCameras(){
        controlPresenter.showControls("CAMERAS");

        ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
        verify(controlsScreen).showControls(captor.capture());
        assertTrue(captor.getValue().size() > 0);
    }

    @Test
    public void testControlsWols(){
        controlPresenter.showControls("WOLS");

        ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
        verify(controlsScreen).showControls(captor.capture());
        assertTrue(captor.getValue().size() > 0);
    }

    @After
    public void tearDown() {
        controlPresenter.detachScreen();
    }
}
