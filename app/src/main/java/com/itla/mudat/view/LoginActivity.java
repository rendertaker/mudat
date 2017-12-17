package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.entily.Usuario;

public class LoginActivity extends AppCompatActivity {
    UsuarioDbo usuarioDbo;
    public static Usuario usuariologeado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioDbo = new UsuarioDbo(this);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText etUsuario =(EditText) findViewById(R.id.etUsuarioLogin);
                String usuario = etUsuario.getText().toString();
                EditText pass=(EditText) findViewById(R.id.etClaveLogin);
                String password = pass.getText().toString();
                Usuario u = new Usuario();
                u = usuarioDbo.login(usuario, password);
                if(u.getId() > 0)
                {

                    usuariologeado = u;
                    Intent main = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main);
                }

                else
                {
                    usuariologeado = null;
                }
            }

        });


        Button btnRegistrarse = (Button) findViewById(R.id.btnRegistararse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {

                Intent registraUsuario = new Intent(LoginActivity.this, UsuarioActivity.class);
                startActivity(registraUsuario);

            }
        });


    }
}
