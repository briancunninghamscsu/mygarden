package com.example.briancunningham.gardenbeta.feature;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

// this is what I've been using as a global variable!
@SuppressWarnings("WeakerAccess")
public class MyAppApplication extends Application {

    private final ArrayList<verynicedatapoint> recordedData = new ArrayList<>();

    public double air_temp_upper_threshold=80;
    public final float air_temp_upper_pushnotification=1;
    public final float air_temp_upper_turn_on_fans=1;
    public final float air_temp_upper_turn_off_heating_element=1;
    public final float air_temp_upper_turn_off_space_heater=1;

    public double air_temp_lower_threshold=70;
    public final float air_temp_lower_pushnotification=0;
    public final float air_temp_lower_turn_off_fans=0;
    public final float air_temp_lower_turn_on_heating_element=1;
    public final float air_temp_lower_turn_on_space_heater=1;

    public double humidity_upper_threshold=80;
    public final float humidity_upper_pushnotification=0;
    public final float humidity_upper_turn_on_extra_fans=1;
    public final float humidity_upper_turn_off_fogger=1;
    public final float humidity_upper_turn_on_space_heater=0;

    public double humidity_lower_threshold=40;
    public final float humidity_lower_pushnotification=0;
    public final float humidity_lower_turn_off_extra_fans=0;
    public final float humidity_lower_turn_off_space_heater=1;
    public final float humidity_lower_turn_on_fogger=0;

    public final float TVOC_upper_threshold=800;
    public final float TVOC_upper_pushnotifications=0;

    public final float TVOC_lower_threshold=400;
    public final float TVOC_lower_pushnotification=0;

    public final float CO2_upper_threshold=800;
    public final float CO2_upper_pushnotifications=0;

    public final float CO2_lower_threshold=400;
    public final float CO2_lower_pushnotification=0;

    public final float slntemp_upper_threshold=80;
    public final float slntemp_upper_pushnotification=0;
    public final float slntemp_upper_turn_off_space_heater=1;
    public final float slntemp_upper_turn_off_heating_element=1;

    public final float slntemp_lower_threshold=70;
    public final float slntemp_lower_pushnotification=0;
    public final float slntemp_lower_turn_on_space_heater=0;
    public final float slntemp_lower_turn_on_heating_element=1;

    public final float tds_upper_threshold=600;
    public final float tds_upper_push_notification=0;
    public final float tds_upper_add_water=1;

    public final float tds_lower_threshold=300;
    public final float tds_lower_pushnotification=0;
    public final float tds_add_florabloom=0;
    public final float tds_add_floragro=1;
    public final float tds_add_floramicro=0;

    public final float do_upper_threshold=500;
    public final float do_upper_push_notification=0;
    public final float do_upper_add_water=1;
    public final float do_upper_turn_off_extra_pump=1;

    public final float do_lower_threshold=300;
    public final float do_lower_push_notification=0;
    public final float do_lower_add_hypochloric_acid=1;
    public final float do_lower_add_hydrogen_peroxide=0;
    public final float do_lower_turn_on_extra_pump=1;

    public final float orp_upper_threshold=500;
    public final float orp_upper_push_notification=0;
    public final float orp_upper_add_water=0;

    public final float orp_lower_threshold=400;
    public final float orp_lower_push_notification=0;
    public final float orp_lower_add_hydrogen_peroxide=0;
    public final float orp_lower_add_hypochloric_acid=0;
    public final float orp_lower_add_base=1;

    public final double pH_lower_threshold=5.5;
    public final double pH_upper_add_acid=1;
    public final double pH_lower_add_base=1;
    public final double pH_upper_push_notification=0;
    public final double pH_lower_push_notification=0;

    public final float reservoirs_need_refilling=1;
    public final float canopy_height_checkpoint=40;
    public final float canopy_height_push_notification=1;
    public final float light_height_target=10;
    public final float light_height_adjustment_push_notification=1;

// --Commented out by Inspection START (5/19/2018 11:17 AM):
//        public void testingmessage(){
//            Log.d("consoleprinting","scroopy doopers");
//        }
// --Commented out by Inspection STOP (5/19/2018 11:17 AM)

    public int size(){
            return recordedData.size();
    }

    public void showusersettings(){
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_turn_on_fans);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_turn_off_heating_element);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_turn_off_space_heater);

        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_turn_off_fans);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_turn_on_heating_element);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_turn_on_space_heater);

        Log.d("usersettings","air temperature upper bound is " + humidity_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_turn_on_extra_fans);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_turn_off_fogger);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_turn_on_space_heater);

        Log.d("usersettings","air temperature upper bound is " + humidity_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + humidity_lower_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + humidity_lower_turn_off_extra_fans);
        Log.d("usersettings","air temperature upper bound is " + humidity_lower_turn_off_space_heater);

        Log.d("usersettings","air temperature upper bound is " + TVOC_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + TVOC_upper_pushnotifications);

        Log.d("usersettings","air temperature upper bound is " + TVOC_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + TVOC_lower_pushnotification);

        Log.d("usersettings","air temperature upper bound is " + CO2_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + CO2_upper_pushnotifications);

        Log.d("usersettings","air temperature upper bound is " + CO2_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + CO2_lower_pushnotification);

        Log.d("usersettings","air temperature upper bound is " + slntemp_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + slntemp_upper_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + slntemp_upper_turn_off_space_heater);
        Log.d("usersettings","air temperature upper bound is " + slntemp_upper_turn_off_heating_element);

        Log.d("usersettings","air temperature upper bound is " + slntemp_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + slntemp_lower_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + slntemp_lower_turn_on_space_heater);
        Log.d("usersettings","air temperature upper bound is " + slntemp_lower_turn_on_heating_element);

        Log.d("usersettings","air temperature upper bound is " + tds_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + tds_upper_push_notification);
        Log.d("usersettings","air temperature upper bound is " + tds_upper_add_water);

        Log.d("usersettings","air temperature upper bound is " + tds_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + tds_lower_pushnotification);
        Log.d("usersettings","air temperature upper bound is " + tds_add_florabloom);
        Log.d("usersettings","air temperature upper bound is " + tds_add_floragro);
        Log.d("usersettings","air temperature upper bound is " + tds_add_floramicro);

        Log.d("usersettings","air temperature upper bound is " + do_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + do_upper_push_notification);
        Log.d("usersettings","air temperature upper bound is " + do_upper_add_water);

        Log.d("usersettings","air temperature upper bound is " + do_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + do_lower_push_notification);
        Log.d("usersettings","air temperature upper bound is " + do_lower_add_hypochloric_acid);
        Log.d("usersettings","air temperature upper bound is " + do_lower_add_hydrogen_peroxide);

        Log.d("usersettings","air temperature upper bound is " + orp_upper_threshold);
        Log.d("usersettings","air temperature upper bound is " + orp_upper_push_notification);
        Log.d("usersettings","air temperature upper bound is " + orp_upper_add_water);

        Log.d("usersettings","air temperature upper bound is " + orp_lower_threshold);
        Log.d("usersettings","air temperature upper bound is " + orp_lower_push_notification);
        Log.d("usersettings","air temperature upper bound is " + orp_lower_add_hydrogen_peroxide);
        Log.d("usersettings","air temperature upper bound is " + orp_lower_add_hypochloric_acid);
        Log.d("usersettings","air temperature upper bound is " + orp_lower_add_base);

        Log.d("usersettings","air temperature upper bound is " + reservoirs_need_refilling);
        Log.d("usersettings","air temperature upper bound is " + canopy_height_checkpoint);
        Log.d("usersettings","air temperature upper bound is " + canopy_height_push_notification);
        Log.d("usersettings","air temperature upper bound is " + light_height_target);
        Log.d("usersettings","air temperature upper bound is " + light_height_adjustment_push_notification);

    }

    public void addavalue() {
        verynicedatapoint temppoint = new verynicedatapoint();
        this.recordedData.add(temppoint);
    }

    public void putavalue(String date, String time, float airtemplevel, float ambienthumiditylevel, float canopyheightlevel, float co2level, float dolevel, float lightheight, float o2level, float orplevel, float tdslevel, float phlevel, float solutiontemplevel, boolean reservoirs){

        verynicedatapoint temppoint = new verynicedatapoint(date, time,airtemplevel,ambienthumiditylevel,canopyheightlevel,co2level,dolevel,lightheight,o2level,orplevel,tdslevel,phlevel,solutiontemplevel,reservoirs);
        this.recordedData.add(temppoint);
    }

    public float getAirtemplevel(int z) {
        return recordedData.get(z).getAirtemplevel();
    }

    public float getAmbienthumiditylevel(int z) {
        return recordedData.get(z).getAmbienthumiditylevel();
    }

    public float getCanopyheightlevel(int z) {
        return recordedData.get(z).getCanopyheightlevel();
    }

    public float getCo2level(int z){
        return recordedData.get(z).getCo2level();
    }

    public float getDolevel(int z){
        return recordedData.get(z).getDolevel();
    }

    public float getLightheight(int z){
        return recordedData.get(z).getLightheight();
    }

    public float getO2level(int z){
        return recordedData.get(z).getO2level();
    }

    public float getOrplevel(int z){
        return recordedData.get(z).getOrplevel();
    }

    public float getTdslevel(int z){
        return recordedData.get(z).getTdslevel();
    }
    public float getPhlevel (int z){
        return recordedData.get(z).getPhlevel();
    }
    public float getSolutiontemplevel(int z){
        return recordedData.get(z).getSolutiontemplevel();
    }

    public boolean getReservoirs(int z){
        return recordedData.get(z).getReservoirs();
    }

    public String getDatapointdatetime(int z) {return recordedData.get(z).getDatapointdatetime();}

    public Date getDatapointinDateFormat(int z) {return recordedData.get(z).getDatapointinDateFormat();}
}