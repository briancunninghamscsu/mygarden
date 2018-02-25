package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class airtempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtemp);
        Intent intent = getIntent();
        //String value = intent.getStringExtra("key"); //if it's a string you stored.
    }
}

