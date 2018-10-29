package com.example.admin.de2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLite extends SQLiteOpenHelper {
    private static final int version = 1   ;
    private static final String name = "db";
    private static final String SQL_CREATE_SANPHAM="Create table SV (" +
            "MSSV TEXT PRIMARY KEY, " +
            "MALOP TEXT, " +
            "TOAN INTEGER, " +
            "VAN INTEGER)";
    public SQLite(Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table = String.format("DROP TABLE IF EXISTS %s", db);

        db.execSQL(drop_table);

        onCreate(db);
        Log.d("onUpgrade","HELLO");
    }
}