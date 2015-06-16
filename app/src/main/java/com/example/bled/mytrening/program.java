package com.example.bled.mytrening;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bled.mytrening.Db;
import java.util.ArrayList;
import java.util.List;

import static android.app.LauncherActivity.*;


public class program extends ActionBarActivity {

    public String [] str2 = {"3435"};
    LinearLayout llMain;
    Context context;
    Db dbl;
    MainActivity mAc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        //dbl =  new Db(this);
        mAc = new MainActivity();
        String str;
//        List<Programmi> mProgList = mAc.db2.getmProgrammiList();

        int i=0;
        Resources res = getResources();

        String[] stroki = res.getStringArray(R.array.stroki);

  //      for (Programmi prog : mProgList){
    //        str2[i]=prog.getNazvanie();
      //      i++;
        //}
        llMain = (LinearLayout) findViewById(R.id.llMain);
        ListView list1 = (ListView) findViewById(R.id.lv1);
//      llMain.addView(list1);
str = "fdfdf";
        TextView txt = (TextView) findViewById(R.id.textView7);
        txt.setText(str);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stroki);

        list1.setAdapter(adapter);

        ListView list2 = (ListView) findViewById(R.id.listView2);

       // dbl.close();
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