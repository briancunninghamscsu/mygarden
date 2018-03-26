package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class DeveloperOptions extends AppCompatActivity {

    //private CClient mClient;
    private ArrayList<verynicedatapoint> recordedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);


        Log.d("bootinup", "it got here");


        final ArrayList<verynicedatapoint> recordedData = getIntent().getParcelableArrayListExtra("passme");
        Log.d("bootinup","from the devoptions activity the listarray has " + recordedData.size());



        Button spoofbutton = (Button) findViewById(R.id.butt2);
        spoofbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordedData.add(new verynicedatapoint());
                Snackbar.make(view, "Spoofed Data. Quantity in ArrayList is " + recordedData.size() , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Button sendastringbutton = (Button) findViewById(R.id.butt1);
        sendastringbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You hopefully transmitted a string", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Button printbutton = (Button) findViewById(R.id.butt3);
        printbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d("stars","oh my that does sound convenient");
                for (int i=0; i<recordedData.size(); i++)
                {
                    String jerry = recordedData.get(i).getDatapointdatetime();
                    Log.d("stars","Array list item number " + i);
                    Log.d("stars",jerry);
                }

                Snackbar.make(view, "Check LogCat for the plug", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Write your code here

        Intent myIntent = new Intent(DeveloperOptions.this, ScrollingActivity.class);
        myIntent.putExtra("passme",recordedData);
        DeveloperOptions.this.startActivity(myIntent);

        super.onBackPressed();
    }


}
