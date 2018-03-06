package com.example.briancunningham.briansjavaarrays;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] aStopLightColors;
        aStopLightColors = new String[3];
        aStopLightColors[0] = new String("red");
        aStopLightColors[1] = new String("yellow");
        aStopLightColors[2] = new String("green");


        // Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        int numberofparameters = 3;
        int numberofsamples = 6;
        final String[][] myexampledata = new String[numberofsamples][numberofparameters];

        myexampledata[0][0] = "073";
        myexampledata[0][1] = "0543";
        myexampledata[0][2] = "053";


        TextView textView = (TextView) findViewById(R.id.mrtexty);
        textView.setTextSize(40);
        textView.setText(myexampledata[0][numberofparameters - 2]);
        final ConstraintLayout container = (ConstraintLayout) findViewById(R.id.mycontainer);
        Button butt1 = (Button) findViewById(R.id.button1);
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.mrtexty);
                Random r = new Random();
                int i1 = r.nextInt(80 - 65) + 65;
                textView.setText(String.valueOf(i1));

                //TextView mTextView = new TextView(); //Creating new TextView
                //mTextView.setText("damn daniel");    //Setting attributes
                //container.addView(mTextView);    //Adding it to the container

                //TextView dynamicTextView;
                //dynamicTextView = new TextView(this);
                //dynamicTextView.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                //dynamicTextView.setText(" Hello World ");

                //Snackbar.make(view, "This opens a new screen to test the actuators.", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
            }
        });

    }
}