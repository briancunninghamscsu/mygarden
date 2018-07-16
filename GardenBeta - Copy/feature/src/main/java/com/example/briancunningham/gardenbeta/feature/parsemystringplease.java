package com.example.briancunningham.gardenbeta.feature;

import android.content.Context;
import android.util.Log;

public class parsemystringplease{
    private MyAppApplication mApp;
    private String thingtochew;

    parsemystringplease(String thingtochew,MyAppApplication mApp){

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


            //assign it into global variables


           if (words[i-1].equals("<")) {
                    String temp_date = words[i];
                    String temp_time = words[i + 1];
                    String temp_airtemp = words[i + 2];
                    String temp_humidity = words[i + 3];
                    String temp_TVOC = words[i + 4];
                    String temp_CO2 = words[i + 5];
                    String temp_Slntemp = words[i + 6];
                    String temp_TDS = words[i + 7];
                    String temp_DO = words[i + 8];
                    String temp_ORP = words[i + 9];
                    String temp_pH = words[i + 10];
                    String temp_reservoirs = words[i + 11];
                    String temp_canopy = words[i + 12];
                    String temp_lightheight = words[i + 13];
                    Log.d("july3","the value of temp_date is "+ temp_date);
                    Log.d("july3","the value of temp_time is "+ temp_time);
                    Log.d("july3","the value of temp_airtemp is "+ temp_airtemp);
                    Log.d("july3","the value temp_humidity is " + temp_humidity);
                    Log.d("july3","the value of temp_TVOC us " + temp_TVOC);
                    Log.d("july3", "the value of temp_CO2 is " +temp_CO2);
                    Log.d("july3", "the value of temp_Sln_temp is "+ temp_Slntemp);
                    Log.d("july3","the value of temp_TDWS is " + temp_TDS);
                    Log.d("july3", "the value of temp_DO is " + temp_DO);
                    Log.d("july3","the value of temp_ORP " + temp_ORP);
                    Log.d("july3","the value of temp_pH is " + temp_pH);
                    Log.d("july3", "the value of temp+_reservoirs is "+ temp_reservoirs);
                    Log.d("july3","the value of temp_canopy is " + temp_canopy);
                    Log.d("july3","the value of temp_lightheight is " + temp_lightheight);



            }
            Log.d("july","Item Number " + i + " is " + words[i]);
        }
    }
}


