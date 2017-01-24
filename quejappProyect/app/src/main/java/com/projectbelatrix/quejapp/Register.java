package com.projectbelatrix.quejapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    TextView reg,log;
    EditText user,pwd,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        reg = (TextView) findViewById(R.id.reg);
        log = (TextView) findViewById(R.id.log);
        user = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pwd);
        mail = (EditText) findViewById(R.id.mail);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/LatoLight.ttf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/LatoRegular.ttf");
        reg.setTypeface(custom_font1);
        pwd.setTypeface(custom_font);
        log.setTypeface(custom_font);
        user.setTypeface(custom_font);
        mail.setTypeface(custom_font);
    }
}
