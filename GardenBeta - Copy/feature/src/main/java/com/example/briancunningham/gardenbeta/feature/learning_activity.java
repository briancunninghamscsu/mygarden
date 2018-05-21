package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class learning_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity);

        TextView t2 = findViewById(R.id.textView10);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        setTitle(getIntent().getStringExtra("parameter_name")); //set the correct title
    }

    @Override
    public void onBackPressed() {
        Intent data = new Intent();
        data.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
        setResult(Activity.RESULT_OK, data);
        //super.onBackPressed();
        finish();
    }

}