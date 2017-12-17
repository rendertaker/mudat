package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itla.mudat.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tvusuario = (TextView) findViewById(R.id.tvUsuarioLogeado);
        tvusuario.setText("Usuario Logeado: " + LoginActivity.usuariologeado.getNombre());

        Button btnUsuarios = (Button) findViewById(R.id.btnUsuarios);
        btnUsuarios.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                Intent listaUsuario = new Intent(MainActivity.this, ListaUsuarioActivity.class);
                startActivity(listaUsuario);

            }
        });

        Button btnAnuncios = (Button) findViewById(R.id.btnAnuncios);
        btnAnuncios.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                Intent anuncios = new Intent(MainActivity.this, ListaAnunciosActivity.class);
                startActivity(anuncios);

            }
        });


        Button btnCategorias = (Button) findViewById(R.id.btnCategorias);
        btnCategorias.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                Intent categorias = new Intent(MainActivity.this, ListaCategoriaActivity.class);
                startActivity(categorias);

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
