package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sree.myappfeb.R;

public class ExplicitIntent extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        et = (EditText) findViewById(R.id.editTextTextPersonName);
    }

    public void passdata(View view) {
        String data = et.getText().toString();
        Intent i = new Intent(getApplicationContext(),ThirdActivity.class);
        i.putExtra("key",data);
        startActivity(i);
    }
}