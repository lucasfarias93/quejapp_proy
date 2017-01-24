package com.projectbelatrix.quejapp;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabsActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("¿Que desea hacer?"),Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Historial de reclamos"),Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Más sobre Quejapp"),Tab3.class, null);
    }
}
