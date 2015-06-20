package com.example.bled.mytrening;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class podhodiActivity extends ActionBarActivity {

    TextView tv1;
    ListView lv1;
    Integer viborPunkta;
    Button btnAddPodhod;
    Button btnEndUpr;
    String nazvanieUpr;
    Long den;
    Long prog;
    String [] str;
    final Atraining atren = new Atraining();
    Editable value;
    Integer kolPovtor;
    Chronometer chron;
    Long vremja;
    Long vremjaTren;
    Chronometer chron2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podhodi);

        tv1 = (TextView) findViewById(R.id.tv1);
        viborPunkta = getIntent().getExtras().getInt("viborPunkta");
        den = getIntent().getExtras().getLong("den");
        prog = getIntent().getExtras().getLong("programma");
        str = atren.spisokUprDayCreate(den, prog);
        nazvanieUpr = str[viborPunkta];
        tv1.setText("Упражнение - " + nazvanieUpr);

        btnAddPodhod = (Button) findViewById(R.id.btnAddPodhod);
        btnEndUpr = (Button) findViewById(R.id.btnEndUpr);

        final View.OnClickListener oclbtnAddPodhod = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                dobavleniePodhoda();
            }
        };

        final View.OnClickListener oclbtnEndUpr = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                chron2.stop();
                vremjaTren =SystemClock.elapsedRealtime() - chron2.getBase();
                Intent intent;
                intent = new Intent(podhodiActivity.this, uprTrenActivity.class);
                intent.putExtra("vremjaTrenSPodhodami",vremjaTren);
                Integer povtor = 1;
                intent.putExtra("povtor",povtor);
                uprTrenActivity uprTren = new uprTrenActivity();
                uprTren.povtorOtkr = 1;
                startActivity(intent);
            }
        };

        chron = (Chronometer) findViewById(R.id.chron);
        chron2 = (Chronometer) findViewById(R.id.chron2);
        vremjaTren = getIntent().getExtras().getLong("vremjaTren");
        chron2.setBase(SystemClock.elapsedRealtime() - vremjaTren);
        chron2.start();

        lv1 = (ListView) findViewById(R.id.lv1);
        formirSpiska();




        btnAddPodhod.setOnClickListener(oclbtnAddPodhod);
        btnEndUpr.setOnClickListener(oclbtnEndUpr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_podhodi, menu);
        return true;
    }

    public void formirSpiska(){
        chron.setBase(SystemClock.elapsedRealtime());
        chron.start();
        str = atren.spisokPodhodov((long) uprTrenActivity.idTren, den, uprTrenActivity.vibor);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        lv1.setAdapter(adapter);
    }

    public void dobavleniePodhoda(){
        //final String[] spisok = aprog.spisokUpragneniy();
        AlertDialog.Builder builder = new AlertDialog.Builder(podhodiActivity.this);
        builder.setTitle("Добавление подхода");
        builder.setMessage("Введите количество повторений");

        final EditText input = new EditText(podhodiActivity.this);
        builder.setView(input);
        builder.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                value = input.getText();
                kolPovtor = Integer.parseInt(value.toString());
                chron.stop();
                vremja = SystemClock.elapsedRealtime() - chron.getBase();
                atren.addPodhod((long)uprTrenActivity.idTren,den,uprTrenActivity.vibor,kolPovtor, vremja);
                formirSpiska();
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder.show();
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
