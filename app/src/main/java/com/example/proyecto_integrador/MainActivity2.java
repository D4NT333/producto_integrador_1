package com.example.proyecto_integrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button btn1_1,btn2_1,btn3_1,btn4_1,btn5_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn1_1 = findViewById(R.id.btn_agregar);
        btn2_1 = findViewById(R.id.btn_mostrar);
        btn3_1 = findViewById(R.id.btn_actualizar);
        btn4_1 = findViewById(R.id.btn_eliminar);
        btn5_1 = findViewById(R.id.btn_salir2);

        //Configuracion de botones

        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_agregar = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(hacia_agregar);
            }
        });

        btn2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_mostrar = new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(hacia_mostrar);
            }
        });

        btn3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_actualizar = new Intent(MainActivity2.this,MainActivity5.class);
                startActivity(hacia_actualizar);
            }
        });


        btn4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hacia_eliminar = new Intent(MainActivity2.this,MainActivity6.class);
                startActivity(hacia_eliminar);
            }
        });

        btn5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });









    }
}