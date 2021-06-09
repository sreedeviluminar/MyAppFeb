package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.sree.myappfeb.R;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    String districts[] = {"Ernakulam","Kottayam","Idukki","TVM","Kollam","Pathanamthitta"};
    int icons[] = {R.drawable.iconfeb,R.drawable.iconfeb,R.drawable.iconfeb,R.drawable.iconfeb,
                    R.drawable.iconfeb,R.drawable.iconfeb};
  Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),icons,districts);
        spinner.setAdapter(adapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),districts[position],Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}