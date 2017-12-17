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
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.entily.Usuario;
import com.itla.mudat.view.listadapter.UsuarioListAdapter;

import java.util.List;

public class ListaUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        UsuarioDbo usuarioDbo = new UsuarioDbo(this);
        final List<Usuario> usuarios = usuarioDbo.buscar();
        Log.i("prueba", "cantidad " + usuarios.size() );
        ListView listView =  (ListView) findViewById(R.id.lvUsuario);
        listView.setAdapter(new UsuarioListAdapter(usuarios,this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent rUsuario = new Intent(ListaUsuarioActivity.this, UsuarioActivity.class);
                Usuario u = (Usuario) adapterView.getItemAtPosition(i);
                rUsuario.putExtra("usuario", u);
                startActivity(rUsuario);
            }
        });

        Button btnAgregarUsuarios = (Button) findViewById(R.id.btnAgregarUsuarios);
        btnAgregarUsuarios.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                // Toast mensaje = Toast.makeText(MainActivity.this,"Klk lo guardaste" + txtNombre.getText(), Toast.LENGTH_LONG);
                // mensaje.show();
              //  Bundle parametros = new Bundle();
                //parametros.putString("nombre", txtNombre.getText().toString());
                Intent registraUsuario = new Intent(ListaUsuarioActivity.this, UsuarioActivity.class);

                //listaUsuario.putExtras(parametros);
                startActivity(registraUsuario);

            }
        });

    }
}
