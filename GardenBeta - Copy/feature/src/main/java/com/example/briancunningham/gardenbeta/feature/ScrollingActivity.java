package com.example.briancunningham.gardenbeta.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv1 = (TextView)findViewById(R.id.textView24); //puts xml-ID'd textview24 in a box


        // This block updates the header with updated real-time clock on startup.
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
        String formattedDate = "Last Updated at " + sdf.format(c);
        tv1.setText(formattedDate);




            // for air temp menu
            TextView tvA = (TextView)findViewById(R.id.textView2);
            TextView tvB = (TextView)findViewById(R.id.textView);
            ImageView ivA = (ImageView)findViewById(R.id.imageView);


            tvA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(ScrollingActivity.this, airtempActivity.class);
                    ScrollingActivity.this.startActivity(myIntent);
                    }
                });
            tvB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(ScrollingActivity.this, airtempActivity.class);
                    ScrollingActivity.this.startActivity(myIntent);
                }
            });
            ivA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(ScrollingActivity.this, airtempActivity.class);
                    ScrollingActivity.this.startActivity(myIntent);
                }
            });

            //for ambient humidity menu
            TextView tvC = (TextView)findViewById(R.id.textView3);
            TextView tvD = (TextView)findViewById(R.id.textView4);
            ImageView ivC = (ImageView)findViewById(R.id.imageView2);

            tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, ambienthumidity.class);
                ScrollingActivity.this.startActivity(myIntent);
                    }
            });
        tvD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, ambienthumidity.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, ambienthumidity.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        // for O2 activity
        TextView tvE = (TextView)findViewById(R.id.textView5);
        TextView tvF = (TextView)findViewById(R.id.textView6);
        ImageView ivE = (ImageView)findViewById(R.id.imageView3);

        tvE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, o2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, o2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, o2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });


        // for CO2 activity
        TextView tvG = (TextView)findViewById(R.id.textView7);
        TextView tvH = (TextView)findViewById(R.id.textView8);
        ImageView ivG = (ImageView)findViewById(R.id.imageView4);

        tvG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, co2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, co2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, co2.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });


        // for sln temp activity
        TextView tvI = (TextView)findViewById(R.id.textView9);
        TextView tvJ = (TextView)findViewById(R.id.textView10);
        ImageView ivI = (ImageView)findViewById(R.id.imageView5);

        tvI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, SolutionTemperatureMeasurements.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, SolutionTemperatureMeasurements.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, SolutionTemperatureMeasurements.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        // for TDS activity
        TextView tvK = (TextView)findViewById(R.id.textView11);
        TextView tvL = (TextView)findViewById(R.id.textView12);
        ImageView ivK = (ImageView)findViewById(R.id.imageView6);

        tvK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, tds.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, tds.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, tds.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        // for DO activity
        TextView tvM = (TextView)findViewById(R.id.textView13);
        TextView tvN = (TextView)findViewById(R.id.textView14);
        ImageView ivM = (ImageView)findViewById(R.id.imageView7);

        tvM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, DO.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, DO.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, DO.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });


        // for for Nutrient ORP activity
        TextView tvO = (TextView)findViewById(R.id.textView15);
        TextView tvP = (TextView)findViewById(R.id.textView16);
        ImageView ivO = (ImageView)findViewById(R.id.imageView8);

        tvO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, orp.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, orp.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, orp.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        // for for pH activity
        TextView tvQ = (TextView)findViewById(R.id.textView20);
        TextView tvR = (TextView)findViewById(R.id.textView19);
        ImageView ivQ = (ImageView)findViewById(R.id.imageView11);

        tvQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, pH.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, pH.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, pH.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        // for for reservoirs activity
        TextView tvS = (TextView)findViewById(R.id.textView22);
        TextView tvT = (TextView)findViewById(R.id.textView21);
        ImageView ivS = (ImageView)findViewById(R.id.imageView10);

        tvS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, reservoirs.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, reservoirs.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, reservoirs.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        /// for canopy height activity
        TextView tvU = (TextView)findViewById(R.id.textViewB);
        TextView tvV = (TextView)findViewById(R.id.textViewC);
        ImageView ivU = (ImageView)findViewById(R.id.imageViewA);

        tvU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, CanopyHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, CanopyHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, CanopyHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });

        // for for light height activity
        TextView tvW = (TextView)findViewById(R.id.textViewE);
        TextView tvX = (TextView)findViewById(R.id.textViewF);
        ImageView ivW = (ImageView)findViewById(R.id.imageViewD);

        tvW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, LightHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        tvX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, LightHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });
        ivW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScrollingActivity.this, LightHeight.class);
                ScrollingActivity.this.startActivity(myIntent);
            }
        });











        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "You pressed tvA", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
                //myIntent.putExtra("key", value); //Optional parameters
                Intent myIntent = new Intent(ScrollingActivity.this, SettingsActivity.class);
                ScrollingActivity.this.startActivity(myIntent);


            }
        });



        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Intent myIntent2 = new Intent(ScrollingActivity.this, AppCompatPreferenceActivity.class);
                //ScrollingActivity.this.startActivity(myIntent2);



                //Snackbar.make(view, "This opens a new screen to test the actuators.", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
           // }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Snackbar.make(, "asdasdasdasd", Snackbar.LENGTH_LONG)
          //  .setAction("Action", null).show();
        
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(ScrollingActivity.this, SettingsActivity.class);
            ScrollingActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.aboutmeid) {
            Intent myIntent = new Intent(ScrollingActivity.this, AboutActivity.class);
            ScrollingActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.firsttimesetupid) {
            Intent myIntent = new Intent(ScrollingActivity.this, FirstTimeSetup.class);
            ScrollingActivity.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
