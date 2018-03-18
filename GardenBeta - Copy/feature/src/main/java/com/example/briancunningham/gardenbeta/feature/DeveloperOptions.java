package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeveloperOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        Button sendastringbutton = (Button) findViewById(R.id.button_send_string);
        sendastringbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You hopefully transmitted a string", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //myIntent.putExtra("key", value); //Optional parameters
                //Intent myIntent = new Intent(DeveloperOptions.this, DeveloperOptions.class);
                //DeveloperOptions.this.startActivity(myIntent);
            }
        });

    }}


