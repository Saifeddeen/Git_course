package com.example.myapplication.OOP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class UserStatusAdapter extends RecyclerView.Adapter<UserStatusAdapter.UserstatusViewHolder> {

    private ArrayList<Record> statusList;

    public UserStatusAdapter(ArrayList status){
        this.statusList = status;
    }

    @NonNull
    @Override
    public UserStatusAdapter.UserstatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item, parent, false);
        return new UserStatusAdapter.UserstatusViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserStatusAdapter.UserstatusViewHolder holder, int position) {

        holder.orDate.setText(this.statusList.get(position).getDate().toString());
        holder.weight.setText(this.statusList.get(position).getWeight());
        holder.len.setText(this.statusList.get(position).getLength());
        holder.st.setText(this.statusList.get(position).status());

    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public void setFoodList(ArrayList<Record> statusList) {
        this.statusList = statusList;
        notifyDataSetChanged();
    }

    public class UserstatusViewHolder extends RecyclerView.ViewHolder {

        TextView orDate;
        TextView weight;
        TextView st;
        TextView len;

        public UserstatusViewHolder(@NonNull View itemView) {
            super(itemView);
            this.orDate = itemView.findViewById(R.id.orDate);
            this.weight = itemView.findViewById(R.id.orWeight);
            this.st = itemView.findViewById(R.id.orStatus);
            this.len = itemView.findViewById(R.id.orLength);
        }
    }

}
