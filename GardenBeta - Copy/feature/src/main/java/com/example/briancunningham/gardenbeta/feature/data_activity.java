package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

public class data_activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title
        TableLayout tbllay = findViewById(R.id.tbllay);
        LinearLayout ll = findViewById(R.id.linlaydo);
        ll.setOrientation(LinearLayout.VERTICAL);

        MyAppApplication mApp = (MyAppApplication) getApplicationContext(); //get global variables

        if (mApp.size() != 0) {     // we don't want to do anything if there is no data to crash
            int a;
            String unit_placeholder = "";
            DataPoint[] values = new DataPoint[mApp.size()]; //make an array of DataPoints, used for graphing

            for (a = 0; a < mApp.size(); a++) { //setting up the x and y values for the graph.
                //implementing a case statement to do get the right graph, and to get the right units
                DataPoint v = new DataPoint(0,0);
                switch (getIntent().getStringExtra("parameter_name")){
                    case "Air Temperature":
                        v = new DataPoint (mApp.getDatapointinDateFormat(a), mApp.getAirtemplevel(a));
                        unit_placeholder=getString(R.string.degreef);
                        break;
                    case "Humidity":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getAmbienthumiditylevel(a));
                        unit_placeholder=getString(R.string.percentsign);
                        break;
                    case "TVOC":    //TODO:co2 change
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));
                        unit_placeholder=getString(R.string.ppm);
                        break;
                    case "Solution Temperature":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));
                        unit_placeholder=getString(R.string.degreef);
                        break;
                    case "Total Dissolved Solids":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getTdslevel(a));
                        unit_placeholder=getString(R.string.ppm);
                        break;
                    case "Dissolved Oxygen":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getDolevel(a));
                        unit_placeholder=getString(R.string.ppm);
                        break;
                    case "Oxidation-Reduction Potential":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getOrplevel(a));
                        unit_placeholder=getString(R.string.mv);
                        break;
                    case "pH":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getPhlevel(a));
                        unit_placeholder=getString(R.string.blank);
                        break;
                    case "Reservoirs":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), 0);
                        unit_placeholder=getString(R.string.blank);
                        break;
                    case "Canopy Height":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCanopyheightlevel(a));
                        unit_placeholder=getString(R.string.centimeters);
                        break;
                    case "Light Height":;
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getLightheight(a));
                        unit_placeholder=getString(R.string.centimeters);
                        break;
                    default:
                }

                values[a] = v; //saving the datapoints into an array for graphing later.
            }



            GraphView graph = findViewById(R.id.graph); //tying the graph from XML into the java
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(values); //put the datapoints into the array used for graphing
            graph.addSeries(series);

            //setting graph parameters
            graph.getViewport().setScalable(true);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScalableY(true);
            graph.getViewport().setScrollableY(true);
            graph.getGridLabelRenderer().setVerticalAxisTitle("Dissolved Oxygen in PPM");
            graph.getGridLabelRenderer().setHorizontalAxisTitle("Date/Time");
            graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext())); // this line makes it display dates instead of numbers.

            //making objects to display on the graph
            final TextView[] datepoints = new TextView[mApp.size()]; // create an empty array;
            final TextView[] measurepoints = new TextView[mApp.size()]; // create an empty array;
            final TextView[] actionpoints = new TextView[mApp.size()]; // create an empty array;

            for (int i = mApp.size() - 1; i >= 0; i--) {    // decrementing loop, so that it goes from most recent to oldest

            // creating new instances for each row and row-element
            final TableRow aNewTableRow = new TableRow(this);
            final TextView rowTextViewA = new TextView(this);
            final TextView rowTextViewB = new TextView(this);
            final TextView rowTextViewC = new TextView(this);

            // setting some properties of new TextViews
            rowTextViewA.setText(mApp.getDatapointdatetime(i));
            rowTextViewA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            rowTextViewA.setPadding(20, 0, 0, 0);
            String unit_suffix_adder = String.valueOf(mApp.getDolevel(i));

            unit_suffix_adder = unit_suffix_adder + unit_placeholder;
            rowTextViewB.setText(unit_suffix_adder);
            rowTextViewB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            rowTextViewB.setPadding(0, 0, 0, 0);

            rowTextViewC.setText(mApp.getAction(i));
            rowTextViewC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            rowTextViewC.setPadding(0, 0, 20, 0);
            rowTextViewC.setHeight(60);

            // add the textview to the linearlayout
            aNewTableRow.addView(rowTextViewA); // adding first column element to the new row
            aNewTableRow.addView(rowTextViewB); // adding the second column element to the new row
            aNewTableRow.addView(rowTextViewC); // adding the third column element to the new row
            tbllay.addView(aNewTableRow);   // adding the new row to the table layout

            }
            // this block updates the header measurements
            String unit_suffix_adder = String.valueOf(mApp.getDolevel(mApp.size() - 1));
            unit_suffix_adder = unit_suffix_adder + unit_placeholder;
            TextView nowtemp = findViewById(R.id.do_current_measurement);
            nowtemp.setText(unit_suffix_adder);
            TextView nowtime = findViewById(R.id.do_current_time);
            nowtime.setText(mApp.getDatapointdatetime(mApp.size() - 1));
        }

        else {  // if there's no data to be found
            TextView tv = new TextView(this);
            tv.setText(getResources().getString(R.string.no_data_found));
            ll.addView(tv);
            }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dating, menu);
        return true;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.learn) {
            Intent myIntent = new Intent(data_activity.this, learning_activity.class);
            data_activity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.tolerances_and_settings) {
            Intent myIntent = new Intent(data_activity.this, tolerances.class);
            data_activity.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
