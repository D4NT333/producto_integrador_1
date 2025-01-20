package com.example.proyecto_integrador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {

    Button btn1_5,btn2_5;
    Spinner spine1_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1_5 = findViewById(R.id.btn_regresar_eliminar);
        btn2_5 = findViewById(R.id.btn_eliminar_eliminar);

        //Valores compartidos
        SharedPreferences sharedPreferences = getSharedPreferences("MisDatos", MODE_PRIVATE);
        final String[] finalString = {sharedPreferences.getString("final_string", "No hay datos disponibles")};


        SharedPreferences sharedPreferences_1 = getSharedPreferences("MisDatos", MODE_PRIVATE);
        final String[] edtt1_2 = {sharedPreferences_1.getString("nombre", "No hay datos disponibles")};


        //Configurar botones

        btn1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_principal = new Intent(MainActivity6.this, MainActivity2.class);
                startActivity(hacia_principal);
            }
        });

        //Configurar spinner
        spine1_5 = findViewById(R.id.spnr2_eliminar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item,new String[]{"Elimina", edtt1_2[0]});
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spine1_5.setAdapter(adapter);
        spine1_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity6.this, "Seleccionaste: " + selected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nada seleccionado

            }
        });


        btn2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtt1_2[0] = "";
                finalString[0] = "";
            }
        });

    }
}