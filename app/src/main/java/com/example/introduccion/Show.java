package com.example.introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.introduccion.Database.DatabaseAux;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        showElements();
    }
    public void changetoMain(View view){
        Intent nIntent = new Intent(Show.this, MainActivity.class);
        startActivity(nIntent);

    }
    void showElements(){
        SQLiteDatabase db =new DatabaseAux(this).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);

        LinearLayout layout = findViewById(R.id.fillContentShow);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String mail = cursor.getString(2);

                TextView data = new TextView(this);
                data.setText("Nombre: " + name + "Email: " + mail);
                layout.addView(data);

            }while(cursor.moveToNext());
        }
        db.close();

    }
    public void delete (View View){

        TextView nameView = findViewById(R.id.deletename);
        TextView emailView = findViewById(R.id.deletemail);

        String nameString = nameView.getText().toString();
        String emailString = emailView.getText().toString();

        SQLiteDatabase db = new DatabaseAux(this).getWritableDatabase();

        if (db != null && !nameString.isEmpty() && !emailString.isEmpty()) {
            long res = db.delete("users", "name = '" + nameString + "'and email = '" + emailString + "'", null);

            if (res > 0) {
                Toast.makeText(this, "SE HAN BORRADO LOS DATOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();

                nameView.setText(" ");
                emailView.setText(" ");
            } else {
                Toast.makeText(this,"SE HA PRODUCIDO UN ERROR",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this ,"Error al acceder .La base de datos está vacia",
                Toast.LENGTH_SHORT).show();
        }

    }
}