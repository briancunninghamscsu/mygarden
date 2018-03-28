package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ScrollingActivity extends AppCompatActivity {

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                //String strEditText = data.getStringExtra("editTextValue");
                //recordedData = getIntent().getParcelableArrayListExtra("passme2");
                //int j = recordedData.size();
                Log.d("consoleprinting", "BRUH THIS CAME FROM onActivityResult");
                //Log.d("consoleprinting","the amount of objects in the listarray is " + recordedData.size());
            }
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) { //startup block
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyAppApplication mApp = (MyAppApplication)getApplicationContext();

        // assigning java to the xml assignments
        TextView tv1 = (TextView)findViewById(R.id.textView24); // for the timestamp entry
        TextView tvC = (TextView)findViewById(R.id.textView3); //for ambient humidity menu
        TextView tvD = (TextView)findViewById(R.id.textView4);
        ImageView ivC = (ImageView)findViewById(R.id.imageView2);
        TextView tvE = (TextView)findViewById(R.id.textView5); // for O2 activity
        TextView tvF = (TextView)findViewById(R.id.textView6);
        ImageView ivE = (ImageView)findViewById(R.id.imageView3);
        TableRow tblrowairtemp = (TableRow) findViewById(R.id.tblrow_airtemp);
        TableRow tblrowambhum = (TableRow) findViewById(R.id.tblrow_ambhum);
        TableRow tblrowco2 = (TableRow) findViewById(R.id.tblrow_co2);
        TableRow tblrowDO = (TableRow) findViewById(R.id.tblrow_DO);
        TableRow tblrowLH = (TableRow) findViewById(R.id.tblrow_lighei);
        TableRow tblrowo2 = (TableRow) findViewById(R.id.tblrow_o2);
        TableRow tblroworp = (TableRow) findViewById(R.id.tblrow_nutorp);
        TableRow tblrowph = (TableRow) findViewById(R.id.tblrow_ph);
        TableRow tblrowslntemp = (TableRow) findViewById(R.id.tblrow_slntemp);
        TableRow tblrowres = (TableRow) findViewById(R.id.tblrow_reservoirs);
        TableRow tblrowtds = (TableRow) findViewById(R.id.tblrow_nuttds);
        TableRow tblrowcanhei = (TableRow) findViewById(R.id.tblrow_canhei);

        // updating the main activity with the most recently-indexed array list
        int mrtesty = mApp.size();
        if (mrtesty==0) {
            tv1.setText("No Data Found!");
            }
        else {
            String stringybeans = "Last Updated at " + mApp.getDatapointdatetime(mrtesty-1);
            tv1.setText(stringybeans);
        }


        // assigning listeners that link activities
        tblrowairtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent myIntent = new Intent(ScrollingActivity.this, airtempActivity.class);
               ScrollingActivity.this.startActivity(myIntent);
               }
            });

        tblrowambhum.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myIntent = new Intent(ScrollingActivity.this, ambienthumidity.class);
               ScrollingActivity.this.startActivity(myIntent);
               }
           });

        tblrowo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, o2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowco2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, co2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowslntemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, SolutionTemperatureMeasurements.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowtds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, tds.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, DO.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });


        tblroworp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, orp.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, pH.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });


        tblrowres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, reservoirs.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowcanhei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, CanopyHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        tblrowLH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, LightHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollingActivity.this, DeveloperOptions.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Snackbar.make(, "asdasdasdasd", Snackbar.LENGTH_LONG)
          //  .setAction("Action", null).show();

        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(ScrollingActivity.this, SettingsActivity.class);
            ScrollingActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.aboutmeid) {
            Intent myIntent = new Intent(ScrollingActivity.this, AboutActivity.class);
            ScrollingActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.firsttimesetupid) {
            Intent myIntent = new Intent(ScrollingActivity.this, FirstTimeSetup.class);
            ScrollingActivity.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
