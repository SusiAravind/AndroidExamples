package com.aravind.androidexamples.Toast_SnackBar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aravind.androidexamples.R;


public class TSActivity extends AppCompatActivity {

    Button toastMessgae, snackMessage, snackbarAction, customeSnackbar;
    ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

//initialize

        toastMessgae = findViewById(R.id.toast_message);
        snackMessage = findViewById(R.id.snackbar_message);
        snackbarAction = findViewById(R.id.snackbar_message_action);
        customeSnackbar = findViewById(R.id.snackbar_custom);
        constraintLayout = findViewById(R.id.cons);


        toastMessgae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TSActivity.this, "This is toast message", Toast.LENGTH_SHORT).show();

            }
        });


        snackMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(constraintLayout, "This is snackBar Message", Snackbar.LENGTH_LONG).show();

            }
        });
        snackbarAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar sn = Snackbar.make(constraintLayout, "This is snackBar Message with Action", Snackbar.LENGTH_LONG);
                sn.setAction("Yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        return;

                    }
                }).show();


            }
        });

        customeSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar snb = Snackbar.make(constraintLayout, "This is custom snackBar Message with action", Snackbar.LENGTH_LONG);
                snb.setAction("Yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        return;
                    }
                }).show();


                View snackbarView = snb.getView();

                snackbarView.setBackgroundColor(Color.WHITE);

                TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLUE);

                TextView textView2 = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_action);
                textView2.setTextColor(Color.YELLOW);
                textView2.setPadding(5, 5, 5, 5);
                textView2.setBackgroundColor(Color.BLUE);


            }
        });

    }
}
