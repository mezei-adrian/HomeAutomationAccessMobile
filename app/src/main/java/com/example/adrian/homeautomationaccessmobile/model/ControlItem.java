package com.example.adrian.homeautomationaccessmobile.ui.control.item;

/**
 * A dummy item representing a piece of content.
 */
public class ControlItem {
    public final String id;
    public final String content;
    public final String details;
    public final String buttonText;

    public ControlItem(String id, String content, String details, String buttonText) {
        this.id = id;
        this.content = content;
        this.details = details;
        this.buttonText = buttonText;
    }

    @Override
    public String toString() {
        return buttonText;
    }
}
