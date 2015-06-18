package com.example.bled.mytrening;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
//import com.example.bled.mytrening.Aprogramm;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bled.mytrening.Db;
import java.util.ArrayList;
import java.util.List;

import static android.app.LauncherActivity.*;
import static com.example.bled.mytrening.R.layout.activity_program;


public class program extends ActionBarActivity {

    Button btnDialog;
    public TextView soobshenie;
    public String[] str,str2;
    public static int perem=0;
    public static int vibor=0;
    ListView list1;
    int vtoroeMenu = 0;
    final Aprogramm aprog = new Aprogramm();
    Editable value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_program);
        list1 = (ListView) findViewById(R.id.lv1);
        soobshenie = (TextView) findViewById(R.id.soobshenie);
        btnDialog = (Button) findViewById(R.id.btnDialog);
        final View.OnClickListener oclbtnDialog = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final AlertDialog.Builder alert = new AlertDialog.Builder(program.this);

                alert.setTitle("Добавление новой программы");
                alert.setMessage("Введите название новой программы");
                final EditText input = new EditText(program.this);
                alert.setView(input);
                alert.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        value = input.getText();
                        aprog.addNewProgramm(value.toString());
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
                intent = new Intent(program.this,dayActivity.class);
                intent.putExtra("viborPunkta", position);
                vibor=position;
                startActivity(intent);
            }
        });
        btnDialog.setOnClickListener(oclbtnDialog);
    }

    private void formirSpiska(){
        soobshenie.setText("");
        str = aprog.menuCreate();
        if(str[0]==""){
            soobshenie.setText("Программ нет. Добавьте!!!");
            list1.setFocusable(false);
        }

        list1.setFocusable(true);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        list1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_program, menu);
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
    }}