package com.projectbelatrix.quejapp.AlertDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.projectbelatrix.quejapp.R;

/**
 * Created by LUCAS on 30/01/2017.
 */
public class SimpleDialog extends DialogFragment {

    public SimpleDialog() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createSimpleDialog();
    }

    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.alert_dialog_login, null);

        builder.setView(v);
        Button ok_dialog_1 = (Button) v.findViewById(R.id.button_ok_dialog);

        ok_dialog_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return builder.create();
    }
}
