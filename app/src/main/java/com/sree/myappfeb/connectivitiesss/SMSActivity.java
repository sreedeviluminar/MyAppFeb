package com.sree.myappfeb.connectivitiesss;
import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sree.myappfeb.R;

public class SMSActivity extends Activity {

        EditText phonenumber,message;
        Button send;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_s_m_s);
            send=findViewById(R.id.button);
            phonenumber=findViewById(R.id.editText);
            message=findViewById(R.id.editText2);
            send.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    String number=phonenumber.getText().toString();
                    String msg=message.getText().toString();
                    try {
                        SmsManager smsManager=SmsManager.getDefault();
                        smsManager.sendTextMessage(number,null,msg,null,null);
                        Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                    }catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Some fiels are Empty",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }