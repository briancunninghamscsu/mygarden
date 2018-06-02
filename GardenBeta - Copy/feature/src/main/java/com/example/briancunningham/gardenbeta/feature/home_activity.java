package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Objects;

public class home_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) { //startup block
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyAppApplication mApp = (MyAppApplication) getApplicationContext();

        TextView tvairtemp = findViewById(R.id.textView_airtemp);
        TextView tvambhum = findViewById(R.id.textView_ambhum);
        TextView tvco2 = findViewById(R.id.textView_co2);
        TextView tvcanhop = findViewById(R.id.textView_canhei);
        TextView tvdo = findViewById(R.id.textView_do);
        TextView tvLH = findViewById(R.id.textView_LH);
        TextView tvo2 = findViewById(R.id.textView_o2);
        TextView tvorp = findViewById(R.id.textView_orp);
        TextView tvph = findViewById(R.id.textView_ph);
        TextView tvtds = findViewById(R.id.textView_nuttds);
        TextView tvres = findViewById(R.id.textView_res);
        TextView tvslntemp = findViewById(R.id.textView_soltemp);

        // assigning java to xml assignments - tablerows for activity linking
        TableRow tblrowairtemp = findViewById(R.id.tblrow_airtemp);
        TableRow tblrowambhum = findViewById(R.id.tblrow_ambhum);
        TableRow tblrowco2 = findViewById(R.id.tblrow_co2);
        TableRow tblrowDO = findViewById(R.id.tblrow_DO);
        TableRow tblrowLH = findViewById(R.id.tblrow_lighei);
        TableRow tblrowo2 = findViewById(R.id.tblrow_o2);
        TableRow tblroworp = findViewById(R.id.tblrow_nutorp);
        TableRow tblrowph = findViewById(R.id.tblrow_ph);
        TableRow tblrowslntemp = findViewById(R.id.tblrow_slntemp);
        TableRow tblrowres = findViewById(R.id.tblrow_reservoirs);
        TableRow tblrowtds = findViewById(R.id.tblrow_nuttds);
        TableRow tblrowcanhei = findViewById(R.id.tblrow_canhei);

        // updating the main activity with the most recently-indexed array list
        int mrtesty = mApp.size();
        if (mApp.size() != 0) {

            String unit_adder = String.valueOf(mApp.getAirtemplevel(mrtesty - 1) + getString(R.string.degreef));
            tvairtemp.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getAmbienthumiditylevel(mrtesty - 1) + getString(R.string.percentsign));
            tvambhum.setText(String.valueOf(unit_adder));

            unit_adder = String.valueOf(mApp.getCanopyheightlevel(mrtesty - 1)) + getString(R.string.centimeters);
            tvcanhop.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getCo2level(mrtesty - 1) + getString(R.string.ppm));
            tvco2.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getDolevel(mrtesty - 1) + getString(R.string.ppm));
            tvdo.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getLightheight(mrtesty - 1)) + getString(R.string.centimeters);
            tvLH.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getO2level(mrtesty - 1)) + getString(R.string.ppm);
            tvo2.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getO2level(mrtesty - 1)) + getString(R.string.mv);
            tvorp.setText(unit_adder);

            tvph.setText(String.valueOf(mApp.getPhlevel(mrtesty - 1)));

            unit_adder = String.valueOf(mApp.getSolutiontemplevel(mrtesty - 1)) + getString(R.string.degreef);
            tvslntemp.setText(unit_adder);

            unit_adder = String.valueOf(mApp.getTdslevel(mrtesty - 1)) + getString(R.string.ppm);
            tvtds.setText(unit_adder);

            if (Objects.equals(String.valueOf(mApp.getReservoirs(mrtesty - 1)), "1")) {
                tvres.setText(getString(R.string.full));
            } else {
                tvres.setText(getString(R.string.notfull));
            }
        }

        // assigning listeners that link activities
        tblrowairtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Air Temperature");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowambhum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Humidity");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "TVOC");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowco2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "CO2");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowslntemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Solution Temperature");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowtds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Total Dissolved Solids");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Dissolved Oxygen");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblroworp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Oxidation-Reduction Potential");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "pH");
                home_activity.this.startActivity(myIntent);
            }
        });


        tblrowres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Reservoirs");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowcanhei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Canopy Height");
                home_activity.this.startActivity(myIntent);
            }
        });

        tblrowLH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(home_activity.this, data_activity.class);
                myIntent.putExtra("parameter_name", "Light Height");
                home_activity.this.startActivity(myIntent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home_activity.this, DeveloperOptions.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Snackbar.make(, "asdasdasdasd", Snackbar.LENGTH_LONG)
        //  .setAction("Action", null).show();

        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(home_activity.this, SettingsActivity.class);
            home_activity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.aboutmeid) {
            Intent myIntent = new Intent(home_activity.this, AboutActivity.class);
            home_activity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.firsttimesetupid) {
            Intent myIntent = new Intent(home_activity.this, FirstTimeSetup.class);
            home_activity.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Log.d("consoleprinting", "BRUH THIS CAME FROM onActivityResult");

                MyAppApplication mApp = (MyAppApplication) getApplicationContext();

                TextView tvairtemp = findViewById(R.id.textView_airtemp);
                TextView tvambhum = findViewById(R.id.textView_ambhum);
                TextView tvco2 = findViewById(R.id.textView_co2);
                TextView tvcanhop = findViewById(R.id.textView_canhei);
                TextView tvdo = findViewById(R.id.textView_do);
                TextView tvLH = findViewById(R.id.textView_LH);
                TextView tvo2 = findViewById(R.id.textView_o2);
                TextView tvorp = findViewById(R.id.textView_orp);
                TextView tvph = findViewById(R.id.textView_ph);
                TextView tvtds = findViewById(R.id.textView_nuttds);
                TextView tvres = findViewById(R.id.textView_res);
                TextView tvslntemp = findViewById(R.id.textView_soltemp);

                // assigning java to xml assignments - tablerows for activity linking
                /*TableRow tblrowairtemp = findViewById(R.id.tblrow_airtemp);
                TableRow tblrowambhum = findViewById(R.id.tblrow_ambhum);
                TableRow tblrowco2 = findViewById(R.id.tblrow_co2);
                TableRow tblrowDO = findViewById(R.id.tblrow_DO);
                TableRow tblrowLH = findViewById(R.id.tblrow_lighei);
                TableRow tblrowo2 = findViewById(R.id.tblrow_o2);
                TableRow tblroworp = findViewById(R.id.tblrow_nutorp);
                TableRow tblrowph = findViewById(R.id.tblrow_ph);
                TableRow tblrowslntemp = findViewById(R.id.tblrow_slntemp);
                TableRow tblrowres = findViewById(R.id.tblrow_reservoirs);
                TableRow tblrowtds = findViewById(R.id.tblrow_nuttds);
                TableRow tblrowcanhei = findViewById(R.id.tblrow_canhei);*/


                // updating the main activity with the most recently-indexed array list
                int mrtesty = mApp.size();
                if (mApp.size() != 0) {

                    String unit_adder = String.valueOf(mApp.getAirtemplevel(mrtesty - 1) + getString(R.string.degreef));
                    tvairtemp.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getAmbienthumiditylevel(mrtesty - 1) + getString(R.string.percentsign));
                    tvambhum.setText(String.valueOf(unit_adder));

                    unit_adder = String.valueOf(mApp.getCanopyheightlevel(mrtesty - 1)) + getString(R.string.centimeters);
                    tvcanhop.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getCo2level(mrtesty - 1) + getString(R.string.ppm));
                    tvco2.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getDolevel(mrtesty - 1) + getString(R.string.ppm));
                    tvdo.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getLightheight(mrtesty - 1)) + getString(R.string.centimeters);
                    tvLH.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getO2level(mrtesty - 1)) + getString(R.string.ppm);
                    tvo2.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getO2level(mrtesty - 1)) + getString(R.string.mv);
                    tvorp.setText(unit_adder);

                    tvph.setText(String.valueOf(mApp.getPhlevel(mrtesty - 1)));

                    unit_adder = String.valueOf(mApp.getSolutiontemplevel(mrtesty - 1)) + getString(R.string.degreef);
                    tvslntemp.setText(unit_adder);

                    unit_adder = String.valueOf(mApp.getTdslevel(mrtesty - 1)) + getString(R.string.ppm);
                    tvtds.setText(unit_adder);

                    if (Objects.equals(String.valueOf(mApp.getReservoirs(mrtesty - 1)), "1")) {
                        tvres.setText(getString(R.string.full));
                    } else {
                        tvres.setText(getString(R.string.notfull));
                    }
                }
            }
        }
    }
}