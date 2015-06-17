package com.example.bled.mytrening;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class uprDayActivity extends ActionBarActivity {

    LinearLayout llMain;
    public ListView list1;
    public Integer viborPunkta;
    public String[] str;
    public TextView soobshenie;
    final Aprogramm aprog = new Aprogramm();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upr_day);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        list1 = (ListView) findViewById(R.id.lv1);
        soobshenie = (TextView) findViewById(R.id.tv1);
        formirSpiska();
    }

    public void formirSpiska(){
        if (dayActivity.perem==1){
            viborPunkta=dayActivity.vibor;
            dayActivity.perem=0;
        }
        if (dayActivity.perem==0) {
            viborPunkta = getIntent().getExtras().getInt("viborPunkta");
            dayActivity.perem=1;
        }


        viborPunkta++;
        str = aprog.spisokUprDayCreate(viborPunkta);
        soobshenie.setText("");
        if(str[0]==""){
            soobshenie.setText("В данной программе нет дней. Добавьте!!!");
            list1.setFocusable(false);
        }

        list1.setFocusable(true);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        list1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upr_day, menu);
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
