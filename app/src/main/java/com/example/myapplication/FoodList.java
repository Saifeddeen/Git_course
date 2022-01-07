package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviderKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.Food;
import com.example.myapplication.OOP.FoodListAdapter;
import com.example.myapplication.databinding.ActivityMainBinding;

public class FoodList extends AppCompatActivity {

    private Activity DataBindingUtil;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        recyclerView = findViewById(R.id.flRecycler);

        FoodListAdapter adapter = new FoodListAdapter(AppMethodsData.getFood());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}