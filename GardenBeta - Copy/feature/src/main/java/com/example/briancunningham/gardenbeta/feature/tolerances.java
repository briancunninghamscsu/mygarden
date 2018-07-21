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
import android.widget.RadioButton;
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

                // title display
                final TextView uppertext = new TextView(this);
                uppertext.setText(getString(R.string.air_temp_above));
                uppertext.setTextSize(24);
                uppertext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext.setPadding(8,8,8,8);
                ll.addView(uppertext);

                // logic for displaying current upper bound settings
                final EditText upperbound = new EditText(this);
                upperbound.setHint(mApp.air_temp_upper_threshold +  getString(R.string.degreef));
                upperbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound.setTextSize(24);
                ll.addView(upperbound);

                //upper bound checkbox display logic
                final CheckBox air_temp_upper_checkbox = new CheckBox(this);
                air_temp_upper_checkbox.setText(getString(R.string.send_push));
                if (mApp.air_temp_upper_pushnotification==1){
                    air_temp_upper_checkbox.setChecked(true);
                }
                else{
                    air_temp_upper_checkbox.setChecked(false);
                }
                ll.addView(air_temp_upper_checkbox);

                // upper air temp extra fans on display code
                final CheckBox air_temp_upper_on_extra_fans = new CheckBox(this);
                ll.addView(air_temp_upper_on_extra_fans);
                air_temp_upper_on_extra_fans.setText(getString(R.string.turn_on_fans));
                if (mApp.air_temp_upper_turn_on_fans==1){
                    air_temp_upper_on_extra_fans.setChecked(true);
                    }
                else{
                    air_temp_upper_on_extra_fans.setChecked(false);
                }

                // upper air temp space heating off
                final CheckBox upper_air_temp_space_heating_checkbox = new CheckBox(this);
                ll.addView(upper_air_temp_space_heating_checkbox);
                upper_air_temp_space_heating_checkbox.setText(getString(R.string.turn_off_heating_element));
                if (mApp.air_temp_upper_turn_off_space_heater==1){
                    upper_air_temp_space_heating_checkbox.setChecked(true);
                }
                else{
                    upper_air_temp_space_heating_checkbox.setChecked(false);
                }

                //upper air temp turn space heater off
                final CheckBox upper_air_temp_space_heater_off = new CheckBox(this);
                ll.addView(upper_air_temp_space_heater_off);
                upper_air_temp_space_heater_off.setText(getString(R.string.turn_off_space_heater));
                if(mApp.air_temp_upper_turn_off_space_heater==1){
                    upper_air_temp_space_heater_off.setChecked(true);
                }
                else {
                    upper_air_temp_space_heater_off.setChecked(false);
                }

                //lower threshold title
                final TextView belowtext = new TextView(this);
                belowtext.setText(getString(R.string.air_temp_below));
                belowtext.setTextSize(24);
                belowtext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext.setPadding(8,8,8,8);
                ll.addView(belowtext);

                // lower threshold edittext
                final EditText lowerbound = new EditText(this);
                lowerbound.setHint(mApp.air_temp_lower_threshold + getString(R.string.degreef));
                lowerbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound.setTextSize(24);
                ll.addView(lowerbound);

                // lower threshold push notification check box
                final CheckBox lower_threshold_push_notification_check_box = new CheckBox(this);
                lower_threshold_push_notification_check_box.setText(getString(R.string.send_push));
                ll.addView(lower_threshold_push_notification_check_box);
                if (mApp.air_temp_lower_threshold==1){
                    lower_threshold_push_notification_check_box.setChecked(true);
                }
                else {
                    lower_threshold_push_notification_check_box.setChecked(false);
                }

                // lower threshold turn off extra fans
                final CheckBox lower_threshold_turn_off_extra_fans_checkbox = new CheckBox(this);
                ll.addView(lower_threshold_turn_off_extra_fans_checkbox);
                lower_threshold_turn_off_extra_fans_checkbox.setText(getString(R.string.turn_off_fans));
                if (mApp.air_temp_lower_turn_off_fans==1) {
                    lower_threshold_turn_off_extra_fans_checkbox.setChecked(true);
                }
                else {
                    lower_threshold_turn_off_extra_fans_checkbox.setChecked(false);
                }

                // lower threshold turn on heating element
                final CheckBox air_temp_lower_turn_on_heating_element = new CheckBox(this);
                ll.addView(air_temp_lower_turn_on_heating_element);
                air_temp_lower_turn_on_heating_element.setText(getString(R.string.turn_on_heating_element));
                if (mApp.air_temp_lower_turn_on_heating_element==1){
                    air_temp_lower_turn_on_heating_element.setChecked(true);
                }
                else {
                    air_temp_lower_turn_on_heating_element.setChecked(false);
                }

                // lower threshold turn on space heater
                final CheckBox lower_threshold_turn_on_space_heater_check_box = new CheckBox(this);
                ll.addView(lower_threshold_turn_on_space_heater_check_box);
                lower_threshold_turn_on_space_heater_check_box.setText(getString(R.string.turn_on_space_heater));
                if (mApp.air_temp_lower_turn_on_space_heater==1){
                    lower_threshold_turn_on_space_heater_check_box.setChecked(true);
                }
                else{
                    lower_threshold_push_notification_check_box.setChecked(false);
                }



                // box for sending data to server
                final Button buttsoup = new Button(this);
                buttsoup.setText(getString(R.string.save_changes));
                ll.addView(buttsoup);
                break;

            case "Humidity":

                final TextView uppertext1 = new TextView(this);
                uppertext1.setText(getString(R.string.hum_above));
                uppertext1.setTextSize(24);
                uppertext1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext1.setPadding(8,8,8,8);
                ll.addView(uppertext1);

                final EditText upperbound1 = new EditText(this);
                upperbound1.setHint(getString(R.string.percentsign));
                upperbound1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound1.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound1.setTextSize(24);
                ll.addView(upperbound1);


                final CheckBox mrchecky1 = new CheckBox(this);
                mrchecky1.setText(getString(R.string.send_push));
                ll.addView(mrchecky1);

                final CheckBox mrcheckyA1 = new CheckBox(this);
                ll.addView(mrcheckyA1);
                mrcheckyA1.setText(getString(R.string.turn_on_fans));

                final CheckBox mrcheckyB1 = new CheckBox(this);
                ll.addView(mrcheckyB1);
                mrcheckyB1.setText(getString(R.string.turn_off_fogger));

                final CheckBox mscheckyC1 = new CheckBox(this);
                ll.addView(mscheckyC1);
                mscheckyC1.setText(getString(R.string.turn_on_space_heater));

                final TextView belowtext1 = new TextView(this);
                belowtext1.setText(getString(R.string.hum_below));
                belowtext1.setTextSize(24);
                belowtext1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext1.setPadding(8,8,8,8);
                ll.addView(belowtext1);

                final EditText lowerbound1 = new EditText(this);
                lowerbound1.setHint(getString(R.string.percentsign));
                lowerbound1.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound1.setTextSize(24);
                ll.addView(lowerbound1);

                final CheckBox mschecky1 = new CheckBox(this);
                mschecky1.setText(getString(R.string.send_push));
                ll.addView(mschecky1);

                final CheckBox mscheckyA1 = new CheckBox(this);
                ll.addView(mscheckyA1);
                mscheckyA1.setText(getString(R.string.turn_off_fans));

                final CheckBox mscheckyB1 = new CheckBox(this);
                ll.addView(mscheckyB1);
                mscheckyB1.setText(getString(R.string.turn_off_space_heater));

                final Button buttsoup1 = new Button(this);
                buttsoup1.setText(getString(R.string.save_changes));
                ll.addView(buttsoup1);

                break;
            case "TVOC":
                final TextView uppertext2 = new TextView(this);
                uppertext2.setText(getString(R.string.TVOC_above));
                uppertext2.setTextSize(24);
                uppertext2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext2.setPadding(8,8,8,8);
                ll.addView(uppertext2);

                final EditText upperbound2 = new EditText(this);
                upperbound2.setHint(getString(R.string.ppm));
                upperbound2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound2.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound2.setTextSize(24);
                ll.addView(upperbound2);

                final CheckBox mrchecky2 = new CheckBox(this);
                mrchecky2.setText(getString(R.string.send_push));
                ll.addView(mrchecky2);

                final TextView belowtext2 = new TextView(this);
                belowtext2.setText(getString(R.string.TVOC_below));
                belowtext2.setTextSize(24);
                belowtext2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext2.setPadding(8,8,8,8);
                ll.addView(belowtext2);

                final EditText lowerbound2 = new EditText(this);
                lowerbound2.setHint(getString(R.string.ppm));
                lowerbound2.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound2.setTextSize(24);
                ll.addView(lowerbound2);

                final CheckBox mschecky2 = new CheckBox(this);
                mschecky2.setText(getString(R.string.send_push));
                ll.addView(mschecky2);

                final Button buttsoup2 = new Button(this);
                buttsoup2.setText(getString(R.string.save_changes));
                ll.addView(buttsoup2);

                break;
            case "CO2":
                final TextView uppertext3 = new TextView(this);
                uppertext3.setText(getString(R.string.CO2_above));
                uppertext3.setTextSize(24);
                uppertext3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext3.setPadding(8,8,8,8);
                ll.addView(uppertext3);

                final EditText upperbound3 = new EditText(this);
                upperbound3.setHint(getString(R.string.ppm));
                upperbound3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound3.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound3.setTextSize(24);
                ll.addView(upperbound3);

                final CheckBox mrchecky3 = new CheckBox(this);
                mrchecky3.setText(getString(R.string.send_push));
                ll.addView(mrchecky3);

                final TextView belowtext3 = new TextView(this);
                belowtext3.setText(getString(R.string.CO2_below));
                belowtext3.setTextSize(24);
                belowtext3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext3.setPadding(8,8,8,8);
                ll.addView(belowtext3);

                final EditText lowerbound3 = new EditText(this);
                lowerbound3.setHint(getString(R.string.ppm));
                lowerbound3.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound3.setTextSize(24);
                ll.addView(lowerbound3);

                final CheckBox mschecky3 = new CheckBox(this);
                mschecky3.setText(getString(R.string.send_push));
                ll.addView(mschecky3);

                final Button buttsoup3 = new Button(this);
                buttsoup3.setText(getString(R.string.save_changes));
                ll.addView(buttsoup3);

                break;
            case "Solution Temperature":
                final TextView uppertext4 = new TextView(this);
                uppertext4.setText(getString(R.string.Sol_above));
                uppertext4.setTextSize(24);
                uppertext4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext4.setPadding(8,8,8,8);
                ll.addView(uppertext4);

                final EditText upperbound4 = new EditText(this);
                upperbound4.setHint(getString(R.string.degreef));
                upperbound4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound4.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound4.setTextSize(24);
                ll.addView(upperbound4);

                final CheckBox mrchecky4 = new CheckBox(this);
                mrchecky4.setText(getString(R.string.send_push));
                ll.addView(mrchecky4);

                final CheckBox mrchecky4b = new CheckBox(this);
                mrchecky4b.setText(getString(R.string.turn_off_space_heater));
                ll.addView(mrchecky4b);

                final CheckBox mrchecky4c = new CheckBox(this);
                mrchecky4c.setText(getString(R.string.turn_off_heating_element));
                ll.addView(mrchecky4c);

                final TextView belowtext4 = new TextView(this);
                belowtext4.setText(getString(R.string.Sol_below));
                belowtext4.setTextSize(24);
                belowtext4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext4.setPadding(8,8,8,8);
                ll.addView(belowtext4);

                final EditText lowerbound4 = new EditText(this);
                lowerbound4.setHint(getString(R.string.degreef));
                lowerbound4.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound4.setTextSize(24);
                ll.addView(lowerbound4);

                final CheckBox mschecky4 = new CheckBox(this);
                mschecky4.setText(getString(R.string.send_push));
                ll.addView(mschecky4);

                final CheckBox mrchecky4d = new CheckBox(this);
                mrchecky4d.setText(getString(R.string.turn_on_space_heater));
                ll.addView(mrchecky4d);

                final CheckBox mrchecky4e = new CheckBox(this);
                mrchecky4e.setText(getString(R.string.turn_on_heating_element));
                ll.addView(mrchecky4e);

                final Button buttsoup4 = new Button(this);
                buttsoup4.setText(getString(R.string.save_changes));
                ll.addView(buttsoup4);
                break;
            case "Total Dissolved Solids":
                final TextView uppertext5 = new TextView(this);
                uppertext5.setText(getString(R.string.tds_above));
                uppertext5.setTextSize(24);
                uppertext5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext5.setPadding(8,8,8,8);
                ll.addView(uppertext5);

                final EditText upperbound5 = new EditText(this);
                upperbound5.setHint(getString(R.string.ppm));
                upperbound5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound5.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound5.setTextSize(24);
                ll.addView(upperbound5);

                final CheckBox mrchecky5 = new CheckBox(this);
                mrchecky5.setText(getString(R.string.send_push));
                ll.addView(mrchecky5);

                final CheckBox mrchecky5b = new CheckBox(this);
                mrchecky5b.setText(getString(R.string.add_water));
                ll.addView(mrchecky5b);


                final TextView belowtext5 = new TextView(this);
                belowtext5.setText(getString(R.string.tds_below));
                belowtext5.setTextSize(24);
                belowtext5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext5.setPadding(8,8,8,8);
                ll.addView(belowtext5);

                final EditText lowerbound5 = new EditText(this);
                lowerbound5.setHint(getString(R.string.ppm));
                lowerbound5.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound5.setTextSize(24);
                ll.addView(lowerbound5);

                final CheckBox mschecky5 = new CheckBox(this);
                mschecky5.setText(getString(R.string.send_push));
                ll.addView(mschecky5);

                final CheckBox mrchecky5d = new CheckBox(this);
                mrchecky5d.setText(getString(R.string.add_florabloom));
                ll.addView(mrchecky5d);

                final CheckBox mrchecky5e = new CheckBox(this);
                mrchecky5e.setText(getString(R.string.add_floragro));
                ll.addView(mrchecky5e);

                final CheckBox mrchecky5f = new CheckBox(this);
                mrchecky5f.setText(getString(R.string.add_floramicro));
                ll.addView(mrchecky5f);

                final Button buttsoup5 = new Button(this);
                buttsoup5.setText(getString(R.string.save_changes));
                ll.addView(buttsoup5);
                break;

            case "Dissolved Oxygen":
                final TextView uppertext6 = new TextView(this);
                uppertext6.setText(getString(R.string.do_above));
                uppertext6.setTextSize(24);
                uppertext6.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext6.setPadding(8,8,8,8);
                ll.addView(uppertext6);

                final EditText upperbound6 = new EditText(this);
                upperbound6.setHint(getString(R.string.ppm));
                upperbound6.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound6.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound6.setTextSize(24);
                ll.addView(upperbound6);

                final CheckBox mrchecky6 = new CheckBox(this);
                mrchecky6.setText(getString(R.string.send_push));
                ll.addView(mrchecky6);

                final CheckBox mrchecky6b = new CheckBox(this);
                mrchecky6b.setText(getString(R.string.add_water));
                ll.addView(mrchecky6b);


                final TextView belowtext6 = new TextView(this);
                belowtext6.setText(getString(R.string.do_below));
                belowtext6.setTextSize(24);
                belowtext6.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext6.setPadding(8,8,8,8);
                ll.addView(belowtext6);

                final EditText lowerbound6 = new EditText(this);
                lowerbound6.setHint(getString(R.string.ppm));
                lowerbound6.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound6.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound6.setTextSize(24);
                ll.addView(lowerbound6);

                final CheckBox mschecky6 = new CheckBox(this);
                mschecky6.setText(getString(R.string.send_push));
                ll.addView(mschecky6);

                final CheckBox mrchecky6d = new CheckBox(this);
                mrchecky6d.setText(getString(R.string.add_hypochloric));
                ll.addView(mrchecky6d);

                final CheckBox mrchecky6e = new CheckBox(this);
                mrchecky6e.setText(getString(R.string.add_peroxide));
                ll.addView(mrchecky6e);

                final Button buttsoup6 = new Button(this);
                buttsoup6.setText(getString(R.string.save_changes));
                ll.addView(buttsoup6);
                break;

            case "Oxidation-Reduction Potential":
                final TextView uppertext7 = new TextView(this);
                uppertext7.setText(getString(R.string.orp_above));
                uppertext7.setTextSize(24);
                uppertext7.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext7.setPadding(8,8,8,8);
                ll.addView(uppertext7);

                final EditText upperbound7 = new EditText(this);
                upperbound7.setHint(getString(R.string.ppm));
                upperbound7.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound7.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound7.setTextSize(24);
                ll.addView(upperbound7);

                final CheckBox mrchecky7 = new CheckBox(this);
                mrchecky7.setText(getString(R.string.send_push));
                ll.addView(mrchecky7);

                final CheckBox mrchecky7b = new CheckBox(this);
                mrchecky7b.setText(getString(R.string.add_water));
                ll.addView(mrchecky7b);


                final TextView belowtext7 = new TextView(this);
                belowtext7.setText(getString(R.string.orp_below));
                belowtext7.setTextSize(24);
                belowtext7.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext7.setPadding(8,8,8,8);
                ll.addView(belowtext7);

                final EditText lowerbound7 = new EditText(this);
                lowerbound7.setHint(getString(R.string.ppm));
                lowerbound7.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound7.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound7.setTextSize(24);
                ll.addView(lowerbound7);

                final CheckBox mschecky7 = new CheckBox(this);
                mschecky7.setText(getString(R.string.send_push));
                ll.addView(mschecky7);

                final CheckBox mrchecky7d = new CheckBox(this);
                mrchecky7d.setText(getString(R.string.add_peroxide));
                ll.addView(mrchecky7d);

                final CheckBox mrchecky7e = new CheckBox(this);
                mrchecky7e.setText(getString(R.string.add_hypochloric));
                ll.addView(mrchecky7e);

                final CheckBox mrchecky7f = new CheckBox(this);
                mrchecky7f.setText(getString(R.string.add_base));
                ll.addView(mrchecky7f);

                final Button buttsoup7 = new Button(this);
                buttsoup7.setText(getString(R.string.save_changes));
                ll.addView(buttsoup7);
                break;

            case "pH":
                final TextView uppertext8 = new TextView(this);
                uppertext8.setText(getString(R.string.pH_above));
                uppertext8.setTextSize(24);
                uppertext8.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext8.setPadding(8,8,8,8);
                ll.addView(uppertext8);

                final EditText upperbound8 = new EditText(this);
                upperbound8.setHint(getString(R.string.ppm));
                upperbound8.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound8.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound8.setTextSize(24);
                ll.addView(upperbound8);

                final CheckBox mrchecky8 = new CheckBox(this);
                mrchecky8.setText(getString(R.string.send_push));
                ll.addView(mrchecky8);

                final CheckBox mrchecky8b = new CheckBox(this);
                mrchecky8b.setText(getString(R.string.add_acid));
                ll.addView(mrchecky8b);


                final TextView belowtext8 = new TextView(this);
                belowtext8.setText(getString(R.string.pH_below));
                belowtext8.setTextSize(24);
                belowtext8.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext8.setPadding(8,8,8,8);
                ll.addView(belowtext8);

                final EditText lowerbound8 = new EditText(this);
                lowerbound8.setHint(getString(R.string.ppm));
                lowerbound8.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound8.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound8.setTextSize(24);
                ll.addView(lowerbound8);

                final CheckBox mschecky8 = new CheckBox(this);
                mschecky8.setText(getString(R.string.send_push));
                ll.addView(mschecky8);

                final CheckBox mrchecky8d = new CheckBox(this);
                mrchecky8d.setText(getString(R.string.add_base));
                ll.addView(mrchecky8d);

                final Button buttsoup8 = new Button(this);
                buttsoup8.setText(getString(R.string.save_changes));
                ll.addView(buttsoup8);
                break;

            case "Reservoirs":
                final TextView uppertext9 = new TextView(this);
                uppertext9.setText(getString(R.string.reservoirs_low));
                uppertext9.setTextSize(24);
                uppertext9.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext9.setPadding(8,8,8,8);
                ll.addView(uppertext9);


                final CheckBox mrchecky10 = new CheckBox(this);
                mrchecky10.setText(getString(R.string.send_push));
                ll.addView(mrchecky10);

                final Button buttsoup9 = new Button(this);
                buttsoup9.setText(getString(R.string.save_changes));
                ll.addView(buttsoup9);
                break;

            case "Canopy Height":
                final TextView uppertext10 = new TextView(this);
                uppertext10.setText(getString(R.string.canopy_height_trigger));
                uppertext10.setTextSize(24);
                uppertext10.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext10.setPadding(8,8,8,8);
                ll.addView(uppertext10);

                final EditText lowerbound10 = new EditText(this);
                lowerbound10.setHint(getString(R.string.centimeters));
                lowerbound10.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound10.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound10.setTextSize(24);
                ll.addView(lowerbound10);

                final CheckBox mrchecky11 = new CheckBox(this);
                mrchecky11.setText(getString(R.string.send_push_once));
                ll.addView(mrchecky11);

                final Button buttsoup10 = new Button(this);
                buttsoup10.setText(getString(R.string.save_changes));
                ll.addView(buttsoup10);
                break;

            case "Light Height":
                final TextView uppertext12 = new TextView(this);
                uppertext12.setText(getString(R.string.light_height));
                uppertext12.setTextSize(24);
                uppertext12.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext12.setPadding(8,8,8,8);
                ll.addView(uppertext12);

                final EditText lowerbound11 = new EditText(this);
                lowerbound11.setHint(getString(R.string.centimeters));
                lowerbound11.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound11.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound11.setTextSize(24);
                ll.addView(lowerbound11);


                final CheckBox mrchecky12 = new CheckBox(this);
                mrchecky12.setText(getString(R.string.send_push_lights));
                ll.addView(mrchecky12);

                final Button buttsoup12 = new Button(this);
                buttsoup12.setText(getString(R.string.save_changes));
                ll.addView(buttsoup12);
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
