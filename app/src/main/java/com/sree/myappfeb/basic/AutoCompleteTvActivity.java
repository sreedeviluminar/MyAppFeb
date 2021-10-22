package com.sree.myappfeb.basic;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;

public class AutoCompleteTvActivity extends AppCompatActivity {
    String[] Countries = { "India", "USA", "Australia", "UK", "Italy", "Ireland", "Africa" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_tv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Countries);

        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.ac_Country);

        actv.setThreshold(1);
        actv.setAdapter(adapter);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = (String)parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Selected Item: " +name,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}