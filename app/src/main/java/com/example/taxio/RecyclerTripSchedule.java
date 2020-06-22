package com.example.taxio;

import android.content.Intent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerTripSchedule extends RecyclerView.Adapter<RecyclerTripSchedule.ItemViewHolder> {
    //
    private ArrayList<TripData> tData = new ArrayList<>();

    class ItemViewHolder extends RecyclerView.ViewHolder { //subView setting
        TextView tripSchedule;
        TextView tripPosition;

        ItemViewHolder(View itemView) {
            super(itemView);

            tripSchedule = itemView.findViewById(R.id.tripSchedule);
            tripPosition = itemView.findViewById(R.id.tripPosition);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(v.getContext(), TripScheduleDetail.class);
                    //데이터 데려와야하나..?
                    v.getContext().startActivity(intent);
                }
            });
        }

        void onBind(TripData dataT) { //data setting
            tripSchedule.setText(dataT.getTripSchedule());
            tripPosition.setText(dataT.getTripPosition());
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_schedule_recycler, parent, false);
        //뭔 의미인지 사실 잘 모르는데 인플레이트함..함.. 죄송..
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(tData.get(position));
    }

    @Override
    public int getItemCount() {
        return tData.size();
    }

    void addItem(TripData data) {
        tData.add(data);
    }

}
