package com.sree.myappfeb.navigation;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.sree.myappfeb.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().setTitle("SETTINGS");
    }
}