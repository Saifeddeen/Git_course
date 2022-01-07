package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.Food;

public class AddFoodDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_details);

        Context context = this.getApplicationContext();

        EditText name = findViewById(R.id.afName);
        String nameStr = name.getText().toString();

        Spinner categ = findViewById(R.id.afCateg);
        TextView selectedCateg = (TextView) categ.getSelectedView();
        String categStr = selectedCateg.getText().toString();

        EditText cal = findViewById(R.id.afCal);
        String calStr = cal.getText().toString();
        Integer calInt = 0;
        if(calStr.equals("") || calStr == null){
            Toast.makeText(context, "complete all fields!!!", Toast.LENGTH_LONG).show();
        }else{
            calInt = Integer.parseInt(calStr);
        }

        ImageView image = findViewById(R.id.afImage);

        Button returnBtn = findViewById(R.id.afReturnBtn);
        Button uploadPhoto = findViewById(R.id.afUploadPhoto);
        Button addFood = findViewById(R.id.afSave);

        returnBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFoodDetails.this, FoodList.class));
                finish();
            }
        });

        //image picker needs............................................................
        uploadPhoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        addFood.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(nameStr!=null && categStr!=null && Integer.parseInt(calStr) != 0){
                    Food newfood = new Food(nameStr, categStr, Integer.parseInt(calStr), image.toString());
                    AppMethodsData.addFood(newfood);
                    Toast.makeText(context, nameStr+" added successfully to "+categStr, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "failed to add new food!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}