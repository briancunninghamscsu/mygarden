package com.example.briancunningham.gardenbeta.feature;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DeveloperOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        final MyAppApplication mApp = (MyAppApplication)getApplicationContext();
        ArrayList<verynicedatapoint> recordedData = mApp.getRecordedData();

        Button makethirty = findViewById(R.id.butt4);
        makethirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                mApp.addavalue();
                Snackbar.make(view, " Quantity in ArrayList is " + mApp.size() , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });



        Button spoofbutton = findViewById(R.id.butt2);
        spoofbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApp.addavalue();
                Snackbar.make(view, "Spoofed Data. Quantity in ArrayList is " + mApp.size() , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Button sendastringbutton = findViewById(R.id.butt1);
        sendastringbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You hopefully transmitted a string", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Button printbutton = findViewById(R.id.butt3);
        printbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d("stars","oh my that does sound convenient");
                for (int i=0; i<mApp.size(); i++)
                {
                    Log.d("consoleprinting","Array list item number " + i + " has an air temp of " + mApp.getAirtemplevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an amb humidity of " + mApp.getAmbienthumiditylevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an canopy height of " + mApp.getCanopyheightlevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an co2 of " + mApp.getCanopyheightlevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an DO of " + mApp.getDolevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an Light Height of " + mApp.getLightheight(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an o2 of " + mApp.getO2level(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an orp temp of " + mApp.getOrplevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an pH of " + mApp.getPhlevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an reservoir state of " + mApp.getReservoirs(i));
                    Log.d("consoleprinting","Array list item number " + i + " has an solution temp of " + mApp.getSolutiontemplevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has a TDS level of " +  mApp.getTdslevel(i));
                    Log.d("consoleprinting","Array list item number " + i + " has a timestamp " + mApp.getDatapointdatetime(i));
                    }

                Snackbar.make(view, "Check LogCat for the Data Activity - tag 'consoleprinting'", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
