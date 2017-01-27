package com.projectbelatrix.quejapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TabsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,TabHost.OnTabChangeListener {

    private FragmentTabHost tabHost;
    private Toolbar toolbar;
    ViewPager viewPager;
    String user_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        Intent m = getIntent();
        user_data = m.getStringExtra("usuario");
        InitViewpager();
        InitTabHost();
           }

    private void InitTabHost() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("¿Que desea hacer?"),Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Historial de reclamos"),Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Más sobre Quejapp"),Tab3.class, null);
        tabHost.setOnTabChangedListener(this);
    }

    private void InitViewpager() {

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        List<Fragment> listFragments = new ArrayList<>();
        listFragments.add(new Tab1());
        listFragments.add(new Tab2());
        listFragments.add(new Tab3());

        MyFragmentPageAdapter myFragmentPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(),listFragments);
        viewPager.setAdapter(myFragmentPageAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.miPerfil) {
            Intent i = new Intent(TabsActivity.this, UsuarioPerfilActivity.class);
            i.putExtra("usuario", user_data);
            startActivity(i);
        }
        if (id==R.id.desloguearse) {
            Intent salida = new Intent(Intent.ACTION_MAIN);
            finish();
            Toast.makeText(this,"Se ha deslogueado con exito",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabChanged(String tabId) {
   int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int selectedItem = this.viewPager.getCurrentItem();
        tabHost.setCurrentTab(selectedItem);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int selectedItem) {
    }
}
