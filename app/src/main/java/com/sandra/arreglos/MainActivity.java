package com.sandra.arreglos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    ArrayList<String> registro, pass;

    Button boton_registrar;
    EditText text2, text3, text4;
    TextView text5;
    String a, b, c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registro = new ArrayList<>();
        pass = new ArrayList<>();

        text2 = (EditText) findViewById(R.id.editUsuario);
        text3 = (EditText) findViewById(R.id.editPass);
        text4 = (EditText) findViewById(R.id.editRePass);
        boton_registrar = (Button) findViewById(R.id.buttonI);
        boton_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        a = text2.getText().toString();
        b = text3.getText().toString();
        c = text4.getText().toString();

        if (a.equals("") || b.equals("") || c.equals("")) {
            Toast.makeText(MainActivity.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();

        } else if (registro.contains(a)) {
            Toast.makeText(MainActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();

        } else if (b.equals(c)) {

            registro.add(a);
            pass.add(b);

            for (int i = 0; i < registro.size(); i++) {
                Log.d(TAG, "OnCreate: usuarios: " + registro.get(i));
            }
            for (int i = 0; i < pass.size(); i++) {
                Log.d(TAG, "OnCreate: usuarios: " + pass.get(i));
            }
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("registro", registro);
            intent.putExtra("password", pass);
            Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
    }

}
}
