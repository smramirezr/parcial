package com.sandra.arreglos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button ingresar, recordar;
    EditText usuario, passwords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        usuario = (EditText) findViewById(R.id.usuario);
        passwords = (EditText) findViewById(R.id.pass);
        ingresar = (Button) findViewById(R.id.Ingresar);
        recordar = (Button) findViewById(R.id.Recordar);

        ingresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ArrayList<String> registro = (ArrayList<String>) getIntent().getSerializableExtra("registro");
        ArrayList<String> pass = (ArrayList<String>) getIntent().getSerializableExtra("password");
        String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
        String passwords = ((EditText) findViewById(R.id.pass)).getText().toString();

        if (usuario.isEmpty() || passwords.isEmpty()) {
            Toast.makeText(Activity2.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        } else if (registro.contains(usuario) && pass.contains(passwords)) {
            Intent intent = new Intent(this, Bienvenida.class);
            startActivity(intent);
        } else {
            {
                Toast.makeText(Activity2.this, "usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void onClick2(View view) {

        ArrayList<String> registro = (ArrayList<String>) getIntent().getSerializableExtra("registro");
        String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
        ArrayList<String> pass = (ArrayList<String>) getIntent().getSerializableExtra("password");
        String pass1 = ((EditText) findViewById(R.id.pass)).getText().toString();

        if(usuario.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese su usuario", Toast.LENGTH_SHORT).show();

        }else if (registro.contains(usuario)){
            int y = 0;
            int s = 0;
            y = registro.indexOf(usuario);
            s = pass.indexOf(pass1);
            String usu=""+y;
            String clave=""+s;

            for(int z=0; z<registro.size();z++){
                if(z==y){
                    usu=(String) registro.get(z);
                    clave=(String) pass.get(z);
                }
            }
            Toast.makeText(getApplicationContext(), "la clave de\""+usu+"\"es\""+clave+"",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_SHORT).show();
        }


    }

    public void onClick3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}