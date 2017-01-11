package com.example.radhikakalaiselvan.cometcollaborate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Attendance extends AppCompatActivity implements android.view.View.OnClickListener{
    Spinner courseSpinner;
    Button btnPostAttnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        courseSpinner=(Spinner)findViewById(R.id.classsatnpinner);
        ArrayAdapter courseadp=ArrayAdapter.createFromResource(this,R.array.classes,android.R.layout.simple_spinner_item);
        courseSpinner.setAdapter(courseadp);
       btnPostAttnd= (Button) findViewById(R.id.btnattdnc);
        btnPostAttnd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //code has to be added to check secret code
        Intent intent = new Intent(this, SuccessLeaveReq.class);
        startActivity(intent);
    }
}
