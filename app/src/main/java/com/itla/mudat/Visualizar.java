package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Visualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);
        Bundle parametros = getIntent().getExtras();
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setText(parametros.getString("nombre"));
    }
}
