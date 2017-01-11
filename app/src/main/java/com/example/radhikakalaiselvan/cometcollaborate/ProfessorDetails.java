package com.example.radhikakalaiselvan.cometcollaborate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfessorDetails extends Activity implements android.view.View.OnClickListener {

    TextView tvView;
    TextView tvOffcTiming,tvLocation,tvBuilding;
    private Button apptmBtn,leaveBtn;
    String professorName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_details);

        tvView = (TextView) findViewById(R.id.tvView);
        tvOffcTiming = (TextView) findViewById(R.id.tvOffcTimeView);
        tvLocation= (TextView) findViewById(R.id.tvLocationView);
        apptmBtn=(Button)findViewById(R.id.btnappnt);
        leaveBtn=(Button)findViewById(R.id.btnleave);


        Intent intent = getIntent();

        String sName = intent.getStringExtra("schname");
        String pName = intent.getStringExtra("profname");
        professorName=pName;

        tvView.setText("Name : "+pName);
        //should call method in DBHelper for now hard coding the values
        tvLocation.setText("Location :ECSS 4.908A");
        tvOffcTiming.setText("Timings : 1.30pm - 4pm");


        apptmBtn.setOnClickListener(this);
leaveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
Intent intent=null;
       switch (v.getId()) {
           case R.id.btnappnt:
               intent = new Intent(this,FixAppointment.class);
               intent.putExtra("profname",professorName);
               startActivity(intent);
               break;
           case R.id.btnleave:
              intent = new Intent(this,RequestLeave.class);
               intent.putExtra("profname",professorName);
               startActivity(intent);
               break;
       }
    }
}
