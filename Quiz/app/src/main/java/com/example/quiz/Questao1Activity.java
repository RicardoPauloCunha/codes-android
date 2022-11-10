package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao1Activity extends AppCompatActivity {
    Button buttonResponder;
    RadioButton radioButtonParasita;
    TextView textViewNome;
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1);

        buttonResponder = findViewById(R.id.buttonResponder);
        radioButtonParasita = findViewById(R.id.radioButtonParasita);
        textViewNome = findViewById(R.id.textViewNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nome = bundle.getString("nome");

        if (!nome.equals(""))
            textViewNome.setText(nome);

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonParasita.isChecked()) {
                    Toast.makeText(Questao1Activity.this, "Certo", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Questao1Activity.this, Questao2Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                } else {
                    Toast.makeText(Questao1Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                }
            }
        });
    }
}