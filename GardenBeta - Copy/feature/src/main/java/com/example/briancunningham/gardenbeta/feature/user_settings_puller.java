package com.example.briancunningham.gardenbeta.feature;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import static java.lang.Double.valueOf;

public class user_settings_puller {

    user_settings_puller(final ConstraintLayout toplevellayout, final MyAppApplication mApp, final String stringy){

        //call the server for the user settings
        RequestParams params = new RequestParams();
        params.put("whatiwant", "pull_settings");
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(1500);
        client.get("http://24.197.216.190/mygarden/api.php", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        //Log.d("spock", "got to onStart()");
                    }

                    @Override
                    public void onFinish(){
                        Snackbar snackbar = Snackbar
                                .make(toplevellayout, "Failed to Connect! User Settings not pulled from Server.", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        Log.d("spock", "got to onRetry()");
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Log.d("spock", "got to onSuccess()");
                        String thingtochew = response.toString();

                        Snackbar snackbar = Snackbar
                                .make(toplevellayout, "Settings pulled from Server!", Snackbar.LENGTH_LONG);
                        snackbar.show();














        //clean up escape characters and payload separators
        if (thingtochew.contains("\\n"))
        {
            thingtochew=thingtochew.replace("\\n"," ");
        }
        if (thingtochew.contains(">"))
        {
            thingtochew=thingtochew.replace(">"," >");
        }

        if (thingtochew.contains("<"))
        {
            thingtochew=thingtochew.replace("<","< ");
        }

        if (thingtochew.contains("payload.\",\"data\":\""))
        {
            thingtochew=thingtochew.replace("payload.\",\"data\":\""," ");
        }

        if (thingtochew.contains("\"}"))
        {
            thingtochew=thingtochew.replace("\"}"," ");
        }



        String words[] = thingtochew.split(" ");
        for (int i = 1; i < words.length; i++) {


            //air temperature
            if (words[i].equals("air_temp_upper_threshold_day_time"))
                mApp.air_temp_upper_threshold_day_time =valueOf(words[i+1]);

            else if (words[i].equals("air_temp_upper_pushnotification_day_time"))
                mApp.air_temp_upper_pushnotification_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_on_fans_day_time"))
                mApp.air_temp_upper_turn_on_fans_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_off_heating_element_day_time"))
                mApp.air_temp_upper_turn_off_heating_element_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_off_space_heater_day_time"))
                mApp.air_temp_upper_turn_off_space_heater_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_threshold_day_time"))
                mApp.air_temp_lower_threshold_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_pushnotification_day_time"))
                mApp.air_temp_lower_pushnotification_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_off_fans_day_time"))
                mApp.air_temp_lower_turn_off_fans_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_on_heating_element_day_time"))
                mApp.air_temp_lower_turn_on_heating_element_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_on_space_heater_day_time"))
                mApp.air_temp_lower_turn_on_space_heater_day_time = valueOf(words[i + 1]);


            //air temperature
            if (words[i].equals("air_temp_upper_threshold_night_time"))
                mApp.air_temp_upper_threshold_night_time =valueOf(words[i+1]);

            else if (words[i].equals("air_temp_upper_pushnotification_night_time"))
                mApp.air_temp_upper_pushnotification_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_on_fans_night_time"))
                mApp.air_temp_upper_turn_on_fans_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_off_heating_element_night_time"))
                mApp.air_temp_upper_turn_off_heating_element_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_off_space_heater_night_time"))
                mApp.air_temp_upper_turn_off_space_heater_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_threshold_night_time"))
                mApp.air_temp_lower_threshold_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_pushnotification_night_time"))
                mApp.air_temp_lower_pushnotification_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_off_fans_night_time"))
                mApp.air_temp_lower_turn_off_fans_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_on_heating_element_night_time"))
                mApp.air_temp_lower_turn_on_heating_element_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_on_space_heater_night_time"))
                mApp.air_temp_lower_turn_on_space_heater_night_time = valueOf(words[i + 1]);


                // humidity

            else if (words[i].equals("humidity_upper_threshold_day_time"))
                mApp.humidity_upper_threshold_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_pushnotification_day_time"))
                mApp.humidity_upper_pushnotification_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_on_extra_fans_day_time"))
                mApp.humidity_upper_turn_on_extra_fans_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_off_fogger_day_time"))
                mApp.humidity_upper_turn_off_fogger_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_on_space_heater_day_time"))
                mApp.humidity_upper_turn_on_space_heater_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_threshold_day_time"))
                mApp.humidity_lower_threshold_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_pushnotification_day_time"))
                mApp.humidity_lower_pushnotification_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_off_extra_fans_day_time"))
                mApp.humidity_lower_turn_off_extra_fans_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_off_space_heater_day_time"))
                mApp.humidity_lower_turn_off_space_heater_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_on_fogger_day_time"))
                mApp.humidity_lower_turn_on_fogger_day_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_threshold_night_time"))
                mApp.humidity_upper_threshold_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_pushnotification_night_time"))
                mApp.humidity_upper_pushnotification_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_on_extra_fans_night_time"))
                mApp.humidity_upper_turn_on_extra_fans_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_off_fogger_night_time"))
                mApp.humidity_upper_turn_off_fogger_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_on_space_heater_night_time"))
                mApp.humidity_upper_turn_on_space_heater_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_threshold_night_time"))
                mApp.humidity_lower_threshold_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_pushnotification_night_time"))
                mApp.humidity_lower_pushnotification_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_off_extra_fans_night_time"))
                mApp.humidity_lower_turn_off_extra_fans_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_off_space_heater_night_time"))
                mApp.humidity_lower_turn_off_space_heater_night_time = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_on_fogger_night_time"))
                mApp.humidity_lower_turn_on_fogger_night_time = valueOf(words[i + 1]);


                //TVOCS

            else if (words[i].equals("TVOC_upper_threshold"))
                mApp.TVOC_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("TVOC_upper_pushnotifications"))
                mApp.TVOC_upper_pushnotifications = valueOf(words[i + 1]);

            else if (words[i].equals("TVOC_lower_threshold"))
                mApp.TVOC_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("TVOC_lower_pushnotification"))
                mApp.TVOC_lower_pushnotification = valueOf(words[i + 1]);

                //CO2

            else if (words[i].equals("CO2_upper_threshold"))
                mApp.CO2_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("CO2_upper_pushnotifications"))
                mApp.CO2_upper_pushnotifications = valueOf(words[i + 1]);

            else if (words[i].equals("CO2_lower_threshold"))
                mApp.CO2_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("CO2_lower_pushnotification"))
                mApp.CO2_lower_pushnotification = valueOf(words[i + 1]);

                // solution temp

            /*else if (words[i].equals("slntemp_upper_threshold"))
                mApp.slntemp_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("slntemp_upper_pushnotification"))
                mApp.slntemp_upper_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("slntemp_upper_turn_off_space_heater"))
                mApp.slntemp_upper_turn_off_space_heater = valueOf(words[i + 1]);

            else if (words[i].equals("slntemp_upper_turn_off_heating_element"))
                mApp.slntemp_upper_turn_off_heating_element = valueOf(words[i + 1]);

            else if (words[i].equals("slntemp_lower_threshold"))
                mApp.slntemp_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("slntemp_lower_pushnotification"))
                mApp.slntemp_lower_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("slntemp_lower_turn_on_space_heater"))
                mApp.slntemp_lower_turn_on_space_heater = valueOf(words[i + 1]);

            else if (words[i].equals("CO2_lower_pushnotification"))
                mApp.slntemp_lower_turn_on_heating_element = valueOf(words[i + 1]);*/


                // TDS

            else if (words[i].equals("tds_upper_threshold"))
                mApp.tds_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("tds_upper_push_notification"))
                mApp.tds_upper_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("tds_upper_add_water"))
                mApp.tds_upper_add_water = valueOf(words[i + 1]);

            else if (words[i].equals("tds_lower_threshold"))
                mApp.tds_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("tds_lower_pushnotification"))
                mApp.tds_lower_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("tds_add_florabloom"))
                mApp.tds_add_florabloom = valueOf(words[i + 1]);

            else if (words[i].equals("tds_add_floragro"))
                mApp.tds_add_floragro = valueOf(words[i + 1]);

            else if (words[i].equals("tds_add_floramicro"))
                mApp.tds_add_floramicro = valueOf(words[i + 1]);

                // DO

            else if (words[i].equals("do_upper_threshold"))
                mApp.do_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("do_upper_push_notification"))
                mApp.do_upper_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("do_upper_add_water"))
                mApp.do_upper_add_water = valueOf(words[i + 1]);

            else if (words[i].equals("do_upper_turn_off_extra_pump"))
                mApp.do_upper_turn_off_extra_pump = valueOf(words[i + 1]);

            else if (words[i].equals("do_lower_threshold"))
                mApp.do_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("do_lower_push_notification"))
                mApp.do_lower_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("do_lower_add_hypochloric_acid"))
                mApp.do_lower_add_hypochloric_acid = valueOf(words[i + 1]);

            else if (words[i].equals("do_lower_add_hydrogen_peroxide"))
                mApp.do_lower_add_hydrogen_peroxide = valueOf(words[i + 1]);


                // ORP

            else if (words[i].equals("orp_upper_threshold"))
                mApp.orp_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("orp_upper_push_notification"))
                mApp.orp_upper_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("orp_upper_add_water"))
                mApp.orp_upper_add_water = valueOf(words[i + 1]);

            else if (words[i].equals("orp_lower_threshold"))
                mApp.orp_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("orp_lower_push_notification"))
                mApp.orp_lower_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("orp_lower_add_hydrogen_peroxide"))
                mApp.orp_lower_add_hydrogen_peroxide = valueOf(words[i + 1]);

            else if (words[i].equals("orp_lower_add_hypochloric_acid"))
                mApp.orp_lower_add_hypochloric_acid = valueOf(words[i + 1]);

            else if (words[i].equals("orp_lower_add_base"))
                mApp.orp_lower_add_base = valueOf(words[i + 1]);


                // pH

            else if (words[i].equals("pH_lower_threshold"))
                mApp.pH_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("pH_lower_push_notification"))
                mApp.pH_lower_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("pH_lower_add_base"))
                mApp.pH_lower_add_base = valueOf(words[i + 1]);

            else if (words[i].equals("pH_upper_add_acid"))
                mApp.pH_upper_add_acid = valueOf(words[i + 1]);

            else if (words[i].equals("pH_upper_push_notification"))
                mApp.pH_upper_push_notification = valueOf(words[i + 1]);

            else if (words[i].equals("pH_upper_add_acid"))
                mApp.pH_upper_add_acid = valueOf(words[i + 1]);

                // reservoirs

            /*else if (words[i].equals("reservoirs_need_refilling"))
                mApp.reservoirs_need_refilling = valueOf(words[i + 1]);

            // canopy height

            else if (words[i].equals("canopy_height_checkpoint"))
                mApp.canopy_height_checkpoint = valueOf(words[i + 1]);

            else if (words[i].equals("canopy_height_push_notification"))
                mApp.canopy_height_push_notification = valueOf(words[i + 1]);

            // light height

            else if (words[i].equals("light_height_target"))
                mApp.light_height_target = valueOf(words[i + 1]);*/


                // actuator settings

            else if (words[i].equals("am_enable"))
                mApp.am_enable = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump1"))
                mApp.am_pump1 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump2"))
                mApp.am_pump2 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump3"))
                mApp.am_pump3 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump4"))
                mApp.am_pump4 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump5"))
                mApp.am_pump5 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump6"))
                mApp.am_pump6 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump7"))
                mApp.am_pump7 = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_pump8"))
                mApp.am_pump8 = Integer.parseInt(words[i + 1]);


                // non pump actuators

            else if (words[i].equals("am_enable"))
                mApp.am_enable = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_space_heater"))
                mApp.am_space_heater = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_grow_light"))
                mApp.am_grow_light = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_fogger"))
                mApp.am_fogger = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_dc_motor"))
                mApp.am_dc_motor = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_extra_fans"))
                mApp.am_extra_fans = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_extra_air_pump"))
                mApp.am_extra_air_pump = Integer.parseInt(words[i + 1]);

            else if (words[i].equals("am_heating_element"))
                mApp.am_heating_element = Integer.parseInt(words[i + 1]);

            Log.d("spock","Item Number " + i + " is " + words[i]);
        }


        }
    });
    }
}

