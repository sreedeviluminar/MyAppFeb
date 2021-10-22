package com.sree.myappfeb.parseandprefference;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class SimpleJson extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_json);

        String json_stu = getListData();

        try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();

            ListView listview = findViewById(R.id.students);

            JSONObject jsObj = new JSONObject(json_stu);

            JSONArray jsArray = jsObj.getJSONArray("Students");

            for (int i = 0 ; i < jsArray.length(); i++) {

                HashMap<String, String> stu = new HashMap<>();

                JSONObject obj = jsArray.getJSONObject(i);

                stu.put("name", obj.getString("name"));
                stu.put("Branch", obj.getString("Branch"));
                stu.put("institute", obj.getString("institute"));

                userList.add(stu);
            }

            ListAdapter simpleAdapter = new SimpleAdapter(SimpleJson.this,
                    userList, R.layout.jsonlistt, new String[]{"name", "Branch", "institute"},
                    new int[]{R.id.StudentName, R.id.Branch, R.id.institute});

            listview.setAdapter(simpleAdapter);

        } catch (JSONException ex) {
            Log.e("JsonParser ", "Exception", ex);
        }
    }

    private String getListData() {
        String json_stu1 = "{ \"Students\" :[" +

                "{\"name\":\"Akshay \"," +
                "\"Branch\":\"Computer Science\","+
                "\"institute\":\"IIT\"}" +

                ",{\"name\":\"Peter \"," +
                "\"Branch\":\"Civil\"," +
                "\"institute\":\" RIT\"}" +

                ",{\"name\":\"Alan \"," +
                "\"Branch\":\"Information Technology\"," +
                "\"institute\":\"IIT\"}" +

                ",{\"name\":\"Aswathy\"," +
                "\"Branch\":\"Mechanical\"," +
                "\"institute\":\" RIT\"}" +

                ",{\"name\":\"Eldho\"," +
                "\"Branch\":\"Textile\"," +
                "\"institute\":\" IIT\"}" +

                ",{\"name\":\"John\"," +
                "\"Branch\":\"Electrical\"," +
                "\"institute\":\" RIT\"}" +


                ",{\"name\":\"Arya\"," +
                "\"Branch\":\"Mechanical\"," +
                "\"institute\":\"NIT\"}" +

                "] }";
        return json_stu1;
    }
}
