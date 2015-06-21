package com.example.bled.mytrening;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class pokazStatActivity extends ActionBarActivity {
    Integer viborUpr;
    String str;
    String[] str2;
    TextView tv1;
    Astatistics stat = new Astatistics();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokaz_stat);
        viborUpr = getIntent().getExtras().getInt("viborPunkta");
        str= viborUpr.toString();
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(str);
        str2 = stat.spisokZnachPodhodov(viborUpr);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pokaz_stat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
