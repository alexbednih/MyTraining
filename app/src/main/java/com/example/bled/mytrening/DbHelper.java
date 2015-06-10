package com.example.bled.mytrening;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper{

    private static final String LOG_TAG = "my_tag";

    public static final String TABLE_UPRAGNENIJA = "tUpragnenija";
    public static final String KEY_ID_UPRAGNENIJA = "id_upragnenie";
    public static final String KEY_NAZVANIE_UPRAGNENIJA = "nazvanie";

    public static final String TABLE_PROGRAMMI = "tProgrammi";
    public static final String KEY_ID_PROGRAMMI = "id_programma";
    public static final String KEY_NAZVANIE_PROGRAMMI = "nazvanie";

    public static final String TABLE_DNI_PROGRAMMI = "tDniProgrammi";
    public static final String KEY_ID_DNI_PROGRAMMI = "id_den_programmi";
    public static final String KEY_NAZVANIE_DNI_PROGRAMMI = "nazvanie";
    public static final String KEY_ID_PROGRAMMI_DNI_PROGRAMMI = "id_programma";

    public static final String TABLE_TRENIROVKI = "tTrenirovki";
    public static final String KEY_ID_TRENIROVKI = "id_trenirovka";
    public static final String KEY_ID_PROGRAMMI_TRENIROVKI = "id_programma";
    public static final String KEY_ID_DNI_PROGRAMMI_TRENIROVKI = "id_den_programmi";
    public static final String KEY_DATA_TRENIROVKI = "data_trenirovki";
    public static final String KEY_VREMJA_TRENIROVKI = "vremja_vipolnenija";

    public static final String TABLE_PODHODI = "tPodhodi";
    public static final String KEY_ID_PODHODI = "id_podhod";
    public static final String KEY_ID_UPRAGNENIJA_PODHODI = "id_upragnenie";
    public static final String KEY_ID_TRENIROVKI_PODHODI = "id_trenirovka";
    public static final String KEY_KOL_POVTOR_PODHODI = "kol_povtoren";
    public static final String KEY_VREMJA_PODHODI = "vremja_vipolnenija";

    public static final String TABLE_UPRAGNENIJA_DNJA = "tUpragnenijaDnja";
    public static final String KEY_ID_UPRAGNENIJA_UPRAGNENIJA_DNJA = "id_upragnenie";
    public static final String KEY_ID_DNI_PROGRAMMI_UPRAGNENIJA_DNJA = "id_den_programmi";

    private static final String DATABASE_NAME = "myTrainingDB";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table tUpragnenija " +
                "(id_upragnenie integer primary key autoincrement," +
                "nazvanie text);");
        db.execSQL("create table tProgrammi " +
                "(id_programma integer primary key autoincrement," +
                "nazvanie text);");
        db.execSQL("create table tDniProgrammi " +
                "(id_den_programmi integer primary key autoincrement," +
                "nazvanie text," +
                "id_programma integer," +
                "FOREIGN KEY(id_programma) REFERENCES tProgrammi(id_programma));");
        db.execSQL("create table tTrenirovki " +
                "(id_trenirovka integer primary key autoincrement," +
                "id_programma integer," +
                "id_den_programmi integer," +
                "data_trenirovki DATE," +
                "vremja_vipolnenija DATETIME," +
                "FOREIGN KEY(id_programma) REFERENCES tProgrammi(id_programma)," +
                "FOREIGN KEY(id_den_programmi) REFERENCES tDniProgrammi(id_den_programmi));");
        db.execSQL("create table tPodhodi " +
                "(id_podhod integer primary key autoincrement," +
                "id_upragnenie integer," +
                "id_trenirovka integer," +
                "kol_povtoren integer," +
                "vremja_vipolnenija DATETIME," +
                "FOREIGN KEY(id_upragnenie) REFERENCES tUpragnenija(id_upragnenie)," +
                "FOREIGN KEY(id_trenirovka) REFERENCES tTrenirovki(id_trenirovka));");
        db.execSQL("create table tUpragnenijaDnja " +
                "(id_upragnenie integer," +
                "id_den_programmi integer," +
                "FOREIGN KEY(id_upragnenie) REFERENCES tUpragnenija(id_upragnenie)," +
                "FOREIGN KEY(id_den_programmi) REFERENCES tDniProgrammi(id_den_programmi));");


        ContentValues cv = new ContentValues();

        cv.put(KEY_NAZVANIE_UPRAGNENIJA, "Подтягивания");
        db.insert(TABLE_UPRAGNENIJA, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tUpragnenija");
        db.execSQL("DROP TABLE IF EXISTS tProgrammi");
        db.execSQL("DROP TABLE IF EXISTS tDniProgrammi");
        db.execSQL("DROP TABLE IF EXISTS tTrenirovki");
        db.execSQL("DROP TABLE IF EXISTS tPodhodi");
        db.execSQL("DROP TABLE IF EXISTS tUpragnenijaDnja");
        this.onCreate(db);
    }
}
