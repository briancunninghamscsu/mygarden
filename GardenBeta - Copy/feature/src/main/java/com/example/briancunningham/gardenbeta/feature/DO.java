package com.example.briancunningham.gardenbeta.feature;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;

import java.util.Date;

import static java.lang.String.valueOf;

public class DO extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        //Log.d("consoleprinting", "got to line 31");

        ScrollView sv = (ScrollView) findViewById(R.id.scrviewdo) ;
        LinearLayout ll = (LinearLayout) findViewById(R.id.linlaydo);
        ll.setOrientation(LinearLayout.VERTICAL);


        // This is where and how the view is used

        MyAppApplication mApp = (MyAppApplication)getApplicationContext();
        int mrtesty = mApp.size();
        if (mrtesty!=0) {
            GraphView graph = (GraphView) findViewById(R.id.graph);

            int a = 1;
            int b = mApp.size();
            DataPoint[] values = new DataPoint[b];
            for (a = 0; a < b; a++) {
                // DataPoint graphbuff[] = new DataPoint(a,mApp.getDolevel(a));
                //series.appendData(graphbuff[a]);
                //series.appendData(graphbuff[a]);
                Log.d("consoleprinting", "DO LEVEL FROM ITEM " + a + " is " + mApp.getDolevel(a));

                Integer xi = (a);
                //String datestring = mApp.getDatapointdatetime(a);
                //Date xi = String.
                //Date xi = mApp.getDatapointdatetime(a);
                float yi = mApp.getDolevel(a);
                DataPoint v = new DataPoint(xi, yi);
                values[a] = v;

            }
            Log.d("consoleprinting", "exited the for loop");
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(values);
            Log.d("consoleprinting", "made new series");
            graph.addSeries(series);
            graph.getViewport().setScalable(true);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScalableY(true);
            graph.getViewport().setScrollableY(true);
            /*graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(19);
            graph.getViewport().setMaxX(29);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMinY(900);
            graph.getViewport().setMaxY(1200);*/
            //graph.getGridLabelRenderer().setNumVerticalLabels(1);
            graph.getGridLabelRenderer().setVerticalAxisTitle("Dissolved Oxygen in PPM");
            graph.getGridLabelRenderer().setHorizontalAxisTitle("Date/Time");


            // Graphing the Data Points
            // first, we need to make an array, as big as there are data points.
            String d;
            int c = mApp.size();
            /*TextView makeanicetable[] = new TextView[c];
            TableLayout tbles = findViewById(R.id.tbllaydo);
            TableRow tblerowA = new TableRow;
            tbles.add  */

            TableLayout tbllay = (TableLayout) findViewById(R.id.tbllaydo);

            final int N = 3; // total number of textviews to add

            final TextView[] datepoints = new TextView[c]; // create an empty array;
            final TextView[] measurepoints = new TextView[c]; // create an empty array;
            final TextView[] actionpoints = new TextView[c]; // create an empty array;

            for (int i = 0; i < c; i++) {

                final TableRow aNewTableRow = new TableRow(this);

                // create a new textview
                final TextView rowTextViewA = new TextView(this);
                final TextView rowTextViewB = new TextView(this);
                final TextView rowTextViewC = new TextView(this);



                // set some properties of rowTextView or something
                rowTextViewA.setText(mApp.getDatapointdatetime(i));
                rowTextViewA.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                String hamzilla = String.valueOf(mApp.getDolevel(i));
                hamzilla = hamzilla + " ppm";
                Log.d("dabug","it's setting hamzilla correctly");
                rowTextViewB.setText(hamzilla);
                rowTextViewB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                Log.d("dabug","it's setting rowTextViewB correctly");
                // rowTextViewB.setText(hamzilla);
                //rowTextViewC.setText(N);

                // add the textview to the linearlayout
                aNewTableRow.addView(rowTextViewA); // adding first column element to the new row
                aNewTableRow.addView(rowTextViewB); // adding the second column element to the new row
                aNewTableRow.addView(rowTextViewC); // adding the third column element to the new row
                tbllay.addView(aNewTableRow);   // adding the new row to the table layout

                // save a reference to the textview for later
                //datepoints[i] = rowTextViewA;
                //measurepoints[i] = rowTextViewB;
                //actionpoints[i] = rowTextViewC;

            }
        }
        else {
            TextView tv = new TextView(this);
            tv.setText("No Data Found!");
            ll.addView(tv);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_airtemp, menu);
        return true;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }}

