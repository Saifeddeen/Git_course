package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.Record;

import java.time.LocalDate;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        if(AppMethodsData.getAuthUser() != null){
            EditText length = findViewById(R.id.nrLength);
            EditText weight = findViewById(R.id.nrWeight);
            EditText rDate = findViewById(R.id.nrDate);
            EditText time = findViewById(R.id.nrTime);

            Button incWeight = findViewById(R.id.nrInc1);
            Button incLength = findViewById(R.id.nrInc2);
            Button decWeight = findViewById(R.id.nrDec1);
            Button decLength = findViewById(R.id.nrDec2);

            Button save = findViewById(R.id.nrSave);


            incWeight.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int w = 20;
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
                    int w = 20;
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
                    int l = 120;
                    if(length.getText().toString().equalsIgnoreCase("") || length.getText().toString() == null){
                        l = 120;
                    }else { l = Integer.parseInt(length.getText().toString()); }

                    if(l < 250){
                        l++;
                        length.setText(l + "");
                    }
                }
            });

            decLength.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int l = 120;
                    if(length.getText().toString().equalsIgnoreCase("") || length.getText().toString() == null){
                        l = 120;
                    }else { l = Integer.parseInt(length.getText().toString()); }

                    if(l > 100){
                        l--;
                        length.setText(l + "");
                    }
                }
            });

            save.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int w = Integer.parseInt(weight.getText().toString());
                    int l = Integer.parseInt(length.getText().toString());
                    LocalDate d = LocalDate.parse(rDate.getText().toString());

                    Record newRecord = new Record(AppMethodsData.getAuthUser(), w, l, d);
                    AppMethodsData.getAuthUser().addRecord(newRecord);
                }
            });
        }
    }
}