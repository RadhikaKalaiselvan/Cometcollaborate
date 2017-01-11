package com.example.radhikakalaiselvan.cometcollaborate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RequestLeave extends AppCompatActivity implements android.view.View.OnClickListener {

    Button cancelButton;
    Button sendLeaveReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_leave);
        sendLeaveReq = (Button) findViewById(R.id.btnSendLeaveReq);
        cancelButton = (Button) findViewById(R.id.cancelReq);
        sendLeaveReq.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendLeaveReq:
                int success = 1;
                //akshaya <code></code> Have to handle error page.
                if (success == 1) {
                    Intent intent = new Intent(this, SuccessLeaveReq.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), " Error while requesting leave :( ", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.cancelReq:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}