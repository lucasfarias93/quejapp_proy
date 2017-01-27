package com.projectbelatrix.quejapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Elias on 24/01/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Quejapp.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String ID = "id";
    private static final String COLUMN_APELLIDO = "apellido";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USUARIO = "usuario";
    private static final String COLUMN_CONTRASEÑA = "contraseña";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table users (id integer primary key not null , " +
            "nombre text not null , apellido text not null , email text not null , usuario text not null , contraseña text not null);";

    public DatabaseHelper (Context context) {
      super (context , DATABASE_NAME ,null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL(TABLE_CREATE);
          this.db = db;
    }
    public void insertUser(User u){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = " select * from users ";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put (ID,count);
        values.put (COLUMN_NOMBRE, u.getNombre());
        values.put (COLUMN_APELLIDO, u.getApellido());
        values.put (COLUMN_EMAIL, u.getEmail());
        values.put (COLUMN_USUARIO, u.getUsername());
        values.put (COLUMN_CONTRASEÑA, u.getPassword());

        db.insert(TABLE_NAME , null , values);
        db.close();
    }
    public boolean validateUser(String user) {
        boolean valor = false;
        db = this.getReadableDatabase();
        String query = "select usuario from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a;

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(user)) {
                    valor = true;
                }
            } while (cursor.moveToNext());
            return valor;
        }
        return valor;
    }
    public String searchPassword (String user){

       db = this.getReadableDatabase();
        String query = " select usuario, contraseña from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a , b ;
        b = "not found";
        if (cursor.moveToFirst()){
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);
                if (a.equals(user)){
                 b = cursor.getString(1);
                }
            } while (cursor.moveToNext());
        }
        return b;
    }

    public User getProfileData(String user){
        User usuario = new User();
        db = this.getReadableDatabase();
        String query = " select nombre , apellido , email , usuario , contraseña from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(3);
                if(a.equals(user)){
                    usuario.setUsername(cursor.getString(3));
                    usuario.setPassword(cursor.getString(4));
                    usuario.setNombre(cursor.getString(0));
                    usuario.setApellido(cursor.getString(1));
                    usuario.setEmail(cursor.getString(2));
                }
            } while (cursor.moveToNext());
            return usuario;
        }
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
    }
}
