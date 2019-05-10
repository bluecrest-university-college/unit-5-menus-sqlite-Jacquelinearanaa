package com.example.errorcorrection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME ="words.db";
    public static  final String TABLE_NAME = "allwords";
    public static  final String COLUM = "Id";
    public static final String COLUM1 = "RIGHT";
    public static final String COLUM2 = "WRONG";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public  void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE" + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"RIGHT TEXT,WRONG TEXT)";
        db.execSQL(createTable);
    }

        @Override
                public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if EXISTS" + TABLE_NAME);
        onCreate(db);
    }
    public void ADDDATA(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUM1, word.getRight());
        contentValues.put(COLUM2, word.getWrong());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public int UPDATEDATE(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUM1, word.getRight());
        contentValues.put(COLUM2, word.getWrong());

        return db.update(TABLE_NAME, contentValues,
        COLUM+"=?", new String[]{String.valueOf(word.getId())});

    }

    public void Delete(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUM+"=?", new String[]{String.valueOf(word.getId())});
        db.close();
    }
            public Word getWord(int id){
            SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUM, COLUM1, COLUM2}, COLUM+"=?",
        new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        return new Word(cursor.getInt(0), cursor.getString(1),cursor.getString(2));

    }

    }


