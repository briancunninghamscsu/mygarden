package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class DeveloperOptions extends AppCompatActivity {

    private CClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);

        Log.d("bootinup", "it got here");
        //ArrayList recordedData = getIntent().getParcelableArrayListExtra("passme");
        //Log.d("bootinup","the amount of objects in the listarray is " + recordedData.size());
        mClient = new CClient();
        Thread myThready = new Thread(mClient);
        myThready.start();

        Button sendastringbutton = (Button) findViewById(R.id.butt1);
        sendastringbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You hopefully transmitted a string", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                proc_Login(view);
            }
        });
    }


    public void proc_Login(View v) {
        for (int i = 0; i < 5; i++)
            mClient.Send("asaadsasdasd");



                /*Socket socket = new Socket("10.101.65.188", 50505);

                OutputStream out = socket.getOutputStream();
                PrintWriter output = new PrintWriter(out);

                mStatusText.setText("Sending Data to PC");
                output.println("Hello from Android");
                out.flush();
                out.close();
                mStatusText.setText("Data sent to PC");

                socket.close();
                mStatusText.setText("Socket closed");*/
    }
}
