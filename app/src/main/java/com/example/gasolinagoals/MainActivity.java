package com.example.gasolinagoals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool, precoGas;
    private Button Calcul;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        precoAlcool = findViewById(R.id.precoAlcool);
        precoGas = findViewById(R.id.precoGas);
        resultado = findViewById(R.id.resultado);

    }
    public void calcularpreco(View view){

        String precoAlcol = precoAlcool.getText().toString();
        String precoGs = precoGas.getText().toString();

        Boolean campoValido = this.validaCampo(precoAlcol, precoGs);
        if(campoValido){
            this.calculaMelhrPreco(precoAlcol, precoGs);
        } else{
            resultado.setText("Preencha os campos primeiro");
        }
    }
    public void calculaMelhrPreco(String pAlcool, String pGas){
// Converte valores string para números
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGas = Double.parseDouble(pGas);
        Double resulta = precoAlcool/precoGas;
        if (precoAlcool>= 0.7){
            resultado.setText("Melhor utilizar gasolina");
        } else {
            resultado.setText("Melhor utilizar Àlcool");
        }
    }

    public boolean validaCampo (String pAlcool, String pGas){
        Boolean campoValido = true;

        if(pAlcool == null || pAlcool.equals("")){
            campoValido = false;
        } else if (pGas == null || pGas.equals("")){
            campoValido = false;
        }
        return campoValido;
    }
}
