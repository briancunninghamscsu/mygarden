package com.example.briancunningham.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView)findViewById(R.id.textView24); //puts xml-ID'd textview24 in a box

        // This block updates the header with updated real-time clock on startup.
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
        String formattedDate = sdf.format(c);
        tv1.setText(formattedDate);
    }


    //long date = System.currentTimeMillis();

    //SimpleDateFormat sdf = new getDateTimeInstance();
    //String dateString = sdf.format(date);
    //tv1.setText(sdf);

}
