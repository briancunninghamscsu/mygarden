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
            /*String newline= "\\n";

            if (words[i].contains(newline))
            {
                words[i]=words[i].replace("\\n","");
            }

            if (words[i].contains("payload.\",\"data\":\""))
            {
                words[i]=words[i].replace("payload.\",\"data\":\"","");
            }

            if (words[i].contains("\"}"))
            {
                words[i]=words[i].replace("\"}","");
            }*/

            //assign it into global variables
            if ((i + 7 ) % 14 == 0) {
                // assuming you don't mess up the server data, it should be all in this form.
                Log.d("july2","a date is "+ words[i]);
                //mApp.putavalue(words[i],words[i+1],words[i+2],words[i+3],words[i+4],words[i+5],words[i+6],words[i+7],words[i+8],words[i+8],words[i+9]);
                if (i< words.length-7) {
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
                    String light_height = words[i + 13];
                }

            }



            Log.d("july","Item Number " + i + " is " + words[i]);

        }



    }

}
