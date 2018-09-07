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

import com.loopj.android.http.*;

import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;

@SuppressWarnings("ALL")
public class DeveloperOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        final MyAppApplication mApp = (MyAppApplication) getApplicationContext();
        MyLoopjTask myLoopjTask = new MyLoopjTask();


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

        Button airtempchangebutton = findViewById(R.id.button6);
        airtempchangebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApp.air_temp_upper_threshold=66;
                mApp.showusersettings();
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


        final Button usersettingsprintbutton = findViewById(R.id.button5);
        usersettingsprintbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApp.showusersettings();
                Log.d("usersettings","got to user settings");
                //Snackbar.make(view, " Quantity in ArrayList is " + mApp.size(), Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }});

        Button readbutton = findViewById(R.id.button2);
        readbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("july", read_file(mApp, "hello.txt"));
                Snackbar.make(view, " Quantity in ArrayList is " + mApp.size(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }});

        Button getdatafromserverbutton = findViewById(R.id.button4);
        getdatafromserverbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestParams params = new RequestParams();
                params.put("whatiwant", "testdata");
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://192.168.1.13/mygarden/api.php", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        Log.d("july", "got to onStart()");
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Log.d("july", "got to onSuccess()");
                        String test1 = response.toString();
                        Log.d("july", test1);
                        parsemystringplease a = new parsemystringplease(test1, mApp);
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        Log.d("july", "got to onRetry()");
                    }
                });
            }
        }
        );

        Button user_settings_button = findViewById(R.id.button7);
        user_settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("spock","you got to the on click listen");
                RequestParams params = new RequestParams();
                params.put("whatiwant", "pull_settings");
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://24.197.216.190/mygarden/api.php", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        Log.d("spock", "got to onStart()");
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Log.d("spock", "got to onSuccess()");
                        String test2 = response.toString();
                        Log.d("spock", test2);
                        parse_for_user_settings b = new parse_for_user_settings(test2, mApp);
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        Log.d("spock", "got to onRetry()");
                    }
                });
            }
        }
        );







        Button uploadbutton = findViewById(R.id.button3);
        uploadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MyLoopjTask myLoopjTask = new MyLoopjTask();
                // myLoopjTask.executeLoopjCall("dogs");
                InputStream myInputStream = new InputStream() {
                                                                  @Override
                                                                  public int read() { return 0;
                                                                  }
                                                              };
                RequestParams params = new RequestParams();
                params.put("secret_passwords", myInputStream, "hello.txt");

                params.put("whatiwant", "testdata");
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://24.197.216.190/mygarden/api.php", params, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        Log.d("july", "got to onStart()");
                    }

                        @Override
                        public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Log.d("july", "got to onSuccess()");
                        String test1 = response.toString();
                        Log.d("july", test1);
                    }

                        @Override
                        public void onRetry(int retryNo) {
                        Log.d("july", "got to onRetry()");
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
                            //Log.d("consoleprinting", "Array list item number " + i + " has an reservoir state of " + mApp.getReservoirs(i));
                            Log.d("consoleprinting", "Array list item number " + i + " has an solution temp of " + mApp.getSolutiontemplevel(i));
                            Log.d("consoleprinting", "Array list item number " + i + " has a TDS level of " + mApp.getTdslevel(i));
                            //Log.d("consoleprinting", "Array list item number " + i + " has a timestamp " + mApp.getDatapointdatetime(i));
                        }
                        Snackbar.make(view, "Check LogCat for the Data Activity - tag 'consoleprinting'", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
            });
        }


    @Override
        public void onBackPressed () {   //this only triggers for the phone back-button!
            Intent data = new Intent();
            data.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
            setResult(Activity.RESULT_OK, data);
            //super.onBackPressed();
            Log.d("doohoohoo", "got to the onbackpressed in the develoepr options function");
            finish();
    }
}

