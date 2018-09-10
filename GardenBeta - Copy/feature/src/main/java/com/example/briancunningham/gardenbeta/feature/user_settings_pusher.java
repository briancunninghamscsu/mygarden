package com.example.briancunningham.gardenbeta.feature;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

public class user_settings_pusher {


    user_settings_pusher(MyAppApplication mappy, final String stringy, final ConstraintLayout constrainty){

        Log.d("guitar","you called the user settings pusher function");
        Log.d("guitar", "my tvoc upper threshold is "+ mappy.TVOC_upper_threshold);

        // for snackbar
        //final ConstraintLayout screen = findViewById(R.id.constrainters);

        RequestParams params = new RequestParams();
        params.put("whatiwant", "push_settings");

        //adding all of the user settings to the parameters












        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://192.168.1.13/mygarden/api.php", params,new JsonHttpResponseHandler() {
                    @Override
                    public void onStart(){
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Snackbar snackbar = Snackbar
                                .make(constrainty, "Changes Saved from " + stringy +  "!", Snackbar.LENGTH_LONG);
                        snackbar.show();

                        // save the variables from the UI


                    }

                    @Override
                    public void onFinish(){
                        Log.d("kirk","got to onfinish");
                        Snackbar snackbar = Snackbar
                                .make(constrainty, "Failed to Connect! Changes from " + stringy + " not saved.", Snackbar.LENGTH_LONG);
                        //snackbar.show();
                    }
                    @Override
                    public void onRetry(int retryNo) {
                        Log.d("kirk", "got to onRetry()");
                    }
                }
        );  // this is the end of client.get line

    }

}
