package com.example.s111_aps1_fernandodipp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Todo: instanciar as classes antes do onCreate
    FrutasBD frutasBD = new FrutasBD();
    FrutaValidator frutaValidator = new FrutaValidator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //abaixo: adição dos meses no arraylist que alimenta os dados do spinner do mês de colheita da fruta
        frutasBD.listaMes.add("Janeiro");
        frutasBD.listaMes.add("Fevereiro");
        frutasBD.listaMes.add("Março");
        frutasBD.listaMes.add("Abril");
        frutasBD.listaMes.add("Maio");
        frutasBD.listaMes.add("Junho");
        frutasBD.listaMes.add("Julho");
        frutasBD.listaMes.add("Agosto");
        frutasBD.listaMes.add("Outubro");
        frutasBD.listaMes.add("Novembro");
        frutasBD.listaMes.add("Dezembro");

        ArrayAdapter<? extends String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, frutasBD.listaMes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinnerMesColheita);
        spinner.setAdapter(adapter);
    }

    EditText campoNomeFruta = findViewById(R.id.editTextNomeFruta);
    String nomeFrutaDigitado = campoNomeFruta.getText().toString();
    EditText campoPrecoFruta = findViewById(R.id.editTextPrecoFruta);
    String precoFrutaDigitado = campoPrecoFruta.getText().toString();
    Spinner spinnerMesColheita = findViewById(R.id.spinnerMesColheita);
    String mesFrutaSelecionado = (String) spinnerMesColheita.getSelectedItem();

    public void abreCadastrosActivity(View view) {
        Fruta fruta = new Fruta();
        fruta.nomeFruta = nomeFrutaDigitado;
        fruta.preco = precoFrutaDigitado;
        fruta.mesColheita = mesFrutaSelecionado;
        if (frutaValidator.validadorFruta(fruta)) {
            frutasBD.adicionaFruta(fruta);
            startCadastrosActivity();
        } else {
            Toast toast = Toast.makeText(this, "Nome ou Valor da Fruta inválidos!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void startCadastrosActivity() {
        Bundle sacolaParametros = new Bundle();
        sacolaParametros.putSerializable("LISTA_FRUTAS", frutasBD.catalogoFruteira);
        Intent cadastroFrutas = new Intent(this, CadastroFrutasActivity.class);
        cadastroFrutas.putExtras(sacolaParametros);
        startActivity(cadastroFrutas);
    }

}