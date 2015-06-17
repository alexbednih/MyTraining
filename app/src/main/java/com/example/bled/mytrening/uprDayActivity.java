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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class uprDayActivity extends ActionBarActivity {

    LinearLayout llMain;
    public ListView list1;
    public Integer viborPunkta;
    public String[] str;
    public String[] spisok;
    public TextView soobshenie;
    Button btnAddUpr;
    Editable value;
    public Integer viborIzSpiska;
    final Aprogramm aprog = new Aprogramm();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upr_day);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        list1 = (ListView) findViewById(R.id.lv1);
        soobshenie = (TextView) findViewById(R.id.tv1);
        btnAddUpr = (Button) findViewById(R.id.btnAddUpr);

        final View.OnClickListener oclbtnAddUpr = new View.OnClickListener() {

            @Override
            public void onClick(View v){
                spisok = aprog.spisokUpragnenii();

                final AlertDialog.Builder alert = new AlertDialog.Builder(uprDayActivity.this);

                alert.setTitle("Добавление упражнения в программу");
                alert.setMessage("Введите название упражнения программы");

                final EditText input = new EditText(uprDayActivity.this);
                alert.setView(input);
                alert.setSingleChoiceItems(spisok, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item) {
                                //viborIzSpiska=item;
                            }
                        });
                alert.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        value = input.getText();
                        aprog.addUprDnja(value.toString(), dayActivity.vibor+1, dayActivity.idProg + 1);
                        formirSpiska();
                    }
                });
                alert.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
                //alert.create();
                alert.show();
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
