package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao3Activity extends AppCompatActivity {
    Button buttonResponderQ3;
    RadioButton radioButtonFate;
    TextView textViewNome;
    int qtdErros = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3);
        
        buttonResponderQ3 = findViewById(R.id.buttonResponderQ3);
        radioButtonFate = findViewById(R.id.radioButtonFate);
        textViewNome = findViewById(R.id.textViewNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        if (!nome.equals(""))
            textViewNome.setText(nome);
        
        buttonResponderQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonFate.isChecked()) {
                    Toast.makeText(Questao3Activity.this, "Certo", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Activity.this);
                    msg.setMessage(nome + " você errou " + qtdErros + " vezes. Parabéns, ou não");
                    msg.show();
                }
                else {
                    Toast.makeText(Questao3Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                }
            }
        });
    }
}