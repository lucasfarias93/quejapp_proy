package com.projectbelatrix.quejapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projectbelatrix.quejapp.Class.Formulario;
import com.projectbelatrix.quejapp.Helpers.DatabaseHelper;
import com.projectbelatrix.quejapp.R;

public class GetFormDataActivity extends AppCompatActivity {

    private Button getData;
    Formulario form;
    String nombre;
    DatabaseHelper helper = new DatabaseHelper(this);
    private TextView textForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_form_data);
        Intent u = getIntent();
        nombre = u.getStringExtra("form_nombre");

        textForm = (TextView) findViewById(R.id.textViewFormulario);
        getData = (Button) findViewById(R.id.buttonGet);

    }

    public void getData(View v){
        form = helper.getFormularioData(nombre);
        textForm.setText(form.getMotivo_reclamo().toString());
    }
}
