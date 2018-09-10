package com.example.briancunningham.gardenbeta.feature;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

// this is what I've been using as a global variable!
@SuppressWarnings("WeakerAccess")
public class MyAppApplication extends Application {

    private final ArrayList<verynicedatapoint> recordedData = new ArrayList<>();


    public String day_time_starts_at="8:00 AM";
    public String night_time_starts_at="8:00 PM";

    public double air_temp_upper_threshold_day_time =0;
    public double air_temp_upper_pushnotification_day_time =0;
    public double air_temp_upper_turn_on_fans_day_time=0;
    public double air_temp_upper_turn_off_heating_element_day_time =0;
    public double air_temp_upper_turn_off_space_heater_day_time =0;

    public double air_temp_lower_threshold_day_time =0;
    public double air_temp_lower_pushnotification_day_time =0;
    public double air_temp_lower_turn_off_fans_day_time =0;
    public double air_temp_lower_turn_on_heating_element_day_time =0;
    public double air_temp_lower_turn_on_space_heater_day_time =0;

    public double air_temp_upper_threshold_night_time =0;
    public double air_temp_upper_pushnotification_night_time =0;
    public double air_temp_upper_turn_on_fans_night_time=0;
    public double air_temp_upper_turn_off_heating_element_night_time =0;
    public double air_temp_upper_turn_off_space_heater_night_time =0;

    public double air_temp_lower_threshold_night_time =0;
    public double air_temp_lower_pushnotification_night_time =0;
    public double air_temp_lower_turn_off_fans_night_time =0;
    public double air_temp_lower_turn_on_heating_element_night_time =0;
    public double air_temp_lower_turn_on_space_heater_night_time =0;



    public double humidity_upper_threshold_day_time =0;
    public double humidity_upper_pushnotification_day_time =0;
    public double humidity_upper_turn_on_extra_fans_day_time =0;
    public double humidity_upper_turn_off_fogger_day_time =0;
    public double humidity_upper_turn_on_space_heater_day_time =0;

    public double humidity_lower_threshold_day_time =0;
    public double humidity_lower_pushnotification_day_time =0;
    public double humidity_lower_turn_off_extra_fans_day_time =0;
    public double humidity_lower_turn_off_space_heater_day_time =0;
    public double humidity_lower_turn_on_fogger_day_time =0;

    public double humidity_upper_threshold_night_time =0;
    public double humidity_upper_pushnotification_night_time =0;
    public double humidity_upper_turn_on_extra_fans_night_time =0;
    public double humidity_upper_turn_off_fogger_night_time =0;
    public double humidity_upper_turn_on_space_heater_night_time =0;

    public double humidity_lower_threshold_night_time =0;
    public double humidity_lower_pushnotification_night_time =0;
    public double humidity_lower_turn_off_extra_fans_night_time =0;
    public double humidity_lower_turn_off_space_heater_night_time =0;
    public double humidity_lower_turn_on_fogger_night_time =0;

    public double TVOC_upper_threshold=0;
    public double TVOC_upper_pushnotifications=0;

    public double TVOC_lower_pushnotification=0;
    public double TVOC_lower_threshold=0;

    public double CO2_upper_threshold=0;
    public double CO2_upper_pushnotifications=0;

    public double CO2_lower_threshold=0;
    public double CO2_lower_pushnotification=0;

    public double slntemp_upper_threshold=0;
    public double slntemp_upper_pushnotification=0;
    public double slntemp_upper_turn_off_space_heater=0;
    public double slntemp_upper_turn_off_heating_element=0;

    public double slntemp_lower_threshold=0;
    public double slntemp_lower_pushnotification=0;
    public double slntemp_lower_turn_on_space_heater=0;
    public double slntemp_lower_turn_on_heating_element=0;

    public double tds_upper_threshold=0;
    public double tds_upper_push_notification=0;
    public double tds_upper_add_water=0;

    public double tds_lower_threshold=0;
    public double tds_lower_pushnotification=0;
    public double tds_add_florabloom=0;
    public double tds_add_floragro=0;
    public double tds_add_floramicro=0;

    public double do_upper_threshold=0;
    public double do_upper_push_notification=0;
    public double do_upper_add_water=0;
    public double do_upper_turn_off_extra_pump=0;

    public double do_lower_threshold=0;
    public double do_lower_push_notification=0;
    public double do_lower_add_hypochloric_acid=0;
    public double do_lower_add_hydrogen_peroxide=0;
    public double do_lower_turn_on_extra_pump=0;

    public double orp_upper_threshold=0;
    public double orp_upper_push_notification=0;
    public double orp_upper_add_water=0;

    public double orp_lower_threshold=0;
    public double orp_lower_push_notification=0;
    public double orp_lower_add_hydrogen_peroxide=0;
    public double orp_lower_add_hypochloric_acid=0;
    public double orp_lower_add_base=0;

    public double pH_upper_threshold=0;
    public double pH_lower_threshold=0;
    public double pH_upper_add_acid=0;
    public double pH_lower_add_base=0;
    public double pH_upper_push_notification=0;
    public double pH_lower_push_notification=0;


    public int am_enable=0;
    public int am_pump1=0;
    public int am_pump2=0;
    public int am_pump3=0;
    public int am_pump4=0;
    public int am_pump5=0;
    public int am_pump6=0;
    public int am_pump7=0;
    public int am_pump8=0;
    public int am_space_heater=0;
    public int am_grow_light=0;
    public int am_fogger=0;
    public int am_dc_motor=0;
    public int am_extra_fans=0;
    public int am_extra_air_pump=0;
    public int am_heating_element=0;

    /*public double reservoirs_need_refilling=0;
    public double canopy_height_checkpoint=0;
    public double canopy_height_push_notification=1;
    public double light_height_target=0;
    public double light_height_adjustment_push_notification=0;*/

// --Commented out by Inspection START (5/19/2018 11:17 AM):
//        public void testingmessage(){
//            Log.d("consoleprinting","scroopy doopers");
//        }
// --Commented out by Inspection STOP (5/19/2018 11:17 AM)

    public int size(){
            return recordedData.size();
    }

    public void showusersettings(){
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_threshold_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_pushnotification_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_turn_on_fans_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_turn_off_heating_element_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_upper_turn_off_space_heater_day_time);

        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_threshold_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_pushnotification_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_turn_off_fans_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_turn_on_heating_element_day_time);
        Log.d("usersettings","air temperature upper bound is " + air_temp_lower_turn_on_space_heater_day_time);

        Log.d("usersettings","air temperature upper bound is " + humidity_upper_threshold_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_pushnotification_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_turn_on_extra_fans_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_turn_off_fogger_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_upper_turn_on_space_heater_day_time);

        Log.d("usersettings","air temperature upper bound is " + humidity_lower_threshold_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_lower_pushnotification_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_lower_turn_off_extra_fans_day_time);
        Log.d("usersettings","air temperature upper bound is " + humidity_lower_turn_off_space_heater_day_time);

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

      /*  Log.d("usersettings","air temperature upper bound is " + reservoirs_need_refilling);
        Log.d("usersettings","air temperature upper bound is " + canopy_height_checkpoint);
        Log.d("usersettings","air temperature upper bound is " + canopy_height_push_notification);
        Log.d("usersettings","air temperature upper bound is " + light_height_target);
        Log.d("usersettings","air temperature upper bound is " + light_height_adjustment_push_notification);
*/
    }

    public void addavalue() {
        verynicedatapoint temppoint = new verynicedatapoint();
        this.recordedData.add(temppoint);
    }

    public void putavalue(String date, String time, float airtemplevel, float ambienthumiditylevel, float canopyheightlevel, float co2level, float dolevel, float lightheight, float o2level, float orplevel, float tdslevel, float phlevel, float solutiontemplevel, float reservoir1, float reservoir2, float reservoir3, float reservoir4, float reservoir5, float reservoir6, float reservoir7, float reservoir8, float reservoir9){

        verynicedatapoint temppoint = new verynicedatapoint(date, time,airtemplevel,ambienthumiditylevel,canopyheightlevel,co2level,dolevel,lightheight,o2level,orplevel,tdslevel,phlevel,solutiontemplevel,reservoir1,reservoir2,reservoir3,reservoir4,reservoir5,reservoir6,reservoir7,reservoir8,reservoir9);
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

    public float getReservoir1(int z){
        return recordedData.get(z).getReservoir1();
    }
    public float getReservoir2(int z){
        return recordedData.get(z).getReservoir2();
    }
    public float getReservoir3(int z){
        return recordedData.get(z).getReservoir3();
    }
    public float getReservoir4(int z){
        return recordedData.get(z).getReservoir4();
    }
    public float getReservoir5(int z){
        return recordedData.get(z).getReservoir5();
    }
    public float getReservoir6(int z){
        return recordedData.get(z).getReservoir6();
    }
    public float getReservoir7(int z){
        return recordedData.get(z).getReservoir7();
    }
    public float getReservoir8(int z){
        return recordedData.get(z).getReservoir8();
    }
    public float getReservoir9(int z){
        return recordedData.get(z).getReservoir9();
    }

    public String getDatapointdatetime(int z) {return recordedData.get(z).getDatapointdatetime();}

    public Date getDatapointinDateFormat(int z) {return recordedData.get(z).getDatapointinDateFormat();}
}