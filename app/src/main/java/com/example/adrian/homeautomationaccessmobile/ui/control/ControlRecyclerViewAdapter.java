package com.example.adrian.homeautomationaccessmobile.ui.control;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.homeautomationaccessmobile.R;
import com.example.adrian.homeautomationaccessmobile.model.ControlItem;
import com.example.adrian.homeautomationaccessmobile.ui.control.item.ControlItemHolder;

import java.util.List;

public class ControlRecyclerViewAdapter extends RecyclerView.Adapter<ControlItemHolder> {

    private List<ControlItem> controlItems;

    public ControlRecyclerViewAdapter(List<ControlItem> controlItems) {
        this.controlItems = controlItems;
    }

    @Override
    public ControlItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_control, parent, false);
        return new ControlItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final ControlItemHolder holder, int position) {
        holder.mItem = controlItems.get(position);
        holder.mIdView.setText(controlItems.get(position).getId());
        holder.mContentView.setText(controlItems.get(position).getContent());
        holder.controlButton.setText(controlItems.get(position).getButtonText());

        holder.controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO implement button click
            }
        });
    }

    public void addControlItems(List<ControlItem> items){
        controlItems.addAll(items);
    }

    @Override
    public int getItemCount() {
        return controlItems.size();
    }

}
