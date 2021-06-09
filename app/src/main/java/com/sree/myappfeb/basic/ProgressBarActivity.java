package com.sree.myappfeb.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.sree.myappfeb.R;

public class ProgressBarActivity extends AppCompatActivity {
    int progress = 0;
    ProgressBar progressBar;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        b = (Button) findViewById(R.id.buttonprogress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressValue(progress);
                    }
                });

            }

    private void setProgressValue(int progress) {
        progressBar.setProgress(progress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }
}


