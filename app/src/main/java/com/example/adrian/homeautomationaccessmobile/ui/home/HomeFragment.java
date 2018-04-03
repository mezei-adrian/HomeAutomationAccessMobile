package com.example.adrian.homeautomationaccessmobile.ui.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adrian.homeautomationaccessmobile.HomeAutomationAccessMobile;
import com.example.adrian.homeautomationaccessmobile.R;

import javax.inject.Inject;


public class HomeFragment extends Fragment implements HomeScreen{

    @Inject
    HomePresenter homePresenter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        HomeAutomationAccessMobile.injector.inject(this);
        homePresenter.attachScreen(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        homePresenter.showWelcomeMessage();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homePresenter.detachScreen();
    }

    @Override
    public void showWelcomeMessage(String message) {
        TextView tv = getActivity().findViewById(R.id.welcomeTextView);
        tv.setText(message);
    }
}
