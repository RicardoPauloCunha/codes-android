package com.example.listafilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextNomeFilme;
    Button buttonAdicionar;
    ListView listViewFilme;
    TextView textViewNone;
    ArrayList<String> arrayListFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        listViewFilme = findViewById(R.id.listViewFilme);
        textViewNone = findViewById(R.id.textViewNone);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextNomeFilme.getText().toString().equals("")) {
                    arrayListFilmes.add(editTextNomeFilme.getText().toString());

                    atualizarListView();

                    editTextNomeFilme.setText("");
                }
            }
        });

        listViewFilme.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int index, long l) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);

                msg.setMessage("Deseja realmente excluir?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayListFilmes.remove(index);

                        atualizarListView();


                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();

                return false;
            }
        });
    }

    private void atualizarListView() {
        if (arrayListFilmes.isEmpty())
            textViewNone.setText("Nenhum filme adicionado");
        else
            textViewNone.setText("");

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListFilmes);

        listViewFilme.setAdapter(arrayAdapter);
    }
}