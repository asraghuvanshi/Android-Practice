package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "contactManager";
    public static int DATABASE_VERSION = 1;
    public static final String TABLE_CONTACTS="contacts";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone_number";
    public static final String KEY_ID = "id";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  CREATE_CONTACT_TABLE =  "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PHONE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
        Log.d("table", "table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Contact> contactArrayList(){
         ArrayList<Contact> contactlist = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_CONTACTS;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery , null);
        if(cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String contact_name = cursor.getString(1);
                String contact_number = cursor.getString(2);
                contactlist.add(new Contact(id , contact_name, contact_number));
            }while (cursor.moveToNext());
        }
        return contactlist;

    }

    void AddContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME ,  contact.getName());
        contentValues.put(KEY_PHONE, contact.getPhone_number());
        db.insert(TABLE_CONTACTS , null, contentValues);
        Log.d("added_data", "Added Contact");
        db.close();
    }

    Contact  getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACTS , new String[] {KEY_ID , KEY_PHONE, KEY_NAME}, KEY_ID+"?",
                new String[]{String.valueOf(id)} , null, null,null);
        if (cursor!=null) {
            cursor.moveToFirst();}
            Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
     return contact;
    }

    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, contact.getId());
        contentValues.put(KEY_NAME, contact.getName());
        contentValues.put(KEY_NAME, contact.getPhone_number());
        return db.update(TABLE_CONTACTS, contentValues ,KEY_ID+"?",new String[]{
                String.valueOf(getContact(contact.getId()))
        });
    }
    public void deleteContacts(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID +"=?" , new String[]{String.valueOf(contact.getId())});
        db.close();
    }
}
