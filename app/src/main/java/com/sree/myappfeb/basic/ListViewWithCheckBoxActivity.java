package com.sree.myappfeb.basic;


import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewWithCheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ListView listView;
    List<Versions> list = new ArrayList<>();

    VersionAdapter versionAdapter;

    String[] version = {"Aestro","Blender","CupCake","Donut","Eclair","Froyo","GingerBread","HoneyComb","IceCream Sandwich",
            "Jelly Bean","Kitkat","Lolipop","Marshmallow","Nought","Oreo"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_check_box);

        listView = findViewById(R.id.list_view);

        list = new ArrayList<>();

        list.add(new Versions("Aestro"));
        list.add(new Versions("Blender"));
        list.add(new Versions("CupCake"));
        list.add(new Versions("Donut"));
        list.add(new Versions("Eclair"));
        list.add(new Versions("Froyo"));
        list.add(new Versions("GingerBread"));
        list.add(new Versions("HoneyComb"));
        list.add(new Versions("IceCream Sandwich"));
        list.add(new Versions("Jelly Bean"));
        list.add(new Versions("Kitkat"));
        list.add(new Versions("Lolipop"));
        list.add(new Versions("Marshmallow"));
        list.add(new Versions("Nought"));
        list.add(new Versions("Oreo"));

        versionAdapter = new VersionAdapter(ListViewWithCheckBoxActivity.this,R.layout.item_row,list);
        listView.setAdapter(versionAdapter);

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        int position = listView.getPositionForView(compoundButton);

        if (position != ListView.INVALID_POSITION){

            Versions versions = list.get(position);
            versions.setSelected(b);

            Toast.makeText(this, "Selected : "+ versions.getVersion(), Toast.LENGTH_SHORT).show();
        }
    }
}