package com.example.briancunningham.gardenbeta.feature;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

public class user_settings_pusher {


    user_settings_pusher(MyAppApplication mappy, final String stringy, final ConstraintLayout constrainty){

        Log.d("guitar","you called the user settings pusher function");
        Log.d("guitar", "my tvoc upper threshold is "+ mappy.TVOC_upper_threshold);

        // for snackbar
        //final ConstraintLayout screen = findViewById(R.id.constrainters);

        RequestParams params = new RequestParams();
        params.put("whatiwant", "push_settings");

        //adding all of the user settings to the parameters
        params.put("day_time_starts_at",mappy.day_time_starts_at);
        params.put("night_time_starts_at",mappy.night_time_starts_at);

        params.put("air_temp_upper_threshold_day_time",mappy.air_temp_upper_threshold_day_time);
        params.put("air_temp_upper_pushnotification_day_time",mappy.air_temp_upper_pushnotification_day_time);
        params.put("air_temp_upper_turn_on_fans_day_time",mappy.air_temp_upper_turn_on_fans_day_time);
        params.put("air_temp_upper_turn_off_heating_element_day_time",mappy.air_temp_upper_turn_off_heating_element_day_time);
        params.put("air_temp_upper_turn_off_space_heater_day_time",mappy.air_temp_upper_turn_off_space_heater_day_time);

        params.put("air_temp_lower_threshold_day_time",mappy.air_temp_lower_threshold_day_time);
        params.put("air_temp_lower_pushnotification_day_time",mappy.air_temp_lower_pushnotification_day_time);
        params.put("air_temp_lower_turn_off_fans_day_time",mappy.air_temp_lower_turn_off_fans_day_time);
        params.put("air_temp_lower_turn_on_heating_element_day_time",mappy.air_temp_lower_turn_on_heating_element_day_time);
        params.put("air_temp_lower_turn_on_space_heater_day_time",mappy.air_temp_lower_turn_on_space_heater_day_time);

        params.put("air_temp_upper_threshold_night_time",mappy.air_temp_upper_threshold_night_time);
        params.put("air_temp_upper_pushnotification_night_time",mappy.air_temp_upper_pushnotification_night_time);
        params.put("air_temp_upper_turn_on_fans_night_time",mappy.air_temp_upper_turn_on_fans_night_time);
        params.put("air_temp_upper_turn_off_heating_element_night_time",mappy.air_temp_upper_turn_off_heating_element_night_time);
        params.put("air_temp_upper_turn_off_space_heater_night_time",mappy.air_temp_upper_turn_off_space_heater_night_time);

        params.put("air_temp_lower_threshold_night_time",mappy.air_temp_lower_threshold_night_time);
        params.put("air_temp_lower_pushnotification_night_time",mappy.air_temp_lower_pushnotification_night_time);
        params.put("air_temp_lower_turn_off_fans_night_time",mappy.air_temp_lower_turn_off_fans_night_time);
        params.put("air_temp_lower_turn_on_heating_element_night_time",mappy.air_temp_lower_turn_on_heating_element_night_time);
        params.put("air_temp_lower_turn_on_space_heater_night_time",mappy.air_temp_lower_turn_on_space_heater_night_time);



        params.put("humidity_upper_threshold_day_time",mappy.humidity_upper_threshold_day_time);
        params.put("humidity_upper_pushnotification_day_time",mappy.humidity_upper_pushnotification_day_time);
        params.put("humidity_upper_turn_on_extra_fans_day_time",mappy.humidity_upper_turn_on_extra_fans_day_time);
        params.put("humidity_upper_turn_off_fogger_day_time",mappy.humidity_upper_turn_off_fogger_day_time);
        params.put("humidity_upper_turn_on_space_heater_day_time",mappy.humidity_upper_turn_on_space_heater_day_time);

        params.put("humidity_lower_threshold_day_time",mappy.humidity_lower_threshold_day_time);
        params.put("humidity_lower_pushnotification_day_time",mappy.humidity_lower_pushnotification_day_time);
        params.put("humidity_lower_turn_off_extra_fans_day_time",mappy.humidity_lower_turn_off_extra_fans_day_time);
        params.put("humidity_lower_turn_off_space_heater_day_time",mappy.humidity_lower_turn_off_space_heater_day_time);
        params.put("humidity_lower_turn_on_fogger_day_time",mappy.humidity_lower_turn_on_fogger_day_time);

        params.put("humidity_upper_threshold_night_time",mappy.humidity_upper_threshold_night_time);
        params.put("humidity_upper_pushnotification_night_time",mappy.humidity_upper_pushnotification_night_time);
        params.put("humidity_upper_turn_on_extra_fans_night_time",mappy.humidity_upper_turn_on_extra_fans_night_time);
        params.put("humidity_upper_turn_off_fogger_night_time",mappy.humidity_upper_turn_off_fogger_night_time);
        params.put("humidity_upper_turn_on_space_heater_night_time",mappy.humidity_upper_turn_on_space_heater_night_time);

        params.put("humidity_lower_threshold_night_time",mappy.humidity_lower_threshold_night_time);
        params.put("humidity_lower_pushnotification_night_time",mappy.humidity_lower_pushnotification_night_time);
        params.put("humidity_lower_turn_off_extra_fans_night_time",mappy.humidity_lower_turn_off_extra_fans_night_time);
        params.put("humidity_lower_turn_off_space_heater_night_time",mappy.humidity_lower_turn_off_space_heater_night_time);
        params.put("humidity_lower_turn_on_fogger_night_time",mappy.humidity_lower_turn_on_fogger_night_time);

        params.put("TVOC_upper_threshold",mappy.TVOC_upper_threshold);
        params.put("TVOC_upper_pushnotifications",mappy.TVOC_upper_pushnotifications);

        params.put("TVOC_lower_pushnotification",mappy.TVOC_lower_pushnotification);
        params.put("TVOC_lower_threshold",mappy.TVOC_lower_threshold);

        params.put("CO2_upper_threshold",mappy.CO2_upper_threshold);
        params.put("CO2_upper_pushnotifications",mappy.CO2_upper_pushnotifications);

        params.put("CO2_lower_threshold",mappy.CO2_lower_threshold);
        params.put("CO2_lower_pushnotification",mappy.CO2_lower_pushnotification);



        params.put("tds_upper_threshold",mappy.tds_upper_threshold);
        params.put("tds_upper_push_notification",mappy.tds_upper_push_notification);
        params.put("tds_upper_add_water",mappy.tds_upper_add_water);

        params.put("tds_lower_threshold",mappy.tds_lower_threshold);
        params.put("tds_lower_pushnotification",mappy.tds_lower_pushnotification);
        params.put("tds_add_florabloom",mappy.tds_add_florabloom);
        params.put("tds_add_floragro",mappy.tds_add_floragro);
        params.put("tds_add_floramicro",mappy.tds_add_floramicro);

        params.put("do_upper_threshold",mappy.do_upper_threshold);
        params.put("do_upper_push_notification",mappy.do_upper_push_notification);
        params.put("do_upper_add_water",mappy.do_upper_add_water);
        params.put("do_upper_turn_off_extra_pump",mappy.do_upper_turn_off_extra_pump);

        params.put("do_lower_threshold",mappy.do_lower_threshold);
        params.put("do_lower_push_notification",mappy.do_lower_push_notification);
        params.put("do_lower_add_hypochloric_acid",mappy.do_lower_add_hypochloric_acid);
        params.put("do_lower_add_hydrogen_peroxide",mappy.do_lower_add_hydrogen_peroxide);
        params.put("do_lower_turn_on_extra_pump",mappy.do_lower_turn_on_extra_pump);

        params.put("orp_upper_threshold",mappy.orp_upper_threshold);
        params.put("orp_upper_push_notification",mappy.orp_upper_push_notification);
        params.put("orp_upper_add_water",mappy.orp_upper_add_water);

        params.put("orp_lower_threshold",mappy.orp_lower_threshold);
        params.put("orp_lower_push_notification",mappy.orp_lower_push_notification);
        params.put("orp_lower_add_hydrogen_peroxide",mappy.orp_lower_add_hydrogen_peroxide);
        params.put("orp_lower_add_hypochloric_acid",mappy.orp_lower_add_hypochloric_acid);
        params.put("orp_lower_add_base",mappy.orp_lower_add_base);

        params.put("pH_upper_threshold",mappy.pH_upper_threshold);
        params.put("pH_lower_threshold",mappy.pH_lower_threshold);
        params.put("pH_upper_add_acid",mappy.pH_upper_add_acid);
        params.put("pH_lower_add_base",mappy.pH_lower_add_base);
        params.put("pH_upper_push_notification",mappy.pH_upper_push_notification);
        params.put("pH_lower_push_notification",mappy.pH_lower_push_notification);


        params.put("am_enable",mappy.am_enable);
        params.put("am_pump1",mappy.am_pump1);
        params.put("am_pump2",mappy.am_pump2);
        params.put("am_pump3",mappy.am_pump3);
        params.put("am_pump4",mappy.am_pump4);
        params.put("am_pump5",mappy.am_pump5);
        params.put("am_pump6",mappy.am_pump6);
        params.put("am_pump7",mappy.am_pump7);
        params.put("am_pump8",mappy.am_pump8);
        params.put("am_space_heater",mappy.am_space_heater);
        params.put("am_grow_light",mappy.am_grow_light);
        params.put("am_fogger",mappy.am_fogger);
        params.put("am_dc_motor",mappy.am_dc_motor);
        params.put("am_extra_fans",mappy.am_extra_fans);
        params.put("am_extra_air_pump",mappy.am_extra_air_pump);
        params.put("am_heating_element",mappy.am_heating_element);






        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(1500);
        client.get("http://192.168.1.13/mygarden/api.php", params,new JsonHttpResponseHandler() {
                    @Override
                    public void onStart(){
                        Log.d("kirk","got to onstart");
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Snackbar snackbar = Snackbar
                                .make(constrainty, "Changes Saved from " + stringy +  "!", Snackbar.LENGTH_LONG);
                        snackbar.show();

                        // save the variables from the UI


                    }


                    @Override
                    public void onFinish(){
                        Log.d("kirk","got to onfinish");
                        Snackbar snackbar = Snackbar
                                .make(constrainty, "Failed to Connect! Changes from " + stringy + " not saved.", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                    @Override
                    public void onRetry(int retryNo) {
                        Log.d("kirk", "got to onRetry()");
                    }
                }
        );  // this is the end of client.get line

    }

}
