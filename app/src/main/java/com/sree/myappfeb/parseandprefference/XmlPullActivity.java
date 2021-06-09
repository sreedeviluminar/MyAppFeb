package com.sree.myappfeb.parseandprefference;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class XmlPullActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_pull);

        try{
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            HashMap<String,String> user = new HashMap<>();

            ListView lv = (ListView) findViewById(R.id.user_list);

            InputStream istream = getAssets().open("userdetails.xml");

            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);

            parser.setInput(istream,null);
            String tag = "" , text = "";

            int event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){
                tag = parser.getName();

                switch (event){
                    case XmlPullParser.START_TAG:
                        if(tag.equals("user"))
                            user = new HashMap<>();
                        break;

                        case XmlPullParser.TEXT:
                        text=parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        switch (tag){
                            case "name": user.put("name",text);
                                break;
                            case "designation": user.put("designation",text);
                                break;
                            case "location": user.put("location",text);
                                break;
                            case "user":
                                if(user!=null)
                                    userList.add(user);
                                break;
                        }
                        break;
                }
                event = parser.next();
            }
            ListAdapter adapter = new SimpleAdapter(XmlPullActivity.this, userList,
                    R.layout.xmlpulllist,new String[]{"name","designation","location"},
                    new int[]{R.id.name, R.id.designation, R.id.location});
            lv.setAdapter(adapter);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}