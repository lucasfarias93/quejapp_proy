package com.projectbelatrix.quejapp.Activities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;

import com.projectbelatrix.quejapp.R;
import com.projectbelatrix.quejapp.Fragments.Reclamo1Fragment;
import com.projectbelatrix.quejapp.Fragments.Reclamo2Fragment;
import com.projectbelatrix.quejapp.Fragments.Reclamo3Fragment;

import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import com.projectbelatrix.quejapp.R;
import com.projectbelatrix.quejapp.reclamo1;
import com.projectbelatrix.quejapp.reclamo2;
import com.projectbelatrix.quejapp.reclamo3;


public class FormularioActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FragmentManager fragmentManager = getFragmentManager();
        setContentView(R.layout.activity_formulario);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_reclamo, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case (0):
                        System.out.println("Eligio una opcion" + position);
                        break;
                    case (1):
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Reclamo1Fragment fragment = new Reclamo1Fragment();
                        transaction.replace(R.id.activityContainer, fragment);
                        transaction.commit();
                        break;
                    case (2):
                        transaction = fragmentManager.beginTransaction();
                        Reclamo2Fragment fragment2 = new Reclamo2Fragment();
                        transaction.replace(R.id.activityContainer, fragment2);
                        transaction.commit();
                        break;
                    case (3):
                        transaction = fragmentManager.beginTransaction();
                        Reclamo3Fragment fragment3 = new Reclamo3Fragment();
                        transaction.replace(R.id.activityContainer, fragment3);
                        transaction.commit();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
