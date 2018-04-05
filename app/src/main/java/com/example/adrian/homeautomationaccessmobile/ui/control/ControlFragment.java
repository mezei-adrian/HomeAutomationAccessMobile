package com.example.adrian.homeautomationaccessmobile.ui.control;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adrian.homeautomationaccessmobile.HomeAutomationAccessMobile;
import com.example.adrian.homeautomationaccessmobile.R;
import com.example.adrian.homeautomationaccessmobile.model.ControlItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ControlFragment extends Fragment implements ControlScreen{

    private String controlType;
    RecyclerView recyclerView;

    @Inject
    ControlPresenter controlPresenter;

    public ControlFragment() {
    }

    public static ControlFragment newInstance(int columnCount) {
        return new ControlFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        HomeAutomationAccessMobile.injector.inject(this);
        controlPresenter.attachScreen(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        controlType = getArguments().getString("controlType" );

        switch(controlType){
            case "GATES": getActivity().setTitle(R.string.screen_gates_title);
                break;

            case "CAMERAS": getActivity().setTitle(R.string.screen_cameras_title);
                break;

            case "WOLS": getActivity().setTitle(R.string.screen_wols_title);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control_list, container, false);

        if (view instanceof RecyclerView) {
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            controlPresenter.showControls(controlType);
            recyclerView.setAdapter(new ControlRecyclerViewAdapter(new ArrayList<ControlItem>()));
        }
        return view;
    }

    @Override
    public void showControls(List<ControlItem> controlItems) {
        recyclerView.setAdapter(new ControlRecyclerViewAdapter(controlItems));
    }

    @Override
    public void showNetworkError(String message) {
        // TODO
        /*if (swipeRefreshLayoutArtists != null) {
            swipeRefreshLayoutArtists.setRefreshing(false);
        }*/
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
