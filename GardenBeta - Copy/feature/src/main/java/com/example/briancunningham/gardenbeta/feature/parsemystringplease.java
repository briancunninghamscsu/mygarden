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
            if ((i + 8 ) % 15 == 0) {
                // assuming you don't mess up the server data, it should be all in this form.
                Log.d("july2","a date is "+ words[i]);
                //mApp.putavalue(words[i],words[i+1],words[i+2],words[i+3],words[i+4],words[i+5],words[i+6],words[i+7],words[i+8],words[i+8],words[i+9]);


            }



            Log.d("july","Item Number " + i + " is " + words[i]);

        }



    }

}
