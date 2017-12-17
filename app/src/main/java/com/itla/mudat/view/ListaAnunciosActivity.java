package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.entily.Anuncio;
import com.itla.mudat.view.listadapter.AnuncioListAdapter;

import java.util.List;

public class ListaAnunciosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncios);


        AnuncioDbo anuncioDbo = new AnuncioDbo(this);
        final List<Anuncio> anuncios = anuncioDbo.buscar();
        //Log.i("prueba", "cantidad " + usuarios.size() );
        ListView listView =  (ListView) findViewById(R.id.lvAnuncios);
        listView.setAdapter(new AnuncioListAdapter(anuncios,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent rAnuncio = new Intent(ListaAnunciosActivity.this, RegistroAnuncioActivity.class);
                Anuncio a = (Anuncio) adapterView.getItemAtPosition(i);
                rAnuncio.putExtra("anuncio", a);
                startActivity(rAnuncio);
            }
        });

        Button btnAgregarAnuncio = (Button) findViewById(R.id.btnAgregarAnuncio);
        btnAgregarAnuncio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {


                Intent registraUsuario = new Intent(ListaAnunciosActivity.this, RegistroAnuncioActivity.class);
                startActivity(registraUsuario);

            }
        });

    }



}
