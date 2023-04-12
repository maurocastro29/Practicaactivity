package com.co.practicaactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.co.practicaactivity.model.Registro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText kilowats;
    private CalendarView fecha;
    private Button enviar;
    private String fechaVisita;
    private Registro registro;
    private ArrayList<Registro> listaRegistro;
    private ListView listaView;

    private Button btnVerDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kilowats = (EditText) findViewById(R.id.edtKilowatts);
        fecha = (CalendarView) findViewById(R.id.calendarView);
        enviar = (Button) findViewById(R.id.btnEnviar);
        btnVerDatos = (Button) findViewById(R.id.btnVerDatos);
        fechaVisita = "";
        listaRegistro = new ArrayList<Registro>();




        fecha.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                fechaVisita = dayOfMonth+"/"+month+"/"+year;
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!kilowats.getText().toString().equals("")){
                    listaRegistro.add(new Registro(fechaVisita, kilowats.getText().toString()));
                    Toast.makeText(MainActivity.this, "Registro agregado con exito", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "No hay valores por agregar en el campo kilowatts", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listaString = new ArrayList<>();
                for (int i = 0; i < listaRegistro.size(); i++) {
                    listaString.add(listaRegistro.get(i).toString());
                }
                Intent intent = new Intent(MainActivity.this, DatosRegistro.class);
                intent.putStringArrayListExtra("lista", listaString);
                startActivity(intent);
            }
        });

    }
}