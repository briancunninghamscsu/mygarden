package com.example.briancunningham.gardenbeta.feature;

import android.util.Log;

import static java.lang.Double.valueOf;

public class parse_for_user_settings {

    parse_for_user_settings(String thingtochew,MyAppApplication mApp){

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
            if (words[i].equals("air_temp_upper_threshold"))
                mApp.air_temp_upper_threshold=valueOf(words[i+1]);

            else if (words[i].equals("air_temp_upper_pushnotification"))
                mApp.air_temp_upper_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_on_fans"))
                mApp.air_temp_upper_turn_on_fans = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_off_heating_element"))
                mApp.air_temp_upper_turn_off_heating_element = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_upper_turn_off_space_heater"))
                mApp.air_temp_upper_turn_off_space_heater = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_threshold"))
                mApp.air_temp_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_pushnotification"))
                mApp.air_temp_lower_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_off_fans"))
                mApp.air_temp_lower_turn_off_fans = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_on_heating_element"))
                mApp.air_temp_lower_turn_on_heating_element = valueOf(words[i + 1]);

            else if (words[i].equals("air_temp_lower_turn_on_space_heater"))
                mApp.air_temp_lower_turn_on_space_heater = valueOf(words[i + 1]);


            // humidity

            else if (words[i].equals(" humidity_upper_threshold"))
                mApp. humidity_upper_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_pushnotification"))
                mApp.humidity_upper_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_on_extra_fans"))
                mApp.humidity_upper_turn_on_extra_fans = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_off_fogger"))
                mApp.humidity_upper_turn_off_fogger = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_upper_turn_on_space_heater"))
                mApp.humidity_upper_turn_on_space_heater = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_threshold"))
                mApp.humidity_lower_threshold = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_pushnotification"))
                mApp.humidity_lower_pushnotification = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_off_extra_fans"))
                mApp.humidity_lower_turn_off_extra_fans = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_off_space_heater"))
                mApp.humidity_lower_turn_off_space_heater = valueOf(words[i + 1]);

            else if (words[i].equals("humidity_lower_turn_on_fogger"))
                mApp.humidity_lower_turn_on_fogger = valueOf(words[i + 1]);


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



            Log.d("spock","Item Number " + i + " is " + words[i]);
        }
    }
}
