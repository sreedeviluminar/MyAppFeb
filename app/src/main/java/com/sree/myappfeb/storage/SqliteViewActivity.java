package com.sree.myappfeb.storage;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import com.sree.myappfeb.R;

public class SqliteViewActivity extends AppCompatActivity {

        SQLiteDatabase db;

        List<String> listItem = new ArrayList<String>();
        ListView listView;
        ArrayAdapter<String> adapter;
        String name, des;

        Cursor result;
        private static final String DB_NAME = "myDB.db";
        private static final String TABLE_NAME = "emp_details";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view);
            listView = (ListView) findViewById(R.id.listView1);
            Intent i = getIntent();
            name = i.getStringExtra("hello");

            db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

            if (name.isEmpty() || name.compareTo(" ") == 0) {
                result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            } else {
                result = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE NAME='" + name + "'", null);
            }
            if (result.moveToFirst()) {
                do {
                    String ID, NAME, DESIGNATION, CONTACT, AREA, CITY;
                    ID = result.getString(0);
                    NAME = result.getString(1);
                    DESIGNATION = result.getString(2);
                    CONTACT = result.getString(3);
                    AREA = result.getString(4);
                    CITY = result.getString(5);

                    String get = ID + " " + NAME + " " + DESIGNATION +
                            " " + CONTACT + " " + AREA + " " + CITY;
                    listItem.add(get);
                    adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, listItem);
                    listView.setAdapter(adapter);

                } while (result.moveToNext());
            }
            db.close();
        }

    }