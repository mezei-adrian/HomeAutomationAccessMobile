package com.example.adrian.homeautomationaccessmobile.ui.home;

public enum ScreenType {
    HOME, GATES, CAMERAS, WOLS, FAVOURITES;

    public static ScreenType toScreenType(String screenTypeString) {
        try {
            return valueOf(screenTypeString);
        } catch (Exception ex) {
            // For error cases
            return HOME;
        }
    }
}
