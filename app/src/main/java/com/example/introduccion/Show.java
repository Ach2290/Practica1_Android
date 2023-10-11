package com.example.introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.introduccion.Database.DatabaseAux;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
    public void changetoMain(View view){
        Intent nIntent = new Intent(Show.this, MainActivity.class);
        startActivity(nIntent);

    }
    void showElements(){
        SQLiteDatabase db =new DatabaseAux(this).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM soccerScout", null);
        TextView nameShow = findViewById(R.id.showname);
        TextView mailShow = findViewById(R.id.showmail);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String mail = cursor.getString(2);
                nameShow.setText(id +" " + name);
                mailShow.setText( mail);
            }while(cursor.moveToNext());
        }
        db.close();
    }
}