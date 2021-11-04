package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sree.myappfeb.R;

public class ListViewActivity extends AppCompatActivity {

    ListView l;
    String tutorials[] = { "Algorithms", "Data Structures","Languages", "Interview Corner",
                "GATE", "ISRO CS", "UGC NET CS", "CS Subjects", "Web Technologies" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
         l = findViewById(R.id.list);
        ArrayAdapter arr= new ArrayAdapter(this, android.R.layout.simple_list_item_1, tutorials);
        l.setAdapter(arr);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),tutorials[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

}
