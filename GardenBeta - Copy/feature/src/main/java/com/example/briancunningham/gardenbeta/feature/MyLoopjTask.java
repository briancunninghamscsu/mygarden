package com.example.briancunningham.gardenbeta.feature;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

@SuppressWarnings("ALL")
class MyLoopjTask {


    public MyLoopjTask() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        //asyncHttpClient.setMaxRetriesAndTimeout(2,10000);
        RequestParams requestParams = new RequestParams();
    }

}