package com.example.bled.mytrening;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.bled.mytrening.DniProgrammi;
import com.example.bled.mytrening.Podhodi;
import com.example.bled.mytrening.Programmi;
import com.example.bled.mytrening.Trenirovki;
import com.example.bled.mytrening.Upragnenija;
import com.example.bled.mytrening.UpragnenijaDnja;
import java.util.List;
import com.orm.SugarRecord;

public class MainActivity extends ActionBarActivity {


    Button programBtn;
    Button trainingBtn;
    Button statisticsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        programBtn = (Button) findViewById(R.id.button);
        trainingBtn = (Button) findViewById(R.id.button2);
        statisticsBtn = (Button) findViewById(R.id.button3);
        final View.OnClickListener oclProgramBtn = new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent;
                intent = new Intent(MainActivity.this,program.class);
                startActivity(intent);
            }
        };
        final View.OnClickListener oclTrainingBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent;
                intent = new Intent(MainActivity.this,training.class);
                startActivity(intent);
            }
        };
        final View.OnClickListener oclStatisticsBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent;
                intent = new Intent(MainActivity.this,statistics.class);
                startActivity(intent);
            }
        };
        programBtn.setOnClickListener(oclProgramBtn);
        trainingBtn.setOnClickListener(oclTrainingBtn);
        statisticsBtn.setOnClickListener(oclStatisticsBtn);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
