package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import org.w3c.dom.Text;

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

        // assigning java to the xml assignments - textboxes for updates
        TextView tvtimestamp = (TextView)findViewById(R.id.textView_timestamp);
        TextView tvairtemp = (TextView)findViewById(R.id.textView_airtemp);
        TextView tvambhum = (TextView) findViewById(R.id.textView_ambhum);
        TextView tvco2 = (TextView) findViewById(R.id.textView_co2);
        TextView tvcanhop = (TextView) findViewById(R.id.textView_canhei);
        TextView tvdo = (TextView) findViewById(R.id.textView_do);
        TextView tvLH = (TextView) findViewById(R.id.textView_LH);
        TextView tvo2 = (TextView) findViewById(R.id.textView_o2);
        TextView tvorp = (TextView) findViewById(R.id.textView_orp);
        TextView tvph = (TextView) findViewById(R.id.textView_ph);
        TextView tvtds = (TextView) findViewById(R.id.textView_nuttds);
        TextView tvres = (TextView) findViewById(R.id.textView_res);
        TextView tvslntemp = (TextView) findViewById(R.id.textView_soltemp);

        // assigning java to xml assignments - tablerows for activity linking
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
            tvtimestamp.setText("No Data Found!");
            tvairtemp.setText("NDF");
            tvairtemp.setTextColor(Color.RED);
            tvambhum.setText("NDF");
            tvambhum.setTextColor(Color.RED);
            tvcanhop.setText("NDF");
            tvcanhop.setTextColor(Color.RED);
            tvco2.setText("NDF");
            tvco2.setTextColor(Color.RED);
            tvdo.setText("NDF");
            tvdo.setTextColor(Color.RED);
            tvLH.setText("NDF");
            tvLH.setTextColor(Color.RED);
            tvo2.setText("NDF");
            tvo2.setTextColor(Color.RED);
            tvorp.setText("NDF");
            tvorp.setTextColor(Color.RED);
            tvph.setText("NDF");
            tvph.setTextColor(Color.RED);
            tvslntemp.setText("NDF");
            tvslntemp.setTextColor(Color.RED);
            tvtds.setText("NDF");
            tvtds.setTextColor(Color.RED);
            tvres.setText("NDF");
            tvres.setTextColor(Color.RED);
        }
        else {
            String stringybeans = mApp.getDatapointdatetime(mrtesty-1);
            tvtimestamp.setText(stringybeans);


            tvairtemp.setText(String.valueOf(mApp.getAirtemplevel(mrtesty-1)));
            tvambhum.setText(String.valueOf(mApp.getAmbienthumiditylevel(mrtesty-1)));
            tvcanhop.setText(String.valueOf(mApp.getCanopyheightlevel(mrtesty-1)));
            tvco2.setText(String.valueOf(mApp.getCo2level(mrtesty-1)));
            tvdo.setText(String.valueOf(mApp.getDolevel(mrtesty-1)));
            tvLH.setText(String.valueOf(mApp.getLightheight(mrtesty-1)));
            tvo2.setText(String.valueOf(mApp.getO2level(mrtesty-1)));
            tvorp.setText(String.valueOf(mApp.getOrplevel(mrtesty-1)));
            tvph.setText(String.valueOf(mApp.getPhlevel(mrtesty-1)));
            tvslntemp.setText(String.valueOf(mApp.getSolutiontemplevel(mrtesty-1)));
            tvtds.setText(String.valueOf(mApp.getTdslevel(mrtesty-1)));
            tvres.setText(String.valueOf(mApp.getReservoirs(mrtesty-1)));

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
