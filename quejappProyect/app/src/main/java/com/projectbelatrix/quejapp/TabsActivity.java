package com.projectbelatrix.quejapp;

import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class TabsActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);


        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("¿Que desea hacer?"),Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Historial de reclamos"),Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Más sobre Quejapp"),Tab3.class, null);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return true;
    }
}
