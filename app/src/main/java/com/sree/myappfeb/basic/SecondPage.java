package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sree.myappfeb.R;

public class SecondPage extends AppCompatActivity {

   EditText un,pw;
   int count = 3;
   TextView al,lb;
   Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        un=(EditText)findViewById(R.id.editText1);
        pw=(EditText)findViewById(R.id.editText2);
        al=(TextView)findViewById(R.id.no_ofatteleft);
        lb=(TextView)findViewById(R.id.loginblocked);
        login =(Button)findViewById(R.id.button);

    }
    public void login(View view) {
        if(un.getText().toString().equals("user") && pw.getText().toString().equals("admin")){

            Intent i = new Intent(getApplicationContext(), ThirdActivity.class);
            startActivity(i);

        }else {

            Toast.makeText(getApplicationContext(),"Username/PassWord is incorrect",Toast.LENGTH_LONG).show();

            al.setVisibility(view.VISIBLE);
            al.setTextColor(Color.RED);
            count--;
            al.setText(Integer.toString(count));

            if (count==0) {
                login.setEnabled(false);
                lb.setText("LOGIN BLOCKED");
                lb.setTextColor(Color.RED);
            }
        }
    }
}