package com.example.adrian.homeautomationaccessmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ControlsResult {

    @SerializedName("controlItems")
    @Expose
    private List<ControlItem> controlItems = new ArrayList<ControlItem>();

    public List<ControlItem> getControlItems() {
        return controlItems;
    }

    public void setControlItems(List<ControlItem> controlItems) {
        this.controlItems = controlItems;
    }
}
