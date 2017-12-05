package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itla.mudat.view.ListaUsuarioActivity;
import com.itla.mudat.view.AnunciosActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnUsuarios = (Button) findViewById(R.id.btnUsuarios);
        btnUsuarios.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

               // Toast mensaje = Toast.makeText(MainActivity.this,"Klk lo guardaste" + txtNombre.getText(), Toast.LENGTH_LONG);
               // mensaje.show();
                Bundle parametros = new Bundle();
                //parametros.putString("nombre", txtNombre.getText().toString());
                Intent listaUsuario = new Intent(MainActivity.this, ListaUsuarioActivity.class);
                //listaUsuario.putExtras(parametros);
                startActivity(listaUsuario);

            }
        });

        Button btnAnuncios = (Button) findViewById(R.id.btnAnuncios);
        btnAnuncios.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                // Toast mensaje = Toast.makeText(MainActivity.this,"Klk lo guardaste" + txtNombre.getText(), Toast.LENGTH_LONG);
                // mensaje.show();
                Bundle parametros = new Bundle();
                //parametros.putString("nombre", txtNombre.getText().toString());
                Intent anuncios = new Intent(MainActivity.this, AnunciosActivity.class);
                anuncios.putExtras(parametros);
                startActivity(anuncios);

            }
        });

    }


    public static class Visualizar extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_visualizar);
            Bundle parametros = getIntent().getExtras();
            TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
            tvNombre.setText(parametros.getString("nombre"));
        }
    }
}
