package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

               // Toast mensaje = Toast.makeText(MainActivity.this,"Klk lo guardaste" + txtNombre.getText(), Toast.LENGTH_LONG);
               // mensaje.show();
                Bundle parametros = new Bundle();
                parametros.putString("nombre", txtNombre.getText().toString());
                Intent visualizar = new Intent(MainActivity.this, Visualizar.class);
                visualizar.putExtras(parametros);
                startActivity(visualizar);

            }
        });
    }


}
