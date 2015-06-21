package com.example.bled.mytrening;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

public class uprTrenActivity extends ActionBarActivity {

    public String[] str;
    public ListView lv1;
    public Integer viborPunkta;
    Button btnEnd;
    final Atraining atren = new Atraining();
    Chronometer chronometer;
    TextView soobshenie;
    public static Integer idTren;
    public static int vibor=0;
    public static int perem=0;
    long vremja, denn, progg;
    Integer povtorOtkr=0;
    Trenirovki tren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upr_tren);
        lv1 = (ListView) findViewById(R.id.lv1);
        btnEnd = (Button) findViewById(R.id.btnEnd);



        if (training.perem==1){
            viborPunkta=training.vibor;
        }
        if (training.perem==0) {
            viborPunkta = getIntent().getExtras().getInt("viborPunkta");
            training.perem=1;
        }
        viborPunkta++;
        tren = Trenirovki.findById(Trenirovki.class,(long)viborPunkta);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        povtorOtkr = getIntent().getExtras().getInt("povtor");
        if (povtorOtkr==1){
            vremja = getIntent().getExtras().getLong("vremjaTrenSPodhodami");
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime() - vremja);
        }

        if (tren.vremja_vipolnenija!=0){
            chronometer.setBase(SystemClock.elapsedRealtime() - tren.vremja_vipolnenija);
        }
        chronometer.start();
        formirSpiska();

        final View.OnClickListener oclbtnEnd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                vremja = SystemClock.elapsedRealtime() - chronometer.getBase();
                tren.vremja_vipolnenija = vremja;
                tren.save();
                Intent intent;
                intent = new Intent(uprTrenActivity.this, training.class);
                startActivity(intent);
            }
        };



        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent;
                intent = new Intent(uprTrenActivity.this,podhodiActivity.class);
                intent.putExtra("viborPunkta", position);
                intent.putExtra("den", denn);
                intent.putExtra("programma", progg);
                chronometer.stop();
                vremja = SystemClock.elapsedRealtime() - chronometer.getBase();
                intent.putExtra("vremjaTren",vremja);
                vibor=position;
                idTren = training.vibor+1;
                startActivity(intent);
            }
        });

        btnEnd.setOnClickListener(oclbtnEnd);
    }

    public void formirSpiska(){


        Long den = tren.den_programmi.getId();
        denn = den;
        Long prog = tren.programma.getId();
        progg = prog;
        str = atren.spisokUprDayCreate(den, prog);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        lv1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upr_tren, menu);
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
