package com.projectbelatrix.quejapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projectbelatrix.quejapp.AlertDialog.SimpleDialog;
import com.projectbelatrix.quejapp.Helpers.DatabaseHelper;
import com.projectbelatrix.quejapp.R;

public class MainActivity extends AppCompatActivity {

    EditText pwd, usr;
    TextView reg, login;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Sacamos la barra de titulo de la aplicacion y de notificaciones
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        login = (TextView) findViewById(R.id.login);
        usr = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pwd);
        reg = (TextView) findViewById(R.id.reg);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/LatoLight.ttf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/LatoRegular.ttf");
        login.setTypeface(custom_font1);
        reg.setTypeface(custom_font);
        usr.setTypeface(custom_font);
        pwd.setTypeface(custom_font);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usr.getText().toString();
                String pass = pwd.getText().toString();
                String password = helper.searchPassword(user);

                if (pass.equals(password)) {
                    usr.setText("");
                    pwd.setText("");
                    Toast.makeText(MainActivity.this, "Se inicio sesion correctamente", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, TabsActivity.class);
                    i.putExtra("usuario", user);
                    startActivity(i);
                } else {
                    new SimpleDialog().show(getFragmentManager(), "SimpleDialog");
                }
            }
        });
    }
}