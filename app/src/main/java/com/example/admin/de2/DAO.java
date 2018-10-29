package com.example.admin.de2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    private SQLiteDatabase db;
    private SQLite data;
    public DAO(Context context){
        data = new SQLite(context);
        db = data.getWritableDatabase();
    }
    public List<Model> getPr(String sql, String...selectionArgs){
        List<Model> list = new ArrayList<>();
        Cursor c =db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Model sv = new Model();
            sv.MaSV = c.getString(c.getColumnIndex("MSSV"));
            sv.MaLop = c.getString(c.getColumnIndex("MALOP"));
            sv.dToan = c.getInt(c.getColumnIndex("TOAN"));
            sv.dVan = c.getInt(c.getColumnIndex("VAN"));
            list.add(sv);
        }
        return list;
    }

    public List<Model> getSPAll(){
        String sql = "SELECT * FROM SV";
        return getPr(sql);
    }
    public List<Model> getLop(String lop){
        String sql = "SELECT * FROM SV WHERE MALOP="+lop;
        return getPr(sql);
    }
    public List<Model> getMon(String mon){
        String sql = "SELECT * FROM SV WHERE MALOP="+mon;
        return getPr(sql);
    }

    public long insert(Model p){
        ContentValues values = new ContentValues();
        values.put("MSSV",p.MaSV);
        values.put("MALOP",p.MaLop);
        values.put("TOAN",p.dToan);
        values.put("VAN",p.dVan);
        return db.insert("SV",null,values);
    }

}