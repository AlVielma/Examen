package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.examen.Adapter.ContactoAdapter;
import com.example.examen.Models.Persona;

import java.util.ArrayList;
import java.util.List;

public class contactos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        List<Persona> contactos = new ArrayList<>();
        contactos.add(new Persona("Adrian", "8715652373","Lo conoci en la universidad, me hablo primero y fuimos a pistear jajaja"));
        contactos.add(new Persona("Javier", "8712515723","Yo mero caguamero"));
        contactos.add(new Persona("Miguel","8714683430","Amigo desde 2do cuatri"));
        contactos.add(new Persona("Jefita","8712317030","Mi madre"));
        RecyclerView rv = findViewById(R.id.recycler);
        rv.setAdapter(new ContactoAdapter(contactos));
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, realiza la llamada
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                startActivity(callIntent);
            } else {
                // Permiso denegado, muestra un mensaje al usuario
                Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

}