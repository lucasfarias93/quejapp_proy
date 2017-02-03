package com.projectbelatrix.quejapp.Fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectbelatrix.quejapp.R;

/**
 * Created by LUCAS on 23/01/2017.
 */
public class Tab3Fragment extends Fragment {

    private TextView mas_sobre_quejapp, clickeable_link;
    private String url ="http://www.google.com";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab3, container, false);
        ui(view);
        return view;
    }

    public void ui(View v) {
        mas_sobre_quejapp = (TextView) v.findViewById(R.id.text2);
        clickeable_link = (TextView) v.findViewById(R.id.text_link);
        Typeface custom_font1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/LatoRegular.ttf");
        mas_sobre_quejapp.setTypeface(custom_font1);
        clickeable_link.setTypeface(custom_font1);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        clickeable_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
