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

public class verynicedatapoint implements Parcelable {

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
        private final boolean reservoirs;
        private String datapointdatetime;
        private Date datapointinDateFormat;

    private verynicedatapoint(Parcel input){
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
        };



        public verynicedatapoint(String date, String time, float airtemplevel, float ambienthumiditylevel, float canopyheightlevel, float co2level, float dolevel, float lightheight, float o2level, float orplevel, float tdslevel, float phlevel, float solutiontemplevel, boolean reservoirs) {
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
            this.reservoirs = reservoirs;

            //gotta have it in SDF format if you want to plot the points
            String string = date + " AD at " + time;
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss", Locale.ENGLISH);
            try {
                this.datapointinDateFormat = format.parse(string);
                datapointdatetime = string;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010

            //SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
            //this.datapointdatetime = sdf.format(c);
        }


        public verynicedatapoint(){
            Random r = new Random();


            int i1 = (r.nextInt(80) + 65);
            this.airtemplevel=i1;
            Log.d("spoof","randomly generated Air Temp level is " + i1);


            i1 = (r.nextInt(40) + 60);
            this.ambienthumiditylevel=i1;
            Log.d("spoof","randomly generated Ambient Humidity level is " + i1);


            i1 = (r.nextInt(1) + 20);
            this.canopyheightlevel=i1;
            Log.d("spoof","randomly generated Canopy Height level is " + i1);

            i1 = (r.nextInt(900) + 1000);
            this.co2level=i1;
            Log.d("spoof","randomly generated Co2 level is " + i1);

            i1 = (r.nextInt(600) + 1000);
            this.dolevel=i1;
            Log.d("spoof","randomly generated DO level is " + i1);

            i1 = (r.nextInt(10) + 60);
            this.lightheight=i1;
            Log.d("spoof","randomly generated light height level is " + i1);

            i1 = (r.nextInt(400) + 600);
            this.o2level=i1;
            Log.d("spoof","randomly generated O2 level is " + i1);

            i1 = (r.nextInt(1) + 5);
            this.orplevel=i1;
            Log.d("spoof","randomly generated ORP level is " + i1);

            i1 = (r.nextInt(500) + 1000);
            this.tdslevel=i1;
            Log.d("spoof","randomly generated ORP level is " + i1);

            i1 = (r.nextInt(14) + 1);
            this.phlevel=i1;
            Log.d("spoof","randomly generated pH level is " + i1);

            i1 = (r.nextInt(80) + 65);
            this.solutiontemplevel=i1;
            Log.d("spoof","randomly generated Solution Temp level is " + i1);
            Log.e("Subtroutine","yougottothe end");


            this.datapointinDateFormat = Calendar.getInstance().getTime();
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
             if (i1==1) {
                 this.reservoirs = false;
                 Log.d("spoof", "reserviors are false (empty)");
             }
                 else{
                 this.reservoirs=true;
                 Log.d("spoof","reservoirs are true (full)");
             }}



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

            public boolean getReservoirs(){
                return reservoirs;
            }
            public Date getDatapointinDateFormat(){ return datapointinDateFormat;}
            public String getDatapointdatetime() {return datapointdatetime;}
}
