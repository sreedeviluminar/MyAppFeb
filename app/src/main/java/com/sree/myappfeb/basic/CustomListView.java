package com.sree.myappfeb.basic;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;


public class CustomListView extends AppCompatActivity {

    ListView list;

    String[] maintitle ={"Title 1","Title 2", "Title 3","Title 4", "Title 5"};

    String[] subtitle ={"description 1","description 2","description 3","description 4","description 5"};

    Integer[] imgid={R.drawable.girl,R.drawable.girl,R.drawable.girl,R.drawable.girl, R.drawable.girl,};

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_list_view);



        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);

        list=(ListView)findViewById(R.id.list);

        list.setAdapter(adapter);





        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override

            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                // TODO Auto-generated method stub

                if(position == 0) {

                    //code specific to first list item

                    Toast.makeText(getApplicationContext(),"You are click  First Option ",Toast.LENGTH_SHORT).show();

                }



                else if(position == 1) {

                    //code specific to 2nd list item

                    Toast.makeText(getApplicationContext(),"You are click Second Option ",Toast.LENGTH_SHORT).show();

                }



                else if(position == 2) {



                    Toast.makeText(getApplicationContext(),"You are click Third Option ",Toast.LENGTH_SHORT).show();

                }

                else if(position == 3) {



                    Toast.makeText(getApplicationContext(),"You are click Forth Option ",Toast.LENGTH_SHORT).show();

                }

                else if(position == 4) {



                    Toast.makeText(getApplicationContext(),"You are click Fifth Option ",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}