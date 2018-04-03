package com.example.adrian.homeautomationaccessmobile.ui.home;

import com.example.adrian.homeautomationaccessmobile.ui.Presenter;

public class HomePresenter extends Presenter<HomeScreen> {

    public void showWelcomeMessage(){
        screen.showWelcomeMessage("This is an application for controlling your home gadgets.\n\n\nYou can find categories like camera, gate etc. in the drawer menu of the top left hamburger button.");
    }

}
