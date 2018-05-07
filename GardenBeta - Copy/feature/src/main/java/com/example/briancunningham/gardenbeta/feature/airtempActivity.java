package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class airtempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("consoleprinting", "got to line 22");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtemp);
        Intent intent = getIntent();
        setupActionBar();

        ScrollView sv = (ScrollView) findViewById(R.id.scrvw_airtemp) ;
        LinearLayout ll = (LinearLayout) findViewById(R.id.linlay_airtemp);
        ll.setOrientation(LinearLayout.VERTICAL);
        Log.d("dabug", "got to line 31");

        // This is where and how the view is used

        MyAppApplication mApp = (MyAppApplication)getApplicationContext();
        int mrtesty = mApp.size();
        if (mrtesty!=0) {
            GraphView graph2 = (GraphView) findViewById(R.id.graph2);

            int a=1;
            int b = mApp.size();
            DataPoint[] values2 = new DataPoint[b];
            for (a=0;a<b;a++)
            {
                    /*DataPoint graphbuff[a]  new DataPoint(a,mApp.getDolevel(a));
                    //series.appendData(graphbuff[a]);
                    series.appendData(graphbuff[a]);*/
                Log.d("dabug", "AIRTEMP LEVEL FROM ITEM " + a + " is " + mApp.getAirtemplevel(a));

                Integer xi = (a);
                //String datestring = mApp.getDatapointdatetime(a);
                //Date xi = String.
                //Date xi = mApp.getDatapointdatetime(a);
                float yi = mApp.getAirtemplevel(a);
                DataPoint v = new DataPoint(xi, yi);
                values2[a] = v;

            }
            Log.d("dabug", "exited the for loop");
            LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(values2);
            Log.d("dabug", "made new series");
            graph2.addSeries(series2);
            Log.d("dabug", "added the new series to the graph");
            graph2.getViewport().setScalable(true);
            graph2.getViewport().setScrollable(true);
            graph2.getViewport().setScalableY(true);
            graph2.getViewport().setScrollableY(true);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setMinX(19);
            graph2.getViewport().setMaxX(29);
            graph2.getViewport().setYAxisBoundsManual(true);
            graph2.getViewport().setMinY(900);
            graph2.getViewport().setMaxY(1200);
            //graph.getGridLabelRenderer().setNumVerticalLabels(1);
            graph2.getGridLabelRenderer().setVerticalAxisTitle("Air Temperature in Fahrenheit");
            graph2.getGridLabelRenderer().setHorizontalAxisTitle("Date/Time");


            // Graphing the Data Points
            // first, we need to make an array, as big as there are data points.
            String d;
            int c = mApp.size();
            TextView makeanicetable[] = new TextView[c];

            for (a=0;a<c;a++) {
                Log.d("consoleprinting", "got into the for loop, iteration " + a);
                d = mApp.getDatapointdatetime(a);
                // makeanicetable[1].setText("hehehe"); // this crashes the program??

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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Snackbar.make(, "asdasdasdasd", Snackbar.LENGTH_LONG)
        //  .setAction("Action", null).show();

        if (id == R.id.airtemplearn) {
            Intent myIntent = new Intent(airtempActivity.this, airtemplearn.class);
            airtempActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.airtemptolerances) {
            Intent myIntent = new Intent(airtempActivity.this, airtemptolerances.class);
            airtempActivity.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

