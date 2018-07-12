package com.example.briancunningham.gardenbeta.feature;

import android.content.Context;
import android.util.Log;

public class parsemystringplease{
    private Context gimmecontext;
    private String thingtochew;

    parsemystringplease(String thingtochew){
        String words[] = thingtochew.split(" ");
        for (int i = 0; i < words.length; i++) {
            String newline= "\\n";

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
            }

            Log.d("july","Item Number " + i + " is " + words[i]);

        }



    }

}
