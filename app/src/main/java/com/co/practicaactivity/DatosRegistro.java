package com.co.practicaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.co.practicaactivity.model.Registro;

import java.util.ArrayList;

public class DatosRegistro extends AppCompatActivity {

    private ListView listaView;
    private Button volver;
    private ArrayAdapter adaptador;
    private ArrayList<String> listaRegistro = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_registro);

        listaRegistro = getIntent().getStringArrayListExtra("lista");
        volver = (Button) findViewById(R.id.btnVolver);
        listaView = (ListView) findViewById(R.id.listaVisitas);
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaRegistro);
        listaView.setAdapter(adaptador);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatosRegistro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}