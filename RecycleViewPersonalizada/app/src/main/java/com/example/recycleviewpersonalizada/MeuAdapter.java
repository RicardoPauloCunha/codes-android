package com.example.recycleviewpersonalizada;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {
    ArrayList<DtoFilme> arrayListFilme;

    public MeuAdapter(ArrayList<DtoFilme> arrayListFilme) {
        this.arrayListFilme = arrayListFilme;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.meu_adapter, parent, false);
        return new MeuViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {
        holder.textViewTitulo.setText(arrayListFilme.get(position).getTitulo());
        holder.textViewNota.setText(arrayListFilme.get(position).getNota());
        holder.textViewGenero.setText(arrayListFilme.get(position).getGenero());
        holder.textViewAno.setText(arrayListFilme.get(position).getAno());
        holder.imageViewFilme.setImageResource(arrayListFilme.get(position).getIdImagem());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MeuViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitulo, textViewNota, textViewGenero, textViewAno;
        ImageView imageViewFilme;

        public MeuViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewNota = itemView.findViewById(R.id.textViewNota);
            textViewGenero = itemView.findViewById(R.id.textViewGenero);
            textViewAno = itemView.findViewById(R.id.textViewAno);
            imageViewFilme = itemView.findViewById(R.id.imageViewFilme);
        }
    }
}
