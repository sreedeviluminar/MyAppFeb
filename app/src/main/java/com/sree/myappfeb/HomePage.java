package com.sree.myappfeb;
import android.content.Intent;
import android.net.Network;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.asynccc.AsyncActivity;
import com.sree.myappfeb.basic.AlertDialogActivity;
import com.sree.myappfeb.basic.AutoCompleteTvActivity;
import com.sree.myappfeb.basic.CalendarActivity;
import com.sree.myappfeb.basic.CameraActivity;
import com.sree.myappfeb.basic.CheckActivity;
import com.sree.myappfeb.basic.ContextMenuEx;
import com.sree.myappfeb.basic.CustomGridViewww;
import com.sree.myappfeb.basic.CustomListView;
import com.sree.myappfeb.basic.CustomToastActivity;
import com.sree.myappfeb.basic.DatePickerActivity;
import com.sree.myappfeb.basic.ExpandableLVActivity;
import com.sree.myappfeb.basic.GalleryActivity;
import com.sree.myappfeb.basic.GridViewActivity;
import com.sree.myappfeb.basic.HorizontalScroll;
import com.sree.myappfeb.basic.MapsActivity;
import com.sree.myappfeb.basic.MediaActivity;
import com.sree.myappfeb.basic.NumberPickerActivity;
import com.sree.myappfeb.basic.OptionMenuEx;
import com.sree.myappfeb.basic.PopUpmenuEx;
import com.sree.myappfeb.basic.ProgressBarActivity;
import com.sree.myappfeb.basic.ProgressDialogActivity;
import com.sree.myappfeb.basic.RadioButtonActivity;
import com.sree.myappfeb.basic.RatingActivity;
import com.sree.myappfeb.basic.SearchViewEx;
import com.sree.myappfeb.basic.SeekBarActivity;
import com.sree.myappfeb.basic.SpinnerActivity;
import com.sree.myappfeb.basic.SubMenuEx;
import com.sree.myappfeb.basic.TabbbActivity;
import com.sree.myappfeb.basic.TimePickerActivity;
import com.sree.myappfeb.basic.TimePickerWithEditText;
import com.sree.myappfeb.basic.VerticalScrol;
import com.sree.myappfeb.basic.VideoActivity;
import com.sree.myappfeb.basic.WebViewActivity;
import com.sree.myappfeb.connectivitiesss.BluethoothActivity;
import com.sree.myappfeb.connectivitiesss.NetworkConnectivityActivity;
import com.sree.myappfeb.connectivitiesss.PhoneCallEx;
import com.sree.myappfeb.connectivitiesss.SMSActivity;
import com.sree.myappfeb.connectivitiesss.WiFiActivity;
import com.sree.myappfeb.designPatterns.MVP.MVPPattern;
import com.sree.myappfeb.fragment.FragmentExample;
import com.sree.myappfeb.integration.FacebookIntegration;
import com.sree.myappfeb.material.MainActivityRecycler;
import com.sree.myappfeb.materialcard.CardWithRecycler;
import com.sree.myappfeb.materialcard.MainActivitycard;
import com.sree.myappfeb.navigation.NavActivity;
import com.sree.myappfeb.notificationsss.BroadActivity;
import com.sree.myappfeb.notificationsss.NewService;
import com.sree.myappfeb.notificationsss.NotificationActivity;
import com.sree.myappfeb.notificationsss.ServiceActivity;
import com.sree.myappfeb.notificationsss.SimpleNotifi;
import com.sree.myappfeb.parseandprefference.JsonFrom2;
import com.sree.myappfeb.parseandprefference.LoginUsingShared;
import com.sree.myappfeb.parseandprefference.SimpleJson;
import com.sree.myappfeb.parseandprefference.XmlPullActivity;
import com.sree.myappfeb.storage.ExStorageActivity;
import com.sree.myappfeb.storage.InternalStorageActivity;
import com.sree.myappfeb.storage.SqliteWithoutOpenHelper;
import com.sree.myappfeb.storage.SqlitewithOpenHelper;
import com.sree.myappfeb.webserviceRetrofit.RetrofitMain;
import com.sree.myappfeb.webserviceVolley.JsonArrayParsingVolley;

public class HomePage extends AppCompatActivity {
    ImageView icon ;
    Animation animation,animation1;
    TextView tv;
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

        tv= (TextView)findViewById(R.id.hometext);
        animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        tv.setAnimation(animation1);


        Handler handler =new Handler();
     handler.postDelayed(new Runnable() {
         @Override
         public void run() {
                 Intent i = new Intent(getApplicationContext(), AsyncActivity.class);
                 startActivity(i);
         }
     },1000);
    }
}