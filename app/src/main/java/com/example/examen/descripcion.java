package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class descripcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        TextView getnom = findViewById(R.id.getnombre);
        TextView gettel = findViewById(R.id.getdescripcion);

        Intent intent = getIntent();

        getnom.setText(intent.getStringExtra("nombre"));
        gettel.setText(intent.getStringExtra("descripcion"));
    }
}