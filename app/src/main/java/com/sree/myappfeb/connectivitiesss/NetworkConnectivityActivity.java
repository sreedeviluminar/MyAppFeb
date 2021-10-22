package com.sree.myappfeb.connectivitiesss;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;
import com.sree.myappfeb.basic.TabbbActivity;

public class NetworkConnectivityActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_connectivity);

        // Register Callback - Call this in your app start!
        CheckNetwork network = new CheckNetwork(getApplicationContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            network.registerNetworkCallback();
        }
    }
    public void checknetworkstate(View view) {
        if (Variables.isNetworkConnected){
            Toast.makeText(getApplicationContext(),
                    "Internet is connected", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),
                    "Internet is not connected", Toast.LENGTH_LONG).show();
        }

    }

}
class Variables {
    // Global variable used to store network state
    public static boolean isNetworkConnected = false;
}

class CheckNetwork{
    private final Context context;

    public CheckNetwork(Context context) {
        this.context = context;
    }
    // Network Check
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void registerNetworkCallback()
    {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback(){
                @Override
                public void onAvailable(Network network) {
                    Variables.isNetworkConnected = true; // Global Static Variable
                }
                @Override
                public void onLost(Network network) {
                    Variables.isNetworkConnected = false; // Global Static Variable
                }
            });

            Variables.isNetworkConnected = false;

        }catch (Exception e){
            Variables.isNetworkConnected = false;
        }
    }
}