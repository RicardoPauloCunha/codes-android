package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Questao2Activity extends AppCompatActivity {
    Button buttonResponderQ2;
    CheckBox checkBoxLeonardoDeCaprio, checkBoxTomHanks, checkBoxJimCarrey, checkBoxWillSmith;
    TextView textViewNome;
    int qtdErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        buttonResponderQ2 = findViewById(R.id.buttonResponderQ2);
        checkBoxLeonardoDeCaprio = findViewById(R.id.checkBoxLeonardoDeCaprio);
        checkBoxTomHanks = findViewById(R.id.checkBoxTomHanks);
        checkBoxJimCarrey = findViewById(R.id.checkBoxJimCarrey);
        checkBoxWillSmith = findViewById(R.id.checkBoxWillSmith);
        textViewNome = findViewById(R.id.textViewNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        if (!nome.equals(""))
            textViewNome.setText(nome);

        buttonResponderQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxLeonardoDeCaprio.isChecked()
                        && checkBoxTomHanks.isChecked()
                        && !checkBoxJimCarrey.isChecked()
                        && !checkBoxWillSmith.isChecked()) {
                    Toast.makeText(Questao2Activity.this, "Certo", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Questao2Activity.this, Questao3Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Questao2Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                }
            }
        });
    }
}