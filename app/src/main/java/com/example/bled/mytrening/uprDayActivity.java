package com.example.bled.mytrening;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class uprDayActivity extends ActionBarActivity {

    public ListView list1;
    public Integer viborPunkta;
    public String[] str;
    public TextView soobshenie;
    Button btnAddUpr;
    Editable value;
    public Integer viborIzSpiska;
    Integer vibrannoeUpr;
    final Aprogramm aprog = new Aprogramm();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upr_day);
        list1 = (ListView) findViewById(R.id.lv1);
        soobshenie = (TextView) findViewById(R.id.soobshenie);
        btnAddUpr = (Button) findViewById(R.id.btnAddUpr);
        final View.OnClickListener oclbtnAddUpr = new View.OnClickListener() {
            @Override
            public void onClick(View v){

                final String[] varianti ={"Выбрать из списка", "Добавить новое"};

                AlertDialog.Builder builder1 = new AlertDialog.Builder(uprDayActivity.this);
                builder1.setTitle("Добавить упражнение"); // заголовок для диалога

                builder1.setItems(varianti, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        /*Toast.makeText(getApplicationContext(),
                                "Выбранный кот: " + varianti[item],
                                Toast.LENGTH_SHORT).show();*/
                        if (item==0){
                            vibor1();
                        }
                        if (item==1){
                            vibor2();
                        }
                    }
                });
                builder1.setCancelable(false);
                builder1.show();
            }
        };

        formirSpiska();

        btnAddUpr.setOnClickListener(oclbtnAddUpr);
    }

    public void formirSpiska(){
        if (dayActivity.perem==1){
            viborPunkta=dayActivity.vibor;
        }
        if (dayActivity.perem==0) {
            viborPunkta = getIntent().getExtras().getInt("viborPunkta");
            dayActivity.perem=1;
        }


        viborPunkta++;
        str = aprog.spisokUprDayCreate(viborPunkta,dayActivity.idProg+1);
        soobshenie.setText("");
        list1.setFocusable(true);
        if(str[0]==""){
            soobshenie.setText("В данной дне нет упражнений. Добавьте!!!");
            list1.setFocusable(false);
        }


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, str);
        list1.setAdapter(adapter);
    }

    public void vibor1(){
        final String[] spisok = aprog.spisokUpragneniy();

        AlertDialog.Builder builder2 = new AlertDialog.Builder(uprDayActivity.this);
        builder2.setTitle("Выберите упражнение")
                .setCancelable(false)

                        // добавляем одну кнопку для закрытия диалога
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        aprog.addUprDnja(dayActivity.vibor + 1, dayActivity.idProg + 1,vibrannoeUpr+1);
                        formirSpiska();
                    }
                })
                        // добавляем переключатели
                .setSingleChoiceItems(spisok, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item) {
                                vibrannoeUpr = item;
                                /*aprog.addUprDnja(dayActivity.vibor + 1, dayActivity.idProg + 1,item+1);
                                formirSpiska();*/
                            }
                        });
        builder2.show();
    }

    public void vibor2(){
        final String[] spisok = aprog.spisokUpragneniy();
        AlertDialog.Builder builder3 = new AlertDialog.Builder(uprDayActivity.this);
        builder3.setTitle("Добавление упражнения в программу");
        builder3.setMessage("Введите название упражнения программы");

        final EditText input = new EditText(uprDayActivity.this);
        builder3.setView(input);
        builder3.setSingleChoiceItems(spisok, -1,
                new DialogInterface.OnClickListener() {
                    //@Override
                    public void onClick(DialogInterface dialog,
                                        int item) {
                        viborIzSpiska=item;
                    }
                });
        builder3.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                value = input.getText();
                aprog.addNewUprDnja(value.toString(), dayActivity.vibor + 1, dayActivity.idProg + 1);
                formirSpiska();
            }
        });
        builder3.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder3.show();
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
