package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class data_activity extends AppCompatActivity {

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Log.d("consoleprinting", "BRUH THIS CAME FROM onActivityResult");
                setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title

            }
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setupActionBar();

        setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title
        TableLayout tbllay = findViewById(R.id.tbllay);
        LinearLayout ll = findViewById(R.id.linlaydo);
        ll.setOrientation(LinearLayout.VERTICAL);

        MyAppApplication mApp = (MyAppApplication) getApplicationContext(); //get global variables

        GraphView graph = findViewById(R.id.graph);

        if (mApp.size() != 0) {     // we don't want to do anything if there is no data to crash
            int a;
            String unit_placeholder = "";
            DataPoint[] values = new DataPoint[mApp.size()]; //make an array of DataPoints, used for graphing


            for (a = 0; a < mApp.size(); a++) { //setting up the x and y values for the graph.
                //implementing a case statement to do get the right graph, and to get the right units
                DataPoint v = new DataPoint(0, 0);
                switch (getIntent().getStringExtra("parameter_name")) {
                    case "Air Temperature":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getAirtemplevel(a));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Air Temperature " + getString(R.string.degreef));
                        //unit_placeholder = getString(R.string.degreef);

                        //updating header measurements with most recent (highest indexed) measurement
                        //String unit_suffix_adder = String.valueOf(mApp.getAirtemplevel(mApp.size() - 1));
                        //unit_suffix_adder = unit_suffix_adder + unit_placeholder;
                        TextView temperature_temp = findViewById(R.id.do_current_measurement);
                        temperature_temp.setText(String.valueOf(mApp.getAirtemplevel(mApp.size() - 1)) + getString(R.string.degreef));
                        TextView time_temp = findViewById(R.id.do_current_time);
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));
                        break;
                    case "Humidity":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getAmbienthumiditylevel(a));
                        unit_placeholder = getString(R.string.percentsign);
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Relative Humidity in %");
                        break;
                    case "TVOC":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("TVOC in PPM");
                        unit_placeholder = getString(R.string.ppm);
                        break;
                    case "Solution Temperature":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));
                        unit_placeholder = getString(R.string.degreef);
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Temperature in " + getString(R.string.degreef));
                        break;
                    case "Total Dissolved Solids":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getTdslevel(a));
                        unit_placeholder = getString(R.string.ppm);
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Total Dissolved Solids in PPM");
                        break;
                    case "Dissolved Oxygen":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getDolevel(a));
                        unit_placeholder = getString(R.string.ppm);
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Dissolved Oxygen in PPM");
                        break;
                    case "Oxidation-Reduction Potential":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getOrplevel(a));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("ORP in mV");
                        unit_placeholder = getString(R.string.mv);
                        break;
                    case "pH":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getPhlevel(a));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("pH");
                        unit_placeholder = getString(R.string.blank);
                        break;
                    case "Reservoirs":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), 0);
                        unit_placeholder = getString(R.string.blank);
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Tank Fullness");
                        break;
                    case "Canopy Height":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCanopyheightlevel(a));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Canopy Height in cm");
                        unit_placeholder = getString(R.string.centimeters);
                        break;
                    case "Light Height":
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getLightheight(a));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Light Height in cm");
                        unit_placeholder = getString(R.string.centimeters);
                        break;
                    default:
                }

                values[a] = v; //saving the datapoints into an array for graphing later.
            }

            //tying the graph from XML into the java
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(values); //put the datapoints into the array used for graphing
            graph.addSeries(series);

            //setting graph parameters
            graph.getViewport().setScalable(true);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScalableY(true);
            graph.getViewport().setScrollableY(true);
            graph.getGridLabelRenderer().setHorizontalAxisTitle("Date/Time");
            graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext())); // this line makes it display dates instead of numbers.



            for (int i = mApp.size() - 1; i >= 0; i--) {    // decrementing loop, so that it goes from most recent to oldest

                // creating new instances for each row and row-element
                final TableRow aNewTableRow = new TableRow(this);
                final TextView rowTextViewA = new TextView(this);
                final TextView rowTextViewB = new TextView(this);

                switch (getIntent().getStringExtra("parameter_name")) {
                    case "Air Temperature":
                        rowTextViewB.setText(String.valueOf(mApp.getAirtemplevel(i)));
                        break;
                    case "Humidity":
                        rowTextViewB.setText(String.valueOf(mApp.getAmbienthumiditylevel(i)));
                        break;
                    case "TVOC":
                        rowTextViewB.setText(String.valueOf(mApp.getCo2level(i)));
                        break;
                    case "Solution Temperature":
                        rowTextViewB.setText(String.valueOf(mApp.getSolutiontemplevel(i)));
                        break;
                    case "Total Dissolved Solids":
                        rowTextViewB.setText(String.valueOf(mApp.getTdslevel(i)));
                        break;
                    case "Dissolved Oxygen":
                        rowTextViewB.setText(String.valueOf(mApp.getDolevel(i)));
                        break;
                    case "Oxidation-Reduction Potential":
                        rowTextViewB.setText(String.valueOf(mApp.getOrplevel(i)));
                        break;
                    case "pH":
                        rowTextViewB.setText(String.valueOf(mApp.getPhlevel(i)));
                        break;
                    case "Reservoirs":
                        rowTextViewB.setText(String.valueOf(mApp.getReservoirs(i)));
                        break;
                    case "Canopy Height":
                        rowTextViewB.setText(String.valueOf(mApp.getCanopyheightlevel(i)));
                        break;
                    case "Light Height":
                        rowTextViewB.setText(String.valueOf(mApp.getLightheight(i)));
                        break;
                    default:

                }

                        // setting some properties of new TextViews
                        rowTextViewA.setText(mApp.getDatapointdatetime(i));
                        rowTextViewA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        rowTextViewA.setPadding(20, 0, 0, 0);
                        // String unit_suffix_adder = String.valueOf(mApp.getDolevel(i));

                        //unit_suffix_adder = unit_suffix_adder + unit_placeholder;
                        //rowTextViewB.setText(unit_suffix_adder);
                        rowTextViewB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        rowTextViewB.setPadding(0, 0, 0, 0);

                        aNewTableRow.addView(rowTextViewA); // adding first column element to the new row
                        aNewTableRow.addView(rowTextViewB); // adding the second column element to the new row
                        tbllay.addView(aNewTableRow);   // adding the new row to the table layout
                }


        }

        else{  // if there's no data to be found
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.learn) {
            Intent myIntent = new Intent(data_activity.this, learning_activity.class);
            myIntent.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
            data_activity.this.startActivityForResult(myIntent,1);
            return true;
        }
        if (id == R.id.tolerances_and_settings) {
            Intent myIntent = new Intent(data_activity.this, tolerances.class);
            myIntent.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
            data_activity.this.startActivityForResult(myIntent,1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
