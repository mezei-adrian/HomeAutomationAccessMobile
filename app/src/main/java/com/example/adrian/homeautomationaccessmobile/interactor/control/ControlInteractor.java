package com.example.adrian.homeautomationaccessmobile.interactor.control;

import android.util.Log;

import com.example.adrian.homeautomationaccessmobile.HomeAutomationAccessMobile;
import com.example.adrian.homeautomationaccessmobile.model.ControlsResult;
import com.example.adrian.homeautomationaccessmobile.network.ControlsApi;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class ControlInteractor {

    @Inject
    ControlsApi controlsApi;

    public ControlInteractor(){
        HomeAutomationAccessMobile.injector.inject(this);
    }

    public void getControls(String controlsType) {
        Call<ControlsResult> artistsQueryCall = controlsApi.getControls(controlsType);
        GetControlsEvent event = new GetControlsEvent();
        try {
            Response<ControlsResult> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setControls(response.body().getControlItems());
            EventBus.getDefault().post(event);
            Log.i("RESPOSNE", response.body().getControlItems().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
