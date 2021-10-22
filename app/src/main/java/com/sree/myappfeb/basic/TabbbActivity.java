package com.sree.myappfeb.basic;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import com.sree.myappfeb.R;

public class TabbbActivity extends TabActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbb);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // initiate TabHost
        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab

        spec = tabHost.newTabSpec("List"); // Create a new TabSpec using tab host
        spec.setIndicator("List"); // set the “List” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, ListViewWithCheckBoxActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        spec = tabHost.newTabSpec("Check"); // Create a new TabSpec using tab host
        spec.setIndicator("Check"); // set the “Check” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, SlidingActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Rating"); // Create a new TabSpec using tab host
        spec.setIndicator("Rating"); // set the “Rating” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, RatingActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);
        //set tab which one you want to open first time 0 or 1 or 2
        tabHost.setCurrentTab(1);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
