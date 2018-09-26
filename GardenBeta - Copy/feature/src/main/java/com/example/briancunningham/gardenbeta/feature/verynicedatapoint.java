package com.example.briancunningham.gardenbeta.feature;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class verynicedatapoint {

        private final float airtemplevel;
        private final float ambienthumiditylevel;
        private final float canopyheightlevel;
        private final float co2level;
        private final float dolevel;
        private final float lightheight;
        private final float o2level;
        private final float orplevel;
        private final float tdslevel;
        private final float phlevel;
        private final float solutiontemplevel;
        private float reservoir1;
        private float reservoir2;
        private float reservoir3;
        private float reservoir4;
        private float reservoir5;
        private float reservoir6;
        private float reservoir7;
        private float reservoir8;
        private float reservoir9;
        private String datapointdatetime;
        private Long datapointinDateFormat;

    /*private verynicedatapoint(Parcel input){
            airtemplevel = input.readFloat();
            ambienthumiditylevel = input.readFloat();
            canopyheightlevel = input.readFloat();
            co2level = input.readFloat();
            dolevel = input.readFloat();
            lightheight = input.readFloat();
            o2level = input.readFloat();
            orplevel = input.readFloat();
            tdslevel = input.readFloat();
            phlevel = input.readFloat();
            solutiontemplevel = input.readFloat();
            int localtemp = input.readInt();
            reservoirs = localtemp == 1;

            //datapointdatetime=input.readString();

        }


    @Override
        public int describeContents() {
            return 0;
        }

        // write your object's data to the passed-in Parcel
        @Override
        public void writeToParcel(Parcel out, int flags) {

            out.writeFloat(airtemplevel);
            out.writeFloat(ambienthumiditylevel);
            out.writeFloat(canopyheightlevel);
            out.writeFloat(co2level);
            out.writeFloat(dolevel);
            out.writeFloat(lightheight);
            out.writeFloat(o2level);
            out.writeFloat(orplevel);
            out.writeFloat(tdslevel);
            out.writeFloat(phlevel);
            out.writeFloat(solutiontemplevel);
            if (reservoirs) {
                out.writeInt(1);
            } else {
                out.writeInt(0);
            }
           // out.writeString(datapointdatetime);

        }

        // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
        public static final Parcelable.Creator<verynicedatapoint> CREATOR = new Parcelable.Creator<verynicedatapoint>() {
            public verynicedatapoint createFromParcel(Parcel in) {
            return new verynicedatapoint(in);
        }


            public verynicedatapoint[] newArray(int size) {
            return new verynicedatapoint[size];
        }
        };*/



        public verynicedatapoint(String date, String time, float airtemplevel, float ambienthumiditylevel, float canopyheightlevel, float co2level, float dolevel, float lightheight, float o2level, float orplevel, float tdslevel, float phlevel, float solutiontemplevel, float reservoir1, float reservoir2, float reservoir3, float reservoir4, float reservoir5, float reservoir6, float reservoir7, float reservoir8, float reservoir9) {
            this.airtemplevel = airtemplevel;
            this.ambienthumiditylevel = ambienthumiditylevel;
            this.canopyheightlevel = canopyheightlevel;
            this.co2level = co2level;
            this.dolevel = dolevel;
            this.lightheight = lightheight;
            this.o2level = o2level;
            this.orplevel = orplevel;
            this.tdslevel = tdslevel;
            this.phlevel = phlevel;
            this.solutiontemplevel = solutiontemplevel;
            this.reservoir1 = reservoir1;
            this.reservoir2 = reservoir2;
            this.reservoir3 = reservoir3;
            this.reservoir4 = reservoir4;
            this.reservoir5 = reservoir5;
            this.reservoir6 = reservoir6;
            this.reservoir7 = reservoir7;
            this.reservoir8 = reservoir8;
            this.reservoir9 = reservoir9;

            //gotta have it in SDF format if you want to plot the points
            String string = date + " " + time;
            Log.d("sept","the value of string is " + string);
            DateFormat format = new SimpleDateFormat("MM.dd.yy HH:mm:ss", Locale.ENGLISH);
            Log.d("sept","the value of format is " + format.toString());

            try {
                Date place_holder= format.parse(string);
                this.datapointinDateFormat = place_holder.getTime();
                //Log.d("sept","the value of this.datapointindateformat is " + this.datapointinDateFormat.getTime());
                datapointdatetime = string;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010

            //SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
            //this.datapointdatetime = sdf.format(c);
        }


        public verynicedatapoint() {
            Random r = new Random();


            int i1 = (r.nextInt(80) + 65);
            this.airtemplevel = i1;
            Log.d("spoof", "randomly generated Air Temp level is " + i1);


            i1 = (r.nextInt(40) + 60);
            this.ambienthumiditylevel = i1;
            Log.d("spoof", "randomly generated Ambient Humidity level is " + i1);


            i1 = (r.nextInt(1) + 20);
            this.canopyheightlevel = i1;
            Log.d("spoof", "randomly generated Canopy Height level is " + i1);

            i1 = (r.nextInt(900) + 1000);
            this.co2level = i1;
            Log.d("spoof", "randomly generated Co2 level is " + i1);

            i1 = (r.nextInt(600) + 1000);
            this.dolevel = i1;
            Log.d("spoof", "randomly generated DO level is " + i1);

            i1 = (r.nextInt(10) + 60);
            this.lightheight = i1;
            Log.d("spoof", "randomly generated light height level is " + i1);

            i1 = (r.nextInt(400) + 600);
            this.o2level = i1;
            Log.d("spoof", "randomly generated O2 level is " + i1);

            i1 = (r.nextInt(1) + 5);
            this.orplevel = i1;
            Log.d("spoof", "randomly generated ORP level is " + i1);

            i1 = (r.nextInt(500) + 1000);
            this.tdslevel = i1;
            Log.d("spoof", "randomly generated ORP level is " + i1);

            i1 = (r.nextInt(14) + 1);
            this.phlevel = i1;
            Log.d("spoof", "randomly generated pH level is " + i1);

            i1 = (r.nextInt(80) + 65);
            this.solutiontemplevel = i1;
            Log.d("spoof", "randomly generated Solution Temp level is " + i1);
            Log.e("Subtroutine", "yougottothe end");


            Date dt = Calendar.getInstance().getTime();
            this.datapointinDateFormat = dt.getTime();
            //SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
            //this.datapointdatetime = sdf.format(c);

            i1 = (r.nextInt(10) + 1);
            switch (i1) {
                case 5:
                    //String action = "Added 5mL";
                    break;
                case 6:
                    break;
                case 4:
                    break;
                default:
                    break;
            }


            i1 = (r.nextInt(1) + 1);
            if (i1 == 1) {
                this.reservoir1 = 0;
                Log.d("spoof", "reserviors are false (empty)");
            } else {
                this.reservoir1 = 1;
                Log.d("spoof", "reservoirs are true (full)");
            }

            this.reservoir2 = 1;
            this.reservoir3 = 1;
            this.reservoir4 = 1;
            this.reservoir5 = 1;
            this.reservoir6 = 1;
            this.reservoir7 = 1;
            this.reservoir8 = 1;
            this.reservoir9 = 1;


        }

            public float getAirtemplevel() {
                return airtemplevel;
            }


            public float getAmbienthumiditylevel() {
                return ambienthumiditylevel;
            }


            public float getCanopyheightlevel() {
                return canopyheightlevel;
            }

            public float getCo2level(){
                return co2level;
            }

            public float getDolevel(){
                return dolevel;
            }

            public float getLightheight(){
                return lightheight;
            }

            public float getO2level(){
                return o2level;
            }

            public float getOrplevel(){
                return orplevel;
            }

            public float getTdslevel(){
                return tdslevel;
            }
            public float getPhlevel(){
                return phlevel;
            }
            public float getSolutiontemplevel(){
                return solutiontemplevel;
            }

            public float getReservoir1(){
                return reservoir1;
            }

            public float getReservoir2(){
                return reservoir2;
            }
            public float getReservoir3(){
                return reservoir3;
            }
            public float getReservoir4(){
                return reservoir4;
            }
            public float getReservoir5(){
                return reservoir5;
            }
            public float getReservoir6(){
                return reservoir6;
            }
            public float getReservoir7(){
                return reservoir7;
            }
            public float getReservoir8(){
                return reservoir8;
            }
            public float getReservoir9(){
                return reservoir9;
            }


            public Long getDatapointinDateFormat(){ return datapointinDateFormat;}
            public String getDatapointdatetime() {return datapointdatetime;}
}
