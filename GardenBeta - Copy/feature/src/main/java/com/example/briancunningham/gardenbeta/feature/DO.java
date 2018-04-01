package com.example.briancunningham.gardenbeta.feature;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        ScrollView sv = (ScrollView) findViewById(R.id.scrviewdo) ;
        LinearLayout ll = (LinearLayout) findViewById(R.id.linlaydo);
        ll.setOrientation(LinearLayout.VERTICAL);


        // This is where and how the view is used

        MyAppApplication mApp = (MyAppApplication)getApplicationContext();
        int mrtesty = mApp.size();
        if (mrtesty!=0) {
            GraphView graph = (GraphView) findViewById(R.id.graph);

            int a=1;
            int b = mApp.size();
            DataPoint[] values = new DataPoint[b];
            for (a=0;a<b;a++)
            {
                    /*DataPoint graphbuff[a]  new DataPoint(a,mApp.getDolevel(a));
                    //series.appendData(graphbuff[a]);
                    series.appendData(graphbuff[a]);*/
                Log.d("consoleprinting", "DO LEVEL FROM ITEM " + a + " is " + mApp.getDolevel(a));

                Integer xi = (a);
                    float yi = mApp.getDolevel(a);
                    DataPoint v = new DataPoint(xi, yi);
                    values[a] = v;

            }
            Log.d("consoleprinting", "exited the for loop");
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(values);
            Log.d("consoleprinting", "made new series");
            graph.addSeries(series);

        }
        else {
            TextView tv = new TextView(this);
            tv.setText("No Data Found!");
            ll.addView(tv);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

