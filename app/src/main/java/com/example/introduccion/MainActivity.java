package com.example.introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
}