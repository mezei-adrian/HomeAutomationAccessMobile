package com.example.adrian.homeautomationaccessmobile.ui.control;

import com.example.adrian.homeautomationaccessmobile.model.ControlItem;

import java.util.List;

public interface ControlScreen {

    void showControls(List<ControlItem> controlItems);

    void showNetworkError(String message);

}
