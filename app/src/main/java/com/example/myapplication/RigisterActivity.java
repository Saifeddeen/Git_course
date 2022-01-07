package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.User;

public class RigisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rigister);


        EditText name = findViewById(R.id.regName);
        EditText email = findViewById(R.id.regEmail);
        EditText password = findViewById(R.id.regPassword);
        EditText confirmation = findViewById(R.id.regPasswordConfirm);
        Button create = findViewById(R.id.regCreateBtn);

        TextView login = findViewById(R.id.regLogin);

        Context context = this.getApplicationContext();

        create.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                User user = AppMethodsData.register(name.toString(), email.toString(), password.toString(), confirmation.toString(), context);
                if(user != null){
                    startActivity(new Intent(RigisterActivity.this, LoginAct.class));
                    finish();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(RigisterActivity.this, LoginAct.class));
                finish();
            }
        });

    }
}