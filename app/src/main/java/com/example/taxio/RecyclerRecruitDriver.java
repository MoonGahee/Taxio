package com.example.taxio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView; //ItemViewHolder와 ViewHolder의 차이?

import java.util.ArrayList;

public class RecyclerRecruitDriver extends RecyclerView.Adapter<RecyclerRecruitDriver.ItemViewHolder>{
    // 주석 체크만 한 경우 ViewHolder > itemViewHolder로 변경함
    private ArrayList<DriverData> dData = new ArrayList<>();

    public class ItemViewHolder extends RecyclerView.ViewHolder{ //
        TextView driverName;
        TextView infoDriver;
        TextView infoPrice;
        ImageView driverImg;
        TextView recruit;
        TextView sendMsg;

        ItemViewHolder(View itemView){ //
            super(itemView);

            //객체 생성
            driverName = itemView.findViewById(R.id.driverName);
            infoDriver = itemView.findViewById(R.id.infoDriver);
            infoPrice = itemView.findViewById(R.id.infoPrice);
            driverImg = itemView.findViewById(R.id.driverImg);
            recruit = itemView.findViewById(R.id.recruit);
            sendMsg = itemView.findViewById(R.id.sendMsg);
        }

        //값을 하나하나 보여주는 함수
        void onBind(DriverData dataD){
            driverName.setText(dataD.getDriverName());
            infoDriver.setText(dataD.getDriverInfo());
            infoPrice.setText(dataD.getDirverPrice());

        }

    }

    @NonNull
    @Override //view를 인플레이터함
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recruit_driver_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override // position에 맞추어 각 항목을 구성하기 위해서 호출함
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) { //
        holder.onBind(dData.get(position));
    }

    @Override
    public int getItemCount() { // recyclerview의 총 개수 반환
        return dData.size();
    }

    void addData(DriverData data){ // 1. RecruitDriver에서 호출 > 2. DriverData값을 가져와서 > 3. 이 곳에 DriverData를 추가
        dData.add(data);
    }
}