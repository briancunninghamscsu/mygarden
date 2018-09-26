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
        graph.getViewport().setYAxisBoundsManual(true);


        TextView temperature_temp = findViewById(R.id.measurement_header);
        TextView time_temp = findViewById(R.id.time_header);

        if (mApp.size() != 0) {     // we don't want to do anything if there is no data to crash
            int a;
            DataPoint[] values = new DataPoint[mApp.size()]; //make an array of DataPoints, used for graphing


            for (a = 0; a < mApp.size(); a++) { //setting up the x and y values for the graph.
                //implementing a case statement to do get the right graph, and to get the right units
                DataPoint v = new DataPoint(0, 0);
                switch (getIntent().getStringExtra("parameter_name")) {
                    case "Air Temperature":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getAirtemplevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Air Temperature " + getString(R.string.degreef));

                        graph.getViewport().setMinY(-5);
                        graph.getViewport().setMaxY(130);
                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getAirtemplevel(mApp.size() - 1)), getString(R.string.degreef)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "Humidity":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getAmbienthumiditylevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Humidity %");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(100);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getAmbienthumiditylevel(mApp.size() - 1)), getString(R.string.percentsign)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;
                    case "TVOC":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("TVOC in PPM");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(100);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getCo2level(mApp.size() - 1)), getString(R.string.ppm)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "Solution Temperature":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Temperature in " + getString(R.string.degreef));
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Total Dissolved Solids in PPM");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(100);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getSolutiontemplevel(mApp.size() - 1)), getString(R.string.degreef)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "Total Dissolved Solids":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getTdslevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Total Dissolved Solids in PPM");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(1000);

                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getTdslevel(mApp.size() - 1)), getString(R.string.ppm)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "Dissolved Oxygen":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getDolevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Dissolved Oxygen in PPM");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(500);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getDolevel(mApp.size() - 1)), getString(R.string.ppm)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "Oxidation-Reduction Potential":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getOrplevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("ORP in mV");
                        graph.getViewport().setMinY(220);
                        graph.getViewport().setMaxY(500);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getOrplevel(mApp.size() - 1)), getString(R.string.mv)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "pH":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getPhlevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("pH");
                        graph.getViewport().setMinY(1);
                        graph.getViewport().setMaxY(14);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getPhlevel(mApp.size() - 1)), getString(R.string.blank)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    /*case "Reservoirs":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), 0);

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Tank Fullness");

                        break;*/

                    case "Canopy Height":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCanopyheightlevel(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Canopy Height in cm");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(100);

                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getCanopyheightlevel(mApp.size() - 1)), getString(R.string.centimeters)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                        break;

                    case "Light Height":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getLightheight(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("Light Height in cm");
                        graph.getViewport().setMinY(0);
                        graph.getViewport().setMaxY(100);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getLightheight(mApp.size() - 1)), getString(R.string.centimeters)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));

                    case "CO2":

                        // add the data point to the graph
                        v = new DataPoint(mApp.getDatapointinDateFormat(a), mApp.getCo2level(a));

                        // adjust the y-axis
                        graph.getGridLabelRenderer().setVerticalAxisTitle("CO2 Level in PPM");
                        graph.getViewport().setMinY(0.0);
                        graph.getViewport().setMaxY(100);


                        //update the header
                        temperature_temp.setText(getString(R.string.dubs,String.valueOf(mApp.getCo2level(mApp.size() - 1)), getString(R.string.ppm)));
                        time_temp.setText(mApp.getDatapointdatetime(mApp.size() - 1));



                        break;

                    default:
                }

                values[a] = v; //saving the data points into an array for graphing later.
            }

            //tying the graph from XML into the java
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(values); //put the data points into the array used for graphing
            graph.addSeries(series);




            //setting graph parameters
            graph.getViewport().setScalable(true);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScalableY(true);
            graph.getViewport().setScrollableY(true);

            /*graph.getGridLabelRenderer().setHorizontalAxisTitle("Date/Time");
            */ // this line makes it display dates instead of numbers.
            /*
            */


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
                        rowTextViewB.setText("okay for now");
                    case "CO2":
                        rowTextViewB.setText(String.valueOf(mApp.getCo2level(i)));
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

            graph.getGridLabelRenderer().setHorizontalAxisTitle("Date/Time");
            graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
            graph.getGridLabelRenderer().setNumHorizontalLabels(3);

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
