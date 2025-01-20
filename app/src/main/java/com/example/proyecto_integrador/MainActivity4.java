package com.example.proyecto_integrador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    Button btn1_3;
    Spinner spinr1_3;
    TextView txv_1_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1_3 = findViewById(R.id.btn_regresar_mostrar);
        txv_1_3 = findViewById(R.id.txv_3_mostrar);
        txv_1_3.setText("");


        //Valores compartidos
        SharedPreferences sharedPreferences = getSharedPreferences("MisDatos", MODE_PRIVATE);
        String finalString = sharedPreferences.getString("final_string", "No hay datos disponibles");



        //Configurar spinner
        spinr1_3 = findViewById(R.id.spnr_mostrar);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,R.layout.spinner_item,new String[]{"Mostrar",finalString,});
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinr1_3.setAdapter(adapter);
        spinr1_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txv_1_3.setText("");
                String selected = adapterView.getItemAtPosition(i).toString();
                if (selected.equals(finalString)) {
                    Toast.makeText(MainActivity4.this, "Seleccionaste: " + selected, Toast.LENGTH_SHORT).show();
                    txv_1_3.setText(selected);
                } else {
                    Toast.makeText(MainActivity4.this, "Seleccionaste: " + selected, Toast.LENGTH_SHORT).show();
                    txv_1_3.setText("");
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nada seleccionado
                txv_1_3.setText("");

            }
        });


        //Configurar botones

        btn1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txv_1_3.setText("");
                Intent hacia_principal = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(hacia_principal);
            }
        });

        //Configurar el spinner

    }
}