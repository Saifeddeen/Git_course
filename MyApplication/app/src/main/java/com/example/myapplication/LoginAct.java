package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.OOP.AppMethodsData;
import com.example.myapplication.OOP.User;

public class LoginAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        EditText email = findViewById(R.id.loginUname);
        String emailStr = email.getText().toString();

        EditText password = findViewById(R.id.loginPassword);
        String passStr = password.getText().toString();

        Button login = findViewById(R.id.loginBtn);

        TextView signup = findViewById(R.id.loginSignup);

        Context context = this.getApplicationContext();

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(AppMethodsData.login(emailStr, passStr) != null){
                    startActivity(new Intent(LoginAct.this, UserStatus.class));
                    finish();
                }else{
                    Toast.makeText(context, "wrong intered data!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAct.this, RigisterActivity.class));
                finish();
            }
        });

    }
}