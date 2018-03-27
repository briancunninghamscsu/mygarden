package com.example.briancunningham.gardenbeta.feature;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class MyAppApplication extends Application {

    private ArrayList<verynicedatapoint> recordedData = new ArrayList<>();

        public void testingmessage(){
            Log.d("consoleprinting","scroopy doopers");
        }

    public ArrayList<verynicedatapoint> getRecordedData() {
        return this.recordedData;
    }

    public int size(){
            return recordedData.size();
    }

    public void addavalue() {
        verynicedatapoint temppoint = new verynicedatapoint();
        this.recordedData.add(temppoint);
    }

}