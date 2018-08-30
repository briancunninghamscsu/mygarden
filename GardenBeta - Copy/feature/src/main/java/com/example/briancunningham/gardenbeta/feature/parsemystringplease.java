package com.example.briancunningham.gardenbeta.feature;

import android.util.Log;

class parsemystringplease{

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
       for (int i = 6; i < words.length; i++) {


            //assign it into global variables
            Log.d("july5","the value of words[" + i + "] is " + words[i]);

           if (words[i-2].equals("<")) {
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
                    String temp_canopy = words[i + 11];
                    String temp_lightheight = words[i + 12];
                    String temp_reservoir1 = words[i + 13];
                    String temp_reservoir2 = words[i + 14];
                    String temp_reservoir3 = words[i + 15];
                    String temp_reservoir4 = words[i + 16];
                    String temp_reservoir5 = words[i + 17];
                    String temp_reservoir6 = words[i + 18];
                    String temp_reservoir7 = words[i + 19];
                    String temp_reservoir8 = words[i + 20];
                    String temp_reservoir9 = words[i + 21];


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
                    /*Log.d("july3", "the value of temp_reservoirs is "+ temp_reservoir1);
                    Log.d("july3","the value of temp_canopy is " + temp_canopy);
                    Log.d("july3","the value of temp_lightheight is " + temp_lightheight);*/

                    //Log.d("july4","the value of boolean.valueof is " + Boolean.valueOf(temp_reservoir1));



                    //store in global variables
               Log.e("august","i think line 90 is what's crashing it");
                    mApp.putavalue(temp_date,temp_time,Float.valueOf(temp_airtemp), Float.valueOf(temp_humidity), Float.valueOf(temp_canopy), Float.valueOf(temp_CO2), Float.valueOf(temp_DO), Float.valueOf(temp_lightheight), Float.valueOf(temp_TVOC), Float.valueOf(temp_ORP), Float.valueOf(temp_TDS), Float.valueOf(temp_pH), Float.valueOf(temp_Slntemp), Boolean.valueOf(temp_reservoir1),Boolean.valueOf(temp_reservoir2),Boolean.valueOf(temp_reservoir3),Boolean.valueOf(temp_reservoir4),Boolean.valueOf(temp_reservoir5),Boolean.valueOf(temp_reservoir6),Boolean.valueOf(temp_reservoir7),Boolean.valueOf(temp_reservoir8),Boolean.valueOf(temp_reservoir9));
                    Log.d("august","the size of mApp is " + mApp.size());


               }
            Log.d("july","Item Number " + i + " is " + words[i]);
        }
    }





}


