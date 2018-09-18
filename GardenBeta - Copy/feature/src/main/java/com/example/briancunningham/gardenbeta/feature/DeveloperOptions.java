package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.loopj.android.http.*;

import org.json.JSONObject;

@SuppressWarnings("ALL")
public class DeveloperOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);
        final MyAppApplication mApp = (MyAppApplication) getApplicationContext();
        MyLoopjTask myLoopjTask = new MyLoopjTask();
        final ConstraintLayout devtp = findViewById(R.id.devcontrols_toplvl);



        final CheckBox am_checkbox = findViewById(R.id.actuator_mode_checkbox);
        final RadioButton pump1butt = findViewById(R.id.butt_pump1);
        final RadioButton pump2butt = findViewById(R.id.butt_pump2);
        final RadioButton pump3butt = findViewById(R.id.butt_pump3);
        final RadioButton pump4butt = findViewById(R.id.butt_pump4);
        final RadioButton pump5butt = findViewById(R.id.butt_pump5);
        final RadioButton pump6butt = findViewById(R.id.butt_pump6);
        final RadioButton pump7butt = findViewById(R.id.butt_pump7);
        final RadioButton pump8butt = findViewById(R.id.butt_pump8);

        final RadioButton space_heater_butt = findViewById(R.id.butt_space_heater);
        final RadioButton grow_light_butt = findViewById(R.id.butt_grow_light);
        final RadioButton fogger_butt = findViewById(R.id.butt_fogger);
        final RadioButton dc_motor_butt = findViewById(R.id.butt_DC_motor);
        final RadioButton extra_fans_butt = findViewById(R.id.butt_extra_fans);
        final RadioButton extra_air_pump_butt = findViewById(R.id.butt_extra_air_pump);
        final RadioButton heating_element_butt = findViewById(R.id.butt_heating_element);




        // actuator mode enabling and UI logic
        am_checkbox.setChecked(mApp.am_enable==1 ? true : false);
        am_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mApp.am_enable = (am_checkbox.isChecked() ? 1 : 0.0);
                //TODO insert call to push user settings
                }
            }
        );

        pump1butt.setChecked(mApp.am_pump1==1 ? true : false);
        pump1butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // turn all actuators off
                mApp.am_pump1=0.0;
                mApp.am_pump2=0.0;
                mApp.am_pump3=0.0;
                mApp.am_pump4=0.0;
                mApp.am_pump5=0.0;
                mApp.am_pump6=0.0;
                mApp.am_pump7=0.0;
                mApp.am_pump8=0.0;
                mApp.am_space_heater=0.0;
                mApp.am_heating_element=0.0;
                mApp.am_extra_air_pump=0.0;
                mApp.am_extra_fans=0.0;
                mApp.am_grow_light=0.0;
                mApp.am_dc_motor=0.0;
                mApp.am_fogger=0.0;

                //turn this actuator on
                mApp.am_pump1 = (pump1butt.isChecked() ? 1 : 0.0);
                //TODO insert call to push user settings
            }
            }
        );

        pump2butt.setChecked(mApp.am_pump2==1 ? true : false);
        pump2butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // turn all actuators off
                mApp.am_pump1=0.0;
                mApp.am_pump2=0.0;
                mApp.am_pump3=0.0;
                mApp.am_pump4=0.0;
                mApp.am_pump5=0.0;
                mApp.am_pump6=0.0;
                mApp.am_pump7=0.0;
                mApp.am_pump8=0.0;
                mApp.am_space_heater=0.0;
                mApp.am_heating_element=0.0;
                mApp.am_extra_air_pump=0.0;
                mApp.am_extra_fans=0.0;
                mApp.am_grow_light=0.0;
                mApp.am_dc_motor=0.0;
                mApp.am_fogger=0.0;

                //turn this actuator on
                mApp.am_pump2 = (pump2butt.isChecked() ? 1 : 0.0);
                //TODO insert call to push user settings
            }
            }
            );

        pump3butt.setChecked(mApp.am_pump3==1 ? true : false);
        pump3butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             // turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_pump3 = (pump3butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );

        pump4butt.setChecked(mApp.am_pump4==1 ? true : false);
        pump4butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {// turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_pump4 = (pump4butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );

        pump5butt.setChecked(mApp.am_pump5==1 ? true : false);
        pump5butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {// turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_pump5 = (pump5butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );

        pump6butt.setChecked(mApp.am_pump6==1 ? true : false);
        pump6butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {// turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_pump6 = (pump6butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );

        pump7butt.setChecked(mApp.am_pump7==1 ? true : false);
        pump7butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {// turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_pump7 = (pump7butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );

        pump8butt.setChecked(mApp.am_pump8==1 ? true : false);
        pump8butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {// turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_pump8 = (pump8butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );


        space_heater_butt.setChecked(mApp.am_space_heater==1 ? true : false);
        space_heater_butt.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {// turn all actuators off
                                             mApp.am_pump1=0.0;
                                             mApp.am_pump2=0.0;
                                             mApp.am_pump3=0.0;
                                             mApp.am_pump4=0.0;
                                             mApp.am_pump5=0.0;
                                             mApp.am_pump6=0.0;
                                             mApp.am_pump7=0.0;
                                             mApp.am_pump8=0.0;
                                             mApp.am_space_heater=0.0;
                                             mApp.am_heating_element=0.0;
                                             mApp.am_extra_air_pump=0.0;
                                             mApp.am_extra_fans=0.0;
                                             mApp.am_grow_light=0.0;
                                             mApp.am_dc_motor=0.0;
                                             mApp.am_fogger=0.0;

                                             //turn this actuator on
                                             mApp.am_space_heater= (space_heater_butt.isChecked() ? 1 : 0.0);
                                             //TODO insert call to push user settings
                                         }
                                     }
        );


        grow_light_butt.setChecked(mApp.am_grow_light==1 ? true : false);
        grow_light_butt.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {// turn all actuators off
                                                   mApp.am_pump1=0.0;
                                                   mApp.am_pump2=0.0;
                                                   mApp.am_pump3=0.0;
                                                   mApp.am_pump4=0.0;
                                                   mApp.am_pump5=0.0;
                                                   mApp.am_pump6=0.0;
                                                   mApp.am_pump7=0.0;
                                                   mApp.am_pump8=0.0;
                                                   mApp.am_space_heater=0.0;
                                                   mApp.am_heating_element=0.0;
                                                   mApp.am_extra_air_pump=0.0;
                                                   mApp.am_extra_fans=0.0;
                                                   mApp.am_grow_light=0.0;
                                                   mApp.am_dc_motor=0.0;
                                                   mApp.am_fogger=0.0;

                                                   //turn this actuator on
                                                   mApp.am_grow_light= (grow_light_butt.isChecked() ? 1 : 0.0);
                                                   //TODO insert call to push user settings
                                               }
                                           }
        );

        fogger_butt.setChecked(mApp.am_fogger==1 ? true : false);
        fogger_butt.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {// turn all actuators off
                                               mApp.am_pump1=0.0;
                                               mApp.am_pump2=0.0;
                                               mApp.am_pump3=0.0;
                                               mApp.am_pump4=0.0;
                                               mApp.am_pump5=0.0;
                                               mApp.am_pump6=0.0;
                                               mApp.am_pump7=0.0;
                                               mApp.am_pump8=0.0;
                                               mApp.am_space_heater=0.0;
                                               mApp.am_heating_element=0.0;
                                               mApp.am_extra_air_pump=0.0;
                                               mApp.am_extra_fans=0.0;
                                               mApp.am_grow_light=0.0;
                                               mApp.am_dc_motor=0.0;
                                               mApp.am_fogger=0.0;

                                               //turn this actuator on
                                               mApp.am_fogger= (fogger_butt.isChecked() ? 1 : 0.0);
                                               //TODO insert call to push user settings
                                           }
                                       }
        );

        dc_motor_butt.setChecked(mApp.am_dc_motor==1 ? true : false);
        dc_motor_butt.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {// turn all actuators off
                                                 mApp.am_pump1=0.0;
                                                 mApp.am_pump2=0.0;
                                                 mApp.am_pump3=0.0;
                                                 mApp.am_pump4=0.0;
                                                 mApp.am_pump5=0.0;
                                                 mApp.am_pump6=0.0;
                                                 mApp.am_pump7=0.0;
                                                 mApp.am_pump8=0.0;
                                                 mApp.am_space_heater=0.0;
                                                 mApp.am_heating_element=0.0;
                                                 mApp.am_extra_air_pump=0.0;
                                                 mApp.am_extra_fans=0.0;
                                                 mApp.am_grow_light=0.0;
                                                 mApp.am_dc_motor=0.0;
                                                 mApp.am_fogger=0.0;

                                                 //turn this actuator on
                                                 mApp.am_dc_motor= (dc_motor_butt.isChecked() ? 1 : 0.0);
                                                 //TODO insert call to push user settings
                                             }
                                         }
        );


        extra_fans_butt.setChecked(mApp.am_extra_fans==1 ? true : false);
        extra_fans_butt.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {// turn all actuators off
                                                   mApp.am_pump1=0.0;
                                                   mApp.am_pump2=0.0;
                                                   mApp.am_pump3=0.0;
                                                   mApp.am_pump4=0.0;
                                                   mApp.am_pump5=0.0;
                                                   mApp.am_pump6=0.0;
                                                   mApp.am_pump7=0.0;
                                                   mApp.am_pump8=0.0;
                                                   mApp.am_space_heater=0.0;
                                                   mApp.am_heating_element=0.0;
                                                   mApp.am_extra_air_pump=0.0;
                                                   mApp.am_extra_fans=0.0;
                                                   mApp.am_grow_light=0.0;
                                                   mApp.am_dc_motor=0.0;
                                                   mApp.am_fogger=0.0;

                                                   //turn this actuator on
                                                   mApp.am_extra_fans= (extra_fans_butt.isChecked() ? 1 : 0.0);
                                                   //TODO insert call to push user settings
                                               }
                                           }
        );

        extra_air_pump_butt.setChecked(mApp.am_extra_air_pump==1 ? true : false);
        extra_air_pump_butt.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {// turn all actuators off
                                                       mApp.am_pump1=0.0;
                                                       mApp.am_pump2=0.0;
                                                       mApp.am_pump3=0.0;
                                                       mApp.am_pump4=0.0;
                                                       mApp.am_pump5=0.0;
                                                       mApp.am_pump6=0.0;
                                                       mApp.am_pump7=0.0;
                                                       mApp.am_pump8=0.0;
                                                       mApp.am_space_heater=0.0;
                                                       mApp.am_heating_element=0.0;
                                                       mApp.am_extra_air_pump=0.0;
                                                       mApp.am_extra_fans=0.0;
                                                       mApp.am_grow_light=0.0;
                                                       mApp.am_dc_motor=0.0;
                                                       mApp.am_fogger=0.0;

                                                       //turn this actuator on
                                                       mApp.am_extra_air_pump= (extra_air_pump_butt.isChecked() ? 1 : 0.0);
                                                       //TODO insert call to push user settings
                                                   }
                                               }
        );

        heating_element_butt.setChecked(mApp.am_heating_element==1 ? true : false);
        heating_element_butt.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {// turn all actuators off
                                                        mApp.am_pump1=0.0;
                                                        mApp.am_pump2=0.0;
                                                        mApp.am_pump3=0.0;
                                                        mApp.am_pump4=0.0;
                                                        mApp.am_pump5=0.0;
                                                        mApp.am_pump6=0.0;
                                                        mApp.am_pump7=0.0;
                                                        mApp.am_pump8=0.0;
                                                        mApp.am_space_heater=0.0;
                                                        mApp.am_heating_element=0.0;
                                                        mApp.am_extra_air_pump=0.0;
                                                        mApp.am_extra_fans=0.0;
                                                        mApp.am_grow_light=0.0;
                                                        mApp.am_dc_motor=0.0;
                                                        mApp.am_fogger=0.0;

                                                        //turn this actuator on
                                                        mApp.am_heating_element= (heating_element_butt.isChecked() ? 1 : 0.0);
                                                        //TODO insert call to push user settings
                                                    }
                                                }
        );













        Button getdatafromserverbutton = findViewById(R.id.pull_data_button);
        getdatafromserverbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestParams params = new RequestParams();
                params.put("whatiwant", "testdata");
                AsyncHttpClient client = new AsyncHttpClient();

                client.get("http://71.37.5.18/mygarden/api.php", params, new JsonHttpResponseHandler() {

                    boolean succ_flag = false;
                    @Override
                    public void onStart() {
                        Log.d("july", "got to onStart()");
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                        Log.d("july", "got to onSuccess()");
                        succ_flag = true;
                        String test1 = response.toString();
                        Log.d("july", test1);
                        parsemystringplease a = new parsemystringplease(test1, mApp);
                    }

                    @Override
                    public void onFinish(){
                        if (!succ_flag){
                        Snackbar snackbar = Snackbar
                                .make(devtp, "Could not connect to server!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        Log.d("july", "got to onRetry()");
                    }
                });
            }
        }
        );

        Button push_user_settings_butt = findViewById(R.id.push_user_settings_button);
        push_user_settings_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            user_settings_pusher USP1 = new user_settings_pusher(mApp,"Dev Options",devtp);
            Log.d("kirk","mApp.am_pump3 is " + mApp.am_pump3);
            }
        });











        Button pull_user_settings_button = findViewById(R.id.pull_user_settings_button);
        pull_user_settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_settings_puller USP1 = new user_settings_puller(devtp,mApp, "DevOptions");
            }}
        );



            }




    @Override
        public void onBackPressed () {   //this only triggers for the phone back-button!
            Intent data = new Intent();
            data.putExtra("parameter_name", getIntent().getStringExtra("parameter_name"));
            setResult(Activity.RESULT_OK, data);
            //super.onBackPressed();
            Log.d("doohoohoo", "got to the onbackpressed in the develoepr options function");
            finish();
    }


}


