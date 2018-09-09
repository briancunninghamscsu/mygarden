package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

public class tolerances extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolerances);
        setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title

        final MyAppApplication mApp = (MyAppApplication) getApplicationContext(); //get global variables
        final LinearLayout ll = findViewById(R.id.linlaytolerances);
        ll.setOrientation(LinearLayout.VERTICAL);

        switch (getIntent().getStringExtra("parameter_name")) {
            case "Air Temperature":

                // daytime starting title
                final TextView day_time_lower = new TextView(this);
                day_time_lower.setText("I want daytime to start at " +mApp.day_time_starts_at);
                day_time_lower.setTextSize(24);
                day_time_lower.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                day_time_lower.setPadding(8, 8, 8, 8);
                day_time_lower.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        final String[] times = {"12:00AM", "1:00AM", "2:00AM", "3:00AM","4:00AM", "5:00AM", "6:00AM", "7:00AM","8:00AM", "9:00AM", "10:00AM", "11:00AM","12:00PM", "1:00PM", "2:00PM", "3:00PM","4:00PM", "5:00PM", "6:00PM", "7:00PM","8:00PM", "9:00PM", "10:00PM", "11:00PM"};

                        AlertDialog.Builder builder = new AlertDialog.Builder(tolerances.this);
                        builder.setTitle("When should day time start?");
                        builder.setItems(times, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // the user clicked on colors[which]
                                mApp.day_time_starts_at=times[which];

                                // error checking
                                if (mApp.night_time_starts_at.equals(mApp.day_time_starts_at)){
                                    if (mApp.day_time_starts_at.equals("12:00AM")){
                                        mApp.day_time_starts_at="11:00PM";
                                    }
                                    else {
                                        mApp.day_time_starts_at = times[which - 1];
                                    }
                                }



                                day_time_lower.setText("I want day time to start at " +mApp.day_time_starts_at+".");
                            }
                            });
                        builder.show();
                        }
                        }
                )
                ;
                ll.addView(day_time_lower);





                final TextView night_time_lower = new TextView(this);
                night_time_lower.setText("I want night time to start at " +mApp.night_time_starts_at + ".");
                night_time_lower.setTextSize(24);
                night_time_lower.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                night_time_lower.setPadding(8, 8, 8, 8);
                night_time_lower.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View view) {

                                                         final String[] times = {"12:00AM", "1:00AM", "2:00AM", "3:00AM","4:00AM", "5:00AM", "6:00AM", "7:00AM","8:00AM", "9:00AM", "10:00AM", "11:00AM","12:00PM", "1:00PM", "2:00PM", "3:00PM","4:00PM", "5:00PM", "6:00PM", "7:00PM","8:00PM", "9:00PM", "10:00PM", "11:00PM"};

                                                         AlertDialog.Builder builder = new AlertDialog.Builder(tolerances.this);
                                                         builder.setTitle("When should night time start?");
                                                         builder.setItems(times, new DialogInterface.OnClickListener() {
                                                             @Override
                                                             public void onClick(DialogInterface dialog, int which) {
                                                                 // the user clicked on colors[which]
                                                                 mApp.night_time_starts_at=times[which];

                                                                 if (mApp.night_time_starts_at.equals(mApp.day_time_starts_at)){
                                                                     if (mApp.night_time_starts_at.equals("11:00PM")){
                                                                         mApp.night_time_starts_at="12:00AM";
                                                                     }
                                                                     else {
                                                                         mApp.night_time_starts_at = times[which + 1];
                                                                     }
                                                                 }
                                                                 night_time_lower.setText("I want night time to start at " +mApp.night_time_starts_at+".");
                                                             }
                                                         });
                                                         builder.show();
                                                     }
                                                 }
                )
                ;

                ll.addView(night_time_lower);




                final TextView uppertext = new TextView(this);
                uppertext.setText("If Day Air Temp is Above ");
                uppertext.setTextSize(24);
                uppertext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext.setPadding(8, 8, 8, 8);
                ll.addView(uppertext);

                // logic for displaying current upper bound settings
                final EditText upperbound = new EditText(this);
                upperbound.setHint(mApp.air_temp_upper_threshold_day_time + getString(R.string.degreef));
                upperbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound.setTextSize(24);
                ll.addView(upperbound);

                //upper bound checkbox display logic
                final CheckBox air_temp_upper_push_notifications_checkbox = new CheckBox(this);
                air_temp_upper_push_notifications_checkbox.setText(getString(R.string.send_push));
                if (mApp.air_temp_upper_pushnotification_day_time == 1) {
                    air_temp_upper_push_notifications_checkbox.setChecked(true);
                } else {
                    air_temp_upper_push_notifications_checkbox.setChecked(false);
                }
                ll.addView(air_temp_upper_push_notifications_checkbox);

                // upper air temp extra fans on display code
                final CheckBox air_temp_upper_on_extra_fans = new CheckBox(this);
                ll.addView(air_temp_upper_on_extra_fans);
                air_temp_upper_on_extra_fans.setText(getString(R.string.turn_on_fans));
                if (mApp.air_temp_upper_turn_on_fans_day_time == 1) {
                    air_temp_upper_on_extra_fans.setChecked(true);
                } else {
                    air_temp_upper_on_extra_fans.setChecked(false);
                }

                // upper air temp heating element off
                final CheckBox upper_air_temp_heating_element_checkbox = new CheckBox(this);
                ll.addView(upper_air_temp_heating_element_checkbox);
                upper_air_temp_heating_element_checkbox.setText(getString(R.string.turn_off_heating_element));
                if (mApp.air_temp_upper_turn_off_heating_element_day_time == 1) {
                    upper_air_temp_heating_element_checkbox.setChecked(true);
                } else {
                    upper_air_temp_heating_element_checkbox.setChecked(false);
                }

                // upper air temp turn space heater off
                final CheckBox upper_air_temp_space_heater_off_checkbox = new CheckBox(this);
                ll.addView(upper_air_temp_space_heater_off_checkbox);
                upper_air_temp_space_heater_off_checkbox.setText(getString(R.string.turn_off_space_heater));
                if (mApp.air_temp_upper_turn_off_space_heater_day_time == 1) {
                    upper_air_temp_space_heater_off_checkbox.setChecked(true);
                } else {
                    upper_air_temp_space_heater_off_checkbox.setChecked(false);
                }

                //lower threshold title
                final TextView belowtext = new TextView(this);
                belowtext.setText("If Day Air Temp is Below");
                belowtext.setTextSize(24);
                belowtext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext.setPadding(8, 8, 8, 8);
                ll.addView(belowtext);

                // lower threshold edittext
                final EditText lowerbound = new EditText(this);
                lowerbound.setHint(mApp.air_temp_lower_threshold_day_time + getString(R.string.degreef));
                lowerbound.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound.setTextSize(24);
                ll.addView(lowerbound);

                // lower threshold push notification check box
                final CheckBox air_temp_lower_threshold_push_notification_check_box = new CheckBox(this);
                air_temp_lower_threshold_push_notification_check_box.setText(getString(R.string.send_push));
                ll.addView(air_temp_lower_threshold_push_notification_check_box);
                if (mApp.air_temp_lower_pushnotification_day_time == 1) {
                    air_temp_lower_threshold_push_notification_check_box.setChecked(true);
                } else {
                    air_temp_lower_threshold_push_notification_check_box.setChecked(false);
                }

                // lower threshold turn off extra fans
                final CheckBox air_temp_lower_turn_off_extra_fans_checkbox = new CheckBox(this);
                ll.addView(air_temp_lower_turn_off_extra_fans_checkbox);
                air_temp_lower_turn_off_extra_fans_checkbox.setText(getString(R.string.turn_off_fans));
                if (mApp.air_temp_lower_turn_off_fans_day_time == 1) {
                    air_temp_lower_turn_off_extra_fans_checkbox.setChecked(true);
                } else {
                    air_temp_lower_turn_off_extra_fans_checkbox.setChecked(false);
                }

                // lower threshold turn on heating element
                final CheckBox air_temp_lower_turn_on_heating_element_checkbox = new CheckBox(this);
                ll.addView(air_temp_lower_turn_on_heating_element_checkbox);
                air_temp_lower_turn_on_heating_element_checkbox.setText(getString(R.string.turn_on_heating_element));
                if (mApp.air_temp_lower_turn_on_heating_element_day_time == 1) {
                    air_temp_lower_turn_on_heating_element_checkbox.setChecked(true);
                } else {
                    air_temp_lower_turn_on_heating_element_checkbox.setChecked(false);
                }

                // lower threshold turn on space heater
                final CheckBox lower_threshold_turn_on_space_heater_check_box = new CheckBox(this);
                ll.addView(lower_threshold_turn_on_space_heater_check_box);
                lower_threshold_turn_on_space_heater_check_box.setText(getString(R.string.turn_on_space_heater));
                if (mApp.air_temp_lower_turn_on_space_heater_day_time == 1) {
                    lower_threshold_turn_on_space_heater_check_box.setChecked(true);
                } else {
                    air_temp_lower_threshold_push_notification_check_box.setChecked(false);
                }




                // NIGHT TIME SETTINGS
                final TextView uppertext_night = new TextView(this);
                uppertext_night.setText("If Night Air Temp is Above ");
                uppertext_night.setTextSize(24);
                uppertext_night.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext_night.setPadding(8, 8, 8, 8);
                ll.addView(uppertext_night);

                // logic for displaying current upper bound settings
                final EditText upperbound_night = new EditText(this);
                upperbound_night.setHint(mApp.air_temp_upper_threshold_night_time + getString(R.string.degreef));
                upperbound_night.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound_night.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound_night.setTextSize(24);
                ll.addView(upperbound_night);

                //upper bound checkbox display logic
                final CheckBox air_temp_upper_push_notifications_checkbox_night = new CheckBox(this);
                air_temp_upper_push_notifications_checkbox_night.setText(getString(R.string.send_push));
                if (mApp.air_temp_upper_pushnotification_night_time == 1) {
                    air_temp_upper_push_notifications_checkbox_night.setChecked(true);
                } else {
                    air_temp_upper_push_notifications_checkbox_night.setChecked(false);
                }
                ll.addView(air_temp_upper_push_notifications_checkbox_night);

                // upper air temp extra fans on display code
                final CheckBox air_temp_upper_on_extra_fans_night = new CheckBox(this);
                ll.addView(air_temp_upper_on_extra_fans_night);
                air_temp_upper_on_extra_fans_night.setText(getString(R.string.turn_on_fans));
                if (mApp.air_temp_upper_turn_on_fans_night_time == 1) {
                    air_temp_upper_on_extra_fans_night.setChecked(true);
                } else {
                    air_temp_upper_on_extra_fans_night.setChecked(false);
                }

                // upper air temp heating element off
                final CheckBox upper_air_temp_heating_element_checkbox_night = new CheckBox(this);
                ll.addView(upper_air_temp_heating_element_checkbox_night);
                upper_air_temp_heating_element_checkbox_night.setText(getString(R.string.turn_off_heating_element));
                if (mApp.air_temp_upper_turn_off_heating_element_night_time == 1) {
                    upper_air_temp_heating_element_checkbox_night.setChecked(true);
                } else {
                    upper_air_temp_heating_element_checkbox_night.setChecked(false);
                }

                // upper air temp turn space heater off
                final CheckBox upper_air_temp_space_heater_off_checkbox_night = new CheckBox(this);
                ll.addView(upper_air_temp_space_heater_off_checkbox_night);
                upper_air_temp_space_heater_off_checkbox_night.setText(getString(R.string.turn_off_space_heater));
                if (mApp.air_temp_upper_turn_off_space_heater_night_time == 1) {
                    upper_air_temp_space_heater_off_checkbox_night.setChecked(true);
                } else {
                    upper_air_temp_space_heater_off_checkbox_night.setChecked(false);
                }

                //lower threshold title
                final TextView belowtext_night = new TextView(this);
                belowtext_night.setText("If Night Air Temp is Below");
                belowtext_night.setTextSize(24);
                belowtext_night.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                belowtext_night.setPadding(8, 8, 8, 8);
                ll.addView(belowtext_night);

                // lower threshold edittext
                final EditText lowerbound_night = new EditText(this);
                lowerbound_night.setHint(mApp.air_temp_lower_threshold_night_time + getString(R.string.degreef));
                lowerbound_night.setInputType(InputType.TYPE_CLASS_NUMBER);
                lowerbound_night.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lowerbound_night.setTextSize(24);
                ll.addView(lowerbound_night);

                // lower threshold push notification check box
                final CheckBox air_temp_lower_threshold_push_notification_check_box_night = new CheckBox(this);
                air_temp_lower_threshold_push_notification_check_box_night.setText(getString(R.string.send_push));
                ll.addView(air_temp_lower_threshold_push_notification_check_box_night);
                if (mApp.air_temp_lower_pushnotification_night_time == 1) {
                    air_temp_lower_threshold_push_notification_check_box_night.setChecked(true);
                } else {
                    air_temp_lower_threshold_push_notification_check_box_night.setChecked(false);
                }

                // lower threshold turn off extra fans
                final CheckBox air_temp_lower_turn_off_extra_fans_checkbox_night = new CheckBox(this);
                ll.addView(air_temp_lower_turn_off_extra_fans_checkbox_night);
                air_temp_lower_turn_off_extra_fans_checkbox_night.setText(getString(R.string.turn_off_fans));
                if (mApp.air_temp_lower_turn_off_fans_night_time == 1) {
                    air_temp_lower_turn_off_extra_fans_checkbox_night.setChecked(true);
                } else {
                    air_temp_lower_turn_off_extra_fans_checkbox_night.setChecked(false);
                }

                // lower threshold turn on heating element
                final CheckBox air_temp_lower_turn_on_heating_element_checkbox_night = new CheckBox(this);
                ll.addView(air_temp_lower_turn_on_heating_element_checkbox_night);
                air_temp_lower_turn_on_heating_element_checkbox_night.setText(getString(R.string.turn_on_heating_element));
                if (mApp.air_temp_lower_turn_on_heating_element_night_time == 1) {
                    air_temp_lower_turn_on_heating_element_checkbox_night.setChecked(true);
                } else {
                    air_temp_lower_turn_on_heating_element_checkbox_night.setChecked(false);
                }

                // lower threshold turn on space heater
                final CheckBox lower_threshold_turn_on_space_heater_check_box_night = new CheckBox(this);
                ll.addView(lower_threshold_turn_on_space_heater_check_box_night);
                lower_threshold_turn_on_space_heater_check_box_night.setText(getString(R.string.turn_on_space_heater));
                if (mApp.air_temp_lower_turn_on_space_heater_night_time == 1) {
                    lower_threshold_turn_on_space_heater_check_box_night.setChecked(true);
                } else {
                    lower_threshold_turn_on_space_heater_check_box_night.setChecked(false);
                }











                // box for sending data to server
                final Button save_changes_box = new Button(this);
                save_changes_box.setText(getString(R.string.save_changes));
                ll.addView(save_changes_box);
                save_changes_box.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                       /* mApp.air_temp_upper_threshold_day_time=Double.parseDouble(uppertext.getText().toString());
                        mApp.air_temp_lower_threshold_day_time=Double.parseDouble(belowtext.getText().toString());
                        mApp.air_temp_upper_threshold_night_time=Double.parseDouble(uppertext_night.getText().toString());
                       */

                        /*mApp.air_temp_lower_threshold_night_time=belowtext_night.getText().toString().isEmpty() ? mApp.air_temp_lower_threshold_night_time:Double.parseDouble(belowtext_night.getText().toString());
                        mApp.air_temp_upper_threshold_night_time=uppertext_night.getText().toString().isEmpty() ? mApp.air_temp_upper_threshold_night_time:Double.parseDouble(uppertext_night.getText().toString());
                        mApp.air_temp_lower_threshold_day_time=belowtext.getText().toString().isEmpty() ? mApp.air_temp_lower_threshold_day_time:Double.parseDouble(belowtext.getText().toString());
                        mApp.air_temp_upper_threshold_day_time=uppertext.getText().toString().isEmpty() ? mApp.air_temp_upper_threshold_day_time:Double.parseDouble(uppertext_night.getText().toString());
*/

                        if (!lowerbound.getText().toString().equals("")) {
                            mApp.air_temp_lower_threshold_day_time = Double.parseDouble(lowerbound.getText().toString());
                        }

                        if (!upperbound.getText().toString().equals("")) {
                            mApp.air_temp_upper_threshold_day_time = Double.parseDouble(upperbound.getText().toString());
                        }
                        if (!lowerbound_night.getText().toString().equals("")) {
                            mApp.air_temp_lower_threshold_night_time = Double.parseDouble(lowerbound_night.getText().toString());
                        }
                        if (!upperbound_night.getText().toString().equals("")) {
                            mApp.air_temp_upper_threshold_night_time = Double.parseDouble(upperbound_night.getText().toString());
                        }




                        // ERROR CHECKING FOR AIR TEMP

                        if (mApp.air_temp_lower_threshold_day_time<45){
                            mApp.air_temp_lower_threshold_day_time=45;
                        }
                        if (mApp.air_temp_lower_threshold_night_time<35){
                            mApp.air_temp_lower_threshold_night_time=35;
                        }
                        if (mApp.air_temp_upper_threshold_day_time>100){
                            mApp.air_temp_upper_threshold_day_time=100;
                        }
                        if (mApp.air_temp_upper_threshold_night_time>90){
                            mApp.air_temp_upper_threshold_night_time=90;
                        }



                        if (mApp.air_temp_lower_threshold_day_time>=mApp.air_temp_upper_threshold_day_time){
                            mApp.air_temp_lower_threshold_day_time=60;
                            mApp.air_temp_upper_threshold_day_time=80;
                        }
                        if (mApp.air_temp_lower_threshold_night_time>=mApp.air_temp_upper_threshold_night_time){
                            mApp.air_temp_lower_threshold_night_time=50;
                            mApp.air_temp_upper_threshold_night_time=70;
                        }








                        /*
                        We assign each of the UI settings parameters into temporary variables for
                        packing into key-value pairs. If the server connection is successful, than the local
                        variables (mApp.whatever) are updated so that the app is synchronized with the server.
                        */


                        // try and connect to the server.
                        /*RequestParams params = new RequestParams();
                        params.put("whatiwant", "push_settings");

                        // keeps from null pointer crashing
                        if (upperbound.getText().toString().equals("")) {
                            params.put("air_temp_upper_threshold_day_time",mApp.air_temp_upper_threshold_day_time);   // if they haven't entered, keep the old value
                        }
                        else {
                            params.put("air_temp_upper_threshold_day_time", Double.valueOf(upperbound.getText().toString()));
                        }

                        params.put("air_temp_upper_pushnotification_day_time", (air_temp_upper_push_notifications_checkbox.isChecked()) ? (1) : (0));
                        params.put("air_temp_upper_turn_on_fans_day_time",(air_temp_upper_on_extra_fans.isChecked()) ? (1) : (0));
                        params.put("air_temp_upper_turn_off_heating_element_day_time",(upper_air_temp_heating_element_checkbox.isChecked()) ? (1) : (0));
                        params.put("air_temp_upper_turn_off_space_heater_day_time", (upper_air_temp_space_heater_off_checkbox.isChecked()) ? (1) : (0));


                        // keeps from null pointer crashing
                        if (lowerbound.getText().toString().equals("")) {
                            params.put("air_temp_lower_threshold_day_time",mApp.air_temp_lower_threshold_day_time);   // if they haven't entered, keep the old value
                        }
                        else {
                            params.put("air_temp_lower_threshold_day_time", Double.valueOf(lowerbound.getText().toString()));
                        }


                        params.put("air_temp_lower_pushnotification_day_time", (air_temp_lower_threshold_push_notification_check_box.isChecked()) ? (1) : (0));
                        params.put("air_temp_lower_turn_off_fans_day_time", (air_temp_lower_turn_off_extra_fans_checkbox.isChecked()) ? (1) : (0));
                        params.put("air_temp_lower_turn_on_heating_element_day_time", (air_temp_lower_turn_on_heating_element_checkbox.isChecked()) ? (1) : (0));
                        params.put("air_temp_lower_turn_on_space_heater_day_time", (lower_threshold_turn_on_space_heater_check_box.isChecked()) ? (1) : (0));
*/

                        final ConstraintLayout screen = findViewById(R.id.constrainters);

                        RequestParams params = new RequestParams();
                        params.put("whatiwant", "testdata");
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get("http://192.168.1.13/mygarden/api.php", params,new JsonHttpResponseHandler() {
                                    @Override
                                    public void onStart() {
                                        Log.d("kirk", "got to onStart()");
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                                        Snackbar snackbar = Snackbar
                                                .make(screen, "Changes Saved Succsesfully!", Snackbar.LENGTH_LONG);
                                        snackbar.show();

                                        // save the variables from the UI

                                        // day time upper settings
                                        mApp.air_temp_upper_pushnotification_day_time = (air_temp_upper_push_notifications_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_upper_turn_on_fans_day_time = (air_temp_upper_on_extra_fans.isChecked()) ? (1) : (0);
                                        mApp.air_temp_upper_turn_off_heating_element_day_time = (upper_air_temp_heating_element_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_upper_turn_off_space_heater_day_time = (upper_air_temp_space_heater_off_checkbox.isChecked()) ? (1) : (0);

                                        //day time lower settings
                                        mApp.air_temp_lower_pushnotification_day_time = (air_temp_lower_threshold_push_notification_check_box.isChecked()) ? (1) : (0);
                                        mApp.air_temp_lower_turn_off_fans_day_time = (air_temp_lower_turn_off_extra_fans_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_lower_turn_on_heating_element_day_time = (air_temp_lower_turn_on_heating_element_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_lower_turn_on_space_heater_day_time = (lower_threshold_turn_on_space_heater_check_box.isChecked()) ? (1) : (0);

                                        // night time upper settings
                                        mApp.air_temp_upper_pushnotification_night_time = (air_temp_upper_push_notifications_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_upper_turn_on_fans_night_time = (air_temp_upper_on_extra_fans.isChecked()) ? (1) : (0);
                                        mApp.air_temp_upper_turn_off_heating_element_night_time = (upper_air_temp_heating_element_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_upper_turn_off_space_heater_night_time = (upper_air_temp_space_heater_off_checkbox.isChecked()) ? (1) : (0);

                                        //night time lower settings
                                        mApp.air_temp_lower_pushnotification_night_time = (air_temp_lower_threshold_push_notification_check_box.isChecked()) ? (1) : (0);
                                        mApp.air_temp_lower_turn_off_fans_night_time = (air_temp_lower_turn_off_extra_fans_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_lower_turn_on_heating_element_night_time = (air_temp_lower_turn_on_heating_element_checkbox.isChecked()) ? (1) : (0);
                                        mApp.air_temp_lower_turn_on_space_heater_night_time = (lower_threshold_turn_on_space_heater_check_box.isChecked()) ? (1) : (0);
                                    }

                                    @Override
                                    public void onFinish(){
                                        Log.d("kirk","got to onfinish");
                                        Snackbar snackbar = Snackbar
                                                .make(screen, "Failed to Connect! Changes not saved.", Snackbar.LENGTH_LONG);
                                        //snackbar.show();
                                    }
                                    @Override
                                    public void onRetry(int retryNo) {
                                        Log.d("kirk", "got to onRetry()");
                                    }
                                }
                        );  // this is the end of client.get line
                    }
                }
                )
                ;

                break;

            case "Humidity":

                // humidity title
                final TextView uppertext_humidity_day_time = new TextView(this);
                uppertext_humidity_day_time.setText("If day time humidity is above");
                uppertext_humidity_day_time.setTextSize(24);
                uppertext_humidity_day_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext_humidity_day_time.setPadding(8, 8, 8, 8);
                ll.addView(uppertext_humidity_day_time);

                // humidity upper threshold edit text
                final EditText upperbound_humidity_day_time = new EditText(this);
                upperbound_humidity_day_time.setHint(mApp.humidity_upper_threshold_day_time + getString(R.string.percentsign));
                upperbound_humidity_day_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound_humidity_day_time.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound_humidity_day_time.setTextSize(24);
                ll.addView(upperbound_humidity_day_time);

                // push notification for upper humidity
                final CheckBox upper_humidity_push_nofitication_check_box_day_time = new CheckBox(this);
                upper_humidity_push_nofitication_check_box_day_time.setText(getString(R.string.send_push));
                ll.addView(upper_humidity_push_nofitication_check_box_day_time);
                if (mApp.humidity_upper_pushnotification_day_time == 1) {
                    upper_humidity_push_nofitication_check_box_day_time.setChecked(true);
                } else {
                    upper_humidity_push_nofitication_check_box_day_time.setChecked(false);
                }

                // upper humidity extra fans on
                final CheckBox upper_humidity_extra_fans_on_day_time = new CheckBox(this);
                ll.addView(upper_humidity_extra_fans_on_day_time);
                upper_humidity_extra_fans_on_day_time.setText(getString(R.string.turn_on_fans));
                if (mApp.humidity_upper_turn_on_extra_fans_day_time == 1) {
                    upper_humidity_extra_fans_on_day_time.setChecked(true);
                } else {
                    upper_humidity_extra_fans_on_day_time.setChecked(false);
                }

                // upper_humidity_turn_off_fogger
                final CheckBox upper_humidity_turn_off_fogger_check_box_day_time = new CheckBox(this);
                ll.addView(upper_humidity_turn_off_fogger_check_box_day_time);
                upper_humidity_turn_off_fogger_check_box_day_time.setText(getString(R.string.turn_off_fogger));
                if (mApp.humidity_upper_turn_off_fogger_day_time == 1) {
                    upper_humidity_turn_off_fogger_check_box_day_time.setChecked(true);
                } else {
                    upper_humidity_turn_off_fogger_check_box_day_time.setChecked(false);
                }

                // upper humidity turn on space heater
                final CheckBox upper_humidity_turn_on_space_heater_checkbox_day_time = new CheckBox(this);
                ll.addView(upper_humidity_turn_on_space_heater_checkbox_day_time);
                upper_humidity_turn_on_space_heater_checkbox_day_time.setText(getString(R.string.turn_on_space_heater));
                if (mApp.humidity_upper_turn_on_space_heater_day_time ==1){
                    upper_humidity_turn_on_space_heater_checkbox_day_time.setChecked(true);
                }
                else {
                    upper_humidity_turn_on_space_heater_checkbox_day_time.setChecked(false);
                }

                // lower humidity title
                final TextView lower_humidity_title = new TextView(this);
                lower_humidity_title.setText(getString(R.string.hum_below));
                lower_humidity_title.setTextSize(24);
                lower_humidity_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_humidity_title.setPadding(8,8,8,8);
                ll.addView(lower_humidity_title);

                // lower humidity threshold edit text
                final EditText lower_humidity_threshold_edit_text_day_time = new EditText(this);
                lower_humidity_threshold_edit_text_day_time.setHint(mApp.humidity_lower_threshold_day_time + getString(R.string.percentsign));
                lower_humidity_threshold_edit_text_day_time.setInputType(InputType.TYPE_CLASS_NUMBER);
                lower_humidity_threshold_edit_text_day_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_humidity_threshold_edit_text_day_time.setTextSize(24);
                ll.addView(lower_humidity_threshold_edit_text_day_time);

                // lower humidity push notification check box
                final CheckBox low_humidity_push_notification_check_box_day_time = new CheckBox(this);
                low_humidity_push_notification_check_box_day_time.setText(getString(R.string.send_push));
                ll.addView(low_humidity_push_notification_check_box_day_time);
                if (mApp.humidity_lower_pushnotification_day_time ==1){
                    low_humidity_push_notification_check_box_day_time.setChecked(true);
                }
                else
                {
                    low_humidity_push_notification_check_box_day_time.setChecked(false);
                }

                // low humidity turn off extra fans
                final CheckBox low_humidity_turn_off_extra_fans_day_time = new CheckBox(this);
                ll.addView(low_humidity_turn_off_extra_fans_day_time);
                low_humidity_turn_off_extra_fans_day_time.setText(getString(R.string.turn_off_fans));
                if (mApp.humidity_lower_turn_off_extra_fans_day_time ==1){
                    low_humidity_turn_off_extra_fans_day_time.setChecked(true);
                }
                else {
                    low_humidity_turn_off_extra_fans_day_time.setChecked(false);
                }

                // low humidity turn on fogger
                final CheckBox low_humidity_turn_on_fogger_day_time = new CheckBox(this);
                ll.addView(low_humidity_turn_on_fogger_day_time);
                low_humidity_turn_on_fogger_day_time.setText(getString(R.string.turn_on_fogger));
                if (mApp.humidity_lower_turn_on_fogger_day_time ==1){
                    low_humidity_turn_on_fogger_day_time.setChecked(true);
                }
                else {
                    low_humidity_turn_on_fogger_day_time.setChecked(false);
                }


                // low humidity turn off space heater
                final CheckBox low_humidity_turn_off_space_heater_checkbox_day_time = new CheckBox(this);
                ll.addView(low_humidity_turn_off_space_heater_checkbox_day_time);
                low_humidity_turn_off_space_heater_checkbox_day_time.setText(getString(R.string.turn_off_space_heater));
                if (mApp.humidity_lower_turn_off_space_heater_day_time==1){
                    low_humidity_turn_off_space_heater_checkbox_day_time.setChecked(true);
                }
                else{
                    low_humidity_turn_off_space_heater_checkbox_day_time.setChecked(false);
                }

                // HUMIDITY NIGHT TIME

                // humidity title
                final TextView uppertext_humidity_night_time = new TextView(this);
                uppertext_humidity_night_time.setText("If night time humidity is above");
                uppertext_humidity_night_time.setTextSize(24);
                uppertext_humidity_night_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                uppertext_humidity_night_time.setPadding(8, 8, 8, 8);
                ll.addView(uppertext_humidity_night_time);

// humidity upper threshold edit text
                final EditText upperbound_humidity_night_time = new EditText(this);
                upperbound_humidity_night_time.setHint(mApp.humidity_upper_threshold_night_time + getString(R.string.percentsign));
                upperbound_humidity_night_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upperbound_humidity_night_time.setInputType(InputType.TYPE_CLASS_NUMBER);
                upperbound_humidity_night_time.setTextSize(24);
                ll.addView(upperbound_humidity_night_time);

// push notification for upper humidity
                final CheckBox upper_humidity_push_nofitication_check_box_night_time = new CheckBox(this);
                upper_humidity_push_nofitication_check_box_night_time.setText(getString(R.string.send_push));
                ll.addView(upper_humidity_push_nofitication_check_box_night_time);
                if (mApp.humidity_upper_pushnotification_night_time == 1) {
                    upper_humidity_push_nofitication_check_box_night_time.setChecked(true);
                } else {
                    upper_humidity_push_nofitication_check_box_night_time.setChecked(false);
                }

// upper humidity extra fans on
                final CheckBox upper_humidity_extra_fans_on_night_time = new CheckBox(this);
                ll.addView(upper_humidity_extra_fans_on_night_time);
                upper_humidity_extra_fans_on_night_time.setText(getString(R.string.turn_on_fans));
                if (mApp.humidity_upper_turn_on_extra_fans_night_time == 1) {
                    upper_humidity_extra_fans_on_night_time.setChecked(true);
                } else {
                    upper_humidity_extra_fans_on_night_time.setChecked(false);
                }

// upper_humidity_turn_off_fogger
                final CheckBox upper_humidity_turn_off_fogger_check_box_night_time = new CheckBox(this);
                ll.addView(upper_humidity_turn_off_fogger_check_box_night_time);
                upper_humidity_turn_off_fogger_check_box_night_time.setText(getString(R.string.turn_off_fogger));
                if (mApp.humidity_upper_turn_off_fogger_night_time == 1) {
                    upper_humidity_turn_off_fogger_check_box_night_time.setChecked(true);
                } else {
                    upper_humidity_turn_off_fogger_check_box_night_time.setChecked(false);
                }

// upper humidity turn on space heater
                final CheckBox upper_humidity_turn_on_space_heater_checkbox_night_time = new CheckBox(this);
                ll.addView(upper_humidity_turn_on_space_heater_checkbox_night_time);
                upper_humidity_turn_on_space_heater_checkbox_night_time.setText(getString(R.string.turn_on_space_heater));
                if (mApp.humidity_upper_turn_on_space_heater_night_time ==1){
                    upper_humidity_turn_on_space_heater_checkbox_night_time.setChecked(true);
                }

// lower humidity title
                final TextView lower_humidity_title_night = new TextView(this);
                lower_humidity_title_night.setText(getString(R.string.hum_below));
                lower_humidity_title_night.setTextSize(24);
                lower_humidity_title_night.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_humidity_title_night.setPadding(8,8,8,8);
                ll.addView(lower_humidity_title_night);

// lower humidity threshold edit text
                final EditText lower_humidity_threshold_edit_text_night_time = new EditText(this);
                lower_humidity_threshold_edit_text_night_time.setHint(mApp.humidity_lower_threshold_night_time + getString(R.string.percentsign));
                lower_humidity_threshold_edit_text_night_time.setInputType(InputType.TYPE_CLASS_NUMBER);
                lower_humidity_threshold_edit_text_night_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lower_humidity_threshold_edit_text_night_time.setTextSize(24);
                ll.addView(lower_humidity_threshold_edit_text_night_time);

// lower humidity push notification check box
                final CheckBox low_humidity_push_notification_check_box_night_time = new CheckBox(this);
                low_humidity_push_notification_check_box_night_time.setText(getString(R.string.send_push));
                ll.addView(low_humidity_push_notification_check_box_night_time);
                if (mApp.humidity_lower_pushnotification_night_time ==1){
                    low_humidity_push_notification_check_box_night_time.setChecked(true);
                }
                else
                {
                    low_humidity_push_notification_check_box_night_time.setChecked(false);
                }

// low humidity turn off extra fans
                final CheckBox low_humidity_turn_off_extra_fans_night_time = new CheckBox(this);
                ll.addView(low_humidity_turn_off_extra_fans_night_time);
                low_humidity_turn_off_extra_fans_night_time.setText(getString(R.string.turn_off_fans));
                if (mApp.humidity_lower_turn_off_extra_fans_night_time ==1){
                    low_humidity_turn_off_extra_fans_night_time.setChecked(true);
                }
                else {
                    low_humidity_turn_off_extra_fans_night_time.setChecked(false);
                }

// low humidity turn on fogger
                final CheckBox low_humidity_turn_on_fogger_night_time = new CheckBox(this);
                ll.addView(low_humidity_turn_on_fogger_night_time);
                low_humidity_turn_on_fogger_night_time.setText(getString(R.string.turn_on_fogger));
                if (mApp.humidity_lower_turn_on_fogger_night_time ==1){
                    low_humidity_turn_on_fogger_night_time.setChecked(true);
                }
                else {
                    low_humidity_turn_on_fogger_night_time.setChecked(false);
                }


                // low humidity turn off space heater
                CheckBox low_humidity_turn_off_space_heater_checkbox_night_time = new CheckBox(this);
                ll.addView(low_humidity_turn_off_space_heater_checkbox_night_time);
                low_humidity_turn_off_space_heater_checkbox_night_time.setText(getString(R.string.turn_off_space_heater));
                if (mApp.humidity_lower_turn_off_space_heater_night_time==1){
                    low_humidity_turn_off_space_heater_checkbox_night_time.setChecked(true);
                }
                else{
                    low_humidity_turn_off_space_heater_checkbox_night_time.setChecked(false);
                }















                //  submit changes button
                final Button buttsoup1 = new Button(this);
                buttsoup1.setText(getString(R.string.save_changes));
                ll.addView(buttsoup1);
                buttsoup1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (!lower_humidity_threshold_edit_text_day_time.getText().toString().equals("")) {
                            mApp.humidity_lower_threshold_day_time = Double.parseDouble(lower_humidity_threshold_edit_text_day_time.getText().toString());
                        }

                        if (!upperbound_humidity_day_time.getText().toString().equals("")) {
                            mApp.humidity_upper_threshold_day_time = Double.parseDouble(upperbound_humidity_day_time.getText().toString());
                        }
                        if (!lower_humidity_threshold_edit_text_night_time.getText().toString().equals("")) {
                            mApp.humidity_lower_threshold_night_time = Double.parseDouble(lower_humidity_threshold_edit_text_night_time.getText().toString());
                        }
                        if (!upperbound_humidity_night_time.getText().toString().equals("")) {
                            mApp.humidity_upper_threshold_night_time = Double.parseDouble(upperbound_humidity_night_time.getText().toString());
                        }


                        // ERROR CHECKING FOR HUMIDITY

                        if (mApp.humidity_lower_threshold_day_time < 50) {
                            mApp.humidity_lower_threshold_day_time = 50;
                        }
                        if (mApp.humidity_lower_threshold_night_time < 40) {
                            mApp.humidity_lower_threshold_night_time = 40;
                        }
                        if (mApp.humidity_upper_threshold_day_time > 80) {
                            mApp.humidity_upper_threshold_day_time = 80;
                        }
                        if (mApp.humidity_upper_threshold_night_time > 70) {
                            mApp.humidity_upper_threshold_night_time = 70;
                        }


                        if (mApp.humidity_lower_threshold_day_time >= mApp.humidity_upper_threshold_day_time) {
                            mApp.humidity_lower_threshold_day_time = 60;
                            mApp.humidity_upper_threshold_day_time = 80;
                        }
                        if (mApp.humidity_lower_threshold_night_time >= mApp.humidity_upper_threshold_night_time) {
                            mApp.humidity_lower_threshold_night_time = 50;
                            mApp.humidity_upper_threshold_night_time = 70;
                        }

                        // saving the changes in the checkboxes
                        // day time upper settings
                        mApp.humidity_upper_pushnotification_day_time = (upper_humidity_push_nofitication_check_box_day_time.isChecked()) ? (1) : (0);
                        mApp.humidity_upper_turn_on_extra_fans_day_time = (upper_humidity_extra_fans_on_day_time.isChecked()) ? (1) : (0);
                        mApp.humidity_upper_turn_off_fogger_day_time = (upper_humidity_turn_off_fogger_check_box_day_time.isChecked()) ? (1) : (0);
                        mApp.humidity_upper_turn_on_space_heater_day_time = (upper_humidity_turn_on_space_heater_checkbox_day_time.isChecked()) ? (1) : (0);

                        //day time lower settings
                        mApp.humidity_lower_pushnotification_day_time = (low_humidity_push_notification_check_box_day_time.isChecked()) ? (1) : (0);
                        mApp.humidity_lower_turn_off_extra_fans_day_time = (low_humidity_turn_off_extra_fans_day_time.isChecked()) ? (1) : (0);
                        mApp.humidity_lower_turn_on_fogger_day_time = (low_humidity_turn_on_fogger_day_time.isChecked()) ? (1) : (0);
                        mApp.humidity_lower_turn_off_space_heater_day_time = (low_humidity_turn_off_space_heater_checkbox_day_time.isChecked()) ? (1) : (0);


                        // night time upper settings
                        mApp.humidity_upper_pushnotification_night_time = (upper_humidity_push_nofitication_check_box_night_time.isChecked()) ? (1) : (0);
                        mApp.humidity_upper_turn_on_extra_fans_night_time = (upper_humidity_extra_fans_on_night_time.isChecked()) ? (1) : (0);
                        mApp.humidity_upper_turn_off_fogger_night_time = (upper_humidity_turn_off_fogger_check_box_night_time.isChecked()) ? (1) : (0);
                        mApp.humidity_upper_turn_on_space_heater_night_time = (upper_humidity_turn_on_space_heater_checkbox_night_time.isChecked()) ? (1) : (0);

                    //night time lower settings
                        mApp.humidity_lower_pushnotification_night_time = (low_humidity_push_notification_check_box_night_time.isChecked()) ? (1) : (0);
                        mApp.humidity_lower_turn_off_extra_fans_night_time = (low_humidity_turn_off_extra_fans_night_time.isChecked()) ? (1) : (0);
                        mApp.humidity_lower_turn_on_fogger_night_time = (low_humidity_turn_on_fogger_night_time.isChecked()) ? (1) : (0);
                        mApp.humidity_lower_turn_off_space_heater_night_time = (low_humidity_turn_off_space_heater_checkbox_day_time.isChecked()) ? (1) : (0);




                    }
                }
                );





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
                final CheckBox tvoc_upper_threshold_push_notifications = new CheckBox(this);
                tvoc_upper_threshold_push_notifications.setText(getString(R.string.send_push));
                ll.addView(tvoc_upper_threshold_push_notifications);
                if (mApp.TVOC_upper_pushnotifications ==1){
                    tvoc_upper_threshold_push_notifications.setChecked(true);
                }
                else{
                    tvoc_upper_threshold_push_notifications.setChecked(false);
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
                buttsoup2.setOnClickListener(new View.OnClickListener() {
                    @Override
                        public void onClick(View view) {
                        mApp.TVOC_lower_pushnotification = (tvoc_lower_push_notification_checkbox.isChecked()) ? (1) : (0);
                        mApp.TVOC_upper_pushnotifications = (tvoc_upper_threshold_push_notifications.isChecked()) ? (1) : (0);

                        if (!tvoc_lower_threshold_edit_text.getText().toString().equals("")) {
                            mApp.TVOC_lower_threshold = Double.parseDouble(tvoc_lower_threshold_edit_text.getText().toString());
                        }

                        if (!tvoc_upper_edit_text.getText().toString().equals("")) {
                            mApp.TVOC_upper_threshold = Double.parseDouble(tvoc_upper_edit_text.getText().toString());
                        }


                        // ERROR CHECKING FOR HUMIDITY

                        if (mApp.TVOC_lower_threshold < 400) {
                            mApp.TVOC_lower_threshold = 400;
                        }
                        if (mApp.TVOC_upper_threshold > 1000) {
                            mApp.TVOC_upper_threshold = 1000;
                        }
                        if (mApp.TVOC_upper_threshold <= mApp.TVOC_lower_threshold) {
                            mApp.TVOC_lower_threshold = 600;
                            mApp.TVOC_upper_threshold=800;
                        }


                    }
                }
                );
                break;

            case "CO2":

                //CO2 upper title
                final TextView CO2_title = new TextView(this);
                CO2_title.setText(getString(R.string.CO2_above));
                CO2_title.setTextSize(24);
                CO2_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_title.setPadding(8,8,8,8);
                ll.addView(CO2_title);

// CO2 upper threshold edit text
                final EditText CO2_upper_edit_text = new EditText(this);
                CO2_upper_edit_text.setHint(mApp.CO2_upper_threshold + getString(R.string.ppm));
                CO2_upper_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_upper_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                CO2_upper_edit_text.setTextSize(24);
                ll.addView(CO2_upper_edit_text);

// CO2 upper threshold push notifications
                final CheckBox CO2_upper_threshold_push_notifications = new CheckBox(this);
                CO2_upper_threshold_push_notifications.setText(getString(R.string.send_push));
                ll.addView(CO2_upper_threshold_push_notifications);
                if (mApp.CO2_upper_pushnotifications ==1){
                    CO2_upper_threshold_push_notifications.setChecked(true);
                }
                else{
                    CO2_upper_threshold_push_notifications.setChecked(false);
                }

// CO2 lower threshold lower title
                final TextView CO2_lower_threshold_title = new TextView(this);
                CO2_lower_threshold_title.setText(getString(R.string.CO2_below));
                CO2_lower_threshold_title.setTextSize(24);
                CO2_lower_threshold_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_lower_threshold_title.setPadding(8,8,8,8);
                ll.addView(CO2_lower_threshold_title);

// CO2 lower threshold edit text
                final EditText CO2_lower_threshold_edit_text = new EditText(this);
                CO2_lower_threshold_edit_text.setHint(mApp.CO2_lower_threshold + getString(R.string.ppm));
                CO2_lower_threshold_edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
                CO2_lower_threshold_edit_text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                CO2_lower_threshold_edit_text.setTextSize(24);
                ll.addView(CO2_lower_threshold_edit_text);

// CO2 lower push notification
                final CheckBox CO2_lower_push_notification_checkbox = new CheckBox(this);
                CO2_lower_push_notification_checkbox.setText(getString(R.string.send_push));
                ll.addView(CO2_lower_push_notification_checkbox);
                if (mApp.CO2_lower_pushnotification==1){
                    CO2_lower_push_notification_checkbox.setChecked(true);
                }
                else{
                    CO2_lower_push_notification_checkbox.setChecked(false);
                }

// save changes
                final Button save_change_button_CO2 = new Button(this);
                save_change_button_CO2.setText(getString(R.string.save_changes));
                ll.addView(save_change_button_CO2);
                save_change_button_CO2.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     mApp.CO2_lower_pushnotification = (CO2_lower_push_notification_checkbox.isChecked()) ? (1) : (0);
                                                     mApp.CO2_upper_pushnotifications = (CO2_upper_threshold_push_notifications.isChecked()) ? (1) : (0);

                                                     if (!CO2_lower_threshold_edit_text.getText().toString().equals("")) {
                                                         mApp.CO2_lower_threshold = Double.parseDouble(CO2_lower_threshold_edit_text.getText().toString());
                                                     }

                                                     if (!CO2_upper_edit_text.getText().toString().equals("")) {
                                                         mApp.CO2_upper_threshold = Double.parseDouble(CO2_upper_edit_text.getText().toString());
                                                     }


                                                     // ERROR CHECKING FOR CO2

                                                     if (mApp.CO2_lower_threshold < 400) {
                                                         mApp.CO2_lower_threshold = 400;
                                                     }
                                                     if (mApp.CO2_upper_threshold > 1000) {
                                                         mApp.CO2_upper_threshold = 1000;
                                                     }
                                                     if (mApp.CO2_upper_threshold <= mApp.CO2_lower_threshold) {
                                                         mApp.CO2_lower_threshold = 600;
                                                         mApp.CO2_upper_threshold=800;
                                                     }


                                                 }
                                             }
                );


                break;

            case "Solution Temperature":
                // upper solution temperature title
                final TextView upper_solution_temperature_title_text_view = new TextView(this);
                upper_solution_temperature_title_text_view.setText("The solution temperature reflects the system settings of the air temperature.");
                upper_solution_temperature_title_text_view.setTextSize(24);
                upper_solution_temperature_title_text_view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                upper_solution_temperature_title_text_view.setPadding(8,8,8,8);
                ll.addView(upper_solution_temperature_title_text_view);

                // upper solution temperature edit text
                /*final EditText upper_solution_temperature_edit_text = new EditText(this);
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
                ll.addView(buttsoup4);*/
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
                if (mApp.do_upper_push_notification==1){
                    do_upper_threshold_push_notification_checkbox.setChecked(true);
                }
                else {
                    do_upper_threshold_push_notification_checkbox.setChecked(false);
                }

                // do upper turn extra air pumps off
                final CheckBox do_upper_turn_extra_air_pumps_off = new CheckBox(this);
                do_upper_turn_extra_air_pumps_off.setText(getString(R.string.turn_off_air_pump));
                ll.addView(do_upper_turn_extra_air_pumps_off);
                if (mApp.do_upper_turn_off_extra_pump==1){
                    do_upper_turn_extra_air_pumps_off.setChecked(true);
                }
                else{
                    do_upper_turn_extra_air_pumps_off.setChecked(false);
                }


                // do upper add water
                final CheckBox do_upper_add_water_checkbox = new CheckBox(this);
                do_upper_add_water_checkbox.setText(getString(R.string.add_water));
                ll.addView(do_upper_add_water_checkbox);
                if (mApp.do_upper_add_water==1){
                    do_upper_add_water_checkbox.setChecked(true);
                }
                else{
                    do_upper_add_water_checkbox.setChecked(false);
                }

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
                if (mApp.do_lower_push_notification==1){
                    do_lower_send_push_notification_checkbox.setChecked(true);
                }
                else {
                    do_lower_send_push_notification_checkbox.setChecked(false);
                }

                // do lower turn extra pumps on
                final CheckBox do_lower_turn_extra_pumps_on= new CheckBox(this);
                do_lower_turn_extra_pumps_on.setText(getString(R.string.turn_on_extra_air_pump));
                ll.addView(do_lower_turn_extra_pumps_on);
                if (mApp.do_lower_turn_on_extra_pump==1){
                    do_lower_turn_extra_pumps_on.setChecked(true);
                }
                else{
                    do_lower_turn_extra_pumps_on.setChecked(false);
                }


                // do lower add hypochloric acid
                final CheckBox do_lower_add_hypochloric_acid = new CheckBox(this);
                do_lower_add_hypochloric_acid.setText(getString(R.string.add_hypochloric));
                ll.addView(do_lower_add_hypochloric_acid);
                if (mApp.do_lower_add_hypochloric_acid==1){
                    do_lower_add_hypochloric_acid.setChecked(true);
                }
                else{
                    do_lower_add_hypochloric_acid.setChecked(false);
                }

                // lower do add peroxide
                final CheckBox do_lower_add_peroxide = new CheckBox(this);
                do_lower_add_peroxide.setText(getString(R.string.add_peroxide));
                ll.addView(do_lower_add_peroxide);
                if (mApp.do_lower_add_hydrogen_peroxide == 1) {
                    do_lower_add_hypochloric_acid.setChecked(true);
                }
                else{
                    do_lower_add_hypochloric_acid.setChecked(false);
                }

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
                if (mApp.orp_upper_push_notification==1){
                    orp_upper_push_notification_checkbox.setChecked(true);
                }
                else {
                    orp_upper_push_notification_checkbox.setChecked(false);
                }

                // orp add upper water checkbox
                final CheckBox orp_upper_add_water_checkbox = new CheckBox(this);
                orp_upper_add_water_checkbox.setText(getString(R.string.add_water));
                ll.addView(orp_upper_add_water_checkbox);
                if (mApp.orp_upper_add_water==1){
                    orp_upper_add_water_checkbox.setChecked(true);
                }
                else {
                    orp_upper_add_water_checkbox.setChecked(false);
                }

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
                if (mApp.orp_lower_push_notification==1){
                    orp_lower_push_notification_checkbox.setChecked(true);
                }
                else{
                    orp_lower_push_notification_checkbox.setChecked(false);
                }

                // orp lower add peroxide
                final CheckBox orp_lower_add_peroxide_checkbox = new CheckBox(this);
                orp_lower_add_peroxide_checkbox.setText(getString(R.string.add_peroxide));
                ll.addView(orp_lower_add_peroxide_checkbox);
                if (mApp.orp_lower_add_hydrogen_peroxide==1){
                    orp_lower_add_peroxide_checkbox.setChecked(true);
                }
                else {
                    orp_lower_add_peroxide_checkbox.setChecked(false);
                }

                // orp lower add hypochloric
                final CheckBox orp_lower_add_hypochloric_checkbox = new CheckBox(this);
                orp_lower_add_hypochloric_checkbox.setText(getString(R.string.add_hypochloric));
                ll.addView(orp_lower_add_hypochloric_checkbox);
                if (mApp.orp_lower_add_hydrogen_peroxide==1){
                    orp_lower_add_hypochloric_checkbox.setChecked(true);
                }
                else {
                    orp_lower_add_hypochloric_checkbox.setChecked(false);
                }

                // orp add base
                final CheckBox orp_lower_add_base = new CheckBox(this);
                orp_lower_add_base.setText(getString(R.string.add_base));
                ll.addView(orp_lower_add_base);
                if (mApp.orp_lower_add_base==1){
                    orp_lower_add_peroxide_checkbox.setChecked(true);
                }
                else {
                    orp_lower_add_peroxide_checkbox.setChecked(false);
                }

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
                if (mApp.pH_upper_push_notification==1){
                    pH_upper_push_notification_checkbox.setChecked(true);
                }
                else {
                    pH_upper_push_notification_checkbox.setChecked(false);
                }

                // pH upper add acid
                final CheckBox ph_upper_add_acid_checkbox = new CheckBox(this);
                ph_upper_add_acid_checkbox.setText(getString(R.string.add_acid));
                ll.addView(ph_upper_add_acid_checkbox);
                if (mApp.pH_upper_add_acid==1){
                    ph_upper_add_acid_checkbox.setChecked(true);
                }
                else {
                    ph_upper_add_acid_checkbox.setChecked(false);
                }

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
                if (mApp.pH_lower_push_notification==1){
                    lower_ph_push_notification_checkbox.setChecked(true);
                }
                else {
                    lower_ph_push_notification_checkbox.setChecked(false);
                }

                // lower ph add base checkbox
                final CheckBox lower_ph_add_base_checkbox = new CheckBox(this);
                lower_ph_add_base_checkbox.setText(getString(R.string.add_base));
                ll.addView(lower_ph_add_base_checkbox);
                if (mApp.pH_lower_add_base==1){
                    lower_ph_add_base_checkbox.setChecked(true);
                }
                else{
                    lower_ph_add_base_checkbox.setChecked(false);
                }

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
                if (mApp.reservoirs_need_refilling==1){
                    reservoirs_checkbox.setChecked(true);
                }
                else {
                    reservoirs_checkbox.setChecked(false);
                }

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
                if (mApp.canopy_height_push_notification==1){
                    canopy_push_notification_checkbox.setChecked(true);
                }
                else {
                    canopy_push_notification_checkbox.setChecked(false);
                }

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
                if (mApp.light_height_adjustment_push_notification==1){
                    light_height_push_checkbox.setChecked(true);
                }
                else {
                    light_height_push_checkbox.setChecked(false);
                }

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
