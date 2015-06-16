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
import android.content.Intent;
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
    //Формирование списков записей таблиц
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
            Log.d(LOG_TAG, "В таблице нет записей!");
        }

        cursor.close();

        return mDniProgrammiList;

    }

    public List<Podhodi> getmPodhodoiList() {
        cursor = db1.query(DbHelper.TABLE_PODHODI, null, null, null, null, null, null);
        mPodhodoiList = new ArrayList<Podhodi>();

        if (cursor.moveToFirst()) {

            int id_podhodColInd = cursor.getColumnIndex(DbHelper.KEY_ID_PODHODI);
            int id_upragnenieColInd = cursor.getColumnIndex(DbHelper.KEY_ID_UPRAGNENIJA_PODHODI);
            int id_trenirovkaColInd = cursor.getColumnIndex(DbHelper.KEY_ID_TRENIROVKI_PODHODI);
            int kol_povtorenColInd = cursor.getColumnIndex(DbHelper.KEY_KOL_POVTOR_PODHODI);
            int vremja_vipolnenijaColInd = cursor.getColumnIndex(DbHelper.KEY_VREMJA_PODHODI);

            do {
                Podhodi podhodi = new Podhodi(cursor.getInt(id_podhodColInd),
                        cursor.getInt(id_upragnenieColInd), cursor.getInt(id_trenirovkaColInd),
                        cursor.getInt(kol_povtorenColInd), cursor.getInt(vremja_vipolnenijaColInd));
                mPodhodoiList.add(podhodi);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В таблице нет записей!");
        }

        cursor.close();

        return mPodhodoiList;

    }

    public List<Programmi> getmProgrammiList() {
        cursor = db1.query(DbHelper.TABLE_PROGRAMMI, null, null, null, null, null, null);
        mProgrammiList = new ArrayList<Programmi>();

        if (cursor.moveToFirst()) {

            int id_programmiColInd = cursor.getColumnIndex(DbHelper.KEY_ID_PROGRAMMI);
            int nazvanieColInd = cursor.getColumnIndex(DbHelper.KEY_NAZVANIE_PROGRAMMI);


            do {
                Programmi programmi = new Programmi(cursor.getInt(id_programmiColInd),
                        cursor.getString(nazvanieColInd));
                mProgrammiList.add(programmi);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В таблице нет записей!");
        }

        cursor.close();

        return mProgrammiList;

    }

    public List<Trenirovki> getmTrenirovkiList() {
        cursor = db1.query(DbHelper.TABLE_TRENIROVKI, null, null, null, null, null, null);
        mTrenirovkiList = new ArrayList<Trenirovki>();

        if (cursor.moveToFirst()) {

            int id_trenirovkaColInd = cursor.getColumnIndex(DbHelper.KEY_ID_TRENIROVKI);
            int id_programmaColInd = cursor.getColumnIndex(DbHelper.KEY_ID_PROGRAMMI_TRENIROVKI);
            int id_den_programmiColInd = cursor.getColumnIndex(DbHelper.KEY_ID_DNI_PROGRAMMI_TRENIROVKI);
            int data_trenirovkiColInd = cursor.getColumnIndex(DbHelper.KEY_DATA_TRENIROVKI);
            int vremja_vipolnenijaColInd = cursor.getColumnIndex(DbHelper.KEY_VREMJA_TRENIROVKI);

            do {
                Trenirovki trenirovki = new Trenirovki(cursor.getInt(id_trenirovkaColInd),
                        cursor.getInt(id_programmaColInd), cursor.getInt(id_den_programmiColInd),
                        cursor.getInt(data_trenirovkiColInd), cursor.getInt(vremja_vipolnenijaColInd));
                mTrenirovkiList.add(trenirovki);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В таблице нет записей!");
        }

        cursor.close();

        return mTrenirovkiList;

    }

    public List<Upragnenija> getmUpragnenijaList() {
        cursor = db1.query(DbHelper.TABLE_UPRAGNENIJA, null, null, null, null, null, null);
        mUpragnenijaList = new ArrayList<Upragnenija>();

        if (cursor.moveToFirst()) {

            int id_upragnenieColInd = cursor.getColumnIndex(DbHelper.KEY_ID_UPRAGNENIJA);
            int nazvanieColInd = cursor.getColumnIndex(DbHelper.KEY_NAZVANIE_UPRAGNENIJA);


            do {
                Upragnenija upragnenija = new Upragnenija(cursor.getInt(id_upragnenieColInd),
                        cursor.getString(nazvanieColInd));
                mUpragnenijaList.add(upragnenija);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В таблице нет записей!");
        }

        cursor.close();



        return mUpragnenijaList;


    }


    public List<UpragnenijaDnja> getmUpragnenijaDnjaList() {
        cursor = db1.query(DbHelper.TABLE_UPRAGNENIJA_DNJA, null, null, null, null, null, null);
        mUpragnenijaDnjaList = new ArrayList<UpragnenijaDnja>();

        if (cursor.moveToFirst()) {

            int id_upragnenie_dnjaColInd = cursor.getColumnIndex(DbHelper.KEY_ID_UPRAGNENIJA_DNJA);
            int id_upragnenieColInd = cursor.getColumnIndex(DbHelper.KEY_ID_UPRAGNENIJA_UPRAGNENIJA_DNJA);
            int id_den_programmiColInd = cursor.getColumnIndex(DbHelper.KEY_ID_DNI_PROGRAMMI_UPRAGNENIJA_DNJA);


            do {
                UpragnenijaDnja upragnenijaDnja = new UpragnenijaDnja(cursor.getInt(id_upragnenie_dnjaColInd),
                        cursor.getInt(id_upragnenieColInd),
                        cursor.getInt(id_den_programmiColInd));
                mUpragnenijaDnjaList.add(upragnenijaDnja);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В таблице нет записей!");
        }

        cursor.close();

        return mUpragnenijaDnjaList;

    }

    public void close() {
        dbHelper.close();
        db1.close();
    }
}
