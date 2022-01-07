package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.FoodListAdapter;
import com.example.myapplication.OOP.UserStatusAdapter;

public class UserStatus extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_status);

        recyclerView = findViewById(R.id.usRecycler);

        UserStatusAdapter adapter = new UserStatusAdapter(AppMethodsData.getAuthUser().getRecords());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}