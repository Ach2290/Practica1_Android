package com.example.introduccion.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseAux extends SQLiteOpenHelper {
    private static final String DB_NAME = "SoccerScout";
    private static final int DB_VERSION = 1;


    public DatabaseAux(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR (25)NOT NULL, " +
                "email varchar (25) NOT NULL) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
