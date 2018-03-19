package com.example.briancunningham.gardenbeta.feature;

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

        private verynicedatapoint(float airtemplevel, float ambienthumiditylevel, float canopyheightlevel, float co2level, float dolevel, float lightheight, float o2level, float orplevel, float tdslevel, float phlevel, float solutiontemplevel, boolean reservoirs ) {
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
}
