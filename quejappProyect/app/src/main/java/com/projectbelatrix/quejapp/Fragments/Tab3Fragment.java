package com.projectbelatrix.quejapp.Fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
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

    private TextView text_link;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab3, container, false);

        text_link = (TextView) view.findViewById(R.id.text_click);
        Typeface custom_font1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/LatoRegular.ttf");
        text_link.setTypeface(custom_font1);

        text_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        return view;
    }
}
