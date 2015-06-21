package com.example.bled.mytrening;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class statistics extends ActionBarActivity {

    Spinner spinner;
    String[] str;
    Button btnStat;
    Astatistics stat = new Astatistics();
    public static int vibor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        spinner = (Spinner) findViewById(R.id.spinner);
        btnStat = (Button) findViewById(R.id.btnStat);
        final View.OnClickListener oclbtnStat = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent;
                intent = new Intent(statistics.this,pokazStatActivity.class);
                intent.putExtra("viborPunkta", vibor);
                startActivity(intent);
            }
        };
        str = stat.spisokUpr();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                vibor = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        btnStat.setOnClickListener(oclbtnStat);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistics, menu);
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
