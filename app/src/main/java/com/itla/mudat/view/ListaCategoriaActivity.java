package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.entily.Categoria;
import com.itla.mudat.view.listadapter.CategoriaListAdapter;

import java.util.List;

public class ListaCategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categoria);


        CategoriaDbo categoriaDbo = new CategoriaDbo(this);
        final List<Categoria> categorias = categoriaDbo.buscar();
        //Log.i("prueba", "cantidad " + usuarios.size() );
        ListView listView =  (ListView) findViewById(R.id.lvCategoria);
        listView.setAdapter(new CategoriaListAdapter(categorias,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent rCategoria = new Intent(ListaCategoriaActivity.this, CategoriaActivity.class);
                Categoria c = (Categoria) adapterView.getItemAtPosition(i);
                rCategoria.putExtra("categoria", c);
                startActivity(rCategoria);
            }
        });

        Button btnAgregarCategoria = (Button) findViewById(R.id.btnAgregarCategoria);
        btnAgregarCategoria.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                // Toast mensaje = Toast.makeText(MainActivity.this,"Klk lo guardaste" + txtNombre.getText(), Toast.LENGTH_LONG);
                // mensaje.show();
                //Bundle parametros = new Bundle();
                //parametros.putString("nombre", txtNombre.getText().toString());
                Intent registraCategoria = new Intent(ListaCategoriaActivity.this, CategoriaActivity.class);
                //listaUsuario.putExtras(parametros);
                startActivity(registraCategoria);

            }
        });

    }



}
