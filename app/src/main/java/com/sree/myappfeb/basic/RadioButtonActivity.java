package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sree.myappfeb.R;

public  class RadioButtonActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        radioGroup = (RadioGroup)findViewById(R.id.rg);
    }
    public void clickme(View view) {
        
        radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        String remark = radioButton.getText().toString();
        Toast.makeText(getApplicationContext(),"Your Remark is "+remark,
                Toast.LENGTH_LONG).show();
    }
}