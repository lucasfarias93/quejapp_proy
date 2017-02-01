package com.projectbelatrix.quejapp.Fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.projectbelatrix.quejapp.R;


public class Reclamo1Fragment extends Fragment {

    private Button confirm, cancel, blank;
    private EditText nombre_reclamo, motivo, hora_ocurrencia, descripcion, asistencia;

    public Reclamo1Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reclamo1, container, false);

        nombre_reclamo = (EditText) view.findViewById(R.id.editNombreForm);
        motivo = (EditText) view.findViewById(R.id.editUbicacion);
        hora_ocurrencia = (EditText) view.findViewById(R.id.editElementos);
        descripcion = (EditText) view.findViewById(R.id.editHora);
        asistencia = (EditText) view.findViewById(R.id.editValor);
        confirm = (Button) view.findViewById(R.id.button_confirm);
        cancel = (Button) view.findViewById(R.id.button_cancel);
        blank = (Button) view.findViewById(R.id.button_blank);

        Typeface custom_font1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/LatoRegular.ttf");

        nombre_reclamo.setTypeface(custom_font1);
        motivo.setTypeface(custom_font1);
        hora_ocurrencia.setTypeface(custom_font1);
        descripcion.setTypeface(custom_font1);
        asistencia.setTypeface(custom_font1);
        confirm.setTypeface(custom_font1);
        cancel.setTypeface(custom_font1);
        blank.setTypeface(custom_font1);
        //Nuevos parametros para el view del fragmento
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        //Nueva Regla: EL fragmento estara debajo del boton add_fragment
        params.addRule(RelativeLayout.BELOW, R.id.button_confirm);

        //Margenes: top:41dp
        params.setMargins(0,41,0,0);

        //Setear los parametros al view
        view.setLayoutParams(params);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        blank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre_reclamo.setText("");
                motivo.setText("");
                hora_ocurrencia.setText("");
                descripcion.setText("");
                asistencia.setText("");
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre_reclamo.setText("");
                motivo.setText("");
                descripcion.setText("");
                hora_ocurrencia.setText("");
                asistencia.setText("");
                Toast.makeText(getActivity(), "Reclamo guardado con exito", Toast.LENGTH_SHORT).show();
                getActivity().finish();

                /*DatabaseHelper helper = new DatabaseHelper(getActivity());
                Formulario form = new Formulario();
                form.setForm_nombre(nombre_reclamo.getText().toString());
                form.setMotivo_reclamo(motivo.getText().toString());
                form.setDescripcion(descripcion.getText().toString());
                form.setHora_realizacion(hora_ocurrencia.getText().toString());
                form.setAsistencia(asistencia.getText().toString());

                helper.insertFormulario(form);
                String nombre = form.getForm_nombre();
                Intent i = new Intent(getActivity(), GetFormDataActivity.class);
                i.putExtra("form_nombre", nombre);
                startActivity(i);*/

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
