package com.example.bled.mytrening;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class training extends ActionBarActivity {

    Button btnAddNew;
    ListView lv1;
    TextView soobshenie;
    String[] str;
    Atraining atren = new Atraining();
    Aprogramm aprog = new Aprogramm();
    Integer vibrannajaProg;
    Integer vibranniyDen;
    public static int vibor=0;
    public static int perem=0;
    public static Long trenirovka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        soobshenie = (TextView) findViewById(R.id.soobshenie);
        btnAddNew = (Button) findViewById(R.id.btnAddNew);
        lv1 = (ListView) findViewById(R.id.lv1);

        final View.OnClickListener oclbtnAddNew = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] spisok = aprog.menuCreate();
                AlertDialog.Builder builder = new AlertDialog.Builder(training.this);
                builder.setTitle("Выберите программу")
                        .setCancelable(false)

                                // добавляем одну кнопку для закрытия диалога
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        })
                        .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                viborOK(vibrannajaProg);
                            }
                        })
                                // добавляем переключатели
                        .setSingleChoiceItems(spisok, -1,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int item) {
                                        vibrannajaProg = item+1;
                                    }
                                });
                builder.show();
            }};
        formirSpiska();


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent;
                intent = new Intent(training.this,uprTrenActivity.class);
                intent.putExtra("viborPunkta", position);
                vibor=position;
                startActivity(intent);
            }
        });


        btnAddNew.setOnClickListener(oclbtnAddNew);
    }

    public void viborOK(Integer i){
        final String[] spisok = aprog.menuDayCreate(i);
        AlertDialog.Builder builder = new AlertDialog.Builder(training.this);
        builder.setTitle("Выберите день")
                .setCancelable(false)

                        // добавляем одну кнопку для закрытия диалога
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //что-то надо здесь сделать
                        atren.addTrenirovka(vibranniyDen, vibrannajaProg);
                        formirSpiska();
                    }
                })
                        // добавляем переключатели
                .setSingleChoiceItems(spisok, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item) {
                                vibranniyDen = item+1;
                            }
                        });
        builder.show();
    }

    public void formirSpiska(){
        str = atren.spisokTrenirovok();
        soobshenie.setText("");
        if(str[0]==""){
            soobshenie.setText("Тренировок еще нет. Начинайте заниматься!!!");
            lv1.setFocusable(false);
        }
        lv1.setFocusable(true);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        lv1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_training, menu);
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
