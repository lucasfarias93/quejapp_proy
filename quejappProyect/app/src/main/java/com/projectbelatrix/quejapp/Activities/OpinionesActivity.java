package com.projectbelatrix.quejapp.Activities;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.projectbelatrix.quejapp.R;

import static com.projectbelatrix.quejapp.R.styleable.Toolbar;

public class OpinionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opiniones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        int miColor = getResources().getColor(R.color.colorPrimary);
        ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{miColor});
        fab.setBackgroundTintList(csl);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OpinionesActivity.this, "Has pulsado el boton flotante", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
