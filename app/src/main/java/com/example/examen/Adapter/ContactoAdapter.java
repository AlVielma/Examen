package com.example.examen.Adapter;

import android.app.Activity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Models.Persona;
import com.example.examen.R;
import com.example.examen.contactos;
import com.example.examen.descripcion;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolder>{
    List<Persona> lista;

    public ContactoAdapter(List<Persona> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ContactoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcontacto, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.ViewHolder holder, int position) {
        Persona contacto = lista.get(position);
        holder.setData(contacto);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView setnombre,settelefono;
        Persona pc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            setnombre = itemView.findViewById(R.id.setnombre);
            settelefono = itemView.findViewById(R.id.settelefono);

            settelefono.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +pc.getTelefono()));
                        v.getContext().startActivity(callIntent);
                    } else {
                        ActivityCompat.requestPermissions((Activity) v.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                }
            });

            setnombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), descripcion.class);
                    pc = lista.get(getAdapterPosition());
                    intent.putExtra("nombre", pc.getNombre());
                    intent.putExtra("telefono", pc.getTelefono());
                    intent.putExtra("descripcion", pc.getDescripcion());
                    v.getContext().startActivity(intent);
                }
            });

        }

        public void setData(Persona persona) {
            pc = persona;
            setnombre.setText(persona.getNombre());
            settelefono.setText(persona.getTelefono());
        }
    }
}
