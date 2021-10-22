package com.sree.myappfeb.basic;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.sree.myappfeb.R;

public class ProgressDialogActivity extends AppCompatActivity {
    Button b1;
    private ProgressDialog progress;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        b1 = (Button) findViewById(R.id.button2);
    }

    public void download(View view){

        progress = new ProgressDialog(ProgressDialogActivity.this);
        progress.setMax(100); // Progress Dialog Max Value
        progress.setMessage("DownLoading Music"); // Setting Message
        progress.setTitle("ProgressDialog"); // Setting Title
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // Progress Dialog Style Horizontal
        progress.show(); // Display Progress Dialog
        progress.setCancelable(false);

        Handler handle = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                progress.incrementProgressBy(2); // Incremented By Value 2
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while ( progress.getProgress() <=  progress.getMax()) {
                        Thread.sleep(2000);
                        handle.sendMessage(handle.obtainMessage());

                        if (progress.getProgress() == progress.getMax()) {
                            progress.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
