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
     //ArrayList<verynicedatapoint> recordedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        final MyAppApplication mApp = (MyAppApplication)getApplicationContext();
        ArrayList<verynicedatapoint> recordedData = mApp.getRecordedData();


        /*Log.d("bootinup", "it got here");


        final ArrayList<verynicedatapoint> recordedData = getIntent().getParcelableArrayListExtra("passme");
        Log.d("consoleprinting","from the devoptions activity the listarray has " + recordedData.size());
*/


        Button spoofbutton = (Button) findViewById(R.id.butt2);
        spoofbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApp.addavalue();
                Snackbar.make(view, "Spoofed Data. Quantity in ArrayList is " + mApp.size() , Snackbar.LENGTH_LONG)
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


/*
                    String jerry = recordedData.get(i).getDatapointdatetime();
                    Log.d("consoleprinting","Array list item number " + i + " has an air temp of " + recordedData.get(i).getAirtemplevel());
                    Log.d("consoleprinting","Array list item number " + i + " has an amb humidity of " + recordedData.get(i).getAmbienthumiditylevel());
                    Log.d("consoleprinting","Array list item number " + i + " has an canopy height of " + recordedData.get(i).getCanopyheightlevel());
                    Log.d("consoleprinting","Array list item number " + i + " has an co2 of " + recordedData.get(i).getCo2level());
                    Log.d("consoleprinting","Array list item number " + i + " has an DO of " + recordedData.get(i).getDolevel());
                    Log.d("consoleprinting","Array list item number " + i + " has an Light Height of " + recordedData.get(i).getLightheight());
                    Log.d("consoleprinting","Array list item number " + i + " has an o2 of " + recordedData.get(i).getO2level());
                    Log.d("consoleprinting","Array list item number " + i + " has an orp temp of " + recordedData.get(i).getOrplevel());
                    Log.d("consoleprinting","Array list item number " + i + " has an pH of " + recordedData.get(i).getPhlevel());
                    Log.d("consoleprinting","Array list item number " + i + " has an reservoir state of " + recordedData.get(i).getReservoirs());
                    Log.d("consoleprinting","Array list item number " + i + " has an solution temp of " + recordedData.get(i).getSolutiontemplevel());
                    Log.d("consoleprinting","Array list item number " + i + " has a TDS level of " + recordedData.get(i).getTdslevel());
                    Log.d("consoleprinting","Array list item number " + i + " has a timestamp " + recordedData.get(i).getDatapointdatetime());*/
                }

                Snackbar.make(view, "Check LogCat for the plug", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Write your code here
        Log.d("consoleprinting", "WENT INTO onBackPressed()");
       /* Intent intent = new Intent();
        intent.putParcelableArrayListExtra("passme2",recordedData);*/
        /*setResult(RESULT_OK, intent);*/
        finish();



        /*Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        returnIntent.putExtra("Uniqid", "from DevOptions");
        returnIntent.putParcelableArrayListExtra("passme",recordedData);
        DeveloperOptions.this.startActivity(returnIntent);
*/
       // super.onBackPressed();
    }


}
