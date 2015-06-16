package com.example.bled.mytrening;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    public String[] str,str2;
    LinearLayout llMain;
    int vtoroeMenu = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_program);
        //List<Book> books = Book.listAll(Book.class);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        ListView list1 = (ListView) findViewById(R.id.lv1);
        final Aprogramm aprog = new Aprogramm();
        str = aprog.menuCreate();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        list1.setAdapter(adapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView txt = (TextView) findViewById(R.id.textView7);
                txt.setText("itemClick: position = " + position + ", id = " + id);
                Intent intent;
                intent = new Intent(program.this,dayActivity.class);
                intent.putExtra("viborPunkta", position);
                startActivity(intent);
            }
        });
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