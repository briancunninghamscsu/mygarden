package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class DeveloperOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        final MyAppApplication mApp = (MyAppApplication) getApplicationContext();


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
                Snackbar.make(view, " Quantity in ArrayList is " + mApp.size(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        Button spoofbutton = findViewById(R.id.butt2);
        spoofbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApp.addavalue();
                Snackbar.make(view, "Spoofed Data. Quantity in ArrayList is " + mApp.size(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        Button txtbutton = findViewById(R.id.button);
        txtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fOut = openFileOutput("hello.txt", Context.MODE_PRIVATE);
                    Log.d("july", "made hello.txt");
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOut);
                    outputStreamWriter.write("apples bananas carrots durian eggplant\n\n");
                    outputStreamWriter.close();
                } catch (Exception e) {
                    Log.d("july", "went into make a text file catch block");


                    Snackbar.make(view, "catch block", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });


        Button readbutton = findViewById(R.id.button2);
        readbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("july",read_file(mApp,"hello.txt"));



               /* try {
                    FileInputStream fis = openFileInput("hello.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader bufferedReader = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                    Snackbar.make(view, line, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Log.d("july", line + " is the contents of line");
                } catch (Exception e) {
                    Log.d("july", "went into catch block");
                }*/

                //Snackbar.make(view, line, Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();

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
                for (int i = 0; i < mApp.size(); i++) {
                    Log.d("consoleprinting", "Array list item number " + i + " has an air temp of " + mApp.getAirtemplevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an amb humidity of " + mApp.getAmbienthumiditylevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an canopy height of " + mApp.getCanopyheightlevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an co2 of " + mApp.getCanopyheightlevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an DO of " + mApp.getDolevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an Light Height of " + mApp.getLightheight(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an o2 of " + mApp.getO2level(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an orp temp of " + mApp.getOrplevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an pH of " + mApp.getPhlevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an reservoir state of " + mApp.getReservoirs(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has an solution temp of " + mApp.getSolutiontemplevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has a TDS level of " + mApp.getTdslevel(i));
                    Log.d("consoleprinting", "Array list item number " + i + " has a timestamp " + mApp.getDatapointdatetime(i));
                }

                Snackbar.make(view, "Check LogCat for the Data Activity - tag 'consoleprinting'", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {   //this only triggers for the phone back-button!
        Intent data = new Intent();
        //data.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
        setResult(Activity.RESULT_OK, data);
        //super.onBackPressed();
        Log.d("doohoohoo", "got to the onbackpressed in the develoepr options function");
        finish();
    }


    public void writeFileOnInternalStorage(Context mcoContext, String sFileName, String sBody) {
        File file = new File(mcoContext.getFilesDir(), "mydir");
        if (!file.exists()) {
            file.mkdir();
        }

        try {
            File gpxfile = new File(file, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();

        } catch (Exception e) {

        }
    }


    public String read_file(Context context, String filename) {
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }

}