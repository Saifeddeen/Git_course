package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.User;

import java.time.LocalDate;

public class CompleteReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_reg2);

        RadioGroup gender = findViewById(R.id.cregRadioGroup);
        EditText length = findViewById(R.id.cregLength);
        EditText weight = findViewById(R.id.cregWeight);
        EditText dob = findViewById(R.id.cregDob);

        Button incWeight = findViewById(R.id.cregInc1);
        Button incLength = findViewById(R.id.cregInc2);
        Button decWeight = findViewById(R.id.cregDec1);
        Button decLength = findViewById(R.id.cregDec2);

        Button save = findViewById(R.id.cregSave);


        incWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int w;
                if(weight.getText().toString().equalsIgnoreCase("") || weight.getText().toString() == null){
                    w = 20;
                }else { w = Integer.parseInt(weight.getText().toString()); }

                if(w < 500){
                    w--;
                    weight.setText(w + "");
                }
            }
        });

        decWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int w;
                if(weight.getText().toString().equalsIgnoreCase("") || weight.getText().toString() == null){
                    w = 20;
                }else { w = Integer.parseInt(weight.getText().toString()); }

                if(w > 20){
                    w--;
                    weight.setText(w + "");
                }
            }
        });

        incLength.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int l;
                if(length.getText().toString().equalsIgnoreCase("") || length.getText().toString() == null){
                    l = 20;
                }else { l = Integer.parseInt(length.getText().toString()); }

                if(l < 250){
                    l++;
                    weight.setText(l + "");
                }
            }
        });

        decLength.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int l;
                if(length.getText().toString().equalsIgnoreCase("") || length.getText().toString() == null){
                    l = 20;
                }else { l = Integer.parseInt(length.getText().toString()); }

                if(l > 100){
                    l--;
                    weight.setText(l + "");
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int w = Integer.parseInt(weight.getText().toString());
                int l = Integer.parseInt(length.getText().toString());
                LocalDate d = LocalDate.parse(dob.getText().toString());

                int radioButtonID = gender.getCheckedRadioButtonId();

                //note radio value here.....................................
                View radioButton = gender.findViewById(radioButtonID);
                String g = radioButton.toString();
                AppMethodsData.getAuthUser().completeInfo(g, w, l, d);
            }
        });

    }
}