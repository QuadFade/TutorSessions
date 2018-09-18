package com.cop2660.android.tutorsessions.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cop2660.android.tutorsessions.database.CustomerDbSchema.CustomerTable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 2;





    private static final String DATABASE_NAME = "customer.db";
    private static final String TABLE_NAME = "customer_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "PHONE_NUMBER";
    private static final String COL4 = "EMAIL_ADDRESS";
    private static final String COL5 = "ZIP_CODE";
    private static final String COL6 = "STREETADDRESS";
    private static final String COL7 = "CITY";
    private static final String COL8 = "STATE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
   public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " NAME TEXT, PHONE_NUMBER INTEGER," +
                    "EMAIL_ADDRESS TEXT,ZIP_CODE INTEGER)");
                    //"STREET_ADDRESS TEXT,CITY TEXT,STATE TEXT) ");
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public boolean addData(String name, String phoneNumber, String emailAddress, String zipCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        Log.d(TAG, "addData: Adding" + name + "to" + TABLE_NAME);
        contentValues.put(COL3,phoneNumber);
        Log.d(TAG, "addData: Adding " + phoneNumber + "to" + TABLE_NAME);
        contentValues.put(COL4,emailAddress);
        Log.d(TAG, "addData: Adding" + emailAddress + "to" + TABLE_NAME);
        contentValues.put(COL5,zipCode);
        Log.d(TAG, "addData: Adding" + zipCode + "to" + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        //String streetAddress, String city, String state
//        contentValues.put(COL6,streetAddress);
//        Log.d(TAG, "addData: Adding" + streetAddress + "to" + TABLE_NAME);
//        contentValues.put(COL7,city);
//        Log.d(TAG, "addData: Adding" + city + "to" + TABLE_NAME);
//        contentValues.put(COL8,state);
//        Log.d(TAG, "addData: Adding" + state + "to" + TABLE_NAME);


        // return the row ID of the newly inserted row, or -1 if an error occurred
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " +TABLE_NAME;
        Cursor result = db.rawQuery(query,null);
        return result;

    }
}

