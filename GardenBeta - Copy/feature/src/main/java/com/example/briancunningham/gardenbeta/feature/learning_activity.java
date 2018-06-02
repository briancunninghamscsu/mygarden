package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class learning_activity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity);

        TextView t2 = findViewById(R.id.textView10);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title

        switch (getIntent().getStringExtra("parameter_name")) {
            case "Air Temperature":
                t2.setText(Html.fromHtml(getResources().getString(R.string.learn_about_air_temp)));
                //t2.setText(getString(R.string.learn_about_air_temp));
                break;
            case "Humidity":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_humidity)));
                break;
            case "TVOC":    //TODO:co2 change
                t2.setText(Html.fromHtml(getString(R.string.learn_about_TVOC)));
                break;
            case "Solution Temperature":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_solution_temp)));
                break;
            case "Total Dissolved Solids":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_tds)));
                break;
            case "Dissolved Oxygen":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_dissolved_oxygen)));
                break;
            case "Oxidation-Reduction Potential":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_orp)));
                break;
            case "pH":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_pH)));
                break;
            case "Reservoirs":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_reservoirs)));
                break;
            case "Canopy Height":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_canopy)));
                break;
            case "Light Height":
                t2.setText(Html.fromHtml(getString(R.string.learn_about_light_height)));
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
