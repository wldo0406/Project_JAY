package com.example.project_jay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 전지연 on 2016-11-25.
 */
public class MyDBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME="schedulev.db";
    private static final int DATABASE_VERSION = 1;
    private static MyDBHelper helper;

    static public MyDBHelper getInstance(Context context) {
        if (helper == null)
            helper = new MyDBHelper(context);
        return helper;
    }

    private MyDBHelper(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE schedulev(" +
                "_id INTEGER  NOT NULL PRIMARY KEY," +
                "title1 TEXT  NULL," +
                "month1 TEXT  NULL," +
                "day1 TEXT  NULL," +
                "starth1 TEXT  NULL," +
                "startm1 TEXT  NULL," +
                "finishh1 TEXT  NULL," +
                "finishm1 TEXT  NULL" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS schedulev");

        onCreate(db);
    }
}
