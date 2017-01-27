package com.projectbelatrix.quejapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

    private EditText nombre, apellido, usuario, contraseña, email;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nombre = (EditText)findViewById(R.id.nombre_edit);
        apellido = (EditText)findViewById(R.id.apellido_edit);
        usuario = (EditText)findViewById(R.id.user_edit);
        contraseña = (EditText)findViewById(R.id.pwd_edit);
        email = (EditText)findViewById(R.id.mail_edit);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/LatoLight.ttf");
        contraseña.setTypeface(custom_font);
        usuario.setTypeface(custom_font);
        email.setTypeface(custom_font);
        nombre.setTypeface(custom_font);
        apellido.setTypeface(custom_font);

        actualizarDatos();
    }

    public void actualizarDatos(){
        User u = new User();
        if(nombre.getText().toString() != "")
        u.setNombre(nombre.getText().toString());
        u.setApellido(apellido.getText().toString());
        u.setUsername(usuario.getText().toString());
        u.setPassword(contraseña.getText().toString());
        u.setEmail(email.getText().toString());



    }
}
