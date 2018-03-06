package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv1 = (TextView)findViewById(R.id.textView24); //puts xml-ID'd textview24 in a box
        TextView tvA = (TextView)findViewById(R.id.textView2); //puts xml-ID'd textview2 in a box

        // This block updates the header with updated real-time clock on startup.
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
        String formattedDate = "Last Updated at " + sdf.format(c);
        tv1.setText(formattedDate);


        tvA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "You pressed tvA", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                //myIntent.putExtra("key", value); //Optional parameters
                Intent myIntent = new Intent(ScrollingActivity.this, airtempActivity.class);
                ScrollingActivity.this.startActivity(myIntent);


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "You pressed tvA", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
                //myIntent.putExtra("key", value); //Optional parameters
                Intent myIntent = new Intent(ScrollingActivity.this, SettingsActivity.class);
                ScrollingActivity.this.startActivity(myIntent);


            }
        });



        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Intent myIntent2 = new Intent(ScrollingActivity.this, AppCompatPreferenceActivity.class);
                //ScrollingActivity.this.startActivity(myIntent2);



                //Snackbar.make(view, "This opens a new screen to test the actuators.", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
           // }
        //});
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

        //Snackbar.make(view, "asdasdasdasd", Snackbar.LENGTH_LONG)
        //    .setAction("Action", null).show();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
