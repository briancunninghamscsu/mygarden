package com.example.briancunningham.gardenbeta.feature;

import android.content.Context;
import android.util.Log;

public class parsemystringplease{
    private Context gimmecontext;
    private String thingtochew;

    parsemystringplease(String thingtochew){
        String words[] = thingtochew.split(" ");
        for (int i = 0; i < words.length; i++) {
            Log.d("july","Item Number " + i + " is " + words[i]);

        }



    }

}
