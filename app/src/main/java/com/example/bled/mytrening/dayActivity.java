package com.example.bled.mytrening;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class dayActivity extends ActionBarActivity {
    public String[] str;
    LinearLayout llMain;
    public ListView list1;
    public TextView soobshenie;
    Button btnDialog;
    public Integer viborPunkta;
    Editable value;
    public static int perem=0;
    public static int vibor=0;
    final Aprogramm aprog = new Aprogramm();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        list1 = (ListView) findViewById(R.id.lv1);
        soobshenie = (TextView) findViewById(R.id.soobshenie);
        btnDialog = (Button) findViewById(R.id.btnDialog);
        final View.OnClickListener oclbtnDialog = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final AlertDialog.Builder alert = new AlertDialog.Builder(dayActivity.this);

                alert.setTitle("Добавление нового дня программы");
                alert.setMessage("Введите название нового дня программы");
                final EditText input = new EditText(dayActivity.this);
                alert.setView(input);
                alert.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        value = input.getText();
                        aprog.addNewDayProgramm(value.toString(), program.vibor+1);
                        formirSpiska();
                    }
                });

                alert.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

                alert.show();
            }
        };

        formirSpiska();
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent;
                intent = new Intent(dayActivity.this,uprDayActivity.class);
                intent.putExtra("viborPunkta", position);
                startActivity(intent);
            }
        });

        btnDialog.setOnClickListener(oclbtnDialog);
    }

    public void formirSpiska(){
        if (program.perem==1){
            viborPunkta=program.vibor;
            program.perem=0;
        }
        if (program.perem==0) {
            viborPunkta = getIntent().getExtras().getInt("viborPunkta");
            program.perem=1;
        }


        viborPunkta++;
        str = aprog.menuDayCreate(viborPunkta);
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
        getMenuInflater().inflate(R.menu.menu_day, menu);
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
