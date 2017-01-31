package com.projectbelatrix.quejapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projectbelatrix.quejapp.Class.User;
import com.projectbelatrix.quejapp.Helpers.DatabaseHelper;
import com.projectbelatrix.quejapp.R;
import com.projectbelatrix.quejapp.utils.ValidatorClass;

public class UsuarioPerfilActivity extends Activity {

    private EditText textMail, textNombre, textApellido, textUsuario, textPassword;
    private TextView  actualziarDatos, cancelarActualizar;
    private String usr;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_perfil);
        Intent u = getIntent();
        usr = u.getStringExtra("usuario");

        actualziarDatos = (TextView) findViewById(R.id.actualizarData);
        cancelarActualizar = (TextView) findViewById(R.id.cancelarActualizar);
        textMail = (EditText) findViewById(R.id.mail);
        textNombre = (EditText) findViewById(R.id.nombre);
        textApellido = (EditText) findViewById(R.id.apellido);
        textUsuario = (EditText) findViewById(R.id.user);
        textPassword = (EditText) findViewById(R.id.pwd);

        showProfileData(usr);
    }

    public void showProfileData(String usuario){
        User usuarioLogueado;
        usuarioLogueado = helper.getProfileData(usuario);
        textNombre.setText(usuarioLogueado.getNombre());
        textApellido.setText(usuarioLogueado.getApellido());
        textMail.setText(usuarioLogueado.getEmail());
        textUsuario.setText(usuarioLogueado.getUsername());
        textPassword.setText(usuarioLogueado.getPassword());


    }

    public void llamarActualizar(View v){
        User usuario_actualizar = new User();
        usuario_actualizar.setNombre(textNombre.getText().toString());
        usuario_actualizar.setApellido(textApellido.getText().toString());
        usuario_actualizar.setUsername(textUsuario.getText().toString());
        usuario_actualizar.setPassword(textPassword.getText().toString());
        usuario_actualizar.setEmail(textMail.getText().toString());
        String usuario = textUsuario.getText().toString();
        String contraseña = textPassword.getText().toString();

        if (!ValidatorClass.validarEmail(textMail.getText().toString())) {
            Toast.makeText(UsuarioPerfilActivity.this, "El formato de email introducido no es correcto o esta vacio, intente nuevamente", Toast.LENGTH_LONG).show();
        } else if (ValidatorClass.validarEmail(textMail.getText().toString()) && ((usuario.equals("") || (contraseña).equals("")))) {
            Toast.makeText(UsuarioPerfilActivity.this, "Ha dejado el usuario o la contraseña vacios", Toast.LENGTH_LONG).show();
        } else {
            helper.onUpdate(usuario_actualizar, usr);
            helper.getProfileData(usuario_actualizar.getUsername());
            Toast.makeText(this, "Los cambios se guardaron con exito", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);

        }
    }
    public void cancelarActualizar(View v){
        finish();
    }
}
