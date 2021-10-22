package com.sree.myappfeb.basic;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;

public class TimePickerActivity extends AppCompatActivity {
    TimePicker picker;
    Button btnGet;
    TextView tvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        tvw=(TextView)findViewById(R.id.textView1);
        picker=(TimePicker)findViewById(R.id.timePicker1);

        picker.setIs24HourView(true);
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;

                if (Build.VERSION.SDK_INT >= 23 ){
                      hour = picker.getHour();
                      minute = picker.getMinute();
                }
                else{
                    hour = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                tvw.setText("Selected Hour: "+ hour +":"+ minute+" "+am_pm);
            }
        });
    }
}