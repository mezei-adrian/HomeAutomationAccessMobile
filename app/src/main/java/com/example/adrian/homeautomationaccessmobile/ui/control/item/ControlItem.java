package com.example.adrian.homeautomationaccessmobile.ui.control.item;

/**
 * A dummy item representing a piece of content.
 */
public class ControlItem {
    public final String id;
    public final String content;
    public final String details;

    public ControlItem(String id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}
