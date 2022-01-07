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

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {

    private ArrayList<Food> foodList;

    public FoodListAdapter(ArrayList<Food> food){
        this.foodList = food;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        holder.name.setText(this.foodList.get(position).getName());
        holder.category.setText(this.foodList.get(position).getCategory());
        holder.calory.setText(this.foodList.get(position).getCalory());
        //holder.photo.setImageResource(this.foodList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView category;
        TextView calory;
        ImageView photo;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.fName);
            this.category = itemView.findViewById(R.id.fCategory);
            this.calory = itemView.findViewById(R.id.fCal);
            this.photo = itemView.findViewById(R.id.foodImage);
        }
    }
}
