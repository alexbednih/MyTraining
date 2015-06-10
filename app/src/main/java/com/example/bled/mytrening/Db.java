package com.example.bled.mytrening;

import java.util.ArrayList;
import java.util.List;

import com.example.bled.mytrening.DniProgrammi;
import com.example.bled.mytrening.Podhodi;
import com.example.bled.mytrening.Programmi;
import com.example.bled.mytrening.Trenirovki;
import com.example.bled.mytrening.Upragnenija;
import com.example.bled.mytrening.UpragnenijaDnja;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
public class Db {
    private static final String LOG_TAG = "my_tag";
    DbHelper dbHelper;
    Context context;
    Cursor cursor;
    SQLiteDatabase db1;
    List<DniProgrammi> mDniProgrammiList;
    List<Podhodi> mPodhodoiList;
    List<Programmi> mProgrammiList;
    List<Trenirovki> mTrenirovkiList;
    List<Upragnenija> mUpragnenijaList;
    List<UpragnenijaDnja> mUpragnenijaDnjaList;

    public Db(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
        db1 = dbHelper.getWritableDatabase();
    }

    public List<DniProgrammi> getmDniProgrammiList() {
        cursor = db1.query(DbHelper.TABLE_DNI_PROGRAMMI, null, null, null, null, null, null);
        mDniProgrammiList = new ArrayList<DniProgrammi>();

        if (cursor.moveToFirst()) {

            int id_den_trenirovkiColInd = cursor.getColumnIndex(DbHelper.KEY_ID_DNI_PROGRAMMI);
            int nazvanieColInd = cursor.getColumnIndex(DbHelper.KEY_NAZVANIE_DNI_PROGRAMMI);
            int id_programmiColInd = cursor.getColumnIndex(DbHelper.KEY_ID_PROGRAMMI_DNI_PROGRAMMI);

            do {
                DniProgrammi dniprogrammi = new DniProgrammi(cursor.getInt(id_den_trenirovkiColInd),
                        cursor.getString(nazvanieColInd), cursor.getInt(id_programmiColInd));
                mDniProgrammiList.add(dniprogrammi);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В базе нет записей!");
        }

        cursor.close();

        return mDniProgrammiList;

    }

    public void close() {
        dbHelper.close();
        db1.close();
    }
}
