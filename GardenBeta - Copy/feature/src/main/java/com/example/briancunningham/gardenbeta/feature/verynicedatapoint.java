package com.example.briancunningham.gardenbeta.feature;

import android.util.Log;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class verynicedatapoint {

        private float airtemplevel;
        private float ambienthumiditylevel;
        private float canopyheightlevel;
        private float co2level;
        private float dolevel;
        private float lightheight;
        private float o2level;
        private float orplevel;
        private float tdslevel;
        private float phlevel;
        private float solutiontemplevel;
        private boolean reservoirs;
        private String datapointdatetime;

        public verynicedatapoint(float airtemplevel, float ambienthumiditylevel, float canopyheightlevel, float co2level, float dolevel, float lightheight, float o2level, float orplevel, float tdslevel, float phlevel, float solutiontemplevel, boolean reservoirs) {
            this.airtemplevel = airtemplevel;
            this.ambienthumiditylevel = ambienthumiditylevel;
            this.canopyheightlevel = canopyheightlevel;
            this.co2level = co2level;
            this.canopyheightlevel = canopyheightlevel;
            this.dolevel = dolevel;
            this.lightheight = lightheight;
            this.o2level = o2level;
            this.orplevel = orplevel;
            this.tdslevel = tdslevel;
            this.phlevel = phlevel;
            this.solutiontemplevel = solutiontemplevel;
            this.reservoirs = reservoirs;
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
            this.datapointdatetime = sdf.format(c);
        }

        public verynicedatapoint(){
            Log.e("Subtroutine","yougottotheconstructor");
            Random r = new Random();
            int i1 = (r.nextInt(80) + 65);
            this.airtemplevel=i1;
            Log.e("Subtroutine","yougottothesecondthing");
            i1 = (r.nextInt(40) + 60);
            this.ambienthumiditylevel=i1;

            i1 = (r.nextInt(1) + 20);
            this.canopyheightlevel=i1;

            i1 = (r.nextInt(900) + 1000);
            this.co2level=i1;

            i1 = (r.nextInt(600) + 1000);
            this.dolevel=i1;

            i1 = (r.nextInt(1) + 200);
            this.lightheight=i1;

            i1 = (r.nextInt(400) + 600);
            this.o2level=i1;

            i1 = (r.nextInt(1) + 5);
            this.orplevel=i1;

            i1 = (r.nextInt(500) + 1000);
            this.tdslevel=i1;

            i1 = (r.nextInt(1) + 14);
            this.phlevel=i1;

            i1 = (r.nextInt(80) + 65);
            this.solutiontemplevel=i1;

            this.reservoirs=false;
            Log.e("Subtroutine","yougottothe end");
            /* i1 = (r.nextInt(0) + 1);
             if (i1==1)
                    this.reservoirs=false;
             else
                 this.reservoirs=true;*/
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

            public boolean getReservoirs(){
                return reservoirs;
            }

            public String getDatapointdatetime() {return datapointdatetime;}
}
