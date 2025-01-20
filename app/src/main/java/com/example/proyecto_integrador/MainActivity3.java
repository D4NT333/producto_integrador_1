package com.example.proyecto_integrador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button btn1_2,btn2_2;
    EditText edt1_2,edt2_2,edt3_2,edt4_2,edt5_2;
    TextView txv1_2;
    String edtt1_2,edtt2_2,edtt3_2,edtt4_2,edtt5_2,final_string;
    Bundle bndl1_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1_2 = findViewById(R.id.btn_regresar_agregar);
        btn2_2 = findViewById(R.id.btn_agregar_agregar);


        edt1_2 = findViewById(R.id.edt_nombre_agregar);
        edt2_2 = findViewById(R.id.edt_precio_agregar);
        edt3_2 = findViewById(R.id.edt_cantidad_agregar);
        edt4_2 = findViewById(R.id.edt_marca_agregar);
        edt5_2 = findViewById(R.id.edt_proveedor_agregar);

        txv1_2 =findViewById(R.id.txv_2_agregar);


        //Configurar los botones

        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_principal = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(hacia_principal);
            }
        });

        btn2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtt1_2 = edt1_2.getText().toString();
                edtt2_2 = edt2_2.getText().toString();
                edtt3_2 = edt3_2.getText().toString();
                edtt4_2 = edt4_2.getText().toString();
                edtt5_2 = edt5_2.getText().toString();
                Toast.makeText(MainActivity3.this, "Los datos han sido guardados", Toast.LENGTH_SHORT).show();
                txv1_2.setText(String.valueOf(edtt1_2+edtt2_2+edtt3_2+edtt4_2+edtt5_2));
                final_string = (edtt1_2+"\n"+edtt2_2+"\n"+edtt3_2+"\n"+edtt4_2+"\n"+edtt5_2);
                txv1_2.setText(String.valueOf(final_string));

                SharedPreferences sharedPreferences = getSharedPreferences("MisDatos", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("final_string", final_string);
                editor.apply();




            }
        });

    }
}