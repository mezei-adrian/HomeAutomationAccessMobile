package com.example.adrian.homeautomationaccessmobile.ui.control.item;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adrian.homeautomationaccessmobile.R;
import com.example.adrian.homeautomationaccessmobile.model.ControlItem;

public class ControlItemHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public final Button controlButton;
    public ControlItem mItem;

    public ControlItemHolder(View view) {
        super(view);
        mView = view;
        mIdView = view.findViewById(R.id.item_number);
        mContentView = view.findViewById(R.id.content);
        controlButton = view.findViewById(R.id.controlButton);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }
}