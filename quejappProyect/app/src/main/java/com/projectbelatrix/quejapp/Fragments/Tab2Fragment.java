package com.projectbelatrix.quejapp.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectbelatrix.quejapp.Adapters.RecyclerViewAdapter;
import com.projectbelatrix.quejapp.Class.Forms;
import com.projectbelatrix.quejapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LUCAS on 23/01/2017.
 */
public class Tab2Fragment extends Fragment {
      private List<Forms> forms;
     RecyclerView rv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_tab2, container, false);
        ui(v);

        return v;
    }

    private void ui(View v) {
        rv = (RecyclerView) v.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        forms = new ArrayList<>();
        forms.add(new Forms("SuperMercado", "De su opinion sobre Supermercados aqui", R.drawable.supermercado));
        forms.add(new Forms("Shopping o Mall", "De su opinion sobre Shoppings o Malls aqui", R.drawable.bolsashopping));
        forms.add(new Forms("Vehiculos", "De su opinion sobre Vehiculos aqui", R.drawable.auto));
        forms.add(new Forms ("Comida Rapida", "De su opinion sobre cualquier comida rapida aqui", R.drawable.comida));
        forms.add(new Forms ("Deportes", "De su opinion sobre Deportes aqui", R.drawable.sports));
        forms.add(new Forms ("Salud", "De su opinion sobre Salud aqui", R.drawable.hospital));

    }
    private void initializeAdapter(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(forms);
        rv.setAdapter(adapter);
    }
}
