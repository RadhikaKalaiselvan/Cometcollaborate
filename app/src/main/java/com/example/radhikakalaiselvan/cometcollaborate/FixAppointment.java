package com.example.radhikakalaiselvan.cometcollaborate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FixAppointment extends android.app.Activity implements android.view.View.OnClickListener {

    Button fixAppntmt,cancelApt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_appointment);
        fixAppntmt=(Button)findViewById(R.id.btnSendapptReq);
        cancelApt=(Button)findViewById(R.id.btnCancelapptReq);
        fixAppntmt.setOnClickListener(this);
        cancelApt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendapptReq:
                int success = 1;
                //akshaya <code></code> Have to handle error page.
                if (success == 1) {
                    Intent intent = new Intent(this, SuccessLeaveReq.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), " Error while requesting leave :( ", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnCancelapptReq:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}
