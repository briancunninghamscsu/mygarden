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
                uppertext.setPadding(8, 8, 8, 8);
                ll.addView(uppertext);

                // logic for displaying current upper bound settings
                final EditText upperbound = new EditText(this);
                upperbound.setHint(mApp.air_temp_upper_threshold + getString(R.string.degreef));
                upperbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound.setTextSize(24);
                ll.addView(upperbound);

                //upper bound checkbox display logic
                final CheckBox air_temp_upper_checkbox = new CheckBox(this);
                air_temp_upper_checkbox.setText(getString(R.string.send_push));
                if (mApp.air_temp_upper_pushnotification == 1) {
                    air_temp_upper_checkbox.setChecked(true);
                } else {
                    air_temp_upper_checkbox.setChecked(false);
                }
                ll.addView(air_temp_upper_checkbox);

                // upper air temp extra fans on display code
                final CheckBox air_temp_upper_on_extra_fans = new CheckBox(this);
                ll.addView(air_temp_upper_on_extra_fans);
                air_temp_upper_on_extra_fans.setText(getString(R.string.turn_on_fans));
                if (mApp.air_temp_upper_turn_on_fans == 1) {
                    air_temp_upper_on_extra_fans.setChecked(true);
                } else {
                    air_temp_upper_on_extra_fans.setChecked(false);
                }

                // upper air temp space heating off
                final CheckBox upper_air_temp_space_heating_checkbox = new CheckBox(this);
                ll.addView(upper_air_temp_space_heating_checkbox);
                upper_air_temp_space_heating_checkbox.setText(getString(R.string.turn_off_heating_element));
                if (mApp.air_temp_upper_turn_off_space_heater == 1) {
                    upper_air_temp_space_heating_checkbox.setChecked(true);
                } else {
                    upper_air_temp_space_heating_checkbox.setChecked(false);
                }

                //upper air temp turn space heater off
                final CheckBox upper_air_temp_space_heater_off = new CheckBox(this);
                ll.addView(upper_air_temp_space_heater_off);
                upper_air_temp_space_heater_off.setText(getString(R.string.turn_off_space_heater));
                if (mApp.air_temp_upper_turn_off_space_heater == 1) {
                    upper_air_temp_space_heater_off.setChecked(true);
                } else {
                    upper_air_temp_space_heater_off.setChecked(false);
                }

                //lower threshold title
                final TextView belowtext = new TextView(this);
                belowtext.setText(getString(R.string.air_temp_below));
                belowtext.setTextSize(24);
                belowtext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext.setPadding(8, 8, 8, 8);
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
                if (mApp.air_temp_lower_threshold == 1) {
                    lower_threshold_push_notification_check_box.setChecked(true);
                } else {
                    lower_threshold_push_notification_check_box.setChecked(false);
                }

                // lower threshold turn off extra fans
                final CheckBox lower_threshold_turn_off_extra_fans_checkbox = new CheckBox(this);
                ll.addView(lower_threshold_turn_off_extra_fans_checkbox);
                lower_threshold_turn_off_extra_fans_checkbox.setText(getString(R.string.turn_off_fans));
                if (mApp.air_temp_lower_turn_off_fans == 1) {
                    lower_threshold_turn_off_extra_fans_checkbox.setChecked(true);
                } else {
                    lower_threshold_turn_off_extra_fans_checkbox.setChecked(false);
                }

                // lower threshold turn on heating element
                final CheckBox air_temp_lower_turn_on_heating_element = new CheckBox(this);
                ll.addView(air_temp_lower_turn_on_heating_element);
                air_temp_lower_turn_on_heating_element.setText(getString(R.string.turn_on_heating_element));
                if (mApp.air_temp_lower_turn_on_heating_element == 1) {
                    air_temp_lower_turn_on_heating_element.setChecked(true);
                } else {
                    air_temp_lower_turn_on_heating_element.setChecked(false);
                }

                // lower threshold turn on space heater
                final CheckBox lower_threshold_turn_on_space_heater_check_box = new CheckBox(this);
                ll.addView(lower_threshold_turn_on_space_heater_check_box);
                lower_threshold_turn_on_space_heater_check_box.setText(getString(R.string.turn_on_space_heater));
                if (mApp.air_temp_lower_turn_on_space_heater == 1) {
                    lower_threshold_turn_on_space_heater_check_box.setChecked(true);
                } else {
                    lower_threshold_push_notification_check_box.setChecked(false);
                }

                // box for sending data to server
                final Button save_changes_box = new Button(this);
                save_changes_box.setText(getString(R.string.save_changes));
                ll.addView(save_changes_box);
                break;

            case "Humidity":

                // humidity title
                final TextView uppertext_humidity = new TextView(this);
                uppertext_humidity.setText(getString(R.string.hum_above));
                uppertext_humidity.setTextSize(24);
                uppertext_humidity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext_humidity.setPadding(8, 8, 8, 8);
                ll.addView(uppertext_humidity);

                // humidity upper threshold edit text
                final EditText upperbound_humidity = new EditText(this);
                upperbound_humidity.setHint(mApp.humidity_upper_threshold + getString(R.string.percentsign));
                upperbound_humidity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound_humidity.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound_humidity.setTextSize(24);
                ll.addView(upperbound_humidity);

                // push notification for upper humidity
                final CheckBox upper_humidity_push_nofitication_check_box = new CheckBox(this);
                upper_humidity_push_nofitication_check_box.setText(getString(R.string.send_push));
                ll.addView(upper_humidity_push_nofitication_check_box);
                if (mApp.humidity_upper_pushnotification == 1) {
                    upper_humidity_push_nofitication_check_box.setChecked(true);
                } else {
                    upper_humidity_push_nofitication_check_box.setChecked(false);
                }

                // upper humidity extra fans on
                final CheckBox upper_humidity_extra_fans_on = new CheckBox(this);
                ll.addView(upper_humidity_extra_fans_on);
                upper_humidity_extra_fans_on.setText(getString(R.string.turn_on_fans));
                if (mApp.humidity_upper_turn_on_extra_fans == 1) {
                    upper_humidity_extra_fans_on.setChecked(true);
                } else {
                    upper_humidity_extra_fans_on.setChecked(false);
                }

                // upper_humidity_turn_off_fogger
                final CheckBox upper_humidity_turn_off_fogger_check_box = new CheckBox(this);
                ll.addView(upper_humidity_turn_off_fogger_check_box);
                upper_humidity_turn_off_fogger_check_box.setText(getString(R.string.turn_off_fogger));
                if (mApp.humidity_upper_turn_off_fogger == 1) {
                    upper_humidity_turn_off_fogger_check_box.setChecked(true);
                } else {
                    upper_humidity_turn_off_fogger_check_box.setChecked(false);
                }

                // upper humidity turn on space heater
                final CheckBox upper_humidity_turn_on_space_heater_checkbox = new CheckBox(this);
                ll.addView(upper_humidity_turn_on_space_heater_checkbox);
                upper_humidity_turn_on_space_heater_checkbox.setText(getString(R.string.turn_on_space_heater));
                if (mApp.humidity_upper_turn_on_space_heater==1){
                    upper_humidity_turn_on_space_heater_checkbox.setChecked(true);
                }

                // lower humidity title
                final TextView lower_humidity_title = new TextView(this);
                lower_humidity_title.setText(getString(R.string.hum_below));
                lower_humidity_title.setTextSize(24);
                lower_humidity_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_humidity_title.setPadding(8,8,8,8);
                ll.addView(lower_humidity_title);

                // lower humidity threshold edit text
                final EditText lower_humidity_threshold_edit_text = new EditText(this);
                lower_humidity_threshold_edit_text.setHint(mApp.humidity_lower_threshold + getString(R.string.percentsign));
                lower_humidity_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                lower_humidity_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_humidity_threshold_edit_text.setTextSize(24);
                ll.addView(lower_humidity_threshold_edit_text);

                // lower humidity push notification check box
                final CheckBox low_humidity_push_notification_check_box = new CheckBox(this);
                low_humidity_push_notification_check_box.setText(getString(R.string.send_push));
                ll.addView(low_humidity_push_notification_check_box);
                if (mApp.humidity_lower_pushnotification==1){
                    low_humidity_push_notification_check_box.setChecked(true);
                }
                else
                {
                    low_humidity_push_notification_check_box.setChecked(false);
                }

                // low humidity turn off extra fans
                final CheckBox low_humidity_turn_off_extra_fans = new CheckBox(this);
                ll.addView(low_humidity_turn_off_extra_fans);
                low_humidity_turn_off_extra_fans.setText(getString(R.string.turn_off_fans));
                if (mApp.humidity_lower_turn_off_extra_fans==1){
                    low_humidity_turn_off_extra_fans.setChecked(true);
                }
                else {
                    low_humidity_turn_off_extra_fans.setChecked(false);
                }

                // low humidity turn off space heater
                final CheckBox low_humidty_turn_off_space_heater_checkbox = new CheckBox(this);
                ll.addView(low_humidty_turn_off_space_heater_checkbox);
                low_humidty_turn_off_space_heater_checkbox.setText(getString(R.string.turn_off_space_heater));
                if (mApp.humidity_lower_turn_off_space_heater==1){
                    low_humidity_turn_off_extra_fans.setChecked(true);
                }
                else{
                    low_humidity_turn_off_extra_fans.setChecked(false);
                }

                //  submit changes button
                final Button buttsoup1 = new Button(this);
                buttsoup1.setText(getString(R.string.save_changes));
                ll.addView(buttsoup1);
                break;

            case "TVOC":
                //TVOC upper title
                final TextView TVOC_title = new TextView(this);
                TVOC_title.setText(getString(R.string.TVOC_above));
                TVOC_title.setTextSize(24);
                TVOC_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                TVOC_title.setPadding(8,8,8,8);
                ll.addView(TVOC_title);

                // TVOC upper threshold edit text
                final EditText tvoc_upper_edit_text = new EditText(this);
                tvoc_upper_edit_text.setHint(getString(R.string.ppm));
                tvoc_upper_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tvoc_upper_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                tvoc_upper_edit_text.setTextSize(24);
                ll.addView(tvoc_upper_edit_text);

                // TVOC upper threshold push notifications
                final CheckBox tvoc_upper_threshold_push_nofitications = new CheckBox(this);
                tvoc_upper_threshold_push_nofitications.setText(getString(R.string.send_push));
                ll.addView(tvoc_upper_threshold_push_nofitications);
                if (mApp.humidity_upper_pushnotification==1){
                    tvoc_upper_threshold_push_nofitications.setChecked(true);
                }
                else{
                    tvoc_upper_threshold_push_nofitications.setChecked(false);
                }

                // TVOC lower threshold lower title
                final TextView belowtext2 = new TextView(this);
                belowtext2.setText(getString(R.string.TVOC_below));
                belowtext2.setTextSize(24);
                belowtext2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext2.setPadding(8,8,8,8);
                ll.addView(belowtext2);

                // TVOC lower threshold edit text
                final EditText tvoc_lower_threshold_edit_text = new EditText(this);
                tvoc_lower_threshold_edit_text.setHint(mApp.TVOC_lower_threshold + getString(R.string.ppm));
                tvoc_lower_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                tvoc_lower_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tvoc_lower_threshold_edit_text.setTextSize(24);
                ll.addView(tvoc_lower_threshold_edit_text);

                // TVOC lower push notification
                final CheckBox tvoc_lower_push_notification_checkbox = new CheckBox(this);
                tvoc_lower_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(tvoc_lower_push_notification_checkbox);
                if (mApp.TVOC_lower_pushnotification==1){
                    tvoc_lower_push_notification_checkbox.setChecked(true);
                }
                else{
                    tvoc_lower_push_notification_checkbox.setChecked(false);
                }

                // save changes
                final Button buttsoup2 = new Button(this);
                buttsoup2.setText(getString(R.string.save_changes));
                ll.addView(buttsoup2);

                break;

            case "CO2":

                // CO2 title text view
                final TextView CO2_title_text_view = new TextView(this);
                CO2_title_text_view.setText(getString(R.string.CO2_above));
                CO2_title_text_view.setTextSize(24);
                CO2_title_text_view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_title_text_view.setPadding(8,8,8,8);
                ll.addView(CO2_title_text_view);

                // CO2 upper bound edit text
                final EditText CO2_upper_bound_edit_text = new EditText(this);
                CO2_upper_bound_edit_text.setHint(getString(R.string.ppm));
                CO2_upper_bound_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_upper_bound_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                CO2_upper_bound_edit_text.setTextSize(24);
                ll.addView(CO2_upper_bound_edit_text);

                // CO2 upper push notifications
                final CheckBox CO2_upper_push_notifications_checkbox = new CheckBox(this);
                CO2_upper_push_notifications_checkbox.setText(getString(R.string.send_push));
                ll.addView(CO2_upper_push_notifications_checkbox);
                if (mApp.CO2_upper_pushnotifications==1){
                    CO2_upper_push_notifications_checkbox.setChecked(true);
                }
                else {
                    CO2_upper_push_notifications_checkbox.setChecked(false);
                }

                // CO2 Below Title
                final TextView CO2_below_title = new TextView(this);
                CO2_below_title.setText(getString(R.string.CO2_below));
                CO2_below_title.setTextSize(24);
                CO2_below_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_below_title.setPadding(8,8,8,8);
                ll.addView(CO2_below_title);

                // CO2 lower threshold edit text
                final EditText CO2_lower_threshold_edit_text = new EditText(this);
                CO2_lower_threshold_edit_text.setHint(getString(R.string.ppm));
                CO2_lower_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                CO2_lower_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_lower_threshold_edit_text.setTextSize(24);
                ll.addView(CO2_lower_threshold_edit_text);

                // CO2 lower threshold push notification
                final CheckBox CO2_lower_threshold_push_notification_checkbox = new CheckBox(this);
                CO2_lower_threshold_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(CO2_lower_threshold_push_notification_checkbox);
                if (mApp.CO2_lower_pushnotification==1){
                    CO2_lower_threshold_push_notification_checkbox.setChecked(true);
                }
                else{
                    CO2_lower_threshold_push_notification_checkbox.setChecked(false);
                }


                // submit changes button
                final Button buttsoup3 = new Button(this);
                buttsoup3.setText(getString(R.string.save_changes));
                ll.addView(buttsoup3);

                break;

            case "Solution Temperature":
                // upper solution temperature title
                final TextView upper_solution_temperature_title_text_view = new TextView(this);
                upper_solution_temperature_title_text_view.setText(getString(R.string.Sol_above));
                upper_solution_temperature_title_text_view.setTextSize(24);
                upper_solution_temperature_title_text_view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upper_solution_temperature_title_text_view.setPadding(8,8,8,8);
                ll.addView(upper_solution_temperature_title_text_view);

                // upper solution temperature edit text
                final EditText upper_solution_temperature_edit_text = new EditText(this);
                upper_solution_temperature_edit_text.setHint(mApp.slntemp_upper_threshold + getString(R.string.degreef));
                upper_solution_temperature_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upper_solution_temperature_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                upper_solution_temperature_edit_text.setTextSize(24);
                ll.addView(upper_solution_temperature_edit_text);

                // upper solution temp check
                final CheckBox upper_solution_temp_check_box = new CheckBox(this);
                upper_solution_temp_check_box.setText(getString(R.string.send_push));
                ll.addView(upper_solution_temp_check_box);
                if (mApp.slntemp_upper_pushnotification==1){
                    upper_solution_temp_check_box.setChecked(true);
                }
                else{
                    upper_solution_temp_check_box.setChecked(false);
                }

                // upper sln temp turn off space heater
                final CheckBox upper_sln_temp_turn_off_space_heater_check_box = new CheckBox(this);
                upper_sln_temp_turn_off_space_heater_check_box.setText(getString(R.string.turn_off_space_heater));
                ll.addView(upper_sln_temp_turn_off_space_heater_check_box);
                if (mApp.slntemp_upper_turn_off_space_heater==1){
                    upper_sln_temp_turn_off_space_heater_check_box.setChecked(true);
                }
                else{
                    upper_sln_temp_turn_off_space_heater_check_box.setChecked(false);
                }

                // upper sln temp turn off heating element checkbox
                final CheckBox upper_sln_temp_turn_off_heating_element_checkbox = new CheckBox(this);
                upper_sln_temp_turn_off_heating_element_checkbox.setText(getString(R.string.turn_off_heating_element));
                ll.addView(upper_sln_temp_turn_off_heating_element_checkbox);
                if (mApp.slntemp_upper_turn_off_heating_element==1){
                    upper_sln_temp_turn_off_heating_element_checkbox.setChecked(true);
                }
                else{
                    upper_sln_temp_turn_off_heating_element_checkbox.setChecked(false);
                }


                // lower solution temp title
                final TextView lower_solution_temp_title = new TextView(this);
                lower_solution_temp_title.setText(getString(R.string.Sol_below));
                lower_solution_temp_title.setTextSize(24);
                lower_solution_temp_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_solution_temp_title.setPadding(8,8,8,8);
                ll.addView(lower_solution_temp_title);

                // lower solution temp edit text
                final EditText lower_solution_temp_edit_text = new EditText(this);
                lower_solution_temp_edit_text.setHint(mApp.slntemp_lower_threshold + getString(R.string.degreef));
                lower_solution_temp_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                lower_solution_temp_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_solution_temp_edit_text.setTextSize(24);
                ll.addView(lower_solution_temp_edit_text);

                //lower solution push notification box
                final CheckBox lower_solution_temp_push_notification_checkbox = new CheckBox(this);
                lower_solution_temp_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(lower_solution_temp_push_notification_checkbox);
                if (mApp.slntemp_lower_pushnotification==1){
                    lower_solution_temp_push_notification_checkbox.setChecked(true);
                }
                else{
                    lower_solution_temp_push_notification_checkbox.setChecked(false);
                }

                // lower sln temp turn on space heater checkbox
                final CheckBox lower_solution_temp_turn_on_space_heater_checkbox = new CheckBox(this);
                lower_solution_temp_turn_on_space_heater_checkbox.setText(getString(R.string.turn_on_space_heater));
                ll.addView(lower_solution_temp_turn_on_space_heater_checkbox);
                if (mApp.slntemp_lower_turn_on_space_heater==1){
                    lower_solution_temp_turn_on_space_heater_checkbox.setChecked(true);
                }
                else {
                    lower_solution_temp_turn_on_space_heater_checkbox.setChecked(false);
                }


                // lower solution temp turn on heating element checkbox
                final CheckBox lower_solution_temp_turn_on_heating_element_checkbox = new CheckBox(this);
                lower_solution_temp_turn_on_heating_element_checkbox.setText(getString(R.string.turn_on_heating_element));
                ll.addView(lower_solution_temp_turn_on_heating_element_checkbox);
                if (mApp.slntemp_lower_turn_on_heating_element==1) {
                    lower_solution_temp_turn_on_heating_element_checkbox.setChecked(true);
                }
                else {
                    lower_solution_temp_turn_on_heating_element_checkbox.setChecked(false);
                }

                //save changes
                final Button buttsoup4 = new Button(this);
                buttsoup4.setText(getString(R.string.save_changes));
                ll.addView(buttsoup4);
                break;

            case "Total Dissolved Solids":

                // title
                final TextView tds_title = new TextView(this);
                tds_title.setText(getString(R.string.tds_above));
                tds_title.setTextSize(24);
                tds_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tds_title.setPadding(8,8,8,8);
                ll.addView(tds_title);

                // upper tds edit text
                final EditText upper_tds_edit_text = new EditText(this);
                upper_tds_edit_text.setHint(mApp.tds_upper_threshold + getString(R.string.ppm));
                upper_tds_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upper_tds_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                upper_tds_edit_text.setTextSize(24);
                ll.addView(upper_tds_edit_text);

                // upper tds push notification checkbox
                final CheckBox upper_tds_push_notification_checkbox = new CheckBox(this);
                upper_tds_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(upper_tds_push_notification_checkbox);
                if (mApp.tds_upper_push_notification==1){
                    upper_tds_push_notification_checkbox.setChecked(true);
                }
                else{
                    upper_tds_push_notification_checkbox.setChecked(false);
                }

                // upper tds add water checkbox
                final CheckBox upper_tds_add_water_checkbox = new CheckBox(this);
                upper_tds_add_water_checkbox.setText(getString(R.string.add_water));
                ll.addView(upper_tds_add_water_checkbox);
                if (mApp.tds_upper_add_water==1){
                    upper_tds_add_water_checkbox.setChecked(true);
                }
                else {
                    upper_tds_add_water_checkbox.setChecked(false);
                }


                // tds lower threshold title
                final TextView tds_lower_threshold_title = new TextView(this);
                tds_lower_threshold_title.setText(getString(R.string.tds_below));
                tds_lower_threshold_title.setTextSize(24);
                tds_lower_threshold_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tds_lower_threshold_title.setPadding(8,8,8,8);
                ll.addView(tds_lower_threshold_title);

                // tds lower edit text
                final EditText tds_lower_threshold_edit_text = new EditText(this);
                tds_lower_threshold_edit_text.setHint(mApp.tds_lower_threshold + getString(R.string.ppm));
                tds_lower_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                tds_lower_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tds_lower_threshold_edit_text.setTextSize(24);
                ll.addView(tds_lower_threshold_edit_text);

                // tds lower threshold send push notification check box
                final CheckBox tds_lower_threshold_send_push_notifiation = new CheckBox(this);
                tds_lower_threshold_send_push_notifiation.setText(getString(R.string.send_push));
                ll.addView(tds_lower_threshold_send_push_notifiation);
                if (mApp.tds_lower_threshold==1){
                    tds_lower_threshold_send_push_notifiation.setChecked(true);
                }
                else{
                    tds_lower_threshold_send_push_notifiation.setChecked(false);
                }


                // add flora bloom check box
                final CheckBox add_flora_bloom_check_box = new CheckBox(this);
                add_flora_bloom_check_box.setText(getString(R.string.add_florabloom));
                ll.addView(add_flora_bloom_check_box);

                if (mApp.tds_add_florabloom==1){
                    add_flora_bloom_check_box.setChecked(true);
                }
                else {
                    add_flora_bloom_check_box.setChecked(false);
                }

                // add flora gro check box
                final CheckBox add_flora_gro_checkbox = new CheckBox(this);
                add_flora_gro_checkbox.setText(getString(R.string.add_floragro));
                ll.addView(add_flora_gro_checkbox);
                if (mApp.tds_add_floragro==1){
                    add_flora_gro_checkbox.setChecked(true);
                }
                else {
                    add_flora_gro_checkbox.setChecked(false);
                }


                // add flora micro check box
                final CheckBox add_flora_micro_check_box = new CheckBox(this);
                add_flora_micro_check_box.setText(getString(R.string.add_floramicro));
                ll.addView(add_flora_micro_check_box);
                if (mApp.tds_add_floramicro==1){
                    add_flora_micro_check_box.setChecked(true);
                }
                else {
                    add_flora_micro_check_box.setChecked(false);
                }

                // save changes
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
