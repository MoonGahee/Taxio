package com.example.taxio;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerTripSchedule extends RecyclerView.Adapter<RecyclerTripSchedule.ItemViewHolder> {
    private ArrayList<String> tData = null;
    private ArrayList<String> pData = null;
    Context context;


    public void addItem(TripData data) {
    }

    @NonNull
    @Override
    public RecyclerTripSchedule.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerTripSchedule.ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
