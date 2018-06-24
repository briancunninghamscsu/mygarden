package com.example.briancunningham.gardenbeta.feature;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class tolerances extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolerances);
        setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title


        MyAppApplication mApp = (MyAppApplication) getApplicationContext(); //get global variables
        LinearLayout ll = findViewById(R.id.linlaytolerances);
        ll.setOrientation(LinearLayout.VERTICAL);



        switch (getIntent().getStringExtra("parameter_name")) {
            case "Air Temperature":

                final TextView uppertext = new TextView(this);
                uppertext.setText(getString(R.string.air_temp_above));
                uppertext.setTextSize(24);
                uppertext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext.setPadding(8,8,8,8);
                ll.addView(uppertext);

                final EditText upperbound = new EditText(this);
                upperbound.setHint(getString(R.string.degreef));
                upperbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound.setTextSize(24);
                ll.addView(upperbound);


                final CheckBox mrchecky = new CheckBox(this);
                mrchecky.setText(getString(R.string.send_push));
                ll.addView(mrchecky);

                final CheckBox mrcheckyA = new CheckBox(this);
                ll.addView(mrcheckyA);
                mrcheckyA.setText(getString(R.string.turn_on_fans));

                final CheckBox mrcheckyB = new CheckBox(this);
                ll.addView(mrcheckyB);
                mrcheckyB.setText(getString(R.string.turn_off_heating_element));

                final CheckBox mrcheckyC = new CheckBox(this);
                ll.addView(mrcheckyC);
                mrcheckyC.setText(getString(R.string.turn_off_space_heater));

                final TextView belowtext = new TextView(this);
                belowtext.setText(getString(R.string.air_temp_below));
                belowtext.setTextSize(24);
                belowtext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext.setPadding(8,8,8,8);
                ll.addView(belowtext);

                final EditText lowerbound = new EditText(this);
                lowerbound.setHint(getString(R.string.degreef));
                lowerbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound.setTextSize(24);
                ll.addView(lowerbound);


            final CheckBox mschecky = new CheckBox(this);
            mschecky.setText(getString(R.string.send_push));
            ll.addView(mschecky);

            final CheckBox mscheckyA = new CheckBox(this);
            ll.addView(mscheckyA);
            mscheckyA.setText(getString(R.string.turn_off_fans));

            final CheckBox mscheckyB = new CheckBox(this);
            ll.addView(mscheckyB);
            mscheckyB.setText(getString(R.string.turn_on_heating_element));

            final CheckBox mscheckyC = new CheckBox(this);
            ll.addView(mscheckyC);
            mscheckyC.setText(getString(R.string.turn_on_space_heater));

            final Button buttsoup = new Button(this);
            buttsoup.setText(getString(R.string.save_changes));
            ll.addView(buttsoup);


                break;
            case "Humidity":
                //t2.setText(getString(R.string.hum_above));
                break;
            case "TVOC":
                //t2.setText(getString(R.string.TVOC_above));
                break;
            case "CO2":
                //t2.setText(getString(R.string.CO2_above));
                break;
            case "Solution Temperature":
                //t2.setText(getString(R.string.Sol_above));
                break;
            case "Total Dissolved Solids":
                //t2.setText(getString(R.string.tds_above));
                break;
            case "Dissolved Oxygen":
                //t2.setText(getString(R.string.do_above));
                break;
            case "Oxidation-Reduction Potential":
                //t2.setText(getString(R.string.orp_above));
                break;
            case "pH":
                //t2.setText(getString(R.string.air_temp_above));
                break;
            case "Reservoirs":
                //t2.setText(getString(R.string.air_temp_above));
                break;
            case "Canopy Height":
                //t2.setText(getString(R.string.air_temp_above));
                break;
            case "Light Height":
                //t2.setText(getString(R.string.air_temp_above));
                break;
            default:
        }
    }

    @Override
    public void onBackPressed() {
        Intent data = new Intent();
        data.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
        setResult(Activity.RESULT_OK, data);
        //super.onBackPressed();
        finish();
    }

}
