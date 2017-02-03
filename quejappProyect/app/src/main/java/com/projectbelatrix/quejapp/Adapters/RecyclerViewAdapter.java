package com.projectbelatrix.quejapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.projectbelatrix.quejapp.Activities.OpinionesActivity;
import com.projectbelatrix.quejapp.Class.Forms;
import com.projectbelatrix.quejapp.R;

import java.util.List;

/**
 * Created by emedina on 2/2/17.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FormsViewHolder> {



    public static class FormsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nombre;
        TextView data;
        ImageView imagen;
        LinearLayout layout_tabs;

        FormsViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            data = (TextView)itemView.findViewById(R.id.data);
            imagen = (ImageView)itemView.findViewById(R.id.imagen);
            layout_tabs = (LinearLayout)itemView.findViewById(R.id.layout_items);
        }

        public void setOnClickListeners() {
            layout_tabs.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent i = new Intent(mContext, OpinionesActivity.class);
            mContext.startActivity(i);
        }
    }

    List<Forms> forms;
    private static Context mContext;
    public RecyclerViewAdapter(List<Forms> forms , Context context){
        this.forms = forms;
        this.mContext= context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public FormsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardviewrec, viewGroup, false);
        FormsViewHolder pvh = new FormsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(FormsViewHolder formsViewHolder, int i) {
        formsViewHolder.nombre.setText(forms.get(i).nombre);
        formsViewHolder.data.setText(forms.get(i).data);
        formsViewHolder.imagen.setImageResource(forms.get(i).imagen);

        formsViewHolder.setOnClickListeners();

    }

    @Override
    public int getItemCount() {
        return forms.size();
    }
}
