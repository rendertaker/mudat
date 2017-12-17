package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;

import com.itla.mudat.entily.Categoria;

import java.util.List;

public class CategoriaActivity extends AppCompatActivity
{

        private static final String LOG_TAG = "CategoriaActivity";
        CategoriaDbo categoriaDbo;
        EditText etNombre;
        EditText etDescripcion;
        Categoria categoria;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_categoria);

            categoriaDbo = new CategoriaDbo(this);

            etNombre = (EditText) findViewById(R.id.etNombreCategoria);
            etDescripcion = (EditText) findViewById(R.id.etDescripcionCategoria);
            llenaCategoria();


            Button btnGuardar = (Button) findViewById(R.id.btnGuardarCategoria);
            btnGuardar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view)
                {

                    if (categoria==null){
                        categoria = new Categoria();
                    }
                    categoria.setNombre(etNombre.getText().toString());
                    categoria.setDescripcion(etDescripcion.getText().toString());
                    categoriaDbo.crear(categoria);
                    Intent categorias = new Intent(CategoriaActivity.this, ListaCategoriaActivity.class);
                    startActivity(categorias);
                }
            });

            Button btnCancelar = (Button) findViewById(R.id.btnCancelarCategoria);
            btnCancelar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view)
                {

                    Intent categorias = new Intent(CategoriaActivity.this, ListaCategoriaActivity.class);
                    startActivity(categorias);
                }
            });

        }

        private void llenaCategoria()
        {
            Bundle parametros = getIntent().getExtras();
            if(parametros != null && parametros.containsKey("categoria"))
            {

                //Categoria categoria = new Categoria();
                categoria = (Categoria) getIntent().getExtras().getSerializable("categoria");
                etNombre.setText(categoria.getNombre());
                etDescripcion.setText(categoria.getDescripcion());

            }
        }

}
