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

public class EditFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        Context context = this.getApplicationContext();

        Food selFood = AppMethodsData.getSelectedFood();

        EditText name = findViewById(R.id.efName);
        name.setText(selFood.getName());

        Spinner categ = findViewById(R.id.efCateg);
        int position = this.getIndexSpinner(categ, selFood.getCategory());
        if(position != -1){
            categ.setSelection(position);
        }

        EditText cal = findViewById(R.id.efCal);
        cal.setText(selFood.getCalory());

        ImageView image = findViewById(R.id.efImage);

        Button returnBtn = findViewById(R.id.efReturnBtn);
        Button uploadPhoto = findViewById(R.id.efUploadBtn);
        Button addFood = findViewById(R.id.efSaveBtn);

        returnBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditFood.this, FoodList.class));
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
                String nameStr = name.getText().toString();

                TextView selectedCateg = (TextView) categ.getSelectedView();
                String categStr = selectedCateg.getText().toString();

                String calStr = cal.getText().toString();
                Integer calInt = 0;
                if(calStr.equals("") || calStr == null){
                    Toast.makeText(context, "complete all fields!!!", Toast.LENGTH_LONG).show();
                }else{
                    calInt = Integer.parseInt(calStr);
                }

                if(nameStr!=null && categStr!=null && Integer.parseInt(calStr) != 0){
                    Food newfood = new Food(nameStr, categStr, Integer.parseInt(calStr), image.toString());
                    AppMethodsData.addFood(newfood);
                    Toast.makeText(context, " edited successfully to ", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "failed to add new food!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //get spinner item position
    private int getIndexSpinner(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return -1;
    }
}