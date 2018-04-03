package com.example.adrian.homeautomationaccessmobile.interactor.control;

import com.example.adrian.homeautomationaccessmobile.ui.control.item.ControlItem;

import java.util.List;


public class GetControlsEvent {
    private int code;
    private List<ControlItem> artists;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetControlsEvent() {
    }

    public GetControlsEvent(int code, List<ControlItem> artists, Throwable throwable) {
        this.code = code;
        this.artists = artists;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ControlItem> getArtists() {
        return artists;
    }

    public void setArtists(List<ControlItem> artists) {
        this.artists = artists;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}