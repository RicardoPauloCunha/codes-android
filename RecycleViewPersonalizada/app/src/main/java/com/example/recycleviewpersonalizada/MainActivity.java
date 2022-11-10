package com.example.recycleviewpersonalizada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DtoFilme> arrayListFilme = new ArrayList<>();
    RecyclerView recyclerViewFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilme = findViewById(R.id.recyclerViewFilme);

        carregaFilmes();
        MeuAdapter adapter = new MeuAdapter(arrayListFilme);

        recyclerViewFilme.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewFilme.setAdapter(adapter);

        recyclerViewFilme.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerViewFilme,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String nome = arrayListFilme.get(position).getTitulo();
                        Toast.makeText(MainActivity.this, "Nome " + nome, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        String genero = arrayListFilme.get(position).getGenero();
                        Toast.makeText(MainActivity.this, "Nome " + genero, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));
    }

    private void carregaFilmes() {
        DtoFilme dtoFilme = new DtoFilme("Um sonho de liberdade", "1994", "9.2", "Drama", R.drawable.sonho);
        DtoFilme dtoFilme2 = new DtoFilme("O poderoso chefão", "1972", "9.1", "Drama", R.drawable.chefao1);
        DtoFilme dtoFilme6 = new DtoFilme("O poderoso chefão 2", "1974", "9.0", "Drama", R.drawable.chefao2);
        DtoFilme dtoFilme3 = new DtoFilme("Cavaleiro das trevas", "2008", "9.0", "Aventura", R.drawable.batman);
        DtoFilme dtoFilme4 = new DtoFilme("12 homens e uma sentença", "1978", "8.9", "Drama", R.drawable.sentenca);
        DtoFilme dtoFilme5 = new DtoFilme("A lista de Schindler", "1957", "8.8", "Drama", R.drawable.lista);

        arrayListFilme.add(dtoFilme);
        arrayListFilme.add(dtoFilme2);
        arrayListFilme.add(dtoFilme3);
        arrayListFilme.add(dtoFilme4);
        arrayListFilme.add(dtoFilme5);
        arrayListFilme.add(dtoFilme6);
    }
}