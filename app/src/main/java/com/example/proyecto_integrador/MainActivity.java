package com.example.proyecto_integrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2;
    EditText edt1,edt2;
    String eddt1,eddt2,usuario,contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edt1 = findViewById(R.id.edt_usuario);
        edt2 = findViewById(R.id.edt_contrasenia);
        btn1 = findViewById(R.id.btn_ingresar);
        btn2 = findViewById(R.id.btn_salir1);

        //Configurar las valoraciones
        usuario = "";
        contrasenia = "";


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Configurar string
                eddt1 = edt1.getText().toString();
                eddt2 = edt2.getText().toString();

                //Valora si coinciden 
                if(usuario.equals(eddt1)&&contrasenia.equals(eddt2)) {
                    Intent hacia_principal = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(hacia_principal);
                }
                else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });


    }
}