package com.example.adrian.homeautomationaccessmobile.ui.control;

import com.example.adrian.homeautomationaccessmobile.HomeAutomationAccessMobile;
import com.example.adrian.homeautomationaccessmobile.di.Network;
import com.example.adrian.homeautomationaccessmobile.interactor.control.ControlInteractor;
import com.example.adrian.homeautomationaccessmobile.interactor.control.GetControlsEvent;
import com.example.adrian.homeautomationaccessmobile.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class ControlPresenter extends Presenter<ControlScreen> {

    @Inject
    ControlInteractor controlInteractor;

    @Inject
    @Network
    Executor networkExecutor;

    public ControlPresenter(){
        HomeAutomationAccessMobile.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    public void showControls(final String controlType){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                controlInteractor.getControls(controlType);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetControlsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showControls(event.getControls()); // TODO getControlItems
            }
        }
    }

}
