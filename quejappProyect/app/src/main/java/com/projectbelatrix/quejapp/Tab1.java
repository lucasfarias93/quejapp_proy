package com.projectbelatrix.quejapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.Normalizer;

/**
 * Created by LUCAS on 23/01/2017.
 */
public class Tab1 extends Fragment {
    private Button formularioReclamo;
    private Button hacerOtraCosa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab1, container, false);
        formularioReclamo = (Button) view.findViewById(R.id.cargarFormulario);
        hacerOtraCosa = (Button) view.findViewById(R.id.hacerOtraCosa);

        formularioReclamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(TabsActivity.class, FormularioActivity.class);
            }
        });
        return view;
    }
}
