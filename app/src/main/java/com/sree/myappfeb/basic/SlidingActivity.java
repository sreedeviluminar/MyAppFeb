package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.os.Bundle;

import com.sree.myappfeb.R;

public class SlidingActivity extends AppCompatActivity {
        String[] nameArray = {"India", "USA", "Australia", "UK", "Italy", "Ireland", "Africa",
                "India", "USA", "Australia", "UK", "Italy", "Ireland", "Africa"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sliding);

            SlidingDrawer simpleSlidingDrawer1 = (SlidingDrawer) findViewById(R.id.simpleSlidingDrawer1);
            Button handleButton = (Button) findViewById(R.id.handle1);
            ListView simpleListView1 = (ListView) findViewById(R.id.simpleListView1);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,nameArray);
            simpleListView1.setAdapter(arrayAdapter);

            simpleSlidingDrawer1.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
                @Override
                public void onDrawerOpened() {
                    handleButton.setText("Close");
                }
            });
            simpleSlidingDrawer1.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
                @Override
                public void onDrawerClosed() {
                    handleButton.setText("Open");
                }
            });
        }
    }
