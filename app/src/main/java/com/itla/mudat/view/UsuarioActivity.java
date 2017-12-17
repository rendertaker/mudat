package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.entily.Usuario;

import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioActivity extends AppCompatActivity {

    private static final String LOG_TAG = "UsuarioActivity";
    UsuarioDbo usuarioDbo;
    EditText etNombre ;
    EditText etTelefono ;
    EditText etIdentificacion;
    EditText etEmail;
    EditText etClave;
    EditText etconfirmacion;
    Spinner spTipoUsuario;
    Usuario usuario;
    List<String> listaTipo;
    ArrayAdapter<String> adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usuario);

        usuarioDbo = new UsuarioDbo(this);

        etNombre = (EditText) findViewById(R.id.etnombre);
        etTelefono = (EditText) findViewById(R.id.ettelefono);
        etIdentificacion = (EditText) findViewById(R.id.etidentificacion);
        etEmail = (EditText) findViewById(R.id.etemail);
        etClave = (EditText) findViewById(R.id.etclave);
        etconfirmacion = (EditText) findViewById(R.id.etconfirmacion);
        spTipoUsuario = (Spinner) findViewById(R.id.spTipoUsuario);

       // spTipoUsuario.setAdapter(new UsuarioListAdapter(usuarioDbo.buscar(), this));

        listaTipo = new ArrayList<>();
        String[] tipoUsuario = {"CLIENTE", "PUBLICADOR"};

        Collections.addAll(listaTipo, tipoUsuario);
        //Paso los valores a mi adapter
        adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaTipo);
        //Linea de código secundario sirve para asignar un layout a los ítems
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Muestro los ítems en el spinner, obtenidos gracias al adapter
        spTipoUsuario.setAdapter(adapterSpinner);

        //spTipoUsuario.setAdapter(new ArrayAdapter<TipoUsuario>(this,R.layout.listatipousuariosp, R.id.tvtipoUsuariosp, TipoUsuario.values()));
        llenaUsuario();


        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                if (usuario==null){
                    usuario = new Usuario();
                }
                usuario.setNombre(etNombre.getText().toString());
                usuario.setTipoUsuario(spTipoUsuario.getSelectedItem().toString());
                usuario.setTelefono(etTelefono.getText().toString());
                usuario.setIdentificacion(etIdentificacion.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                usuario.setClave(etClave.getText().toString());
                usuario.setEstatus("1");
                usuarioDbo.crear(usuario);
                Intent listaUsuario = new Intent(UsuarioActivity.this, ListaUsuarioActivity.class);
                //listaUsuario.putExtras(parametros);
                startActivity(listaUsuario);

            }
        });


        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {
                Intent listaUsuario = new Intent(UsuarioActivity.this, ListaUsuarioActivity.class);
                startActivity(listaUsuario);

            }
        });


        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {
                List<Usuario> usuarios = usuarioDbo.buscar();
                for(Usuario u : usuarios)
                {
                    Log.i("UsuarioDbo_Buscar", u.toString());
                }
            }
        });
    }

    private void llenaUsuario()
    {
        Bundle parametros = getIntent().getExtras();
        if(parametros != null && parametros.containsKey("usuario"))
        {


            usuario = (Usuario) parametros.getSerializable("usuario");
            etNombre.setText(usuario.getNombre());
            etTelefono.setText(usuario.getTelefono());
            etIdentificacion.setText(usuario.getIdentificacion());
            etEmail.setText(usuario.getEmail());
            etClave.setText(usuario.getClave());
            spTipoUsuario.setSelection(obtenerPosicionItem(spTipoUsuario, usuario.getTipoUsuario()));

        }
    }

    public static int obtenerPosicionItem(Spinner spinner, String tipo)
    {

        int posicion = 0;
        for (int i = 0; i < spinner.getCount(); i++)
        {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(tipo))
            {
                posicion = i;
            }
        }
        return posicion;
    }


}
