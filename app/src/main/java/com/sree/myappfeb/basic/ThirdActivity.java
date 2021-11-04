package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sree.myappfeb.R;

public class ThirdActivity extends AppCompatActivity  {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv= (TextView) findViewById(R.id.tv);
        Intent i = getIntent();
        String data = i.getStringExtra("key");
        tv.setText(data);

    }

}