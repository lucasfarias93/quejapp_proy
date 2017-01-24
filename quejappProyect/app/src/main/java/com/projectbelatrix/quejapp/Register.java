package com.projectbelatrix.quejapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    TextView reg,log;
    EditText user,pwd,mail,name,apell;
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

                helper.insertUser(u);
                if ((nameString +apellidoString + emailString + contraseñaString + usuarioString ).equals("")) {

                    Toast  msj =Toast.makeText(Register.this,"Ha dejado campos vacios o incorrectos",Toast.LENGTH_LONG);
                    msj.show();
                } else {
                    Intent i = new Intent(Register.this , MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}
