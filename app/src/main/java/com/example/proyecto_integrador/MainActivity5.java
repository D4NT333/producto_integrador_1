package com.example.proyecto_integrador;

import android.content.Intent;
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

public class MainActivity5 extends AppCompatActivity {

    Button btn1_4,btn2_4;
    Spinner spiner1_4,spiner2_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1_4 = findViewById(R.id.btn_regresar_actualizar);
        btn2_4 = findViewById(R.id.btn_actualizar_actualizar);



        //Configurar botones
        btn1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_principal = new Intent(MainActivity5.this, MainActivity2.class);
                startActivity(hacia_principal);
            }
        });

        //Configurar spiners
        spiner1_4 = findViewById(R.id.spnr1_actualizar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item,new String[]{"Muestra","Soy el uriel","Webos"});
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spiner1_4.setAdapter(adapter);
        spiner1_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity5.this, "Seleccionaste: " + selected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nada seleccionado

            }
        });

        spiner2_4 = findViewById(R.id.spnr2_actualizar);
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<>(this,R.layout.spinner_item,new String[]{"Hola","Soy el uriel","Webos"});
        adapter_2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spiner2_4.setAdapter(adapter_2);
        spiner2_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity5.this, "Seleccionaste: " + selected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nada seleccionado

            }
        });


    }
}