package com.projectbelatrix.quejapp.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.projectbelatrix.quejapp.R;

import org.w3c.dom.Text;

public class DatosTecnicosActivity extends AppCompatActivity {

    private TextView app_name, data, descripcion, sis_op, agradecimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_tecnicos);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/LatoRegular.ttf");

        app_name = (TextView) findViewById(R.id.text_app_name);
        data = (TextView) findViewById(R.id.textTecnique_data);
        descripcion = (TextView) findViewById(R.id.descripcion);
        sis_op = (TextView) findViewById(R.id.sistema);
        agradecimiento = (TextView) findViewById(R.id.agradecimiento);

        app_name.setTypeface(custom_font1);
        data.setTypeface(custom_font1);
        descripcion.setTypeface(custom_font1);
        sis_op.setTypeface(custom_font1);
        agradecimiento.setTypeface(custom_font1);
    }
}
