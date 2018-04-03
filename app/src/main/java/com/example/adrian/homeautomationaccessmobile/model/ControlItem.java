package com.example.adrian.homeautomationaccessmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ControlItem {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("details")
    @Expose
    private String details;

    @SerializedName("buttonText")
    @Expose
    private String buttonText;

    public ControlItem(String id, String content, String details, String buttonText) {
        this.id = id;
        this.content = content;
        this.details = details;
        this.buttonText = buttonText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public String toString() {
        return buttonText;
    }
}
