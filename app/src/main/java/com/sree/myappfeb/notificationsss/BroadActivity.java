package com.sree.myappfeb.notificationsss;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sree.myappfeb.R;

public class BroadActivity extends Activity {
    TextView textview;
    Button button;
    IntentFilter intentfilter;
    int deviceStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        button = (Button)findViewById(R.id.button1);
        textview = (TextView)findViewById(R.id.textView1);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                BroadActivity.this.registerReceiver(broadcastreceiver,intentfilter);
            }
        });

    }

    private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            if(deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING){
                textview.setText("Battery Status = Charging ");
            }

            if(deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING){
                textview.setText("Battery Status = Discharging ");
            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL){
                textview.setText("Battery Status = Battery Full ");
            }

            if(deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN){
                textview.setText("Battery Status = Unknown ");
            }
            if (deviceStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING){
                textview.setText("Battery Status = Not Charging ");
            }

        }
    };

}