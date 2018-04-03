package com.example.adrian.homeautomationaccessmobile.interactor.control;

import com.example.adrian.homeautomationaccessmobile.model.ControlItem;

import java.util.List;


public class GetControlsEvent {
    private int code;
    private List<ControlItem> controls;
    private Throwable throwable;

    public GetControlsEvent() {
    }

    public GetControlsEvent(int code, List<ControlItem> controls, Throwable throwable) {
        this.code = code;
        this.controls = controls;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ControlItem> getControls() {
        return controls;
    }

    public void setControls(List<ControlItem> controls) {
        this.controls = controls;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}