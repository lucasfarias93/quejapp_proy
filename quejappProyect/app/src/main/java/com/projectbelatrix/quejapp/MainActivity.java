package com.projectbelatrix.quejapp;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

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

                Intent i = new Intent(MainActivity.this, TabsActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            String user = usr.getText().toString();
            String pass = pwd.getText().toString();

            @Override
            public void onClick(View v) {
                String password = helper.searchPassword(user);
                //  String username = helper.searchUsername (pass);

                if (pass.equals(password)) {
                    Toast mensaje = Toast.makeText(MainActivity.this, "LO LOGRASTE WACHIN!", Toast.LENGTH_LONG);
                    mensaje.show();

                } else {
                    Toast error = Toast.makeText(MainActivity.this, "Pass o usuarios Incorrectos ", Toast.LENGTH_LONG);
                    error.show();
                }
            }
        });

    }

    //  public void launchTabActivity(View v) {
    //    Intent i = new Intent(this, TabsActivity.class);
    //  startActivity(i);
    // }
}