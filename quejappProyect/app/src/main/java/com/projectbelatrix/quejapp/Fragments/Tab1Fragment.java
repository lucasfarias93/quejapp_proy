package com.projectbelatrix.quejapp.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.projectbelatrix.quejapp.Activities.DatosTecnicosActivity;
import com.projectbelatrix.quejapp.Activities.FormularioActivity;
import com.projectbelatrix.quejapp.R;

/**
 * Created by LUCAS on 23/01/2017.
 */
public class Tab1Fragment extends Fragment {
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
        hacerOtraCosa.setText("Datos tecnicos");

        formularioReclamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), FormularioActivity.class);
                startActivity(i);
            }
        });

        hacerOtraCosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DatosTecnicosActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}
