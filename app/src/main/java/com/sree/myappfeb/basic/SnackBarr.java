package com.sree.myappfeb.basic;


import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material
        .snackbar
        .Snackbar;
import com.sree.myappfeb.R;

public class SnackBarr extends AppCompatActivity {

    Button button;
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_barr);

        button = findViewById(R.id.button);
        layout = findViewById(R.id.layout);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Create a snackbar
                        Snackbar snackbar = Snackbar.make(layout, "Message is deleted", Snackbar.LENGTH_LONG).setAction("UNDO",

                                        // If the Undo button
                                        // is pressed, show
                                        // the message using Toast
                                new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(SnackBarr.this, "Undo Clicked", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                        snackbar.show();
                    }
                });
    }
}
