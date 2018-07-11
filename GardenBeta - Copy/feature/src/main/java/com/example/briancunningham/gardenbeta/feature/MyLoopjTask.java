package com.example.briancunningham.gardenbeta.feature;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

public class MyLoopjTask {

    private static final String TAG = "MOVIE_TRIVIA";

    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;

    String BASE_URL = "http://www.omdbapi.com/?";
    String jsonResponse;



    public MyLoopjTask() {
        asyncHttpClient = new AsyncHttpClient();
        requestParams = new RequestParams();
    }

    public void executeLoopjCall(String queryTerm) {
        requestParams.put("s", queryTerm);
        asyncHttpClient.get(BASE_URL, requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                jsonResponse = response.toString();
                Log.i("july", "onSuccess: " + jsonResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.e("july", "onFailure: " + errorResponse);
            }
        });
    }
}