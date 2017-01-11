package com.example.radhikakalaiselvan.cometcollaborate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;
import android.content.Intent;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, android.view.View.OnClickListener{

    Spinner professorSpinner;
    Spinner schoolNamesSpinner;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schoolNamesSpinner = (Spinner) findViewById(R.id.spinner);
        professorSpinner=(Spinner)findViewById(R.id.spinnerProf);
        ArrayAdapter schoolsAdp=ArrayAdapter.createFromResource(this,R.array.Schools_name,android.R.layout.simple_spinner_item);
        btnSearch = (Button) findViewById(R.id.button);
        btnSearch.setOnClickListener(this);

schoolNamesSpinner.setAdapter(schoolsAdp);
        ArrayAdapter professors = ArrayAdapter.createFromResource(this, R.array.EJS, android.R.layout.simple_spinner_item);
        professorSpinner.setAdapter(professors);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, ProfessorDetails.class);
        intent.putExtra("schname",schoolNamesSpinner.getSelectedItem().toString());
        intent.putExtra("profname",professorSpinner.getSelectedItem().toString());
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        parent.getItemAtPosition(pos);
        TextView myTextView=(TextView)view;
        String school= (String) myTextView.getText();

        if(pos==0){
                ArrayAdapter professors = ArrayAdapter.createFromResource(this, R.array.EJS, android.R.layout.simple_spinner_item);
                professorSpinner.setAdapter(professors);
            } else if (pos==1)
        {       ArrayAdapter professors = ArrayAdapter.createFromResource(this, R.array.AH, android.R.layout.simple_spinner_item);
                professorSpinner.setAdapter(professors);
            } else if (pos==3) {
                ArrayAdapter professors = ArrayAdapter.createFromResource(this, R.array.NSM, android.R.layout.simple_spinner_item);
                professorSpinner.setAdapter(professors);
            } else if(pos==2) {
                ArrayAdapter professors = ArrayAdapter.createFromResource(this, R.array.JSOM, android.R.layout.simple_spinner_item);
                professorSpinner.setAdapter(professors);
            }




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
