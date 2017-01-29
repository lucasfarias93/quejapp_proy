package com.projectbelatrix.quejapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projectbelatrix.quejapp.Class.User;
import com.projectbelatrix.quejapp.Helpers.DatabaseHelper;
import com.projectbelatrix.quejapp.R;
import com.projectbelatrix.quejapp.utils.ValidatorClass;


public class RegisterActivity extends AppCompatActivity {
    TextView reg, log;
    EditText user, pwd, mail, name, apell;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        reg = (TextView) findViewById(R.id.reg);
        log = (TextView) findViewById(R.id.log);
        user = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pwd);
        mail = (EditText) findViewById(R.id.mail);
        name = (EditText) findViewById(R.id.nombre);
        apell = (EditText) findViewById(R.id.apellido);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/LatoLight.ttf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/LatoRegular.ttf");
        reg.setTypeface(custom_font1);
        pwd.setTypeface(custom_font);
        log.setTypeface(custom_font);
        user.setTypeface(custom_font);
        mail.setTypeface(custom_font);
        name.setTypeface(custom_font);
        apell.setTypeface(custom_font);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String apellidoString = apell.getText().toString();
                String emailString = mail.getText().toString();
                String contraseñaString = pwd.getText().toString();
                String usuarioString = user.getText().toString();
                User u = new User();
                u.setNombre(nameString);
                u.setApellido(apellidoString);
                u.setEmail(emailString);
                u.setPassword(contraseñaString);
                u.setUsername(usuarioString);
                validarCampos(usuarioString, contraseñaString, emailString, u);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void validarCampos(String user, String contraseña, String email, User u) {
        if (!ValidatorClass.validarEmail(email)) {
            Toast.makeText(RegisterActivity.this, "El formato de email introducido no es correcto o esta vacio, intente nuevamente", Toast.LENGTH_LONG).show();
        } else if (ValidatorClass.validarEmail(email) && (contraseña + user).equals("")) {
            Toast.makeText(RegisterActivity.this, "Debe completar los campos obligatorios", Toast.LENGTH_LONG).show();
        } else if (ValidatorClass.validarEmail(email) && !((contraseña + user).equals("")) && (helper.validateUser(user))) {
            Toast.makeText(RegisterActivity.this, "El usuario ya existe, pruebe con otro nombre de usuario", Toast.LENGTH_LONG).show();
        } else {
            helper.insertUser(u);
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

}
