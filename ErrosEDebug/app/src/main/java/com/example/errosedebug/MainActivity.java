package com.example.errosedebug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonIncluirSenha, buttonAdd1;
    EditText editTextSenha, editTextSenha2, editTextContador;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonIncluirSenha = findViewById(R.id.buttonIncluirSenha);
        buttonAdd1 = findViewById(R.id.buttonAdd1);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextSenha2 = findViewById(R.id.editTextSenha2);
        editTextContador = findViewById(R.id.editTextContador);

        buttonIncluirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String senha = editTextSenha.getText().toString();
                String confirmaSenha = editTextSenha2.getText().toString();

                if (senha.equals(confirmaSenha))
                    Toast.makeText(MainActivity.this, "Iguais", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Diferentes", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                Log.d("senhas", "Senhas iguais");
                editTextContador.setText(i + "");
            }
        });
    }
}