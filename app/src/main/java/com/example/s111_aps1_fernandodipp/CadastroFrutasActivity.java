package com.example.s111_aps1_fernandodipp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroFrutasActivity extends AppCompatActivity {
    FrutasBD frutasBD = new FrutasBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_frutas);

        imprimeListaFruta();

        Toast toast = Toast.makeText(this, "Fruta cadastrada com sucesso!", Toast.LENGTH_LONG);
        toast.show();

    }

    public Fruta imprimeListaFruta(){
        for(Fruta fruta : frutasBD.catalogoFruteira){
            return fruta;
        }
        return null;
    }
}
