package com.example.briancunningham.gardenbeta.feature;

import android.util.Log;

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


            //assign it into global variables




            Log.d("spock","Item Number " + i + " is " + words[i]);
        }
    }
}
