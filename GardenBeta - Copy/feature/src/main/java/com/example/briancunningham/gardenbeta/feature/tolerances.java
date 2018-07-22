package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
                air_temp_upper_checkbox.setChecked(true);
                ll.addView(air_temp_upper_checkbox);

                // upper air temp extra fans on display code
                final CheckBox air_temp_upper_on_extra_fans = new CheckBox(this);
                ll.addView(air_temp_upper_on_extra_fans);
                air_temp_upper_on_extra_fans.setText(getString(R.string.turn_on_fans));
                air_temp_upper_on_extra_fans.setChecked(true);

                // upper air temp space heating off
                final CheckBox upper_air_temp_space_heating_checkbox = new CheckBox(this);
                ll.addView(upper_air_temp_space_heating_checkbox);
                upper_air_temp_space_heating_checkbox.setText(getString(R.string.turn_off_heating_element));
                upper_air_temp_space_heating_checkbox.setChecked(true);

                //upper air temp turn space heater off
                final CheckBox upper_air_temp_space_heater_off = new CheckBox(this);
                ll.addView(upper_air_temp_space_heater_off);
                upper_air_temp_space_heater_off.setText(getString(R.string.turn_off_space_heater));
                upper_air_temp_space_heater_off.setChecked(true);

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
                lower_threshold_push_notification_check_box.setChecked(false);

                // lower threshold turn off extra fans
                final CheckBox lower_threshold_turn_off_extra_fans_checkbox = new CheckBox(this);
                ll.addView(lower_threshold_turn_off_extra_fans_checkbox);
                lower_threshold_turn_off_extra_fans_checkbox.setText(getString(R.string.turn_off_fans));
                lower_threshold_turn_off_extra_fans_checkbox.setChecked(false);

                // lower threshold turn on heating element
                final CheckBox air_temp_lower_turn_on_heating_element = new CheckBox(this);
                ll.addView(air_temp_lower_turn_on_heating_element);
                air_temp_lower_turn_on_heating_element.setText(getString(R.string.turn_on_heating_element));
                air_temp_lower_turn_on_heating_element.setChecked(true);

                // lower threshold turn on space heater
                final CheckBox lower_threshold_turn_on_space_heater_check_box = new CheckBox(this);
                ll.addView(lower_threshold_turn_on_space_heater_check_box);
                lower_threshold_turn_on_space_heater_check_box.setText(getString(R.string.turn_on_space_heater));
                lower_threshold_turn_on_space_heater_check_box.setChecked(true);

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
                upper_humidity_push_nofitication_check_box.setChecked(false);

                // upper humidity extra fans on
                final CheckBox upper_humidity_extra_fans_on = new CheckBox(this);
                ll.addView(upper_humidity_extra_fans_on);
                upper_humidity_extra_fans_on.setText(getString(R.string.turn_on_fans));
                upper_humidity_extra_fans_on.setChecked(true);

                // upper_humidity_turn_off_fogger
                final CheckBox upper_humidity_turn_off_fogger_check_box = new CheckBox(this);
                ll.addView(upper_humidity_turn_off_fogger_check_box);
                upper_humidity_turn_off_fogger_check_box.setText(getString(R.string.turn_off_fogger));
                upper_humidity_turn_off_fogger_check_box.setChecked(true);

                // upper humidity turn on space heater
                final CheckBox upper_humidity_turn_on_space_heater_checkbox = new CheckBox(this);
                ll.addView(upper_humidity_turn_on_space_heater_checkbox);
                upper_humidity_turn_on_space_heater_checkbox.setText(getString(R.string.turn_on_space_heater));

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
                low_humidity_push_notification_check_box.setChecked(false);

                // low humidity turn off extra fans
                final CheckBox low_humidity_turn_off_extra_fans = new CheckBox(this);
                ll.addView(low_humidity_turn_off_extra_fans);
                low_humidity_turn_off_extra_fans.setText(getString(R.string.turn_off_fans));
                low_humidity_turn_off_extra_fans.setChecked(false);

                // low humidity turn on fogger
                final CheckBox low_humidity_turn_on_fogger = new CheckBox(this);
                ll.addView(low_humidity_turn_on_fogger);
                low_humidity_turn_on_fogger.setText(getString(R.string.turn_on_fogger));
                low_humidity_turn_on_fogger.setChecked(false);


                // low humidity turn off space heater
                final CheckBox low_humidty_turn_off_space_heater_checkbox = new CheckBox(this);
                ll.addView(low_humidty_turn_off_space_heater_checkbox);
                low_humidty_turn_off_space_heater_checkbox.setText(getString(R.string.turn_off_space_heater));
                low_humidity_turn_off_extra_fans.setChecked(true);

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
                tvoc_upper_edit_text.setHint(mApp.TVOC_upper_threshold + getString(R.string.ppm));
                tvoc_upper_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tvoc_upper_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                tvoc_upper_edit_text.setTextSize(24);
                ll.addView(tvoc_upper_edit_text);

                // TVOC upper threshold push notifications
                final CheckBox tvoc_upper_threshold_push_nofitications = new CheckBox(this);
                tvoc_upper_threshold_push_nofitications.setText(getString(R.string.send_push));
                ll.addView(tvoc_upper_threshold_push_nofitications);
                tvoc_upper_threshold_push_nofitications.setChecked(false);

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
                tvoc_lower_push_notification_checkbox.setChecked(false);

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
                CO2_upper_push_notifications_checkbox.setChecked(false);

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
                CO2_lower_threshold_push_notification_checkbox.setChecked(false);


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
                upper_solution_temp_check_box.setChecked(false);

                // upper sln temp turn off space heater
                final CheckBox upper_sln_temp_turn_off_space_heater_check_box = new CheckBox(this);
                upper_sln_temp_turn_off_space_heater_check_box.setText(getString(R.string.turn_off_space_heater));
                ll.addView(upper_sln_temp_turn_off_space_heater_check_box);
                upper_sln_temp_turn_off_space_heater_check_box.setChecked(true);

                // upper sln temp turn off heating element checkbox
                final CheckBox upper_sln_temp_turn_off_heating_element_checkbox = new CheckBox(this);
                upper_sln_temp_turn_off_heating_element_checkbox.setText(getString(R.string.turn_off_heating_element));
                ll.addView(upper_sln_temp_turn_off_heating_element_checkbox);
                upper_sln_temp_turn_off_heating_element_checkbox.setChecked(true);


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
                lower_solution_temp_push_notification_checkbox.setChecked(false);

                // lower sln temp turn on space heater checkbox
                final CheckBox lower_solution_temp_turn_on_space_heater_checkbox = new CheckBox(this);
                lower_solution_temp_turn_on_space_heater_checkbox.setText(getString(R.string.turn_on_space_heater));
                ll.addView(lower_solution_temp_turn_on_space_heater_checkbox);
                lower_solution_temp_turn_on_space_heater_checkbox.setChecked(false);


                // lower solution temp turn on heating element checkbox
                final CheckBox lower_solution_temp_turn_on_heating_element_checkbox = new CheckBox(this);
                lower_solution_temp_turn_on_heating_element_checkbox.setText(getString(R.string.turn_on_heating_element));
                ll.addView(lower_solution_temp_turn_on_heating_element_checkbox);
                lower_solution_temp_turn_on_heating_element_checkbox.setChecked(true);

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
                upper_tds_push_notification_checkbox.setChecked(false);

                // upper tds add water checkbox
                final CheckBox upper_tds_add_water_checkbox = new CheckBox(this);
                upper_tds_add_water_checkbox.setText(getString(R.string.add_water));
                ll.addView(upper_tds_add_water_checkbox);
                upper_tds_add_water_checkbox.setChecked(true);


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
                tds_lower_threshold_send_push_notifiation.setChecked(false);


                // add flora bloom check box
                final CheckBox add_flora_bloom_check_box = new CheckBox(this);
                add_flora_bloom_check_box.setText(getString(R.string.add_florabloom));
                ll.addView(add_flora_bloom_check_box);

                add_flora_bloom_check_box.setChecked(false);

                // add flora gro check box
                final CheckBox add_flora_gro_checkbox = new CheckBox(this);
                add_flora_gro_checkbox.setText(getString(R.string.add_floragro));
                ll.addView(add_flora_gro_checkbox);
                add_flora_gro_checkbox.setChecked(true);


                // add flora micro check box
                final CheckBox add_flora_micro_check_box = new CheckBox(this);
                add_flora_micro_check_box.setText(getString(R.string.add_floramicro));
                ll.addView(add_flora_micro_check_box);
                add_flora_micro_check_box.setChecked(false);

                // save changes
                final Button buttsoup5 = new Button(this);
                buttsoup5.setText(getString(R.string.save_changes));
                ll.addView(buttsoup5);
                break;

            case "Dissolved Oxygen":

                // title
                final TextView do_upper_title = new TextView(this);
                do_upper_title.setText(getString(R.string.do_above));
                do_upper_title.setTextSize(24);
                do_upper_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                do_upper_title.setPadding(8,8,8,8);
                ll.addView(do_upper_title);

                // do upper threshold edit text
                final EditText do_upper_threshold_edit_text = new EditText(this);
                do_upper_threshold_edit_text.setHint(getString(R.string.ppm));
                do_upper_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                do_upper_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                do_upper_threshold_edit_text.setTextSize(24);
                ll.addView(do_upper_threshold_edit_text);

                // do upper threshold push notification
                final CheckBox do_upper_threshold_push_notification_checkbox = new CheckBox(this);
                do_upper_threshold_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(do_upper_threshold_push_notification_checkbox);
                do_upper_threshold_push_notification_checkbox.setChecked(false);

                // do upper turn extra air pumps off
                final CheckBox do_upper_turn_extra_air_pumps_off = new CheckBox(this);
                do_upper_turn_extra_air_pumps_off.setText(getString(R.string.turn_off_air_pump));
                ll.addView(do_upper_turn_extra_air_pumps_off);
                do_upper_turn_extra_air_pumps_off.setChecked(true);


                // do upper add water
                final CheckBox do_upper_add_water_checkbox = new CheckBox(this);
                do_upper_add_water_checkbox.setText(getString(R.string.add_water));
                ll.addView(do_upper_add_water_checkbox);
                do_upper_add_water_checkbox.setChecked(true);

                // do lower title
                final TextView do_lower_title = new TextView(this);
                do_lower_title.setText(getString(R.string.do_below));
                do_lower_title.setTextSize(24);
                do_lower_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                do_lower_title.setPadding(8,8,8,8);
                ll.addView(do_lower_title);

                // do lower bound edit text
                final EditText do_lower_bound_edit_text = new EditText(this);
                do_lower_bound_edit_text.setHint(getString(R.string.ppm));
                do_lower_bound_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                do_lower_bound_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                do_lower_bound_edit_text.setTextSize(24);
                ll.addView(do_lower_bound_edit_text);

                // do lower send push notification checkbox
                final CheckBox do_lower_send_push_notification_checkbox = new CheckBox(this);
                do_lower_send_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(do_lower_send_push_notification_checkbox);
                do_lower_send_push_notification_checkbox.setChecked(false);

                // do lower turn extra pumps on
                final CheckBox do_lower_turn_extra_pumps_on= new CheckBox(this);
                do_lower_turn_extra_pumps_on.setText(getString(R.string.turn_on_extra_air_pump));
                ll.addView(do_lower_turn_extra_pumps_on);
                do_lower_turn_extra_pumps_on.setChecked(true);


                // do lower add hypochloric acid
                final CheckBox do_lower_add_hypochloric_acid = new CheckBox(this);
                do_lower_add_hypochloric_acid.setText(getString(R.string.add_hypochloric));
                ll.addView(do_lower_add_hypochloric_acid);
                do_lower_add_hypochloric_acid.setChecked(true);

                // lower do add peroxide
                final CheckBox do_lower_add_peroxide = new CheckBox(this);
                do_lower_add_peroxide.setText(getString(R.string.add_peroxide));
                ll.addView(do_lower_add_peroxide);
                do_lower_add_hypochloric_acid.setChecked(false);

                // save changes
                final Button buttsoup6 = new Button(this);
                buttsoup6.setText(getString(R.string.save_changes));
                ll.addView(buttsoup6);
                break;


            case "Oxidation-Reduction Potential":
                // orp title
                final TextView orp_title_text_view = new TextView(this);
                orp_title_text_view.setText(getString(R.string.orp_above));
                orp_title_text_view.setTextSize(24);
                orp_title_text_view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                orp_title_text_view.setPadding(8,8,8,8);
                ll.addView(orp_title_text_view);

                // upper bound edit text
                final EditText orp_upper_bound_edit_text = new EditText(this);
                orp_upper_bound_edit_text.setHint(mApp.orp_upper_threshold + getString(R.string.ppm));
                orp_upper_bound_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                orp_upper_bound_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                orp_upper_bound_edit_text.setTextSize(24);
                ll.addView(orp_upper_bound_edit_text);

                // orp upper push notification
                final CheckBox orp_upper_push_notification_checkbox = new CheckBox(this);
                orp_upper_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(orp_upper_push_notification_checkbox);
                orp_upper_push_notification_checkbox.setChecked(false);

                // orp add upper water checkbox
                final CheckBox orp_upper_add_water_checkbox = new CheckBox(this);
                orp_upper_add_water_checkbox.setText(getString(R.string.add_water));
                ll.addView(orp_upper_add_water_checkbox);
                orp_upper_add_water_checkbox.setChecked(false);

                // orp lower title
                final TextView orp_lower_title = new TextView(this);
                orp_lower_title.setText(getString(R.string.orp_below));
                orp_lower_title.setTextSize(24);
                orp_lower_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                orp_lower_title.setPadding(8,8,8,8);
                ll.addView(orp_lower_title);

                // orp lower threshold edit text
                final EditText orp_lower_threshold_edit_text = new EditText(this);
                orp_lower_threshold_edit_text.setHint(mApp.orp_lower_threshold + getString(R.string.ppm));
                orp_lower_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                orp_lower_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                orp_lower_threshold_edit_text.setTextSize(24);
                ll.addView(orp_lower_threshold_edit_text);

                // orp lower push notification
                final CheckBox orp_lower_push_notification_checkbox = new CheckBox(this);
                orp_lower_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(orp_lower_push_notification_checkbox);
                orp_lower_push_notification_checkbox.setChecked(false);

                // orp lower add peroxide
                final CheckBox orp_lower_add_peroxide_checkbox = new CheckBox(this);
                orp_lower_add_peroxide_checkbox.setText(getString(R.string.add_peroxide));
                ll.addView(orp_lower_add_peroxide_checkbox);
                orp_lower_add_peroxide_checkbox.setChecked(false);

                // orp lower add hypochloric
                final CheckBox orp_lower_add_hypochloric_checkbox = new CheckBox(this);
                orp_lower_add_hypochloric_checkbox.setText(getString(R.string.add_hypochloric));
                ll.addView(orp_lower_add_hypochloric_checkbox);
                orp_lower_add_hypochloric_checkbox.setChecked(false);

                // orp add base
                final CheckBox orp_lower_add_base = new CheckBox(this);
                orp_lower_add_base.setText(getString(R.string.add_base));
                ll.addView(orp_lower_add_base);
                orp_lower_add_peroxide_checkbox.setChecked(true);

                // save changes
                final Button buttsoup7 = new Button(this);
                buttsoup7.setText(getString(R.string.save_changes));
                ll.addView(buttsoup7);
                break;

            case "pH":

                //ph title
                final TextView pH_title = new TextView(this);
                pH_title.setText(getString(R.string.pH_above));
                pH_title.setTextSize(24);
                pH_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                pH_title.setPadding(8,8,8,8);
                ll.addView(pH_title);

                // ph upper bound edit text
                final EditText pH_upper_bound_edit_text = new EditText(this);
                pH_upper_bound_edit_text.setHint(getString(R.string.ppm));
                pH_upper_bound_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                pH_upper_bound_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                pH_upper_bound_edit_text.setTextSize(24);
                ll.addView(pH_upper_bound_edit_text);

                // ph upper push notification
                final CheckBox pH_upper_push_notification_checkbox = new CheckBox(this);
                pH_upper_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(pH_upper_push_notification_checkbox);
                pH_upper_push_notification_checkbox.setChecked(false);

                // pH upper add acid
                final CheckBox ph_upper_add_acid_checkbox = new CheckBox(this);
                ph_upper_add_acid_checkbox.setText(getString(R.string.add_acid));
                ll.addView(ph_upper_add_acid_checkbox);
                ph_upper_add_acid_checkbox.setChecked(true);

                // lower title
                final TextView lower_title_pH = new TextView(this);
                lower_title_pH.setText(getString(R.string.pH_below));
                lower_title_pH.setTextSize(24);
                lower_title_pH.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_title_pH.setPadding(8,8,8,8);
                ll.addView(lower_title_pH);

                // lower edit text
                final EditText lower_ph_edit_text = new EditText(this);
                lower_ph_edit_text.setHint(mApp.pH_lower_threshold + getString(R.string.ppm));
                lower_ph_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                lower_ph_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_ph_edit_text.setTextSize(24);
                ll.addView(lower_ph_edit_text);

                // lower ph push notification checkbox
                final CheckBox lower_ph_push_notification_checkbox = new CheckBox(this);
                lower_ph_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(lower_ph_push_notification_checkbox);
                lower_ph_push_notification_checkbox.setChecked(false);

                // lower ph add base checkbox
                final CheckBox lower_ph_add_base_checkbox = new CheckBox(this);
                lower_ph_add_base_checkbox.setText(getString(R.string.add_base));
                ll.addView(lower_ph_add_base_checkbox);
                lower_ph_add_base_checkbox.setChecked(true);

                // save changes
                final Button buttsoup8 = new Button(this);
                buttsoup8.setText(getString(R.string.save_changes));
                ll.addView(buttsoup8);
                break;

            case "Reservoirs":

                // reservoirs title
                final TextView reservoirs_title_text_view = new TextView(this);
                reservoirs_title_text_view.setText(getString(R.string.reservoirs_low));
                reservoirs_title_text_view.setTextSize(24);
                reservoirs_title_text_view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                reservoirs_title_text_view.setPadding(8,8,8,8);
                ll.addView(reservoirs_title_text_view);

                // reservoirs checkbox
                final CheckBox reservoirs_checkbox = new CheckBox(this);
                reservoirs_checkbox.setText(getString(R.string.send_push));
                ll.addView(reservoirs_checkbox);
                reservoirs_checkbox.setChecked(true);

                //save changes
                final Button buttsoup9 = new Button(this);
                buttsoup9.setText(getString(R.string.save_changes));
                ll.addView(buttsoup9);
                break;

            case "Canopy Height":
                // canopy height title
                final TextView canopy_height_title = new TextView(this);
                canopy_height_title.setText(getString(R.string.canopy_height_trigger));
                canopy_height_title.setTextSize(24);
                canopy_height_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                canopy_height_title.setPadding(8,8,8,8);
                ll.addView(canopy_height_title);

                // canopy height marker
                final EditText canopy_height_marker = new EditText(this);
                canopy_height_marker.setHint(mApp.canopy_height_checkpoint + getString(R.string.centimeters));
                canopy_height_marker.setInputType(InputType.TYPE_CLASS_NUMBER);
                canopy_height_marker.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                canopy_height_marker.setTextSize(24);
                ll.addView(canopy_height_marker);

                // canopy push notifications
                final CheckBox canopy_push_notification_checkbox = new CheckBox(this);
                canopy_push_notification_checkbox.setText(getString(R.string.send_push_once));
                ll.addView(canopy_push_notification_checkbox);
                canopy_push_notification_checkbox.setChecked(true);

                // save changes
                final Button buttsoup10 = new Button(this);
                buttsoup10.setText(getString(R.string.save_changes));
                ll.addView(buttsoup10);
                break;

            case "Light Height":
                // light height titles
                final TextView light_height_title = new TextView(this);
                light_height_title.setText(getString(R.string.light_height));
                light_height_title.setTextSize(24);
                light_height_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                light_height_title.setPadding(8,8,8,8);
                ll.addView(light_height_title);

                // light height target
                final EditText light_height_edit_text = new EditText(this);
                light_height_edit_text.setHint(mApp.light_height_target + getString(R.string.centimeters));
                light_height_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                light_height_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                light_height_edit_text.setTextSize(24);
                ll.addView(light_height_edit_text);

                // light height push checkbox
                final CheckBox light_height_push_checkbox = new CheckBox(this);
                light_height_push_checkbox.setText(getString(R.string.send_push_lights));
                ll.addView(light_height_push_checkbox);
                light_height_push_checkbox.setChecked(true);

                // push changes
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
