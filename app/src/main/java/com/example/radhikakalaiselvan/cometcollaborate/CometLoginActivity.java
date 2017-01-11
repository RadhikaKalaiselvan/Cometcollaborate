package com.example.radhikakalaiselvan.cometcollaborate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CometLoginActivity extends AppCompatActivity implements View.OnClickListener {

     private Button login;
    private EditText etEmail, etPass;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comet_login);
        db=new DBHelper(this);
        login=(Button)findViewById(R.id.btnLogin);
        etEmail=(EditText)findViewById(R.id.etemail);
        etPass=(EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        login();
    }

    private void login() {
        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();
        if(db.getUser(email,pass)){
            startActivity(new Intent(CometLoginActivity.this,MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Wrong email/password ! :( ", Toast.LENGTH_SHORT).show();
        }
    }
}
