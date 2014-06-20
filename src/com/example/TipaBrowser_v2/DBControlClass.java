package com.example.TipaBrowser_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Practicant1.ORPO_KRG on 20.06.2014.
 */
public class DBControlClass extends SQLiteOpenHelper {

    final String LOG_TAG = "myLogs";

    public DBControlClass(Context context) {
        super(context, "myDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // create table
        sqLiteDatabase.execSQL("create table mytable ("
                + "id integer primary key autoincrement, "
                + "name text, "
                + "url text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    public void insertIntoDB(String name, String url){
        // create object for data
        ContentValues contentValues = new ContentValues();

        // connect to database
        SQLiteDatabase database = this.getWritableDatabase();

        Log.d(LOG_TAG, "--- Insert in mytable: ---");

        contentValues.put("name", name);
        contentValues.put("url", url);

        long rowID = database.insert("mytable", null, contentValues);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);
    }
}
