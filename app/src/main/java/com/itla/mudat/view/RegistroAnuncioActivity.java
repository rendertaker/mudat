package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.entily.Anuncio;
import com.itla.mudat.entily.Categoria;
import com.itla.mudat.view.listadapter.CategoriaListAdapter;

public class RegistroAnuncioActivity extends AppCompatActivity {

    private static final String LOG_TAG = "AnuncioActivity";
    AnuncioDbo anuncioDbo;
    CategoriaDbo categoriaDbo;
    EditText etTitulo ;
    EditText etDescripcion;
    EditText etUbicacion;
    EditText etPrecio;
    Spinner spCategoria;
    Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_anuncio);


        anuncioDbo = new AnuncioDbo(this);

        categoriaDbo = new CategoriaDbo(this);
        etTitulo = (EditText) findViewById(R.id.etTituloAnuncio);
        etDescripcion = (EditText) findViewById(R.id.etDescripcionAnuncio);
        spCategoria = (Spinner) findViewById(R.id.spCategoria);
        etUbicacion = (EditText) findViewById(R.id.etUbicacion);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        spCategoria.setAdapter(new CategoriaListAdapter(categoriaDbo.buscar(), this));
        llenaAnuncio();


        Button btnGuardarAnuncio = (Button) findViewById(R.id.btnGuardarAnuncio);
        btnGuardarAnuncio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                if (anuncio==null){
                    anuncio = new Anuncio();
                }
                anuncio.setTitulo(etTitulo .getText().toString());
                anuncio.setCategoria((Categoria) spCategoria.getSelectedItem());
                anuncio.setDescripcion(etDescripcion.getText().toString());
                anuncio.setUbicacion(etUbicacion.getText().toString());
                anuncio.setPrecio(Double.parseDouble(etPrecio.getText().toString()));
                anuncio.setUsuario(LoginActivity.usuariologeado);
                anuncioDbo.crear(anuncio);

            }
        });



    }


    private void llenaAnuncio()
    {
        Bundle parametros = getIntent().getExtras();
        if(parametros != null && parametros.containsKey("anuncio"))
        {


            anuncio = (Anuncio) getIntent().getExtras().getSerializable("anuncio");
            etTitulo.setText(anuncio.getTitulo());
            etDescripcion.setText(anuncio.getDescripcion());
            etPrecio.setText(String.valueOf(anuncio.getPrecio()));
            etUbicacion.setText(anuncio.getUbicacion());
            spCategoria.setSelection(UsuarioActivity.obtenerPosicionItem(spCategoria, anuncio.getCategoria().getNombre()));

            //Toast mensaje = Toast.makeText(UsuarioActivity.this,"Usuario: " + usuario.getNombre(), Toast.LENGTH_LONG);
            //mensaje.show();

        }
    }
}
