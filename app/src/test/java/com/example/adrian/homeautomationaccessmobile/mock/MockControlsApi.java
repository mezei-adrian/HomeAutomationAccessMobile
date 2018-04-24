package com.example.adrian.homeautomationaccessmobile.mock;

import com.example.adrian.homeautomationaccessmobile.model.ControlItem;
import com.example.adrian.homeautomationaccessmobile.model.ControlsResult;
import com.example.adrian.homeautomationaccessmobile.network.ControlsApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MockControlsApi implements ControlsApi {


    @Override
    public Call<ControlsResult> getControls(@Query("controlType") String controlType) {

        final ControlsResult controlsResult = new ControlsResult();

        List<ControlItem> controlItems = new ArrayList<>();

        if(controlType.equals("GATES")){
            controlItems.add(new ControlItem("A", "A", "A", "Left gate"));
            controlItems.add(new ControlItem("B", "B", "B", "Neighbour gate"));
            controlItems.add(new ControlItem("C", "C", "C", "Red gate"));
        }

        if(controlType.equals("CAMERAS")){
            controlItems.add(new ControlItem("A", "A", "A", "Red camera"));
            controlItems.add(new ControlItem("B", "B", "B", "Neighbour camera"));
            controlItems.add(new ControlItem("C", "C", "C", "Left camera"));
        }

        if(controlType.equals("WOLS")){
            controlItems.add(new ControlItem("A", "A", "A", "Jane PC"));
            controlItems.add(new ControlItem("B", "B", "B", "Ryan PC"));
            controlItems.add(new ControlItem("C", "C", "C", "Tom PC"));
        }

        controlsResult.setControlItems(controlItems);

        Call<ControlsResult> call = new Call<ControlsResult>() {
            @Override
            public Response<ControlsResult> execute() throws IOException {
                return Response.success(controlsResult);
            }

            @Override
            public void enqueue(Callback<ControlsResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<ControlsResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
        return call;
    }
}