package com.aravind.androidexamples.Alert;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aravind.androidexamples.R;

public class AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);


        Button cButton = findViewById(R.id.c_dialog);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(1);

            }
        });


        Button dAlert = findViewById(R.id.d_alert);
        dAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                defaultAlert();
            }
        });


        Button fDialog = findViewById(R.id.f_dialog);
        fDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullScreenDialog();
            }
        });


    }

    protected void fullScreenDialog() {

        // for example, you can show a custom dialog box...
        final Dialog cDialog = new Dialog(AlertDialog.this, R.style.FullScreenDialog);
        cDialog.setContentView(R.layout.custom_dialog);
        cDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        TextView ok = cDialog.findViewById(R.id.ok);
        TextView cancel = cDialog.findViewById(R.id.cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cDialog.dismiss();


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cDialog.dismiss();


            }
        });


        cDialog.show();

    }


    public void defaultAlert() {


        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AlertDialog.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage("This Default Alert Dialog...");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });

        builder.show();


    }

    protected Dialog onCreateDialog(int id) {

        // for example, you can show a custom dialog box...
        final Dialog cDialog = new Dialog(AlertDialog.this);
        cDialog.setContentView(R.layout.custom_dialog);
        cDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        TextView ok = cDialog.findViewById(R.id.ok);
        TextView cancel = cDialog.findViewById(R.id.cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cDialog.dismiss();


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cDialog.dismiss();


            }
        });


        cDialog.show();

        return cDialog;
    }

}
