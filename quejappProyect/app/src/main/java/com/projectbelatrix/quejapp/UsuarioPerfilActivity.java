package com.projectbelatrix.quejapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class UsuarioPerfilActivity extends Activity {

    private TextView actualziarDatos, cancelarActualizar, textMail, textNombre, textAppellido, textUsuario, textPassword;
    private String usr;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_perfil);

        actualziarDatos = (TextView) findViewById(R.id.actualizarData);
        cancelarActualizar = (TextView) findViewById(R.id.cancelarActualizar);
        textMail = (TextView) findViewById(R.id.mail);
        textNombre = (TextView) findViewById(R.id.nombre);
        textAppellido = (TextView) findViewById(R.id.apellido);
        textUsuario = (TextView) findViewById(R.id.user);
        textPassword = (TextView) findViewById(R.id.pwd);

        showProfileData(usr); //Esta chagar es null, ¿Como consigo la referencia al user logueado actualmente?
    }

    public void showProfileData(String usuario){
        User usuarioLogueado;
        usuarioLogueado = helper.getProfileData(usuario);
        textNombre.setText(usuarioLogueado.getNombre());
        textAppellido.setText(usuarioLogueado.getApellido());
        textMail.setText(usuarioLogueado.getEmail());
        textUsuario.setText(usuarioLogueado.getUsername());
        textPassword.setText(usuarioLogueado.getPassword());
    }

    public void llamarActualizar(View v){
        Toast.makeText(UsuarioPerfilActivity.this, "Lalala", Toast.LENGTH_SHORT).show();
    }

}
