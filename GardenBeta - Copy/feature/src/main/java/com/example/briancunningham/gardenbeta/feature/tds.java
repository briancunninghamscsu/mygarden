package com.example.briancunningham.gardenbeta.feature;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class tds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_airtemp, menu);
        return true;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Snackbar.make(, "asdasdasdasd", Snackbar.LENGTH_LONG)
        //  .setAction("Action", null).show();

        if (id == R.id.airtemplearn) {
            Intent myIntent = new Intent(tds.this, tdslearn.class);
            tds.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.airtemptolerances) {
            Intent myIntent = new Intent(tds.this, tdstolerances.class);
            tds.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
