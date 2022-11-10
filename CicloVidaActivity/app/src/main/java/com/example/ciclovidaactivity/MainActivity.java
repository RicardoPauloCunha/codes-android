package com.example.ciclovidaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonIniciar, buttonParar;
    TextView textViewTempo;
    CountDownTimer countDown;
    EditText editTextShared;
    long tempoRestante;

    @Override
    protected void onStop() {
        super.onStop();

        countDown.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences preferences = getSharedPreferences("minhaShared", 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("meuTexto", editTextShared.getText().toString() + "");

        editor.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        countDown = new CountDownTimer(tempoRestante, 1 * 1000) {
            @Override
            public void onTick(long tempoRestante) {
                textViewTempo.setText(tempoRestante / 1000 + "");
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Voltando ao jogo...", Toast.LENGTH_SHORT).show();
            }
        };

        countDown.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonIniciar = findViewById(R.id.buttonIniciar);
        buttonParar = findViewById(R.id.buttonParar);
        textViewTempo = findViewById(R.id.textViewTempo);
        editTextShared = findViewById(R.id.editTextShared);

        SharedPreferences preferences = getSharedPreferences("minhaShared", 0);
        String meuTexto = preferences.getString("meuTexto", "Texto não encontrado");

        editTextShared.setText(meuTexto);

        countDown = new CountDownTimer(30 * 1000, 1 * 1000) {
            @Override
            public void onTick(long tempoRestante) {
                textViewTempo.setText(tempoRestante / 1000 + "");
                MainActivity.this.tempoRestante = tempoRestante;
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Voltando ao jogo...", Toast.LENGTH_SHORT).show();
            }
        };

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown.start();
            }
        });

        buttonParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown.cancel();
            }
        });
    }
}