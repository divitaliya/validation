package com.example.validation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Mydb extends SQLiteOpenHelper {
    public Mydb(@Nullable Context context) {
        super(context, "register", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "create table student(id integer primary key,name text,contact text,password text)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void insertdata(String name, String contact, String pass)
    {
        String q = "insert into student values(null,'"+name+"','"+contact+"','"+pass+"')";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(q);
    }
    void updatedata(String id,String name, String contact, String pass)
    {
        String q = "update student set name='"+name+"',contact='"+contact+"',password='"+pass+"' where id='"+id+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(q);
    }
    Cursor getdata()
    {
        String q = "select * from student";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery(q,null);
        return c;
    }
    void deletdata(String id1)
    {
        String q = "delete from student where id='"+id1+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(q);
    }


}
