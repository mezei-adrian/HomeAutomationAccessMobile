package com.example.adrian.homeautomationaccessmobile.network;

import com.example.adrian.homeautomationaccessmobile.model.ControlsResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ControlsApi {
    @GET("Controls")
    Call<ControlsResult> getControls(@Query("controlType") String controlType);
}
