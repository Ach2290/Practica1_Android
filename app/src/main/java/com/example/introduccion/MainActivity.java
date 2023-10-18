package com.example.introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.introduccion.Database.DatabaseAux;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button buttonTest = findViewById(R.id.BotonEntrar);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "BIENVENIDO A SOCCERSCOUT", Toast.LENGTH_SHORT).show();

            }

        });*/

    }

    public void diceAdios(View view){
        // leo lo que ha escrito el ususario
        TextView textocorreo = findViewById(R.id.textoCorreo);
        String correo = textocorreo.getText().toString();
        Toast.makeText(this, "Hola" + correo, Toast.LENGTH_SHORT).show();
    }
    public void changetoInser(View view){
        Intent nIntent = new Intent(MainActivity.this, Principal.class);
        startActivity(nIntent);
    }
    public void changetoShow(View view){
        Intent nIntent = new Intent(MainActivity.this, Show.class);
        startActivity(nIntent);
    }
    public void insertValue(View v){
       TextView nameTextView = findViewById(R.id.textoCorreo);
        TextView emailTextView = findViewById(R.id.textoContra);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(MainActivity.this);
        SQLiteDatabase db= aux.getWritableDatabase();

    if(db!= null && !nameString.isEmpty() && !emailString.isEmpty()){

        ContentValues values= new ContentValues();
        values.put("name",nameString);
        values.put("email",emailString);
        long res= db.insert("users", null,values);
        if(res>=0){
            Toast.makeText(this,"Insertado correctamente", Toast.LENGTH_SHORT).show();
            nameTextView.setText("");
            emailTextView.setText("");

        }else{
            Toast.makeText(this,"Error al introducir los datos", Toast.LENGTH_SHORT).show();
        }
    }



    }
}