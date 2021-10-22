package com.sree.myappfeb.material;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sree.myappfeb.R;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityRecycler extends AppCompatActivity {

    // ArrayList for person names
    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Person 1",
            "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7",
            "Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13",
            "Person 14"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.person1,
            R.drawable.person2, R.drawable.person3, R.drawable.person4,
            R.drawable.person5, R.drawable.person6, R.drawable.person7,R.drawable.person1,
            R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5,
            R.drawable.person6, R.drawable.person7));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainrecycler);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a GridLayoutManager with 2 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapterRecycler customAdapter = new CustomAdapterRecycler(MainActivityRecycler.this, personNames,personImages);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}
