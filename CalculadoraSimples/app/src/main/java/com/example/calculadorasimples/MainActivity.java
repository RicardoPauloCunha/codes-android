package com.example.calculadorasimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonSoma, buttonSub, buttonDiv, buttonMult;
    EditText editTextValor1, editTextValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associa componentes java aos componentes XML
        buttonSoma = findViewById(R.id.button_soma);
        buttonSub = findViewById(R.id.button_sub);
        buttonDiv = findViewById(R.id.button_div);
        buttonMult = findViewById(R.id.button_mult);
        editTextValor1 = findViewById(R.id.edit_valor1);
        editTextValor2 = findViewById(R.id.edit_valor2);

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("soma");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("sub");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("div");
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("mult");
            }
        });
    }

    public void mostraResultado(String op) {
        double result = 0;

        if (editTextValor1.getText().length() != 0
            && editTextValor2.getText().length() != 0 ) {
            double v1 = Double.parseDouble(editTextValor1.getText().toString());
            double v2 = Double.parseDouble(editTextValor2.getText().toString());

            if (op == "soma")
                result = v1 + v2;
            else if (op == "sub")
                result = v1 - v2;
            else if (op == "div")
                result = v1 / v2;
            else if (op == "mult")
                result = v1 * v2;

            // Toast.makeText(MainActivity.this, "Resultado: " + result, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
            msg.setTitle("Resultado");
            msg.setNeutralButton("Ok", null);
            msg.setMessage(result + "").show();
        }
        else {
            Toast.makeText(MainActivity.this, "Preencha os valores", Toast.LENGTH_SHORT).show();
        }
    }
}