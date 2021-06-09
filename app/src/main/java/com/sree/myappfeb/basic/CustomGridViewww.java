package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.sree.myappfeb.R;

import java.util.ArrayList;

public class CustomGridViewww extends AppCompatActivity {

    GridView simpleList;
    ArrayList iconList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_viewww);

        simpleList = (GridView) findViewById(R.id.simpleGridView);

        iconList.add(new Item("icon 1",R.drawable.iconfeb));
        iconList.add(new Item("icon 2",R.drawable.iconfeb));
        iconList.add(new Item("icon 3",R.drawable.iconfeb));
        iconList.add(new Item("icon 4",R.drawable.iconfeb));
        iconList.add(new Item("icon 5",R.drawable.iconfeb));
        iconList.add(new Item("icon 6",R.drawable.iconfeb));

        MyAdapter myAdapter=new MyAdapter(this,R.layout.grid_view_items,iconList);
        simpleList.setAdapter(myAdapter);

    }
}