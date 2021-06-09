package com.sree.myappfeb;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.basic.AutoCompleteTvActivity;
import com.sree.myappfeb.basic.CheckActivity;

import com.sree.myappfeb.basic.CustomGridViewww;
import com.sree.myappfeb.basic.CustomListView;
import com.sree.myappfeb.basic.ExpandableLVActivity;
import com.sree.myappfeb.basic.GridViewActivity;
import com.sree.myappfeb.basic.ProgressBarActivity;
import com.sree.myappfeb.basic.RatingActivity;
import com.sree.myappfeb.basic.SearchViewEx;
import com.sree.myappfeb.basic.SecondPage;
import com.sree.myappfeb.basic.SeekBarActivity;
import com.sree.myappfeb.basic.SpinnerActivity;
import com.sree.myappfeb.designPatterns.MVC.MVCPatterns;
import com.sree.myappfeb.designPatterns.MVP.MVPPattern;
import com.sree.myappfeb.designPatterns.mvvmexample.MVVMPattern;
import com.sree.myappfeb.integration.FacebookIntegration;
import com.sree.myappfeb.webserviceRetrofit.RetrofitMain;
import com.sree.myappfeb.webserviceVolley.JsonArrayParsingVolley;


public class HomePage extends AppCompatActivity {
    ImageView icon ;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        icon=(ImageView)findViewById(R.id.icon) ;
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
        icon.setAnimation(animation);

     Handler handler =new Handler();
     handler.postDelayed(new Runnable() {
         @Override
         public void run() {
                 Intent i = new Intent(getApplicationContext(), SearchViewEx.class);
             startActivity(i);
         }
     },1000);
    }
}