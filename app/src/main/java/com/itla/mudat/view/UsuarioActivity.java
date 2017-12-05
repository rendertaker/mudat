package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.entily.TipoUsuario;
import com.itla.mudat.entily.Usuario;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class UsuarioActivity extends AppCompatActivity {

    private static final String LOG_TAG = "UsuarioActivity";
    UsuarioDbo usuarioDbo;
    EditText etNombre ;
    EditText etTipoUsuario;
    EditText etTelefono ;
    EditText etIdentificacion;
    EditText etEmail;
    EditText etClave;
    EditText etconfirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        usuarioDbo = new UsuarioDbo(this);

        etNombre = (EditText) findViewById(R.id.etnombre);
        etTipoUsuario = (EditText) findViewById(R.id.ettipoUsuario);
        etTelefono = (EditText) findViewById(R.id.ettelefono);
        etIdentificacion = (EditText) findViewById(R.id.etidentificacion);
        etEmail = (EditText) findViewById(R.id.etemail);
        etClave = (EditText) findViewById(R.id.etclave);
        etconfirmacion = (EditText) findViewById(R.id.etconfirmacion);
        llenaUsuario();


        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                final Usuario usuario = new Usuario();
                usuario.setNombre(etNombre.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                usuario.setTelefono(etTelefono.getText().toString());
                usuario.setIdentificacion(etIdentificacion.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                usuario.setClave(etClave.getText().toString());
                usuarioDbo.crear(usuario);

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

            Usuario usuario = new Usuario();
            usuario = (Usuario) getIntent().getExtras().getSerializable("usuario");
            etNombre.setText(usuario.getNombre());
            Toast mensaje = Toast.makeText(UsuarioActivity.this,"Usuario: " + usuario.getNombre(), Toast.LENGTH_LONG);
            mensaje.show();

        }
    }
}
